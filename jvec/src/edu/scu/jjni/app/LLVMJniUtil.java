package edu.scu.jjni.app;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Pair;

import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Module;
import edu.scu.jjni.aotc.LLVM2Jni;
import edu.scu.llvm.parser.LLVMLexer;
import edu.scu.llvm.parser.LLVMParser;
import edu.scu.llvm.translate.FunctionConverter;

public class LLVMJniUtil {
	public static String filePath = "HelloWorld.s"; // default
	public static String fileFolder = ".";
	public String[] methodNames;
	public String[] outputMethodNames;
	
	/**
	 * Set a set of methods to optimize. If methodNames[0] == "#autovec",
	 * it converts methods which access vector types.
	 * @param methodNames
	 */
	public void setMethodNames(String[] methodNames) {
		this.methodNames = methodNames;
	}
	
	public String[] getOutputMethodNames() {
		return outputMethodNames;
	}
	
	public Pair<Boolean,String> run() {
		if (!filePath.endsWith(".ll") && !filePath.endsWith(".s")) {
			return new Pair<Boolean,String>(false, "Error: Not LLVM file");
		}
		
		File file = new File(filePath);		
		if (!file.exists()){
			return new Pair<Boolean,String>(false,"Error: File not found");
		}
		
		fileFolder = file.getParent();
		
		ANTLRFileStream f;
		try {
			f = new ANTLRFileStream(filePath);
		} catch (IOException e) {
			return new Pair<Boolean,String>(false,"Error: File read error");
		}
		
	   	LLVMLexer l = new LLVMLexer(f);
		CommonTokenStream ct = new CommonTokenStream((TokenSource) l);
		LLVMParser p = new LLVMParser((TokenStream) ct);
		
		System.out.println("Parsing " + filePath);
		
		BasicBlock.CONTACT = false;
		Module module = p.llvm_program().program;
		if (module == null)
			return new Pair<Boolean,String>(false,
					"Error: Nothing to process in source file");
		
		// Target is JNI transform
		FunctionConverter system;
		try {
			system = new LLVM2Jni(module, methodNames);
		} catch (Exception e) {
			e.printStackTrace();
			return new Pair<Boolean,String>(false, e.getLocalizedMessage());
		}
		
		boolean state = system.process();
		if (state) {
			outputMethodNames = system.getOutputFunctionNames().toArray(new String[0]);
			return new Pair<Boolean,String>(true, system.getResult());
		}
		else
			return new Pair<Boolean,String>(false, system.getLog());
	}	
}
