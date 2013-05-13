package edu.scu.jvec.Instructions;

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
	}
	
	public static String op(int opcode) {		
		return table[opcode];
	}
}
