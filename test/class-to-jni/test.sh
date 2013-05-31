DRAGONEGG=../../dragonegg.so
GCJ=gcj
FILE=$1

if [[ ! `uname -a` =~ .*_64.* ]]; then
  LLC_ARCH="-march=x86"
fi

FUNC="testSum testArraySum testSort quicksort testSLPVectorize"

if [ "$1" == "" ]; then
  echo Usage: test.sh ClassName
else

echo 0. Compiling Java
if [ -f $FILE.java ]; then
  javac $FILE.java
fi

echo 1. Compile Java to LLVM
$GCJ -save-temps -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S $FILE.java

echo 2. Optimizing LLVM code
#opt -S -vectorize-loops -bb-vectorize -loop-vectorize -vectorize -force-vector-width=2 -o $FILE.opt.s $FILE.s
opt -O3 -disable-inlining -vectorize -vectorize-loops --bb-vectorize --loop-vectorize -force-vector-width=8 -S -o $FILE.opt.s $FILE.s

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
