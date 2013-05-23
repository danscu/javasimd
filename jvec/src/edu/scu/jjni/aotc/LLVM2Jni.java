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
import edu.scu.jjni.aotc.recgen.Translator;
import edu.scu.llvm.asm.InstFactory;
import edu.scu.llvm.translate.FunctionConverter;
import edu.scu.llvm.translate.VariableMapper;
import edu.scu.llvm.translate.VariableMapper.Semcode;
import edu.scu.llvm.translate.WildcardConstant;
import edu.scu.llvm.translate.WildcardType;

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
	
	static InstFactory fac = new InstFactory();
	static ValueFactory vfac = new ValueFactory();	
	
	static public Type envType;
	static public Type envTypePtr;
	static public Type envTypePtrPtr;
	static public Type typeNullStruct;
	static public Type typeNullStructPtr;
	static public Type typeNullStructPtrPtr;
	
	protected static void addArgStoreRecognizer(VariableMapper mapper) {		
		// 1st recognizer
		OpRecognizer argStoreRec = new OpRecognizer(VariableMapper.Semcode.STORE_ARGUMENT,
				null, null);
		Translator trn = new Translator(argStoreRec, null);
		mapper.addTranslator(trn);

		int wildNo = 0;
		
		Type anyType = new WildcardType(OpRecognizer.getMatchName(wildNo++));
		Type anyTypePtr = TypeFactory.getPointerType(anyType);
		
		// store i32 %unnamed_arg2, i32* %unnamed_arg_addr1, align 1
		Constant pArg = new WildcardConstant(OpRecognizer.getPublicVar("argName"));
		Constant pArgAddr = new WildcardConstant(OpRecognizer.getMatchName("argAddr"));
		Instruction ins = fac.createLoadStoreInst(null /* dest */, InstType.storeInst,
				// env_addr will be provided by associated recognizer
				Arrays.asList(new Constant[] { pArg, pArgAddr }),
				Arrays.asList(new Type[] { anyType, anyTypePtr }),
				false /* volatile */);
		argStoreRec.addInstruction(ins);
		argStoreRec.addPublicVar(pArgAddr.getValue());
		
		// 2nd recognizer
		OpRecognizer argLoadRec = new OpRecognizer(VariableMapper.Semcode.LOAD_ARGUMENT,
				null, null);
		trn = new Translator(argLoadRec, null);
		mapper.addTranslator(trn);
		
		// %0 = load i32* %unnamed_arg_addr1, align 4
		pArgAddr = new WildcardConstant(OpRecognizer.getPublicVar("argAddr"));
		Constant pArgLocal = new WildcardConstant(OpRecognizer.getMatchName("argLocal"));
		ins = fac.createLoadStoreInst(pArgLocal /* dest */, InstType.loadInst,
				// env_addr will be provided by associated recognizer
				Arrays.asList(new Constant[] { pArgAddr }),
				Arrays.asList(new Type[] { anyTypePtr }),
				false /* volatile */);
		argLoadRec.addInstruction(ins);
		argLoadRec.addPublicVar(pArgLocal.getValue());
	}

	protected static void addStructElemTranslator(VariableMapper mapper) {
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
		Translator trn = new Translator(elemOpRec, elemOpGen);
		mapper.addTranslator(trn);
		
		int destNo = 0;
		
		// %1 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*
		Constant pObject = new LocalVariable(OpRecognizer.getMatchName(destNo++));		
		Instruction ins = fac.createOperationInst(pObject, InstType.converInst,
				Arrays.asList(new Constant[] { new WildcardConstant(OpRecognizer.getPublicVar("argLocal")) }),
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
		FunctionType arrayBaseFType = (FunctionType) TypeFactory.getFunctionType(
				Arrays.asList(new Type[] {
						i32_t, typeNullStructPtr, pi8_t, pi8_t
		}));
	
		Constant env_addr = new WildcardConstant(OpRecognizer.getMatchName("env_addr"));
		Constant iscopy = new WildcardConstant(OpRecognizer.getMatchName("is_copy"));
		
		JniEnvCallGen arrayBaseGen = new JniEnvCallGen(Semcode.GET_ARRAY_BASE,
				elemOpRec, null, pi8_t, env_addr, JNIFunc_GetIntArrayElements,
				arrayBaseFType /* funcType */,
				Arrays.asList(new Type[] {envTypePtrPtr})/* list types */,
				Arrays.asList(new Constant[] {env_addr})/* list args */);
		elemOpGen.addGenerator(1 /* elem 1 */, arrayBaseGen);
		
		FunctionType arrayLenFType = (FunctionType) TypeFactory.getFunctionType(
				Arrays.asList(new Type[] {
						i32_t, typeNullStructPtr, pi8_t, 
		}));

		// call i32 %6(%struct.JNINativeInterface_** %0, i8* %1) nounwind		
		JniEnvCallGen arrayLenGen = new JniEnvCallGen(Semcode.GET_ARRAY_LENGTH,
				elemOpRec, null, pi8_t, env_addr, JNIFunc_GetIntArrayLength,
				arrayBaseFType /* funcType */,
				Arrays.asList(new Type[] {envTypePtrPtr, pi8_t})/* list types */,
				Arrays.asList(new Constant[] { env_addr, iscopy })/* list args */);
		elemOpGen.addGenerator(2 /* elem 2 */, arrayLenGen);
	}
	
	private static VariableMapper getJNIMapper() {
		VariableMapper mapper = new VariableMapper();
		
		envType = new Type(Type.StructTyID, "%struct.JNINativeInterface_");
		envTypePtr = TypeFactory.getPointerType(envType);
		envTypePtrPtr = TypeFactory.getPointerType(envTypePtr);
		
		typeNullStruct = TypeFactory.getStructType(null);
		typeNullStructPtr = TypeFactory.getPointerType(typeNullStruct);
		typeNullStructPtrPtr = TypeFactory.getPointerType(typeNullStructPtr);

		addArgStoreRecognizer(mapper);
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
