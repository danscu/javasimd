; ModuleID = 'HelloWorld.java'
target datalayout = "e-p:32:32:32-S128-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:32:64-f16:16:16-f32:32:32-f64:32:64-f128:128:128-v64:64:64-v128:128:128-a0:0:64-f80:32:32-n8:16:32"
target triple = "i386--linux-gnu"

module asm "\09.ident\09\22GCC: (Ubuntu/Linaro 4.6.3-1ubuntu2) 4.6.3 LLVM: 3.2svn\22"

%0 = type { %struct.java.lang.Class*, [2 x i8*] }
%1 = type { i16, i16 }
%2 = type { i32, i8*, i8* }
%3 = type { %1*, %1*, i16, i16, i8*, i8* }
%4 = type { %1*, %struct.java.lang.Class*, i16, i16, %5 }
%5 = type { i32 }
%6 = type { %1*, %1*, %1* }
%7 = type { i16, i16, [12 x i8] }
%8 = type { i16, i16, [14 x i8] }
%9 = type { i16, i16, [8 x i8] }
%10 = type { i16, i16, [14 x i8] }
%11 = type { i16, i16, [20 x i8] }
%12 = type { i16, i16, [8 x i8] }
%13 = type { i16, i16, [4 x i8] }
%14 = type { i16, i16, [8 x i8] }
%15 = type { i16, i16, [6 x i8] }
%16 = type { i16, i16, [14 x i8] }
%17 = type { i16, i16, [6 x i8] }
%18 = type { i16, i16, [10 x i8] }
%19 = type { i16, i16, [6 x i8] }
%20 = type { i16, i16, [6 x i8] }
%21 = type { i16, i16, [24 x i8] }
%22 = type { %1*, i8* }
%23 = type { i32, i32, [6 x i8], [2 x i8] }
%struct.java.lang.Class = type { %struct.java.lang.Object, %struct.java.lang.Class*, %1*, i16, %struct.java.lang.Class*, %2, %3*, i16, i16, %4*, i32, i16, i16, %0*, [2 x i32]*, [2 x %6]*, [2 x i8*]*, [2 x %6]*, [2 x i8*]*, [2 x %6]*, i8*, {}*, i8*, i16, i8, i8*, i16, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8* }
%struct.java.lang.Object = type { %0* }
%struct.java.io.PrintStream = type { %struct.java.io.FilterOutputStream, %struct.gnu.gcj.convert.UnicodeToBytes*, %"struct.char[]"*, %"struct.byte[]"*, i8, i8, [2 x i8] }
%struct.java.io.FilterOutputStream = type { %struct.java.io.OutputStream, %struct.java.io.OutputStream* }
%struct.java.io.OutputStream = type { %struct.java.lang.Object }
%struct.gnu.gcj.convert.UnicodeToBytes = type opaque
%"struct.char[]" = type { %struct.java.lang.Object, i32 }
%"struct.byte[]" = type { %struct.java.lang.Object, i32 }
%struct.java.lang.String = type opaque
%struct.HelloWorld = type { %struct.java.lang.Object }
%"struct.int[]" = type { %struct.java.lang.Object, i32 }
%"struct.java.lang.Object[]" = type { %struct.java.lang.Object, i32 }
%"struct.java.lang.String[]" = type { %struct.java.lang.Object, i32 }
%struct.java.lang.StringBuilder = type { %struct.java.lang.AbstractStringBuffer }
%struct.java.lang.AbstractStringBuffer = type { %struct.java.lang.Object, i32, %"struct.char[]"* }
%struct.java.util.Random = type { %struct.java.lang.Object, i8, double, i64 }

@"_ZN10HelloWorld7class$$E" = hidden unnamed_addr constant %struct.java.lang.Class* @"_ZN10HelloWorld6class$E"
@"_ZN10HelloWorld6class$E" = global %struct.java.lang.Class { %struct.java.lang.Object { %0* bitcast (i8** getelementptr inbounds (%0* @_ZTVN4java4lang5ClassE, i32 0, i32 1, i32 1) to %0*) }, %struct.java.lang.Class* inttoptr (i32 406000 to %struct.java.lang.Class*), %1* bitcast (%7* @_Utf15 to %1*), i16 33, %struct.java.lang.Class* @"_ZN4java4lang6Object6class$E", %2 { i32 5, i8* getelementptr inbounds ([5 x i8]* @_CT_HelloWorld, i32 0, i32 0), i8* bitcast ([5 x i8*]* @_CD_HelloWorld to i8*) }, %3* getelementptr inbounds ([5 x %3]* @_MT_HelloWorld, i32 0, i32 0), i16 5, i16 6, %4* null, i32 4, i16 0, i16 0, %0* bitcast (i8** getelementptr inbounds ([10 x i8*]* @_ZTVN10HelloWorldE, i32 0, i32 2) to %0*), [2 x i32]* null, [2 x %6]* null, [2 x i8*]* null, [2 x %6]* null, [2 x i8*]* null, [2 x %6]* null, i8* bitcast ([3 x %22]* @_catch_classes_HelloWorld to i8*), {}* null, i8* null, i16 0, i8 1, i8* null, i16 0, i8* null, i8* null, i8* null, i8* null, i8* null, i8* null, i8* null, i8* null, i8* null, i8* null }, align 32
@_ZTVN4java4lang5ClassE = external global %0
@_Utf15 = internal unnamed_addr constant %7 { i16 -24064, i16 10, [12 x i8] c"HelloWorld\00\00" }
@"_ZN4java4lang6Object6class$E" = external global %struct.java.lang.Class
@_CT_HelloWorld = internal unnamed_addr global [5 x i8] c"\00\08\08\08\08"
@_CD_HelloWorld = internal unnamed_addr global [5 x i8*] [i8* null, i8* bitcast (%8* @_Utf14 to i8*), i8* bitcast (%9* @_Utf13 to i8*), i8* bitcast (%10* @_Utf12 to i8*), i8* bitcast (%11* @_Utf11 to i8*)]
@_Utf14 = internal unnamed_addr constant %8 { i16 31116, i16 12, [14 x i8] c"Hello, World\00\00" }
@_Utf13 = internal unnamed_addr constant %9 { i16 1432, i16 6, [8 x i8] c"Sum = \00\00" }
@_Utf12 = internal unnamed_addr constant %10 { i16 -17089, i16 12, [14 x i8] c"Array sum = \00\00" }
@_Utf11 = internal unnamed_addr constant %11 { i16 -441, i16 18, [20 x i8] c"Sorting done, N = \00\00" }
@_MT_HelloWorld = internal unnamed_addr global [5 x %3] [%3 { %1* bitcast (%12* @_Utf1 to %1*), %1* bitcast (%13* @_Utf2 to %1*), i16 16385, i16 -1, i8* bitcast (void (%struct.HelloWorld*)* @_ZN10HelloWorldC1Ev to i8*), i8* null }, %3 { %1* bitcast (%14* @_Utf3 to %1*), %1* bitcast (%15* @_Utf4 to %1*), i16 16386, i16 -1, i8* bitcast (i32 (%struct.HelloWorld*, i32)* @_ZN10HelloWorld7testSumEJii to i8*), i8* null }, %3 { %1* bitcast (%16* @_Utf5 to %1*), %1* bitcast (%17* @_Utf6 to %1*), i16 16386, i16 -1, i8* bitcast (i32 (%struct.HelloWorld*, %"struct.int[]"*)* @_ZN10HelloWorld12testArraySumEJiP6JArrayIiE to i8*), i8* null }, %3 { %1* bitcast (%18* @_Utf7 to %1*), %1* bitcast (%19* @_Utf8 to %1*), i16 16386, i16 -1, i8* bitcast (void (%struct.HelloWorld*, %"struct.int[]"*)* @_ZN10HelloWorld8testSortEJvP6JArrayIiE to i8*), i8* null }, %3 { %1* bitcast (%20* @_Utf9 to %1*), %1* bitcast (%21* @_Utf10 to %1*), i16 16393, i16 -1, i8* bitcast (void (%"struct.java.lang.String[]"*)* @_ZN10HelloWorld4mainEJvP6JArrayIPN4java4lang6StringEE to i8*), i8* null }], align 32
@_Utf1 = internal unnamed_addr constant %12 { i16 626, i16 6, [8 x i8] c"<init>\00\00" }
@_Utf2 = internal unnamed_addr constant %13 { i16 -25739, i16 3, [4 x i8] c"()V\00" }
@_Utf3 = internal unnamed_addr constant %14 { i16 -8103, i16 7, [8 x i8] c"testSum\00" }
@_Utf4 = internal unnamed_addr constant %15 { i16 17953, i16 4, [6 x i8] c"(I)I\00\00" }
@_Utf5 = internal unnamed_addr constant %16 { i16 -28, i16 12, [14 x i8] c"testArraySum\00\00" }
@_Utf6 = internal unnamed_addr constant %17 { i16 8502, i16 5, [6 x i8] c"([I)I\00" }
@_Utf7 = internal unnamed_addr constant %18 { i16 5456, i16 8, [10 x i8] c"testSort\00\00" }
@_Utf8 = internal unnamed_addr constant %19 { i16 8515, i16 5, [6 x i8] c"([I)V\00" }
@_Utf9 = internal unnamed_addr constant %20 { i16 1465, i16 4, [6 x i8] c"main\00\00" }
@_Utf10 = internal unnamed_addr constant %21 { i16 -6102, i16 22, [24 x i8] c"([Ljava.lang.String;)V\00\00" }
@_ZTVN10HelloWorldE = hidden unnamed_addr global [10 x i8*] [i8* null, i8* null, i8* bitcast (%struct.java.lang.Class* @"_ZN10HelloWorld6class$E" to i8*), i8* inttoptr (i32 4 to i8*), i8* bitcast (void (%struct.java.lang.Object*)* @_ZN4java4lang6Object8finalizeEJvv to i8*), i8* bitcast (i32 (%struct.java.lang.Object*)* @_ZN4java4lang6Object8hashCodeEJiv to i8*), i8* bitcast (i8 (%struct.java.lang.Object*, %struct.java.lang.Object*)* @_ZN4java4lang6Object6equalsEJbPS1_ to i8*), i8* bitcast (%struct.java.lang.String* (%struct.java.lang.Object*)* @_ZN4java4lang6Object8toStringEJPNS0_6StringEv to i8*), i8* bitcast (%struct.java.lang.Object* (%struct.java.lang.Object*)* @_ZN4java4lang6Object5cloneEJPS1_v to i8*), i8* bitcast (void (%struct.java.lang.Object*)* @_ZN4java4lang6Object22throwNoSuchMethodErrorEJvv to i8*)], align 32
@_catch_classes_HelloWorld = internal unnamed_addr global [3 x %22] zeroinitializer
@"_ZGr8_$_dummy" = hidden constant %23 { i32 6, i32 0, [6 x i8] c".dummy", [2 x i8] undef }
@"_ZN4java4lang6System6class$E" = external global %struct.java.lang.Class
@_ZN4java4lang6System3outE = external global %struct.java.io.PrintStream*
@"_ZN4java4lang13StringBuilder6class$E" = external global %struct.java.lang.Class
@_Jv_intClass = external global %struct.java.lang.Class
@"_ZN4java4util6Random6class$E" = external global %struct.java.lang.Class
@llvm.global_ctors = appending global [1 x { i32, void ()* }] [{ i32, void ()* } { i32 65535, void ()* @_Jv_global_static_constructor }]

