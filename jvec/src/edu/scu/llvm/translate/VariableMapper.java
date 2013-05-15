package edu.scu.llvm.translate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.Pair;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;

public class VariableMapper {
	/**
	 * Template for variable mapping. Used for
	 * Java type to JNI type mapping.
	 */
	class TypeMap {
		public Type javaType;
		public Type jniType;
		
		/**
		 * Constructor.
		 * @param _srcType
		 * @param _dstType
		 */
		public TypeMap(Type _srcType, Type _dstType)
		{
			javaType = _srcType;
			jniType = _dstType;
		}
	}
	
	/**
	 * Java to JNI mapping templates for all Java-JNI relations.
	 */
	protected List<TypeMap> globalTypeMap;

	/**
	 * Java to JNI mapping templates for current function.
	 */	
	protected List<TypeMap> localTypeMap;
	
	/**
	 * Variable map of the current function.
	 */
	protected Map<String, Constant> varMap;
	
	/**
	 * Constructor.
	 */
	public VariableMapper()
	{
		globalTypeMap = new ArrayList<TypeMap>();
		localTypeMap = new ArrayList<TypeMap>();
		varMap = new HashMap<String, Constant>();
	}
	
 	/**
	 * Add a global template.
	 * @param javaType
	 * @param jniType
	 */
	public void addGlobalTypeMap(Type javaType, Type jniType)
	{
		TypeMap tmap = new TypeMap(javaType, jniType);
		globalTypeMap.add(tmap);
	}
	
	/**
	 * Add a local template.
	 * @param javaType
	 * @param jniType
	 */
	public void addLocalTypeMap(Type javaType, Type jniType)
	{
		TypeMap tmap = new TypeMap(javaType, jniType);
		localTypeMap.add(tmap);
	}
	
	/**
	 * Clears variable and local templates (keep the global template).
	 */
	public void clear()
	{
		localTypeMap.clear();
		varMap.clear();
	}
	
	/**
	 * Add a local variable mapping
	 * @param javaArg
	 * @param jniArg
	 */
	public void addVarMap(Constant javaArg, Constant jniArg)
	{		
		varMap.put(javaArg.toString(), jniArg);
	}
	
	/**
	 * Find a mapping for a Java type from the templates.
	 * @param javaType
	 */
	public Type mapType(Type javaArg)
	{		
		// 1. Search local type map	
		for (TypeMap tm : localTypeMap)
			if (tm.javaType.equals(javaArg))
				return tm.jniType;
		
		// 2. Search global type map
		for (TypeMap tm : globalTypeMap)
			if (tm.javaType.equals(javaArg))
				return tm.jniType;											
		
		// 3. Types without conversion
		if (javaArg.isPrimType())
			return javaArg;
		
		// 4. Resolve pointer type recursively		
		if (javaArg.isPointerType()) {
			Type mappedSubtype = mapType(javaArg.getSubType());
			if (mappedSubtype != null) {
				Type newPointerType = TypeFactory.getPointerType(mappedSubtype);
				return newPointerType;
			}
		}
		
		// Cannot convert the type -- fatal error
		return null;
	}
	
	/**
	 * Convert a value.
	 */
	public Constant mapVariable(Constant javaArg)
	{
		Constant mapped = varMap.get(javaArg.toString());
		if (mapped != null)
			return mapped;
		else
			return javaArg;
	}
	
	/**
	 * Parses GCJ-generated function names.
	 * @param gcjName The function name to convert (e.g., 5Class6MethodEi)
	 * @param parts If not null, the name path is returned as the list (e.g., ["Class", "Method"]).
	 * @return The JNI function name (e.g., Java_Class_Method).
	 */
	public String parseGCJName(String gcjName, List<String> parts) {
		StringBuffer sbLen = new StringBuffer();
		StringBuffer sbResult = new StringBuffer();
		
		int idx;
		boolean first = true;
		
		sbResult.append("Java_");
		if (parts != null)
			parts.clear();
		
		for (idx = 0; idx < gcjName.length(); idx++) {
			char ch = gcjName.charAt(idx);

			if (Character.isDigit(ch))
				sbLen.append(ch);
			else {
				int idLen = Integer.parseInt(sbLen.toString());
				sbLen.setLength(0);
				
				assert(idx + idLen < gcjName.length());
				String id = gcjName.substring(idx, idx + idLen);
				if (!first)
					sbResult.append('_');
				else
					first = false;
				
				sbResult.append(id);
				if (parts != null)
					parts.add(id);
				
				idx += idLen - 1;
				
				assert(idx + 1 < gcjName.length());
				
				if (!Character.isDigit(gcjName.charAt(idx + 1)))
					break; // done scan
			}
		}
		
		return sbResult.toString();
	}
	
	public String convertFuncName(String functionName, List<String> nameParts) {
		// GCJ to JNI
		if (functionName.startsWith("_ZN"))
			return parseGCJName(functionName.substring(3), nameParts);		
		
		return functionName;
	}
}
