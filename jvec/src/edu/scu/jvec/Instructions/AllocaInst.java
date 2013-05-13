package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * Alloca instruction
 *
 * dest = alloca type0 {, type1 op0} {, align op1}
 */

public class AllocaInst extends
		cn.edu.sjtu.jllvm.VMCore.Instructions.AllocaInst {

	public AllocaInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types) {
		super(dest, opcode, operands, types);
	}

	/**
	 * Generates LLVM code for the 'alloca' instruction.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int op = 0;
		
		sb.append(dest); sb.append(" = ");
		sb.append(InstrName.op(opcode)); sb.append(' ');
		
		sb.append(types.get(0));
		if (types.size() > 1) {
			sb.append(", ");
			sb.append(types.get(1)); sb.append(' ');
			sb.append(operands.get(op++)); sb.append(' ');
		} else {
			sb.append(' ');
		}
		
		// The remaining op is alignment
		if (operands.size() > op) {
			sb.append(", align ");
			sb.append(operands.get(op++));
		}
		
		return sb.toString();
	}		
}
