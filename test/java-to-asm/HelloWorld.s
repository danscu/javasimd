; ModuleID = 'HelloWorld.java'
target datalayout = "e-p:64:64:64-S128-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:64:64-f16:16:16-f32:32:32-f64:64:64-f128:128:128-v64:64:64-v128:128:128-a0:0:64-s0:64:64-f80:128:128-n8:16:32:64"
target triple = "x86_64--linux-gnu"

module asm "\09.ident\09\22GCC: (Ubuntu/Linaro 4.6.3-1ubuntu2) 4.6.3 LLVM: 3.2svn\22"

%0 = type { %struct.java.lang.Class*, [2 x i8*] }
%1 = type { i16, i16 }
%2 = type { i32, i8*, i8* }
%3 = type { %1*, %1*, i16, i16, i8*, i8* }
%4 = type { %1*, %struct.java.lang.Class*, i16, i16, [4 x i8], %5 }
%5 = type { i32, [4 x i8] }
%6 = type { %1*, %1*, %1* }
%7 = type { i16, i16, [12 x i8] }
%8 = type { i16, i16, [14 x i8] }
%9 = type { i16, i16, [8 x i8] }
%10 = type { i16, i16, [8 x i8] }
%11 = type { i16, i16, [4 x i8] }
%12 = type { i16, i16, [8 x i8] }
%13 = type { i16, i16, [6 x i8] }
%14 = type { i16, i16, [6 x i8] }
%15 = type { i16, i16, [24 x i8] }
%16 = type { %1*, i8* }
%17 = type { i32, i32, [6 x i8], [2 x i8] }
%struct.java.lang.Class = type { %struct.java.lang.Object, %struct.java.lang.Class*, %1*, i16, %struct.java.lang.Class*, %2, %3*, i16, i16, %4*, i32, i16, i16, %0*, [2 x i32]*, [2 x %6]*, [2 x i8*]*, [2 x %6]*, [2 x i8*]*, [2 x %6]*, i8*, {}*, i8*, i16, i8, i8*, i16, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8* }
%struct.java.lang.Object = type { %0* }
%struct.java.io.PrintStream = type { %struct.java.io.FilterOutputStream, %struct.gnu.gcj.convert.UnicodeToBytes*, %"struct.char[]"*, %"struct.byte[]"*, i8, i8, [6 x i8] }
%struct.java.io.FilterOutputStream = type { %struct.java.io.OutputStream, %struct.java.io.OutputStream* }
%struct.java.io.OutputStream = type { %struct.java.lang.Object }
%struct.gnu.gcj.convert.UnicodeToBytes = type opaque
%"struct.char[]" = type { %struct.java.lang.Object, i32, [4 x i8] }
%"struct.byte[]" = type { %struct.java.lang.Object, i32, [4 x i8] }
%struct.java.lang.String = type opaque
%struct.HelloWorld = type { %struct.java.lang.Object }
%"struct.java.lang.String[]" = type { %struct.java.lang.Object, i32, [4 x i8] }
%struct.java.lang.StringBuilder = type { %struct.java.lang.AbstractStringBuffer }
%struct.java.lang.AbstractStringBuffer = type { %struct.java.lang.Object, i32, %"struct.char[]"* }