declare void @_ZN4java4lang6Object8finalizeEJvv(%struct.java.lang.Object*)

declare i32 @_ZN4java4lang6Object8hashCodeEJiv(%struct.java.lang.Object*)

declare zeroext i8 @_ZN4java4lang6Object6equalsEJbPS1_(%struct.java.lang.Object*, %struct.java.lang.Object*)

declare %struct.java.lang.String* @_ZN4java4lang6Object8toStringEJPNS0_6StringEv(%struct.java.lang.Object*)

declare %struct.java.lang.Object* @_ZN4java4lang6Object5cloneEJPS1_v(%struct.java.lang.Object*)

declare void @_ZN4java4lang6Object22throwNoSuchMethodErrorEJvv(%struct.java.lang.Object*)

define void @_ZN10HelloWorldC1Ev(%struct.HelloWorld* %unnamed_arg) uwtable align 2 {
entry:
  %unnamed_arg_addr = alloca %struct.HelloWorld*, align 4
  %"#ref#0#0" = alloca i8*
  %D.242 = alloca %struct.java.lang.Object*
  %"#ref#1#2" = alloca i8*
  %"alloca point" = bitcast i32 0 to i32
  call void @llvm.dbg.declare(metadata !{%struct.HelloWorld** %unnamed_arg_addr}, metadata !159), !dbg !160
  store %struct.HelloWorld* %unnamed_arg, %struct.HelloWorld** %unnamed_arg_addr, align 1
  %0 = load %struct.HelloWorld** %unnamed_arg_addr, align 4
  %"ssa point" = bitcast i32 0 to i32
  br label %"2", !dbg !160

"2":                                              ; preds = %entry
  %1 = bitcast %struct.HelloWorld* %0 to %struct.java.lang.Object*, !dbg !160
  %2 = bitcast %struct.java.lang.Object* %1 to i8*, !dbg !160
  %3 = bitcast i8* %2 to %struct.java.lang.Object*, !dbg !160
  call void @_ZN4java4lang6ObjectC1Ev(%struct.java.lang.Object* %3), !dbg !160
  br label %return, !dbg !160

return:                                           ; preds = %"2"
  ret void, !dbg !160
}

define i32 @_ZN10HelloWorld7testSumEJii(%struct.HelloWorld* %unnamed_arg, i32 %unnamed_arg2) uwtable align 2 {
entry:
  %unnamed_arg_addr = alloca %struct.HelloWorld*, align 4
  %unnamed_arg_addr1 = alloca i32, align 4
  %"#slot#4#0" = alloca i32
  %"#slot#3#1" = alloca i32
  %"#slot#2#2" = alloca i32
  %D.256 = alloca i32
  %D.257 = alloca i32
  %"#slot#5#3" = alloca i32
  %D.259 = alloca i32
  %D.260 = alloca i32
  %D.261 = alloca i32
  %"<retval>" = alloca i32
  %"alloca point" = bitcast i32 0 to i32
  call void @llvm.dbg.declare(metadata !{%struct.HelloWorld** %unnamed_arg_addr}, metadata !161), !dbg !162
  store %struct.HelloWorld* %unnamed_arg, %struct.HelloWorld** %unnamed_arg_addr, align 1
  call void @llvm.dbg.declare(metadata !{i32* %unnamed_arg_addr1}, metadata !163), !dbg !162
  store i32 %unnamed_arg2, i32* %unnamed_arg_addr1, align 1
  %0 = load i32* %unnamed_arg_addr1, align 4
  %"ssa point" = bitcast i32 0 to i32
  br label %"2", !dbg !162

"2":                                              ; preds = %entry
  br label %"4", !dbg !164

"3":                                              ; preds = %"4"
  %1 = add i32 %3, %4, !dbg !165
  %2 = add i32 %4, 1, !dbg !164
  br label %"4", !dbg !164

"4":                                              ; preds = %"3", %"2"
  %3 = phi i32 [ %1, %"3" ], [ 0, %"2" ], !dbg !164
  %4 = phi i32 [ %2, %"3" ], [ 0, %"2" ], !dbg !164
  %5 = icmp slt i32 %4, %0, !dbg !164
  br i1 %5, label %"3", label %"5", !dbg !164

"5":                                              ; preds = %"4"
  store i32 %3, i32* %"<retval>", align 1, !dbg !166
  br label %return, !dbg !166

return:                                           ; preds = %"5"
  %6 = load i32* %"<retval>", align 4, !dbg !166
  ret i32 %6, !dbg !166
}

define i32 @_ZN10HelloWorld12testArraySumEJiP6JArrayIiE(%struct.HelloWorld* %unnamed_arg, %"struct.int[]"* %unnamed_arg2) uwtable align 2 {
entry:
  %unnamed_arg_addr = alloca %struct.HelloWorld*, align 4
  %unnamed_arg_addr1 = alloca %"struct.int[]"*, align 4
  %"#slot#4#0" = alloca i32
  %"#slot#2#1" = alloca i32
  %"#slot#3#2" = alloca i32
  %D.273 = alloca i32
  %"#ref#1#3" = alloca i8*
  %D.275 = alloca %struct.java.lang.Object*
  %"#ref#5#5" = alloca i8*
  %D.278 = alloca i32
  %"#slot#6#6" = alloca i32
  %"#slot#5#8" = alloca i32
  %D.282 = alloca i32
  %D.283 = alloca %struct.java.lang.Object*
  %D.288 = alloca i32
  %"<retval>" = alloca i32
  %"alloca point" = bitcast i32 0 to i32
  call void @llvm.dbg.declare(metadata !{%struct.HelloWorld** %unnamed_arg_addr}, metadata !167), !dbg !168
  store %struct.HelloWorld* %unnamed_arg, %struct.HelloWorld** %unnamed_arg_addr, align 1
  call void @llvm.dbg.declare(metadata !{%"struct.int[]"** %unnamed_arg_addr1}, metadata !169), !dbg !168
  store %"struct.int[]"* %unnamed_arg2, %"struct.int[]"** %unnamed_arg_addr1, align 1
  %0 = load %"struct.int[]"** %unnamed_arg_addr1, align 4
  %"ssa point" = bitcast i32 0 to i32
  br label %"2", !dbg !168

"2":                                              ; preds = %entry
  br label %"6", !dbg !170

"3":                                              ; preds = %"6"
  %1 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !171
  %2 = bitcast %struct.java.lang.Object* %1 to i8*, !dbg !171
  %3 = bitcast i8* %2 to %"struct.int[]"*, !dbg !171
  %4 = bitcast %"struct.int[]"* %3 to i8*, !dbg !171
  %5 = getelementptr inbounds i8* %4, i32 8, !dbg !171
  %6 = bitcast i8* %5 to [0 x i32]*, !dbg !171
  %7 = bitcast i8* %2 to %"struct.int[]"*, !dbg !171
  %8 = getelementptr inbounds %"struct.int[]"* %7, i32 0, i32 1, !dbg !171
  %9 = load i32* %8, align 4, !dbg !171
  %10 = icmp uge i32 %19, %9, !dbg !171
  br i1 %10, label %"4", label %"5", !dbg !171

"4":                                              ; preds = %"3"
  call void (i32, ...)* @_Jv_ThrowBadArrayIndex(i32 %19) noreturn, !dbg !171
  unreachable, !dbg !171

"5":                                              ; preds = %"3"
  %11 = mul i32 %19, 4, !dbg !171
  %12 = bitcast [0 x i32]* %6 to i8*, !dbg !171
  %13 = getelementptr i8* %12, i32 %11, !dbg !171
  %14 = bitcast i8* %13 to i32*, !dbg !171
  %15 = load i32* %14, align 4, !dbg !171
  %16 = add i32 %18, %15, !dbg !171
  %17 = add i32 %19, 1, !dbg !170
  br label %"6", !dbg !170

"6":                                              ; preds = %"5", %"2"
  %18 = phi i32 [ %16, %"5" ], [ 0, %"2" ], !dbg !170
  %19 = phi i32 [ %17, %"5" ], [ 0, %"2" ], !dbg !170
  %20 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !170
  %21 = bitcast %struct.java.lang.Object* %20 to i8*, !dbg !170
  %22 = bitcast i8* %21 to %"struct.java.lang.Object[]"*, !dbg !170
  %23 = getelementptr inbounds %"struct.java.lang.Object[]"* %22, i32 0, i32 1, !dbg !170
  %24 = load i32* %23, align 4, !dbg !170
  %25 = icmp slt i32 %19, %24, !dbg !170
  br i1 %25, label %"3", label %"7", !dbg !170

"7":                                              ; preds = %"6"
  store i32 %18, i32* %"<retval>", align 1, !dbg !172
  br label %return, !dbg !172

return:                                           ; preds = %"7"
  %26 = load i32* %"<retval>", align 4, !dbg !172
  ret i32 %26, !dbg !172
}

