package edu.scu.jjni.aotc.recgen;

import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;

public class MatchVariable extends Constant {
	protected String varName;
	protected Translator trn;
	
	public MatchVariable(Translator trn, String varName) {
		this.varName = varName;
		this.trn = trn;
	}

	@Override
	public String toString() {	
		return trn.getVar("$" + varName).toString();
	}
}
