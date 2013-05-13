package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class SelectInst extends
		cn.edu.sjtu.jllvm.VMCore.Instructions.SelectInst {

	public SelectInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types) {
		super(dest, opcode, operands, types);
		// TODO Auto-generated constructor stub
	}

}