define void @_ZN10HelloWorld8testSortEJvP6JArrayIiE(%struct.HelloWorld* %unnamed_arg, %"struct.int[]"* %unnamed_arg2) uwtable align 2 {
entry:
  %unnamed_arg_addr = alloca %struct.HelloWorld*, align 4
  %unnamed_arg_addr1 = alloca %"struct.int[]"*, align 4
  %"#slot#6#0" = alloca i32
  %"#slot#2#1" = alloca i32
  %D.305 = alloca i32
  %"#slot#4#2" = alloca i32
  %D.307 = alloca i32
  %"#slot#7#3" = alloca i32
  %"#slot#3#4" = alloca i32
  %"#ref#1#5" = alloca i8*
  %D.311 = alloca %struct.java.lang.Object*
  %"#ref#6#7" = alloca i8*
  %D.314 = alloca i32
  %D.316 = alloca %struct.java.lang.Object*
  %"#ref#7#10" = alloca i8*
  %D.319 = alloca i32
  %"#slot#8#11" = alloca i32
  %D.322 = alloca i32
  %D.323 = alloca i32
  %D.324 = alloca %struct.java.lang.Object*
  %D.325 = alloca %struct.java.lang.Object*
  %D.326 = alloca i32
  %"#slot#5#13" = alloca i32
  %D.328 = alloca %struct.java.lang.Object*
  %D.329 = alloca i32
  %D.330 = alloca %struct.java.lang.Object*
  %"#ref#8#15" = alloca i8*
  %D.333 = alloca i32
  %"#slot#9#16" = alloca i32
  %D.336 = alloca i32*
  %D.337 = alloca %struct.java.lang.Object*
  %D.338 = alloca i32
  %D.339 = alloca i32
  %D.340 = alloca i32*
  %D.341 = alloca i32
  %D.342 = alloca %struct.java.lang.Object*
  %"alloca point" = bitcast i32 0 to i32
  call void @llvm.dbg.declare(metadata !{%struct.HelloWorld** %unnamed_arg_addr}, metadata !173), !dbg !174
  store %struct.HelloWorld* %unnamed_arg, %struct.HelloWorld** %unnamed_arg_addr, align 1
  call void @llvm.dbg.declare(metadata !{%"struct.int[]"** %unnamed_arg_addr1}, metadata !175), !dbg !174
  store %"struct.int[]"* %unnamed_arg2, %"struct.int[]"** %unnamed_arg_addr1, align 1
  %0 = load %"struct.int[]"** %unnamed_arg_addr1, align 4
  %"ssa point" = bitcast i32 0 to i32
  br label %"2", !dbg !174

"2":                                              ; preds = %entry
  br label %"21", !dbg !174

"3":                                              ; preds = %"21"
  %1 = add i32 %102, 1, !dbg !176
  br label %"11", !dbg !176

"4":                                              ; preds = %"11"
  %2 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !177
  %3 = bitcast %struct.java.lang.Object* %2 to i8*, !dbg !177
  %4 = bitcast i8* %3 to %"struct.int[]"*, !dbg !177
  %5 = bitcast %"struct.int[]"* %4 to i8*, !dbg !177
  %6 = getelementptr inbounds i8* %5, i32 8, !dbg !177
  %7 = bitcast i8* %6 to [0 x i32]*, !dbg !177
  %8 = bitcast i8* %3 to %"struct.int[]"*, !dbg !177
  %9 = getelementptr inbounds %"struct.int[]"* %8, i32 0, i32 1, !dbg !177
  %10 = load i32* %9, align 4, !dbg !177
  %11 = icmp uge i32 %36, %10, !dbg !177
  br i1 %11, label %"5", label %"6", !dbg !177

"5":                                              ; preds = %"4"
  call void (i32, ...)* @_Jv_ThrowBadArrayIndex(i32 %36) noreturn, !dbg !177
  unreachable, !dbg !177

"6":                                              ; preds = %"4"
  %12 = mul i32 %36, 4, !dbg !177
  %13 = bitcast [0 x i32]* %7 to i8*, !dbg !177
  %14 = getelementptr i8* %13, i32 %12, !dbg !177
  %15 = bitcast i8* %14 to i32*, !dbg !177
  %16 = load i32* %15, align 4, !dbg !177
  %17 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !177
  %18 = bitcast %struct.java.lang.Object* %17 to i8*, !dbg !177
  %19 = bitcast i8* %18 to %"struct.int[]"*, !dbg !177
  %20 = bitcast %"struct.int[]"* %19 to i8*, !dbg !177
  %21 = getelementptr inbounds i8* %20, i32 8, !dbg !177
  %22 = bitcast i8* %21 to [0 x i32]*, !dbg !177
  %23 = bitcast i8* %18 to %"struct.int[]"*, !dbg !177
  %24 = getelementptr inbounds %"struct.int[]"* %23, i32 0, i32 1, !dbg !177
  %25 = load i32* %24, align 4, !dbg !177
  %26 = icmp uge i32 %35, %25, !dbg !177
  br i1 %26, label %"7", label %"8", !dbg !177

"7":                                              ; preds = %"6"
  call void (i32, ...)* @_Jv_ThrowBadArrayIndex(i32 %35) noreturn, !dbg !177
  unreachable, !dbg !177

"8":                                              ; preds = %"6"
  %27 = mul i32 %35, 4, !dbg !177
  %28 = bitcast [0 x i32]* %22 to i8*, !dbg !177
  %29 = getelementptr i8* %28, i32 %27, !dbg !177
  %30 = bitcast i8* %29 to i32*, !dbg !177
  %31 = load i32* %30, align 4, !dbg !177
  %32 = icmp sge i32 %16, %31, !dbg !177
  br i1 %32, label %"10", label %"9", !dbg !177

"9":                                              ; preds = %"8"
  br label %"10", !dbg !178

"10":                                             ; preds = %"9", %"8"
  %33 = phi i32 [ %36, %"9" ], [ %35, %"8" ], !dbg !178
  %34 = add i32 %36, 1, !dbg !176
  br label %"11", !dbg !176

"11":                                             ; preds = %"10", %"3"
  %35 = phi i32 [ %33, %"10" ], [ %102, %"3" ], !dbg !176
  %36 = phi i32 [ %34, %"10" ], [ %1, %"3" ], !dbg !176
  %37 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !176
  %38 = bitcast %struct.java.lang.Object* %37 to i8*, !dbg !176
  %39 = bitcast i8* %38 to %"struct.java.lang.Object[]"*, !dbg !176
  %40 = getelementptr inbounds %"struct.java.lang.Object[]"* %39, i32 0, i32 1, !dbg !176
  %41 = load i32* %40, align 4, !dbg !176
  %42 = icmp slt i32 %36, %41, !dbg !176
  br i1 %42, label %"4", label %"12", !dbg !176

"12":                                             ; preds = %"11"
  %43 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !179
  %44 = bitcast %struct.java.lang.Object* %43 to i8*, !dbg !179
  %45 = bitcast i8* %44 to %"struct.int[]"*, !dbg !179
  %46 = bitcast %"struct.int[]"* %45 to i8*, !dbg !179
  %47 = getelementptr inbounds i8* %46, i32 8, !dbg !179
  %48 = bitcast i8* %47 to [0 x i32]*, !dbg !179
  %49 = bitcast i8* %44 to %"struct.int[]"*, !dbg !179
  %50 = getelementptr inbounds %"struct.int[]"* %49, i32 0, i32 1, !dbg !179
  %51 = load i32* %50, align 4, !dbg !179
  %52 = icmp uge i32 %102, %51, !dbg !179
  br i1 %52, label %"13", label %"14", !dbg !179

"13":                                             ; preds = %"12"
  call void (i32, ...)* @_Jv_ThrowBadArrayIndex(i32 %102) noreturn, !dbg !179
  unreachable, !dbg !179

"14":                                             ; preds = %"12"
  %53 = mul i32 %102, 4, !dbg !179
  %54 = bitcast [0 x i32]* %48 to i8*, !dbg !179
  %55 = getelementptr i8* %54, i32 %53, !dbg !179
  %56 = bitcast i8* %55 to i32*, !dbg !179
  %57 = load i32* %56, align 4, !dbg !179
  %58 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !179
  %59 = bitcast %struct.java.lang.Object* %58 to i8*, !dbg !179
  %60 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !179
  %61 = bitcast %struct.java.lang.Object* %60 to i8*, !dbg !179
  %62 = bitcast i8* %61 to %"struct.int[]"*, !dbg !179
  %63 = bitcast %"struct.int[]"* %62 to i8*, !dbg !179
  %64 = getelementptr inbounds i8* %63, i32 8, !dbg !179
  %65 = bitcast i8* %64 to [0 x i32]*, !dbg !179
  %66 = bitcast i8* %61 to %"struct.int[]"*, !dbg !179
  %67 = getelementptr inbounds %"struct.int[]"* %66, i32 0, i32 1, !dbg !179
  %68 = load i32* %67, align 4, !dbg !179
  %69 = icmp uge i32 %35, %68, !dbg !179
  br i1 %69, label %"15", label %"16", !dbg !179

"15":                                             ; preds = %"14"
  call void (i32, ...)* @_Jv_ThrowBadArrayIndex(i32 %35) noreturn, !dbg !179
  unreachable, !dbg !179

"16":                                             ; preds = %"14"
  %70 = mul i32 %35, 4, !dbg !179
  %71 = bitcast [0 x i32]* %65 to i8*, !dbg !179
  %72 = getelementptr i8* %71, i32 %70, !dbg !179
  %73 = bitcast i8* %72 to i32*, !dbg !179
  %74 = load i32* %73, align 4, !dbg !179
  %75 = bitcast i8* %59 to %"struct.int[]"*, !dbg !179
  %76 = bitcast %"struct.int[]"* %75 to i8*, !dbg !179
  %77 = getelementptr inbounds i8* %76, i32 8, !dbg !179
  %78 = bitcast i8* %77 to [0 x i32]*, !dbg !179
  %79 = bitcast i8* %59 to %"struct.int[]"*, !dbg !179
  %80 = getelementptr inbounds %"struct.int[]"* %79, i32 0, i32 1, !dbg !179
  %81 = load i32* %80, align 4, !dbg !179
  %82 = icmp uge i32 %102, %81, !dbg !179
  br i1 %82, label %"17", label %"18", !dbg !179

"17":                                             ; preds = %"16"
  call void (i32, ...)* @_Jv_ThrowBadArrayIndex(i32 %102) noreturn, !dbg !179
  unreachable, !dbg !179

"18":                                             ; preds = %"16"
  %83 = mul i32 %102, 4, !dbg !179
  %84 = bitcast [0 x i32]* %78 to i8*, !dbg !179
  %85 = getelementptr i8* %84, i32 %83, !dbg !179
  %86 = bitcast i8* %85 to i32*, !dbg !179
  store i32 %74, i32* %86, align 4, !dbg !179
  %87 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !179
  %88 = bitcast %struct.java.lang.Object* %87 to i8*, !dbg !179
  %89 = bitcast i8* %88 to %"struct.int[]"*, !dbg !179
  %90 = bitcast %"struct.int[]"* %89 to i8*, !dbg !179
  %91 = getelementptr inbounds i8* %90, i32 8, !dbg !179
  %92 = bitcast i8* %91 to [0 x i32]*, !dbg !179
  %93 = bitcast i8* %88 to %"struct.int[]"*, !dbg !179
  %94 = getelementptr inbounds %"struct.int[]"* %93, i32 0, i32 1, !dbg !179
  %95 = load i32* %94, align 4, !dbg !179
  %96 = icmp uge i32 %35, %95, !dbg !179
  br i1 %96, label %"19", label %"20", !dbg !179

"19":                                             ; preds = %"18"
  call void (i32, ...)* @_Jv_ThrowBadArrayIndex(i32 %35) noreturn, !dbg !179
  unreachable, !dbg !179

"20":                                             ; preds = %"18"
  %97 = mul i32 %35, 4, !dbg !179
  %98 = bitcast [0 x i32]* %92 to i8*, !dbg !179
  %99 = getelementptr i8* %98, i32 %97, !dbg !179
  %100 = bitcast i8* %99 to i32*, !dbg !179
  store i32 %57, i32* %100, align 4, !dbg !179
  %101 = add i32 %102, 1, !dbg !174
  br label %"21", !dbg !174

"21":                                             ; preds = %"20", %"2"
  %102 = phi i32 [ %101, %"20" ], [ 0, %"2" ], !dbg !174
  %103 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !174
  %104 = bitcast %struct.java.lang.Object* %103 to i8*, !dbg !174
  %105 = bitcast i8* %104 to %"struct.java.lang.Object[]"*, !dbg !174
  %106 = getelementptr inbounds %"struct.java.lang.Object[]"* %105, i32 0, i32 1, !dbg !174
  %107 = load i32* %106, align 4, !dbg !174
  %108 = sub i32 %107, 1, !dbg !174
  %109 = icmp slt i32 %102, %108, !dbg !174
  br i1 %109, label %"3", label %"22", !dbg !174

"22":                                             ; preds = %"21"
  br label %return, !dbg !180

return:                                           ; preds = %"22"
  ret void, !dbg !180
}

