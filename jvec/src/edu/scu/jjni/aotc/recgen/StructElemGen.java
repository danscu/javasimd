package edu.scu.jjni.aotc.recgen;

import java.util.List;
import java.util.ListIterator;

import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import edu.scu.llvm.translate.VariableMapper.Semcode;

public abstract class StructElemGen extends OpGenerator {

	public StructElemGen(Semcode semc, OpRecognizer opr, Type typeIn,
			Type typeOut) {
		super(semc, opr, typeIn, typeOut);
	}

	@Override
	public List<Instruction> insert(List<Instruction> insList,
			ListIterator<Instruction> start) {
		String elemNo = opr.getMatchContent(OpRecognizer.getMatchName("elem_no"));
		int elemNumber = Integer.parseInt(elemNo);
		return modifyGetElem(insList, start, elemNumber);
	}
	
	abstract public List<Instruction> modifyGetElem(List<Instruction> insList,
			ListIterator<Instruction> start, int elemNo);
}
