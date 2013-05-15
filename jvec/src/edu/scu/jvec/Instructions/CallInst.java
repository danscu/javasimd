package edu.scu.jvec.Instructions;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

/**
 * Call instruction
 *
 *  {dest = } {tail} call {cc | fastcc | coldcc | cc#} {pattr} type name (arglist) {unnamed_addr} {fattr}
 *  
 */
public class CallInst extends cn.edu.sjtu.jllvm.VMCore.Instructions.CallInst {

	public CallInst(Constant dest, int opcode, List<Constant> operands,
			List<Type> types, boolean tail, String cconv,
			List<String> pAttributes, List<String> fAttributes) {
		super(dest, opcode, operands, types, tail, cconv, pAttributes, fAttributes);
	}

    /**
     * Generates LLVM code for binary instructions.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        if (dest != null) {
            sb.append(dest); sb.append(" = ");
        }
        
        if (this.isTail())
            sb.append("tail ");
        
        sb.append(InstrName.op(opcode));
        sb.append(' ');
        
        if (getCconv() != null) {
            sb.append(getCconv());
            sb.append(' ');
        }
        
        for (String s : getpAttributes()) {
            sb.append(s);
            sb.append(' ');
        }
        
        sb.append(types.get(0));
        sb.append(" ");
        sb.append(operands.get(0));
        
        sb.append('(');        
                
        boolean first = true;
        for (int i = 1; i < types.size(); i++) {
            if (!first)
                sb.append(", ");
            else
                first = false;
            sb.append(types.get(i));
            sb.append(" ");
            sb.append(operands.get(i));
        }
        
        // TODO varadic function, append(", ...");
        
        sb.append(')');

        for (String s : getfAttributes()) {
            sb.append(' ');
            sb.append(s);
        }
        
        return sb.toString();
    }	
}
