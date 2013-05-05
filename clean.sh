echo Cleaning...
rm -rf clang+llvm-3.2-x86_64-linux-ubuntu-12.04/
rm -rf dragonegg-3.2.src/
rm -f dragonegg-3.2.src.tar.gz
rm -f clang+llvm-3.2-x86_64-linux-ubuntu-12.04.tar.gz
rm -f dragonegg.so

echo Cleaning avian...
(cd avian; make clean)

TEST_DIRS=`ls -1 test`
for d in $TEST_DIRS; do
  echo Cleaning $d...
  (cd test/$d; ./clean.sh)
done
