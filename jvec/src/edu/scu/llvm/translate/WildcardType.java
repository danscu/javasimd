package edu.scu.llvm.translate;

import cn.edu.sjtu.jllvm.VMCore.Types.Type;

public class WildcardType extends Type {
	public WildcardType(String name) {
		super(0, name);
	}
}