@"_ZN10HelloWorld7class$$E" = hidden unnamed_addr constant %struct.java.lang.Class* @"_ZN10HelloWorld6class$E"
@"_ZN10HelloWorld6class$E" = global %struct.java.lang.Class { %struct.java.lang.Object { %0* bitcast (i8** getelementptr inbounds (%0* @_ZTVN4java4lang5ClassE, i64 0, i32 1, i64 1) to %0*) }, %struct.java.lang.Class* inttoptr (i64 406000 to %struct.java.lang.Class*), %1* bitcast (%7* @_Utf9 to %1*), i16 33, %struct.java.lang.Class* @"_ZN4java4lang6Object6class$E", %2 { i32 3, i8* getelementptr inbounds ([3 x i8]* @_CT_HelloWorld, i64 0, i64 0), i8* bitcast ([3 x i8*]* @_CD_HelloWorld to i8*) }, %3* getelementptr inbounds ([3 x %3]* @_MT_HelloWorld, i64 0, i64 0), i16 3, i16 6, %4* null, i32 8, i16 0, i16 0, %0* bitcast (i8** getelementptr inbounds ([10 x i8*]* @_ZTVN10HelloWorldE, i64 0, i64 2) to %0*), [2 x i32]* null, [2 x %6]* null, [2 x i8*]* null, [2 x %6]* null, [2 x i8*]* null, [2 x %6]* null, i8* bitcast ([3 x %16]* @_catch_classes_HelloWorld to i8*), {}* null, i8* null, i16 0, i8 1, i8* null, i16 0, i8* null, i8* null, i8* null, i8* null, i8* null, i8* null, i8* null, i8* null, i8* null, i8* null }, align 32
@_ZTVN4java4lang5ClassE = external global %0
@_Utf9 = internal unnamed_addr constant %7 { i16 -24064, i16 10, [12 x i8] c"HelloWorld\00\00" }
@"_ZN4java4lang6Object6class$E" = external global %struct.java.lang.Class
@_CT_HelloWorld = internal unnamed_addr global [3 x i8] c"\00\08\08"
@_CD_HelloWorld = internal unnamed_addr global [3 x i8*] [i8* null, i8* bitcast (%8* @_Utf8 to i8*), i8* bitcast (%9* @_Utf7 to i8*)], align 16
@_Utf8 = internal unnamed_addr constant %8 { i16 31116, i16 12, [14 x i8] c"Hello, World\00\00" }
@_Utf7 = internal unnamed_addr constant %9 { i16 1432, i16 6, [8 x i8] c"Sum = \00\00" }
@_MT_HelloWorld = internal unnamed_addr global [3 x %3] [%3 { %1* bitcast (%10* @_Utf1 to %1*), %1* bitcast (%11* @_Utf2 to %1*), i16 16385, i16 -1, i8* bitcast (void (%struct.HelloWorld*)* @_ZN10HelloWorldC1Ev to i8*), i8* null }, %3 { %1* bitcast (%12* @_Utf3 to %1*), %1* bitcast (%13* @_Utf4 to %1*), i16 16386, i16 -1, i8* bitcast (i32 (%struct.HelloWorld*, i32)* @_ZN10HelloWorld7testSumEJii to i8*), i8* null }, %3 { %1* bitcast (%14* @_Utf5 to %1*), %1* bitcast (%15* @_Utf6 to %1*), i16 16393, i16 -1, i8* bitcast (void (%"struct.java.lang.String[]"*)* @_ZN10HelloWorld4mainEJvP6JArrayIPN4java4lang6StringEE to i8*), i8* null }], align 32
@_Utf1 = internal unnamed_addr constant %10 { i16 626, i16 6, [8 x i8] c"<init>\00\00" }
@_Utf2 = internal unnamed_addr constant %11 { i16 -25739, i16 3, [4 x i8] c"()V\00" }
@_Utf3 = internal unnamed_addr constant %12 { i16 -8103, i16 7, [8 x i8] c"testSum\00" }
@_Utf4 = internal unnamed_addr constant %13 { i16 17953, i16 4, [6 x i8] c"(I)I\00\00" }
@_Utf5 = internal unnamed_addr constant %14 { i16 1465, i16 4, [6 x i8] c"main\00\00" }
@_Utf6 = internal unnamed_addr constant %15 { i16 -6102, i16 22, [24 x i8] c"([Ljava.lang.String;)V\00\00" }
@_ZTVN10HelloWorldE = hidden unnamed_addr global [10 x i8*] [i8* null, i8* null, i8* bitcast (%struct.java.lang.Class* @"_ZN10HelloWorld6class$E" to i8*), i8* inttoptr (i64 8 to i8*), i8* bitcast (void (%struct.java.lang.Object*)* @_ZN4java4lang6Object8finalizeEJvv to i8*), i8* bitcast (i32 (%struct.java.lang.Object*)* @_ZN4java4lang6Object8hashCodeEJiv to i8*), i8* bitcast (i8 (%struct.java.lang.Object*, %struct.java.lang.Object*)* @_ZN4java4lang6Object6equalsEJbPS1_ to i8*), i8* bitcast (%struct.java.lang.String* (%struct.java.lang.Object*)* @_ZN4java4lang6Object8toStringEJPNS0_6StringEv to i8*), i8* bitcast (%struct.java.lang.Object* (%struct.java.lang.Object*)* @_ZN4java4lang6Object5cloneEJPS1_v to i8*), i8* bitcast (void (%struct.java.lang.Object*)* @_ZN4java4lang6Object22throwNoSuchMethodErrorEJvv to i8*)], align 32
@_catch_classes_HelloWorld = internal unnamed_addr global [3 x %16] zeroinitializer, align 32
@"_ZGr8_$_dummy" = hidden constant %17 { i32 6, i32 0, [6 x i8] c".dummy", [2 x i8] undef }, align 16
@"_ZN4java4lang6System6class$E" = external global %struct.java.lang.Class
@_ZN4java4lang6System3outE = external global %struct.java.io.PrintStream*
@"_ZN4java4lang13StringBuilder6class$E" = external global %struct.java.lang.Class
@llvm.global_ctors = appending global [1 x { i32, void ()* }] [{ i32, void ()* } { i32 65535, void ()* @_Jv_global_static_constructor }]

declare void @_ZN4java4lang6Object8finalizeEJvv(%struct.java.lang.Object*)

declare i32 @_ZN4java4lang6Object8hashCodeEJiv(%struct.java.lang.Object*)

declare zeroext i8 @_ZN4java4lang6Object6equalsEJbPS1_(%struct.java.lang.Object*, %struct.java.lang.Object*)

declare %struct.java.lang.String* @_ZN4java4lang6Object8toStringEJPNS0_6StringEv(%struct.java.lang.Object*)

declare %struct.java.lang.Object* @_ZN4java4lang6Object5cloneEJPS1_v(%struct.java.lang.Object*)

declare void @_ZN4java4lang6Object22throwNoSuchMethodErrorEJvv(%struct.java.lang.Object*)

define void @_ZN10HelloWorldC1Ev(%struct.HelloWorld* %unnamed_arg) uwtable align 2 {
entry:
  %unnamed_arg_addr = alloca %struct.HelloWorld*, align 8
  %"#ref#0#0" = alloca i8*
  %D.236 = alloca %struct.java.lang.Object*
  %"#ref#1#2" = alloca i8*
  %"alloca point" = bitcast i32 0 to i32
  call void @llvm.dbg.declare(metadata !{%struct.HelloWorld** %unnamed_arg_addr}, metadata !147), !dbg !148
  store %struct.HelloWorld* %unnamed_arg, %struct.HelloWorld** %unnamed_arg_addr, align 1
  %0 = load %struct.HelloWorld** %unnamed_arg_addr, align 8
  %"ssa point" = bitcast i32 0 to i32
  br label %"2", !dbg !148

"2":                                              ; preds = %entry
  %1 = bitcast %struct.HelloWorld* %0 to %struct.java.lang.Object*, !dbg !148
  %2 = bitcast %struct.java.lang.Object* %1 to i8*, !dbg !148
  %3 = bitcast i8* %2 to %struct.java.lang.Object*, !dbg !148
  call void @_ZN4java4lang6ObjectC1Ev(%struct.java.lang.Object* %3), !dbg !148
  br label %return, !dbg !148

return:                                           ; preds = %"2"
  ret void, !dbg !148
}

