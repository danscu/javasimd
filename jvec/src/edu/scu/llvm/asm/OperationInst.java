package edu.scu.llvm.asm;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * Operation instruction.
 * 
 * conversion_op:
 * 
 *   dest = op t0 op0 to t1
 *
 */
public class OperationInst extends
		cn.edu.sjtu.jllvm.VMCore.Instructions.OperationInst {

	public OperationInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, String opStr) {
		super(dest, opcode, operands, types, opStr);		
	}

    /**
     * Generates LLVM code for binary instructions.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append(dest); sb.append(" = ");
        sb.append(getOpStr()); sb.append(' ');
        
        if (getOpcode() == InstType.converInst) {
            sb.append(types.get(0));
            sb.append(' ');
            sb.append(operands.get(0));
            sb.append(' ');
            sb.append("to ");
            sb.append(types.get(1));
        }
        
        return sb.toString();
    }	
}
