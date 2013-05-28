package edu.scu.jjni.aotc.recgen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import edu.scu.jjni.aotc.Debug;
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
	protected Semcode semc;
	protected Type typeIn;
	protected Type typeOut;
	protected List<Instruction> seq;
	protected Map<String, String> matchMap;

	/**
	 * Matched types
	 */	
	protected Map<String, Type> matchType;
	
	protected List<String> publicNames; 
	
	public OpRecognizer(Semcode op, Type typeIn, Type typeOut) {
		this.semc = op;
		this.typeIn = typeIn;
		this.typeOut = typeOut;
		seq = new ArrayList<Instruction>();
		matchMap = new HashMap<String, String>();
		matchType = new HashMap<String, Type>();
		publicNames = new ArrayList<String>();
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
	 * Use this function to generate temporary variable names for the
	 * destination of the instructions.
	 * 
	 * @param n
	 *            The sequential
	 * @return the destination variable name
	 */
	public static String getArgMatchName(int n) {
		return String.format("%%MA.%d", n);
	}
	
	/**
	 * Use this function to generate variable names to match specific
	 * operands in the instructions
	 * 
	 * @param m
	 * @return the matching variable name
	 */
	public static String newWildcard(String id) {
		String name = String.format("%%Ms.%s", id);
		return name;
	}
	
	public void addInstruction(Instruction inst) {
		seq.add(inst);
	}

	public List<Instruction> getInstructions() {
		return seq;
	}

	/**
	 * Matched variables can be published for other generator to use.
	 * Publish the variable name returned by getMatchName by this
	 * function. Public names can be accessed by Translator.getVar().
	 */
	public void addPublicVar(Constant var) {
		if (!publicNames.contains(var.getValue()))
			publicNames.add(var.getValue());		
	}
	
	/**
	 * Get matched name.
	 * @param varName Full name (including prefix).
	 * @return the value.
	 */
	public String getMatchContent(String varName) {
		return matchMap.get(varName);
	}

	public Map<String, String> getMatchMap() {
		return matchMap;
	}

	public Map<String, Type> getTypeMatchMap() {
		return matchType;
	}
	
	public Semcode getSemc() {
		return semc;
	}

	public Type getTypeIn() {
		return typeIn;
	}

	public Type getTypeOut() {
		return typeOut;
	}

	public void publishVars(Translator trn) {
		for (String name : publicNames) {
			trn.setVar("@" + name, getMatchContent(name));
			if (Debug.level >= 2)
				System.out.println("Publish var: " + name + " val: " + getMatchContent(name));
		}
	}
}
