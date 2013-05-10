package edu.scu.jvec.ui;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;


import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

import cn.edu.sjtu.jllvm.ESP.ESPChecking;
import cn.edu.sjtu.jllvm.ESP.ESPProperty.ESPTransitionSystem;
import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Module;
import cn.edu.sjtu.jllvm.VMCore.Parser.LLVMLexer;
import cn.edu.sjtu.jllvm.VMCore.Parser.LLVMParser;
import edu.scu.jvec.JNITransform;
import edu.scu.jvec.LLVMTransform;

public class UIUtil {
	public static String filePath = "/home/danke/vm/test/java-to-asm/HelloWorld.s"; // default
	public static String fileFolder = ".";
	
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
		
		byte[] buffer = new byte[(int) file.length()];
		BufferedInputStream f = new BufferedInputStream(new FileInputStream(file));
	   	f.read(buffer);
	   	LLVMLexer l = new LLVMLexer(new ANTLRStringStream(new String(buffer)));
		CommonTokenStream ct = new CommonTokenStream(l);
		LLVMParser p = new LLVMParser(ct);
		BasicBlock.CONTACT=false;
		Module module = p.program();
		if (module == null)
			return "Error: Nothing to process in source file";
		
		// Target is JNI transform
		LLVMTransform system = new JNITransform(module, null);
		String result = system.getResult();
		
		return result;
	}
}
