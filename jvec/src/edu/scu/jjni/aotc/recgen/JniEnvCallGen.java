package edu.scu.jjni.aotc.recgen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.ValueFactory;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.LocalVariable;
import cn.edu.sjtu.jllvm.VMCore.Constants.SimpleConstantValue;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.FunctionType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;
import edu.scu.jjni.aotc.LLVM2Jni;
import edu.scu.llvm.asm.InstFactory;
import edu.scu.llvm.translate.InstMatcher;
import edu.scu.llvm.translate.VariableMapper.Semcode;

public class JniEnvCallGen extends OpGenerator {
	protected Constant env_addr;
	protected int jniEnvFuncNo;
	protected boolean callOnceAtInit;
	protected FunctionType funcType;
	protected List<Type> argTypes;
	protected List<Constant> args;
	protected List<Instruction> extraInstr;
	protected boolean initCall;
	protected String resultName;
	
	public JniEnvCallGen(Semcode semc, OpRecognizer opr, Type typeIn, Type typeOut, Constant env_addr,
			int jniEnvFuncNo,
			boolean callOnceAtInit,
			FunctionType funcType, List<Type> argTypes, List<Constant> args,
			List<Instruction> extraInstr,
			String resultName) {
		super(semc, opr, typeIn, typeOut);
		this.env_addr = env_addr;
		this.jniEnvFuncNo = jniEnvFuncNo;
		this.callOnceAtInit = callOnceAtInit;
		this.funcType = funcType;
		this.argTypes = argTypes;
		this.args = args;
		this.extraInstr = extraInstr;
		this.resultName = resultName;
	}
	
	protected Constant resolve(Translator trn, Constant var) {
		if (InstMatcher.isGlobalVar(var)) {
			return trn.getVar(var.getValue(), false);
		}
		return var;
	}

	protected List<Constant> resolveAll(Translator trn,
			List<Constant> args) {
		List<Constant> res = new ArrayList<Constant>();
		for (Constant arg : args)
			res.add(resolve(trn, arg));
		return res;
	}		
	
	@Override
	public void insertInit(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start) {				
		
		String arraySetupDone = Translator.publicVarName("arraySetupDone");		
		Constant setupDone = trn.getVar(arraySetupDone, false);
		
		if (setupDone == null) {
			trn.setVar(arraySetupDone, "1");
			setupArgments(trn, insList, start);
		}		

		assert(trn.getSubrecognizerKey() != null);
		
		String jniDoneVariable = Translator.publicVarName("arraySetupDone" +
				trn.getSubrecognizerKey());
		Constant jniDone = trn.getVar(jniDoneVariable, false);		
		
		if (jniDone == null) {
			trn.setVar(jniDoneVariable, "1");
			
			if (callOnceAtInit) {
				// generate jni code at init
				insertJniCall(trn, insList, start);
			}
		}			
	}

	private void setupArgments(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start) {
		InstFactory fac = new InstFactory();

		Type i8_t = TypeFactory.getIntNType(8);
		Type i32_t = TypeFactory.getIntNType(32);
		Type i32p_t = TypeFactory.getPointerType(i32_t);

		Instruction ins;

		// The argument %env
		Constant isCopy = new LocalVariable(trn.getVar(Translator.publicVarName("argName"), true) + "_iscopy");
		this.publishVar(trn, "isCopy", isCopy.toString());

		// %env_addr = alloca %struct.JNINativeInterface_**, align 8
		ins = fac.createSimpleInst(isCopy, InstType.allocaInst,
				Arrays.asList(new Constant[] {}),
				Arrays.asList(new Type[] { i8_t }));
		addInstruction(start, ins);

		// %tab = alloca i32*
		Constant arrayTab = new LocalVariable(trn.getVar(Translator.publicVarName("argName"), true) + "_tab");
		this.publishVar(trn, "arrayTab", arrayTab.toString());
		ins = fac.createSimpleInst(arrayTab, InstType.allocaInst,
				Arrays.asList(new Constant[] {}),
				Arrays.asList(new Type[] { i32p_t }));
		addInstruction(start, ins);
	}
	
	@Override
	public void insertCleanup(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start, List<BasicBlock> extraBlocks, Constant outLabel) {
		Constant alreadySetupArray = trn.getVar(Translator.publicVarName("arrayCleanupDone"), false);
		if (alreadySetupArray == null) {		
			if (clearupArgments(trn, insList, start, extraBlocks, outLabel))
				trn.setVar(Translator.publicVarName("arrayCleanupDone"), "1");
		}
	}

