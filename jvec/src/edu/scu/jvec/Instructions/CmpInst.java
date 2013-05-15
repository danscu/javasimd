package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class CmpInst extends cn.edu.sjtu.jllvm.VMCore.Instructions.CmpInst {

	public CmpInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, String cond) {
		super(dest, opcode, operands, types, cond);
	}

}
