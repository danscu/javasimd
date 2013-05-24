package edu.scu.jjni.aotc.recgen;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import cn.edu.sjtu.jllvm.VMCore.ValueFactory;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.LocalVariable;
import cn.edu.sjtu.jllvm.VMCore.Constants.SimpleConstantValue;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;
import edu.scu.jjni.aotc.LLVM2Jni;
import edu.scu.llvm.asm.InstFactory;
import edu.scu.llvm.translate.VariableMapper.Semcode;

public class JniEnvSetupGen extends OpGenerator {

	public JniEnvSetupGen(Semcode semc, OpRecognizer opr, Constant envArg) {
		super(semc, opr, null, null);
	}

	/**
	 * This generates allocation code for the jni env argument
	 */
	@Override
	public List<Instruction> insertInit(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start) {
		InstFactory fac = new InstFactory();
		ValueFactory vfac = new ValueFactory();
		
		Instruction ins;
		
		// The argument %env
		Constant envArg = trn.getVar(Translator.getPublicVar("envArg"), true);
		
		// %env_addr = alloca %struct.JNINativeInterface_**, align 8
		Constant env_addr = new LocalVariable("%env_addr");
		ins = fac.createSimpleInst(env_addr, InstType.allocaInst,
				/* align 8 */
				Arrays.asList(new Constant[] { vfac.createConstantValue(SimpleConstantValue.intConst, "8") }),
				Arrays.asList(new Type[] { LLVM2Jni.envTypePtrPtr }));
		addInstruction(start, ins);
		
		// store %struct.JNINativeInterface_** %env, %struct.JNINativeInterface_*** %env_addr, align 1
		ins = fac.createLoadStoreInst(env_addr, InstType.storeInst,
				/* align 8 */
				Arrays.asList(new Constant[] { envArg, env_addr, vfac.createConstantValue(SimpleConstantValue.intConst, "1") }),
				Arrays.asList(new Type[] { LLVM2Jni.envTypePtrPtr, TypeFactory.getPointerType(LLVM2Jni.envTypePtrPtr) }),
				false /* volatile */);		
		addInstruction(start, ins);
		
		// %0 = load %struct.JNINativeInterface_*** %env_addr, align 8
		Constant local_env = new LocalVariable("%local_env");
		ins = fac.createLoadStoreInst(local_env, InstType.loadInst,
				/* align 8 */
				Arrays.asList(new Constant[] { env_addr, vfac.createConstantValue(SimpleConstantValue.intConst, "8") }),
				Arrays.asList(new Type[] { TypeFactory.getPointerType(LLVM2Jni.envTypePtrPtr) }),
				false /* volatile */);
		addInstruction(start, ins);
		
		// Publish the local env
		publishVar(trn, "localEnv", local_env.toString());
	
		return insList;
	}
}
