package edu.scu.jvec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Argument;
import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Module;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.Function;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

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
	 * Constructor.
	 * @param _module The module to be analyzed.
	 * @param _functionNames List of function names to be added to the native library
	 */
	public FunctionConverter(Module _module, String[] _functionNames, String _preamble,
			VariableMapper _mapper) {
		module = _module;
		functionNames = _functionNames;
		preamble = _preamble;
		mapper = _mapper;
		newFunctions = new LinkedList<Function>();
	}
	
	/**
	 * Convert Java functions to JNI. Modifies the function in place.
	 * @param src
	 * @return
	 */
	public Function convertFunction(Function src) {
		String linkage = src.linkage;
		String visibility = src.visibility;
		String cconv = src.cconv;
		Type returnType = src.returnType;
		String name = src.functionName;
		List<Argument> arguments = new ArrayList<Argument>();
		boolean isVarargFunction = src.isVararg;
		List<String> pAttributes = src.pAttributes;
		List<String> fAttributes = src.fAttributes;
		int align = src.align;
		List<BasicBlock> basicBlocks = src.blockList;	
		
		mapper.clear();
		
		// JNI env
		Type envType = new Type(Type.StructTyID, "%struct.JNINativeInterface_**");
		Constant envVal = new Constant(); 
		envVal.setType(envType);
		envVal.setValue("%env");
		Argument env = new Argument(envType,
				new ArrayList<String>() /* attributes */,
				0 /* align */,
				envVal);		
		arguments.add(env);
		
		// Create arguments maps
		for (Argument arg : src.arguments) {			
			// Convert the first from class to i8*
			if (arg == src.arguments.get(0)) {
				Type thisType = new Type(Type.PointerTyID, "i8*");
				Constant thisVal = new Constant(); 
				thisVal.setType(envType);
				thisVal.setValue("%thisobj");
				Argument thisArg = new Argument(thisType,
						new ArrayList<String>() /* attributes */,
						0 /* align */,
						thisVal);
				
				mapper.addMapping(arg, thisArg);
				arguments.add(thisArg);
			} else {
				// Best-effort conversion for other arguments
				Argument newArg = mapper.findMap(arg);
				if (newArg == null) {
					System.err.println("Cannot find a mapping for Java type: " +
							arg.getType().getTypeString());
					return null;
				}
				
				mapper.addMapping(arg, newArg);
				arguments.add(newArg);
			}
		}
		
		// TODO Convert code
		
		return new FunctionWriter(linkage, visibility, cconv, pAttributes,
				returnType, name, arguments, isVarargFunction, fAttributes, align,
				basicBlocks);
	}
	
	/**
	 * Process the program.
	 */
	public boolean process() {
		logBuffer = new StringBuffer();
		resultBuffer = new StringBuffer();		
		
		resultBuffer.append(preamble);
		resultBuffer.append("; =================================================\n\n");				
		
		newFunctions.clear();
		
		// Enumerate functions
		for (Function fn : module.getFunctions()) {
			Function jniFn = convertFunction(fn);
			if (jniFn != null) {
				newFunctions.add(jniFn);
				resultBuffer.append(jniFn.toString());
				resultBuffer.append("\n");
			}
		}
		
		return true;
	}
	
	/**
	 * Gets the log of the processing, including errors.
	 * @return the log.
	 */
	public String getLog() {
		return logBuffer.toString();
	}
	
	/**
	 * Gets the execution result (generated code)
	 * @return the generated code.
	 */
	public String getResult() {		
		return resultBuffer.toString();
	}
}
