if [ "$1" == "" ]; then
  echo Usage: test.sh ClassName
else

LOG=log.txt

echo ======================================================================================= >> $LOG
date >> $LOG
echo ======================================================================================= >> $LOG

# Test java
./test-java.sh $1

FOLDER=out-java
mkdir -p $FOLDER
cp $1.class $FOLDER

  # Optimization level -O*
  for i in 3; do
    # Optimization places
    for opt in 14 6 4; do
      export OPT_BEFORE_JNI=$(($opt & 1))
      export OPT_AFTER_JNI=$((($opt & 2) >> 1))
      export OPT_COMPILE_NATIVE=$((($opt & 4) >> 2))
      export VECTORIZE=$((($opt & 8) >> 3))
      export OLEVEL=$i
      export VECTOR_SIZE=0
      ./test-jni.sh $1

      # copy the files to new folder
      if [ "$opt" == "14" ]; then
          FOLDER=out-vec
      else if [ "$opt" == "6" ]; then
          FOLDER=out-jni
      else if [ "$opt" == "4" ]; then
          FOLDER=out-jni-fast
      fi; fi; fi
      mkdir -p $FOLDER
      cp lib$1.so $1.ll.s vdir/$1.* $FOLDER
    done
  done

echo "Timing results stored in $LOG"

fi