	private boolean clearupArgments(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start, List<BasicBlock> extraBlocks, Constant outLabel) {
		InstFactory fac = new InstFactory();
		ValueFactory vfac = new ValueFactory();
		Instruction ins;
		
		Constant pArrayBase = trn.getVar(Translator.publicVarName("arrayBasePtr"), false);
		if (pArrayBase == null)
			return false;
		
		Constant pArrayIsCopy = trn.getVar(Translator.publicVarName("isCopy"), true);
		
		// %26 = load i8* %iscopy, align 1
		Constant iscopy = new LocalVariable(trn.getGenTmpName());		
		ins = fac.createLoadStoreInst(iscopy /* dest */, InstType.loadInst,
				Arrays.asList(new Constant[] { pArrayIsCopy,
						vfac.createConstantValue(SimpleConstantValue.intConst, "1")} /* align 1 */),
				Arrays.asList(new Type[] { LLVM2Jni.pi8_t }),
				false /* volatile */);
		addInstruction(start, ins);
		
		// %27 = icmp eq i8 %26, 1
		Constant iscopyTrue = new LocalVariable(trn.getGenTmpName());
		ins = fac.createCmpInst
				(iscopyTrue /* dest */, InstType.icmpInst,
				Arrays.asList(new Constant[] { iscopy,
						vfac.createConstantValue(SimpleConstantValue.intConst, "1")} /* align 1 */),
				Arrays.asList(new Type[] { LLVM2Jni.i8_t }),
				"eq");
		addInstruction(start, ins);
		
		// br i1 %27, label %"8" /* iscopy */, label %"9" /* !iscopy */
		Constant labelIsCopy = new LocalVariable(trn.getLabelTmpName());
		ins = fac.createSimpleInst(null, 
				InstType.brInst,
				Arrays.asList(new Constant[] { iscopyTrue,
						labelIsCopy,
						outLabel}),
				Arrays.asList(new Type[] { LLVM2Jni.i1_t }));
		addInstruction(start, ins);
		
		// Add block 1
		List<Instruction> iList = new ArrayList<Instruction>();
		ListIterator<Instruction> it = iList.listIterator();
		BasicBlock b1 = new BasicBlock(labelIsCopy.getValue(), iList);
		
		// jniEnvFuncNo for ReleaseIntArrayElements;		
		int jniEnvFuncNo = LLVM2Jni.JNIFunc_ReleaseIntArrayElements;

		FunctionType funcType = (FunctionType) TypeFactory.getFunctionType(
				Arrays.asList(new Type[] {
						TypeFactory.getVoidType() /* ret type */,
						LLVM2Jni.envTypePtrPtr, LLVM2Jni.pi8_t,
						LLVM2Jni.pi32_t, LLVM2Jni.i32_t }));				
		
		// Dereference the pointer to array base
		Constant arrayBase = new LocalVariable(trn.getGenTmpName());
		Constant arrayTab = trn.getVar(Translator.publicVarName("arrayTab"), true);
		ins = fac.createLoadStoreInst(arrayBase,
				InstType.loadInst,
				Arrays.asList(new Constant[] { arrayTab }),
				Arrays.asList(new Type[] { TypeFactory.getPointerType(LLVM2Jni.pi32_t) }),
				false /* volatile */);
		addInstruction(it, ins);
		
		// Insert release elements jni call
		insertJniCall(trn, iList, it, funcType, 
				Arrays.asList(new Constant[] { arrayBase,
						vfac.createConstantValue(SimpleConstantValue.intConst, "0") /* writeback */		
				}),
				Arrays.asList(new Type[] { LLVM2Jni.pi32_t, LLVM2Jni.i32_t }),
				jniEnvFuncNo, false/* has no retval */);

		// Add branch
		ins = fac.createSimpleInst(null,
				InstType.brInst,
				Arrays.asList(new Constant[] { outLabel }),
				Arrays.asList(new Type[] { }));
		addInstruction(it, ins);
		
		// Add to block list
		extraBlocks.add(b1);
		
		return true;
	}

