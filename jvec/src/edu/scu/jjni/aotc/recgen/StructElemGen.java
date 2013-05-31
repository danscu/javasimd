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
		int elemNumber = getElemNumber();
		trn.setSubrecognizerKey(Integer.toString(elemNumber));
		initGetElem(trn, insList, start, elemNumber);
	}

	@Override
	public void insertCleanup(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start,
			List<BasicBlock> extraBlocks, Constant outLabel) {					
		int elemNumber = getElemNumber();
		cleanupGetElem(trn, insList, start, extraBlocks, outLabel, elemNumber);
	}

	@Override
	public void insert(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start) {
		int elemNumber = getElemNumber();
		if (Debug.level >= 2)
			trn.log("Struct Elem Access: " + elemNumber);
		modifyGetElem(trn, insList, start, elemNumber);
	}

	private int getElemNumber() {
		String elemNoByte = opr.getMatchContent(OpRecognizer
				.newWildcard("elem_no_byte"));
		String elemNoHalf = opr.getMatchContent(OpRecognizer
				.newWildcard("elem_no_half"));
		
		int elemNumber;
		
		if (elemNoHalf != null) {
			elemNumber = Integer.parseInt(elemNoHalf) * 2;
		} else if (elemNoByte != null) {
			elemNumber = Integer.parseInt(elemNoByte) / 4;
		} else {
			String elemNo = opr.getMatchContent(OpRecognizer
				.newWildcard("elem_no"));
			elemNumber = Integer.parseInt(elemNo);
		}
		
		return elemNumber;
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
