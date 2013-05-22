package edu.scu.jjni.aotc.recgen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import edu.scu.llvm.translate.VariableMapper.Semcode;

/**
 * Define a pattern of instructions to implement an operation on a type. In
 * the inserted instruction the dest variable names follow the pattern %R.i
 * where i = 0, 1, 2, ..., N. It must be strictly sequential in the pattern,
 * but it will match any variable name in the function.
 * 
 * The output value %R.N has the type typeOut
 * 
 * @author danke
 */
public class OpRecognizer {
	protected Semcode op;
	protected Type typeIn;
	protected Type typeOut;
	protected List<Instruction> seq;
	protected Map<String, String> matchMap;

	public OpRecognizer(Semcode op, Type typeIn, Type typeOut) {
		this.op = op;
		this.typeIn = typeIn;
		this.typeOut = typeOut;
		seq = new ArrayList<Instruction>();
		matchMap = new HashMap<String, String>();
	}

	/**
	 * Use this function to generate temporary variable names for the
	 * destination of the instructions.
	 * 
	 * @param n
	 *            The sequential
	 * @return the destination variable name
	 */
	public static String getMatchName(int n) {
		return String.format("%%M.%d", n);
	}

	/**
	 * Use this function to generate variable names to match specific
	 * operands in the instructions
	 * 
	 * @param m
	 * @return the matching variable name
	 */
	public static String getMatchName(String id) {
		return String.format("%%Ms.%s", id);
	}

	public void addInstruction(Instruction inst) {
		seq.add(inst);
	}

	public List<Instruction> getInstructions() {
		return seq;
	}

	public String getMatchContent(String id) {
		return matchMap.get(getMatchName(id));
	}

	public Map<String, String> getMatchMap() {
		return matchMap;
	}

	public Type getTypeIn() {
		return typeIn;
	}

	public Type getTypeOut() {
		return typeOut;
	}

}
