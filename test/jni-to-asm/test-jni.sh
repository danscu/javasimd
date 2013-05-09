javac HelloWorld.java
javah -jni HelloWorld
gcc -fPIC -c -I"/opt/java/include" -I"/opt/java/include/linux" HelloWorld.c
gcc HelloWorld.o -shared -o libHelloWorld.so -Wl,-soname,HelloWorld
java -Djava.library.path=. HelloWorld
