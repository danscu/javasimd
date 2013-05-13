package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class CallInst extends cn.edu.sjtu.jllvm.VMCore.Instructions.CallInst {

	public CallInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, boolean tail, String cconv,
			List<String> pAttributes, List<String> fAttributes) {
		super(dest, opcode, operands, types, tail, cconv, pAttributes, fAttributes);
	}

}
