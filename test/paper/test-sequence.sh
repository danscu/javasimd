clear
echo Standard Java Test
cd out-java
#echo -1- java VectorTestStressVersion 
#java VectorTestStressVersion 

echo -2- java -Djava.compiler=NONE VectorTestStressVersion 
java -Djava.compiler=NONE VectorTestStressVersion 

echo -3- java -agentlib:hprof=cpu=old VectorTestStressVersion
java -agentlib:hprof=cpu=old,file=3.txt VectorTestStressVersion 

echo -4- java -agentlib:hprof=cpu=old -Djava.compiler=NONE VectorTestStressVersion 
java -agentlib:hprof=cpu=old,file=4.txt -Djava.compiler=NONE VectorTestStressVersion 

cd ..

echo JNI Java Test
cd out-jni
echo -5- java -Djava.library.path=. VectorTestStressVersion
java -Djava.library.path=. VectorTestStressVersion

echo -6- java -Djava.library.path=. -Djava.compiler=NONE VectorTestStressVersion
java -Djava.library.path=. -Djava.compiler=NONE VectorTestStressVersion

echo -7- java -Djava.library.path=. -agentlib:hprof=cpu=old VectorTestStressVersion
java -Djava.library.path=. -agentlib:hprof=cpu=old,file=7.txt VectorTestStressVersion

echo -8- java -Djava.library.path=. -agentlib:hprof=cpu=old -Djava.compiler=NONE VectorTestStressVersion
java -Djava.library.path=. -agentlib:hprof=cpu=old,file=8.txt -Djava.compiler=NONE VectorTestStressVersion


cd ..

echo JNI-FAST Java Test
cd out-jni-fast

echo -9- java -Djava.library.path=. VectorTestStressVersion
java -Djava.library.path=. VectorTestStressVersion

echo -10- java -Djava.library.path=. -Djava.compiler=NONE VectorTestStressVersion
java -Djava.library.path=. -Djava.compiler=NONE VectorTestStressVersion

echo -11- java -Djava.library.path=. -agentlib:hprof=cpu=old VectorTestStressVersion
java -Djava.library.path=. -agentlib:hprof=cpu=old,file=11.txt VectorTestStressVersion

echo -12- java -Djava.library.path=. -agentlib:hprof=cpu=old -Djava.compiler=NONE VectorTestStressVersion
java -Djava.library.path=. -agentlib:hprof=cpu=old,file=12.txt -Djava.compiler=NONE VectorTestStressVersion

cd ..

echo VECTORIZE Java Test 
cd out-vec

echo -13- java -Djava.library.path=. VectorTestStressVersion
java -Djava.library.path=. VectorTestStressVersion

echo -14- java -Djava.library.path=. -Djava.compiler=NONE VectorTestStressVersion
java -Djava.library.path=. -Djava.compiler=NONE VectorTestStressVersion

echo -15- java -Djava.library.path=. -agentlib:hprof=cpu=old VectorTestStressVersion
java -Djava.library.path=. -agentlib:hprof=cpu=old,file=15.txt VectorTestStressVersion

echo -16- java -Djava.library.path=. -agentlib:hprof=cpu=old -Djava.compiler=NONE VectorTestStressVersion
java -Djava.library.path=. -agentlib:hprof=cpu=old,file=16.txt -Djava.compiler=NONE VectorTestStressVersion

cd ..
