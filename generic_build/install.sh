###############################################
# CLASS PATH
###############################################

PKG=classpath-0.97.2
SUFFIX=.tar.gz
URL=http://mirror.anl.gov/pub/gnu/classpath/$PKG$SUFFIX
if [ ! -d $PKG ]; then
  wget $URL
  tar -zxvf $PKG$SUFFIX
  rm -f $PKG$SUFFIX
fi 

if [ ! -d $PKG/lib ]; then
(cd $PKG; ./configure --disable-plugin --disable-examples --disable-Werror --disable-gtk-peer --disable-gconf-peer; make)
(cd $PKG/lib; 
    ln -s ../native/jni/gtk-peer/.libs/libgtkpeer.so;
    ln -s ../native/jni/gconf-peer/.libs/libgconfpeer.so;
    ln -s ../native/jni/java-io/.libs/libjavaio.so;
    ln -s ../native/jni/java-lang/.libs/libjavalangreflect.so;
    ln -s ../native/jni/java-lang/.libs/libjavalang.so;
    ln -s ../native/jni/java-net/.libs/libjavanet.so;
    ln -s ../native/jni/java-nio/.libs/libjavanio.so;
    ln -s ../native/jni/java-util/.libs/libjavautil.so;)
fi

CLSPATH_LIB=`pwd`/$PKG/lib

###############################################
# LLVM
###############################################

PKG=llvm-3.2.src
SUFFIX=.tar.gz
URL=http://llvm.org/releases/3.2/$PKG$SUFFIX
if [ ! -d $PKG ]; then
  wget $URL
  tar -zxvf $PKG$SUFFIX
  rm -f $PKG$SUFFIX
fi 

cd $PKG
if [ ! -f config.status ]; then
  ./configure
fi

###############################################
# LLVM C-lang
###############################################

cd tools

PKG=clang-3.2.src
SUFFIX=.tar.gz
URL=http://llvm.org/releases/3.2/clang-3.2.src.tar.gz
if [ ! -d $PKG ]; then
  wget $URL
  tar -zxvf $PKG$SUFFIX
  rm -f $PKG$SUFFIX
fi 

LLVM_BIN=`pwd`/Release+Asserts/bin
LLVM_DIR=`pwd`

echo $LLVM_BIN > ../llvm.dir

cd ..
make -j16

###############################################
# LLVM - VMKIT
###############################################

PKG=vmkit-0.32
SUFFIX=.tar.bz2
URL=http://llvm.org/viewvc/llvm-project/vmkit/branches/release_032/www/releases/vmkit-0.32.tar.bz2?revision=170960

if [ ! -d $PKG ]; then
  wget -O $PKG$SUFFIX $URL
  tar -jxf $PKG$SUFFIX
  rm -f $PKG$SUFFIX
fi

cd $PKG
if [ ! -f config.status ]; then
  ./configure --with-gnu-classpath-glibj=$CLSPATH_LIB/glibj.zip --with-gnu-classpath-libs=$CLSPATH_LIB --with-llvmsrc=$LLVM_DIR --with-llvmobj=$LLVM_DIR
fi
make -j8

