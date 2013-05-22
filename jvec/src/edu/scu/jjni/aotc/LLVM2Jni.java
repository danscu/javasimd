package edu.scu.jjni.aotc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import cn.edu.sjtu.jllvm.VMCore.Module;
import cn.edu.sjtu.jllvm.VMCore.ValueFactory;
import cn.edu.sjtu.jllvm.VMCore.Constants.Constant;
import cn.edu.sjtu.jllvm.VMCore.Constants.LocalVariable;
import cn.edu.sjtu.jllvm.VMCore.Constants.SimpleConstantValue;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;
import cn.edu.sjtu.jllvm.VMCore.Operators.InstType;
import cn.edu.sjtu.jllvm.VMCore.Types.FunctionType;
import cn.edu.sjtu.jllvm.VMCore.Types.Type;
import cn.edu.sjtu.jllvm.VMCore.Types.TypeFactory;
import edu.scu.jjni.aotc.recgen.ArrayAccessGen;
import edu.scu.jjni.aotc.recgen.JniEnvCallGen;
import edu.scu.jjni.aotc.recgen.OpRecognizer;
import edu.scu.llvm.asm.InstFactory;
import edu.scu.llvm.translate.FunctionConverter;
import edu.scu.llvm.translate.VariableMapper;
import edu.scu.llvm.translate.VariableMapper.Semcode;

public class LLVM2Jni extends FunctionConverter {

	private static final String PREAMBLE = "dat/jnipreamble.ll";
	
	/* Indices of functions in %struct.JNINativeInterface_ */
	private static final int JNIFunc_GetIntArrayElements = 187;
	private static final int JNIFunc_GetIntArrayLength = 171;
	
	public LLVM2Jni(Module _module, String[] _functionNames) throws Exception {
		super(_module, _functionNames, getJNIPreamble(), getJNIMapper(), getIgnoreCalls(),
				getIgnoreFAttr());		
	}

	static private String JNIPreamble;
	static private String getJNIPreamble() throws Exception {
		String content = "";
		try {
			content = new Scanner(new File(PREAMBLE)).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open JNI preamble file: " + PREAMBLE);
			throw e;
		}
		return content;
	}
	
	static public Type envType;
	static public Type envTypePtr;
	static public Type envTypePtrPtr;
	static public Type typeNullStruct;
	static public Type typeNullStructPtr;
	static public Type typeNullStructPtrPtr;
	
