package edu.scu.jjni.aotc;

import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ACC_STATIC;
import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.RETURN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.TraceClassVisitor;

public class Java2Jni extends ClassVisitor {
	protected Set<String> functionTable;
	protected String jniLibName;
	protected boolean insertLibraryLoad;
	
	/**
	 * When used as a method visitor, this class drops a method's implementation.
	 */
	class MethodMuter extends MethodVisitor {
		public MethodMuter(int api, String methodName) {
			super(api, null /* MethodVistor */);
		}
	}
	
	/**
	 * Insert code to load library "System.loadLibrary("<libraryName>");"
	 * @param mv the method visitor.
	 * @param libraryName
	 */
	void insertCodeToLoadLibrary(MethodVisitor mv, String libraryName) {
		mv.visitLdcInsn(libraryName);
		mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "loadLibrary", "(Ljava/lang/String;)V");		
	}
	
	/**
	 * Adds the line "System.loadLibrary("<libraryName>" to a class containing
	 * an initializer.
	 */
	class ClassInitModifier extends MethodVisitor {
		protected boolean insertCode;
		protected String jniLibName;
		
		public ClassInitModifier(int api, MethodVisitor mv, String jniLibName) {
			super(api, mv);
			insertCode = true;
			this.jniLibName = jniLibName;
		}

		@Override
		public void visitCode() {
			super.visitCode();

			// Insert the code now
			if (insertCode) {
				insertCode = false;
				insertCodeToLoadLibrary(this, jniLibName);
			}
		}
	}
	
	/**
	 * Converts a Java class by changing specific methods to native
	 * @param cv The base class visitor.
	 * @param jniLibName JNI Library Name to be loaded as a static constructor.
	 * @param functionNames Methods to be nativized.
	 */
	public Java2Jni(ClassVisitor cv, String jniLibName, String[] functionNames) {
		super(ASM4, cv);
		this.jniLibName = jniLibName;
		
		functionTable = new HashSet<String>();
		for (String fn : functionNames)
			functionTable.add(fn);
		
		insertLibraryLoad = true;
	}

	/**
	 * Insert initializer code to load a dynamic library.
	 * 
	 * static {
	 *     System.loadLibrary("<library_name>");
	 * }
	 *
	 */
	private void insertLibraryLoader(String libraryName) {
		// For class format, see http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html
		MethodVisitor mv = super.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
		mv.visitCode();
		insertCodeToLoadLibrary(mv, libraryName);
		mv.visitInsn(RETURN);
		mv.visitMaxs(1 /* max stack */, 0 /* max locals */);
		mv.visitEnd();
	}
	
	/**
	 * Visits and modifies methods. Makes specified methods native.
	 */
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
            String signature, String[] exceptions) {
    	
    	// Modify class initializer
    	if (name.equals("<clinit>")) {
    		if (!insertLibraryLoad) {
    			// Since standard Java compilers add this method first, it shouldn't be
    			// a real problem. Just warn in case it happens.
    			System.out.println("Error: class initializer is not the first method. " +
    					"Need to update this program to handle the case.");
    			System.exit(-100);
    		}
    		insertLibraryLoad = false;
    		MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
    		// Modifies the class initializer
            ClassInitModifier newMethodVisitor = new ClassInitModifier(api, mv, jniLibName);
            return newMethodVisitor;
    	}
    	else {
	    	// Insert class initializer as the first method
	    	if (insertLibraryLoad) {
	    		insertLibraryLoad = false;
	    		insertLibraryLoader(jniLibName);
	    	}
    	}
    	
    	// Do not change other methods
    	if (!functionTable.contains(name))
    		return super.visitMethod(access, name, desc, signature, exceptions);	
    	
    	// Make a method 'native'
        super.visitMethod(access | ACC_NATIVE, name, desc, signature, exceptions);

        // Remove the method implementation
        MethodMuter newMethodVisitor = new MethodMuter(api, name);

        return newMethodVisitor;
    }
    
    /**
     * Transforms a set of methods to native
     * 
     * @param clsName
     * @param functionNames
     * @return the transformed Java class
     */
	public static byte[] transformClass(String clsName, String jniLibName, String[] functionNames,
			boolean printResult)
	{
		/*
		 *  Creates a class writer, and automatically computes stack & locals instead of using specified value.
		 *  It is necessary to automatic compute stack & locals here, because we may be modifying the static
		 *  class constructor.
		 */
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		ClassVisitor cv;
		
		if (printResult) {
			PrintWriter cp = new PrintWriter(System.out);
			cv = new TraceClassVisitor(cw, cp);
		} else {
			cv = cw;
		}
		
		Java2Jni cmod = new Java2Jni(cv, jniLibName, functionNames);
		ClassReader cr;
		
		try {
			cr = new ClassReader(clsName);
			cr.accept(cmod, 0);
		} catch (IOException e) {
			System.out.println("Error: class not found, clsName = " + clsName);
			return null;
		}
		
		return cw.toByteArray();
	}
	
	public static boolean writeClass(String filename, byte[] modifiedClass) {
		try {
			FileOutputStream file = new FileOutputStream(new File(filename));
			file.write(modifiedClass);
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: failed to open output class " + filename);
			return false;
		} catch (IOException e) {
			System.out.println("Error: failed to write output class " + filename);
			return false;
		}
		return true;
	}
	
	/**
	 * Modifies a Java class and nativizes specified methods.
	 * @param args args[0] class name, args[1] output name, args[2] library name,
	 * args[3..N] method names.
	 */
	public static void main(String[] args) {
		if (args.length < 4) {
			System.out.println("Usage: java Java2JniClass <input_class> <output_path> <jni_lib_name> <methods>...");
			System.exit(-1);
		}
		
		byte[] modifiedClass = transformClass(args[0], args[2],
				Arrays.copyOfRange(args, 3, args.length), true);
		if (modifiedClass == null)
			System.exit(-2);
		
		if (args.length >= 2) {
			String filename = args[1];
			if (!writeClass(filename, modifiedClass))
				System.exit(-3);
			System.out.println("New class written to " + filename);
		} else {
			System.out.println("Output path is not present. Modified class is not written.");	
		}
	}
}
