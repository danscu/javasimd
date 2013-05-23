LLVM_PKG=clang+llvm-3.2-x86-linux-ubuntu-12.04
DRAGONEGG_PKG=dragonegg-3.2.src

PKG_SUFFIX=.tar.gz

echo Installing Java compiler \(passwd needed\)
sudo apt-get install gcj-jdk gcj-4.6-jdk

if [ ! -d $LLVM_PKG ]; then
  echo Getting LLVM 3.2
  wget http://llvm.org/releases/3.2/${LLVM_PKG}${PKG_SUFFIX}

  echo Extracting LLVM 3.2
  tar -zxf ${LLVM_PKG}${PKG_SUFFIX}
fi

if [ ! -d $DRAGONEGG_PKG ]; then
  echo Getting DragonEgg 3.2
  wget http://llvm.org/releases/3.2/${DRAGONEGG_PKG}${PKG_SUFFIX}

  echo Extracting DragonEgg 3.2
  tar -zxvf ${DRAGONEGG_PKG}${PKG_SUFFIX}
fi

echo Installing dependencies \(passwd needed\)
sudo apt-get install libmpfr-dev libmpc-dev gcc-4.6-plugin-dev 

echo Setup environment
. setup.sh

if [ ! -f dragonegg.so ]; then
  echo Compiling dragonegg
  (cd $DRAGONEGG_PKG; make -j8 DISABLE_VERSION_CHECK=1)

  echo Create symbolic link for dragonegg.so for easy access
  ln -sf `pwd`/$DRAGONEGG_PKG/dragonegg.so .
fi

echo
echo "**********************************************************************"
echo Installation done! Please run \'source setup.sh\' for subsequent use.
echo "**********************************************************************"
