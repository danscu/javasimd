; ModuleID = 'HelloWorld.c'
target datalayout = "e-p:64:64:64-S128-i1:8:8-i8:8:8-i16:16:16-i32:32:32-i64:64:64-f16:16:16-f32:32:32-f64:64:64-f128:128:128-v64:64:64-v128:128:128-a0:0:64-s0:64:64-f80:128:128-n8:16:32:64"
target triple = "x86_64--linux-gnu"

module asm "\09.ident\09\22GCC: (Ubuntu/Linaro 4.6.3-1ubuntu5) 4.6.3 LLVM: 3.2svn\22"

%struct.JNINativeInterface_ = type { i8*, i8*, i8*, i8*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}*, {}* }

define i32 @Java_HelloWorld_testSum(%struct.JNINativeInterface_** %env, i8* %thisobj, i32 %arg0) unnamed_addr nounwind uwtable ssp {
entry:
  %env_addr = alloca %struct.JNINativeInterface_**, align 8
  %thisobj_addr = alloca i8*, align 8
  %arg0_addr = alloca i32, align 4
  %i = alloca i32
  %sum = alloca i32
  %"<retval>" = alloca i32
  %"alloca point" = bitcast i32 0 to i32
  store %struct.JNINativeInterface_** %env, %struct.JNINativeInterface_*** %env_addr, align 1
  store i8* %thisobj, i8** %thisobj_addr, align 1
  store i32 %arg0, i32* %arg0_addr, align 1
  %0 = load i32* %arg0_addr, align 4
  %"ssa point" = bitcast i32 0 to i32
  br label %"2"

"2":                                              ; preds = %entry
  br label %"4"

"3":                                              ; preds = %"4"
  %1 = add i32 %4, %3
  %2 = add i32 %3, 1
  br label %"4"

"4":                                              ; preds = %"3", %"2"
  %3 = phi i32 [ %2, %"3" ], [ 0, %"2" ]
  %4 = phi i32 [ %1, %"3" ], [ 0, %"2" ]
  %5 = icmp slt i32 %3, %0
  br i1 %5, label %"3", label %"5"

"5":                                              ; preds = %"4"
  store i32 %4, i32* %"<retval>", align 1
  br label %return

return:                                           ; preds = %"5"
  %6 = load i32* %"<retval>", align 4
  ret i32 %6
}
