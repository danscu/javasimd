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
import edu.scu.jjni.aotc.Debug;
import edu.scu.jjni.aotc.recgen.OpGenerator;
import edu.scu.jjni.aotc.recgen.OpRecognizer;
import edu.scu.jjni.aotc.recgen.Translator;

public class InstMatcher {
	/**
	 * Matched variables
	 */
	Map<String, String> matchPat;
	
	/**
	 * Matched types
	 */	
	Map<String, Type> matchType;

	public InstMatcher() {
	}

	protected boolean isGlobalVar(Constant constant) {
		if (constant == null)
			return false;
		return constant.getValue().startsWith("@");
	}
	
	protected boolean isWildcard(Constant constant) {
		if (constant == null)
			return false;
		return constant.getValue().startsWith("%M") ||
				constant.getValue().startsWith("@%M");
	}

	protected boolean isArgWildcard(Constant constant) {
		return constant.getValue().startsWith("%MA") ||
				constant.getValue().startsWith("@%MA");
	}
	
	private boolean isWildcard(Type insType) {
		return insType instanceof WildcardType;
	}
	
	protected boolean isUnbound(Constant constant) {
		return matchPat.get(constant.getValue()) == null;
	}

	protected boolean isUnbound(Type insType) {
		return matchType.get(insType.getTypeString()) == null;
	}
	
	protected String getWildcardVal(Constant constant) {
		return matchPat.get(constant.getValue());
	}
	
	protected Type getWildcardVal(Type insType) {
		Type t = matchType.get(insType.getTypeString());
		return t;
	}

	protected void bind(Constant wildcard, Constant var) {
		matchPat.put(wildcard.getValue(), var.getValue());
	}
	
	protected void bind(Type wildcard, Type insType) {
		matchType.put(wildcard.getTypeString(), insType);
	}

	protected void unbind(Constant wildcard) {
		matchPat.remove(wildcard.getValue());
	}

	protected void unbind(Type wildcard) {
		matchType.put(wildcard.getTypeString(), null);
	}
	
	protected void unbindAll() {
		matchPat.clear();
		matchType.clear();
	}

