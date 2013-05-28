package edu.scu.jjni.aotc.recgen;

import java.util.List;
import java.util.ListIterator;

import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import edu.scu.jjni.aotc.Debug;
import edu.scu.llvm.translate.VariableMapper.Semcode;

public abstract class StructElemGen extends OpGenerator {

	public StructElemGen(Semcode semc, OpRecognizer opr, Type typeIn,
			Type typeOut) {
		super(semc, opr, typeIn, typeOut);
	}

	@Override
	public void insertInit(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start) {
		String elemNoByte = opr.getMatchContent(OpRecognizer
				.newWildcard("elem_no_byte"));
		
		int elemNumber;
		
		if (elemNoByte != null) {
			elemNumber = Integer.parseInt(elemNoByte) / 4;
		} else {
			String elemNo = opr.getMatchContent(OpRecognizer
				.newWildcard("elem_no"));
			elemNumber = Integer.parseInt(elemNo);
		}
		
		initGetElem(trn, insList, start, elemNumber);
	}

	@Override
	public void insertCleanup(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start,
			List<BasicBlock> extraBlocks, Constant outLabel) {			
		String elemNo = opr.getMatchContent(OpRecognizer
				.newWildcard("elem_no"));
		int elemNumber = Integer.parseInt(elemNo);
		cleanupGetElem(trn, insList, start, extraBlocks, outLabel, elemNumber);
	}

	@Override
	public void insert(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start) {
		String elemNo = opr.getMatchContent(OpRecognizer
				.newWildcard("elem_no"));
		if (Debug.level >= 2)
			System.out.println("Struct Elem Access: " + elemNo);
		int elemNumber = Integer.parseInt(elemNo);
		modifyGetElem(trn, insList, start, elemNumber);
	}

	abstract public void modifyGetElem(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start,
			int elemNo);

	abstract public void initGetElem(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start,
			int elemNo);

	abstract public void cleanupGetElem(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start,
			List<BasicBlock> extraBlocks, Constant outLabel,
			int elemNo);
}
