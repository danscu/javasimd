package edu.scu.llvm.asm;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * Instruction: store
 * 
 * {volatile} store t0 op0, t1 op1 {, align op2}
 *
 */
public class StoreInst extends cn.edu.sjtu.jllvm.VMCore.Instructions.StoreInst {

	public StoreInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, boolean isVolatile) {
		super(dest, opcode, operands, types, isVolatile);
	}

	/**
	 * Generates LLVM code for the 'store' instruction.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();		

		assert(types.size() == 2 && operands.size() >= 2);		
		
		if (isVolatile()) {
			sb.append("volatile");
			sb.append(' ');
		}

		sb.append(InstrName.op(opcode));
		sb.append(' ');
		sb.append(types.get(0));
		sb.append(' ');
		sb.append(operands.get(0));
		sb.append(", ");
		sb.append(types.get(1));
		sb.append(' ');
		sb.append(operands.get(1));		
		
		// The remaining op is alignment
		if (operands.size() >= 2) {
			sb.append(", ");
			sb.append("align ");
			sb.append(operands.get(2));
		}
		
		return sb.toString();
	}
}
