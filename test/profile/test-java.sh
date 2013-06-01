FILE="$1"
LOG=log.txt

javac $FILE.java
echo -n "Java with JIT: " >> $LOG
java $FILE 2>> $LOG

echo -n "Java without JIT: " >> $LOG
java -Djava.compiler=NONE $FILE 2>> $LOG
