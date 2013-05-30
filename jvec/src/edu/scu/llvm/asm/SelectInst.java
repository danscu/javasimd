package edu.scu.llvm.asm;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * Operation instruction.
 * 
 * select_op:
 * 
 *   dest = select t0 op0, t1 op1, t2 op2
 *
 */
public class SelectInst extends
		cn.edu.sjtu.jllvm.VMCore.Instructions.SelectInst {
	
	public SelectInst(Constant dest, int opcode, List<Constant> operands,
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
        sb.append("select"); sb.append(' ');
              
        sb.append(types.get(0));
        sb.append(' ');
        sb.append(operands.get(0));          
        
        sb.append(", ");
        sb.append(types.get(1));
        sb.append(' ');
        sb.append(operands.get(1));

        sb.append(", ");
        sb.append(types.get(2));
        sb.append(' ');
        sb.append(operands.get(2));        
        
        return sb.toString();
    }
}
