DRAGONEGG=../../dragonegg.so
GCJ=gcj
FILE=$1

LOG=log.txt

# Optimization level
if [ "$OLEVEL" == "" ]; then
   OLEVEL=3
fi

# Vector size
if [ "$VECTOR_SIZE" == "" ]; then
   VECTOR_SIZE=8
fi

# Handle 64bit and 32bit compilation
if [[ ! `uname -a` =~ .*_64.* ]]; then
  LLC_ARCH="-march=x86"
fi

FUNC="testSum testArraySum testSLPVectorize testSort quicksort isPrime gcd primeCount $2 $3 $4 $5 $6 $7 $8 $9"

if [ "$1" == "" ]; then
  echo Usage: test.sh ClassName \{methods\}*
else

# Print parameters
echo OLEVEL=$OLEVEL >> $LOG
echo VECTOR_SIZE=$VECTOR_SIZE >> $LOG
echo MACHINETYPE=`uname -a` >> $LOG

echo ==============================================================================================
echo OLEVEL=$OLEVEL VECTOR_SIZE=$VECTOR_SIZE

echo 0. Compiling Java
if [ -f $FILE.java ]; then
  javac $FILE.java
fi

echo 1. Compile Java to LLVM
$GCJ -save-temps -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S $FILE.java

echo 2. Converting LLVM-IR to JNI code
./optimize.sh $FILE $FILE.s ${FUNC}

echo 3+. Optimizing translated code
if [ $OLEVEL == "0" ]; then
  cp vdir/$FILE.s vdir/$FILE.opt.s
else
  opt -O$OLEVEL -disable-inlining -S -o vdir/$FILE.opt.s vdir/$FILE.s
fi

echo 4. Compile modified LLVM IR
llvm-as vdir/$FILE.opt.s -o $FILE.ll.bc

echo 5. Compiling LLVM bitcode to assembly
llc ${LLC_ARCH} $FILE.ll.bc

echo 6. Compile assembly
gcc -o $FILE.o -c -fPIC $FILE.ll.s

echo 7. Generate dynamic library
gcc -shared -o lib$FILE.so -Wl,-soname,$FILE $FILE.o

echo 8. Run optimized JAVA code
java -Djava.library.path=. -cp vdir $FILE 2>> $LOG

echo 9. Run original JAVA code
java $FILE 2>>$LOG

fi
