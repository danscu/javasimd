package edu.scu.llvm.asm;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * Get element instruction.
 * 
 * dest = 'getelementptr' {inbounds} t0 op0 (, ti opi)+
 */
public class GetElePtrInst extends
		cn.edu.sjtu.jllvm.VMCore.Instructions.GetElePtrInst {

	public GetElePtrInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, boolean inbounds) {
		super(dest, opcode, operands, types, inbounds);
	}

    /**
     * Generates LLVM code for getelementptr instruction
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        if (dest != null) {
            sb.append(dest); sb.append(" = ");
        }
        
        sb.append(InstrName.op(opcode));
        sb.append(' ');
        
        if (inbounds)
            sb.append("inbounds ");        
        
        sb.append(types.get(0));
        sb.append(" ");
        sb.append(operands.get(0));
        
        for (int i = 1; i < types.size(); i++) {
        	sb.append(", ");            
            sb.append(types.get(i));
            sb.append(" ");
            sb.append(operands.get(i));
        }

        return sb.toString();
    }	
}
