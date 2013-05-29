package edu.scu.jjni.aotc.recgen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

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
	protected String name;
	
	protected OpRecognizer opr;
	protected OpGenerator opg;
	
	protected VariableMapper mapper;
	
	protected List<Translator> children;
	
	protected Map<String,List<Translator>> keyedChildren;
	private String subrecognizerKey;
	
	public Translator(String name, OpRecognizer opr, OpGenerator opg) {
		super();
		this.name = name;
		this.opr = opr;
		this.opg = opg;
		children = new ArrayList<Translator>();
		keyedChildren = new HashMap<String,List<Translator>>();
		
		if (opg != null)
			opg.setTrn(this);
	}

	public String getName() {		
		return name;
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
	public static String publicVarName(String id) {
		String name = String.format("@%%Ms.%s", id);
		return name;
	}		
	
	public static boolean isPublicVar(Constant var) {
		return var.getValue().startsWith("@%Ms.");
	}
	
	public void setMapper(VariableMapper mapper) {
		this.mapper = mapper;
	}

	public void modify(Translator trn, List<Instruction> insList,
			ListIterator<Instruction> start, BasicBlock initBlock, BasicBlock cleanupBlock,
			List<BasicBlock> extraCleanupBlocks, Constant cleanupOutLabel) {
		
		if (Debug.level >= 1)
			trn.log("Modify code for " + trn.getOpg().semc);			
		
		if (initBlock != null) {
			// insert init code to initBlock
			List<Instruction> list = initBlock.getInstructions();
			// insert before br instruction
			opg.insertInit(trn, list, list.listIterator(list.size() - 1));
		} else {
			// this is the init block, insert init code to front
			Instruction startIns = start.next();
			opg.insertInit(trn, insList, start);
			
			// insList modified, get the iterator again
			start = insList.listIterator(insList.indexOf(startIns));
		}
		
		// remove old ins
		for (int i = 0; i < opr.getInstructions().size(); i++) {
			Instruction ins = start.next();
			if (Debug.level >= 2)
				trn.log("Removing: " + ins);
			start.remove();
		}

		// insert cleanup code to cleanup block
		opg.insertCleanup(trn, cleanupBlock.getInstructions(),
				cleanupBlock.getInstructions().listIterator(),
				extraCleanupBlocks, cleanupOutLabel);
		
		opg.insert(trn, insList, start);
	}

	/**
	 * Gets a public variable in the translation context
	 * @param var The variable name with needed prefix.
	 * @param strict If set to true, an exception will be thrown if the variable
	 * does not exist.
	 * @return The constant.
	 */
	public Constant getVar(String var, boolean strict) {
		Constant c = mapper.mapVariable(var, strict);
		if (c == null)
			return c;
		
		if (!isPublicVar(c))
			return c;
		else
			return getVar(c.getValue(), strict);
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
	
	public String getLabelTmpName() {		
		return mapper.getLabelTmpName();
	}
	
	public void addTranslator(Translator trn) {
		children.add(trn);
		trn.setMapper(mapper);
	}
	
	public void addTranslator(String key, Translator trn) {
		if (keyedChildren.get(key) == null)
			keyedChildren.put(key, new ArrayList<Translator>());
		List<Translator> list = keyedChildren.get(key);
		list.add(trn);
		trn.setMapper(mapper);
	}
	
	public List<Translator> getChildren() {
		if (subrecognizerKey != null) {
			List<Translator> c = new ArrayList<Translator>();
			c.addAll(children);
			List<Translator> kt = getKeyedChildren(subrecognizerKey);
			if (kt == null)
				throw new RuntimeException("Cannot find keyed child");
			c.addAll(kt);
			return c;
		}
		
		return children;
	}
	
	public List<Translator> getKeyedChildren(String key) {
		return keyedChildren.get(key);
	}
	
	public void setSubrecognizerKey(String key) {
		subrecognizerKey = key;
	}

	public String getSubrecognizerKey() {
		return subrecognizerKey;
	}	
	
	public void log(String str) {
		mapper.log(str);
	}
}
