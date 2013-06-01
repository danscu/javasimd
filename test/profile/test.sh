if [ "$1" == "" ]; then
  echo Usage: test.sh ClassName
else

LOG=log.txt

echo ======================================================================================= >> $LOG
date >> $LOG
echo ======================================================================================= >> $LOG

# Test java
./test-java.sh $1

# Optimization level -O*
for i in 3; do
  # Optimization places
  for opt in 0 1 2 3 4 5 6 7; do
    export OPT_BEFORE_JNI=$(($opt & 1))
    export OPT_AFTER_JNI=$((($opt & 2) >> 1))
    export OPT_COMPILE_NATIVE=$((($opt & 4) >> 2))
    export OLEVEL=$i
    export VECTOR_SIZE=0
    ./test-jni.sh $1
  done
done

echo "Timing results stored in $LOG"

fi