define i32 @_ZN10HelloWorld7testSumEJii(%struct.HelloWorld* %unnamed_arg, i32 %unnamed_arg2) uwtable align 2 {
entry:
  %unnamed_arg_addr = alloca %struct.HelloWorld*, align 8
  %unnamed_arg_addr1 = alloca i32, align 4
  %"#slot#4#0" = alloca i32
  %"#slot#3#1" = alloca i32
  %"#slot#2#2" = alloca i32
  %D.250 = alloca i32
  %D.251 = alloca i32
  %"#slot#5#3" = alloca i32
  %D.253 = alloca i32
  %D.254 = alloca i32
  %D.255 = alloca i32
  %"<retval>" = alloca i32
  %"alloca point" = bitcast i32 0 to i32
  call void @llvm.dbg.declare(metadata !{%struct.HelloWorld** %unnamed_arg_addr}, metadata !149), !dbg !150
  store %struct.HelloWorld* %unnamed_arg, %struct.HelloWorld** %unnamed_arg_addr, align 1
  call void @llvm.dbg.declare(metadata !{i32* %unnamed_arg_addr1}, metadata !151), !dbg !150
  store i32 %unnamed_arg2, i32* %unnamed_arg_addr1, align 1
  %0 = load i32* %unnamed_arg_addr1, align 4
  %"ssa point" = bitcast i32 0 to i32
  br label %"2", !dbg !150

"2":                                              ; preds = %entry
  br label %"4", !dbg !152

"3":                                              ; preds = %"4"
  %1 = add i32 %3, %4, !dbg !153
  %2 = add i32 %4, 1, !dbg !152
  br label %"4", !dbg !152

"4":                                              ; preds = %"3", %"2"
  %3 = phi i32 [ %1, %"3" ], [ 0, %"2" ], !dbg !152
  %4 = phi i32 [ %2, %"3" ], [ 0, %"2" ], !dbg !152
  %5 = icmp slt i32 %4, %0, !dbg !152
  br i1 %5, label %"3", label %"5", !dbg !152

"5":                                              ; preds = %"4"
  store i32 %4, i32* %"<retval>", align 1, !dbg !154
  br label %return, !dbg !154

return:                                           ; preds = %"5"
  %6 = load i32* %"<retval>", align 4, !dbg !154
  ret i32 %6, !dbg !154
}

