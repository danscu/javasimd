package edu.scu.jvec;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class ClassVisitorChain extends ClassVisitor {
	private ClassVisitor[] m_visitors;
	
	/**
	 * Constructor. The first visitor can determine the return value for
	 * visitor methods with a return value.
	 * @param arg0
	 * @param visitors
	 */
	public ClassVisitorChain(int arg0, ClassVisitor... visitors) {
		super(arg0);
		m_visitors = visitors;
	}

	@Override
	public void visit(int arg0, int arg1, String arg2, String arg3,
			String arg4, String[] arg5) {
		for (ClassVisitor v : m_visitors)
			v.visit(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public AnnotationVisitor visitAnnotation(String arg0, boolean arg1) {
		for (ClassVisitor v : m_visitors)
			v.visitAnnotation(arg0, arg1);
		return super.visitAnnotation(arg0, arg1);
	}

	@Override
	public void visitAttribute(Attribute arg0) {
		for (ClassVisitor v : m_visitors)
			v.visitAttribute(arg0);
	}

	@Override
	public void visitEnd() {
		for (ClassVisitor v : m_visitors)
			v.visitEnd();
	}

	@Override
	public FieldVisitor visitField(int arg0, String arg1, String arg2,
			String arg3, Object arg4) {
		FieldVisitor res = null;	
		for (ClassVisitor v : m_visitors) {
			if (v == m_visitors[0])
				res = v.visitField(arg0, arg1, arg2, arg3, arg4);
			else
				v.visitField(arg0, arg1, arg2, arg3, arg4);
		}
		return res;
	}

	@Override
	public void visitInnerClass(String arg0, String arg1, String arg2, int arg3) {
		for (ClassVisitor v : m_visitors)
			v.visitInnerClass(arg0, arg1, arg2, arg3);		
	}

	@Override
	public MethodVisitor visitMethod(int arg0, String arg1, String arg2,
			String arg3, String[] arg4) {
		MethodVisitor res = null;
		for (ClassVisitor v : m_visitors) {
			if (v == m_visitors[0])
				res = v.visitMethod(arg0, arg1, arg2, arg3, arg4);
			else
				v.visitMethod(arg0, arg1, arg2, arg3, arg4);
		}
		return res;
	}

	@Override
	public void visitOuterClass(String arg0, String arg1, String arg2) {
		for (ClassVisitor v : m_visitors)
			v.visitOuterClass(arg0, arg1, arg2);
	}

	@Override
	public void visitSource(String arg0, String arg1) {
		for (ClassVisitor v : m_visitors)		
			v.visitSource(arg0, arg1);
	}
}
