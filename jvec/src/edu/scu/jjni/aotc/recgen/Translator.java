package edu.scu.jjni.aotc.recgen;

import java.util.List;
import java.util.ListIterator;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import edu.scu.llvm.translate.VariableMapper;

/**
 * Translator is a collection of code recognizer and generator. It is also 
 * used as a context for code recognition and generation.
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
	
	public void setMapper(VariableMapper mapper) {
		this.mapper = mapper;
	}

	public List<Instruction> modify(List<Instruction> insList,
			ListIterator<Instruction> start) {
		// remove old ins
		for (int i = 0; i < opr.getInstructions().size(); i++) {
			start.next();
			start.remove();
		}
		return opg.insert(insList, start);
	}

	public Constant getVar(String var, boolean strict) {
		return mapper.mapVariable(var, strict);
	}
	
	public void setVar(String name, String matchContent) {		
		mapper.addVarMap(name, matchContent);
	}

	public boolean isFuncArg(String string) {
		return mapper.isFuncArg(string);
	}
}