define void @_ZN10HelloWorld4mainEJvP6JArrayIPN4java4lang6StringEE(%"struct.java.lang.String[]"* %unnamed_arg) unnamed_addr uwtable {
entry:
  %unnamed_arg_addr = alloca %"struct.java.lang.String[]"*, align 8
  %D.570 = alloca %struct.java.io.PrintStream*
  %"#ref#3#1" = alloca i8*
  %"#ref#4#3" = alloca i8*
  %"#ref#1#7" = alloca i8*
  %D.682 = alloca %struct.HelloWorld*
  %"#slot#4#8" = alloca i32
  %"#slot#3#9" = alloca i32
  %"#slot#2#10" = alloca i32
  %D.686 = alloca %struct.java.io.PrintStream*
  %"#ref#5#13" = alloca i8*
  %"#ref#6#15" = alloca i8*
  %D.839 = alloca i32
  %"#slot#5#16" = alloca i32
  %"alloca point" = bitcast i32 0 to i32
  call void @llvm.dbg.declare(metadata !{%"struct.java.lang.String[]"** %unnamed_arg_addr}, metadata !155), !dbg !156
  store %"struct.java.lang.String[]"* %unnamed_arg, %"struct.java.lang.String[]"** %unnamed_arg_addr, align 1
  %"ssa point" = bitcast i32 0 to i32
  br label %"2", !dbg !156

"2":                                              ; preds = %entry
  %0 = load %struct.java.lang.Class** @"_ZN10HelloWorld7class$$E", align 8, !dbg !156
  %1 = bitcast %struct.java.lang.Class* %0 to i8*, !dbg !156
  call void (i8*, ...)* @_Jv_InitClass(i8* %1), !dbg !156
  br i1 true, label %"3", label %"4", !dbg !156

"3":                                              ; preds = %"2"
  call void (i8*, ...)* @_Jv_InitClass(i8* bitcast (%struct.java.lang.Class* @"_ZN4java4lang6System6class$E" to i8*)), !dbg !156
  br label %"4", !dbg !156

"4":                                              ; preds = %"3", %"2"
  %2 = load %struct.java.io.PrintStream** @_ZN4java4lang6System3outE, align 8, !dbg !156
  %3 = bitcast %struct.java.io.PrintStream* %2 to i8*, !dbg !156
  %4 = load i8** getelementptr inbounds ([3 x i8*]* @_CD_HelloWorld, i64 0, i64 1), align 8, !dbg !156
  %5 = bitcast i8* %3 to %struct.java.lang.Object*, !dbg !156
  %6 = getelementptr inbounds %struct.java.lang.Object* %5, i32 0, i32 0, !dbg !156
  %7 = load %0** %6, align 8, !dbg !156
  %8 = bitcast %0* %7 to i8*, !dbg !156
  %9 = getelementptr i8* %8, i64 248, !dbg !156
  %10 = bitcast i8* %9 to i8**, !dbg !156
  %11 = load i8** %10, align 8, !dbg !156
  %12 = bitcast i8* %11 to void (%struct.java.io.PrintStream*, %struct.java.lang.String*)*, !dbg !156
  %13 = bitcast i8* %3 to %struct.java.io.PrintStream*, !dbg !156
  %14 = bitcast i8* %4 to %struct.java.lang.String*, !dbg !156
  call void %12(%struct.java.io.PrintStream* %13, %struct.java.lang.String* %14), !dbg !156
  %15 = call noalias i8* (%struct.java.lang.Class*, ...)* @_Jv_AllocObjectNoFinalizer(%struct.java.lang.Class* @"_ZN10HelloWorld6class$E"), !dbg !157
  %16 = bitcast i8* %15 to %struct.HelloWorld*, !dbg !157
  call void @_ZN10HelloWorldC1Ev(%struct.HelloWorld* %16) uwtable, !dbg !157
  %17 = bitcast i8* %15 to %struct.HelloWorld*, !dbg !158
  %18 = bitcast %struct.HelloWorld* %17 to i8*, !dbg !158
  %19 = icmp eq i8* %18, null, !dbg !158
  br i1 %19, label %"5", label %"6", !dbg !158

"5":                                              ; preds = %"4"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !158
  unreachable, !dbg !158

"6":                                              ; preds = %"4"
  %20 = bitcast i8* %18 to %struct.HelloWorld*, !dbg !158
  %21 = bitcast i8* %18 to %struct.HelloWorld*, !dbg !158
  %22 = call i32 @_ZN10HelloWorld7testSumEJii(%struct.HelloWorld* %21, i32 100) uwtable, !dbg !158
  br i1 false, label %"7", label %"8", !dbg !159

"7":                                              ; preds = %"6"
  call void (i8*, ...)* @_Jv_InitClass(i8* bitcast (%struct.java.lang.Class* @"_ZN4java4lang6System6class$E" to i8*)), !dbg !159
  br label %"8", !dbg !159

"8":                                              ; preds = %"7", %"6"
  %23 = load %struct.java.io.PrintStream** @_ZN4java4lang6System3outE, align 8, !dbg !159
  %24 = bitcast %struct.java.io.PrintStream* %23 to i8*, !dbg !159
  %25 = call noalias i8* (%struct.java.lang.Class*, ...)* @_Jv_AllocObjectNoFinalizer(%struct.java.lang.Class* @"_ZN4java4lang13StringBuilder6class$E"), !dbg !159
  %26 = load i8** getelementptr inbounds ([3 x i8*]* @_CD_HelloWorld, i64 0, i64 2), align 8, !dbg !159
  %27 = bitcast i8* %25 to %struct.java.lang.StringBuilder*, !dbg !159
  %28 = bitcast i8* %26 to %struct.java.lang.String*, !dbg !159
  call void @_ZN4java4lang13StringBuilderC1EPNS0_6StringE(%struct.java.lang.StringBuilder* %27, %struct.java.lang.String* %28), !dbg !159
  %29 = icmp eq i8* %25, null, !dbg !159
  br i1 %29, label %"9", label %"10", !dbg !159

"9":                                              ; preds = %"8"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !159
  unreachable, !dbg !159

"10":                                             ; preds = %"8"
  %30 = bitcast i8* %25 to %struct.java.lang.StringBuilder*, !dbg !159
  %31 = bitcast i8* %25 to %struct.java.lang.StringBuilder*, !dbg !159
  %32 = call %struct.java.lang.StringBuilder* @_ZN4java4lang13StringBuilder6appendEJPS1_i(%struct.java.lang.StringBuilder* %31, i32 %22), !dbg !159
  %33 = bitcast %struct.java.lang.StringBuilder* %32 to i8*, !dbg !159
  %34 = icmp eq i8* %33, null, !dbg !159
  br i1 %34, label %"11", label %"12", !dbg !159

"11":                                             ; preds = %"10"
  call void (...)* @_Jv_ThrowNullPointerException() noreturn, !dbg !159
  unreachable, !dbg !159

"12":                                             ; preds = %"10"
  %35 = bitcast i8* %33 to %struct.java.lang.StringBuilder*, !dbg !159
  %36 = bitcast i8* %33 to %struct.java.lang.StringBuilder*, !dbg !159
  %37 = call %struct.java.lang.String* @_ZN4java4lang13StringBuilder8toStringEJPNS0_6StringEv(%struct.java.lang.StringBuilder* %36), !dbg !159
  %38 = bitcast %struct.java.lang.String* %37 to i8*, !dbg !159
  %39 = bitcast i8* %24 to %struct.java.lang.Object*, !dbg !159
  %40 = getelementptr inbounds %struct.java.lang.Object* %39, i32 0, i32 0, !dbg !159
  %41 = load %0** %40, align 8, !dbg !159
  %42 = bitcast %0* %41 to i8*, !dbg !159
  %43 = getelementptr i8* %42, i64 248, !dbg !159
  %44 = bitcast i8* %43 to i8**, !dbg !159
  %45 = load i8** %44, align 8, !dbg !159
  %46 = bitcast i8* %45 to void (%struct.java.io.PrintStream*, %struct.java.lang.String*)*, !dbg !159
  %47 = bitcast i8* %24 to %struct.java.io.PrintStream*, !dbg !159
  %48 = bitcast i8* %38 to %struct.java.lang.String*, !dbg !159
  call void %46(%struct.java.io.PrintStream* %47, %struct.java.lang.String* %48), !dbg !159
  br label %return, !dbg !160

return:                                           ; preds = %"12"
  ret void, !dbg !160
}

declare void @llvm.dbg.declare(metadata, metadata) nounwind readnone

declare void @_ZN4java4lang6ObjectC1Ev(%struct.java.lang.Object*)

declare void @_Jv_InitClass(i8*, ...)

declare noalias i8* @_Jv_AllocObjectNoFinalizer(%struct.java.lang.Class*, ...)

declare void @_Jv_ThrowNullPointerException(...) noreturn

declare void @_ZN4java4lang13StringBuilderC1EPNS0_6StringE(%struct.java.lang.StringBuilder*, %struct.java.lang.String*)

declare %struct.java.lang.StringBuilder* @_ZN4java4lang13StringBuilder6appendEJPS1_i(%struct.java.lang.StringBuilder*, i32)

