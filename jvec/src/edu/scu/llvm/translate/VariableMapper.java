package edu.scu.llvm.translate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.Pair;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;

public class VariableMapper {
	/**
	 * Template for variable mapping. Used for
	 * Java type to JNI type mapping.
	 */
	
	public enum Opcode {
		READ,	// javaType -> jniType
		WRITE,	// jniType -> javaType
		DESTRUCT, // clear up jniType
		
		// For struct
		GET_STRUCT_ELEM,
		
		// For arrays
		GET_ARRAY_BASE,
		GET_ARRAY_LENGTH,
	};
	
	/**
	 * Define a pattern of instructions to implement an operation on a type.
	 * In the inserted instruction the dest variable names follow the pattern
	 * %R.i where i = 0, 1, 2, ..., N. It must be strictly sequential in the
	 * pattern, but it will match any variable name in the function.
	 * 
	 * The output value %R.N has the type typeOut
	 * 
	 * @author danke
	 */
	public static class OpRecognizer {
		protected Opcode op;
		protected Type typeIn;
		protected Type typeOut;
		List<Instruction> seq;
		Map<String, String> match;
		
		public OpRecognizer(Opcode op, Type typeIn, Type typeOut) {
			this.op = op;
			this.typeIn = typeIn;
			this.typeOut = typeOut;
			seq = new ArrayList<Instruction>();
			match = new HashMap<String, String>();
		}
		
		/**
		 * Use this function to generate temporary variable names for
		 * the destination of the instructions.
		 * 
		 * @param n The sequential 
		 * @return the destination variable name
		 */
		public static String getTmpName(int n) {
			return String.format("%%R.%d", n);
		}
		
		/**
		 * Use this function to generate variable names to match specific
		 * operands in the instructions
		 * @param m
		 * @return the matching variable name
		 */
		public static String getMatchName(String id) {
			return String.format("%%RM.%s", id);
		}
		
		public void addInstruction(Instruction inst) {
			seq.add(inst);
		}
		
		public String getMatchContent(String id) {
			return match.get(id);
		}		
	}
	
	/**
	 * Define a sequence of instructions for one operation.
	 * @author danke
	 */
	public static class OpGenerator {
		protected Opcode op;
		protected Type typeIn;
		protected Type typeOut;
		List<Instruction> seq;
		List<Instruction> destructor;
		
		public OpGenerator(Opcode op, Type typeIn, Type typeOut) {
			this.op = op;
			this.typeIn = typeIn;
			this.typeOut = typeOut;
			seq = new ArrayList<Instruction>();
		}
		
		/**
		 * Use this function to generate temporary variable names in the 
		 * pattern. In the actual generated code, the variable names will be
		 * automatically renamed.
		 * 
		 * @param n The sequential 
		 * @return the variable name
		 */
		public static String getTmpName(int n) {
			return String.format("%%R.%d", n);
		}
		
		public void addInstruction(Instruction inst) {
			seq.add(inst);
		}
		
		/**
		 * Use this to define operations to release resources
		 * @param inst
		 */
		public void addDestuctorInst(Instruction inst) {			
			if (destructor == null)
				destructor = new ArrayList<Instruction>();
			destructor.add(inst);
		}
	}
	
	public static abstract class Operator {
		private Opcode op;		
		public Operator(Opcode op) { this.op = op; }
		public Opcode getOpcode() { return op; }
		public abstract List<Instruction> exec(Object... args);
	}
	
	public static class TypeMap {
		public Type javaType;
		public Type jniType;
		
		private Map<Opcode, Operator> ops;
		
		/**
		 * Constructor.
		 * @param _srcType
		 * @param _dstType
		 */
		public TypeMap(Type _srcType, Type _dstType)
		{
			javaType = _srcType;
			jniType = _dstType;
			
			ops = new HashMap<Opcode, Operator>();
		}
		
		public void addOp(Operator op) {
			ops.put(op.getOpcode(), op);
		}
		
		public List<Instruction> translateOp(Opcode opcode, Object... args) {
			Operator op = ops.get(opcode);
			if (op == null)
				return null;
			return op.exec(args);
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
	 * @return the map for adding more ops
	 */
	public TypeMap addGlobalTypeMap(Type javaType, Type jniType)
	{
		TypeMap tmap = new TypeMap(javaType, jniType);
		globalTypeMap.add(tmap);
		return tmap;
	}
	
	/**
	 * Add a local template.
	 * @param javaType
	 * @param jniType
	 * @return the map for adding more ops
	 */
	public TypeMap addLocalTypeMap(Type javaType, Type jniType)
	{
		TypeMap tmap = new TypeMap(javaType, jniType);
		localTypeMap.add(tmap);
		return tmap;
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