	/**
	 * Match an instruction. If patIns contains wildcard, it can match anything
	 * if it has not been bound. If it is bound, the instructions match only if
	 * they resolve to the same value.
	 * 
	 * Once an instruction is matched, the wildcard values are resolved.
	 * 
	 * @param ins
	 *            The source instruction
	 * @param patIns
	 *            The pattern instruction
	 * @return true or false.
	 */
	protected boolean matchInst(Translator trn, Instruction ins, Instruction patIns) {
		if (ins.getOpcode() != patIns.getOpcode())
			return false;

		//// match type
		if (ins.getNumTypes() != patIns.getNumTypes())
			return false;
		
		List<Type> boundTypes = new ArrayList<Type>();
		boolean success = false;
		
		do {
			boolean typeMatchSuccess = true;
			for (int i = 0; i < ins.getNumTypes(); i++) {
				Type insType = ins.getType(i);
				Type patType = patIns.getType(i);
				
				// is pointer, scale down to base type
				while (patType.isPointerType() && insType.isPointerType()) {
					patType = patType.getSubType();
					insType = insType.getSubType();
				}			
	
				if (insType.equals(patType))
					continue;			
				
				// wildcard
				if (isWildcard(patType) &&
						( isUnbound(patType) || getWildcardVal(patType).equals(insType))) {
					// bind
					if (isUnbound(patType)) {
						boundTypes.add(patType); // for backtrack
						bind(patType, insType);
					}
					continue;
				}		
				
				// non-wildcard
				if (!patType.equals(insType)) {
					typeMatchSuccess = false;
					break;
				}
			}
	
			if (!typeMatchSuccess)
				break;
			
			// match operands
			if (ins.getOperands().size() < patIns.getOperands().size())
				break;
			
			boolean operandSucc = true;
			
			for (int i = 0; i < patIns.getNumOperands(); i++) {
				Constant insOp = ins.getOperand(i);
				Constant patOp = patIns.getOperand(i);
	
				// global var
				if (isGlobalVar(patOp)) {
					Constant varVal = trn.getVar(patOp.toString(), false);
					if (varVal != null)
						bind(patOp, varVal);
					else {
						operandSucc = false;
						break;
					}
				}
				
				// wildcard
				if (isWildcard(patOp)
						&& (isUnbound(patOp) || getWildcardVal(patOp).equals(
								insOp.getValue())))
					continue;
	
				// non-wildcard
				if (!patOp.getValue().equals(insOp.getValue())) {
					operandSucc = false;
					break;
				}
			}
	
			if (!operandSucc)
				break;
			
			// match destination		
			if (patIns.getDest() == null) {
				if (ins.getDest() != null)
					break;
			}
			else {
				if (!isWildcard(patIns.getDest())
						&& !patIns.getDest().getValue()
								.equals(ins.getDest().getValue()))
					break;
			}
	
			// If pat is not wildcard or unbound, and the value mismatches, then fail
			if (patIns.getDest() != null && !isUnbound(patIns.getDest())
					&& !ins.getDest().getValue()
							.equals(getWildcardVal(patIns.getDest())))
				break;
	
			// check argument binds
			operandSucc = true;
			for (int i = 0; i < patIns.getNumOperands(); i++) {
				Constant insOp = ins.getOperand(i);
				Constant patOp = patIns.getOperand(i);
	
				if (isArgWildcard(patOp) && !trn.isFuncArg(insOp.toString())) {
					operandSucc = false;
					break;
				}
			}
			
			if (!operandSucc)
				break;
			
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
			
			success = true;
			
		} while (false);

		if (!success)
			for (Type t : boundTypes)
				unbind(t);
		
		return success;
	}

	enum MatchResult {
		MISMATCH, MATCH, TOO_SHORT
	};

	protected MatchResult _match(Translator trn, ListIterator<Instruction> start,
			OpRecognizer opr) {
		for (Instruction patIns : opr.getInstructions()) {
			if (!start.hasNext())
				return MatchResult.TOO_SHORT;

			Instruction ins = start.next();
			if (!matchInst(trn, ins, patIns))
				return MatchResult.MISMATCH;
		}

		return MatchResult.MATCH;
	}

	public boolean matchAndModify(Translator trn, List<Instruction> insList) {
		OpRecognizer opr = trn.getOpr();
		OpGenerator opg = trn.getOpg();
		
		matchPat = opr.getMatchMap();
		matchPat.clear();
		
		matchType = new HashMap<String,Type>();

		boolean changed;
		do {
			changed = false;
			ListIterator<Instruction> iit = insList.listIterator();
			while (iit.hasNext()) {
				ListIterator<Instruction> start = insList.listIterator(iit.nextIndex());				
				MatchResult res = _match(trn, start, opr);
				
				if (res == MatchResult.TOO_SHORT)
					break;				
				
				if (res == MatchResult.MATCH) {
					if (Debug.level >= 2)
						System.out.println("Match " + opr.getSemc());
					
					/* Recognzier can publish matched vars to environment */
					opr.publishVars(trn);
					
					if (opg != null) {
						changed = true;
						insList = modifyCode(insList, iit, trn);						
					}
					
					break;
				}
				iit.next();
			}
		} while (changed);

		return false;
	}

	/**
	 * Modify the code using the code generator <code>opg</code> at the
	 * <code>start</code> location of the <code>insList</code>.
	 * 
	 * @param start
	 *            Start iterator of the section to be modified.
	 * @param opg
	 *            Code generator.
	 * @return The modified instructions.
	 */
	private List<Instruction> modifyCode(List<Instruction> insList,
			ListIterator<Instruction> start, Translator trn) {		
		return trn.modify(insList, start);
	}
}
