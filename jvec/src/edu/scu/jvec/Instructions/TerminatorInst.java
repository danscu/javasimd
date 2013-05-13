package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class TerminatorInst extends
		cn.edu.sjtu.jllvm.VMCore.Instructions.TerminatorInst {

	public TerminatorInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types) {
		super(dest, opcode, operands, types);
	}

}