define void @_ZN10HelloWorld4mainEJvP6JArrayIPN4java4lang6StringEE(%"struct.java.lang.String[]"* %unnamed_arg) unnamed_addr uwtable {
entry:
  %unnamed_arg_addr = alloca %"struct.java.lang.String[]"*, align 4
  %D.661 = alloca %struct.java.io.PrintStream*
  %"#ref#7#1" = alloca i8*
  %"#ref#8#3" = alloca i8*
  %"#ref#1#7" = alloca i8*
  %D.773 = alloca %struct.HelloWorld*
  %"#slot#8#8" = alloca i32
  %"#slot#7#9" = alloca i32
  %"#slot#2#10" = alloca i32
  %D.777 = alloca %struct.java.io.PrintStream*
  %"#ref#9#13" = alloca i8*
  %"#ref#10#15" = alloca i8*
  %D.930 = alloca i32
  %"#slot#9#16" = alloca i32
  %"#ref#3#19" = alloca i8*
  %"#slot#4#20" = alloca i32
  %D.938 = alloca %struct.java.lang.Object*
  %D.940 = alloca i32
  %D.941 = alloca i32
  %D.942 = alloca i32*
  %D.943 = alloca i32
  %D.945 = alloca %struct.java.lang.Object*
  %D.946 = alloca %struct.java.lang.Object*
  %D.949 = alloca %struct.java.io.PrintStream*
  %D.950 = alloca i32
  %"#ref#5#29" = alloca i8*
  %D.973 = alloca i32
  %"#slot#6#30" = alloca i32
  %D.975 = alloca %struct.java.lang.Object*
  %D.976 = alloca i32
  %D.978 = alloca %struct.java.lang.Object*
  %D.981 = alloca i32*
  %D.982 = alloca i32
  %D.983 = alloca i32
  %D.984 = alloca %struct.java.lang.Object*
  %D.985 = alloca %struct.java.lang.Object*
  %D.986 = alloca %struct.java.io.PrintStream*
  %D.987 = alloca i32
  %"alloca point" = bitcast i32 0 to i32
  call void @llvm.dbg.declare(metadata !{%"struct.java.lang.String[]"** %unnamed_arg_addr}, metadata !181), !dbg !182
  store %"struct.java.lang.String[]"* %unnamed_arg, %"struct.java.lang.String[]"** %unnamed_arg_addr, align 1
  %"ssa point" = bitcast i32 0 to i32
  br label %"2", !dbg !182

"2":                                              ; preds = %entry
  %0 = load %struct.java.lang.Class** @"_ZN10HelloWorld7class$$E", align 4, !dbg !182
  %1 = bitcast %struct.java.lang.Class* %0 to i8*, !dbg !182
  call void (i8*, ...)* @_Jv_InitClass(i8* %1), !dbg !182
  br i1 true, label %"3", label %"4", !dbg !182

"3":                                              ; preds = %"2"
  call void (i8*, ...)* @_Jv_InitClass(i8* bitcast (%struct.java.lang.Class* @"_ZN4java4lang6System6class$E" to i8*)), !dbg !182
  br label %"4", !dbg !182

"4":                                              ; preds = %"3", %"2"
  %2 = load %struct.java.io.PrintStream** @_ZN4java4lang6System3outE, align 4, !dbg !182
  %3 = bitcast %struct.java.io.PrintStream* %2 to i8*, !dbg !182
  %4 = load i8** getelementptr inbounds ([5 x i8*]* @_CD_HelloWorld, i32 0, i32 1), align 4, !dbg !182
  %5 = bitcast i8* %3 to %struct.java.lang.Object*, !dbg !182
  %6 = getelementptr inbounds %struct.java.lang.Object* %5, i32 0, i32 0, !dbg !182
  %7 = load %0** %6, align 4, !dbg !182
  %8 = bitcast %0* %7 to i8*, !dbg !182
  %9 = getelementptr i8* %8, i32 124, !dbg !182
  %10 = bitcast i8* %9 to i8**, !dbg !182
  %11 = load i8** %10, align 4, !dbg !182
  %12 = bitcast i8* %11 to void (%struct.java.io.PrintStream*, %struct.java.lang.String*)*, !dbg !182
  %13 = bitcast i8* %3 to %struct.java.io.PrintStream*, !dbg !182
  %14 = bitcast i8* %4 to %struct.java.lang.String*, !dbg !182
  call void %12(%struct.java.io.PrintStream* %13, %struct.java.lang.String* %14), !dbg !182
  %15 = call noalias i8* (%struct.java.lang.Class*, ...)* @_Jv_AllocObjectNoFinalizer(%struct.java.lang.Class* @"_ZN10HelloWorld6class$E"), !dbg !183
  %16 = bitcast i8* %15 to %struct.HelloWorld*, !dbg !183
  call void @_ZN10HelloWorldC1Ev(%struct.HelloWorld* %16) uwtable, !dbg !183
  %17 = bitcast i8* %15 to %struct.HelloWorld*, !dbg !184
  %18 = bitcast %struct.HelloWorld* %17 to i8*, !dbg !184
  %19 = icmp eq i8* %18, null, !dbg !184
  br i1 %19, label %"5", label %"6", !dbg !184

"5":                                              ; preds = %"4"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !184
  unreachable, !dbg !184

"6":                                              ; preds = %"4"
  %20 = bitcast i8* %18 to %struct.HelloWorld*, !dbg !184
  %21 = bitcast i8* %18 to %struct.HelloWorld*, !dbg !184
  %22 = call i32 @_ZN10HelloWorld7testSumEJii(%struct.HelloWorld* %21, i32 100) uwtable, !dbg !184
  br i1 false, label %"7", label %"8", !dbg !185

"7":                                              ; preds = %"6"
  call void (i8*, ...)* @_Jv_InitClass(i8* bitcast (%struct.java.lang.Class* @"_ZN4java4lang6System6class$E" to i8*)), !dbg !185
  br label %"8", !dbg !185

"8":                                              ; preds = %"7", %"6"
  %23 = load %struct.java.io.PrintStream** @_ZN4java4lang6System3outE, align 4, !dbg !185
  %24 = bitcast %struct.java.io.PrintStream* %23 to i8*, !dbg !185
  %25 = call noalias i8* (%struct.java.lang.Class*, ...)* @_Jv_AllocObjectNoFinalizer(%struct.java.lang.Class* @"_ZN4java4lang13StringBuilder6class$E"), !dbg !185
  %26 = load i8** getelementptr inbounds ([5 x i8*]* @_CD_HelloWorld, i32 0, i32 2), align 4, !dbg !185
  %27 = bitcast i8* %25 to %struct.java.lang.StringBuilder*, !dbg !185
  %28 = bitcast i8* %26 to %struct.java.lang.String*, !dbg !185
  call void @_ZN4java4lang13StringBuilderC1EPNS0_6StringE(%struct.java.lang.StringBuilder* %27, %struct.java.lang.String* %28), !dbg !185
  %29 = icmp eq i8* %25, null, !dbg !185
  br i1 %29, label %"9", label %"10", !dbg !185

"9":                                              ; preds = %"8"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !185
  unreachable, !dbg !185

"10":                                             ; preds = %"8"
  %30 = bitcast i8* %25 to %struct.java.lang.StringBuilder*, !dbg !185
  %31 = bitcast i8* %25 to %struct.java.lang.StringBuilder*, !dbg !185
  %32 = call %struct.java.lang.StringBuilder* @_ZN4java4lang13StringBuilder6appendEJPS1_i(%struct.java.lang.StringBuilder* %31, i32 %22), !dbg !185
  %33 = bitcast %struct.java.lang.StringBuilder* %32 to i8*, !dbg !185
  %34 = icmp eq i8* %33, null, !dbg !185
  br i1 %34, label %"11", label %"12", !dbg !185

"11":                                             ; preds = %"10"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !185
  unreachable, !dbg !185

"12":                                             ; preds = %"10"
  %35 = bitcast i8* %33 to %struct.java.lang.StringBuilder*, !dbg !185
  %36 = bitcast i8* %33 to %struct.java.lang.StringBuilder*, !dbg !185
  %37 = call %struct.java.lang.String* @_ZN4java4lang13StringBuilder8toStringEJPNS0_6StringEv(%struct.java.lang.StringBuilder* %36), !dbg !185
  %38 = bitcast %struct.java.lang.String* %37 to i8*, !dbg !185
  %39 = bitcast i8* %24 to %struct.java.lang.Object*, !dbg !185
  %40 = getelementptr inbounds %struct.java.lang.Object* %39, i32 0, i32 0, !dbg !185
  %41 = load %0** %40, align 4, !dbg !185
  %42 = bitcast %0* %41 to i8*, !dbg !185
  %43 = getelementptr i8* %42, i32 124, !dbg !185
  %44 = bitcast i8* %43 to i8**, !dbg !185
  %45 = load i8** %44, align 4, !dbg !185
  %46 = bitcast i8* %45 to void (%struct.java.io.PrintStream*, %struct.java.lang.String*)*, !dbg !185
  %47 = bitcast i8* %24 to %struct.java.io.PrintStream*, !dbg !185
  %48 = bitcast i8* %38 to %struct.java.lang.String*, !dbg !185
  call void %46(%struct.java.io.PrintStream* %47, %struct.java.lang.String* %48), !dbg !185
  %49 = call noalias i8* (i8*, i32, ...)* @_Jv_NewPrimArray(i8* bitcast (%struct.java.lang.Class* @_Jv_intClass to i8*), i32 200), !dbg !186
  br label %"16", !dbg !187

"13":                                             ; preds = %"16"
  %50 = bitcast i8* %49 to %struct.java.lang.Object*, !dbg !188
  %51 = bitcast %struct.java.lang.Object* %50 to i8*, !dbg !188
  %52 = bitcast i8* %51 to %"struct.int[]"*, !dbg !188
  %53 = bitcast %"struct.int[]"* %52 to i8*, !dbg !188
  %54 = getelementptr inbounds i8* %53, i32 8, !dbg !188
  %55 = bitcast i8* %54 to [0 x i32]*, !dbg !188
  %56 = bitcast i8* %51 to %"struct.int[]"*, !dbg !188
  %57 = getelementptr inbounds %"struct.int[]"* %56, i32 0, i32 1, !dbg !188
  %58 = load i32* %57, align 4, !dbg !188
  %59 = icmp uge i32 %65, %58, !dbg !188
  br i1 %59, label %"14", label %"15", !dbg !188

"14":                                             ; preds = %"13"
  call void (i32, ...)* @_Jv_ThrowBadArrayIndex(i32 %65) noreturn, !dbg !188
  unreachable, !dbg !188

"15":                                             ; preds = %"13"
  %60 = mul i32 %65, 4, !dbg !188
  %61 = bitcast [0 x i32]* %55 to i8*, !dbg !188
  %62 = getelementptr i8* %61, i32 %60, !dbg !188
  %63 = bitcast i8* %62 to i32*, !dbg !188
  store i32 %65, i32* %63, align 4, !dbg !188
  %64 = add i32 %65, 1, !dbg !187
  br label %"16", !dbg !187

"16":                                             ; preds = %"15", %"12"
  %65 = phi i32 [ %64, %"15" ], [ 0, %"12" ], !dbg !187
  %66 = icmp slt i32 %65, 200, !dbg !187
  br i1 %66, label %"13", label %"17", !dbg !187

"17":                                             ; preds = %"16"
  %67 = bitcast i8* %15 to %struct.java.lang.Object*, !dbg !189
  %68 = bitcast %struct.java.lang.Object* %67 to i8*, !dbg !189
  %69 = bitcast i8* %49 to %struct.java.lang.Object*, !dbg !189
  %70 = bitcast %struct.java.lang.Object* %69 to i8*, !dbg !189
  %71 = icmp eq i8* %68, null, !dbg !189
  br i1 %71, label %"18", label %"19", !dbg !189

"18":                                             ; preds = %"17"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !189
  unreachable, !dbg !189

"19":                                             ; preds = %"17"
  %72 = bitcast i8* %68 to %struct.HelloWorld*, !dbg !189
  %73 = bitcast i8* %68 to %struct.HelloWorld*, !dbg !189
  %74 = bitcast i8* %70 to %"struct.int[]"*, !dbg !189
  %75 = call i32 @_ZN10HelloWorld12testArraySumEJiP6JArrayIiE(%struct.HelloWorld* %73, %"struct.int[]"* %74) uwtable, !dbg !189
  br i1 false, label %"20", label %"21", !dbg !190

"20":                                             ; preds = %"19"
  call void (i8*, ...)* @_Jv_InitClass(i8* bitcast (%struct.java.lang.Class* @"_ZN4java4lang6System6class$E" to i8*)), !dbg !190
  br label %"21", !dbg !190

"21":                                             ; preds = %"20", %"19"
  %76 = load %struct.java.io.PrintStream** @_ZN4java4lang6System3outE, align 4, !dbg !190
  %77 = bitcast %struct.java.io.PrintStream* %76 to i8*, !dbg !190
  %78 = call noalias i8* (%struct.java.lang.Class*, ...)* @_Jv_AllocObjectNoFinalizer(%struct.java.lang.Class* @"_ZN4java4lang13StringBuilder6class$E"), !dbg !190
  %79 = load i8** getelementptr inbounds ([5 x i8*]* @_CD_HelloWorld, i32 0, i32 3), align 4, !dbg !190
  %80 = bitcast i8* %78 to %struct.java.lang.StringBuilder*, !dbg !190
  %81 = bitcast i8* %79 to %struct.java.lang.String*, !dbg !190
  call void @_ZN4java4lang13StringBuilderC1EPNS0_6StringE(%struct.java.lang.StringBuilder* %80, %struct.java.lang.String* %81), !dbg !190
  %82 = icmp eq i8* %78, null, !dbg !190
  br i1 %82, label %"22", label %"23", !dbg !190

"22":                                             ; preds = %"21"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !190
  unreachable, !dbg !190

"23":                                             ; preds = %"21"
  %83 = bitcast i8* %78 to %struct.java.lang.StringBuilder*, !dbg !190
  %84 = bitcast i8* %78 to %struct.java.lang.StringBuilder*, !dbg !190
  %85 = call %struct.java.lang.StringBuilder* @_ZN4java4lang13StringBuilder6appendEJPS1_i(%struct.java.lang.StringBuilder* %84, i32 %75), !dbg !190
  %86 = bitcast %struct.java.lang.StringBuilder* %85 to i8*, !dbg !190
  %87 = icmp eq i8* %86, null, !dbg !190
  br i1 %87, label %"24", label %"25", !dbg !190

"24":                                             ; preds = %"23"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !190
  unreachable, !dbg !190

"25":                                             ; preds = %"23"
  %88 = bitcast i8* %86 to %struct.java.lang.StringBuilder*, !dbg !190
  %89 = bitcast i8* %86 to %struct.java.lang.StringBuilder*, !dbg !190
  %90 = call %struct.java.lang.String* @_ZN4java4lang13StringBuilder8toStringEJPNS0_6StringEv(%struct.java.lang.StringBuilder* %89), !dbg !190
  %91 = bitcast %struct.java.lang.String* %90 to i8*, !dbg !190
  %92 = bitcast i8* %77 to %struct.java.lang.Object*, !dbg !190
  %93 = getelementptr inbounds %struct.java.lang.Object* %92, i32 0, i32 0, !dbg !190
  %94 = load %0** %93, align 4, !dbg !190
  %95 = bitcast %0* %94 to i8*, !dbg !190
  %96 = getelementptr i8* %95, i32 124, !dbg !190
  %97 = bitcast i8* %96 to i8**, !dbg !190
  %98 = load i8** %97, align 4, !dbg !190
  %99 = bitcast i8* %98 to void (%struct.java.io.PrintStream*, %struct.java.lang.String*)*, !dbg !190
  %100 = bitcast i8* %77 to %struct.java.io.PrintStream*, !dbg !190
  %101 = bitcast i8* %91 to %struct.java.lang.String*, !dbg !190
  call void %99(%struct.java.io.PrintStream* %100, %struct.java.lang.String* %101), !dbg !190
  %102 = call noalias i8* (%struct.java.lang.Class*, ...)* @_Jv_AllocObjectNoFinalizer(%struct.java.lang.Class* @"_ZN4java4util6Random6class$E"), !dbg !191
  %103 = bitcast i8* %102 to %struct.java.util.Random*, !dbg !191
  call void @_ZN4java4util6RandomC1Ev(%struct.java.util.Random* %103), !dbg !191
  %104 = call noalias i8* (i8*, i32, ...)* @_Jv_NewPrimArray(i8* bitcast (%struct.java.lang.Class* @_Jv_intClass to i8*), i32 100000), !dbg !192
  br label %"29", !dbg !193

"26":                                             ; preds = %"29"
  %105 = bitcast i8* %104 to %struct.java.lang.Object*, !dbg !194
  %106 = bitcast %struct.java.lang.Object* %105 to i8*, !dbg !194
  %107 = bitcast i8* %102 to %struct.java.lang.Object*, !dbg !194
  %108 = bitcast %struct.java.lang.Object* %107 to i8*, !dbg !194
  %109 = bitcast i8* %108 to %struct.java.lang.Object*, !dbg !194
  %110 = getelementptr inbounds %struct.java.lang.Object* %109, i32 0, i32 0, !dbg !194
  %111 = load %0** %110, align 4, !dbg !194
  %112 = bitcast %0* %111 to i8*, !dbg !194
  %113 = getelementptr i8* %112, i32 44, !dbg !194
  %114 = bitcast i8* %113 to i8**, !dbg !194
  %115 = load i8** %114, align 4, !dbg !194
  %116 = bitcast i8* %115 to i32 (%struct.java.util.Random*)*, !dbg !194
  %117 = bitcast i8* %108 to %struct.java.util.Random*, !dbg !194
  %118 = call i32 %116(%struct.java.util.Random* %117), !dbg !194
  %119 = bitcast i8* %106 to %"struct.int[]"*, !dbg !194
  %120 = bitcast %"struct.int[]"* %119 to i8*, !dbg !194
  %121 = getelementptr inbounds i8* %120, i32 8, !dbg !194
  %122 = bitcast i8* %121 to [0 x i32]*, !dbg !194
  %123 = bitcast i8* %106 to %"struct.int[]"*, !dbg !194
  %124 = getelementptr inbounds %"struct.int[]"* %123, i32 0, i32 1, !dbg !194
  %125 = load i32* %124, align 4, !dbg !194
  %126 = icmp uge i32 %132, %125, !dbg !194
  br i1 %126, label %"27", label %"28", !dbg !194

"27":                                             ; preds = %"26"
  call void (i32, ...)* @_Jv_ThrowBadArrayIndex(i32 %132) noreturn, !dbg !194
  unreachable, !dbg !194

"28":                                             ; preds = %"26"
  %127 = mul i32 %132, 4, !dbg !194
  %128 = bitcast [0 x i32]* %122 to i8*, !dbg !194
  %129 = getelementptr i8* %128, i32 %127, !dbg !194
  %130 = bitcast i8* %129 to i32*, !dbg !194
  store i32 %118, i32* %130, align 4, !dbg !194
  %131 = add i32 %132, 1, !dbg !193
  br label %"29", !dbg !193

"29":                                             ; preds = %"28", %"25"
  %132 = phi i32 [ %131, %"28" ], [ 0, %"25" ], !dbg !193
  %133 = icmp slt i32 %132, 100000, !dbg !193
  br i1 %133, label %"26", label %"30", !dbg !193

"30":                                             ; preds = %"29"
  %134 = bitcast i8* %15 to %struct.java.lang.Object*, !dbg !195
  %135 = bitcast %struct.java.lang.Object* %134 to i8*, !dbg !195
  %136 = bitcast i8* %104 to %struct.java.lang.Object*, !dbg !195
  %137 = bitcast %struct.java.lang.Object* %136 to i8*, !dbg !195
  %138 = icmp eq i8* %135, null, !dbg !195
  br i1 %138, label %"31", label %"32", !dbg !195

"31":                                             ; preds = %"30"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !195
  unreachable, !dbg !195

"32":                                             ; preds = %"30"
  %139 = bitcast i8* %135 to %struct.HelloWorld*, !dbg !195
  %140 = bitcast i8* %135 to %struct.HelloWorld*, !dbg !195
  %141 = bitcast i8* %137 to %"struct.int[]"*, !dbg !195
  call void @_ZN10HelloWorld8testSortEJvP6JArrayIiE(%struct.HelloWorld* %140, %"struct.int[]"* %141) uwtable, !dbg !195
  br i1 false, label %"33", label %"34", !dbg !196

"33":                                             ; preds = %"32"
  call void (i8*, ...)* @_Jv_InitClass(i8* bitcast (%struct.java.lang.Class* @"_ZN4java4lang6System6class$E" to i8*)), !dbg !196
  br label %"34", !dbg !196

"34":                                             ; preds = %"33", %"32"
  %142 = load %struct.java.io.PrintStream** @_ZN4java4lang6System3outE, align 4, !dbg !196
  %143 = bitcast %struct.java.io.PrintStream* %142 to i8*, !dbg !196
  %144 = call noalias i8* (%struct.java.lang.Class*, ...)* @_Jv_AllocObjectNoFinalizer(%struct.java.lang.Class* @"_ZN4java4lang13StringBuilder6class$E"), !dbg !196
  %145 = load i8** getelementptr inbounds ([5 x i8*]* @_CD_HelloWorld, i32 0, i32 4), align 4, !dbg !196
  %146 = bitcast i8* %144 to %struct.java.lang.StringBuilder*, !dbg !196
  %147 = bitcast i8* %145 to %struct.java.lang.String*, !dbg !196
  call void @_ZN4java4lang13StringBuilderC1EPNS0_6StringE(%struct.java.lang.StringBuilder* %146, %struct.java.lang.String* %147), !dbg !196
  %148 = icmp eq i8* %144, null, !dbg !196
  br i1 %148, label %"35", label %"36", !dbg !196

"35":                                             ; preds = %"34"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !196
  unreachable, !dbg !196

"36":                                             ; preds = %"34"
  %149 = bitcast i8* %144 to %struct.java.lang.StringBuilder*, !dbg !196
  %150 = bitcast i8* %144 to %struct.java.lang.StringBuilder*, !dbg !196
  %151 = call %struct.java.lang.StringBuilder* @_ZN4java4lang13StringBuilder6appendEJPS1_i(%struct.java.lang.StringBuilder* %150, i32 100000), !dbg !196
  %152 = bitcast %struct.java.lang.StringBuilder* %151 to i8*, !dbg !196
  %153 = icmp eq i8* %152, null, !dbg !196
  br i1 %153, label %"37", label %"38", !dbg !196

"37":                                             ; preds = %"36"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !196
  unreachable, !dbg !196

"38":                                             ; preds = %"36"
  %154 = bitcast i8* %152 to %struct.java.lang.StringBuilder*, !dbg !196
  %155 = bitcast i8* %152 to %struct.java.lang.StringBuilder*, !dbg !196
  %156 = call %struct.java.lang.String* @_ZN4java4lang13StringBuilder8toStringEJPNS0_6StringEv(%struct.java.lang.StringBuilder* %155), !dbg !196
  %157 = bitcast %struct.java.lang.String* %156 to i8*, !dbg !196
  %158 = bitcast i8* %143 to %struct.java.lang.Object*, !dbg !196
  %159 = getelementptr inbounds %struct.java.lang.Object* %158, i32 0, i32 0, !dbg !196
  %160 = load %0** %159, align 4, !dbg !196
  %161 = bitcast %0* %160 to i8*, !dbg !196
  %162 = getelementptr i8* %161, i32 124, !dbg !196
  %163 = bitcast i8* %162 to i8**, !dbg !196
  %164 = load i8** %163, align 4, !dbg !196
  %165 = bitcast i8* %164 to void (%struct.java.io.PrintStream*, %struct.java.lang.String*)*, !dbg !196
  %166 = bitcast i8* %143 to %struct.java.io.PrintStream*, !dbg !196
  %167 = bitcast i8* %157 to %struct.java.lang.String*, !dbg !196
  call void %165(%struct.java.io.PrintStream* %166, %struct.java.lang.String* %167), !dbg !196
  br label %return, !dbg !197

return:                                           ; preds = %"38"
  ret void, !dbg !197
}

