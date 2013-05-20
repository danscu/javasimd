VDIR=vdir
JVECBIN=~/work/javasimd/jvec/bin
JLIB=../../jvec/lib
JFLAGS="-cp .:$JLIB/asm-all-4.1.jar:$JLIB/antlr-4.0-complete.jar:$JVECBIN"

mkdir -p $VDIR
mkdir -p $(dirname $VDIR/$2)
java $JFLAGS edu.scu.jjni.aotc.JavaOptimizer $1 $VDIR/$1.class $1 $2 $VDIR/$2 $3 $4 $5 $6 $7 $8 $9
