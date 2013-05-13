package edu.scu.jvec;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cn.edu.sjtu.jllvm.VMCore.Module;

public class JNIConverter extends FunctionConverter {

	private static final String PREAMBLE = "dat/jnipreamble.ll";
	
	public JNIConverter(Module _module, String[] _functionNames) throws Exception {
		super(_module, _functionNames, getJNIPreamble(), getJNIMapper(), getIgnoreCalls(),
				getIgnoreFAttr());
	}

	static private String JNIPreamble;
	static private String getJNIPreamble() throws Exception {
		String content = "";
		try {
			content = new Scanner(new File(PREAMBLE)).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open JNI preamble file: " + PREAMBLE);
			throw e;
		}
		return content;
	}
	
	private static VariableMapper getJNIMapper() {
		VariableMapper mapper = new VariableMapper();
		return mapper;
	}
	
	private static List<String> getIgnoreCalls() {
		List<String> ignoreCalls = new ArrayList<String>();
		ignoreCalls.add("@llvm.dbg.declare");
		return ignoreCalls;
	}
	
	private static List<String> getIgnoreFAttr() {
		List<String> ignoreFAttr = new ArrayList<String>();
		ignoreFAttr.add("uwtable");
		return ignoreFAttr;
	}
}
