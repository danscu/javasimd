package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class BinaryInst extends
		cn.edu.sjtu.jllvm.VMCore.Instructions.BinaryInst {

	public BinaryInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, String opStr, String nuw, String nsw, String exact) {
		super(dest, opcode, operands, types, opStr, nuw, nsw, exact);
		// TODO Auto-generated constructor stub
	}

}
