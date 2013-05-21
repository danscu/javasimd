package edu.scu.jjni.aotc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.antlr.v4.runtime.misc.Pair;

import edu.scu.jjni.app.LLVMJniUtil;

public class JavaOptimizer {
	/**
	 * Modifies a Java class to use native code for optimized methods.
	 * @param args args[0] class name, args[1] output name, args[2] library name,
	 * args[3] LLVM code for the compiled Java class,
	 * args[4] filename for converted LLVM code,
	 * args[5..N] optimized method names. If args[5] == "#autovec", then the optimizer
	 * only emits methods with vector code.
	 */
	public static void main(String[] args) {
		if (args.length <= 5) {
			System.out.println("Usage: java JavaOptimizer <input_class> <output_class> <jni_lib_name> <llvm_in> <llvm_out> <<methods>...");
			System.exit(-1);
		}
		
		String className = args[0];
		String outputName = args[1];
		String libraryName = args[2];
		String llvmFile = args[3];
		String llvmOutFile = args[4];
		String[] methodNames = Arrays.copyOfRange(args, 5, args.length);
		
		System.out.print("Methods to optimize: ");
		for (String s : methodNames)
			System.out.print(s + " ");
		System.out.println();
		
		LLVMJniUtil util = new LLVMJniUtil();
		util.filePath = llvmFile;
		util.setMethodNames(methodNames);
		
		Pair<Boolean,String> res = util.run();
		
		if (!res.a) {
			System.err.println("LLVM code conversion failed.");
			System.err.println(res.b);
			System.exit(-1);
		}
		
		// Write LLVM output file
		try {
			OutputStream os = new FileOutputStream(new File(llvmOutFile));
			PrintStream ps = new PrintStream(os);
			ps.append(res.b);
			ps.close();
			System.out.println("LLVM output file written: " + llvmOutFile);
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open file to write: " + llvmOutFile);
			System.exit(-1);
		}
		
		String[] convertedFuncs = util.getOutputMethodNames();
		
		System.out.print("Converted methods: ");
		for (String s : convertedFuncs)
			System.out.print(s + " ");
		System.out.println();

		System.out.println("Modifying the Java class " + className);
		System.out.println("Dynaically links to library " + libraryName);
		
		byte[] modifiedClass = Java2Jni.transformClass(className, libraryName,
				convertedFuncs, false);

		if (modifiedClass != null) {
			Java2Jni.writeClass(outputName, modifiedClass);
		}
	}
}