	/**
	 * Create JNI call functions
	 * @param trn
	 * @param insList
	 * @param start
	 * @param argTypes2 
	 * @param args2 
	 * @param hasRet
	 * @return The return-value variable
	 */
	protected Constant insertJniCall(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start, FunctionType funcType, List<Constant> args,
			List<Type> argTypes, int funcNo, boolean hasRet) {
		
		InstFactory fac = new InstFactory();
		ValueFactory vfac = new ValueFactory();

		Type i32_t = TypeFactory.getInt32Type();
		
		Instruction ins;
		
		// %2 = load %struct.JNINativeInterface_** %0, align 8
		Constant pEnv = new LocalVariable(trn.getGenTmpName());		
		ins = fac.createLoadStoreInst(pEnv /* dest */, InstType.loadInst,
				// env_addr will be provided by associated recognizer
				Arrays.asList(new Constant[] { resolve(trn, env_addr),
						vfac.createConstantValue(SimpleConstantValue.intConst, "8")} /* align 8 */),
				Arrays.asList(new Type[] { LLVM2Jni.envTypePtrPtr }),
				false /* volatile */);
		addInstruction(start, ins);
		
		// %3 = getelementptr inbounds %struct.JNINativeInterface_* %2, i32 0, i32 <func_no>
		Constant funcAddr = new LocalVariable(trn.getGenTmpName());
		ins = fac.createGetElePtrInst(funcAddr /* dest */, InstType.getElePtrInst,
				Arrays.asList(new Constant[] { pEnv, vfac.createConstantValue(SimpleConstantValue.intConst, "0"),
						vfac.createConstantValue(SimpleConstantValue.intConst, Integer.toString(funcNo)) }),						
				Arrays.asList(new Type[] { LLVM2Jni.envTypePtr, i32_t, i32_t }),
				true /* inbounds */);
		addInstruction(start, ins);
		
		// %4 = bitcast {}** %3 to temp funcType**
		Constant ppFunc = new LocalVariable(trn.getGenTmpName());
		List<Type> tempFSubTypes = new ArrayList<Type>();
		tempFSubTypes.addAll(funcType.getSubTypes());
		tempFSubTypes.remove(1);
		tempFSubTypes.add(1, LLVM2Jni.typeNullStructPtr);
		
		Type tempFType = TypeFactory.getFunctionType(tempFSubTypes);
		Type ptempFType = TypeFactory.getPointerType(tempFType);
		Type ppTempFuncType = TypeFactory.getPointerType(ptempFType);		
		
		ins = fac.createOperationInst(ppFunc /* dest */, InstType.converInst,
				Arrays.asList(new Constant[] { funcAddr }),
				Arrays.asList(new Type[] { LLVM2Jni.typeNullStructPtrPtr, ppTempFuncType }),
				"bitcast");
		addInstruction(start, ins);
		
		// %5 = load funcType** %4, align 8
		Constant pFunc = new LocalVariable(trn.getGenTmpName());
		ins = fac.createLoadStoreInst(pFunc /* dest */, InstType.loadInst,			
				Arrays.asList(new Constant[] { ppFunc,
						vfac.createConstantValue(SimpleConstantValue.intConst, "8")} /* align 8 */),
				Arrays.asList(new Type[] { ppTempFuncType }),
				false /* volatile */);
		addInstruction(start, ins);
		
		// %6 bitcast i32 ({}*, i8*)* %5 to i32 (%struct.JNINativeInterface_**, i8*)*
		Constant pGoodFunc = new LocalVariable(trn.getGenTmpName());
		Type pGoodFuncType = TypeFactory.getPointerType(funcType);
		ins = fac.createOperationInst(pGoodFunc /* dest */, InstType.converInst,
				Arrays.asList(new Constant[] { pFunc }),
				Arrays.asList(new Type[] { ptempFType, pGoodFuncType }),
				"bitcast");
		addInstruction(start, ins);
		
		// %7 = call i32 %6(%struct.JNINativeInterface_** %0, i8* %1) nounwind
		Constant pRes = null;
		if (hasRet)
			pRes = new LocalVariable(trn.getGenTmpName());
		
		List<Constant> operands = new LinkedList<Constant>();
		Constant arrayArgName = trn.getVar(Translator.publicVarName("argName"), true);
		operands.addAll(Arrays.asList(new Constant[] { pGoodFunc, resolve(trn, env_addr), arrayArgName }));
		if (args != null)
			operands.addAll(resolveAll(trn, args));
		
		List<Type> types = new LinkedList<Type>();
		types.addAll(Arrays.asList(new Type[] { funcType.getRetType(), LLVM2Jni.envTypePtrPtr, LLVM2Jni.pi8_t }));
		if (argTypes != null)
			types.addAll(argTypes);
		
		ins = fac.createCallInst(pRes /* dest */, InstType.callInst,
				operands,
				types,
				false /* tail */,
				"", /* cconv */
				Arrays.asList(new String[] {}), /* pattr */
				Arrays.asList(new String[] { "nounwind" })/* fattr */
				);
		addInstruction(start, ins);
		
		return pRes;
	}
	
	@Override
	public void insert(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start) {		
		if (!callOnceAtInit) {
			insertJniCall(trn, insList, start);
		}
	}
	
	protected void insertJniCall(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start) {
		Constant pRes = insertJniCall(trn, insList, start, funcType, 
				args, argTypes, jniEnvFuncNo, true /* has ret */);

		// Publish the result
		publishVar(trn, resultName, pRes.toString());

		/*
		 * Generate specific code
		 */
	}
}
