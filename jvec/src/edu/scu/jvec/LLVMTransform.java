package edu.scu.jvec;

import cn.edu.sjtu.jllvm.VMCore.Module;

public class LLVMTransform {
	/**
	 * The LLVM module to be analyzed.
	 */
	protected Module module;

	/**
	 * Preamble of the generated code.
	 */
	protected String preamble;
	
	/**
	 * The result log of the process.
	 */
	protected StringBuffer logBuffer;
		
	/**
	 * The generated code.
	 */
	protected StringBuffer resultBuffer;
	
	/**
	 * Function names. If null, all functions are analyzed.
	 */
	protected String[] functionNames;
	
	/**
	 * Constructor.
	 * @param _module The module to be analyzed.
	 * @param _functionNames List of function names to be added to the native library
	 */
	public LLVMTransform(Module _module, String[] _functionNames, String _preamble) {
		module = _module;
		functionNames = _functionNames;
		preamble = _preamble;						
	}
	
	/**
	 * Process the program.
	 */
	public boolean process() {
		logBuffer = new StringBuffer();
		resultBuffer = new StringBuffer();		
		
		resultBuffer.append(preamble);
		
		return true;
	}
	
	/**
	 * Gets the log of the processing, including errors.
	 * @return the log.
	 */
	public String getLog() {
		return logBuffer.toString();		
	}
	
	/**
	 * Gets the execution result (generated code)
	 * @return the generated code.
	 */
	public String getResult() {	
		return resultBuffer.toString();
	}
}
