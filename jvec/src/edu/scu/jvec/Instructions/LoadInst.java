package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * Load instruction
 * 
 * dest = {volatile} load t0 op0 {, align op1}
 *
 */
public class LoadInst extends cn.edu.sjtu.jllvm.VMCore.Instructions.LoadInst {

	public LoadInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, boolean isVolatile) {
		super(dest, opcode, operands, types, isVolatile);
	}

    /**
     * Generates LLVM code for the 'load' instruction.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        int op = 0;
        
        sb.append(dest); sb.append(" = ");
        if (isVolatile()) {
            sb.append("volatile ");
        }
        
        sb.append(InstrName.op(opcode)); sb.append(' ');
        
        sb.append(types.get(0)); sb.append(' ');
        sb.append(operands.get(op++));
               
        // The remaining op is alignment
        if (operands.size() > op) {
            sb.append(", align ");
            sb.append(operands.get(op++));
        }
        
        return sb.toString();
    }	
}
