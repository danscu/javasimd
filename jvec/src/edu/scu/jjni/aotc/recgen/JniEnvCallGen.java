package edu.scu.jjni.aotc.recgen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import cn.edu.sjtu.jllvm.VMCore.ValueFactory;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.LocalVariable;
import cn.edu.sjtu.jllvm.VMCore.Constants.SimpleConstantValue;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.FunctionType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;
import edu.scu.llvm.asm.InstFactory;
import edu.scu.jjni.aotc.LLVM2Jni;
import edu.scu.llvm.translate.InstMatcher;
import edu.scu.llvm.translate.VariableMapper.Semcode;

public class JniEnvCallGen extends OpGenerator {
	protected Constant env_addr;
	protected int jniEnvFuncNo;
	protected FunctionType funcType;
	protected List<Type> argTypes;
	protected List<Constant> args;
	
	public JniEnvCallGen(Semcode semc, OpRecognizer opr, Type typeIn, Type typeOut, Constant env_addr,
			int jniEnvFuncNo, FunctionType funcType, List<Type> argTypes, List<Constant> args) {
		super(semc, opr, typeIn, typeOut);
		this.env_addr = env_addr;
		this.jniEnvFuncNo = jniEnvFuncNo;
		this.funcType = funcType;
		this.argTypes = argTypes;
		this.args = args;
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
	public List<Instruction> insertInit(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start) {				

		Constant alreadySetupArray = trn.getVar(Translator.getPublicVar("arraySetupDone"), false);
		if (alreadySetupArray == null) {
			trn.setVar(Translator.getPublicVar("arraySetupDone"), "1");
			setupArgments(trn, insList, start);
		}
		
		return insList;
	}

	private void setupArgments(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start) {
		InstFactory fac = new InstFactory();

		Type i8_t = TypeFactory.getIntNType(8);
		Type i32_t = TypeFactory.getIntNType(32);
		Type i32p_t = TypeFactory.getPointerType(i32_t);

		Instruction ins;

		// The argument %env
		Constant isCopy = new LocalVariable(trn.getVar(Translator.getPublicVar("argName"), true) + "_iscopy");
		this.publishVar(trn, "isCopy", isCopy.toString());

		// %env_addr = alloca %struct.JNINativeInterface_**, align 8
		ins = fac.createSimpleInst(isCopy, InstType.allocaInst,
				Arrays.asList(new Constant[] {}),
				Arrays.asList(new Type[] { i8_t }));
		addInstruction(start, ins);

		// %tab = alloca i32*
		Constant arrayTab = new LocalVariable(trn.getVar(Translator.getPublicVar("argName"), true) + "_tab");
		this.publishVar(trn, "arrayTab", isCopy.toString());
		ins = fac.createSimpleInst(arrayTab, InstType.allocaInst,
				Arrays.asList(new Constant[] {}),
				Arrays.asList(new Type[] { i32p_t }));
		addInstruction(start, ins);
	}	
	
	@Override
	public List<Instruction> insert(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start) {
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
						vfac.createConstantValue(SimpleConstantValue.intConst, Integer.toString(jniEnvFuncNo)) }),						
				Arrays.asList(new Type[] { LLVM2Jni.envTypePtr, i32_t, i32_t }),
				true /* inbounds */);
		addInstruction(start, ins);
		
		// %4 = bitcast {}** %3 to funcType**
		Constant ppFunc = new LocalVariable(trn.getGenTmpName());
		Type ppFuncType = TypeFactory.getPointerType(TypeFactory.getPointerType(funcType));
		ins = fac.createOperationInst(ppFunc /* dest */, InstType.converInst,
				Arrays.asList(new Constant[] { funcAddr }),
				Arrays.asList(new Type[] { LLVM2Jni.typeNullStructPtrPtr, ppFuncType }),
				"bitcast");
		addInstruction(start, ins);
		
		// %5 = load funcType** %4, align 8
		Constant pFunc = new LocalVariable(trn.getGenTmpName());
		ins = fac.createLoadStoreInst(pFunc /* dest */, InstType.loadInst,			
				Arrays.asList(new Constant[] { ppFunc,
						vfac.createConstantValue(SimpleConstantValue.intConst, "8")} /* align 8 */),
				Arrays.asList(new Type[] { ppFuncType }),
				false /* volatile */);
		addInstruction(start, ins);
		
		// %7 = call i32 %6(%struct.JNINativeInterface_** %0, i8* %1) nounwind
		Constant pRes = new LocalVariable(trn.getGenTmpName());
		
		List<Constant> operands = new LinkedList<Constant>();
		operands.addAll(Arrays.asList(new Constant[] { ppFunc, resolve(trn, env_addr) }));
		if (args != null)
			operands.addAll(resolveAll(trn, args));
		
		List<Type> types = new LinkedList<Type>();
		types.addAll(Arrays.asList(new Type[] { funcType.getRetType(), LLVM2Jni.envTypePtrPtr }));
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
		
		return insList;
	}
}
