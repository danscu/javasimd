JFLAGS = -g -sourcepath src -d bin -classpath .:bin:lib/antlr-4.0-complete.jar:lib/asm-all-4.1.jar
JC = javac

SRCDIR = src
BINDIR = bin

.SUFFIXES: .java .class

SRCDIRS = \
cn/edu/sjtu/jllvm/VMCore/Types \
cn/edu/sjtu/jllvm/VMCore \
cn/edu/sjtu/jllvm/VMCore/Instructions \
cn/edu/sjtu/jllvm/VMCore \
cn/edu/sjtu/jllvm/VMCore/Operators \
cn/edu/sjtu/jllvm/VMCore \
cn/edu/sjtu/jllvm/VMCore/Constants \
edu/scu/llvm/translate \
edu/scu/llvm/parser \
edu/scu/llvm/asm \
edu/scu/jjni/app \
edu/scu/jjni/aotc \
edu/scu/jjni/aotc/recgen \

SRCS := $(foreach dir,$(SRCDIRS),$(wildcard $(SRCDIR)/$(dir)/*.java))
SRCS := $(patsubst $(SRCDIR)/%,%,$(SRCS))

CLASSES := $(SRCS:.java=.class)
CLASSES := $(addprefix $(BINDIR)/,$(CLASSES))

all: $(CLASSES)

$(BINDIR)/%.class: $(SRCDIR)/%.java
	@mkdir -p bin
	$(JC) $(JFLAGS) $<

clean:
	$(RM) $(CLASSES)
