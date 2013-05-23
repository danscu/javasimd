package edu.scu.llvm.translate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Argument;
import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Module;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.Function;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;
import edu.scu.jjni.aotc.Debug;

public class FunctionConverter {
	/**
	 * The LLVM module to be analyzed.
	 */
	protected Module module;

	/**
	 * Preamble of the generated code.
	 */
	protected String preamble;

	/**
	 * Variable mapper.
	 */
	protected VariableMapper mapper;

	/**
	 * Ignored calls.
	 */
	protected List<String> ignoreCalls;

	/**
	 * Ignored function attributes.
	 */
	protected List<String> ignoreFAttr;	
	
	/**
	 * Generated functions
	 */
	protected List<Function> newFunctions;

	/**
	 * The result log of the process.
	 */
	protected StringBuffer logBuffer;

	/**
	 * The generated code.
	 */
	protected StringBuffer resultBuffer;

	/**
	 * Function names. If null, all functions are analyzed.
	 */
	protected String[] functionNames;

	/**
	 * Output functions.
	 */
	protected List<String> outputFunctionNames;
	
	/**
	 * Automatically convert vectorized methods.
	 */
	private boolean isAutoVec = false;
	
	/**
	 * Constructor.
	 * 
	 * @param _module
	 *            The module to be analyzed.
	 * @param _functionNames
	 *            List of function names to be added to the native library
	 */
	public FunctionConverter(Module _module, String[] _functionNames,
			String _preamble, VariableMapper _mapper, List<String> _ignoreCalls,
			List<String> _ignoreFAttr) {
		module = _module;
		functionNames = _functionNames;
		preamble = _preamble;
		mapper = _mapper;
		newFunctions = new LinkedList<Function>();
		ignoreCalls = _ignoreCalls;
		ignoreFAttr = _ignoreFAttr;
		
		/* 
		 * If functionNames == null, all functions are converted.
		 * 
		 * If first function name is "#autovec", then use auto vectorization feature.
		 * 
		 * Otherwise, use specified function names.
		 */
		if (functionNames != null && functionNames[0].equals("#autovec")) {
			isAutoVec = true;
			functionNames = null;
		}
	}

	/**
	 * Convert Java functions to JNI. Modifies the function in place.
	 * 
	 * @param fn
	 * @return the new function
	 */
	public Function convertFunction(Function fn) {
		String linkage = fn.linkage;
		String visibility = fn.visibility;
		String cconv = fn.cconv;
		Type returnType = fn.returnType;
		String name;
		List<Argument> arguments = new ArrayList<Argument>();
		boolean isVarargFunction = fn.isVararg;
		List<String> pAttributes = fn.pAttributes;
		List<String> fAttributes = fn.fAttributes;
		int align = fn.align;
		List<BasicBlock> basicBlocksPass1 = new LinkedList<BasicBlock>();
		List<BasicBlock> basicBlocksPass2 = new LinkedList<BasicBlock>();
		
		mapper.clear();

		// Function name conversion
		name = mapper.convertFuncName(fn.functionName, null);

		// JNI env
		Type envType = new Type(Type.StructTyID,
				"%struct.JNINativeInterface_**");
		Constant envVal = new Constant();
		envVal.setType(envType);
		envVal.setValue("%env");
		Argument env = new Argument(envType,
				new ArrayList<String>() /* attributes */, 0 /* align */, envVal);
		arguments.add(env);
		
		mapper.clearFuncArg();
		
		// Create arguments maps
		for (Argument arg : fn.arguments) {
			// Maintain function arguments in code recognition/generation context
			mapper.addFuncArg(arg.getExpr().toString());
			
			// Convert the first from class to i8*
			if (arg == fn.arguments.get(0)) {
				assert (arg.getType().isPointerType());

				// Map base class type to i8
				Type clsType = arg.getType().getSubType();
				mapper.addLocalTypeMap(clsType, TypeFactory.getInt8Type());
				Type thisType = mapper.mapType(arg.getType());
				Constant thisVal = new Constant();
				thisVal.setType(envType);
				thisVal.setValue("%thisobj");
				Argument thisArg = new Argument(thisType,
						new ArrayList<String>() /* attributes */,
						0 /* align */, thisVal);

				mapper.addVarMap(arg.getExpr(), thisVal);
				arguments.add(thisArg);
			} else {
				// Best-effort conversion for other arguments
				Type newType = mapper.mapType(arg.getType());
				if (newType == null) {
					System.out.println("Skipping function "
							+ fn.getFunctionName()
							+ ", cannot find a mapping for Java type: "
							+ arg.getType().getTypeString());
					return null;
				}

				Argument newArg = new Argument(newType,
						new ArrayList<String>() /* attributes */,
						0 /* align */, arg.getExpr());

				arguments.add(newArg);
			}
		}

		// Convert code - Pass 1 (Semantic recognizer)
		for (BasicBlock bs : fn.getBasicBlocks()) {
			List<Instruction> list = new LinkedList<Instruction>();
			list.addAll(bs.getInstructions());
			
			mapper.mapOperations(list);
			
			basicBlocksPass1.add(bs);
		}
		
		// Convert code - Pass 2 (simple type mapping)
		for (BasicBlock bs : basicBlocksPass1) {
			List<Instruction> list = new LinkedList<Instruction>();

			for (Instruction ins : bs.getInstructions()) {
				int opcode = ins.getOpcode();

				// Check ignored instructions
				if (opcode == InstType.callInst) {
					String funcName = ins.getOperand(0).toString();
					boolean ignoreIns = false;
					for (String ignoredFunc : ignoreCalls)
						if (funcName.equals(ignoredFunc)) {
							if (Debug.level >= 1) {
								System.out.println("In function "
										+ fn.getFunctionName() + ", ignored call "
										+ funcName);
							}
							ignoreIns = true;
							break;
						}
					if (ignoreIns)
						continue;
				}

				Constant dest = ins.getDest();
				List<Type> types = new ArrayList<Type>();

				// Map types
				for (Type t : ins.getTypes()) {
					Type dst = mapper.mapType(t);

					// Type change failed
					if (dst == null) {
						System.out.println("Skipping function "
								+ fn.getFunctionName()
								+ ", cannot convert local variable type: "
								+ t.getTypeString());
						return null;
					}

					types.add(dst);
				}

				// Modify types
				ins.getTypes().clear();
				ins.getTypes().addAll(types);

				// Modify operands
				for (Constant c : ins.getOperands()) {
					Constant dst = mapper.mapVariable(c);

					c.setType(dst.getType());
					c.setValue(dst.getValue());
				}

				list.add(ins);
			}

			basicBlocksPass2.add(new BasicBlock(bs.getBlockID(), list));
		}		
				
		// Function attributes
		if (ignoreFAttr != null) {
			fAttributes = new ArrayList<String>();
			for (String attr : fn.fAttributes)
				for (String iattr : ignoreFAttr)
					if (!iattr.equals(attr))
						fAttributes.add(attr);
		}
		
		return new FunctionWriter(linkage, visibility, cconv, pAttributes,
				returnType, name, arguments, isVarargFunction, fAttributes,
				align, basicBlocksPass2);
	}

