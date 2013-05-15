package edu.scu.llvm.asm;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * PHI Instructions
 *
 * dest = phi t0 [ op0 , op1 ] {, [ op2 , op3 ] }*
 */
public class PHIInst extends cn.edu.sjtu.jllvm.VMCore.Instructions.PHIInst {

	public PHIInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types) {
		super(dest, opcode, operands, types);
	}

    /**
     * Generates LLVM code for binary instructions.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append(dest); sb.append(" = ");
        sb.append(InstrName.op(opcode)); sb.append(' ');
        
        sb.append(types.get(0));
        sb.append(' ');

        for (int i = 0; i < operands.size(); i+=2) {
            if (i != 0)
                sb.append(", ");            
            sb.append('[');
            sb.append(operands.get(i));
            sb.append(", ");
            sb.append(operands.get(i + 1));
            sb.append(']');
        }
        
        return sb.toString();
    }
}
