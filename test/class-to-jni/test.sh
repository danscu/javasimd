DRAGONEGG=../../dragonegg.so
GCJ=gcj
FILE=$1

if [[ ! `uname -a` =~ .*_64.* ]]; then
  LLC_ARCH="-march=x86"
fi

FUNC="findMinPos"

if [ "$1" == "" ]; then
  echo Usage: test.sh ClassName
else
echo 0. Compiling Java \(if classfile does not exist\)
if [ ! -f $FILE.class ]; then
  javac $FILE.java
fi

echo 1. Compile Java to LLVM
$GCJ -save-temps -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S $1.java

echo 2. Compile java byte code to LLVM
opt -S -vectorize-loops -bb-vectorize -loop-vectorize -vectorize -force-vector-width=2 -o $FILE.opt.s $FILE.s

echo 3. Compiling LLVM-IR to LLVM bitcode \(.bc\)
./optimize.sh $FILE $FILE.opt.s ${FUNC}

echo 4. Compile modified LLVM IR
llvm-as vdir/$FILE.opt.s -o $FILE.ll.bc

echo 5. Compiling LLVM bitcode to assembly
llc ${LLC_ARCH} $FILE.ll.bc

echo 6. Link assembly
gcc -o $FILE.o -c -fPIC $FILE.ll.s

echo 7. Generate dynamic library
gcc -shared -o lib$FILE.so -Wl,-soname,$FILE $FILE.o

echo 8. Run JAVA code
java -Djava.library.path=. -cp vdir $FILE

fi