	/**
	 * Process the program.
	 */
	/**
	 * @return
	 */
	public boolean process() {
		logBuffer = new StringBuffer();
		resultBuffer = new StringBuffer();

		resultBuffer.append(preamble);
		resultBuffer
				.append("; =================================================\n\n");

		newFunctions.clear();

		List<Function> listFn = null;

		// Generate list of functions to convert
		if (functionNames != null) {
			listFn = new LinkedList<Function>();			
			
			List<String> nameParts = new ArrayList<String>();
			for (Function fn : module.getFunctions()) {
				String fullname = mapper.convertFuncName(fn.getFunctionName(), nameParts);				
				for (String specifiedName : functionNames)
					// Match full JNI name or first-level method name
					if (specifiedName.equals(fullname) || (nameParts.size() > 1 &&
							specifiedName.equals(nameParts.get(1))))
						listFn.add(fn);
			}
		} else {
			listFn = module.getFunctions();
		}

		outputFunctionNames = new LinkedList<String>();
		
		// Enumerate functions
		for (Function fn : listFn) {
			Function jniFn = convertFunction(fn);
			if (jniFn != null) {
				if (!isAutoVec || isFuncVectorized(fn)) {					
					newFunctions.add(jniFn);
					resultBuffer.append(jniFn.toString());
					resultBuffer.append("\n");
					
					// Add the name of the converted function
					List<String> nameParts = new ArrayList<String>();
					mapper.convertFuncName(fn.getFunctionName(), nameParts);
					StringBuilder sb = new StringBuilder();
					
					for (int i = 1; i < nameParts.size(); i++) {
						String pname = nameParts.get(i);
						if (i != 1)
							sb.append('.');
						sb.append(pname);
					}
					
					outputFunctionNames.add(sb.toString());
				}
			}
		}

		return true;
	}

	protected boolean isFuncVectorized(Function fn) {
		for (BasicBlock b : fn.getBasicBlocks())
			for (Instruction ins : b.getInstructions())
				for (Type t : ins.getTypes())
					if (t.getTypeID() == Type.VectorTyID)
						return true;		
		return false;
	}
	
	/**
	 * Gets the log of the processing, including errors.
	 * 
	 * @return the log.
	 */
	public String getLog() {
		return logBuffer.toString();
	}

	/**
	 * Gets the execution result (generated code)
	 * 
	 * @return the generated code.
	 */
	public String getResult() {
		return resultBuffer.toString();
	}

	/**
	 * Gets the list of generated functions.
	 * @return the list of generated functions.
	 */
	public List<String> getOutputFunctionNames() {
		return outputFunctionNames;
	}		
}
