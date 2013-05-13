package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class PHIInst extends cn.edu.sjtu.jllvm.VMCore.Instructions.PHIInst {

	public PHIInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types) {
		super(dest, opcode, operands, types);
	}

}
