package edu.scu.llvm.translate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.LocalVariable;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import edu.scu.jjni.aotc.Debug;
import edu.scu.jjni.aotc.recgen.OpGenerator;
import edu.scu.jjni.aotc.recgen.OpRecognizer;
import edu.scu.jjni.aotc.recgen.Translator;
import edu.scu.llvm.translate.VariableMapper.Semcode;

/**
 * This class matches instructions against defined patterns 
 * @author danke
 */
public class InstMatcher {
	public InstMatcher() {
	}

	public static boolean isGlobalVar(Constant constant) {
		if (constant == null)
			return false;
		return constant.getValue().startsWith("@");
	}

	/**
	 * Checks if a variable is a wildcard
	 * @param constant The variable.
	 * @return true if the variable is a wildcard.
	 */
	public static boolean isWildcard(Constant constant) {
		if (constant == null)
			return false;
		return constant.getValue().startsWith("%M") ||
				constant.getValue().startsWith("@%M");
	}
	
	/**
	 * Checks if a variable is a wildcard that matches only
	 * function arguments.
	 * @param constant
	 * @return true if it is wildcard and matches only function arguments.
	 */
	public static boolean isArgWildcard(Constant constant) {
		return constant.getValue().startsWith("%MA") ||
				constant.getValue().startsWith("@%MA");
	}
	
	/**
	 * Checks if a type is a wildcard.
	 * @param insType
	 * @return true if wildcard.
	 */
	public boolean isWildcard(Type insType) {
		return insType instanceof WildcardType;
	}
	
	protected boolean isUnbound(OpRecognizer opr, Constant constant) {
		return opr.getMatchMap().get(constant.getValue()) == null;
	}

	protected boolean isUnbound(OpRecognizer opr, Type insType) {
		return opr.getMatchMap().get(insType.getTypeString()) == null;
	}
	
	protected String getWildcardVal(OpRecognizer opr, Constant constant) {
		return opr.getMatchMap().get(constant.getValue());
	}
	
	protected Type getWildcardVal(OpRecognizer opr, Type insType) {
		Type t = opr.getTypeMatchMap().get(insType.getTypeString());
		return t;
	}

	protected void bind(OpRecognizer opr, Constant wildcard, Constant var) {
		opr.getMatchMap().put(wildcard.getValue(), var.getValue());
	}
	
	protected void bind(OpRecognizer opr, Type wildcard, Type insType) {
		opr.getTypeMatchMap().put(wildcard.getTypeString(), insType);
	}

	protected void unbind(OpRecognizer opr, Constant wildcard) {
		opr.getMatchMap().remove(wildcard.getValue());
	}

	protected void unbind(OpRecognizer opr, Type wildcard) {
		opr.getTypeMatchMap().put(wildcard.getTypeString(), null);
	}
	
	protected void unbindAll(OpRecognizer opr) {
		opr.getMatchMap().clear();
		opr.getTypeMatchMap().clear();
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
		
		OpRecognizer opr = trn.getOpr(); 
		
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
						( isUnbound(opr, patType) || getWildcardVal(opr, patType).equals(insType))) {
					// bind
					if (isUnbound(opr, patType)) {
						boundTypes.add(patType); // for backtrack
						bind(opr, patType, insType);
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
						bind(opr, patOp, varVal);
					else {
						operandSucc = false;
						break;
					}
				}
				
				// wildcard
				if (isWildcard(patOp)
						&& (isUnbound(opr, patOp) || getWildcardVal(opr, patOp).equals(
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
			if (patIns.getDest() != null && !isUnbound(opr, patIns.getDest())
					&& !ins.getDest().getValue()
							.equals(getWildcardVal(opr, patIns.getDest())))
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
			if (isWildcard(patIns.getDest()) && isUnbound(opr, patIns.getDest()))
				bind(opr, patIns.getDest(), ins.getDest());
	
			// bind operand wildcards
			for (int i = 0; i < ins.getNumOperands(); i++) {
				Constant insOp = ins.getOperand(i);
				Constant patOp = patIns.getOperand(i);
	
				if (isWildcard(patOp) && isUnbound(opr, patOp)) {
					bind(opr, patOp, insOp);
				}
			}
			
			success = true;
			
		} while (false);

		if (!success)
			for (Type t : boundTypes)
				unbind(opr, t);
		
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

	/*
	 * Returns true if modified
	 */
	public boolean matchAndModify(VariableMapper mapper, Translator trn, 
			List<Instruction> insList, BasicBlock initBlock,
			List<BasicBlock> bbs, BasicBlock cleanupBlock,
			List<BasicBlock> cleanupExtra, Constant cleanupOutLabel,
			boolean clearMatch) {
		OpRecognizer opr = trn.getOpr();
		OpGenerator opg = trn.getOpg();
		
		if (clearMatch) {
			opr.getMatchMap().clear();
			opr.getTypeMatchMap().clear();
		}

		boolean changed;
		int instructAfterMatch = 0;
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
						System.out.println("Match " + opr.getSemc() + " " + opr.getMatchMap().toString());
					
					/* Recognzier can publish matched vars to environment */
					opr.publishVars(trn);
					
					instructAfterMatch = iit.nextIndex();
					
					if (opg != null) {
						changed = true;						
						modifyCode(trn, insList, iit, initBlock, cleanupBlock, cleanupExtra, cleanupOutLabel);						
					} else {
						instructAfterMatch += opr.getInstructions().size();						
					}
					
					// Call translator children recursively
					for (Translator subTrn : trn.getChildren())
						if (subTrn.getOpr() != null) {
							mapper.mapOperations(subTrn, bbs, cleanupBlock, cleanupExtra, cleanupOutLabel, false);
							changed = true;
						}
					
					unbindAll(opr);
					
					if (changed) {
						// set the iterator to find other matches
						iit = insList.listIterator(instructAfterMatch);					
					}
				}
				iit.next();
			}
		} while (changed);

		return changed;
	}

	/**
	 * Modify the code using the code generator <code>opg</code> at the
	 * <code>start</code> location of the <code>insList</code>.
	 * 
	 * @param start
	 *            Start iterator of the section to be modified.
	 * @param initBlock 
	 * @param cleanupBlock 
	 * @param opg
	 *            Code generator.
	 * @return The modified instructions.
	 */
	private void modifyCode(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start, BasicBlock initBlock, BasicBlock cleanupBlock,
			List<BasicBlock> cleanupExtraBlocks, Constant cleanupOutLabel) {
		trn.modify(trn, insList, start, initBlock, cleanupBlock, cleanupExtraBlocks, cleanupOutLabel);
	}
}
