package edu.scu.jjni.aotc.recgen;

import java.util.List;
import java.util.ListIterator;

import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import edu.scu.jjni.aotc.Debug;
import edu.scu.llvm.translate.VariableMapper;

/**
 * Translator is a collection of code recognizer and generator. It is also 
 * used as a context for code recognition and generation.
 * 
 * There are three types of translators:
 *   1) Recognizer + Generator. The recognizer is used to match a code sequence. If
 *      a match is found, the code sequence is removed, and the code generator is
 *      called to re-generate the removed code.
 *   2) Recognizer only. It is called for each BasicBlock to process the instructions,
 *      and publish variables.
 *   3) Generator only. The generator's init and cleanup insert functions are called
 *      for each function. The normal insert function is not used.
 * 
 * @author danke 
 */
public class Translator {
	protected OpRecognizer opr;
	protected OpGenerator opg;
	
	protected VariableMapper mapper;
	
	public Translator(OpRecognizer opr, OpGenerator opg) {
		super();
		this.opr = opr;
		this.opg = opg;		
	}

	public OpRecognizer getOpr() {
		return opr;
	}

	public OpGenerator getOpg() {
		return opg;
	}
	
	/**
	 * Use this function to generate variable names to match specific
	 * operands in the instructions.
	 * 
	 * @param m The variable ID without prefix
	 * @return the matching variable name
	 */
	public static String getPublicVar(String id) {
		String name = String.format("@%%Ms.%s", id);
		return name;
	}		
	
	public void setMapper(VariableMapper mapper) {
		this.mapper = mapper;
	}

	public List<Instruction> modify(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start, BasicBlock initBlock, BasicBlock cleanupBlock) {
		
		if (Debug.level >= 1)
			System.out.println("Modify code for " + trn.getOpg().semc);			
		
		if (initBlock != null) {
			// insert init code to initBlock
			opg.insertInit(trn, initBlock.getInstructions(), initBlock.getInstructions().listIterator());
		} else {
			// this is the init block, insert init code to front
			Instruction startIns = start.next();
			insList = opg.insertInit(trn, insList, start);
			start = insList.listIterator(insList.indexOf(startIns));
		}
		
		// remove old ins
		for (int i = 0; i < opr.getInstructions().size(); i++) {
			Instruction ins = start.next();
			if (Debug.level >= 2)
				System.out.println("Removing: " + ins);
			start.remove();
		}

		// insert cleanup code to cleanup block
		opg.insertCleanup(trn, cleanupBlock.getInstructions(), cleanupBlock.getInstructions().listIterator());
		
		return opg.insert(trn, insList, start);		
	}

	/**
	 * Gets a public variable in the translation context
	 * @param var The variable name with needed prefix.
	 * @param strict If set to true, an exception will be thrown if the variable
	 * does not exist.
	 * @return The constant.
	 */
	public Constant getVar(String var, boolean strict) {
		return mapper.mapVariable(var, strict);
	}
	
	public void setVar(String name, String matchContent) {		
		mapper.addVarMap(name, matchContent);
	}

	public boolean isFuncArg(String string) {
		return mapper.isFuncArg(string);
	}

	public String getRecTmpName() {		
		return mapper.getRecTmpName();
	}
	
	public String getGenTmpName() {		
		return mapper.getGenTmpName();
	}
}