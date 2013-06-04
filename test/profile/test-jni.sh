DRAGONEGG=../../dragonegg.so
GCJ=gcj
FILE=$1

LOG=log.txt

# Defaults

# Optimization level
if [ "$OLEVEL" == "" ]; then
   OLEVEL=3
fi

# Vector size
if [ "$VECTOR_SIZE" == "" ]; then
   VECTOR_SIZE=8
fi

# Pre-JNI Optimization
if [ "$OPT_BEFORE_JNI" == "" ]; then
    OPT_BEFORE_JNI="1"
fi

# Post-JNI Optimization
if [ "$OPT_AFTER_JNI" == "" ]; then
    OPT_AFTER_JNI="1"
fi

# JNI native code compilation optimization
if [ "$OPT_COMPILE_NATIVE" == "" ]; then
    OPT_COMPILE_NATIVE="1"
fi

# Handle 64bit and 32bit compilation
if [[ ! `uname -a` =~ .*_64.* ]]; then
  LLC_ARCH="-march=x86"
fi

FUNC="testSum testArraySum testSLPVectorize testSort quicksort isPrime gcd primeCount $2 $3 $4 $5 $6 $7 $8 $9"
LLVMFLAGS="-disable-inlining --bb-vectorize --loop-vectorize -force-vector-width=$VECTOR_SIZE"
# -vectorize -vectorize-loops 

if [ "$1" == "" ]; then
  echo Usage: test.sh ClassName \{methods\}*
else

# Print parameters
echo OLEVEL=$OLEVEL >> $LOG
echo VECTOR_SIZE=$VECTOR_SIZE >> $LOG
echo MACHINETYPE=`uname -a` >> $LOG
echo OPT_BEFORE_JNI=$OPT_BEFORE_JNI >> $LOG
echo OPT_AFTER_JNI=$OPT_AFTER_JNI >> $LOG
echo OPT_COMPILE_NATIVE=$OPT_COMPILE_NATIVE >> $LOG

echo ==============================================================================================
echo OLEVEL=$OLEVEL VECTOR_SIZE=$VECTOR_SIZE
echo OPT_BEFORE_JNI=$OPT_BEFORE_JNI
echo OPT_AFTER_JNI=$OPT_AFTER_JNI
echo OPT_COMPILE_NATIVE=$OPT_COMPILE_NATIVE

echo 0. Compiling Java
if [ ! -f $FILE.class ]; then
  javac $FILE.java
else
  echo "Skipped"
fi

echo 1. Compile Java to LLVM
$GCJ -save-temps -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S $FILE.java

echo 1+. Optimize after LLVM generation
if [ "$OPT_BEFORE_JNI" == "1" ]; then
    opt -O$OLEVEL $LLVMFLAGS -S -o $FILE.opt.1.s $FILE.s
else
    cp $FILE.s $FILE.opt.1.s
fi

echo 2. Converting LLVM-IR to JNI code
./optimize.sh $FILE $FILE.opt.1.s ${FUNC}

echo 3+. Optimizing translated code
if [ "$OLEVEL" == "0" -o "$OPT_AFTER_JNI" != "1" ]; then
  cp vdir/$FILE.opt.1.s vdir/$FILE.opt.2.s
else
  opt -O$OLEVEL $LLVMFLAGS -S -o vdir/$FILE.opt.2.s vdir/$FILE.opt.1.s
fi

echo 4. Compile modified LLVM IR
llvm-as vdir/$FILE.opt.2.s -o $FILE.ll.bc

echo 5. Compiling LLVM bitcode to assembly
if [ "$OPT_COMPILE_NATIVE" == "1" ]; then
    llc -O$OLEVEL ${LLC_ARCH} $FILE.ll.bc
else
    llc -O0 ${LLC_ARCH} $FILE.ll.bc
fi

echo 6. Compile assembly to machine code
gcc -o $FILE.o -c -fPIC $FILE.ll.s

echo 7. Generate dynamic library
gcc -shared -o lib$FILE.so -Wl,-soname,$FILE $FILE.o

echo 8. Run optimized JAVA code
java -Djava.library.path=. -cp vdir $FILE 2>> $LOG

fi
