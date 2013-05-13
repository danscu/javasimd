package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class OperationInst extends
		cn.edu.sjtu.jllvm.VMCore.Instructions.OperationInst {

	public OperationInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, String opStr) {
		super(dest, opcode, operands, types, opStr);
		// TODO Auto-generated constructor stub
	}

}
