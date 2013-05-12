package edu.scu.jvec.ui;

import java.io.File;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;

import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Module;
import cn.edu.sjtu.jllvm.VMCore.Parser.LLVMLexer;
import cn.edu.sjtu.jllvm.VMCore.Parser.LLVMParser;
import edu.scu.jvec.FunctionConverter;
import edu.scu.jvec.JNIConverter;

public class UIUtil {
	public static String filePath = "./Example/HelloWorld.s"; // default
	public static String fileFolder = "./Example/";
	
	public static boolean DEBUG_ALL_INFO = false;
	
	public String run() throws Exception {
		if (!filePath.endsWith(".ll") && !filePath.endsWith(".s")) {
			return "Error: Not LLVM file";
		}
		
		File file = new File(filePath);
		
		if(!file.exists()){
			return "Error: File not found";
		}
		
		fileFolder = file.getParent();
		
		ANTLRFileStream f = new ANTLRFileStream(filePath);
	   	LLVMLexer l = new LLVMLexer(f);
		CommonTokenStream ct = new CommonTokenStream((TokenSource) l);
		LLVMParser p = new LLVMParser((TokenStream) ct);
		
		BasicBlock.CONTACT=false;
		Module module = p.llvm_program().program;
		if (module == null)
			return "Error: Nothing to process in source file";
		
		// Target is JNI transform
		FunctionConverter system = new JNIConverter(module, null);
		boolean state = system.process();
		if (state)
			return system.getResult();
		else
			return system.getLog();
	}
}