declare void @llvm.dbg.declare(metadata, metadata) nounwind readnone

declare void @_ZN4java4lang6ObjectC1Ev(%struct.java.lang.Object*)

declare void @_Jv_ThrowBadArrayIndex(i32, ...) noreturn

declare void @_Jv_InitClass(i8*, ...)

declare noalias i8* @_Jv_AllocObjectNoFinalizer(%struct.java.lang.Class*, ...)

declare void @_Jv_ThrowNullPointerException(...) noreturn

declare void @_ZN4java4lang13StringBuilderC1EPNS0_6StringE(%struct.java.lang.StringBuilder*, %struct.java.lang.String*)

declare %struct.java.lang.StringBuilder* @_ZN4java4lang13StringBuilder6appendEJPS1_i(%struct.java.lang.StringBuilder*, i32)

declare %struct.java.lang.String* @_ZN4java4lang13StringBuilder8toStringEJPNS0_6StringEv(%struct.java.lang.StringBuilder*)

declare noalias i8* @_Jv_NewPrimArray(i8*, i32, ...)

declare void @_ZN4java4util6RandomC1Ev(%struct.java.util.Random*)

define internal void @_Jv_global_static_constructor() unnamed_addr uwtable {
entry:
  %"ssa point" = bitcast i32 0 to i32
  br label %"2"

"2":                                              ; preds = %entry
  call void @_Jv_RegisterResource(i8* bitcast (%23* @"_ZGr8_$_dummy" to i8*))
  br label %return

return:                                           ; preds = %"2"
  ret void
}

