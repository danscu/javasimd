package edu.scu.llvm.translate;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import edu.scu.jjni.aotc.recgen.OpGenerator;
import edu.scu.jjni.aotc.recgen.OpRecognizer;

public class InstMatcher {
	/**
	 * Matched variables
	 */
	Map<String, String> matchPat;

	public InstMatcher() {
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
			if (isWildcard(patOp)
					&& (isUnbound(patOp) || getWildcardVal(patOp).equals(
							insOp.getValue())))
				continue;

			// non-wildcard
			if (!patOp.getValue().equals(insOp.getValue()))
				return false;
		}

		// match destination last
		if (!isWildcard(patIns.getDest())
				&& !patIns.getDest().getValue()
						.equals(ins.getDest().getValue()))
			return false;

		// If pat is not wildcard or unbound, and the value mismatches, then
		// fail
		if (!isUnbound(patIns.getDest())
				&& !ins.getDest().getValue()
						.equals(getWildcardVal(patIns.getDest())))
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

	enum MatchResult {
		MISMATCH, MATCH, TOO_SHORT
	};

	protected MatchResult _match(ListIterator<Instruction> start,
			OpRecognizer opr) {
		for (Instruction patIns : opr.getInstructions()) {
			if (!start.hasNext())
				return MatchResult.TOO_SHORT;

			Instruction ins = start.next();
			if (!matchInst(ins, patIns))
				return MatchResult.MISMATCH;
		}

		return MatchResult.MATCH;
	}

	public boolean matchAndModify(OpRecognizer opr, OpGenerator opg,
			List<Instruction> insList) {
		matchPat = opr.getMatchMap();
		matchPat.clear();

		boolean changed;
		do {
			changed = false;
			ListIterator<Instruction> iit = insList.listIterator();
			while (iit.hasNext()) {
				ListIterator<Instruction> start = insList.listIterator(iit
						.nextIndex());
				MatchResult res = _match(start, opr);
				if (res == MatchResult.MATCH) {
					System.out.println("Match");
					changed = true;
					insList = modifyCode(insList, start, opg);
				} else if (res == MatchResult.TOO_SHORT)
					break;
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
			ListIterator<Instruction> start, OpGenerator opg) {
		return opg.modify(insList, start);
	}
}
