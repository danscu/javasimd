package edu.scu.llvm.asm;

import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;

/**
 * This class converts LLVM opcode to instruction name
 */
public class InstrName {
	private static String table[];
	
	static {
		// The size needs to be updated with last value of InstType
		table = new String[InstType.unreachableInst + 1];
		
		// TODO Fill the table
		table[InstType.allocaInst] = "alloca";
		table[InstType.storeInst] = "store";
		table[InstType.callInst] = "call";
		table[InstType.loadInst] = "load";
		table[InstType.icmpInst] = "icmp";
		table[InstType.fcmpInst] = "fcmp";
		table[InstType.retInst] = "ret";
		table[InstType.brInst] = "br";
		table[InstType.phiInst] = "phi";
		table[InstType.getElePtrInst] = "getelementptr";
		table[InstType.unreachableInst] = "unreachable";
	}
	
	public static String op(int opcode) {
	    String res = table[opcode];
	    if (res == null) {
	        throw new RuntimeException("Error: opcode is not yet implemented " + opcode);
	    }
	    return res;
	}
}