	protected static void addStructElemTranslator(VariableMapper mapper) {
		InstFactory fac = new InstFactory();
		ValueFactory vfac = new ValueFactory();
		
		// Initialize the mapper with rich type support
		Type javaStructBase = new Type(Type.StructTyID, "%\"struct.int[]\""); // TODO handle the wild card by the matcher
		Type javaStructPtr = TypeFactory.getPointerType(javaStructBase);
		
		Type i8_t = TypeFactory.getIntNType(8);
		Type pi8_t = TypeFactory.getPointerType(i8_t);
		Type i32_t = TypeFactory.getInt32Type();
		
		Type javaObject = new Type(Type.StructTyID, "%struct.java.lang.Object");
		Type javaObjectPtr = TypeFactory.getPointerType(javaObject);
		
		Type type4xi8 = TypeFactory.getArrayType(4, i8_t);
		Type type4xi8Ptr = TypeFactory.getPointerType(type4xi8);
		
		Type type0xi32 = TypeFactory.getArrayType(0, i32_t);
		Type type0xi32Ptr = TypeFactory.getPointerType(type0xi32);
		
		// Create recognizer
		OpRecognizer elemOpRec = new OpRecognizer(VariableMapper.Semcode.GET_STRUCT_ELEM,
				javaStructPtr, type0xi32Ptr);
		ArrayAccessGen elemOpGen = new ArrayAccessGen(VariableMapper.Semcode.GET_STRUCT_ELEM, elemOpRec,
				pi8_t, type0xi32Ptr);
		mapper.addTranslator(elemOpRec, elemOpGen);
		
		int destNo = 0;
		
		// %1 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*
		Constant pObject = new LocalVariable(OpRecognizer.getMatchName(destNo++));		
		Instruction ins = fac.createOperationInst(pObject, InstType.converInst,
				Arrays.asList(new Constant[] { new LocalVariable(OpRecognizer.getMatchName("array_addr")) }),
				Arrays.asList(new Type[] { javaStructPtr, javaObjectPtr}),
				"bitcast");
		elemOpRec.addInstruction(ins);
		
		// %2 = bitcast %struct.java.lang.Object* %1 to i8*
		Constant pi8 = new LocalVariable(OpRecognizer.getMatchName(destNo++));		
		ins = fac.createOperationInst(pi8, InstType.converInst,				
				Arrays.asList(new Constant[] { pObject }),
				Arrays.asList(new Type[] { javaObjectPtr, pi8_t }),
				"bitcast");
		elemOpRec.addInstruction(ins);
		
		// %3 = bitcast i8* %2 to %"struct.int[]"*
		Constant pStruct = new LocalVariable(OpRecognizer.getMatchName(destNo++));
		ins = fac.createOperationInst(pStruct, InstType.converInst,			
				Arrays.asList(new Constant[] { pi8 }),
				Arrays.asList(new Type[] { pi8_t, javaStructPtr}),
				"bitcast");
		elemOpRec.addInstruction(ins);
		
		// %4 = getelementptr inbounds %"struct.int[]"* %3, i32 0, i32 2
		Constant pElem = new LocalVariable(OpRecognizer.getMatchName(destNo++));
		ins = fac.createGetElePtrInst(pElem, InstType.getElePtrInst,			
				Arrays.asList(new Constant[] { pStruct, vfac.createConstantValue(SimpleConstantValue.intConst, "0"),
						new LocalVariable(OpRecognizer.getMatchName("elem_no")) }),
				Arrays.asList(new Type[] { javaStructPtr, i32_t, i32_t}),
				true /* inbounds */);
		elemOpRec.addInstruction(ins);
		
		// %5 = bitcast [4 x i8]* %4 to [0 x i32]*
		Constant pBaseAddr = new LocalVariable(OpRecognizer.getMatchName(destNo++));
		ins = fac.createOperationInst(pBaseAddr, InstType.converInst,
				Arrays.asList(new Constant[] { pElem }),
				Arrays.asList(new Type[] { type4xi8Ptr, type0xi32Ptr}),
				"bitcast");
		
		// Array access generators
		FunctionType arrayBaseFType = (FunctionType) TypeFactory.getFunctionType(Arrays.asList(new Type[] {
				i32_t, typeNullStructPtr, pi8_t
		}));
		
		JniEnvCallGen arrayBaseGen = new JniEnvCallGen(Semcode.GET_ARRAY_BASE,
				elemOpRec, null, pi8_t, "array_length" /* todo */, JNIFunc_GetIntArrayElements,
				arrayBaseFType /* funcType */, null /* list types */, null /* list args */);
		elemOpGen.addGenerator(1 /* elem 1 */, arrayBaseGen);
		
		JniEnvCallGen arrayLenGen = new JniEnvCallGen(Semcode.GET_ARRAY_LENGTH,
				elemOpRec, null, pi8_t, "array_addr" /* todo */, JNIFunc_GetIntArrayLength,
				arrayBaseFType /* funcType */, null /* list types */, null /* list args */);
		elemOpGen.addGenerator(2 /* elem 2 */, arrayLenGen);
	}

	/*
	protected static void addArrayTransform(VariableMapper mapper) {		
		// Initialize the mapper with rich type support
		Type javaArrayIntBase = new Type(Type.StructTyID, "%\"struct.int[]\"");
		Type javaArrayInt = TypeFactory.getPointerType(javaArrayIntBase);
		
		Type jniArrayIntBase = TypeFactory.getInt8Type();
		Type jniArrayInt = TypeFactory.getPointerType(jniArrayIntBase);			
		
		VariableMapper.TypeMap tmArrayInt = mapper.addGlobalTypeMap(javaArrayInt, jniArrayInt);		
		
		tmArrayInt.addOp(
				new VariableMapper.Operator(VariableMapper.Opcode.READ) {
					@Override
					public List<Instruction> exec(Object... args) {
						return null;
					}
				}
				);
	}
	*/
	
	private static VariableMapper getJNIMapper() {
		VariableMapper mapper = new VariableMapper();
		
		envType = new Type(Type.StructTyID, "%struct.JNINativeInterface_");
		envTypePtr = TypeFactory.getPointerType(envType);
		envTypePtrPtr = TypeFactory.getPointerType(envTypePtr);
		
		typeNullStruct = TypeFactory.getStructType(null);
		typeNullStructPtr = TypeFactory.getPointerType(typeNullStruct);
		typeNullStructPtrPtr = TypeFactory.getPointerType(typeNullStructPtr);
		
		addStructElemTranslator(mapper);
		
		return mapper;
	}
	
	private static List<String> getIgnoreCalls() {
		List<String> ignoreCalls = new ArrayList<String>();
		ignoreCalls.add("@llvm.dbg.declare");
		return ignoreCalls;
	}
	
	private static List<String> getIgnoreFAttr() {
		List<String> ignoreFAttr = new ArrayList<String>();
		ignoreFAttr.add("uwtable");
		return ignoreFAttr;
	}
}
