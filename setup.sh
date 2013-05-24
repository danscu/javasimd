LOCAL_DIR=`pwd`

if [[ ! `uname -a` =~ .*_64.* ]]; then
  LLC_ARCH="-march=x86"
  echo LLVM 64-bit compilation disabled
else
  LLV="_64"
  echo LLVM 64-bit compilation not disabled
fi

export PATH=$LOCAL_DIR/clang+llvm-3.2-x86${LLV}-linux-ubuntu-12.04/bin:$PATH

export LLC_ARCH
