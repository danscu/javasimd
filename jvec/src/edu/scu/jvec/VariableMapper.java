package edu.scu.jvec;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.Pair;
import cn.edu.sjtu.jllvm.VMCore.Argument;

public class VariableMapper {
	/**
	 * Template for variable mapping. Used for
	 * Java type to JNI type mapping.
	 */
	class ArgMapTempl {
		public String javaType;
		public String jniType;
		
		/**
		 * Constructor.
		 * @param _srcType
		 * @param _dstType
		 */
		public ArgMapTempl(String _srcType, String _dstType)
		{
			javaType = _srcType;
			jniType = _dstType;
		}
	}
	
	/**
	 * Represents a variable mapping.
	 */
	class ArgMap extends Pair<Argument,Argument> {
		public ArgMap(Argument a, Argument b)
		{
			super(a, b);
		}
	};
	
	/**
	 * Java to JNI mapping templates
	 */
	protected List<ArgMapTempl> templates;
	
	/**
	 * Map of the current function.
	 */
	protected List<ArgMap> map;
	
	/**
	 * Constructor.
	 */
	public VariableMapper()
	{
		templates = new ArrayList<ArgMapTempl>();
		map = new ArrayList<ArgMap>();
	}
	
	/**
	 * Add a template.
	 * @param javaType
	 * @param jniType
	 */
	public void addTemplate(String javaType, String jniType)
	{
		ArgMapTempl tmpl = new ArgMapTempl(javaType, jniType);
		templates.add(tmpl);
	}
	
	/**
	 * Clears variable map (keep the templates).
	 */
	public void clear()
	{
		map.clear();
	}
	
	/**
	 * Add a concrete mapping without using templates.
	 * @param javaArg
	 * @param jniArg
	 */
	public void addMapping(Argument javaArg, Argument jniArg)
	{
		ArgMap argMap = new ArgMap(javaArg, jniArg);
		map.add(argMap);
	}
	
	/**
	 * Find a mapping for a Java type from the templates.
	 * @param javaType
	 */
	public Argument findMap(Argument javaArg)
	{		
		// TODO
		return javaArg;
	}
	
	/**
	 * Convert a value.
	 */
	public Argument convert(Argument javaArg)
	{
		// TODO
		Argument jniArg = new Argument(null, null, 0, null);
		return jniArg;
	}
}
