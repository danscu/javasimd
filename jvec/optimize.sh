VDIR=vdir

mkdir -p $VDIR
mkdir -p $(dirname $VDIR/$2)
java -cp lib/asm-all-4.1.jar:lib/antlr-4.0-complete.jar:bin:Example edu.scu.jjni.aotc.JavaOptimizer $1 $VDIR/$1.class $1 $2 $VDIR/$2 $3 $4 $5 $6 $7 $8 $9
