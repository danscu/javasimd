GCC_VER=
GCC=gcc$GCC_VER
GCJ=gcj$GCC_VER
DRAGONEGG=../../dragonegg.so

LLVM_AS=llvm-as

echo Generating intermediate file for main

$GCJ --main=$1 -save-temps $1.java
rm a.out

echo Generating Java bytecode

javac $1.java

echo Generating LLVM IR

$GCJ -save-temps -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S $1.java

echo TODO: optimization with LLVM here

echo Compiling with LLVM IR to bitcode .bc

llvm-as $1.s

echo Compiling LLVM bitcode .s.bc to assembly .s

llc $1.s.bc

echo Generating object file from .s

$GCC -c $1.s.s

if [ -f HelloWorld.s.o ]; then
  echo Success!
else
  echo Failed!
fi
