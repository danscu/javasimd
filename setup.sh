LOCAL_DIR=`pwd`
export PATH=$LOCAL_DIR/clang+llvm-3.2-x86-linux-ubuntu-12.04/bin:$PATH

if [[ ! `uname -a` =~ .*_64.* ]]; then
  LLC_ARCH="-march=x86"
  echo LLVM 64-bit compilation disabled
else
  echo LLVM 64-bit compilation not disabled
fi

export LLC_ARCH
