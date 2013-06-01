if [ "$1" == "" ]; then
  echo Usage: time.sh ClassName
else

LOG=log.txt

echo ======================================================================================= >> $LOG
date >> $LOG

for i in 0 1 2 3; do
  OLEVEL=$i VECTOR_SIZE=8 ./test.sh $1
done

echo "Timing results stored in $LOG"

fi
