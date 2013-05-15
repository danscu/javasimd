package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * Generates the binary instruction
 * 
 * dest = op {nuw} {nsw} {exact} t0 op0, op1
 */

public class BinaryInst extends
		cn.edu.sjtu.jllvm.VMCore.Instructions.BinaryInst {

	public BinaryInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, String opStr, String nuw, String nsw, String exact) {
		super(dest, opcode, operands, types, opStr, nuw, nsw, exact);		
	}

    /**
     * Generates LLVM code for binary instructions.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append(dest); sb.append(" = ");
        sb.append(InstrName.op(opcode)); sb.append(' ');
        
        if (getNuw() != null) {
            sb.append(getNuw());
            sb.append(' ');
        }
        
        if (getNsw() != null) {
            sb.append(getNsw());
            sb.append(' ');
        }
        
        if (getExact() != null) {
            sb.append(getExact());
            sb.append(' ');
        }
        
        sb.append(types.get(0));
        sb.append(' ');
        sb.append(operands.get(0));
        sb.append(", ");
        sb.append(operands.get(1));
        
        return sb.toString();
    }	
}
