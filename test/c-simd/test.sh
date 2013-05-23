DRAGONEGG=../../dragonegg.so

echo 1. Compiling C to LLVM-IR
gcc -O0 -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S sum.c

if [ "$1" != "0" ]; then
  echo 2. Optimize
  opt -S -loop-vectorize -force-vector-width=2 -o sum.opt.s sum.s
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
