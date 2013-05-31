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
	public static final int JNIFunc_ReleaseIntArrayElements = 195;
	
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

	static public Type javaStructBase = new Type(Type.StructTyID, "%\"struct.int[]\""); // TODO handle the wild card by the matcher
	static public Type javaStructPtr = TypeFactory.getPointerType(javaStructBase);

	static public Type javaObjectArrayBase = new Type(Type.StructTyID, "%\"struct.java.lang.Object[]\"");
	static public Type javaObjectArrayPtr = TypeFactory.getPointerType(javaObjectArrayBase);	
	
	static public Type i1_t = TypeFactory.getIntNType(1);
	static public Type i8_t = TypeFactory.getIntNType(8);
	static public Type pi8_t = TypeFactory.getPointerType(i8_t);
	static public Type i32_t = TypeFactory.getInt32Type();
	static public Type i64_t = TypeFactory.getInt64Type();
	static public Type pi32_t = TypeFactory.getPointerType(i32_t);
	
	static public Type type4xi8 = TypeFactory.getArrayType(4, i8_t);
	static public Type type4xi8Ptr = TypeFactory.getPointerType(type4xi8);
	
	static public Type type0xi32 = TypeFactory.getArrayType(0, i32_t);
	static public Type type0xi32Ptr = TypeFactory.getPointerType(type0xi32);	
	
	protected static void addEnvSetupGenerator(VariableMapper mapper) {
		// 1st recognizer
		OpGenerator envSetupGen = new JniEnvSetupGen(VariableMapper.Semcode.SETUP_JNI_ENV,
				null, null);
		Translator trn = new Translator("envSetup", null, envSetupGen);
		mapper.addTranslator(trn);
	}
	
	protected static void addArgStoreRecognizer(VariableMapper mapper) {		
		// 1st recognizer
		OpRecognizer argStoreRec = new OpRecognizer(VariableMapper.Semcode.STORE_ARGUMENT,
				null, null);
		Translator trn = new Translator("argStore", argStoreRec, null);
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
		trn = new Translator("argLoad", argLoadRec, null);
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

	protected static void addObjectRec32bit(VariableMapper mapper, Translator trnStructBase) {
		Instruction ins;
		
		//// Object operation recognizer
		OpRecognizer elemOpRec = new OpRecognizer(VariableMapper.Semcode.GET_STRUCT_ELEM,
				javaStructPtr, type0xi32Ptr);
		ArrayAccessGen elemOpGen = new ArrayAccessGen(VariableMapper.Semcode.GET_STRUCT_ELEM, elemOpRec,
				pi8_t, type0xi32Ptr);
		Translator trnStructElem = new Translator("elemOp32", elemOpRec, elemOpGen);
		trnStructBase.addTranslator(trnStructElem);
		
		Constant objBase = new WildcardConstant(Translator.publicVarName("objBase"));
		Type arrayType = new WildcardType(OpRecognizer.newWildcard("arrayType"));
		Type arrayPtrType = TypeFactory.getPointerType(arrayType);
		
		// %3 = bitcast i8* %2 to %"struct.int[]"*
		Constant pStruct = new LocalVariable(trnStructElem.getRecTmpName());
		ins = fac.createOperationInst(pStruct, InstType.converInst,			
				Arrays.asList(new Constant[] { objBase }),
				Arrays.asList(new Type[] { pi8_t, arrayPtrType }),
				"bitcast");
		elemOpRec.addInstruction(ins);
		
		// %4 = bitcast %"struct.int[]"* %3 to i8*
		Constant pByte = new LocalVariable(trnStructElem.getRecTmpName());
		ins = fac.createOperationInst(pByte, InstType.converInst,
				Arrays.asList(new Constant[] { pStruct }),
				Arrays.asList(new Type[] { arrayPtrType, pi8_t }),
				"bitcast");
		elemOpRec.addInstruction(ins);
		
		// %5 = getelementptr inbounds i8* %4, i32 (<elem_no> * 4)
		Constant pElem = new WildcardConstant(
				OpRecognizer.newWildcard("objElemPtr")); // publishable
		ins = fac.createGetElePtrInst(pElem, InstType.getElePtrInst,
				Arrays.asList(new Constant[] { pByte,
						new WildcardConstant(OpRecognizer.newWildcard("elem_no_byte")) }),
				Arrays.asList(new Type[] { pi8_t, i32_t}),
				true /* inbounds */);
		elemOpRec.addInstruction(ins);
		elemOpRec.addPublicVar(pElem);
		
		addArrayRef1(trnStructElem);
		addArrayRef2(trnStructElem);		
	}
	
	protected static void addObjectRec64bit(VariableMapper mapper, Translator trnStructBase) {
		// Initialize the mapper with rich type support
		Type javaStructBase = new Type(Type.StructTyID, "%\"struct.int[]\""); // TODO handle the wild card by the matcher
		Type javaStructPtr = TypeFactory.getPointerType(javaStructBase);

		Type javaObjectArrayBase = new Type(Type.StructTyID, "%\"struct.java.lang.Object[]\"");
		Type javaObjectArrayPtr = TypeFactory.getPointerType(javaObjectArrayBase);
				
		Instruction ins;
		
		//// Object operation recognizer
		OpRecognizer elemOpRec = new OpRecognizer(VariableMapper.Semcode.GET_STRUCT_ELEM,
				javaStructPtr, type0xi32Ptr);
		ArrayAccessGen elemOpGen = new ArrayAccessGen(VariableMapper.Semcode.GET_STRUCT_ELEM, elemOpRec,
				pi8_t, type0xi32Ptr);
		Translator trnStructElem = new Translator("elemOp64", elemOpRec, elemOpGen);
		trnStructBase.addTranslator(trnStructElem);
		
		Constant objBase = new WildcardConstant(Translator.publicVarName("objBase"));
		Type arrayType = new WildcardType(OpRecognizer.newWildcard("arrayType"));
		Type arrayPtrType = TypeFactory.getPointerType(arrayType);
		
		// %3 = bitcast i8* %2 to %"struct.int[]"*
		Constant pStruct = new LocalVariable(trnStructElem.getRecTmpName());
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
		
		addArrayRef1(trnStructElem);
		addArrayRef2(trnStructElem);
	}
	
	protected static void addObjectRecOptimizedLen(VariableMapper mapper) {
		Instruction ins;
		
		//// Object operation recognizer
		OpRecognizer elemOpRec = new OpRecognizer(VariableMapper.Semcode.GET_STRUCT_ELEM,
				javaStructPtr, type0xi32Ptr);
		ArrayAccessGen elemOpGen = new ArrayAccessGen(VariableMapper.Semcode.GET_STRUCT_ELEM, elemOpRec,
				pi8_t, type0xi32Ptr);
		Translator trnStructElem = new Translator("elemOp32", elemOpRec, elemOpGen);
		mapper.addTranslator(trnStructElem);
		
		Constant argName = new WildcardConstant(Translator.publicVarName("argName"));
		Type arrayType = new WildcardType(OpRecognizer.newWildcard("arrayType"));
		Type arrayPtrType = TypeFactory.getPointerType(arrayType);
		
		// %0 = getelementptr inbounds %"struct.int[]"* %unnamed_arg2, i64 0, i32 1,
		Constant pElem = new WildcardConstant(OpRecognizer.newWildcard("objElemPtr")); // publishable
		ins = fac.createGetElePtrInst(pElem, InstType.getElePtrInst,
				Arrays.asList(new Constant[] { argName,
						vfac.createConstantValue(SimpleConstantValue.intConst, "0"),
						new WildcardConstant(OpRecognizer.newWildcard("elem_no"))
				}),
				Arrays.asList(new Type[] { arrayPtrType, i64_t, i32_t }),
				true /* inbounds */);
		elemOpRec.addInstruction(ins);
		elemOpRec.addPublicVar(pElem);
		
		addArrayRef1(trnStructElem);
		addArrayRef2(trnStructElem);
	}
	
	protected static void addObjectRecOptimizedBase32bit(VariableMapper mapper) {
		Instruction ins;
		
		//// Object operation recognizer
		OpRecognizer elemOpRec = new OpRecognizer(VariableMapper.Semcode.GET_STRUCT_ELEM,
				javaStructPtr, type0xi32Ptr);
		ArrayAccessGen elemOpGen = new ArrayAccessGen(VariableMapper.Semcode.GET_STRUCT_ELEM, elemOpRec,
				pi8_t, type0xi32Ptr);
		Translator trnStructElem = new Translator("elemOp32", elemOpRec, elemOpGen);
		mapper.addTranslator(trnStructElem);
		
		Constant argName = new WildcardConstant(Translator.publicVarName("argName"));
		Type arrayType = new WildcardType(OpRecognizer.newWildcard("arrayType"));
		Type arrayPtrType = TypeFactory.getPointerType(arrayType);
		
		// %3 = getelementptr inbounds %"struct.int[]"* %unnamed_arg2, i32 <elem_no_half>
		Constant pArrayBaseInStruct = new WildcardConstant(OpRecognizer.newWildcard("arrayBasePtrInStruct")); // publishable
		ins = fac.createGetElePtrInst(pArrayBaseInStruct, InstType.getElePtrInst,
				Arrays.asList(new Constant[] { argName,
						new WildcardConstant(OpRecognizer.newWildcard("elem_no_half"))
				}),
				Arrays.asList(new Type[] { arrayPtrType, i32_t }),
				true /* inbounds */);
		elemOpRec.addInstruction(ins);
		elemOpRec.addPublicVar(pArrayBaseInStruct);

		// %4 = bitcast %"struct.int[]"* %3 to i8*
		Constant arrayBasePtr = new WildcardConstant(OpRecognizer.newWildcard("arrayBasePtr")); // publishable
		ins = fac.createOperationInst(arrayBasePtr, InstType.converInst,
				Arrays.asList(new Constant[] { pArrayBaseInStruct }),
				Arrays.asList(new Type[] { arrayPtrType, pi8_t}),
				"bitcast");
		elemOpRec.addInstruction(ins);
		elemOpRec.addPublicVar(arrayBasePtr);
		
		addArrayRef4(trnStructElem);
	}
	
	protected static void addObjectRecOptimizedLen32bit(VariableMapper mapper) {
		Instruction ins;
		
		//// Object operation recognizer
		OpRecognizer elemOpRec = new OpRecognizer(VariableMapper.Semcode.GET_STRUCT_ELEM,
				javaStructPtr, type0xi32Ptr);
		ArrayAccessGen elemOpGen = new ArrayAccessGen(VariableMapper.Semcode.GET_STRUCT_ELEM, elemOpRec,
				pi8_t, type0xi32Ptr);
		Translator trnStructElem = new Translator("elemOp32", elemOpRec, elemOpGen);
		mapper.addTranslator(trnStructElem);
		
		Constant argName = new WildcardConstant(Translator.publicVarName("argName"));
		Type arrayType = new WildcardType(OpRecognizer.newWildcard("arrayType"));
		Type arrayPtrType = TypeFactory.getPointerType(arrayType);
		
		// %0 = getelementptr inbounds %"struct.int[]"* %unnamed_arg2, i64 0, i32 1,
		Constant pElem = new WildcardConstant(OpRecognizer.newWildcard("objElemPtr")); // publishable
		ins = fac.createGetElePtrInst(pElem, InstType.getElePtrInst,
				Arrays.asList(new Constant[] { argName,
						vfac.createConstantValue(SimpleConstantValue.intConst, "0"),
						new WildcardConstant(OpRecognizer.newWildcard("elem_no"))
				}),
				Arrays.asList(new Type[] { arrayPtrType, i32_t, i32_t }),
				true /* inbounds */);
		elemOpRec.addInstruction(ins);
		elemOpRec.addPublicVar(pElem);
		
		addArrayRef1(trnStructElem);
		addArrayRef2(trnStructElem);
	}	
	
	protected static void addObjectRecOptimizedBase(VariableMapper mapper) {
		Instruction ins;
		
		//// Object operation recognizer
		OpRecognizer elemOpRec = new OpRecognizer(VariableMapper.Semcode.GET_STRUCT_ELEM,
				javaStructPtr, type0xi32Ptr);
		ArrayAccessGen elemOpGen = new ArrayAccessGen(VariableMapper.Semcode.GET_STRUCT_ELEM, elemOpRec,
				pi8_t, type0xi32Ptr);
		Translator trnStructElem = new Translator("elemOp32", elemOpRec, elemOpGen);
		mapper.addTranslator(trnStructElem);
		
		Constant argName = new WildcardConstant(Translator.publicVarName("argName"));
		Type arrayType = new WildcardType(OpRecognizer.newWildcard("arrayType"));
		Type arrayPtrType = TypeFactory.getPointerType(arrayType);
		
		// %0 = getelementptr inbounds %"struct.int[]"* %unnamed_arg2, i64 0, i32 2, i64 %7
		Constant pArrayElem = new WildcardConstant(OpRecognizer.newWildcard("arrayElemPtr")); // publishable
		Constant byteIndex = new WildcardConstant(OpRecognizer.newWildcard("byteIndex")); // publishable
		ins = fac.createGetElePtrInst(pArrayElem, InstType.getElePtrInst,
				Arrays.asList(new Constant[] { argName,
						vfac.createConstantValue(SimpleConstantValue.intConst, "0"),
						new WildcardConstant(OpRecognizer.newWildcard("elem_no")),
						byteIndex /* match user array index */
				}),
				Arrays.asList(new Type[] { arrayPtrType, i64_t, i32_t, i64_t }),
				true /* inbounds */);
		elemOpRec.addInstruction(ins);
		elemOpRec.addPublicVar(pArrayElem);
		elemOpRec.addPublicVar(byteIndex);
		
		addArrayRef3(trnStructElem);
	}
	
	protected static void addArrayRef1(Translator trnStructElem) {		
		OpRecognizer elemOpRec = trnStructElem.getOpr();
		ArrayAccessGen elemOpGen = (ArrayAccessGen)trnStructElem.getOpg();
		
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
						i32_t /* ret type */, envTypePtrPtr, pi8_t,
		}));
		
		List<Instruction> extraInstr = new LinkedList<Instruction>();
		
		JniEnvCallGen arrayLenJniGen = new JniEnvCallGen(Semcode.GET_ARRAY_LENGTH,
				elemOpRec, null, pi8_t, env_addr, JNIFunc_GetIntArrayLength,
				true, /* call once at init */
				arrayLenFType /* funcType */,
				null/* list types */,
				null/* list args */,
				extraInstr,
				"jniArrayLen");
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
				true, /* call once at init */
				arrayBaseFType /* funcType */,
				Arrays.asList(new Type[] {pi8_t})/* list types */,
				Arrays.asList(new Constant[] { iscopy })/* list args */,
				extraInstr,
				"jniArrayBase");
		elemOpGen.addGenerator(2 /* elem 2 */, arrayBaseJniGen);		
		
		/*
		 *  Array element access recognizer (process JNI call result)
		 *  
		 *     1. Array Base
		 *     
		 *  JNI env call result is returned in 'jniArrayBase'
		 */
		
		OpRecognizer arrayBaseRec = new OpRecognizer(VariableMapper.Semcode.GET_ARRAY_BASE_POST,
				javaStructPtr, type0xi32Ptr);
		// %5 = bitcast [4 x i8]* %4 to [0 x i32]*
		Constant pElem = new WildcardConstant(Translator.publicVarName("objElemPtr")); // published
		Constant pArrayBaseAddr = new WildcardConstant(OpRecognizer.newWildcard("arrayBasePtr")); // publishable
		Instruction ins = fac.createOperationInst(pArrayBaseAddr, InstType.converInst,
				Arrays.asList(new Constant[] { pElem }),
				Arrays.asList(new Type[] { type4xi8Ptr, type0xi32Ptr}),
				"bitcast");
		arrayBaseRec.addInstruction(ins);
		arrayBaseRec.addPublicVar(pArrayBaseAddr);

		OpGenerator arrayBaseGen = new OpGenerator(VariableMapper.Semcode.GET_ARRAY_BASE_POST, arrayBaseRec,
				null, null) {
				@Override
				public int insert(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					
					// bitcast i32 to [0 x i32]*
					Instruction ins = null;
					Constant pRes = trn.getVar(Translator.publicVarName("jniArrayBase"), true);
				Constant arrayAddr = trn.getVar(
						Translator.publicVarName("arrayBasePtr"), true);
					
					ins = fac.createOperationInst(arrayAddr, InstType.converInst,
							Arrays.asList(new Constant[] { pRes }),
							Arrays.asList(new Type[] { pi32_t, type0xi32Ptr }),
							"bitcast");
					addInstruction(start, ins);
					
					// Be cautious about using arrayBasePtr. It might not dominate the cleanup.
					publishVar(trn, "arrayBasePtr", pRes.toString());
					
					return super.insert(trn, insList, start);
				}
				
				@Override
				public void insertInit(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					Instruction ins;
					
					String jniDoneVariable = Translator.publicVarName("arrayAccessDone" + 
							trn.getSubrecognizerKey());
					Constant jniDone = trn.getVar(jniDoneVariable, false);
					
					if (jniDone == null) {
						Constant tab = trn.getVar(Translator.publicVarName("arrayTab"), true);
						Constant pRes = trn.getVar(Translator.publicVarName("jniArrayBase"), true);
						
						// store returned array base to tab variable
						ins = fac.createLoadStoreInst(null, InstType.storeInst,
								Arrays.asList(new Constant[] { pRes, tab }),
								Arrays.asList(new Type[] { pi32_t, TypeFactory.getPointerType(pi32_t)}),
								false /* volatile */ );
						
						addInstruction(start, ins);
						
						trn.setVar(jniDoneVariable, "1");
					}
				}
		};
		
		Translator trnArrayBase  = new Translator("arrayBaseRef64", arrayBaseRec, arrayBaseGen);
		trnStructElem.addTranslator("2", trnArrayBase);
		
		/*
		 *  Array element access recognizer (process JNI call result)
		 *  
		 *     2. Array length
		 */
		
		OpRecognizer arrayLenRefRec = new OpRecognizer(VariableMapper.Semcode.GET_ARRAY_LENGTH_POST,
				javaStructPtr, type0xi32Ptr);		
		// %8 = load i32* %7, align 8
		pElem = new WildcardConstant(Translator.publicVarName("objElemPtr")); // published
		Constant arrayLen = new WildcardConstant(OpRecognizer.newWildcard("arrayLen")); // publishable
		ins = fac.createLoadStoreInst(arrayLen, InstType.loadInst,
				Arrays.asList(new Constant[] { pElem }),
				Arrays.asList(new Type[] { pi32_t }),
				false /* volatile */ );
		arrayLenRefRec.addInstruction(ins);
		arrayLenRefRec.addPublicVar(arrayLen);
		
		OpGenerator arrayLenRefGen = new OpGenerator(VariableMapper.Semcode.GET_ARRAY_LENGTH_POST, arrayBaseRec,
				null, null) {
				@Override
				public int insert(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					
					Instruction ins = null;
					Constant pRes = trn.getVar(Translator.publicVarName("jniArrayLen"), true);
					
					// no instruction needed, just add a dummy one
					Constant arrayAddr = trn.getVar(Translator.publicVarName("arrayLen"), true);
					ins = fac.createBinaryInst(arrayAddr, InstType.binaryInst,
							Arrays.asList(new Constant[] { pRes, vfac.createConstantValue(SimpleConstantValue.intConst, "0")}),
							Arrays.asList(new Type[] { i32_t, i32_t }),
							"add", "", "", "");
					addInstruction(start, ins);
					
					return super.insert(trn, insList, start);
				}
		};
		
		Translator trnArrayLen = new Translator("arrayLenRef64", arrayLenRefRec, arrayLenRefGen);
		trnStructElem.addTranslator("1", trnArrayLen);		
	}
	
	protected static void addArrayRef2(Translator trnStructElem) {
		OpRecognizer elemOpRec = trnStructElem.getOpr();
		ArrayAccessGen elemOpGen = (ArrayAccessGen)trnStructElem.getOpg();
	
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
						i32_t /* ret type */, envTypePtrPtr, pi8_t,
		}));
		
		List<Instruction> extraInstr = new LinkedList<Instruction>();
		
		JniEnvCallGen arrayLenJniGen = new JniEnvCallGen(Semcode.GET_ARRAY_LENGTH,
				elemOpRec, null, pi8_t, env_addr, JNIFunc_GetIntArrayLength,
				true, /* call once at init */
				arrayLenFType /* funcType */,
				null/* list types */,
				null/* list args */,
				extraInstr,
				"jniArrayLen");
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
				true, /* call once at init */
				arrayBaseFType /* funcType */,
				Arrays.asList(new Type[] {pi8_t})/* list types */,
				Arrays.asList(new Constant[] { iscopy })/* list args */,
				extraInstr,
				"jniArrayBase");
		elemOpGen.addGenerator(2 /* elem 2 */, arrayBaseJniGen);
		
		/*
		 *  Array element access recognizer (process JNI call result)
		 *  
		 *     1. Array Base
		 *     
		 *  JNI env call result is returned in 'jniArrayBase'
		 */
		
		OpRecognizer arrayBaseRec = new OpRecognizer(VariableMapper.Semcode.GET_ARRAY_BASE_POST,
				javaStructPtr, type0xi32Ptr);
		// %5 = bitcast i8* %4 to [0 x i32]*
		Constant pElem = new WildcardConstant(Translator.publicVarName("objElemPtr")); // published
		Constant pArrayBaseAddr = new WildcardConstant(OpRecognizer.newWildcard("arrayBasePtr")); // publishable
		Instruction ins = fac.createOperationInst(pArrayBaseAddr, InstType.converInst,
				Arrays.asList(new Constant[] { pElem }),
				Arrays.asList(new Type[] { pi8_t, type0xi32Ptr}),
				"bitcast");
		arrayBaseRec.addInstruction(ins);
		arrayBaseRec.addPublicVar(pArrayBaseAddr);

		OpGenerator arrayBaseGen = new OpGenerator(VariableMapper.Semcode.GET_ARRAY_BASE_POST, arrayBaseRec,
				null, null) {
				@Override				
				public int insert(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					
					// bitcast i32* to [0 x i32]*
					Instruction ins = null;
					Constant pRes = trn.getVar(Translator.publicVarName("jniArrayBase"), true);
					Constant arrayAddr = trn.getVar(Translator.publicVarName("arrayBasePtr"), true);
					
					ins = fac.createOperationInst(arrayAddr, InstType.converInst,
							Arrays.asList(new Constant[] { pRes }),
							Arrays.asList(new Type[] { pi32_t, type0xi32Ptr }),
							"bitcast");
					addInstruction(start, ins);
					
					// Be cautious about using arrayBasePtr. It might not dominate the cleanup.
					publishVar(trn, "arrayBasePtr", pRes.toString());
					
					return super.insert(trn, insList, start);
				}

				@Override
				public void insertInit(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					Instruction ins;
					
					String jniDoneVariable = Translator.publicVarName("arrayAccessDone" + 
							trn.getSubrecognizerKey());
					Constant jniDone = trn.getVar(jniDoneVariable, false);					
					
					if (jniDone == null) {					
						Constant tab = trn.getVar(Translator.publicVarName("arrayTab"), true);
						Constant pRes = trn.getVar(Translator.publicVarName("jniArrayBase"), true);
						
						// store returned array base to tab variable
						ins = fac.createLoadStoreInst(null, InstType.storeInst,
								Arrays.asList(new Constant[] { pRes, tab }),
								Arrays.asList(new Type[] { pi32_t, TypeFactory.getPointerType(pi32_t)}),
								false /* volatile */ );
						
						addInstruction(start, ins);
						
						trn.setVar(jniDoneVariable, "1");
					}
				}
		};
		
		Translator trnArrayBase  = new Translator("arrayBaseRef32", arrayBaseRec, arrayBaseGen);
		trnStructElem.addTranslator("2", trnArrayBase);
		
		/*
		 *  Array element access recognizer (process JNI call result)
		 *  
		 *     2. Array length
		 */		
		
		OpRecognizer arrayLenRefRec = new OpRecognizer(VariableMapper.Semcode.GET_ARRAY_LENGTH_POST,
				javaStructPtr, type0xi32Ptr);		
		// %8 = load i32* %7, align 8
		pElem = new WildcardConstant(Translator.publicVarName("objElemPtr")); // published
		Constant arrayLen = new WildcardConstant(OpRecognizer.newWildcard("arrayLen")); // publishable
		ins = fac.createLoadStoreInst(arrayLen, InstType.loadInst,
				Arrays.asList(new Constant[] { pElem }),
				Arrays.asList(new Type[] { pi32_t }),
				false /* volatile */ );
		arrayLenRefRec.addInstruction(ins);
		arrayLenRefRec.addPublicVar(arrayLen);
		
		OpGenerator arrayLenRefGen = new OpGenerator(VariableMapper.Semcode.GET_ARRAY_LENGTH_POST, arrayBaseRec,
				null, null) {
				@Override
				public int insert(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					
					Instruction ins = null;
					Constant pRes = trn.getVar(Translator.publicVarName("jniArrayLen"), true);
					
					// no instruction needed, just add a dummy one
					Constant arrayAddr = trn.getVar(Translator.publicVarName("arrayLen"), true);
					ins = fac.createBinaryInst(arrayAddr, InstType.binaryInst,
							Arrays.asList(new Constant[] { pRes, vfac.createConstantValue(SimpleConstantValue.intConst, "0")}),
							Arrays.asList(new Type[] { i32_t, i32_t }),
							"add", "", "", "");
					addInstruction(start, ins);
					
					return super.insert(trn, insList, start);
				}
		};
		
		Translator trnArrayLen = new Translator("arrayLenRef32", arrayLenRefRec, arrayLenRefGen);
		trnStructElem.addTranslator("1", trnArrayLen);		
	}
	
	protected static void addArrayRef3(Translator trnStructElem) {		
		OpRecognizer elemOpRec = trnStructElem.getOpr();
		ArrayAccessGen elemOpGen = (ArrayAccessGen)trnStructElem.getOpg();
		
		// Get existing public vars
		Constant env_addr = new WildcardConstant(Translator.publicVarName("localEnv"));	
		Constant iscopy = new WildcardConstant(Translator.publicVarName("isCopy"));
		
		/*
		 *     Array base (Array length is not possible)
		 */		
		FunctionType arrayBaseFType = (FunctionType) TypeFactory.getFunctionType(
				Arrays.asList(new Type[] {
						pi32_t /* ret type */, envTypePtrPtr, pi8_t, pi8_t
		}));

		List<Instruction> extraInstr = new LinkedList<Instruction>();		
		
		extraInstr = new LinkedList<Instruction>();
		// call i32 %6(%struct.JNINativeInterface_** %0, i8* %1) nounwind
		JniEnvCallGen arrayBaseJniGen = new JniEnvCallGen(Semcode.GET_ARRAY_BASE,
				elemOpRec, null, pi8_t, env_addr, JNIFunc_GetIntArrayElements,
				true, /* call once at init */
				arrayBaseFType /* funcType */,
				Arrays.asList(new Type[] {pi8_t})/* list types */,
				Arrays.asList(new Constant[] { iscopy })/* list args */,
				extraInstr,
				"jniArrayBase");
		elemOpGen.addGenerator(2 /* elem 2 */, arrayBaseJniGen);		
		
		/*
		 *  Array element access recognizer (process JNI call result)
		 *  
		 *      Array Base
		 *     
		 *  JNI env call result is returned in 'jniArrayBase'
		 */
		
		OpRecognizer arrayBaseRec = new OpRecognizer(VariableMapper.Semcode.GET_ARRAY_BASE_POST,
				javaStructPtr, type0xi32Ptr);
		// %5 = bitcast i8* %10 to i32*
		Constant arrayElemPtr = new WildcardConstant(Translator.publicVarName("arrayElemPtr")); // published
		Constant arrayElemPtrTyped = new WildcardConstant(OpRecognizer.newWildcard("arrayElemPtrTyped")); // publishable
		Instruction ins = fac.createOperationInst(arrayElemPtrTyped, InstType.converInst,
				Arrays.asList(new Constant[] { arrayElemPtr }),
				Arrays.asList(new Type[] { pi8_t, pi32_t }),
				"bitcast");
		arrayBaseRec.addInstruction(ins);
		arrayBaseRec.addPublicVar(arrayElemPtrTyped);

		OpGenerator arrayBaseGen = new OpGenerator(VariableMapper.Semcode.GET_ARRAY_BASE_POST, arrayBaseRec,
				null, null) {
				@Override
				public int insert(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					
					Instruction ins = null;
					Constant pElem = trn.getVar(Translator.publicVarName("arrayElemPtrTyped"), true);
					Constant byteIndex = trn.getVar(Translator.publicVarName("byteIndex"), true);
					Constant intIndex = new LocalVariable(trn.getGenTmpName());
					
					// Divide by 4
					// %. = shr nsw i64 %6, 2
					ins = fac.createBinaryInst(intIndex, InstType.binaryInst,
							Arrays.asList(new Constant[] { byteIndex,
									vfac.createConstantValue(SimpleConstantValue.intConst, "2") }),
							Arrays.asList(new Type[] { i64_t, i64_t }),
							"ashr", "", "", "");
					addInstruction(start, ins);
					
					// %. = getelementptr inbounds i32* <base>, i64 <index>
					Constant pRes = trn.getVar(Translator.publicVarName("jniArrayBase"), true);
					ins = fac.createGetElePtrInst(pElem, InstType.getElePtrInst,
							Arrays.asList(new Constant[] { pRes, intIndex }),
							Arrays.asList(new Type[] { pi32_t, i64_t }),
							true /* inbounds */);
					addInstruction(start, ins);
					
					// Be cautious about using arrayBasePtr. It might not dominate the cleanup.
					// Setting it is only used to indicate array base has been retrieved.
					publishVar(trn, "arrayBasePtr", pRes.toString());
					
					return super.insert(trn, insList, start);
				}
				
				@Override
				public void insertInit(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					Instruction ins;
					
					String jniDoneVariable = Translator.publicVarName("arrayAccessDone" + 
							trn.getSubrecognizerKey());
					Constant jniDone = trn.getVar(jniDoneVariable, false);
					
					if (jniDone == null) {
						Constant tab = trn.getVar(Translator.publicVarName("arrayTab"), true);
						Constant pRes = trn.getVar(Translator.publicVarName("jniArrayBase"), true);
						
						// store returned array base to tab variable
						ins = fac.createLoadStoreInst(null, InstType.storeInst,
								Arrays.asList(new Constant[] { pRes, tab }),
								Arrays.asList(new Type[] { pi32_t, TypeFactory.getPointerType(pi32_t)}),
								false /* volatile */ );
						
						addInstruction(start, ins);
						
						trn.setVar(jniDoneVariable, "1");
					}
				}
		};
		
		Translator trnArrayBase  = new Translator("addArrayRef3", arrayBaseRec, arrayBaseGen);
		trnStructElem.addTranslator("2", trnArrayBase);
	}
	
	protected static void addArrayRef4(Translator trnStructElem) {		
		OpRecognizer elemOpRec = trnStructElem.getOpr();
		ArrayAccessGen elemOpGen = (ArrayAccessGen)trnStructElem.getOpg();
		
		// Get existing public vars
		Constant env_addr = new WildcardConstant(Translator.publicVarName("localEnv"));	
		Constant iscopy = new WildcardConstant(Translator.publicVarName("isCopy"));
		
		/*
		 *     Array base (Array length is not possible)
		 */		
		FunctionType arrayBaseFType = (FunctionType) TypeFactory.getFunctionType(
				Arrays.asList(new Type[] {
						pi32_t /* ret type */, envTypePtrPtr, pi8_t, pi8_t
		}));

		List<Instruction> extraInstr = new LinkedList<Instruction>();		
		
		extraInstr = new LinkedList<Instruction>();
		// call i32 %6(%struct.JNINativeInterface_** %0, i8* %1) nounwind
		JniEnvCallGen arrayBaseJniGen = new JniEnvCallGen(Semcode.GET_ARRAY_BASE,
				elemOpRec, null, pi8_t, env_addr, JNIFunc_GetIntArrayElements,
				true, /* call once at init */
				arrayBaseFType /* funcType */,
				Arrays.asList(new Type[] {pi8_t})/* list types */,
				Arrays.asList(new Constant[] { iscopy })/* list args */,
				extraInstr,
				"jniArrayBase");
		elemOpGen.addGenerator(2 /* elem 2 */, arrayBaseJniGen);		
		
		/*
		 *  Array element access recognizer (process JNI call result)
		 *  
		 *      Array Base
		 *     
		 *  JNI env call result is returned in 'jniArrayBase'
		 */
		
		OpRecognizer arrayBaseRec = new OpRecognizer(VariableMapper.Semcode.GET_ARRAY_BASE_POST,
				javaStructPtr, type0xi32Ptr);
		// %5 = getelementptr i8* %4, i32 %8
		Constant arrayBasePtr = new WildcardConstant(Translator.publicVarName("arrayBasePtr")); // published
		Constant elemPtr = new WildcardConstant(OpRecognizer.newWildcard("elemPtr")); // publishable
		Constant index = new WildcardConstant(OpRecognizer.newWildcard("elemIndex")); // publishable
		Instruction ins = fac.createGetElePtrInst(elemPtr, InstType.getElePtrInst,
				Arrays.asList(new Constant[] { arrayBasePtr, index }),
				Arrays.asList(new Type[] { pi8_t, i32_t }),
				false /* inbounds */);
		arrayBaseRec.addInstruction(ins);
		arrayBaseRec.addPublicVar(elemPtr);
		arrayBaseRec.addPublicVar(index);

		OpGenerator arrayBaseGen = new OpGenerator(VariableMapper.Semcode.GET_ARRAY_BASE_POST, arrayBaseRec,
				null, null) {
				@Override
				public int insert(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					
					Instruction ins = null;
					Constant pRes = trn.getVar(Translator.publicVarName("jniArrayBase"), true);
					Constant elemPtr = trn.getVar(Translator.publicVarName("elemPtr"), true);
					Constant index = trn.getVar(Translator.publicVarName("elemIndex"), true);
					Constant arrayBase = new LocalVariable(trn.getGenTmpName());
					
					// bitcast
					ins = fac.createOperationInst(arrayBase, InstType.converInst,			
							Arrays.asList(new Constant[] { pRes }),
							Arrays.asList(new Type[] { pi32_t, pi8_t }),
							"bitcast");
					addInstruction(start, ins);
					
					// %. = getelementptr inbounds i32* <base>, i64 <index>					
					ins = fac.createGetElePtrInst(elemPtr, InstType.getElePtrInst,
							Arrays.asList(new Constant[] { arrayBase, index }),
							Arrays.asList(new Type[] { pi8_t, i32_t }),
							false /* inbounds */);
					addInstruction(start, ins);
					
					return super.insert(trn, insList, start);
				}
				
				@Override
				public void insertInit(Translator trn,
						List<Instruction> insList,
						ListIterator<Instruction> start) {
					Instruction ins;
					
					String jniDoneVariable = Translator.publicVarName("arrayAccessDone" + 
							trn.getSubrecognizerKey());
					Constant jniDone = trn.getVar(jniDoneVariable, false);
					
					if (jniDone == null) {
						Constant tab = trn.getVar(Translator.publicVarName("arrayTab"), true);
						Constant pRes = trn.getVar(Translator.publicVarName("jniArrayBase"), true);
						
						// store returned array base to tab variable
						ins = fac.createLoadStoreInst(null, InstType.storeInst,
								Arrays.asList(new Constant[] { pRes, tab }),
								Arrays.asList(new Type[] { pi32_t, TypeFactory.getPointerType(pi32_t)}),
								false /* volatile */ );
						
						addInstruction(start, ins);
						
						trn.setVar(jniDoneVariable, "1");
					}
				}
		};
		
		Translator trnArrayBase  = new Translator("addArrayRef4", arrayBaseRec, arrayBaseGen);
		trnStructElem.addTranslator("2", trnArrayBase);
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
		Translator trnStructBase = new Translator("arrayToi8", arrayToi8Rec, 
				new OpGenerator(VariableMapper.Semcode.GET_STRUCT_BASE, 
						null, null, null)  /* eraser */
				);
		mapper.addTranslator(trnStructBase);
		
		// %1 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*
		Constant pObject = new LocalVariable(trnStructBase.getRecTmpName());
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
		
		addObjectRec64bit(mapper, trnStructBase);
		addObjectRec32bit(mapper, trnStructBase);
		addObjectRecOptimizedLen(mapper);
		addObjectRecOptimizedBase(mapper);
		addObjectRecOptimizedLen32bit(mapper);
		addObjectRecOptimizedBase32bit(mapper);		
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
		ignoreCalls.add("@llvm.dbg.value");
		ignoreCalls.add("@llvm.dbg.declare");
		ignoreCalls.add("@_Jv_ThrowBadArrayIndex");
		ignoreCalls.add("@_Jv_ThrowNullPointerException");
		return ignoreCalls;
	}
	
	private static List<String> getIgnoreFAttr() {
		List<String> ignoreFAttr = new ArrayList<String>();
		ignoreFAttr.add("uwtable");
		return ignoreFAttr;
	}
}
