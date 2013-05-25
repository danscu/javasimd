package edu.scu.llvm.translate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.misc.Pair;

import cn.edu.sjtu.jllvm.VMCore.BasicBlock;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.LocalVariable;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Types.ArrayType;
import cn.edu.sjtu.jllvm.VMCore.Types.FunctionType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;
import cn.edu.sjtu.jllvm.VMCore.Types.VectorType;
import edu.scu.jjni.aotc.recgen.OpGenerator;
import edu.scu.jjni.aotc.recgen.OpRecognizer;
import edu.scu.jjni.aotc.recgen.Translator;

public class VariableMapper {
	/**
	 * Template for variable mapping. Used for
	 * Java type to JNI type mapping.
	 */
	
	/**
	 * Recognizable variable operations (semantics). These operations can be mapped
	 * from Java type to JNI type with a pair of code recognizer and generator.
	 * 
	 * @author danke
	 */
	public enum Semcode {
		// For argument		
		STORE_ARGUMENT,
		LOAD_ARGUMENT,
		SETUP_JNI_ENV,
				
		// For struct
		GET_STRUCT_BASE, /* convert struct to i8* */		
		GET_STRUCT_ELEM,
		
		// For arrays
		GET_ARRAY_BASE,
		GET_ARRAY_BASE_POST,
		GET_ARRAY_LENGTH,
		GET_ARRAY_LENGTH_POST,
	};
	
	public static abstract class Operator {
		private Semcode op;		
		public Operator(Semcode op) { this.op = op; }
		public Semcode getOpcode() { return op; }
		public abstract List<Instruction> exec(Object... args);
	}
	
	public static class TypeMap {
		public Type javaType;
		public Type jniType;
		
		private Map<Semcode, Operator> ops;
		
		/**
		 * Constructor.
		 * @param _srcType
		 * @param _dstType
		 */
		public TypeMap(Type _srcType, Type _dstType)
		{
			javaType = _srcType;
			jniType = _dstType;
			
			ops = new HashMap<Semcode, Operator>();
		}
		
		public void addOp(Operator op) {
			ops.put(op.getOpcode(), op);
		}
		
		public List<Instruction> translateOp(Semcode opcode, Object... args) {
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
	 * Function argument list
	 */
	protected List<String> localArgumentList;
	
	/**
	 * Variable map of the current function.
	 */
	protected Map<String, Constant> varMap;
	
	/**
	 * Recognizer
	 */
	protected List<Translator> translators;	
	
	/**
	 * Matcher
	 */
	protected InstMatcher matcher;	
	
	/**
	 * Local generator variable ID
	 */
	protected int genVarId;
	
	/**
	 * Local recognizer variable ID
	 */
	protected int recVarId;
	
	/**
	 * Constructor.
	 */
	public VariableMapper()
	{
		globalTypeMap = new ArrayList<TypeMap>();
		localTypeMap = new ArrayList<TypeMap>();
		localArgumentList = new ArrayList<String>();
		varMap = new HashMap<String, Constant>();
		translators = new ArrayList<Translator>();
		matcher = new InstMatcher();
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
	
	public void addTranslator(Translator trn) {
		translators.add(trn);
		trn.setMapper(this);
	}
	
	/**
	 * Clears variable and local templates (keep the global template).
	 */
	public void clear()
	{
		localTypeMap.clear();
		varMap.clear();
		genVarId = recVarId = 0;
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
	 * Add a local variable mapping by string. Internally, prefix the string
	 * by '$'
	 */
	public void addVarMap(String refName, String localVarName)
	{
		varMap.put(refName, new LocalVariable(localVarName));
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
		
		// 3. Search recognizer-generator map
		for (Translator trn: translators) {
			OpRecognizer opr = trn.getOpr();
			OpGenerator opg = trn.getOpg();
			if (opr != null && opg != null &&
					opr.getTypeIn() != null && opr.getTypeIn().equals(javaArg))
				return opg.getTypeIn();
		}
		
		// 4. Types without conversion
		if (javaArg.isPrimType())
			return javaArg;
		
		// 5.1 Recursively solve Array type
		if (javaArg.getTypeID() == Type.ArrayTyID) {
			ArrayType vType = (ArrayType)javaArg;
			Type mappedSubtype = mapType(vType.getSubTypes().get(0));			
			if (mappedSubtype != null) {
				Type newPointerType = TypeFactory.getArrayType(vType.getLength(), mappedSubtype);
				return newPointerType;
			}
		}
		
		// 5.2 Resolve pointer type recursively
		if (javaArg.isPointerType()) {
			Type mappedSubtype = mapType(javaArg.getSubType());
			if (mappedSubtype != null) {
				Type newPointerType = TypeFactory.getPointerType(mappedSubtype);
				return newPointerType;
			}
		}
		
		// 5.3 Resolve function type recursively. It does not yet do functionType
		// mapping, just checking all the subtypes are valid
		if (javaArg.isFunctionType()) {
			FunctionType fType = (FunctionType)javaArg;
			for (Type subtype : fType.getSubTypes()) {
				Type mappedSubtype = mapType(subtype);
				if (mappedSubtype == null)
					return null;
			}
			return fType;
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
	 * Convert a value. If  <code>strict</code> is true, then throw an error
	 * if refName is not found.
	 */
	public Constant mapVariable(String refName, boolean strict)
	{
		Constant mapped = varMap.get(refName);
		if (mapped != null)
			return mapped;
		else if (strict)
			throw new RuntimeException("Unknown refname for local variable");
		else
			return null;
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

	/**
	 * Recognizes operation patterns and convert to new instructions
	 * @param cleanupBlock 
	 * @param bs BasicBlock to search
	 */
	public void mapOperations(List<Instruction> insList, BasicBlock initBlock,
			BasicBlock cleanupBlock) {
		for (Translator trn: translators) {
			if (trn.getOpr() != null && trn.getOpr().getSemc() == Semcode.GET_ARRAY_BASE_POST)
				System.out.println("Testing arraybase post");
			
			if (trn.getOpr() != null)
				matcher.matchAndModify(trn, insList, initBlock, cleanupBlock);
		}
	}
	
	public void addInitCode(List<Instruction> insList) {
		for (Translator trn: translators) {
			if (trn.getOpr() == null) // unconditional generator
				trn.getOpg().insertInit(trn, insList, insList.listIterator());
		}
	}
	
	public void addCleanupCode(List<Instruction> insList) {
		for (Translator trn: translators) {
			if (trn.getOpr() == null && trn.getOpg() != null) // unconditional generator
				trn.getOpg().insertCleanup(trn, insList,
						insList.listIterator(insList.size()));
		}
	}
	
	public List<String> getFuncArg() {
		return localArgumentList;
	}
	
	public void clearFuncArg() {
		localArgumentList.clear();
	}
	
	public void addFuncArg(String string) {
		localArgumentList.add(string);
	}

	public boolean isFuncArg(String string) {
		return localArgumentList.contains(string);
	}

	public String getGenTmpName() {		
		return OpGenerator.getTmpName(genVarId++);
	}

	public String getRecTmpName() {
		return OpRecognizer.getMatchName(recVarId++);
	}
}
