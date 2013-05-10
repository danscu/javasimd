package edu.scu.jvec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.TraceClassVisitor;

import static org.objectweb.asm.Opcodes.*;

public class ClassVectorizer extends ClassVisitor {	
	public ClassVectorizer(ClassVisitor cv) {
		super(ASM4, cv);
	}

	@Override
	public void visit(int version, int access, String name,
			String signature, String superName, String[] interfaces) {
		cv.visit(V1_5, access, name, signature, superName, interfaces);
	}

	public static byte[] transformClass(String clsName)
	{
		ClassWriter cw = new ClassWriter(0);
		PrintWriter cp = new PrintWriter(System.out);		
		TraceClassVisitor cv = new TraceClassVisitor(cw, cp);
		ClassReader cr;
		
		try {
			cr = new ClassReader(clsName);
			cr.accept(cv, 0);
		} catch (IOException e) {
			System.out.println("Error: class not found, clsName = " + clsName);
			return null;
		}
		
		return cw.toByteArray();
	}
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Usage: java ClassVectorizer <input_class> <output_path>");
			System.exit(-1);
		}
		
		byte[] modifiedClass = transformClass(args[0]);		
		if (modifiedClass == null)
			System.exit(-2);
		
		if (args.length >= 2) {
			String fn = args[1];
			try {
				FileOutputStream file = new FileOutputStream(new File(fn));		
				file.write(modifiedClass);
				file.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error: failed to open output class " + fn);
				System.exit(-3);
			} catch (IOException e) {
				System.out.println("Error: failed to write output class " + fn);
				System.exit(-4);
			}
			System.out.println("New class written to " + fn);
		} else {
			System.out.println("Output path is not present. Modified class is not written.");	
		}				
	}
}
