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
    if [ "$opt" == "14" ]; then
       export VSIZES="0 2 4 8 16"
    else
       export VSIZES="0"
    fi

    for vs in $VSIZES; do 
      export OPT_BEFORE_JNI=$(($opt & 1))
      export OPT_AFTER_JNI=$((($opt & 2) >> 1))
      export OPT_COMPILE_NATIVE=$((($opt & 4) >> 2))
      export VECTORIZE=$((($opt & 8) >> 3))
      export OLEVEL=$i
      export VECTOR_SIZE=$vs
      ./test-jni.sh $1

      # copy the files to new folder
      if [ "$opt" == "14" ]; then
          FOLDER=out-vec-$vs
      else if [ "$opt" == "6" ]; then
          FOLDER=out-jni
      else if [ "$opt" == "4" ]; then
          FOLDER=out-jni-fast
      fi; fi; fi
      mkdir -p $FOLDER
      cp lib$1.so $1.ll.s vdir/$1.* $FOLDER
      cp $1.opt.1.s $FOLDER/$1.opt.0.s
    done
  done
done

echo "Timing results stored in $LOG"

fi
