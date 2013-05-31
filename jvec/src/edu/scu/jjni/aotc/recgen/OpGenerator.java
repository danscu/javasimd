package edu.scu.jjni.aotc.recgen;

import java.util.List;
import java.util.ListIterator;

import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
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
	Translator trn;	
	protected int insertCount;
	
	public OpGenerator(Semcode semc, OpRecognizer opr, Type typeIn,
			Type typeOut) {
		this.semc = semc;
		this.opr = opr;
		this.typeIn = typeIn;
		this.typeOut = typeOut;
	}	
	
	public void setTrn(Translator trn) {
		this.trn = trn;
	}

	public void resetInsertCount() {
		insertCount = 0;
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
		return String.format("%%Gen.%d", n);
	}
	
	public static String getLabelName(int n) {
		return String.format("%%\"L.%d\"", n);
	}

	public void addInstruction(ListIterator<Instruction> it, Instruction inst) {
		insertCount++;
		it.add(inst);
		if (Debug.level >= 2)
			trn.log("Inserting: " + inst);
	}

	public Type getTypeIn() {
		return typeIn;
	}

	public Type getTypeOut() {
		return typeOut;
	}

	/**
	 * Insert initialization code at the beginning of a function
	 * @param trn
	 * @param insList
	 * @param start
	 */
	public void insertInit(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start) {
	}
	
	/**
	 * Modify code at a point where other code is recognized. It returns the number of
	 * inserted instructions. A subclass can call this function to return the value.
	 * @param trn The translator context.
	 * @param insList
	 * @param start	 *
	 * @return The number of inserted instructions. 
	 */
	public int insert(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start) {
		return insertCount;
	}
	
	/**
	 * Insert cleanup code at the end of a function
	 * @param trn
	 * @param insList
	 * @param start
	 */
	public void insertCleanup(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start,
			List<BasicBlock> extraBlocks, Constant outLabel) {
	}
	
	protected void publishVar(Translator trn, String publicVar, String value) {		
		trn.setVar(Translator.publicVarName(publicVar), value);
		if (Debug.level >= 2)
			trn.log("Generator publishes var: " + publicVar + " val: " + value);
	}
}
