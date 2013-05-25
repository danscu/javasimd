package edu.scu.jjni.aotc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
import edu.scu.jjni.aotc.recgen.JniEnvSetupGen;
import edu.scu.jjni.aotc.recgen.OpGenerator;
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
	static public Type typeJavaObject;
	static public Type typeJavaObjectPtr;
	
	static public Type i8_t = TypeFactory.getIntNType(8);
	static public Type pi8_t = TypeFactory.getPointerType(i8_t);
	static public Type i32_t = TypeFactory.getInt32Type();
	static public Type pi32_t = TypeFactory.getPointerType(i32_t);
	
	static public Type type4xi8 = TypeFactory.getArrayType(4, i8_t);
	static public Type type4xi8Ptr = TypeFactory.getPointerType(type4xi8);
	
	static public Type type0xi32 = TypeFactory.getArrayType(0, i32_t);
	static public Type type0xi32Ptr = TypeFactory.getPointerType(type0xi32);	
	
	protected static void addEnvSetupGenerator(VariableMapper mapper) {
		// 1st recognizer
		OpGenerator envSetupGen = new JniEnvSetupGen(VariableMapper.Semcode.SETUP_JNI_ENV,
				null, null);
		Translator trn = new Translator(null, envSetupGen);
		mapper.addTranslator(trn);
	}
	
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
		Constant pArg = new WildcardConstant(Translator.publicVarName("argName"));
		Constant pArgAddr = new WildcardConstant(OpRecognizer.newWildcard("argAddr"));
		Instruction ins = fac.createLoadStoreInst(null /* dest */, InstType.storeInst,
				// env_addr will be provided by associated recognizer
				Arrays.asList(new Constant[] { pArg, pArgAddr }),
				Arrays.asList(new Type[] { anyType, anyTypePtr }),
				false /* volatile */);
		argStoreRec.addInstruction(ins);
		argStoreRec.addPublicVar(pArgAddr);
		
		// 2nd recognizer
		OpRecognizer argLoadRec = new OpRecognizer(VariableMapper.Semcode.LOAD_ARGUMENT,
				null, null);
		trn = new Translator(argLoadRec, null);
		mapper.addTranslator(trn);
		
		// %0 = load i32* %unnamed_arg_addr1, align 4
		pArgAddr = new WildcardConstant(Translator.publicVarName("argAddr"));
		Constant pArgLocal = new WildcardConstant(OpRecognizer.newWildcard("argLocal"));
		ins = fac.createLoadStoreInst(pArgLocal /* dest */, InstType.loadInst,
				// env_addr will be provided by associated recognizer
				Arrays.asList(new Constant[] { pArgAddr }),
				Arrays.asList(new Type[] { anyTypePtr }),
				false /* volatile */);
		argLoadRec.addInstruction(ins);
		argLoadRec.addPublicVar(pArgLocal);
	}

	protected static void addStructElemTranslator(VariableMapper mapper) {
		// Initialize the mapper with rich type support
		Type javaStructBase = new Type(Type.StructTyID, "%\"struct.int[]\""); // TODO handle the wild card by the matcher
		Type javaStructPtr = TypeFactory.getPointerType(javaStructBase);

		Type javaObjectArrayBase = new Type(Type.StructTyID, "%\"struct.java.lang.Object[]\"");
		Type javaObjectArrayPtr = TypeFactory.getPointerType(javaObjectArrayBase);
		
		//// Object base conversion recognizer
		OpRecognizer arrayToi8Rec = new OpRecognizer(VariableMapper.Semcode.GET_STRUCT_BASE,
				javaStructPtr, pi8_t);
		Translator trn = new Translator(arrayToi8Rec, /*
				new OpGenerator(VariableMapper.Semcode.GET_STRUCT_BASE,
						arrayToi8Rec, null, null)); */ null); /* eraser */
		mapper.addTranslator(trn);
		
		// %1 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*
		Constant pObject = new LocalVariable(trn.getRecTmpName());
		Instruction ins = fac.createOperationInst(pObject, InstType.converInst,
				Arrays.asList(new Constant[] { new WildcardConstant(Translator.publicVarName("argLocal")) }),
				Arrays.asList(new Type[] { javaStructPtr, typeJavaObjectPtr}),
				"bitcast");
		arrayToi8Rec.addInstruction(ins);
		
		// %2 = bitcast %struct.java.lang.Object* %1 to i8*
		Constant pi8 = new WildcardConstant(OpRecognizer.newWildcard("objBase"));
		ins = fac.createOperationInst(pi8, InstType.converInst,
				Arrays.asList(new Constant[] { pObject }),
				Arrays.asList(new Type[] { typeJavaObjectPtr, pi8_t }),
				"bitcast");
		arrayToi8Rec.addInstruction(ins);
		arrayToi8Rec.addPublicVar(pi8);
		
		//// Object operation recognizer
		OpRecognizer elemOpRec = new OpRecognizer(VariableMapper.Semcode.GET_STRUCT_ELEM,
				javaStructPtr, type0xi32Ptr);
		ArrayAccessGen elemOpGen = new ArrayAccessGen(VariableMapper.Semcode.GET_STRUCT_ELEM, elemOpRec,
				pi8_t, type0xi32Ptr);
		Translator trnStructElem = new Translator(elemOpRec, elemOpGen);
		mapper.addTranslator(trnStructElem);
		
		Constant objBase = new WildcardConstant(Translator.publicVarName("objBase"));
		Type arrayType = new WildcardType(OpRecognizer.newWildcard("arrayType"));
		Type arrayPtrType = TypeFactory.getPointerType(arrayType);
		
		// %3 = bitcast i8* %2 to %"struct.int[]"*
		Constant pStruct = new LocalVariable(trn.getRecTmpName());
		ins = fac.createOperationInst(pStruct, InstType.converInst,			
				Arrays.asList(new Constant[] { objBase }),
				Arrays.asList(new Type[] { pi8_t, arrayPtrType }),
				"bitcast");
		elemOpRec.addInstruction(ins);
		
		// %4 = getelementptr inbounds %"struct.int[]"* %3, i32 0, i32 <elem_no>
		Constant pElem = new WildcardConstant(OpRecognizer.newWildcard("objElemPtr")); // publishable
		ins = fac.createGetElePtrInst(pElem, InstType.getElePtrInst,
				Arrays.asList(new Constant[] { pStruct, vfac.createConstantValue(SimpleConstantValue.intConst, "0"),
						new WildcardConstant(OpRecognizer.newWildcard("elem_no")) }),
				Arrays.asList(new Type[] { arrayPtrType, i32_t, i32_t}),
				true /* inbounds */);
		elemOpRec.addInstruction(ins);
		elemOpRec.addPublicVar(pElem);
		
		/*
		 *  Array element access generator (JNI call part)
		 *
		 *     1. Array Length
		 */
		
		// Get existing public vars
		Constant env_addr = new WildcardConstant(Translator.publicVarName("localEnv"));	
		Constant iscopy = new WildcardConstant(Translator.publicVarName("isCopy"));
		
		// Array access generators
		FunctionType arrayLenFType = (FunctionType) TypeFactory.getFunctionType(
				Arrays.asList(new Type[] {
						pi32_t /* ret type */, envTypePtrPtr, pi8_t, 
		}));
		
		List<Instruction> extraInstr = new LinkedList<Instruction>();
		
		JniEnvCallGen arrayLenJniGen = new JniEnvCallGen(Semcode.GET_ARRAY_LENGTH,
				elemOpRec, null, pi8_t, env_addr, JNIFunc_GetIntArrayLength,
				arrayLenFType /* funcType */,
				null/* list types */,
				null/* list args */,
				extraInstr);
		elemOpGen.addGenerator(1 /* elem 1 */, arrayLenJniGen);
		
		/*
		 *     2. Array base
		 */		
		FunctionType arrayBaseFType = (FunctionType) TypeFactory.getFunctionType(
				Arrays.asList(new Type[] {
						pi32_t /* ret type */, envTypePtrPtr, pi8_t, pi8_t
		}));			

		extraInstr = new LinkedList<Instruction>();
		// call i32 %6(%struct.JNINativeInterface_** %0, i8* %1) nounwind		
		JniEnvCallGen arrayBaseJniGen = new JniEnvCallGen(Semcode.GET_ARRAY_BASE,
				elemOpRec, null, pi8_t, env_addr, JNIFunc_GetIntArrayElements,
				arrayBaseFType /* funcType */,
				Arrays.asList(new Type[] {pi8_t})/* list types */,
				Arrays.asList(new Constant[] { iscopy })/* list args */,
				extraInstr);
		elemOpGen.addGenerator(2 /* elem 2 */, arrayBaseJniGen);		
		
		/*
		 *  Array element access recognizer (process JNI call result)
		 *  
		 *     1. Array Base
		 *     
		 *  JNI env call result is returned in 'jniCallRes'
		 */
		
		OpRecognizer arrayBaseRec = new OpRecognizer(VariableMapper.Semcode.GET_ARRAY_BASE_POST,
				javaStructPtr, type0xi32Ptr);
		// %5 = bitcast [4 x i8]* %4 to [0 x i32]*
		pElem = new WildcardConstant(Translator.publicVarName("objElemPtr")); // published
		Constant pArrayBaseAddr = new WildcardConstant(OpRecognizer.newWildcard("arrayBasePtr")); // publishable
		ins = fac.createOperationInst(pArrayBaseAddr, InstType.converInst,
				Arrays.asList(new Constant[] { pElem }),
				Arrays.asList(new Type[] { type4xi8Ptr, type0xi32Ptr}),
				"bitcast");
		arrayBaseRec.addInstruction(ins);
		arrayBaseRec.addPublicVar(pArrayBaseAddr);

		OpGenerator arrayBaseGen = new OpGenerator(VariableMapper.Semcode.GET_ARRAY_BASE_POST, arrayBaseRec,
				null, null) {
				@Override
				public List<Instruction> insert(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					
					// bitcast i32 to [0 x i32]*
					Instruction ins = null;
					Constant pRes = trn.getVar(Translator.publicVarName("jniCallRes"), true);
					Constant arrayAddr = trn.getVar(Translator.publicVarName("arrayBasePtr"), true);
					
					ins = fac.createOperationInst(arrayAddr, InstType.converInst,
							Arrays.asList(new Constant[] { pRes }),
							Arrays.asList(new Type[] { pi32_t, type0xi32Ptr }),
							"bitcast");
					addInstruction(start, ins);
					publishVar(trn, "", arrayAddr.toString());
					return insList;
				}
		};
		
		trn = new Translator(arrayBaseRec, arrayBaseGen);
		trnStructElem.addTranslator(trn);
		
		OpRecognizer arrayBaseRefRec = new OpRecognizer(VariableMapper.Semcode.GET_ARRAY_LENGTH_POST,
				javaStructPtr, type0xi32Ptr);		
		// %8 = load i32* %7, align 8
		pArrayBaseAddr = new WildcardConstant(Translator.publicVarName("arrayBasePtr")); // published
		Constant arrayAddr = new WildcardConstant(OpRecognizer.newWildcard("arrayAddr")); // publishable
		ins = fac.createOperationInst(arrayAddr, InstType.converInst,
				Arrays.asList(new Constant[] { pArrayBaseAddr }),
				Arrays.asList(new Type[] { type0xi32Ptr, pi8_t }),
				"bitcast");
		arrayBaseRefRec.addInstruction(ins);
		arrayBaseRefRec.addPublicVar(arrayAddr);
		
		OpGenerator arrayBaseRefGen = new OpGenerator(VariableMapper.Semcode.GET_ARRAY_LENGTH_POST, arrayBaseRec,
				null, null) {
				@Override
				public List<Instruction> insert(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					
					Instruction ins = null;
					Constant pRes = trn.getVar(Translator.publicVarName("jniCallRes"), true);
					
					// bitcast
					Constant arrayAddr = trn.getVar(Translator.publicVarName("arrayAddr"), true);
					ins = fac.createOperationInst(arrayAddr, InstType.converInst,
							Arrays.asList(new Constant[] { pRes }),
							Arrays.asList(new Type[] { i32_t, type0xi32Ptr }),
							"bitcast");
					addInstruction(start, ins);
					
					return insList;
				}
		};
		
		trn = new Translator(arrayBaseRefRec, arrayBaseRefGen);
		trnStructElem.addTranslator(trn);
	}
	
	private static VariableMapper getJNIMapper() {
		VariableMapper mapper = new VariableMapper();
		
		envType = new Type(Type.StructTyID, "%struct.JNINativeInterface_");
		envTypePtr = TypeFactory.getPointerType(envType);
		envTypePtrPtr = TypeFactory.getPointerType(envTypePtr);
		
		typeNullStruct = TypeFactory.getStructType(null);
		typeNullStructPtr = TypeFactory.getPointerType(typeNullStruct);
		typeNullStructPtrPtr = TypeFactory.getPointerType(typeNullStructPtr);

		typeJavaObject = new Type(Type.StructTyID, "%struct.java.lang.Object");
		typeJavaObjectPtr = TypeFactory.getPointerType(typeJavaObject);		
		
		addEnvSetupGenerator(mapper);
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
