DRAGONEGG=../../dragonegg.so

echo 1. Compiling C to LLVM-IR
gcc -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S hello.c

echo 2. Compiling LLVM-IR to LLVM bitcode \(.bc\)
llvm-as hello.s

echo 3. Compiling LLVM bitcode to assembly
llc hello.s.bc

echo 3. Link assembly
gcc hello.s.s

echo 4. Execute program
./a.out