declare %struct.java.lang.String* @_ZN4java4lang13StringBuilder8toStringEJPNS0_6StringEv(%struct.java.lang.StringBuilder*)

define internal void @_Jv_global_static_constructor() unnamed_addr uwtable {
entry:
  %"ssa point" = bitcast i32 0 to i32
  br label %"2"

"2":                                              ; preds = %entry
  call void @_Jv_RegisterResource(i8* bitcast (%17* @"_ZGr8_$_dummy" to i8*))
  br label %return

return:                                           ; preds = %"2"
  ret void
}

declare void @_Jv_RegisterResource(i8*)

!llvm.dbg.gv = !{!0, !7}
!llvm.dbg.sp = !{!10, !129, !132, !144}

!0 = metadata !{i32 655412, i32 0, metadata !1, metadata !"_CT_HelloWorld", metadata !"_CT_HelloWorld", metadata !"", metadata !1, i32 34, metadata !3, i1 true, i1 true, [3 x i8]* @_CT_HelloWorld}
!1 = metadata !{i32 655401, metadata !"HelloWorld.java", metadata !"/home/danke/work/vm/test/java-to-asm/", metadata !2}
!2 = metadata !{i32 655377, i32 0, i32 11, metadata !"HelloWorld.java", metadata !"/home/danke/work/vm/test/java-to-asm/", metadata !"4.6.3", i1 true, i1 false, metadata !"", i32 0}
!3 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 24, i64 8, i64 0, i32 0, metadata !4, metadata !5, i32 0, null}
!4 = metadata !{i32 655396, metadata !1, metadata !"unsigned byte", metadata !1, i32 0, i64 8, i64 8, i64 0, i32 0, i32 7}
!5 = metadata !{metadata !6}
!6 = metadata !{i32 655393, i64 0, i64 2}
!7 = metadata !{i32 655412, i32 0, metadata !1, metadata !"_CD_HelloWorld", metadata !"_CD_HelloWorld", metadata !"", metadata !1, i32 30, metadata !8, i1 true, i1 true, [3 x i8*]* @_CD_HelloWorld}
!8 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 192, i64 64, i64 0, i32 0, metadata !9, metadata !5, i32 0, null}
!9 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, null}
!10 = metadata !{i32 655406, i32 0, metadata !11, metadata !"HelloWorld::HelloWorld", metadata !"HelloWorld::HelloWorld", metadata !"_ZN10HelloWorldC1Ev", metadata !1, i32 19, metadata !126, i1 false, i1 true, i32 0, i32 0, null, i32 0, i1 false, null}
!11 = metadata !{i32 655379, metadata !1, metadata !"HelloWorld", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, null, metadata !12, i32 0, metadata !14}
!12 = metadata !{metadata !13}
!13 = metadata !{i32 655388, metadata !1, metadata !"", null, i32 0, i64 0, i64 0, i64 0, i32 0, metadata !14}
!14 = metadata !{i32 655379, metadata !1, metadata !"java.lang.Object", metadata !15, i32 0, i64 64, i64 64, i64 0, i32 0, null, metadata !16, i32 0, metadata !14}
!15 = metadata !{i32 655401, metadata !"Object.java", metadata !"/home/danke/work/vm/test/java-to-asm/java/lang", metadata !2}
!16 = metadata !{metadata !17}
!17 = metadata !{i32 655373, metadata !14, metadata !"vtable", metadata !18, i32 0, i64 64, i64 64, i64 0, i32 1, metadata !19}
!18 = metadata !{i32 655401, metadata !"<built-in>", metadata !"/home/danke/work/vm/test/java-to-asm/", metadata !2}
!19 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !20}
!20 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 192, i64 64, i64 0, i32 0, null, metadata !21, i32 0, null}
!21 = metadata !{metadata !22, metadata !125}
!22 = metadata !{i32 655373, metadata !20, metadata !"class", metadata !18, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !23}
!23 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !24}
!24 = metadata !{i32 655379, metadata !1, metadata !"java.lang.Class", metadata !25, i32 0, i64 2240, i64 64, i64 0, i32 0, null, metadata !26, i32 0, metadata !14}
!25 = metadata !{i32 655401, metadata !"Class.java", metadata !"/home/danke/work/vm/test/java-to-asm/java/lang", metadata !2}
!26 = metadata !{metadata !13, metadata !27, metadata !30, metadata !33, metadata !36, metadata !39, metadata !40, metadata !47, metadata !48, metadata !49, metadata !56, metadata !66, metadata !68, metadata !69, metadata !83, metadata !84, metadata !85, metadata !86, metadata !87, metadata !92, metadata !100, metadata !103, metadata !104, metadata !105, metadata !106, metadata !107, metadata !109, metadata !110, metadata !111, metadata !113, metadata !114, metadata !115, metadata !116, metadata !117, metadata !118, metadata !119, metadata !120, metadata !121, metadata !122, metadata !123, metadata !124}
!27 = metadata !{i32 655388, metadata !1, metadata !"", null, i32 0, i64 0, i64 0, i64 0, i32 32, metadata !28}
!28 = metadata !{i32 655379, metadata !1, metadata !"java.lang.reflect.Type", metadata !29, i32 0, i64 64, i64 64, i64 0, i32 0, null, metadata !12, i32 0, metadata !14}
!29 = metadata !{i32 655401, metadata !"Type.java", metadata !"/home/danke/work/vm/test/java-to-asm/java/lang/reflect", metadata !2}
!30 = metadata !{i32 655388, metadata !1, metadata !"", null, i32 0, i64 0, i64 0, i64 0, i32 32, metadata !31}
!31 = metadata !{i32 655379, metadata !1, metadata !"java.lang.reflect.AnnotatedElement", metadata !32, i32 0, i64 64, i64 64, i64 0, i32 0, null, metadata !12, i32 0, metadata !14}
!32 = metadata !{i32 655401, metadata !"AnnotatedElement.java", metadata !"/home/danke/work/vm/test/java-to-asm/java/lang/reflect", metadata !2}
!33 = metadata !{i32 655388, metadata !1, metadata !"", null, i32 0, i64 0, i64 0, i64 0, i32 32, metadata !34}
!34 = metadata !{i32 655379, metadata !1, metadata !"java.lang.reflect.GenericDeclaration", metadata !35, i32 0, i64 64, i64 64, i64 0, i32 0, null, metadata !12, i32 0, metadata !14}
!35 = metadata !{i32 655401, metadata !"GenericDeclaration.java", metadata !"/home/danke/work/vm/test/java-to-asm/java/lang/reflect", metadata !2}
!36 = metadata !{i32 655388, metadata !1, metadata !"", null, i32 0, i64 0, i64 0, i64 0, i32 32, metadata !37}
!37 = metadata !{i32 655379, metadata !1, metadata !"java.io.Serializable", metadata !38, i32 0, i64 64, i64 64, i64 0, i32 0, null, metadata !12, i32 0, metadata !14}
!38 = metadata !{i32 655401, metadata !"Serializable.java", metadata !"/home/danke/work/vm/test/java-to-asm/java/io", metadata !2}
!39 = metadata !{i32 655373, metadata !24, metadata !"next_or_version", metadata !18, i32 0, i64 64, i64 64, i64 64, i32 1, metadata !23}
!40 = metadata !{i32 655373, metadata !24, metadata !"name", metadata !18, i32 0, i64 64, i64 64, i64 128, i32 1, metadata !41}
!41 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !42}
!42 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 32, i64 16, i64 0, i32 0, null, metadata !43, i32 0, null}
!43 = metadata !{metadata !44, metadata !46}
!44 = metadata !{i32 655373, metadata !42, metadata !"hash", metadata !18, i32 0, i64 16, i64 16, i64 0, i32 0, metadata !45}
!45 = metadata !{i32 655396, metadata !1, metadata !"unsigned short", metadata !1, i32 0, i64 16, i64 16, i64 0, i32 0, i32 7}
!46 = metadata !{i32 655373, metadata !42, metadata !"length", metadata !18, i32 0, i64 16, i64 16, i64 16, i32 0, metadata !45}
!47 = metadata !{i32 655373, metadata !24, metadata !"accflags", metadata !18, i32 0, i64 16, i64 16, i64 192, i32 1, metadata !45}
!48 = metadata !{i32 655373, metadata !24, metadata !"superclass", metadata !18, i32 0, i64 64, i64 64, i64 256, i32 1, metadata !23}
!49 = metadata !{i32 655373, metadata !24, metadata !"constants", metadata !18, i32 0, i64 192, i64 64, i64 320, i32 1, metadata !50}
!50 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 192, i64 64, i64 0, i32 0, null, metadata !51, i32 0, null}
!51 = metadata !{metadata !52, metadata !54, metadata !55}
!52 = metadata !{i32 655373, metadata !50, metadata !"size", metadata !18, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !53}
!53 = metadata !{i32 655396, metadata !1, metadata !"unsigned int", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, i32 7}
!54 = metadata !{i32 655373, metadata !50, metadata !"tags", metadata !18, i32 0, i64 64, i64 64, i64 64, i32 0, metadata !9}
!55 = metadata !{i32 655373, metadata !50, metadata !"data", metadata !18, i32 0, i64 64, i64 64, i64 128, i32 0, metadata !9}
!56 = metadata !{i32 655373, metadata !24, metadata !"methods", metadata !18, i32 0, i64 64, i64 64, i64 512, i32 1, metadata !57}
!57 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !58}
!58 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 320, i64 64, i64 0, i32 0, null, metadata !59, i32 0, null}
!59 = metadata !{metadata !60, metadata !61, metadata !62, metadata !63, metadata !64, metadata !65}
!60 = metadata !{i32 655373, metadata !58, metadata !"name", metadata !18, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !41}
!61 = metadata !{i32 655373, metadata !58, metadata !"signature", metadata !18, i32 0, i64 64, i64 64, i64 64, i32 0, metadata !41}
!62 = metadata !{i32 655373, metadata !58, metadata !"accflags", metadata !18, i32 0, i64 16, i64 16, i64 128, i32 0, metadata !45}
!63 = metadata !{i32 655373, metadata !58, metadata !"index", metadata !18, i32 0, i64 16, i64 16, i64 144, i32 0, metadata !45}
!64 = metadata !{i32 655373, metadata !58, metadata !"ncode", metadata !18, i32 0, i64 64, i64 64, i64 192, i32 0, metadata !9}
!65 = metadata !{i32 655373, metadata !58, metadata !"throws", metadata !18, i32 0, i64 64, i64 64, i64 256, i32 0, metadata !9}
!66 = metadata !{i32 655373, metadata !24, metadata !"method_count", metadata !18, i32 0, i64 16, i64 16, i64 576, i32 1, metadata !67}
!67 = metadata !{i32 655396, metadata !1, metadata !"short", metadata !1, i32 0, i64 16, i64 16, i64 0, i32 0, i32 5}
!68 = metadata !{i32 655373, metadata !24, metadata !"vtable_method_count", metadata !18, i32 0, i64 16, i64 16, i64 592, i32 1, metadata !67}
!69 = metadata !{i32 655373, metadata !24, metadata !"fields", metadata !18, i32 0, i64 64, i64 64, i64 640, i32 1, metadata !70}
!70 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !71}
!71 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 256, i64 64, i64 0, i32 0, null, metadata !72, i32 0, null}
!72 = metadata !{metadata !73, metadata !74, metadata !75, metadata !76, metadata !77}
!73 = metadata !{i32 655373, metadata !71, metadata !"name", metadata !18, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !41}
!74 = metadata !{i32 655373, metadata !71, metadata !"type", metadata !18, i32 0, i64 64, i64 64, i64 64, i32 0, metadata !23}
!75 = metadata !{i32 655373, metadata !71, metadata !"accflags", metadata !18, i32 0, i64 16, i64 16, i64 128, i32 0, metadata !45}
!76 = metadata !{i32 655373, metadata !71, metadata !"bsize", metadata !18, i32 0, i64 16, i64 16, i64 144, i32 0, metadata !45}
!77 = metadata !{i32 655373, metadata !71, metadata !"info", metadata !18, i32 0, i64 64, i64 64, i64 192, i32 0, metadata !78}
!78 = metadata !{i32 655383, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, null, metadata !79, i32 0, null}
!79 = metadata !{metadata !80, metadata !82}
!80 = metadata !{i32 655373, metadata !78, metadata !"boffset", metadata !18, i32 0, i64 32, i64 32, i64 0, i32 0, metadata !81}
!81 = metadata !{i32 655396, metadata !1, metadata !"int", metadata !1, i32 0, i64 32, i64 32, i64 0, i32 0, i32 5}
!82 = metadata !{i32 655373, metadata !78, metadata !"addr", metadata !18, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !9}
!83 = metadata !{i32 655373, metadata !24, metadata !"size_in_bytes", metadata !18, i32 0, i64 32, i64 32, i64 704, i32 1, metadata !81}
!84 = metadata !{i32 655373, metadata !24, metadata !"field_count", metadata !18, i32 0, i64 16, i64 16, i64 736, i32 1, metadata !67}
!85 = metadata !{i32 655373, metadata !24, metadata !"static_field_count", metadata !18, i32 0, i64 16, i64 16, i64 752, i32 1, metadata !67}
!86 = metadata !{i32 655373, metadata !24, metadata !"vtable", metadata !18, i32 0, i64 64, i64 64, i64 768, i32 1, metadata !19}
!87 = metadata !{i32 655373, metadata !24, metadata !"otable", metadata !18, i32 0, i64 64, i64 64, i64 832, i32 1, metadata !88}
!88 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !89}
!89 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 32, i64 0, i32 0, metadata !81, metadata !90, i32 0, null}
!90 = metadata !{metadata !91}
!91 = metadata !{i32 655393, i64 0, i64 1}
!92 = metadata !{i32 655373, metadata !24, metadata !"otable_syms", metadata !18, i32 0, i64 64, i64 64, i64 896, i32 1, metadata !93}
!93 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !94}
!94 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 384, i64 64, i64 0, i32 0, metadata !95, metadata !90, i32 0, null}
!95 = metadata !{i32 655379, metadata !1, metadata !"", metadata !1, i32 0, i64 192, i64 64, i64 0, i32 0, null, metadata !96, i32 0, null}
!96 = metadata !{metadata !97, metadata !98, metadata !99}
!97 = metadata !{i32 655373, metadata !95, metadata !"clname", metadata !18, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !41}
!98 = metadata !{i32 655373, metadata !95, metadata !"name", metadata !18, i32 0, i64 64, i64 64, i64 64, i32 0, metadata !41}
!99 = metadata !{i32 655373, metadata !95, metadata !"signature", metadata !18, i32 0, i64 64, i64 64, i64 128, i32 0, metadata !41}
!100 = metadata !{i32 655373, metadata !24, metadata !"atable", metadata !18, i32 0, i64 64, i64 64, i64 960, i32 1, metadata !101}
!101 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !102}
!102 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 128, i64 64, i64 0, i32 0, metadata !9, metadata !90, i32 0, null}
!103 = metadata !{i32 655373, metadata !24, metadata !"atable_syms", metadata !18, i32 0, i64 64, i64 64, i64 1024, i32 1, metadata !93}
!104 = metadata !{i32 655373, metadata !24, metadata !"itable", metadata !18, i32 0, i64 64, i64 64, i64 1088, i32 1, metadata !101}
!105 = metadata !{i32 655373, metadata !24, metadata !"itable_syms", metadata !18, i32 0, i64 64, i64 64, i64 1152, i32 1, metadata !93}
!106 = metadata !{i32 655373, metadata !24, metadata !"catch_classes", metadata !18, i32 0, i64 64, i64 64, i64 1216, i32 1, metadata !9}
!107 = metadata !{i32 655373, metadata !24, metadata !"interfaces", metadata !18, i32 0, i64 64, i64 64, i64 1280, i32 1, metadata !108}
!108 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !23}
!109 = metadata !{i32 655373, metadata !24, metadata !"loader", metadata !18, i32 0, i64 64, i64 64, i64 1344, i32 1, metadata !9}
!110 = metadata !{i32 655373, metadata !24, metadata !"interface_count", metadata !18, i32 0, i64 16, i64 16, i64 1408, i32 1, metadata !67}
!111 = metadata !{i32 655373, metadata !24, metadata !"state", metadata !18, i32 0, i64 8, i64 8, i64 1424, i32 1, metadata !112}
!112 = metadata !{i32 655396, metadata !1, metadata !"byte", metadata !1, i32 0, i64 8, i64 8, i64 0, i32 0, i32 5}
!113 = metadata !{i32 655373, metadata !24, metadata !"thread", metadata !18, i32 0, i64 64, i64 64, i64 1472, i32 1, metadata !9}
!114 = metadata !{i32 655373, metadata !24, metadata !"depth", metadata !18, i32 0, i64 16, i64 16, i64 1536, i32 1, metadata !67}
!115 = metadata !{i32 655373, metadata !24, metadata !"ancestors", metadata !18, i32 0, i64 64, i64 64, i64 1600, i32 1, metadata !9}
!116 = metadata !{i32 655373, metadata !24, metadata !"idt", metadata !18, i32 0, i64 64, i64 64, i64 1664, i32 1, metadata !9}
!117 = metadata !{i32 655373, metadata !24, metadata !"arrayclass", metadata !18, i32 0, i64 64, i64 64, i64 1728, i32 1, metadata !9}
!118 = metadata !{i32 655373, metadata !24, metadata !"protectionDomain", metadata !18, i32 0, i64 64, i64 64, i64 1792, i32 1, metadata !9}
!119 = metadata !{i32 655373, metadata !24, metadata !"assertion_table", metadata !18, i32 0, i64 64, i64 64, i64 1856, i32 1, metadata !9}
!120 = metadata !{i32 655373, metadata !24, metadata !"hack_signers", metadata !18, i32 0, i64 64, i64 64, i64 1920, i32 1, metadata !9}
!121 = metadata !{i32 655373, metadata !24, metadata !"chain", metadata !18, i32 0, i64 64, i64 64, i64 1984, i32 1, metadata !9}
!122 = metadata !{i32 655373, metadata !24, metadata !"aux_info", metadata !18, i32 0, i64 64, i64 64, i64 2048, i32 1, metadata !9}
!123 = metadata !{i32 655373, metadata !24, metadata !"engine", metadata !18, i32 0, i64 64, i64 64, i64 2112, i32 1, metadata !9}
!124 = metadata !{i32 655373, metadata !24, metadata !"reflection_data", metadata !18, i32 0, i64 64, i64 64, i64 2176, i32 1, metadata !9}
!125 = metadata !{i32 655373, metadata !20, metadata !"methods", metadata !18, i32 0, i64 128, i64 64, i64 64, i32 0, metadata !102}
!126 = metadata !{i32 655381, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 0, i64 0, i32 0, null, metadata !127, i32 0, null}
!127 = metadata !{null, metadata !128}
!128 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 64, metadata !11}
!129 = metadata !{i32 655406, i32 0, metadata !11, metadata !"HelloWorld::testSum", metadata !"HelloWorld::testSum", metadata !"_ZN10HelloWorld7testSumEJii", metadata !1, i32 23, metadata !130, i1 false, i1 true, i32 0, i32 0, null, i32 0, i1 false, null}
!130 = metadata !{i32 655381, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 0, i64 0, i32 0, null, metadata !131, i32 0, null}
!131 = metadata !{metadata !81, metadata !128, metadata !81}
!132 = metadata !{i32 655406, i32 0, metadata !11, metadata !"HelloWorld::main", metadata !"HelloWorld::main", metadata !"_ZN10HelloWorld4mainEJvP6JArrayIPN4java4lang6StringEE", metadata !1, i32 30, metadata !133, i1 false, i1 true, i32 0, i32 0, null, i32 0, i1 false, null}
!133 = metadata !{i32 655381, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 0, i64 0, i32 0, null, metadata !134, i32 0, null}
!134 = metadata !{null, metadata !135}
!135 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !136}
!136 = metadata !{i32 655379, metadata !1, metadata !"java.lang.String[]", metadata !1, i32 0, i64 128, i64 64, i64 0, i32 0, null, metadata !137, i32 0, metadata !14}
!137 = metadata !{metadata !13, metadata !138, metadata !139}
!138 = metadata !{i32 655373, metadata !136, metadata !"length", metadata !1, i32 0, i64 32, i64 32, i64 64, i32 0, metadata !81}
!139 = metadata !{i32 655373, metadata !136, metadata !"data", metadata !1, i32 0, i64 0, i64 64, i64 128, i32 0, metadata !140}
!140 = metadata !{i32 655361, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 64, i64 0, i32 0, metadata !141, metadata !143, i32 0, null}
!141 = metadata !{i32 655375, metadata !1, metadata !"", metadata !1, i32 0, i64 64, i64 64, i64 0, i32 0, metadata !142}
!142 = metadata !{i32 655379, metadata !1, metadata !"java.lang.String", metadata !18, i32 0, i64 0, i64 0, i64 0, i32 4, null, null, i32 0, null}
!143 = metadata !{i32 0}
!144 = metadata !{i32 655406, i32 0, metadata !1, metadata !"_Jv_global_static_constructor", metadata !"_Jv_global_static_constructor", metadata !"_Jv_global_static_constructor", metadata !1, i32 0, metadata !145, i1 true, i1 true, i32 0, i32 0, null, i32 1, i1 false, null}
!145 = metadata !{i32 655381, metadata !1, metadata !"", metadata !1, i32 0, i64 0, i64 0, i64 0, i32 0, null, metadata !146, i32 0, null}
!146 = metadata !{null}
!147 = metadata !{i32 655617, metadata !10, metadata !"unnamed_arg", metadata !1, i32 19, metadata !128, i32 0, i32 0}
!148 = metadata !{i32 19, i32 0, metadata !10, null}
!149 = metadata !{i32 655617, metadata !129, metadata !"unnamed_arg", metadata !1, i32 23, metadata !128, i32 0, i32 0}
!150 = metadata !{i32 23, i32 0, metadata !129, null}
!151 = metadata !{i32 655617, metadata !129, metadata !"unnamed_arg", metadata !1, i32 23, metadata !81, i32 0, i32 0}
!152 = metadata !{i32 24, i32 0, metadata !129, null}
!153 = metadata !{i32 25, i32 0, metadata !129, null}
!154 = metadata !{i32 26, i32 0, metadata !129, null}
!155 = metadata !{i32 655617, metadata !132, metadata !"unnamed_arg", metadata !1, i32 30, metadata !135, i32 0, i32 0}
!156 = metadata !{i32 30, i32 0, metadata !132, null}
!157 = metadata !{i32 31, i32 0, metadata !132, null}
!158 = metadata !{i32 32, i32 0, metadata !132, null}
!159 = metadata !{i32 33, i32 0, metadata !132, null}
!160 = metadata !{i32 34, i32 0, metadata !132, null}
