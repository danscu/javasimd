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

