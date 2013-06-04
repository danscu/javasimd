DRAGONEGG=../../dragonegg.so
LLVMFLAGS="-bb-vectorize -loop-vectorize"

echo 1. Compiling C to LLVM-IR
#gcc -O0 -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S sum.c
clang -O0 -S -emit-llvm sum.c

if [ "$1" != "0" ]; then
  echo 2. Optimize
  opt -O3 $LLVMFLAGS -S -o sum.opt.s sum.s
  llvm-as -o sum.s.bc sum.opt.s
else
  echo 2. No-optimize
  llvm-as -o sum.s.bc sum.s
fi

echo 3. Compiling LLVM bitcode to assembly
llc sum.s.bc

echo 3. Link assembly
gcc sum.s.s

echo 4. Execute program
time ./a.out
