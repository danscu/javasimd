package edu.scu.jjni.aotc.recgen;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import edu.scu.llvm.translate.VariableMapper.Semcode;

/**
 * Define a sequence of instructions for one operation.
 * 
 * @author danke
 */
public class OpGenerator {
	protected Semcode op;
	protected Type typeIn;
	protected Type typeOut;
	List<Instruction> seq;
	List<Instruction> destructor;
	OpRecognizer opr;

	public OpGenerator(Semcode semc, OpRecognizer opr, Type typeIn,
			Type typeOut) {
		this.op = semc;
		this.opr = opr;
		this.typeIn = typeIn;
		this.typeOut = typeOut;
		seq = new ArrayList<Instruction>();
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

	public void addInstruction(Instruction inst) {
		seq.add(inst);
	}

	public Type getTypeIn() {
		return typeIn;
	}

	public Type getTypeOut() {
		return typeOut;
	}

	/**
	 * Use this to define operations to release resources
	 * 
	 * @param inst
	 */
	public void addDestuctorInst(Instruction inst) {
		if (destructor == null)
			destructor = new ArrayList<Instruction>();
		destructor.add(inst);
	}

	/**
	 * Modify code.
	 * @param insList
	 * @param start
	 * @return modified code.
	 */
	public List<Instruction> modify(List<Instruction> insList,
			ListIterator<Instruction> start) {
		return null;
	}
}
