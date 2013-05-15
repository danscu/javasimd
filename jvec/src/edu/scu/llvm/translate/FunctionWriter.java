package edu.scu.llvm.translate;

import java.util.List;

import cn.edu.sjtu.jllvm.VMCore.Argument;
import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Constants.Function;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class FunctionWriter extends Function {	
	public FunctionWriter(String linkage, String visibility, String cconv,
			List<String> pAttributes, Type returnType, String name,
			List<Argument> arguments, boolean isVarargFunction,
			List<String> fAttributes, int align, List<BasicBlock> basicBlocks) {
		super(linkage, visibility, cconv, pAttributes, returnType, name, arguments,
				isVarargFunction, fAttributes, align, basicBlocks);
	}

	/**
	 * Generates LLVM code for the function.
	 */
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		
		sb.append("define"); sb.append(" ");
		sb.append(returnType); sb.append(" ");
		sb.append("@"); sb.append(functionName);
		
		sb.append("(");
		for (Argument arg : arguments) {
			if (arg != arguments.get(0))
				sb.append(", ");
			sb.append(arg.toString());
		}
		sb.append(")");
		
		for (String attr : fAttributes) {
			sb.append(" ");
			sb.append(attr);
		}
		
		sb.append(" ");
		sb.append("{\n");
		
		for (BasicBlock bb : blockList) {
			sb.append(bb.getBlockID());
			sb.append(":\n");
			
			for (Instruction ins : bb.getInstructions()) {
				sb.append(ins);
				sb.append("\n");
			}
		}
		
		sb.append("}\n");
		
		return sb.toString();
	}	
}
