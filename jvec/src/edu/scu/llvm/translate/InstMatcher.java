package edu.scu.llvm.translate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.LocalVariable;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import edu.scu.llvm.translate.VariableMapper.Opcode;

public class InstMatcher {
	/**
	 * Define a pattern of instructions to implement an operation on a type.
	 * In the inserted instruction the dest variable names follow the pattern
	 * %R.i where i = 0, 1, 2, ..., N. It must be strictly sequential in the
	 * pattern, but it will match any variable name in the function.
	 * 
	 * The output value %R.N has the type typeOut
	 * 
	 * @author danke
	 */
	public static class OpRecognizer {
		protected Opcode op;
		protected Type typeIn;
		protected Type typeOut;
		protected List<Instruction> seq;
		protected Map<String, String> match;
		
		public OpRecognizer(Opcode op, Type typeIn, Type typeOut) {
			this.op = op;
			this.typeIn = typeIn;
			this.typeOut = typeOut;
			seq = new ArrayList<Instruction>();
			match = new HashMap<String, String>();
		}
		
		/**
		 * Use this function to generate temporary variable names for
		 * the destination of the instructions.
		 * 
		 * @param n The sequential 
		 * @return the destination variable name
		 */
		public static String getMatchName(int n) {
			return String.format("%%M.%d", n);
		}
		
		/**
		 * Use this function to generate variable names to match specific
		 * operands in the instructions
		 * @param m
		 * @return the matching variable name
		 */
		public static String getMatchName(String id) {
			return String.format("%%Ms.%s", id);
		}
		
		public void addInstruction(Instruction inst) {
			seq.add(inst);
		}
		
		public List<Instruction> getInstructions() {
			return seq;
		}
		
		public String getMatchContent(String id) {
			return match.get(id);
		}
	}
	
	/**
	 * Define a sequence of instructions for one operation.
	 * @author danke
	 */
	public static class OpGenerator {
		protected Opcode op;
		protected Type typeIn;
		protected Type typeOut;
		List<Instruction> seq;
		List<Instruction> destructor;
		
		public OpGenerator(Opcode op, Type typeIn, Type typeOut) {
			this.op = op;
			this.typeIn = typeIn;
			this.typeOut = typeOut;
			seq = new ArrayList<Instruction>();
		}
		
		/**
		 * Use this function to generate temporary variable names in the 
		 * pattern. In the actual generated code, the variable names will be
		 * automatically renamed.
		 * 
		 * @param n The sequential 
		 * @return the variable name
		 */
		public static String getTmpName(int n) {
			return String.format("%%R.%d", n);
		}
		
		public void addInstruction(Instruction inst) {
			seq.add(inst);
		}
		
		/**
		 * Use this to define operations to release resources
		 * @param inst
		 */
		public void addDestuctorInst(Instruction inst) {			
			if (destructor == null)
				destructor = new ArrayList<Instruction>();
			destructor.add(inst);
		}
	}	
	
	/**
	 * Matched variables
	 */
	Map<String,String> matchPat;
	
	public InstMatcher() {
		matchPat = new HashMap<String,String>();
	}
	
	protected boolean isWildcard(Constant constant) {
		return constant.getValue().startsWith("%M");
	}
	
	protected boolean isUnbound(Constant constant) {
		return matchPat.get(constant.getValue()) == null;
	}
	
	protected String getWildcardVal(Constant constant) {
		return matchPat.get(constant.getValue());
	}
	
	protected void bind(Constant wildcard, Constant var) {
		matchPat.put(wildcard.getValue(), var.getValue());
	}
	
	protected void unbind(Constant wildcard) {
		matchPat.remove(wildcard.getValue());
	}
	
	protected void unbindAll() {
		matchPat.clear();
	}
	
	/**
	 * Match an instruction. If patIns contains wildcard, it can match anything if
	 * it has not been bound. If it is bound, the instructions match only if they
	 * resolve to the same value.
	 * 
	 * Once an instruction is matched, the wildcard values are resolved.
	 * 
	 * @param ins The source instruction
	 * @param patIns The pattern instruction
	 * @return true or false.
	 */
	protected boolean matchInst(Instruction ins, Instruction patIns) {
		if (ins.getOpcode() != patIns.getOpcode())
			return false;
		
		// match type
		if (ins.getNumTypes() != patIns.getNumTypes())
			return false;
		
		for (int i = 0; i < ins.getNumTypes(); i++) {
			Type insType = ins.getType(i);
			Type patType = patIns.getType(i);
			if (!insType.equals(patType))
				return false;
		}
		
		// match operands
		for (int i = 0; i < ins.getNumOperands(); i++) {
			Constant insOp = ins.getOperand(i);
			Constant patOp = patIns.getOperand(i);
			
			// wildcard
			if (isWildcard(patOp) && 
					(isUnbound(patOp) || getWildcardVal(patOp).equals(insOp.getValue())))
				continue;
			
			// non-wildcard
			if (!patOp.getValue().equals(insOp.getValue()))
					return false;
		}				
		
		// match destination last
		if (!isWildcard(patIns.getDest()) && !patIns.getDest().getValue().equals(ins.getDest().getValue()))
				return false;
		if (isWildcard(patIns.getDest()) && !ins.getDest().getValue().equals(getWildcardVal(patIns.getDest())))
				return false;
		
		// bind destination
		if (isWildcard(patIns.getDest()) && isUnbound(patIns.getDest()))
			bind(patIns.getDest(), ins.getDest());		
		
		// bind operand wildcards
		for (int i = 0; i < ins.getNumOperands(); i++) {
			Constant insOp = ins.getOperand(i);
			Constant patOp = patIns.getOperand(i);
			
			if (isWildcard(patOp) && isUnbound(patOp)) {
				bind(patOp, insOp);
			}
		}		
		
		return true;
	}
	
	enum MatchResult {MISMATCH, MATCH, TOO_SHORT};
	
	protected MatchResult _match(ListIterator<Instruction> start, OpRecognizer opr) {		
		for (Instruction patIns : opr.getInstructions()) {
			if (!start.hasNext())
				return MatchResult.TOO_SHORT;
			
			Instruction ins = start.next();			
			if (!matchInst(ins, patIns))
				return MatchResult.MISMATCH;
		}
		
		return MatchResult.MATCH;
	}
	
	public boolean match(OpRecognizer opr, List<Instruction> insList) {
		matchPat.clear();
		
		ListIterator<Instruction> iit = insList.listIterator();
		while (iit.hasNext()) {			
			ListIterator<Instruction> start = insList.listIterator(iit.nextIndex());
			MatchResult res = _match(start, opr);			
			if (res == MatchResult.MATCH)
				System.out.println("Match");
			else if (res == MatchResult.TOO_SHORT)
				break;			
			iit.next();
		}
		
		return false;
	}
}