declare void @_Jv_RegisterResource(i8*)

!llvm.dbg.gv = !{!0, !7}
!llvm.dbg.sp = !{!10, !129, !132, !142, !145, !156}

!0 = metadata !{i32 655412, i32 0, metadata !1, metadata !"_CT_HelloWorld", metadata !"_CT_HelloWorld", metadata !"", metadata !1, i32 76, metadata !3, i1 true, i1 true, [5 x i8]* @_CT_HelloWorld}
!1 = metadata !{i32 655401, metadata !"HelloWorld.java", metadata !"/home/ubuntu/javasimd/test/class-to-jni/", metadata !2}
!2 = metadata !{i32 655377, i32 0, i32 11, metadata !"HelloWorld.java", metadata !"/home/ubuntu/javasimd/test/class-to-jni/", metadata !"4.6.3", i1 true, i1 false, metadata !"", i32 0}
!3 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 40, i64 8, i64 0, i32 0, metadata !4, metadata !5, i32 0, null}
!4 = metadata !{i32 655396, metadata !1, metadata !"unsigned byte", metadata !1, i32 0, i64 8, i64 8, i64 0, i32 0, i32 7}
!5 = metadata !{metadata !6}
!6 = metadata !{i32 655393, i64 0, i64 4}
!7 = metadata !{i32 655412, i32 0, metadata !1, metadata !"_CD_HelloWorld", metadata !"_CD_HelloWorld", metadata !"", metadata !1, i32 49, metadata !8, i1 true, i1 true, [5 x i8*]* @_CD_HelloWorld}
!8 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 160, i64 32, i64 0, i32 0, metadata !9, metadata !5, i32 0, null}
!9 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, null}
!10 = metadata !{i32 655406, i32 0, metadata !11, metadata !"HelloWorld::HelloWorld", metadata !"HelloWorld::HelloWorld", metadata !"_ZN10HelloWorldC1Ev", metadata !1, i32 21, metadata !126, i1 false, i1 true, i32 0, i32 0, null, i32 0, i1 false, null}
!11 = metadata !{i32 655379, metadata !1, metadata !"HelloWorld", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, null, metadata !12, i32 0, metadata !14}
!12 = metadata !{metadata !13}
!13 = metadata !{i32 655388, metadata !1, metadata !"", null, i32 0, i64 0, i64 0, i64 0, i32 0, metadata !14}
!14 = metadata !{i32 655379, metadata !1, metadata !"java.lang.Object", metadata !15, i32 0, i64 32, i64 32, i64 0, i32 0, null, metadata !16, i32 0, metadata !14}
!15 = metadata !{i32 655401, metadata !"Object.java", metadata !"/home/ubuntu/javasimd/test/class-to-jni/java/lang", metadata !2}
!16 = metadata !{metadata !17}
!17 = metadata !{i32 655373, metadata !14, metadata !"vtable", metadata !18, i32 0, i64 32, i64 32, i64 0, i32 1, metadata !19}
!18 = metadata !{i32 655401, metadata !"<built-in>", metadata !"/home/ubuntu/javasimd/test/class-to-jni/", metadata !2}
!19 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !20}
!20 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 96, i64 32, i64 0, i32 0, null, metadata !21, i32 0, null}
!21 = metadata !{metadata !22, metadata !125}
!22 = metadata !{i32 655373, metadata !20, metadata !"class", metadata !18, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !23}
!23 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !24}
!24 = metadata !{i32 655379, metadata !1, metadata !"java.lang.Class", metadata !25, i32 0, i64 1152, i64 32, i64 0, i32 0, null, metadata !26, i32 0, metadata !14}
!25 = metadata !{i32 655401, metadata !"Class.java", metadata !"/home/ubuntu/javasimd/test/class-to-jni/java/lang", metadata !2}
!26 = metadata !{metadata !13, metadata !27, metadata !30, metadata !33, metadata !36, metadata !39, metadata !40, metadata !47, metadata !48, metadata !49, metadata !56, metadata !66, metadata !68, metadata !69, metadata !83, metadata !84, metadata !85, metadata !86, metadata !87, metadata !92, metadata !100, metadata !103, metadata !104, metadata !105, metadata !106, metadata !107, metadata !109, metadata !110, metadata !111, metadata !113, metadata !114, metadata !115, metadata !116, metadata !117, metadata !118, metadata !119, metadata !120, metadata !121, metadata !122, metadata !123, metadata !124}
!27 = metadata !{i32 655388, metadata !1, metadata !"", null, i32 0, i64 0, i64 0, i64 0, i32 32, metadata !28}
!28 = metadata !{i32 655379, metadata !1, metadata !"java.lang.reflect.Type", metadata !29, i32 0, i64 32, i64 32, i64 0, i32 0, null, metadata !12, i32 0, metadata !14}
!29 = metadata !{i32 655401, metadata !"Type.java", metadata !"/home/ubuntu/javasimd/test/class-to-jni/java/lang/reflect", metadata !2}
!30 = metadata !{i32 655388, metadata !1, metadata !"", null, i32 0, i64 0, i64 0, i64 0, i32 32, metadata !31}
!31 = metadata !{i32 655379, metadata !1, metadata !"java.lang.reflect.AnnotatedElement", metadata !32, i32 0, i64 32, i64 32, i64 0, i32 0, null, metadata !12, i32 0, metadata !14}
!32 = metadata !{i32 655401, metadata !"AnnotatedElement.java", metadata !"/home/ubuntu/javasimd/test/class-to-jni/java/lang/reflect", metadata !2}
!33 = metadata !{i32 655388, metadata !1, metadata !"", null, i32 0, i64 0, i64 0, i64 0, i32 32, metadata !34}
!34 = metadata !{i32 655379, metadata !1, metadata !"java.lang.reflect.GenericDeclaration", metadata !35, i32 0, i64 32, i64 32, i64 0, i32 0, null, metadata !12, i32 0, metadata !14}
!35 = metadata !{i32 655401, metadata !"GenericDeclaration.java", metadata !"/home/ubuntu/javasimd/test/class-to-jni/java/lang/reflect", metadata !2}
!36 = metadata !{i32 655388, metadata !1, metadata !"", null, i32 0, i64 0, i64 0, i64 0, i32 32, metadata !37}
!37 = metadata !{i32 655379, metadata !1, metadata !"java.io.Serializable", metadata !38, i32 0, i64 32, i64 32, i64 0, i32 0, null, metadata !12, i32 0, metadata !14}
!38 = metadata !{i32 655401, metadata !"Serializable.java", metadata !"/home/ubuntu/javasimd/test/class-to-jni/java/io", metadata !2}
!39 = metadata !{i32 655373, metadata !24, metadata !"next_or_version", metadata !18, i32 0, i64 32, i64 32, i64 32, i32 1, metadata !23}
!40 = metadata !{i32 655373, metadata !24, metadata !"name", metadata !18, i32 0, i64 32, i64 32, i64 64, i32 1, metadata !41}
!41 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !42}
!42 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 16, i64 0, i32 0, null, metadata !43, i32 0, null}
!43 = metadata !{metadata !44, metadata !46}
!44 = metadata !{i32 655373, metadata !42, metadata !"hash", metadata !18, i32 0, i64 16, i64 16, i64 0, i32 0, metadata !45}
!45 = metadata !{i32 655396, metadata !1, metadata !"unsigned short", metadata !1, i32 0, i64 16, i64 16, i64 0, i32 0, i32 7}
!46 = metadata !{i32 655373, metadata !42, metadata !"length", metadata !18, i32 0, i64 16, i64 16, i64 16, i32 0, metadata !45}
!47 = metadata !{i32 655373, metadata !24, metadata !"accflags", metadata !18, i32 0, i64 16, i64 16, i64 96, i32 1, metadata !45}
!48 = metadata !{i32 655373, metadata !24, metadata !"superclass", metadata !18, i32 0, i64 32, i64 32, i64 128, i32 1, metadata !23}
!49 = metadata !{i32 655373, metadata !24, metadata !"constants", metadata !18, i32 0, i64 96, i64 32, i64 160, i32 1, metadata !50}
!50 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 96, i64 32, i64 0, i32 0, null, metadata !51, i32 0, null}
!51 = metadata !{metadata !52, metadata !54, metadata !55}
!52 = metadata !{i32 655373, metadata !50, metadata !"size", metadata !18, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !53}
!53 = metadata !{i32 655396, metadata !1, metadata !"unsigned int", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, i32 7}
!54 = metadata !{i32 655373, metadata !50, metadata !"tags", metadata !18, i32 0, i64 32, i64 32, i64 32, i32 0, metadata !9}
!55 = metadata !{i32 655373, metadata !50, metadata !"data", metadata !18, i32 0, i64 32, i64 32, i64 64, i32 0, metadata !9}
!56 = metadata !{i32 655373, metadata !24, metadata !"methods", metadata !18, i32 0, i64 32, i64 32, i64 256, i32 1, metadata !57}
!57 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !58}
!58 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 160, i64 32, i64 0, i32 0, null, metadata !59, i32 0, null}
!59 = metadata !{metadata !60, metadata !61, metadata !62, metadata !63, metadata !64, metadata !65}
!60 = metadata !{i32 655373, metadata !58, metadata !"name", metadata !18, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !41}
!61 = metadata !{i32 655373, metadata !58, metadata !"signature", metadata !18, i32 0, i64 32, i64 32, i64 32, i32 0, metadata !41}
!62 = metadata !{i32 655373, metadata !58, metadata !"accflags", metadata !18, i32 0, i64 16, i64 16, i64 64, i32 0, metadata !45}
!63 = metadata !{i32 655373, metadata !58, metadata !"index", metadata !18, i32 0, i64 16, i64 16, i64 80, i32 0, metadata !45}
!64 = metadata !{i32 655373, metadata !58, metadata !"ncode", metadata !18, i32 0, i64 32, i64 32, i64 96, i32 0, metadata !9}
!65 = metadata !{i32 655373, metadata !58, metadata !"throws", metadata !18, i32 0, i64 32, i64 32, i64 128, i32 0, metadata !9}
!66 = metadata !{i32 655373, metadata !24, metadata !"method_count", metadata !18, i32 0, i64 16, i64 16, i64 288, i32 1, metadata !67}
!67 = metadata !{i32 655396, metadata !1, metadata !"short", metadata !1, i32 0, i64 16, i64 16, i64 0, i32 0, i32 5}
!68 = metadata !{i32 655373, metadata !24, metadata !"vtable_method_count", metadata !18, i32 0, i64 16, i64 16, i64 304, i32 1, metadata !67}
!69 = metadata !{i32 655373, metadata !24, metadata !"fields", metadata !18, i32 0, i64 32, i64 32, i64 320, i32 1, metadata !70}
!70 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !71}
!71 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 128, i64 32, i64 0, i32 0, null, metadata !72, i32 0, null}
!72 = metadata !{metadata !73, metadata !74, metadata !75, metadata !76, metadata !77}
!73 = metadata !{i32 655373, metadata !71, metadata !"name", metadata !18, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !41}
!74 = metadata !{i32 655373, metadata !71, metadata !"type", metadata !18, i32 0, i64 32, i64 32, i64 32, i32 0, metadata !23}
!75 = metadata !{i32 655373, metadata !71, metadata !"accflags", metadata !18, i32 0, i64 16, i64 16, i64 64, i32 0, metadata !45}
!76 = metadata !{i32 655373, metadata !71, metadata !"bsize", metadata !18, i32 0, i64 16, i64 16, i64 80, i32 0, metadata !45}
!77 = metadata !{i32 655373, metadata !71, metadata !"info", metadata !18, i32 0, i64 32, i64 32, i64 96, i32 0, metadata !78}
!78 = metadata !{i32 655383, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, null, metadata !79, i32 0, null}
!79 = metadata !{metadata !80, metadata !82}
!80 = metadata !{i32 655373, metadata !78, metadata !"boffset", metadata !18, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !81}
!81 = metadata !{i32 655396, metadata !1, metadata !"int", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, i32 5}
!82 = metadata !{i32 655373, metadata !78, metadata !"addr", metadata !18, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !9}
!83 = metadata !{i32 655373, metadata !24, metadata !"size_in_bytes", metadata !18, i32 0, i64 32, i64 32, i64 352, i32 1, metadata !81}
!84 = metadata !{i32 655373, metadata !24, metadata !"field_count", metadata !18, i32 0, i64 16, i64 16, i64 384, i32 1, metadata !67}
!85 = metadata !{i32 655373, metadata !24, metadata !"static_field_count", metadata !18, i32 0, i64 16, i64 16, i64 400, i32 1, metadata !67}
!86 = metadata !{i32 655373, metadata !24, metadata !"vtable", metadata !18, i32 0, i64 32, i64 32, i64 416, i32 1, metadata !19}
!87 = metadata !{i32 655373, metadata !24, metadata !"otable", metadata !18, i32 0, i64 32, i64 32, i64 448, i32 1, metadata !88}
!88 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !89}
!89 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 32, i64 0, i32 0, metadata !81, metadata !90, i32 0, null}
!90 = metadata !{metadata !91}
!91 = metadata !{i32 655393, i64 0, i64 1}
!92 = metadata !{i32 655373, metadata !24, metadata !"otable_syms", metadata !18, i32 0, i64 32, i64 32, i64 480, i32 1, metadata !93}
!93 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !94}
!94 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 192, i64 32, i64 0, i32 0, metadata !95, metadata !90, i32 0, null}
!95 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 96, i64 32, i64 0, i32 0, null, metadata !96, i32 0, null}
!96 = metadata !{metadata !97, metadata !98, metadata !99}
!97 = metadata !{i32 655373, metadata !95, metadata !"clname", metadata !18, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !41}
!98 = metadata !{i32 655373, metadata !95, metadata !"name", metadata !18, i32 0, i64 32, i64 32, i64 32, i32 0, metadata !41}
!99 = metadata !{i32 655373, metadata !95, metadata !"signature", metadata !18, i32 0, i64 32, i64 32, i64 64, i32 0, metadata !41}
!100 = metadata !{i32 655373, metadata !24, metadata !"atable", metadata !18, i32 0, i64 32, i64 32, i64 512, i32 1, metadata !101}
!101 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !102}
!102 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 32, i64 0, i32 0, metadata !9, metadata !90, i32 0, null}
!103 = metadata !{i32 655373, metadata !24, metadata !"atable_syms", metadata !18, i32 0, i64 32, i64 32, i64 544, i32 1, metadata !93}
!104 = metadata !{i32 655373, metadata !24, metadata !"itable", metadata !18, i32 0, i64 32, i64 32, i64 576, i32 1, metadata !101}
!105 = metadata !{i32 655373, metadata !24, metadata !"itable_syms", metadata !18, i32 0, i64 32, i64 32, i64 608, i32 1, metadata !93}
!106 = metadata !{i32 655373, metadata !24, metadata !"catch_classes", metadata !18, i32 0, i64 32, i64 32, i64 640, i32 1, metadata !9}
!107 = metadata !{i32 655373, metadata !24, metadata !"interfaces", metadata !18, i32 0, i64 32, i64 32, i64 672, i32 1, metadata !108}
!108 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !23}
!109 = metadata !{i32 655373, metadata !24, metadata !"loader", metadata !18, i32 0, i64 32, i64 32, i64 704, i32 1, metadata !9}
!110 = metadata !{i32 655373, metadata !24, metadata !"interface_count", metadata !18, i32 0, i64 16, i64 16, i64 736, i32 1, metadata !67}
!111 = metadata !{i32 655373, metadata !24, metadata !"state", metadata !18, i32 0, i64 8, i64 8, i64 752, i32 1, metadata !112}
!112 = metadata !{i32 655396, metadata !1, metadata !"byte", metadata !1, i32 0, i64 8, i64 8, i64 0, i32 0, i32 5}
!113 = metadata !{i32 655373, metadata !24, metadata !"thread", metadata !18, i32 0, i64 32, i64 32, i64 768, i32 1, metadata !9}
!114 = metadata !{i32 655373, metadata !24, metadata !"depth", metadata !18, i32 0, i64 16, i64 16, i64 800, i32 1, metadata !67}
!115 = metadata !{i32 655373, metadata !24, metadata !"ancestors", metadata !18, i32 0, i64 32, i64 32, i64 832, i32 1, metadata !9}
!116 = metadata !{i32 655373, metadata !24, metadata !"idt", metadata !18, i32 0, i64 32, i64 32, i64 864, i32 1, metadata !9}
!117 = metadata !{i32 655373, metadata !24, metadata !"arrayclass", metadata !18, i32 0, i64 32, i64 32, i64 896, i32 1, metadata !9}
!118 = metadata !{i32 655373, metadata !24, metadata !"protectionDomain", metadata !18, i32 0, i64 32, i64 32, i64 928, i32 1, metadata !9}
!119 = metadata !{i32 655373, metadata !24, metadata !"assertion_table", metadata !18, i32 0, i64 32, i64 32, i64 960, i32 1, metadata !9}
!120 = metadata !{i32 655373, metadata !24, metadata !"hack_signers", metadata !18, i32 0, i64 32, i64 32, i64 992, i32 1, metadata !9}
!121 = metadata !{i32 655373, metadata !24, metadata !"chain", metadata !18, i32 0, i64 32, i64 32, i64 1024, i32 1, metadata !9}
!122 = metadata !{i32 655373, metadata !24, metadata !"aux_info", metadata !18, i32 0, i64 32, i64 32, i64 1056, i32 1, metadata !9}
!123 = metadata !{i32 655373, metadata !24, metadata !"engine", metadata !18, i32 0, i64 32, i64 32, i64 1088, i32 1, metadata !9}
!124 = metadata !{i32 655373, metadata !24, metadata !"reflection_data", metadata !18, i32 0, i64 32, i64 32, i64 1120, i32 1, metadata !9}
!125 = metadata !{i32 655373, metadata !20, metadata !"methods", metadata !18, i32 0, i64 64, i64 32, i64 32, i32 0, metadata !102}
!126 = metadata !{i32 655381, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 0, i64 0, i32 0, null, metadata !127, i32 0, null}
!127 = metadata !{null, metadata !128}
!128 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 64, metadata !11}
!129 = metadata !{i32 655406, i32 0, metadata !11, metadata !"HelloWorld::testSum", metadata !"HelloWorld::testSum", metadata !"_ZN10HelloWorld7testSumEJii", metadata !1, i32 24, metadata !130, i1 false, i1 true, i32 0, i32 0, null, i32 0, i1 false, null}
!130 = metadata !{i32 655381, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 0, i64 0, i32 0, null, metadata !131, i32 0, null}
!131 = metadata !{metadata !81, metadata !128, metadata !81}
!132 = metadata !{i32 655406, i32 0, metadata !11, metadata !"HelloWorld::testArraySum", metadata !"HelloWorld::testArraySum", metadata !"_ZN10HelloWorld12testArraySumEJiP6JArrayIiE", metadata !1, i32 31, metadata !133, i1 false, i1 true, i32 0, i32 0, null, i32 0, i1 false, null}
!133 = metadata !{i32 655381, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 0, i64 0, i32 0, null, metadata !134, i32 0, null}
!134 = metadata !{metadata !81, metadata !128, metadata !135}
!135 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !136}
!136 = metadata !{i32 655379, metadata !1, metadata !"int[]", metadata !1, i32 0, i64 64, i64 32, i64 0, i32 0, null, metadata !137, i32 0, metadata !14}
!137 = metadata !{metadata !13, metadata !138, metadata !139}
!138 = metadata !{i32 655373, metadata !136, metadata !"length", metadata !1, i32 0, i64 32, i64 32, i64 32, i32 0, metadata !81}
!139 = metadata !{i32 655373, metadata !136, metadata !"data", metadata !1, i32 0, i64 0, i64 32, i64 64, i32 0, metadata !140}
!140 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 32, i64 0, i32 0, metadata !81, metadata !141, i32 0, null}
!141 = metadata !{i32 0}
!142 = metadata !{i32 655406, i32 0, metadata !11, metadata !"HelloWorld::testSort", metadata !"HelloWorld::testSort", metadata !"_ZN10HelloWorld8testSortEJvP6JArrayIiE", metadata !1, i32 39, metadata !143, i1 false, i1 true, i32 0, i32 0, null, i32 0, i1 false, null}
!143 = metadata !{i32 655381, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 0, i64 0, i32 0, null, metadata !144, i32 0, null}
!144 = metadata !{null, metadata !128, metadata !135}
!145 = metadata !{i32 655406, i32 0, metadata !11, metadata !"HelloWorld::main", metadata !"HelloWorld::main", metadata !"_ZN10HelloWorld4mainEJvP6JArrayIPN4java4lang6StringEE", metadata !1, i32 49, metadata !146, i1 false, i1 true, i32 0, i32 0, null, i32 0, i1 false, null}
!146 = metadata !{i32 655381, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 0, i64 0, i32 0, null, metadata !147, i32 0, null}
!147 = metadata !{null, metadata !148}
!148 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !149}
!149 = metadata !{i32 655379, metadata !1, metadata !"java.lang.String[]", metadata !1, i32 0, i64 64, i64 32, i64 0, i32 0, null, metadata !150, i32 0, metadata !14}
!150 = metadata !{metadata !13, metadata !151, metadata !152}
!151 = metadata !{i32 655373, metadata !149, metadata !"length", metadata !1, i32 0, i64 32, i64 32, i64 32, i32 0, metadata !81}
!152 = metadata !{i32 655373, metadata !149, metadata !"data", metadata !1, i32 0, i64 0, i64 32, i64 64, i32 0, metadata !153}
!153 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 32, i64 0, i32 0, metadata !154, metadata !141, i32 0, null}
!154 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !155}
!155 = metadata !{i32 655379, metadata !1, metadata !"java.lang.String", metadata !18, i32 0, i64 0, i64 0, i64 0, i32 4, null, null, i32 0, null}
!156 = metadata !{i32 655406, i32 0, metadata !1, metadata !"_Jv_global_static_constructor", metadata !"_Jv_global_static_constructor", metadata !"_Jv_global_static_constructor", metadata !1, i32 0, metadata !157, i1 true, i1 true, i32 0, i32 0, null, i32 1, i1 false, null}
!157 = metadata !{i32 655381, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 0, i64 0, i32 0, null, metadata !158, i32 0, null}
!158 = metadata !{null}
!159 = metadata !{i32 655617, metadata !10, metadata !"unnamed_arg", metadata !1, i32 21, metadata !128, i32 0, i32 0}
!160 = metadata !{i32 21, i32 0, metadata !10, null}
!161 = metadata !{i32 655617, metadata !129, metadata !"unnamed_arg", metadata !1, i32 24, metadata !128, i32 0, i32 0}
!162 = metadata !{i32 24, i32 0, metadata !129, null}
!163 = metadata !{i32 655617, metadata !129, metadata !"unnamed_arg", metadata !1, i32 24, metadata !81, i32 0, i32 0}
!164 = metadata !{i32 25, i32 0, metadata !129, null}
!165 = metadata !{i32 26, i32 0, metadata !129, null}
!166 = metadata !{i32 27, i32 0, metadata !129, null}
!167 = metadata !{i32 655617, metadata !132, metadata !"unnamed_arg", metadata !1, i32 31, metadata !128, i32 0, i32 0}
!168 = metadata !{i32 31, i32 0, metadata !132, null}
!169 = metadata !{i32 655617, metadata !132, metadata !"unnamed_arg", metadata !1, i32 31, metadata !135, i32 0, i32 0}
!170 = metadata !{i32 32, i32 0, metadata !132, null}
!171 = metadata !{i32 33, i32 0, metadata !132, null}
!172 = metadata !{i32 34, i32 0, metadata !132, null}
!173 = metadata !{i32 655617, metadata !142, metadata !"unnamed_arg", metadata !1, i32 39, metadata !128, i32 0, i32 0}
!174 = metadata !{i32 39, i32 0, metadata !142, null}
!175 = metadata !{i32 655617, metadata !142, metadata !"unnamed_arg", metadata !1, i32 39, metadata !135, i32 0, i32 0}
!176 = metadata !{i32 41, i32 0, metadata !142, null}
!177 = metadata !{i32 42, i32 0, metadata !142, null}
!178 = metadata !{i32 43, i32 0, metadata !142, null}
!179 = metadata !{i32 44, i32 0, metadata !142, null}
!180 = metadata !{i32 46, i32 0, metadata !142, null}
!181 = metadata !{i32 655617, metadata !145, metadata !"unnamed_arg", metadata !1, i32 49, metadata !148, i32 0, i32 0}
!182 = metadata !{i32 49, i32 0, metadata !145, null}
!183 = metadata !{i32 50, i32 0, metadata !145, null}
!184 = metadata !{i32 53, i32 0, metadata !145, null}
!185 = metadata !{i32 54, i32 0, metadata !145, null}
!186 = metadata !{i32 57, i32 0, metadata !145, null}
!187 = metadata !{i32 58, i32 0, metadata !145, null}
!188 = metadata !{i32 59, i32 0, metadata !145, null}
!189 = metadata !{i32 60, i32 0, metadata !145, null}
!190 = metadata !{i32 61, i32 0, metadata !145, null}
!191 = metadata !{i32 65, i32 0, metadata !145, null}
!192 = metadata !{i32 66, i32 0, metadata !145, null}
!193 = metadata !{i32 67, i32 0, metadata !145, null}
!194 = metadata !{i32 68, i32 0, metadata !145, null}
!195 = metadata !{i32 69, i32 0, metadata !145, null}
!196 = metadata !{i32 75, i32 0, metadata !145, null}
!197 = metadata !{i32 76, i32 0, metadata !145, null}
