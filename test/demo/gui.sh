VDIR=vdir
JVECBIN=../../jvec/bin
JLIB=../../jvec/lib
JFLAGS="-cp .:$JLIB/asm-all-4.1.jar:$JLIB/antlr-4.0-complete.jar:$JVECBIN"

java $JFLAGS edu.scu.jjni.app.FileGUI
