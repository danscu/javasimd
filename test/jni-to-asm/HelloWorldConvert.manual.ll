;; Preamble

; ModuleID = 'HelloWorld.c'
target datalayout = "e-p:64:64:64-S128-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:64:64-f16:16:16-f32:32:32-f64:64:64-f128:128:128-v64:64:64-v128:128:128-a0:0:64-s0:64:64-f80:128:128-n8:16:32:64"
target triple = "x86_64--linux-gnu"

module asm "\09.ident\09\22GCC: (Ubuntu/Linaro 4.6.3-1ubuntu5) 4.6.3 LLVM: 3.2svn\22"

%struct.JNINativeInterface_ = type { i8*, i8*, i8*, i8*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}* }

define i32 @Java_HelloWorld_testSum(%struct.JNINativeInterface_** %env, i8* %thisobj, i32 %unnamed_arg2) align 2 {
entry:
  %env_addr = alloca %struct.JNINativeInterface_**, align 8
  %thisobj_addr = alloca i8*, align 8
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
  store i8* %thisobj, i8** %thisobj_addr, align 1
  store i32 %unnamed_arg2, i32* %unnamed_arg_addr1, align 1
  %0 = load i32* %unnamed_arg_addr1, align 4
  %"ssa point" = bitcast i32 0 to i32
  br label %"2"

"2":                                              ; preds = %entry
  br label %"4"

"3":                                              ; preds = %"4"
  %1 = add i32 %3, %4
  %2 = add i32 %4, 1
  br label %"4"

"4":                                              ; preds = %"3", %"2"
  %3 = phi i32 [ %1, %"3" ], [ 0, %"2" ]
  %4 = phi i32 [ %2, %"3" ], [ 0, %"2" ]
  %5 = icmp slt i32 %4, %0
  br i1 %5, label %"3", label %"5"

"5":                                              ; preds = %"4"
  store i32 %4, i32* %"<retval>", align 1
  br label %return

return:                                           ; preds = %"5"
  %6 = load i32* %"<retval>", align 4
  ret i32 %6
}

; change type from %"struct.int[]" to i8, remember the 

%type %"struct.int[]@JNI" i8

define i32 @Java_HelloWorld_testArraySum(%struct.JNINativeInterface_** %env, i8* %thisobj, i8* %unnamed_arg2) uwtable align 2 {
entry:
  %unnamed_arg_addr = alloca i8*, align 8
  %unnamed_arg_addr1 = alloca %"struct.int[]@JNI"*, align 8
  %"#slot#4#0" = alloca i32
  %"#slot#2#1" = alloca i32
  %"#slot#3#2" = alloca i32
  %D.272 = alloca i32
  %"#ref#1#3" = alloca i8*
  %D.274 = alloca %struct.java.lang.Object*
  %"#ref#5#5" = alloca i8*
  %D.277 = alloca i32
  %"#slot#6#6" = alloca i32
  %"#slot#5#8" = alloca i32
  %D.281 = alloca i32
  %D.282 = alloca %struct.java.lang.Object*
  %D.287 = alloca i32
  %"<retval>" = alloca i32
  %"alloca point" = bitcast i32 0 to i32
  store i8* %unnamed_arg, i8** %unnamed_arg_addr, align 1
  %J.0 = bitcast i8* %unnamed_arg2 to %"struct.int[]@JNI"*
  store i8* %J.0, %"struct.int[]@JNI"** %unnamed_arg_addr1, align 1
  %0 = load %"struct.int[]@JNI"** %unnamed_arg_addr1, align 8
  %"ssa point" = bitcast i32 0 to i32
  br label %"2", !dbg !165

"2":                                              ; preds = %entry
  br label %"6", !dbg !167

"3":                                              ; preds = %"6"
  %1 = bitcast %"struct.int[]@JNI"* %0 to %struct.java.lang.Object*, !dbg !168
  %2 = bitcast %struct.java.lang.Object* %1 to i8*, !dbg !168
  %3 = bitcast i8* %2 to %"struct.int[]"*, !dbg !168
  %4 = getelementptr inbounds %"struct.int[]"* %3, i32 0, i32 2, !dbg !168
  %5 = bitcast [4 x i8]* %4 to [0 x i32]*, !dbg !168
  %6 = bitcast i8* %2 to %"struct.int[]"*, !dbg !168
  %7 = getelementptr inbounds %"struct.int[]"* %6, i32 0, i32 1, !dbg !168
  %8 = load i32* %7, align 8, !dbg !168
  %9 = icmp uge i32 %19, %8, !dbg !168
  br i1 %9, label %"4", label %"5", !dbg !168

; Need to recognize array operations
;   [0] --> %struct.java.lang.Object
;   [1] --> [i32] array.length
;   [2] --> [4 x i8] cast to [0 x i32]* base addresss

; Remove instructions related to getting these elements
; Add instructions to call JNI helper functions to get corresponding the values
; Add clean up code

; Ignore the call for now
;   @_Jv_ThrowBadArrayIndex ; C does not check boundary -- but can translate to Java call
;   to keep Java semantics

"4":                                              ; preds = %"3"
  call void (i32, ...)* @_Jv_ThrowBadArrayIndex(i32 %19) noreturn, !dbg !168
  unreachable, !dbg !168

"5":                                              ; preds = %"3"
  %10 = sext i32 %19 to i64, !dbg !168
  %11 = mul i64 %10, 4, !dbg !168
  %12 = bitcast [0 x i32]* %5 to i8*, !dbg !168
  %13 = getelementptr i8* %12, i64 %11, !dbg !168
  %14 = bitcast i8* %13 to i32*, !dbg !168
  %15 = load i32* %14, align 4, !dbg !168
  %16 = add i32 %18, %15, !dbg !168
  %17 = add i32 %19, 1, !dbg !167
  br label %"6", !dbg !167

"6":                                              ; preds = %"5", %"2"
  %18 = phi i32 [ %16, %"5" ], [ 0, %"2" ], !dbg !167
  %19 = phi i32 [ %17, %"5" ], [ 0, %"2" ], !dbg !167
  %20 = bitcast %"struct.int[]"* %0 to %struct.java.lang.Object*, !dbg !167
  %21 = bitcast %struct.java.lang.Object* %20 to i8*, !dbg !167
  %22 = bitcast i8* %21 to %"struct.java.lang.Object[]"*, !dbg !167
  %23 = getelementptr inbounds %"struct.java.lang.Object[]"* %22, i32 0, i32 1, !dbg !167
  %24 = load i32* %23, align 8, !dbg !167
  %25 = icmp slt i32 %19, %24, !dbg !167
  br i1 %25, label %"3", label %"7", !dbg !167

"7":                                              ; preds = %"6"
  store i32 %18, i32* %"<retval>", align 1, !dbg !169
  br label %return, !dbg !169

return:                                           ; preds = %"7"
  %26 = load i32* %"<retval>", align 4, !dbg !169
  ret i32 %26, !dbg !169
}
