package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class LoadInst extends cn.edu.sjtu.jllvm.VMCore.Instructions.LoadInst {

	public LoadInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, boolean isVolatile) {
		super(dest, opcode, operands, types, isVolatile);
	}

}
