FILE="$1"
LOG=log.txt

javac $FILE.java
echo "Java with JIT: " >> $LOG
java $FILE 2>> $LOG

echo >> $LOG

echo "Java without JIT: " >> $LOG
if [ "$2" != "jit-only" ]; then
  java -Djava.compiler=NONE $FILE 2>> $LOG
else
  echo "not run" >> $LOG
fi
echo >> $LOG
