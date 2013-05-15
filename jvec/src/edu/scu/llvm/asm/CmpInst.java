package edu.scu.llvm.asm;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Operators.CompareCondition;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * Compare instructions
 * 
 * dest = icmp|fcmp cond t0 op0, op1 
 * 
 */
public class CmpInst extends cn.edu.sjtu.jllvm.VMCore.Instructions.CmpInst {

	public CmpInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, String cond) {
		super(dest, opcode, operands, types, cond);
	}

    /**
     * Generates LLVM code for binary instructions.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append(dest); sb.append(" = ");
        sb.append(InstrName.op(opcode)); sb.append(' ');        
        
        sb.append(CompareCondition.getCondStr(getCond()));
        sb.append(' ');
        
        sb.append(types.get(0));
        sb.append(' ');
        sb.append(operands.get(0));
        sb.append(", ");
        sb.append(operands.get(1));
        
        return sb.toString();
    }
}
