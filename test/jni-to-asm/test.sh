DRAGONEGG=../../dragonegg.so

FILE=HelloWorld

echo 1. Compiling C to LLVM-IR
gcc -fplugin=$DRAGONEGG -fplugin-arg-dragonegg-emit-ir -S $FILE.c

echo 2. Compiling LLVM-IR to LLVM bitcode \(.bc\)
llvm-as $FILE.s

echo 3. Compiling LLVM bitcode to assembly
llc $FILE.s.bc

echo 4. Link assembly
gcc -o $FILE.o -c -fPIC $FILE.s.s

echo 5. Generate dynamic library
gcc -shared -o lib$FILE.so -Wl,-soname,$FILE $FILE.o

echo 6. Compile JAVA
javac $FILE.java

echo 7. Run JAVA code
java -Djava.library.path=. $FILE
