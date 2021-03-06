package edu.scu.jjni.aotc.recgen;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.antlr.v4.parse.ANTLRParser.throwsSpec_return;

import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import edu.scu.jjni.aotc.Debug;
import edu.scu.llvm.translate.VariableMapper.Semcode;

public class ArrayAccessGen extends StructElemGen {
	protected Map<Integer, OpGenerator> genMap;

	public ArrayAccessGen(Semcode semc, OpRecognizer opr, Type typeIn,
			Type typeOut) {
		super(semc, opr, typeIn, typeOut);
		genMap = new HashMap<Integer, OpGenerator>();
	}

	private OpGenerator getOpg(int elemNo) {
		OpGenerator opg = genMap.get(elemNo);

		if (opg == null) {
			throw new RuntimeException("Cannot generate code for elem "
					+ elemNo);
		}

		return opg;
	}

	@Override
	public void modifyGetElem(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start,
			int elemNo) {
		OpGenerator opg = getOpg(elemNo);
		opg.insert(trn, insList, start);
	}

	public void addGenerator(int elemNo, OpGenerator opg) {
		genMap.put(elemNo, opg);
		opg.setTrn(trn);
	}

	@Override
	public void initGetElem(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start,
			int elemNo) {
		OpGenerator opg = getOpg(elemNo);
		opg.insertInit(trn, insList, start);
	}

	@Override
	public void cleanupGetElem(Translator trn,
			List<Instruction> insList, ListIterator<Instruction> start,
			List<BasicBlock> extraBlocks, Constant outLabel,
			int elemNo) {
		OpGenerator opg = getOpg(elemNo);
		opg.insertCleanup(trn, insList, start, extraBlocks, outLabel);
	}
}
