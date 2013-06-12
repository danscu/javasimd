DRAGONEGG=../../dragonegg.so
GCJ=gcj
FILE=$1

if [[ ! `uname -a` =~ .*_64.* ]]; then
  LLC_ARCH="-march=x86"
fi

FUNC="testSum testArraySum $2 $3 $4 $5 $6 $7 $8 $9"

if [ "$1" == "" ]; then
  echo Usage: test.sh ClassName \{methods\}*
else

echo 0. Compiling Java
if [ -f $FILE.java ]; then
  javac $FILE.java
fi

echo 1. Compile Java to LLVM
$GCJ -save-temps -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S $FILE.java

echo 2. Opt1: no optimization
cp $FILE.s $FILE.opt.s

echo 3. Compiling LLVM-IR to LLVM bitcode \(.bc\)
./optimize.sh $FILE $FILE.opt.s ${FUNC}

echo 3+. Opt2: optimizing translated code
opt -O3 -disable-inlining --bb-vectorize --loop-vectorize -force-vector-width=4 -S -o vdir/$FILE.opt2.s vdir/$FILE.opt.s

echo 4. Compile modified LLVM IR to bitcode
llvm-as vdir/$FILE.opt2.s -o $FILE.ll.bc

echo 5. Opt3: Compiling LLVM bitcode to assembly
llc ${LLC_ARCH} $FILE.ll.bc

echo 6. Link assembly
gcc -o $FILE.o -c -fPIC $FILE.ll.s

echo 7. Generate dynamic library
gcc -shared -o lib$FILE.so -Wl,-soname,$FILE $FILE.o

echo 8. Run modified JAVA code
java -Djava.library.path=. -cp vdir $FILE

fi
