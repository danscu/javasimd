DRAGONEGG=../../dragonegg.so

FILE=HelloWorld

if [[ ! `uname -a` =~ .*_64.* ]]; then
  LLC_ARCH="-march=x86"
fi

#echo 1. Compiling C to LLVM-IR
#gcc -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S $FILE.c

echo 2. Compiling LLVM-IR to LLVM bitcode \(.bc\)
llvm-as Example/${FILE}.s -o ${FILE}.ll.bc

echo 3. Compiling LLVM bitcode to assembly
llc ${LLC_ARCH} $FILE.ll.bc

echo 4. Link assembly
gcc -o $FILE.o -c -fPIC $FILE.ll.s

echo 5. Generate dynamic library
gcc -shared -o lib$FILE.so -Wl,-soname,$FILE $FILE.o

echo 6. Run JAVA code
java -Djava.library.path=. $FILE
