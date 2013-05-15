package edu.scu.llvm.asm;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class GetElePtrInst extends
		cn.edu.sjtu.jllvm.VMCore.Instructions.GetElePtrInst {

	public GetElePtrInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, boolean inbounds) {
		super(dest, opcode, operands, types, inbounds);
		// TODO Auto-generated constructor stub
	}

}
