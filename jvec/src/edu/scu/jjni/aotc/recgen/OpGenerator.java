package edu.scu.jjni.aotc.recgen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import edu.scu.jjni.aotc.Debug;
import edu.scu.llvm.translate.VariableMapper.Semcode;

/**
 * Define a sequence of instructions for one operation.
 * 
 * @author danke
 */
public class OpGenerator {
	protected Semcode semc;
	protected Type typeIn;
	protected Type typeOut;
	OpRecognizer opr;

	public OpGenerator(Semcode semc, OpRecognizer opr, Type typeIn,
			Type typeOut) {
		this.semc = semc;
		this.opr = opr;
		this.typeIn = typeIn;
		this.typeOut = typeOut;
	}

	/**
	 * Use this function to generate temporary variable names in the
	 * pattern. In the actual generated code, the variable names will be
	 * automatically renamed.
	 * 
	 * @param n
	 *            The sequential
	 * @return the variable name
	 */
	public static String getTmpName(int n) {
		return String.format("%%R.%d", n);
	}

	public void addInstruction(ListIterator<Instruction> it, Instruction inst) {
		it.add(inst);
		if (Debug.level >= 2)
			System.out.println("Inserting: " + inst);
	}

	public Type getTypeIn() {
		return typeIn;
	}

	public Type getTypeOut() {
		return typeOut;
	}

	/**
	 * Modify code.
	 * @param insList
	 * @param start
	 * @return modified code.
	 */
	public List<Instruction> insert(List<Instruction> insList,
			ListIterator<Instruction> start) {		
		return insList;
	}
}
