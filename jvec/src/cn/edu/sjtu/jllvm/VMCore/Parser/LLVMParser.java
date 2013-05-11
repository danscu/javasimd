// Generated from LLVM.g4 by ANTLR 4.0

package cn.edu.sjtu.jllvm.VMCore.Parser;

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import cn.edu.sjtu.jllvm.VMCore.*;
import cn.edu.sjtu.jllvm.VMCore.Types.*;
import cn.edu.sjtu.jllvm.VMCore.Instructions.*;
import cn.edu.sjtu.jllvm.VMCore.Constants.*;
import cn.edu.sjtu.jllvm.VMCore.Operators.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LLVMParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__56=1, T__55=2, T__54=3, T__53=4, T__52=5, T__51=6, T__50=7, T__49=8, 
		T__48=9, T__47=10, T__46=11, T__45=12, T__44=13, T__43=14, T__42=15, T__41=16, 
		T__40=17, T__39=18, T__38=19, T__37=20, T__36=21, T__35=22, T__34=23, 
		T__33=24, T__32=25, T__31=26, T__30=27, T__29=28, T__28=29, T__27=30, 
		T__26=31, T__25=32, T__24=33, T__23=34, T__22=35, T__21=36, T__20=37, 
		T__19=38, T__18=39, T__17=40, T__16=41, T__15=42, T__14=43, T__13=44, 
		T__12=45, T__11=46, T__10=47, T__9=48, T__8=49, T__7=50, T__6=51, T__5=52, 
		T__4=53, T__3=54, T__2=55, T__1=56, T__0=57, BLOCK_ID=58, BOOLEAN_TYPE=59, 
		INTEGER_TYPE=60, LOCAL_VARIABLE=61, GLOBAL_VARIABLE=62, INTEGER=63, BOOLEAN=64, 
		FLOATING_POINT=65, HEX=66, BINARY_OP=67, CONVERSION_OP=68, CMP_COND=69, 
		ICMP_COND=70, FCMP_COND=71, VOLATILE=72, VOID=73, OPAQUE=74, METADATA=75, 
		SECTION=76, ALIGN=77, LABEL=78, TO=79, UNWIND=80, FLOATING_POINT_TYPE=81, 
		STRING=82, NULL=83, UNDEF=84, LINKAGE=85, VISIBILITY=86, CCONV=87, PARAMETER_ATTRIBUTES=88, 
		FUNCTION_ATTRIBUTES=89, UNNAMED_ADDR=90, IDENTIFIER=91, WS=92, LINE_COMMENT=93;
	public static final String[] tokenNames = {
		"<INVALID>", "'['", "'*'", "'<'", "'inbounds'", "'asm'", "'sideeffect'", 
		"'tail'", "'thread_local'", "'}'", "'alloca'", "'phi'", "'target'", "'union'", 
		"')'", "'c'", "'global'", "'extractvalue'", "'='", "'module'", "'insertelement'", 
		"'x'", "'alias'", "'call'", "'!dbg'", "'load'", "'store'", "'invoke'", 
		"'!'", "'unreachable'", "'triple'", "'getelementptr'", "']'", "'exact'", 
		"'select'", "','", "'('", "'extractelement'", "'ret'", "'...'", "'{'", 
		"'zeroinitializer'", "'insertvalue'", "'nuw'", "'constant'", "'fcmp'", 
		"'define'", "'alignstack'", "'indirectbr'", "'>'", "'type'", "'datalayout'", 
		"'shufflevector'", "'switch'", "'icmp'", "'br'", "'declare'", "'nsw'", 
		"BLOCK_ID", "'i1'", "INTEGER_TYPE", "LOCAL_VARIABLE", "GLOBAL_VARIABLE", 
		"INTEGER", "BOOLEAN", "FLOATING_POINT", "HEX", "BINARY_OP", "CONVERSION_OP", 
		"CMP_COND", "ICMP_COND", "FCMP_COND", "'volatile'", "'void'", "'opaque'", 
		"'metadata'", "'section'", "'align'", "'label'", "'to'", "'unwind'", "FLOATING_POINT_TYPE", 
		"STRING", "'null'", "'undef'", "LINKAGE", "VISIBILITY", "CCONV", "PARAMETER_ATTRIBUTES", 
		"FUNCTION_ATTRIBUTES", "'unnamed_addr'", "IDENTIFIER", "WS", "LINE_COMMENT"
	};
	public static final int
		RULE_llvm_program = 0, RULE_target = 1, RULE_module = 2, RULE_named_type = 3, 
		RULE_global_variable = 4, RULE_aliases_variable = 5, RULE_function_declaration = 6, 
		RULE_function_definition = 7, RULE_basic_block = 8, RULE_llvm_align = 9, 
		RULE_llvm_section = 10, RULE_terminator = 11, RULE_block_label = 12, RULE_operator = 13, 
		RULE_binary_op = 14, RULE_vector_op = 15, RULE_aggregate_op = 16, RULE_memory_op = 17, 
		RULE_alloca_op = 18, RULE_load_op = 19, RULE_store_op = 20, RULE_getelementptr_op = 21, 
		RULE_conversion_op = 22, RULE_icmp_op = 23, RULE_fcmp_op = 24, RULE_phi_op = 25, 
		RULE_select_op = 26, RULE_call_op = 27, RULE_function_call = 28, RULE_argument_list = 29, 
		RULE_variable = 30, RULE_expression = 31, RULE_getelementptr_expr = 32, 
		RULE_conversion_expr = 33, RULE_binary_expr = 34, RULE_cmp_expr = 35, 
		RULE_metadata_definition = 36, RULE_metadata_variable = 37, RULE_metadata_expr = 38, 
		RULE_metadata_list = 39, RULE_dbg_metadata = 40, RULE_id_type = 41, RULE_element_type = 42, 
		RULE_scalar_type = 43, RULE_primitive_type = 44, RULE_first_class_type = 45, 
		RULE_derived_type = 46, RULE_aggregate_type = 47, RULE_pointer_type = 48, 
		RULE_structure_type = 49, RULE_packed_structure_type = 50, RULE_union_type = 51, 
		RULE_type_list = 52, RULE_array_type = 53, RULE_vector_type = 54, RULE_return_type = 55, 
		RULE_function_type = 56, RULE_parameter_type_list = 57, RULE_initializer = 58, 
		RULE_index = 59, RULE_llvm_constant = 60, RULE_simple_constant = 61, RULE_complex_constant = 62, 
		RULE_constant_list = 63, RULE_structure_constant = 64, RULE_array_constant = 65, 
		RULE_vector_constant = 66, RULE_undef_constant = 67, RULE_function_name = 68, 
		RULE_assembly_expr = 69;
	public static final String[] ruleNames = {
		"llvm_program", "target", "module", "named_type", "global_variable", "aliases_variable", 
		"function_declaration", "function_definition", "basic_block", "llvm_align", 
		"llvm_section", "terminator", "block_label", "operator", "binary_op", 
		"vector_op", "aggregate_op", "memory_op", "alloca_op", "load_op", "store_op", 
		"getelementptr_op", "conversion_op", "icmp_op", "fcmp_op", "phi_op", "select_op", 
		"call_op", "function_call", "argument_list", "variable", "expression", 
		"getelementptr_expr", "conversion_expr", "binary_expr", "cmp_expr", "metadata_definition", 
		"metadata_variable", "metadata_expr", "metadata_list", "dbg_metadata", 
		"id_type", "element_type", "scalar_type", "primitive_type", "first_class_type", 
		"derived_type", "aggregate_type", "pointer_type", "structure_type", "packed_structure_type", 
		"union_type", "type_list", "array_type", "vector_type", "return_type", 
		"function_type", "parameter_type_list", "initializer", "index", "llvm_constant", 
		"simple_constant", "complex_constant", "constant_list", "structure_constant", 
		"array_constant", "vector_constant", "undef_constant", "function_name", 
		"assembly_expr"
	};

	@Override
	public String getGrammarFileName() { return "LLVM.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


	TypeFactory typeFactory = new TypeFactory();
	ValueFactory valueFactory = new ValueFactory();
	InstFactory instFactory = new InstFactory();

	public LLVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Llvm_programContext extends ParserRuleContext {
		public Module program;
		public Global_variableContext global_variable;
		public Aliases_variableContext aliases_variable;
		public Function_declarationContext function_declaration;
		public Function_definitionContext function_definition;
		public List<Metadata_definitionContext> metadata_definition() {
			return getRuleContexts(Metadata_definitionContext.class);
		}
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public List<Function_declarationContext> function_declaration() {
			return getRuleContexts(Function_declarationContext.class);
		}
		public Aliases_variableContext aliases_variable(int i) {
			return getRuleContext(Aliases_variableContext.class,i);
		}
		public List<Global_variableContext> global_variable() {
			return getRuleContexts(Global_variableContext.class);
		}
		public Metadata_definitionContext metadata_definition(int i) {
			return getRuleContext(Metadata_definitionContext.class,i);
		}
		public List<Aliases_variableContext> aliases_variable() {
			return getRuleContexts(Aliases_variableContext.class);
		}
		public TargetContext target(int i) {
			return getRuleContext(TargetContext.class,i);
		}
		public Global_variableContext global_variable(int i) {
			return getRuleContext(Global_variableContext.class,i);
		}
		public Function_definitionContext function_definition(int i) {
			return getRuleContext(Function_definitionContext.class,i);
		}
		public List<Named_typeContext> named_type() {
			return getRuleContexts(Named_typeContext.class);
		}
		public List<TargetContext> target() {
			return getRuleContexts(TargetContext.class);
		}
		public TerminalNode EOF() { return getToken(LLVMParser.EOF, 0); }
		public Function_declarationContext function_declaration(int i) {
			return getRuleContext(Function_declarationContext.class,i);
		}
		public Named_typeContext named_type(int i) {
			return getRuleContext(Named_typeContext.class,i);
		}
		public List<Function_definitionContext> function_definition() {
			return getRuleContexts(Function_definitionContext.class);
		}
		public Llvm_programContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llvm_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterLlvm_program(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitLlvm_program(this);
		}
	}

	public final Llvm_programContext llvm_program() throws RecognitionException {
		Llvm_programContext _localctx = new Llvm_programContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_llvm_program);

		List<GlobalVariable> globalVariables = new ArrayList<GlobalVariable>();
		List<GlobalAlias> globalAlias = new ArrayList<GlobalAlias>();
		List<FunctionDeclare> functionDeclares = new ArrayList<FunctionDeclare>();
		List<Function> functions = new ArrayList<Function>();

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==12) {
				{
				{
				setState(140); target();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146); module();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LOCAL_VARIABLE) {
				{
				{
				setState(147); named_type();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(153); ((Llvm_programContext)_localctx).global_variable = global_variable();
					globalVariables.add(((Llvm_programContext)_localctx).global_variable.globalVariable);
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GLOBAL_VARIABLE) {
				{
				{
				setState(161); ((Llvm_programContext)_localctx).aliases_variable = aliases_variable();
				globalAlias.add(((Llvm_programContext)_localctx).aliases_variable.globalAlias);
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(176);
				switch (_input.LA(1)) {
				case 56:
					{
					setState(169); ((Llvm_programContext)_localctx).function_declaration = function_declaration();
					functionDeclares.add(((Llvm_programContext)_localctx).function_declaration.functionDeclare);
					}
					break;
				case 46:
					{
					setState(172); ((Llvm_programContext)_localctx).function_definition = function_definition();
					functions.add(((Llvm_programContext)_localctx).function_definition.function);
					}
					break;
				case 28:
					{
					setState(175); metadata_definition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 28) | (1L << 46) | (1L << 56))) != 0) );
			setState(180); match(EOF);
			}
			 
			((Llvm_programContext)_localctx).program =  valueFactory.createModule(globalVariables, globalAlias, functionDeclares, functions, typeFactory.getNamedTypeTable());

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(LLVMParser.STRING, 0); }
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitTarget(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_target);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); match(12);
			setState(183);
			_la = _input.LA(1);
			if ( !(_la==30 || _la==51) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(184); match(18);
			setState(185); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(LLVMParser.STRING, 0); }
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitModule(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_module);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); match(19);
			setState(188); match(5);
			setState(189); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Named_typeContext extends ParserRuleContext {
		public Token LOCAL_VARIABLE;
		public Derived_typeContext derived_type;
		public Derived_typeContext derived_type() {
			return getRuleContext(Derived_typeContext.class,0);
		}
		public TerminalNode LOCAL_VARIABLE() { return getToken(LLVMParser.LOCAL_VARIABLE, 0); }
		public Named_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterNamed_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitNamed_type(this);
		}
	}

	public final Named_typeContext named_type() throws RecognitionException {
		Named_typeContext _localctx = new Named_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_named_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); ((Named_typeContext)_localctx).LOCAL_VARIABLE = match(LOCAL_VARIABLE);
			setState(192); match(18);
			setState(193); match(50);
			{
			setState(194); ((Named_typeContext)_localctx).derived_type = derived_type();
			String idTypeName = (((Named_typeContext)_localctx).LOCAL_VARIABLE!=null?((Named_typeContext)_localctx).LOCAL_VARIABLE.getText():null); Type type = ((Named_typeContext)_localctx).derived_type.type; typeFactory.addIDType(idTypeName, type); 
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Global_variableContext extends ParserRuleContext {
		public GlobalVariable globalVariable;
		public Token GLOBAL_VARIABLE;
		public Token LINKAGE;
		public Derived_typeContext derived_type;
		public InitializerContext initializer;
		public Llvm_sectionContext llvm_section;
		public Llvm_alignContext llvm_align;
		public Derived_typeContext derived_type() {
			return getRuleContext(Derived_typeContext.class,0);
		}
		public TerminalNode VISIBILITY() { return getToken(LLVMParser.VISIBILITY, 0); }
		public Llvm_alignContext llvm_align() {
			return getRuleContext(Llvm_alignContext.class,0);
		}
		public TerminalNode LINKAGE() { return getToken(LLVMParser.LINKAGE, 0); }
		public Llvm_sectionContext llvm_section() {
			return getRuleContext(Llvm_sectionContext.class,0);
		}
		public TerminalNode UNNAMED_ADDR() { return getToken(LLVMParser.UNNAMED_ADDR, 0); }
		public TerminalNode GLOBAL_VARIABLE() { return getToken(LLVMParser.GLOBAL_VARIABLE, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public Global_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterGlobal_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitGlobal_variable(this);
		}
	}

	public final Global_variableContext global_variable() throws RecognitionException {
		Global_variableContext _localctx = new Global_variableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_global_variable);

		String name;
		String linkage = null;
		boolean isThreadLocal = false;
		boolean isConstant = false;
		Type type = null; 
		Constant initializer = null;
		String section = null;
		int align = -1;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); ((Global_variableContext)_localctx).GLOBAL_VARIABLE = match(GLOBAL_VARIABLE);
			name = (((Global_variableContext)_localctx).GLOBAL_VARIABLE!=null?((Global_variableContext)_localctx).GLOBAL_VARIABLE.getText():null); name = name.substring(1, name.length());
			setState(199); match(18);
			setState(202);
			_la = _input.LA(1);
			if (_la==LINKAGE) {
				{
				setState(200); ((Global_variableContext)_localctx).LINKAGE = match(LINKAGE);
				linkage = (((Global_variableContext)_localctx).LINKAGE!=null?((Global_variableContext)_localctx).LINKAGE.getText():null);
				}
			}

			setState(205);
			_la = _input.LA(1);
			if (_la==VISIBILITY) {
				{
				setState(204); match(VISIBILITY);
				}
			}

			setState(209);
			_la = _input.LA(1);
			if (_la==8) {
				{
				setState(207); match(8);
				isThreadLocal= true;
				}
			}

			setState(212);
			_la = _input.LA(1);
			if (_la==UNNAMED_ADDR) {
				{
				setState(211); match(UNNAMED_ADDR);
				}
			}

			setState(217);
			switch (_input.LA(1)) {
			case 16:
				{
				setState(214); match(16);
				}
				break;
			case 44:
				{
				setState(215); match(44);
				isConstant = true;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(219); ((Global_variableContext)_localctx).derived_type = derived_type();
			type = ((Global_variableContext)_localctx).derived_type.type;
			setState(235);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(221); ((Global_variableContext)_localctx).initializer = initializer();
				initializer = ((Global_variableContext)_localctx).initializer.constant;
				setState(227);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(223); match(35);
					setState(224); ((Global_variableContext)_localctx).llvm_section = llvm_section();
					section = ((Global_variableContext)_localctx).llvm_section.section;
					}
					break;
				}
				setState(233);
				_la = _input.LA(1);
				if (_la==35) {
					{
					setState(229); match(35);
					setState(230); ((Global_variableContext)_localctx).llvm_align = llvm_align();
					align = ((Global_variableContext)_localctx).llvm_align.align;
					}
				}

				}
				break;
			}
			}

			((Global_variableContext)_localctx).globalVariable =  valueFactory.createGlobalVariable(name, linkage, isThreadLocal, isConstant, type, 
			                                  initializer, section, align);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aliases_variableContext extends ParserRuleContext {
		public GlobalAlias globalAlias;
		public Token g1;
		public Token LINKAGE;
		public Token VISIBILITY;
		public Derived_typeContext derived_type;
		public Token g2;
		public Derived_typeContext derived_type() {
			return getRuleContext(Derived_typeContext.class,0);
		}
		public TerminalNode VISIBILITY() { return getToken(LLVMParser.VISIBILITY, 0); }
		public TerminalNode LINKAGE() { return getToken(LLVMParser.LINKAGE, 0); }
		public TerminalNode GLOBAL_VARIABLE(int i) {
			return getToken(LLVMParser.GLOBAL_VARIABLE, i);
		}
		public List<TerminalNode> GLOBAL_VARIABLE() { return getTokens(LLVMParser.GLOBAL_VARIABLE); }
		public Aliases_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliases_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterAliases_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitAliases_variable(this);
		}
	}

	public final Aliases_variableContext aliases_variable() throws RecognitionException {
		Aliases_variableContext _localctx = new Aliases_variableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_aliases_variable);

		String name;
		String linkage = null;
		String visibility = null;
		Type type;
		String gVarName;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); ((Aliases_variableContext)_localctx).g1 = match(GLOBAL_VARIABLE);
			name = (((Aliases_variableContext)_localctx).g1!=null?((Aliases_variableContext)_localctx).g1.getText():null); name = name.substring(1, name.length());
			setState(239); match(18);
			setState(240); match(22);
			setState(243);
			_la = _input.LA(1);
			if (_la==LINKAGE) {
				{
				setState(241); ((Aliases_variableContext)_localctx).LINKAGE = match(LINKAGE);
				linkage = (((Aliases_variableContext)_localctx).LINKAGE!=null?((Aliases_variableContext)_localctx).LINKAGE.getText():null);
				}
			}

			setState(247);
			_la = _input.LA(1);
			if (_la==VISIBILITY) {
				{
				setState(245); ((Aliases_variableContext)_localctx).VISIBILITY = match(VISIBILITY);
				visibility = (((Aliases_variableContext)_localctx).VISIBILITY!=null?((Aliases_variableContext)_localctx).VISIBILITY.getText():null);
				}
			}

			setState(249); ((Aliases_variableContext)_localctx).derived_type = derived_type();
			type = ((Aliases_variableContext)_localctx).derived_type.type;
			setState(251); ((Aliases_variableContext)_localctx).g2 = match(GLOBAL_VARIABLE);
			gVarName = (((Aliases_variableContext)_localctx).g2!=null?((Aliases_variableContext)_localctx).g2.getText():null); gVarName = gVarName.substring(1, gVarName.length());
			}

			((Aliases_variableContext)_localctx).globalAlias =  valueFactory.createGlobalAlias(name, linkage, visibility, type, gVarName);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_declarationContext extends ParserRuleContext {
		public FunctionDeclare functionDeclare;
		public Token LINKAGE;
		public Token VISIBILITY;
		public Token CCONV;
		public Token PARAMETER_ATTRIBUTES;
		public Return_typeContext return_type;
		public Token GLOBAL_VARIABLE;
		public Argument_listContext argument_list;
		public Token FUNCTION_ATTRIBUTES;
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode FUNCTION_ATTRIBUTES(int i) {
			return getToken(LLVMParser.FUNCTION_ATTRIBUTES, i);
		}
		public TerminalNode VISIBILITY() { return getToken(LLVMParser.VISIBILITY, 0); }
		public TerminalNode PARAMETER_ATTRIBUTES(int i) {
			return getToken(LLVMParser.PARAMETER_ATTRIBUTES, i);
		}
		public TerminalNode CCONV() { return getToken(LLVMParser.CCONV, 0); }
		public TerminalNode LINKAGE() { return getToken(LLVMParser.LINKAGE, 0); }
		public List<TerminalNode> PARAMETER_ATTRIBUTES() { return getTokens(LLVMParser.PARAMETER_ATTRIBUTES); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode UNNAMED_ADDR() { return getToken(LLVMParser.UNNAMED_ADDR, 0); }
		public TerminalNode GLOBAL_VARIABLE() { return getToken(LLVMParser.GLOBAL_VARIABLE, 0); }
		public List<TerminalNode> FUNCTION_ATTRIBUTES() { return getTokens(LLVMParser.FUNCTION_ATTRIBUTES); }
		public Function_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterFunction_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitFunction_declaration(this);
		}
	}

	public final Function_declarationContext function_declaration() throws RecognitionException {
		Function_declarationContext _localctx = new Function_declarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_declaration);

		String linkage = null;
		String visibility = null;
		String cconv = null;
		List<String> pAttributes = new ArrayList<String>();
		boolean isVararg = false;
		Type type;
		String name;
		List<Argument> argList = new ArrayList<Argument>();
		List<String> fAttributes = new ArrayList<String>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(56);
			setState(257);
			_la = _input.LA(1);
			if (_la==LINKAGE) {
				{
				setState(255); ((Function_declarationContext)_localctx).LINKAGE = match(LINKAGE);
				linkage = (((Function_declarationContext)_localctx).LINKAGE!=null?((Function_declarationContext)_localctx).LINKAGE.getText():null);
				}
			}

			setState(261);
			_la = _input.LA(1);
			if (_la==VISIBILITY) {
				{
				setState(259); ((Function_declarationContext)_localctx).VISIBILITY = match(VISIBILITY);
				visibility = (((Function_declarationContext)_localctx).VISIBILITY!=null?((Function_declarationContext)_localctx).VISIBILITY.getText():null);
				}
			}

			setState(265);
			_la = _input.LA(1);
			if (_la==CCONV) {
				{
				setState(263); ((Function_declarationContext)_localctx).CCONV = match(CCONV);
				cconv = (((Function_declarationContext)_localctx).CCONV!=null?((Function_declarationContext)_localctx).CCONV.getText():null);
				}
			}

			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PARAMETER_ATTRIBUTES) {
				{
				{
				setState(267); ((Function_declarationContext)_localctx).PARAMETER_ATTRIBUTES = match(PARAMETER_ATTRIBUTES);
				pAttributes.add((((Function_declarationContext)_localctx).PARAMETER_ATTRIBUTES!=null?((Function_declarationContext)_localctx).PARAMETER_ATTRIBUTES.getText():null));
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274); ((Function_declarationContext)_localctx).return_type = return_type();
			type = ((Function_declarationContext)_localctx).return_type.type;
			setState(276); ((Function_declarationContext)_localctx).GLOBAL_VARIABLE = match(GLOBAL_VARIABLE);
			name = (((Function_declarationContext)_localctx).GLOBAL_VARIABLE!=null?((Function_declarationContext)_localctx).GLOBAL_VARIABLE.getText():null); name = name.substring(1, name.length());
			setState(278); match(36);
			setState(279); ((Function_declarationContext)_localctx).argument_list = argument_list(argList);
			isVararg = ((Function_declarationContext)_localctx).argument_list.isVarargFunction;
			setState(281); match(14);
			setState(283);
			_la = _input.LA(1);
			if (_la==UNNAMED_ADDR) {
				{
				setState(282); match(UNNAMED_ADDR);
				}
			}

			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION_ATTRIBUTES) {
				{
				{
				setState(285); ((Function_declarationContext)_localctx).FUNCTION_ATTRIBUTES = match(FUNCTION_ATTRIBUTES);
				fAttributes.add((((Function_declarationContext)_localctx).FUNCTION_ATTRIBUTES!=null?((Function_declarationContext)_localctx).FUNCTION_ATTRIBUTES.getText():null));
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}

			((Function_declarationContext)_localctx).functionDeclare =  valueFactory.createFunctionDeclare(linkage, visibility, cconv, pAttributes, isVararg, type, name, argList, fAttributes);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_definitionContext extends ParserRuleContext {
		public Function function;
		public Token LINKAGE;
		public Token VISIBILITY;
		public Token CCONV;
		public Token PARAMETER_ATTRIBUTES;
		public Return_typeContext return_type;
		public Token GLOBAL_VARIABLE;
		public Argument_listContext argument_list;
		public Token FUNCTION_ATTRIBUTES;
		public Llvm_alignContext llvm_align;
		public Basic_blockContext basic_block;
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode FUNCTION_ATTRIBUTES(int i) {
			return getToken(LLVMParser.FUNCTION_ATTRIBUTES, i);
		}
		public TerminalNode VISIBILITY() { return getToken(LLVMParser.VISIBILITY, 0); }
		public TerminalNode CCONV() { return getToken(LLVMParser.CCONV, 0); }
		public Llvm_alignContext llvm_align() {
			return getRuleContext(Llvm_alignContext.class,0);
		}
		public Basic_blockContext basic_block(int i) {
			return getRuleContext(Basic_blockContext.class,i);
		}
		public List<Basic_blockContext> basic_block() {
			return getRuleContexts(Basic_blockContext.class);
		}
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode UNNAMED_ADDR(int i) {
			return getToken(LLVMParser.UNNAMED_ADDR, i);
		}
		public List<TerminalNode> UNNAMED_ADDR() { return getTokens(LLVMParser.UNNAMED_ADDR); }
		public TerminalNode PARAMETER_ATTRIBUTES(int i) {
			return getToken(LLVMParser.PARAMETER_ATTRIBUTES, i);
		}
		public TerminalNode LINKAGE() { return getToken(LLVMParser.LINKAGE, 0); }
		public List<TerminalNode> PARAMETER_ATTRIBUTES() { return getTokens(LLVMParser.PARAMETER_ATTRIBUTES); }
		public TerminalNode GLOBAL_VARIABLE() { return getToken(LLVMParser.GLOBAL_VARIABLE, 0); }
		public List<TerminalNode> FUNCTION_ATTRIBUTES() { return getTokens(LLVMParser.FUNCTION_ATTRIBUTES); }
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterFunction_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitFunction_definition(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_definition);

		String linkage = null;
		String visibility = null;
		String cconv = null;
		List<String> pAttributes=new ArrayList<String>();
		Type type;
		String name;
		List<Argument> argList=new ArrayList<Argument>();
		boolean isVararg = false;
		List<String> fAttributes=new ArrayList<String>();
		int align = -1;
		List<BasicBlock> basicBlocks = new ArrayList<BasicBlock>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292); match(46);
			setState(295);
			_la = _input.LA(1);
			if (_la==LINKAGE) {
				{
				setState(293); ((Function_definitionContext)_localctx).LINKAGE = match(LINKAGE);
				linkage = (((Function_definitionContext)_localctx).LINKAGE!=null?((Function_definitionContext)_localctx).LINKAGE.getText():null);
				}
			}

			setState(299);
			_la = _input.LA(1);
			if (_la==VISIBILITY) {
				{
				setState(297); ((Function_definitionContext)_localctx).VISIBILITY = match(VISIBILITY);
				visibility = (((Function_definitionContext)_localctx).VISIBILITY!=null?((Function_definitionContext)_localctx).VISIBILITY.getText():null);
				}
			}

			setState(303);
			_la = _input.LA(1);
			if (_la==CCONV) {
				{
				setState(301); ((Function_definitionContext)_localctx).CCONV = match(CCONV);
				cconv = (((Function_definitionContext)_localctx).CCONV!=null?((Function_definitionContext)_localctx).CCONV.getText():null);
				}
			}

			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PARAMETER_ATTRIBUTES) {
				{
				{
				setState(305); ((Function_definitionContext)_localctx).PARAMETER_ATTRIBUTES = match(PARAMETER_ATTRIBUTES);
				pAttributes.add((((Function_definitionContext)_localctx).PARAMETER_ATTRIBUTES!=null?((Function_definitionContext)_localctx).PARAMETER_ATTRIBUTES.getText():null));
				}
				}
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(312); ((Function_definitionContext)_localctx).return_type = return_type();
			type = ((Function_definitionContext)_localctx).return_type.type;
			setState(314); ((Function_definitionContext)_localctx).GLOBAL_VARIABLE = match(GLOBAL_VARIABLE);
			name = (((Function_definitionContext)_localctx).GLOBAL_VARIABLE!=null?((Function_definitionContext)_localctx).GLOBAL_VARIABLE.getText():null); name = name.substring(1, name.length());
			setState(316); match(36);
			setState(317); ((Function_definitionContext)_localctx).argument_list = argument_list(argList);
			isVararg = ((Function_definitionContext)_localctx).argument_list.isVarargFunction;
			setState(319); match(14);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION_ATTRIBUTES || _la==UNNAMED_ADDR) {
				{
				setState(323);
				switch (_input.LA(1)) {
				case UNNAMED_ADDR:
					{
					setState(320); match(UNNAMED_ADDR);
					}
					break;
				case FUNCTION_ATTRIBUTES:
					{
					setState(321); ((Function_definitionContext)_localctx).FUNCTION_ATTRIBUTES = match(FUNCTION_ATTRIBUTES);
					fAttributes.add((((Function_definitionContext)_localctx).FUNCTION_ATTRIBUTES!=null?((Function_definitionContext)_localctx).FUNCTION_ATTRIBUTES.getText():null));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(331);
			_la = _input.LA(1);
			if (_la==ALIGN) {
				{
				setState(328); ((Function_definitionContext)_localctx).llvm_align = llvm_align();
				align = ((Function_definitionContext)_localctx).llvm_align.align;
				}
			}

			setState(333); match(40);
			setState(337); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(334); ((Function_definitionContext)_localctx).basic_block = basic_block();
				basicBlocks.add(((Function_definitionContext)_localctx).basic_block.basicBlock);
				      
				}
				}
				setState(339); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 23) | (1L << 26) | (1L << 27) | (1L << 29) | (1L << 38) | (1L << 48) | (1L << 53) | (1L << 55) | (1L << BLOCK_ID) | (1L << LOCAL_VARIABLE) | (1L << GLOBAL_VARIABLE))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (VOLATILE - 72)) | (1L << (UNWIND - 72)) | (1L << (UNDEF - 72)))) != 0) );
			setState(341); match(9);
			}

			((Function_definitionContext)_localctx).function =  valueFactory.createFunction(linkage, visibility, cconv, pAttributes, type, name, argList, isVararg, fAttributes, align, basicBlocks);  

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Basic_blockContext extends ParserRuleContext {
		public BasicBlock basicBlock;
		public Token BLOCK_ID;
		public Phi_opContext phi_op;
		public OperatorContext operator;
		public TerminatorContext terminator;
		public Phi_opContext phi_op(int i) {
			return getRuleContext(Phi_opContext.class,i);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public List<Phi_opContext> phi_op() {
			return getRuleContexts(Phi_opContext.class);
		}
		public TerminatorContext terminator() {
			return getRuleContext(TerminatorContext.class,0);
		}
		public TerminalNode BLOCK_ID() { return getToken(LLVMParser.BLOCK_ID, 0); }
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public Basic_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterBasic_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitBasic_block(this);
		}
	}

	public final Basic_blockContext basic_block() throws RecognitionException {
		Basic_blockContext _localctx = new Basic_blockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_basic_block);

		String blockID = null;
		List<Instruction> instructions = new ArrayList<Instruction>();

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_la = _input.LA(1);
			if (_la==BLOCK_ID) {
				{
				setState(343); ((Basic_blockContext)_localctx).BLOCK_ID = match(BLOCK_ID);
				String bid = (((Basic_blockContext)_localctx).BLOCK_ID!=null?((Basic_blockContext)_localctx).BLOCK_ID.getText():null); bid = bid.trim(); bid = bid.substring(0, bid.length()-1); blockID = bid.trim();
				}
			}

			setState(352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(347); ((Basic_blockContext)_localctx).phi_op = phi_op();
					Instruction inst1=((Basic_blockContext)_localctx).phi_op.inst; inst1.setValue((((Basic_blockContext)_localctx).phi_op!=null?_input.getText(((Basic_blockContext)_localctx).phi_op.start,((Basic_blockContext)_localctx).phi_op.stop):null)); instructions.add(inst1);
					}
					} 
				}
				setState(354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(360);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(355); ((Basic_blockContext)_localctx).operator = operator();
					Instruction inst2=((Basic_blockContext)_localctx).operator.inst; inst2.setValue((((Basic_blockContext)_localctx).operator!=null?_input.getText(((Basic_blockContext)_localctx).operator.start,((Basic_blockContext)_localctx).operator.stop):null)); instructions.add(inst2);
					}
					} 
				}
				setState(362);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			setState(363); ((Basic_blockContext)_localctx).terminator = terminator();
			Instruction inst3=((Basic_blockContext)_localctx).terminator.inst; inst3.setValue((((Basic_blockContext)_localctx).terminator!=null?_input.getText(((Basic_blockContext)_localctx).terminator.start,((Basic_blockContext)_localctx).terminator.stop):null)); instructions.add(inst3);
			}

			((Basic_blockContext)_localctx).basicBlock =  valueFactory.createBasicBlock(blockID, instructions);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Llvm_alignContext extends ParserRuleContext {
		public int align;
		public Token INTEGER;
		public TerminalNode INTEGER() { return getToken(LLVMParser.INTEGER, 0); }
		public TerminalNode ALIGN() { return getToken(LLVMParser.ALIGN, 0); }
		public Llvm_alignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llvm_align; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterLlvm_align(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitLlvm_align(this);
		}
	}

	public final Llvm_alignContext llvm_align() throws RecognitionException {
		Llvm_alignContext _localctx = new Llvm_alignContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_llvm_align);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366); match(ALIGN);
			setState(367); ((Llvm_alignContext)_localctx).INTEGER = match(INTEGER);
			((Llvm_alignContext)_localctx).align =  Integer.parseInt((((Llvm_alignContext)_localctx).INTEGER!=null?((Llvm_alignContext)_localctx).INTEGER.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Llvm_sectionContext extends ParserRuleContext {
		public String section;
		public Token STRING;
		public TerminalNode SECTION() { return getToken(LLVMParser.SECTION, 0); }
		public TerminalNode STRING() { return getToken(LLVMParser.STRING, 0); }
		public Llvm_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llvm_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterLlvm_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitLlvm_section(this);
		}
	}

	public final Llvm_sectionContext llvm_section() throws RecognitionException {
		Llvm_sectionContext _localctx = new Llvm_sectionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_llvm_section);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370); match(SECTION);
			setState(371); ((Llvm_sectionContext)_localctx).STRING = match(STRING);
			((Llvm_sectionContext)_localctx).section =  (((Llvm_sectionContext)_localctx).STRING!=null?((Llvm_sectionContext)_localctx).STRING.getText():null);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminatorContext extends ParserRuleContext {
		public Instruction inst;
		public Token VOID;
		public Return_typeContext return_type;
		public ExpressionContext e1;
		public Token t;
		public Block_labelContext b0;
		public ExpressionContext e2;
		public Block_labelContext b1;
		public Block_labelContext b2;
		public Token it1;
		public ExpressionContext e3;
		public Block_labelContext b3;
		public Token it2;
		public Token INTEGER;
		public Block_labelContext b4;
		public Pointer_typeContext pointer_type;
		public ExpressionContext e4;
		public Block_labelContext b5;
		public Block_labelContext b6;
		public VariableContext variable;
		public Block_labelContext b7;
		public Block_labelContext b8;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(LLVMParser.INTEGER, 0); }
		public TerminalNode UNWIND() { return getToken(LLVMParser.UNWIND, 0); }
		public Dbg_metadataContext dbg_metadata() {
			return getRuleContext(Dbg_metadataContext.class,0);
		}
		public TerminalNode TO() { return getToken(LLVMParser.TO, 0); }
		public Block_labelContext block_label() {
			return getRuleContext(Block_labelContext.class,0);
		}
		public Pointer_typeContext pointer_type() {
			return getRuleContext(Pointer_typeContext.class,0);
		}
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode BOOLEAN_TYPE() { return getToken(LLVMParser.BOOLEAN_TYPE, 0); }
		public TerminalNode INTEGER_TYPE() { return getToken(LLVMParser.INTEGER_TYPE, 0); }
		public TerminalNode VOID() { return getToken(LLVMParser.VOID, 0); }
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterTerminator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitTerminator(this);
		}
	}

	public final TerminatorContext terminator() throws RecognitionException {
		TerminatorContext _localctx = new TerminatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_terminator);

		Constant dest = null;
		int opcode=0;
		List<Constant> operands = new ArrayList<Constant>();
		List<Type> types = new ArrayList<Type>();

		String cconv = null;
		List<String> pAttributes = new ArrayList<String>();
		List<String> fAttributes = new ArrayList<String>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			switch (_input.LA(1)) {
			case 38:
			case UNWIND:
				{
				setState(386);
				switch (_input.LA(1)) {
				case 38:
					{
					setState(374); match(38);
					opcode = InstType.retInst;
					setState(382);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(376); ((TerminatorContext)_localctx).VOID = match(VOID);
						operands.add(valueFactory.createConstantValue(SimpleConstantValue.voidConst, (((TerminatorContext)_localctx).VOID!=null?((TerminatorContext)_localctx).VOID.getText():null)));
						}
						break;

					case 2:
						{
						setState(378); ((TerminatorContext)_localctx).return_type = return_type();
						setState(379); ((TerminatorContext)_localctx).e1 = expression();
						types.add(((TerminatorContext)_localctx).return_type.type); operands.add(((TerminatorContext)_localctx).e1.expr);
						}
						break;
					}
					}
					break;
				case UNWIND:
					{
					setState(384); match(UNWIND);
					opcode = InstType.unwindInst;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 27:
			case 29:
			case 48:
			case 53:
			case 55:
			case LOCAL_VARIABLE:
			case GLOBAL_VARIABLE:
			case UNDEF:
				{
				setState(457);
				switch (_input.LA(1)) {
				case 55:
					{
					setState(388); ((TerminatorContext)_localctx).t = match(55);
					opcode = InstType.brInst;
					setState(401);
					switch (_input.LA(1)) {
					case LABEL:
						{
						setState(390); ((TerminatorContext)_localctx).b0 = block_label();
						operands.add(((TerminatorContext)_localctx).b0.expr);
						}
						break;
					case BOOLEAN_TYPE:
						{
						setState(393); match(BOOLEAN_TYPE);
						setState(394); ((TerminatorContext)_localctx).e2 = expression();
						setState(395); match(35);
						setState(396); ((TerminatorContext)_localctx).b1 = block_label();
						setState(397); match(35);
						setState(398); ((TerminatorContext)_localctx).b2 = block_label();
						types.add(typeFactory.getIntNType(1)); operands.add(((TerminatorContext)_localctx).e2.expr);
						             operands.add(((TerminatorContext)_localctx).b1.expr); operands.add(((TerminatorContext)_localctx).b2.expr);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case 53:
					{
					setState(403); ((TerminatorContext)_localctx).t = match(53);
					setState(404); ((TerminatorContext)_localctx).it1 = match(INTEGER_TYPE);
					setState(405); ((TerminatorContext)_localctx).e3 = expression();
					setState(406); match(35);
					setState(407); ((TerminatorContext)_localctx).b3 = block_label();
					opcode = InstType.switchInst; 
					       String n = (((TerminatorContext)_localctx).it1!=null?((TerminatorContext)_localctx).it1.getText():null); n = n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n))); 
					       operands.add(((TerminatorContext)_localctx).e3.expr); operands.add(((TerminatorContext)_localctx).b3.expr);
					setState(409); match(1);
					setState(418);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==INTEGER_TYPE) {
						{
						{
						setState(410); ((TerminatorContext)_localctx).it2 = match(INTEGER_TYPE);
						setState(411); ((TerminatorContext)_localctx).INTEGER = match(INTEGER);
						setState(412); match(35);
						setState(413); ((TerminatorContext)_localctx).b4 = block_label();
						n = (((TerminatorContext)_localctx).it2!=null?((TerminatorContext)_localctx).it2.getText():null); n = n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n)));
						             operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, (((TerminatorContext)_localctx).INTEGER!=null?((TerminatorContext)_localctx).INTEGER.getText():null)));
						             operands.add(((TerminatorContext)_localctx).b4.expr);
						}
						}
						setState(420);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(421); match(32);
					}
					break;
				case 48:
					{
					setState(423); ((TerminatorContext)_localctx).t = match(48);
					setState(424); ((TerminatorContext)_localctx).pointer_type = pointer_type();
					setState(425); ((TerminatorContext)_localctx).e4 = expression();
					setState(426); match(35);
					setState(427); match(1);
					setState(428); ((TerminatorContext)_localctx).b5 = block_label();
					opcode = InstType.indirectBrInst; types.add(((TerminatorContext)_localctx).pointer_type.type); operands.add(((TerminatorContext)_localctx).e4.expr); operands.add(((TerminatorContext)_localctx).b5.expr);
					setState(436);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==35) {
						{
						{
						setState(430); match(35);
						setState(431); ((TerminatorContext)_localctx).b6 = block_label();
						operands.add(((TerminatorContext)_localctx).b6.expr);
						}
						}
						setState(438);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(439); match(32);
					}
					break;
				case 27:
				case LOCAL_VARIABLE:
				case GLOBAL_VARIABLE:
				case UNDEF:
					{
					setState(445);
					_la = _input.LA(1);
					if (((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (LOCAL_VARIABLE - 61)) | (1L << (GLOBAL_VARIABLE - 61)) | (1L << (UNDEF - 61)))) != 0)) {
						{
						setState(441); ((TerminatorContext)_localctx).variable = variable();
						setState(442); match(18);
						dest = ((TerminatorContext)_localctx).variable.expr;
						}
					}

					setState(447); ((TerminatorContext)_localctx).t = match(27);
					setState(448); function_call(cconv, pAttributes, types, operands, fAttributes);
					setState(449); match(TO);
					setState(450); ((TerminatorContext)_localctx).b7 = block_label();
					setState(451); match(UNWIND);
					setState(452); ((TerminatorContext)_localctx).b8 = block_label();
					opcode = InstType.invokeInst; operands.add(((TerminatorContext)_localctx).b7.expr); operands.add(((TerminatorContext)_localctx).b8.expr);
					}
					break;
				case 29:
					{
					setState(455); ((TerminatorContext)_localctx).t = match(29);
					opcode = InstType.unreachableInst;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(462);
			_la = _input.LA(1);
			if (_la==35) {
				{
				setState(461); dbg_metadata();
				}
			}

			}

			if(opcode == InstType.invokeInst){
			  ((TerminatorContext)_localctx).inst =  instFactory.createCallInst(dest, opcode, operands, types, false, cconv, pAttributes, fAttributes);
			}else{
			  ((TerminatorContext)_localctx).inst =  instFactory.createSimpleInst(dest, opcode, operands, types);
			}

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_labelContext extends ParserRuleContext {
		public Constant expr;
		public Token LOCAL_VARIABLE;
		public TerminalNode LABEL() { return getToken(LLVMParser.LABEL, 0); }
		public TerminalNode LOCAL_VARIABLE() { return getToken(LLVMParser.LOCAL_VARIABLE, 0); }
		public Block_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterBlock_label(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitBlock_label(this);
		}
	}

	public final Block_labelContext block_label() throws RecognitionException {
		Block_labelContext _localctx = new Block_labelContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464); match(LABEL);
			setState(465); ((Block_labelContext)_localctx).LOCAL_VARIABLE = match(LOCAL_VARIABLE);
			((Block_labelContext)_localctx).expr =  valueFactory.createVariable((((Block_labelContext)_localctx).LOCAL_VARIABLE!=null?((Block_labelContext)_localctx).LOCAL_VARIABLE.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public Instruction inst;
		public Binary_opContext binary_op;
		public Vector_opContext vector_op;
		public Aggregate_opContext aggregate_op;
		public Memory_opContext memory_op;
		public Conversion_opContext conversion_op;
		public Icmp_opContext icmp_op;
		public Fcmp_opContext fcmp_op;
		public Select_opContext select_op;
		public Call_opContext call_op;
		public Fcmp_opContext fcmp_op() {
			return getRuleContext(Fcmp_opContext.class,0);
		}
		public Icmp_opContext icmp_op() {
			return getRuleContext(Icmp_opContext.class,0);
		}
		public Conversion_opContext conversion_op() {
			return getRuleContext(Conversion_opContext.class,0);
		}
		public Memory_opContext memory_op() {
			return getRuleContext(Memory_opContext.class,0);
		}
		public Vector_opContext vector_op() {
			return getRuleContext(Vector_opContext.class,0);
		}
		public Select_opContext select_op() {
			return getRuleContext(Select_opContext.class,0);
		}
		public Binary_opContext binary_op() {
			return getRuleContext(Binary_opContext.class,0);
		}
		public Dbg_metadataContext dbg_metadata() {
			return getRuleContext(Dbg_metadataContext.class,0);
		}
		public Aggregate_opContext aggregate_op() {
			return getRuleContext(Aggregate_opContext.class,0);
		}
		public Call_opContext call_op() {
			return getRuleContext(Call_opContext.class,0);
		}
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(468); ((OperatorContext)_localctx).binary_op = binary_op();
				 ((OperatorContext)_localctx).inst =  ((OperatorContext)_localctx).binary_op.inst; 
				}
				break;

			case 2:
				{
				setState(471); ((OperatorContext)_localctx).vector_op = vector_op();
				 ((OperatorContext)_localctx).inst =  ((OperatorContext)_localctx).vector_op.inst; 
				}
				break;

			case 3:
				{
				setState(474); ((OperatorContext)_localctx).aggregate_op = aggregate_op();
				 ((OperatorContext)_localctx).inst =  ((OperatorContext)_localctx).aggregate_op.inst; 
				}
				break;

			case 4:
				{
				setState(477); ((OperatorContext)_localctx).memory_op = memory_op();
				 ((OperatorContext)_localctx).inst =  ((OperatorContext)_localctx).memory_op.inst; 
				}
				break;

			case 5:
				{
				setState(480); ((OperatorContext)_localctx).conversion_op = conversion_op();
				 ((OperatorContext)_localctx).inst =  ((OperatorContext)_localctx).conversion_op.inst; 
				}
				break;

			case 6:
				{
				setState(483); ((OperatorContext)_localctx).icmp_op = icmp_op();
				 ((OperatorContext)_localctx).inst =  ((OperatorContext)_localctx).icmp_op.inst; 
				}
				break;

			case 7:
				{
				setState(486); ((OperatorContext)_localctx).fcmp_op = fcmp_op();
				 ((OperatorContext)_localctx).inst =  ((OperatorContext)_localctx).fcmp_op.inst; 
				}
				break;

			case 8:
				{
				setState(489); ((OperatorContext)_localctx).select_op = select_op();
				 ((OperatorContext)_localctx).inst =  ((OperatorContext)_localctx).select_op.inst; 
				}
				break;

			case 9:
				{
				setState(492); ((OperatorContext)_localctx).call_op = call_op();
				 ((OperatorContext)_localctx).inst =  ((OperatorContext)_localctx).call_op.inst; 
				}
				break;
			}
			setState(498);
			_la = _input.LA(1);
			if (_la==35) {
				{
				setState(497); dbg_metadata();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext variable;
		public Token BINARY_OP;
		public Element_typeContext element_type;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Vector_typeContext vector_type() {
			return getRuleContext(Vector_typeContext.class,0);
		}
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public TerminalNode BINARY_OP() { return getToken(LLVMParser.BINARY_OP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Binary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterBinary_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitBinary_op(this);
		}
	}

	public final Binary_opContext binary_op() throws RecognitionException {
		Binary_opContext _localctx = new Binary_opContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_binary_op);

		Constant dest;
		int opcode=InstType.binaryInst;
		String op;
		String nuw = null;
		String nsw = null;
		String exact = null;
		List<Constant> operands= new ArrayList<Constant>();
		List<Type> types = new ArrayList<Type>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500); ((Binary_opContext)_localctx).variable = variable();
			dest = ((Binary_opContext)_localctx).variable.expr;
			setState(502); match(18);
			setState(503); ((Binary_opContext)_localctx).BINARY_OP = match(BINARY_OP);
			op = (((Binary_opContext)_localctx).BINARY_OP!=null?((Binary_opContext)_localctx).BINARY_OP.getText():null);
			setState(507);
			_la = _input.LA(1);
			if (_la==43) {
				{
				setState(505); match(43);
				nuw = "nuw";
				}
			}

			setState(511);
			_la = _input.LA(1);
			if (_la==57) {
				{
				setState(509); match(57);
				nsw = "nsw";
				}
			}

			setState(515);
			_la = _input.LA(1);
			if (_la==33) {
				{
				setState(513); match(33);
				exact = "exact";
				}
			}

			setState(523);
			switch (_input.LA(1)) {
			case BOOLEAN_TYPE:
			case INTEGER_TYPE:
			case LOCAL_VARIABLE:
			case FLOATING_POINT_TYPE:
				{
				setState(517); ((Binary_opContext)_localctx).element_type = element_type();
				types.add(((Binary_opContext)_localctx).element_type.type);
				}
				break;
			case 3:
				{
				setState(520); vector_type();
				types.add(((Binary_opContext)_localctx).element_type.type);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(525); ((Binary_opContext)_localctx).e1 = expression();
			operands.add(((Binary_opContext)_localctx).e1.expr);
			setState(527); match(35);
			setState(528); ((Binary_opContext)_localctx).e2 = expression();
			operands.add(((Binary_opContext)_localctx).e2.expr);
			}

			((Binary_opContext)_localctx).inst =  instFactory.createBinaryInst(dest, opcode, operands, types, op, nuw, nsw, exact);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vector_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext v0;
		public Vector_typeContext vt1;
		public VariableContext v1;
		public Token it1;
		public ExpressionContext e1;
		public Vector_typeContext vt2;
		public VariableContext v2;
		public Element_typeContext et1;
		public ExpressionContext e2;
		public Token it2;
		public ExpressionContext e3;
		public Vector_typeContext vt3;
		public VariableContext v3;
		public Vector_typeContext vt4;
		public VariableContext v4;
		public Vector_typeContext vt5;
		public Token it3;
		public Token i1;
		public Token it4;
		public Token i2;
		public List<TerminalNode> INTEGER() { return getTokens(LLVMParser.INTEGER); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Vector_typeContext vector_type(int i) {
			return getRuleContext(Vector_typeContext.class,i);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> INTEGER_TYPE() { return getTokens(LLVMParser.INTEGER_TYPE); }
		public TerminalNode INTEGER(int i) {
			return getToken(LLVMParser.INTEGER, i);
		}
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public TerminalNode INTEGER_TYPE(int i) {
			return getToken(LLVMParser.INTEGER_TYPE, i);
		}
		public List<Vector_typeContext> vector_type() {
			return getRuleContexts(Vector_typeContext.class);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public Vector_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterVector_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitVector_op(this);
		}
	}

	public final Vector_opContext vector_op() throws RecognitionException {
		Vector_opContext _localctx = new Vector_opContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_vector_op);

		int opcode=0;
		Constant dest;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531); ((Vector_opContext)_localctx).v0 = variable();
			dest = ((Vector_opContext)_localctx).v0.expr;
			setState(533); match(18);
			setState(577);
			switch (_input.LA(1)) {
			case 37:
				{
				setState(534); match(37);
				setState(535); ((Vector_opContext)_localctx).vt1 = vector_type();
				setState(536); ((Vector_opContext)_localctx).v1 = variable();
				setState(537); match(35);
				setState(538); ((Vector_opContext)_localctx).it1 = match(INTEGER_TYPE);
				setState(539); ((Vector_opContext)_localctx).e1 = expression();
				opcode = InstType.extractEleInst; 
				        types.add(((Vector_opContext)_localctx).vt1.type); operands.add(((Vector_opContext)_localctx).v1.expr); 
				        String n = (((Vector_opContext)_localctx).it1!=null?((Vector_opContext)_localctx).it1.getText():null); n=n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n))); operands.add(((Vector_opContext)_localctx).e1.expr);
				}
				break;
			case 20:
				{
				setState(542); match(20);
				setState(543); ((Vector_opContext)_localctx).vt2 = vector_type();
				setState(544); ((Vector_opContext)_localctx).v2 = variable();
				setState(545); match(35);
				setState(546); ((Vector_opContext)_localctx).et1 = element_type();
				setState(547); ((Vector_opContext)_localctx).e2 = expression();
				setState(548); match(35);
				setState(549); ((Vector_opContext)_localctx).it2 = match(INTEGER_TYPE);
				setState(550); ((Vector_opContext)_localctx).e3 = expression();
				opcode = InstType.insertEleInst; 
				        types.add(((Vector_opContext)_localctx).vt2.type); operands.add(((Vector_opContext)_localctx).v2.expr); 
				        types.add(((Vector_opContext)_localctx).et1.type); operands.add(((Vector_opContext)_localctx).e2.expr);
				        String n = (((Vector_opContext)_localctx).it2!=null?((Vector_opContext)_localctx).it2.getText():null); n=n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n))); operands.add(((Vector_opContext)_localctx).e3.expr);
				}
				break;
			case 52:
				{
				setState(553); match(52);
				setState(554); ((Vector_opContext)_localctx).vt3 = vector_type();
				setState(555); ((Vector_opContext)_localctx).v3 = variable();
				setState(556); match(35);
				setState(557); ((Vector_opContext)_localctx).vt4 = vector_type();
				setState(558); ((Vector_opContext)_localctx).v4 = variable();
				setState(559); match(35);
				setState(560); ((Vector_opContext)_localctx).vt5 = vector_type();
				opcode = InstType.shuffleVecInst;
				        types.add(((Vector_opContext)_localctx).vt3.type); operands.add(((Vector_opContext)_localctx).v3.expr);
				        types.add(((Vector_opContext)_localctx).vt4.type); operands.add(((Vector_opContext)_localctx).v4.expr);
				        types.add(((Vector_opContext)_localctx).vt5.type);
				setState(562); match(3);
				setState(563); ((Vector_opContext)_localctx).it3 = match(INTEGER_TYPE);
				setState(564); ((Vector_opContext)_localctx).i1 = match(INTEGER);
				String n = (((Vector_opContext)_localctx).it3!=null?((Vector_opContext)_localctx).it3.getText():null); n=n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n)));
				        operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, (((Vector_opContext)_localctx).i1!=null?((Vector_opContext)_localctx).i1.getText():null)));
				setState(572);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==35) {
					{
					{
					setState(566); match(35);
					setState(567); ((Vector_opContext)_localctx).it4 = match(INTEGER_TYPE);
					setState(568); ((Vector_opContext)_localctx).i2 = match(INTEGER);
					String n2 = (((Vector_opContext)_localctx).it4!=null?((Vector_opContext)_localctx).it4.getText():null); n2=n2.substring(1,n2.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n2)));
					        operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, (((Vector_opContext)_localctx).i2!=null?((Vector_opContext)_localctx).i2.getText():null)));
					}
					}
					setState(574);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(575); match(49);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}

			((Vector_opContext)_localctx).inst =  instFactory.createSimpleInst(dest, opcode, operands, types);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aggregate_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext v0;
		public Aggregate_typeContext at1;
		public VariableContext v1;
		public IndexContext i1;
		public IndexContext i2;
		public Aggregate_typeContext at2;
		public VariableContext v2;
		public Derived_typeContext dt1;
		public ExpressionContext e1;
		public IndexContext i3;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Derived_typeContext derived_type() {
			return getRuleContext(Derived_typeContext.class,0);
		}
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public Aggregate_typeContext aggregate_type() {
			return getRuleContext(Aggregate_typeContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public Aggregate_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterAggregate_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitAggregate_op(this);
		}
	}

	public final Aggregate_opContext aggregate_op() throws RecognitionException {
		Aggregate_opContext _localctx = new Aggregate_opContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_aggregate_op);

		int opcode=0;
		Constant dest;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();

		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(579); ((Aggregate_opContext)_localctx).v0 = variable();
			dest = ((Aggregate_opContext)_localctx).v0.expr;
			setState(581); match(18);
			setState(607);
			switch (_input.LA(1)) {
			case 17:
				{
				setState(582); match(17);
				setState(583); ((Aggregate_opContext)_localctx).at1 = aggregate_type();
				setState(584); ((Aggregate_opContext)_localctx).v1 = variable();
				setState(585); match(35);
				setState(586); ((Aggregate_opContext)_localctx).i1 = index();
				opcode = InstType.extractValInst; types.add(((Aggregate_opContext)_localctx).at1.type); operands.add(((Aggregate_opContext)_localctx).v1.expr); operands.add(((Aggregate_opContext)_localctx).i1.expr);
				setState(594);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(588); match(35);
						setState(589); ((Aggregate_opContext)_localctx).i2 = index();
						operands.add(((Aggregate_opContext)_localctx).i2.expr);
						}
						} 
					}
					setState(596);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
				}
				}
				break;
			case 42:
				{
				setState(597); match(42);
				setState(598); ((Aggregate_opContext)_localctx).at2 = aggregate_type();
				setState(599); ((Aggregate_opContext)_localctx).v2 = variable();
				setState(600); match(35);
				setState(601); ((Aggregate_opContext)_localctx).dt1 = derived_type();
				setState(602); ((Aggregate_opContext)_localctx).e1 = expression();
				setState(603); match(35);
				setState(604); ((Aggregate_opContext)_localctx).i3 = index();
				opcode = InstType.insertValInst; types.add(((Aggregate_opContext)_localctx).at2.type); operands.add(((Aggregate_opContext)_localctx).v2.expr); types.add(((Aggregate_opContext)_localctx).dt1.type); operands.add(((Aggregate_opContext)_localctx).e1.expr); operands.add(((Aggregate_opContext)_localctx).i3.expr);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}

			((Aggregate_opContext)_localctx).inst =  instFactory.createSimpleInst(dest, opcode, operands, types);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Memory_opContext extends ParserRuleContext {
		public Instruction inst;
		public Getelementptr_opContext getelementptr_op;
		public Alloca_opContext alloca_op;
		public Load_opContext load_op;
		public Store_opContext store_op;
		public Getelementptr_opContext getelementptr_op() {
			return getRuleContext(Getelementptr_opContext.class,0);
		}
		public Store_opContext store_op() {
			return getRuleContext(Store_opContext.class,0);
		}
		public Alloca_opContext alloca_op() {
			return getRuleContext(Alloca_opContext.class,0);
		}
		public Load_opContext load_op() {
			return getRuleContext(Load_opContext.class,0);
		}
		public Memory_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memory_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterMemory_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitMemory_op(this);
		}
	}

	public final Memory_opContext memory_op() throws RecognitionException {
		Memory_opContext _localctx = new Memory_opContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_memory_op);
		try {
			setState(621);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(609); ((Memory_opContext)_localctx).getelementptr_op = getelementptr_op();
				((Memory_opContext)_localctx).inst =  ((Memory_opContext)_localctx).getelementptr_op.inst;
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(612); ((Memory_opContext)_localctx).alloca_op = alloca_op();
				((Memory_opContext)_localctx).inst =  ((Memory_opContext)_localctx).alloca_op.inst;
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(615); ((Memory_opContext)_localctx).load_op = load_op();
				((Memory_opContext)_localctx).inst =  ((Memory_opContext)_localctx).load_op.inst;
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(618); ((Memory_opContext)_localctx).store_op = store_op();
				((Memory_opContext)_localctx).inst =  ((Memory_opContext)_localctx).store_op.inst;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alloca_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext variable;
		public Derived_typeContext t1;
		public Derived_typeContext t2;
		public IndexContext index;
		public Llvm_alignContext llvm_align;
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public List<Derived_typeContext> derived_type() {
			return getRuleContexts(Derived_typeContext.class);
		}
		public Derived_typeContext derived_type(int i) {
			return getRuleContext(Derived_typeContext.class,i);
		}
		public Llvm_alignContext llvm_align() {
			return getRuleContext(Llvm_alignContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Alloca_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alloca_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterAlloca_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitAlloca_op(this);
		}
	}

	public final Alloca_opContext alloca_op() throws RecognitionException {
		Alloca_opContext _localctx = new Alloca_opContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_alloca_op);

		Constant dest;
		int opcode=0;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623); ((Alloca_opContext)_localctx).variable = variable();
			setState(624); match(18);
			setState(625); match(10);
			setState(626); ((Alloca_opContext)_localctx).t1 = derived_type();
			dest = ((Alloca_opContext)_localctx).variable.expr; opcode = InstType.allocaInst; types.add(((Alloca_opContext)_localctx).t1.type);
			setState(633);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(628); match(35);
				setState(629); ((Alloca_opContext)_localctx).t2 = derived_type();
				setState(630); ((Alloca_opContext)_localctx).index = index();
				types.add(((Alloca_opContext)_localctx).t2.type); operands.add(((Alloca_opContext)_localctx).index.expr);
				}
				break;
			}
			setState(639);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(635); match(35);
				setState(636); ((Alloca_opContext)_localctx).llvm_align = llvm_align();
				operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, ((Alloca_opContext)_localctx).llvm_align.align + ""));
				}
				break;
			}
			}

			((Alloca_opContext)_localctx).inst =  instFactory.createSimpleInst(dest, opcode, operands, types);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Load_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext variable;
		public Pointer_typeContext pointer_type;
		public ExpressionContext expression;
		public Llvm_alignContext llvm_align;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Llvm_alignContext llvm_align() {
			return getRuleContext(Llvm_alignContext.class,0);
		}
		public TerminalNode VOLATILE() { return getToken(LLVMParser.VOLATILE, 0); }
		public Pointer_typeContext pointer_type() {
			return getRuleContext(Pointer_typeContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Load_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_load_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterLoad_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitLoad_op(this);
		}
	}

	public final Load_opContext load_op() throws RecognitionException {
		Load_opContext _localctx = new Load_opContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_load_op);

		Constant dest;
		int opcode;
		boolean isVolatile = false;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641); ((Load_opContext)_localctx).variable = variable();
			setState(642); match(18);
			dest = ((Load_opContext)_localctx).variable.expr; opcode = InstType.loadInst;
			setState(646);
			_la = _input.LA(1);
			if (_la==VOLATILE) {
				{
				setState(644); match(VOLATILE);
				isVolatile = true;
				}
			}

			setState(648); match(25);
			setState(649); ((Load_opContext)_localctx).pointer_type = pointer_type();
			setState(650); ((Load_opContext)_localctx).expression = expression();
			types.add(((Load_opContext)_localctx).pointer_type.type); operands.add(((Load_opContext)_localctx).expression.expr);
			setState(656);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(652); match(35);
				setState(653); ((Load_opContext)_localctx).llvm_align = llvm_align();
				operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, ((Load_opContext)_localctx).llvm_align.align + ""));
				}
				break;
			}
			}

			((Load_opContext)_localctx).inst =  instFactory.createLoadStoreInst(dest, opcode, operands, types, isVolatile);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Store_opContext extends ParserRuleContext {
		public Instruction inst;
		public First_class_typeContext t1;
		public ExpressionContext e1;
		public Pointer_typeContext t2;
		public ExpressionContext e2;
		public Llvm_alignContext llvm_align;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public First_class_typeContext first_class_type() {
			return getRuleContext(First_class_typeContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Llvm_alignContext llvm_align() {
			return getRuleContext(Llvm_alignContext.class,0);
		}
		public TerminalNode VOLATILE() { return getToken(LLVMParser.VOLATILE, 0); }
		public Pointer_typeContext pointer_type() {
			return getRuleContext(Pointer_typeContext.class,0);
		}
		public Store_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_store_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterStore_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitStore_op(this);
		}
	}

	public final Store_opContext store_op() throws RecognitionException {
		Store_opContext _localctx = new Store_opContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_store_op);

		Constant dest = null;
		int opcode;
		boolean isVolatile = false;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			_la = _input.LA(1);
			if (_la==VOLATILE) {
				{
				setState(658); match(VOLATILE);
				isVolatile=true;
				}
			}

			setState(662); match(26);
			opcode = InstType.storeInst;
			setState(664); ((Store_opContext)_localctx).t1 = first_class_type();
			setState(665); ((Store_opContext)_localctx).e1 = expression();
			types.add(((Store_opContext)_localctx).t1.type); operands.add(((Store_opContext)_localctx).e1.expr);
			setState(667); match(35);
			setState(668); ((Store_opContext)_localctx).t2 = pointer_type();
			setState(669); ((Store_opContext)_localctx).e2 = expression();
			types.add(((Store_opContext)_localctx).t2.type); operands.add(((Store_opContext)_localctx).e2.expr);
			setState(675);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(671); match(35);
				setState(672); ((Store_opContext)_localctx).llvm_align = llvm_align();
				operands.add(valueFactory.createConstantValue(SimpleConstantValue.intConst, ((Store_opContext)_localctx).llvm_align.align + ""));
				}
				break;
			}
			}

			((Store_opContext)_localctx).inst =  instFactory.createLoadStoreInst(dest, opcode, operands, types, isVolatile);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Getelementptr_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext variable;
		public Pointer_typeContext pointer_type;
		public ExpressionContext expression;
		public Token INTEGER_TYPE;
		public IndexContext index;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<IndexContext> index() {
			return getRuleContexts(IndexContext.class);
		}
		public List<TerminalNode> INTEGER_TYPE() { return getTokens(LLVMParser.INTEGER_TYPE); }
		public IndexContext index(int i) {
			return getRuleContext(IndexContext.class,i);
		}
		public Pointer_typeContext pointer_type() {
			return getRuleContext(Pointer_typeContext.class,0);
		}
		public TerminalNode INTEGER_TYPE(int i) {
			return getToken(LLVMParser.INTEGER_TYPE, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Getelementptr_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getelementptr_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterGetelementptr_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitGetelementptr_op(this);
		}
	}

	public final Getelementptr_opContext getelementptr_op() throws RecognitionException {
		Getelementptr_opContext _localctx = new Getelementptr_opContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_getelementptr_op);

		Constant dest;
		int opcode = InstType.getElePtrInst;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();
		boolean inbounds = false;

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(677); ((Getelementptr_opContext)_localctx).variable = variable();
			setState(678); match(18);
			setState(679); match(31);
			dest = ((Getelementptr_opContext)_localctx).variable.expr;
			setState(683);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(681); match(4);
				inbounds = true;
				}
			}

			setState(685); ((Getelementptr_opContext)_localctx).pointer_type = pointer_type();
			setState(686); ((Getelementptr_opContext)_localctx).expression = expression();
			types.add(((Getelementptr_opContext)_localctx).pointer_type.type); operands.add(((Getelementptr_opContext)_localctx).expression.expr);
			setState(693); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(688); match(35);
					setState(689); ((Getelementptr_opContext)_localctx).INTEGER_TYPE = match(INTEGER_TYPE);
					setState(690); ((Getelementptr_opContext)_localctx).index = index();
					String n = (((Getelementptr_opContext)_localctx).INTEGER_TYPE!=null?((Getelementptr_opContext)_localctx).INTEGER_TYPE.getText():null); n = n.substring(1,n.length()); types.add(typeFactory.getIntNType(Integer.parseInt(n)));
					    operands.add(((Getelementptr_opContext)_localctx).index.expr);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(695); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}

			((Getelementptr_opContext)_localctx).inst =  instFactory.createGetElePtrInst(dest, opcode, operands, types, inbounds);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conversion_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext variable;
		public Token CONVERSION_OP;
		public Scalar_typeContext t1;
		public ExpressionContext expression;
		public Scalar_typeContext t2;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<Scalar_typeContext> scalar_type() {
			return getRuleContexts(Scalar_typeContext.class);
		}
		public TerminalNode TO() { return getToken(LLVMParser.TO, 0); }
		public TerminalNode CONVERSION_OP() { return getToken(LLVMParser.CONVERSION_OP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Scalar_typeContext scalar_type(int i) {
			return getRuleContext(Scalar_typeContext.class,i);
		}
		public Conversion_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversion_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterConversion_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitConversion_op(this);
		}
	}

	public final Conversion_opContext conversion_op() throws RecognitionException {
		Conversion_opContext _localctx = new Conversion_opContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_conversion_op);

		Constant dest;
		String converOp;
		int opcode = InstType.converInst;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697); ((Conversion_opContext)_localctx).variable = variable();
			setState(698); match(18);
			setState(699); ((Conversion_opContext)_localctx).CONVERSION_OP = match(CONVERSION_OP);
			setState(700); ((Conversion_opContext)_localctx).t1 = scalar_type();
			setState(701); ((Conversion_opContext)_localctx).expression = expression();
			setState(702); match(TO);
			setState(703); ((Conversion_opContext)_localctx).t2 = scalar_type();
			dest = ((Conversion_opContext)_localctx).variable.expr; converOp=(((Conversion_opContext)_localctx).CONVERSION_OP!=null?((Conversion_opContext)_localctx).CONVERSION_OP.getText():null); types.add(((Conversion_opContext)_localctx).t1.type); types.add(((Conversion_opContext)_localctx).t2.type); operands.add(((Conversion_opContext)_localctx).expression.expr);
			}

			((Conversion_opContext)_localctx).inst =  instFactory.createOperationInst(dest, opcode, operands, types, converOp);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Icmp_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext variable;
		public Token ICMP_COND;
		public Token CMP_COND;
		public Scalar_typeContext scalar_type;
		public Vector_typeContext vector_type;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public Scalar_typeContext scalar_type() {
			return getRuleContext(Scalar_typeContext.class,0);
		}
		public TerminalNode CMP_COND() { return getToken(LLVMParser.CMP_COND, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ICMP_COND() { return getToken(LLVMParser.ICMP_COND, 0); }
		public Vector_typeContext vector_type() {
			return getRuleContext(Vector_typeContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Icmp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_icmp_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterIcmp_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitIcmp_op(this);
		}
	}

	public final Icmp_opContext icmp_op() throws RecognitionException {
		Icmp_opContext _localctx = new Icmp_opContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_icmp_op);

		Constant dest;
		int opcode = InstType.icmpInst;
		String cond=null;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706); ((Icmp_opContext)_localctx).variable = variable();
			setState(707); match(18);
			setState(708); match(54);
			dest = ((Icmp_opContext)_localctx).variable.expr;
			setState(714);
			switch (_input.LA(1)) {
			case ICMP_COND:
				{
				setState(710); ((Icmp_opContext)_localctx).ICMP_COND = match(ICMP_COND);
				cond = (((Icmp_opContext)_localctx).ICMP_COND!=null?((Icmp_opContext)_localctx).ICMP_COND.getText():null);
				}
				break;
			case CMP_COND:
				{
				setState(712); ((Icmp_opContext)_localctx).CMP_COND = match(CMP_COND);
				cond = (((Icmp_opContext)_localctx).CMP_COND!=null?((Icmp_opContext)_localctx).CMP_COND.getText():null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(722);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(716); ((Icmp_opContext)_localctx).scalar_type = scalar_type();
				types.add(((Icmp_opContext)_localctx).scalar_type.type);
				}
				break;

			case 2:
				{
				setState(719); ((Icmp_opContext)_localctx).vector_type = vector_type();
				types.add(((Icmp_opContext)_localctx).vector_type.type);
				}
				break;
			}
			setState(724); ((Icmp_opContext)_localctx).e1 = expression();
			setState(725); match(35);
			setState(726); ((Icmp_opContext)_localctx).e2 = expression();
			operands.add(((Icmp_opContext)_localctx).e1.expr); operands.add(((Icmp_opContext)_localctx).e2.expr);
			}

			((Icmp_opContext)_localctx).inst =  instFactory.createCmpInst(dest, opcode, operands, types, cond);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fcmp_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext variable;
		public Token FCMP_COND;
		public Token CMP_COND;
		public Token BOOLEAN;
		public Scalar_typeContext scalar_type;
		public Vector_typeContext vector_type;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public Scalar_typeContext scalar_type() {
			return getRuleContext(Scalar_typeContext.class,0);
		}
		public TerminalNode CMP_COND() { return getToken(LLVMParser.CMP_COND, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BOOLEAN() { return getToken(LLVMParser.BOOLEAN, 0); }
		public TerminalNode FCMP_COND() { return getToken(LLVMParser.FCMP_COND, 0); }
		public Vector_typeContext vector_type() {
			return getRuleContext(Vector_typeContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Fcmp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fcmp_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterFcmp_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitFcmp_op(this);
		}
	}

	public final Fcmp_opContext fcmp_op() throws RecognitionException {
		Fcmp_opContext _localctx = new Fcmp_opContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_fcmp_op);

		Constant dest;
		int opcode = InstType.fcmpInst;
		String cond=null;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729); ((Fcmp_opContext)_localctx).variable = variable();
			setState(730); match(18);
			setState(731); match(45);
			dest = ((Fcmp_opContext)_localctx).variable.expr;
			setState(739);
			switch (_input.LA(1)) {
			case FCMP_COND:
				{
				setState(733); ((Fcmp_opContext)_localctx).FCMP_COND = match(FCMP_COND);
				cond = (((Fcmp_opContext)_localctx).FCMP_COND!=null?((Fcmp_opContext)_localctx).FCMP_COND.getText():null);
				}
				break;
			case CMP_COND:
				{
				setState(735); ((Fcmp_opContext)_localctx).CMP_COND = match(CMP_COND);
				cond = (((Fcmp_opContext)_localctx).CMP_COND!=null?((Fcmp_opContext)_localctx).CMP_COND.getText():null);
				}
				break;
			case BOOLEAN:
				{
				setState(737); ((Fcmp_opContext)_localctx).BOOLEAN = match(BOOLEAN);
				cond = (((Fcmp_opContext)_localctx).BOOLEAN!=null?((Fcmp_opContext)_localctx).BOOLEAN.getText():null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(747);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(741); ((Fcmp_opContext)_localctx).scalar_type = scalar_type();
				types.add(((Fcmp_opContext)_localctx).scalar_type.type);
				}
				break;

			case 2:
				{
				setState(744); ((Fcmp_opContext)_localctx).vector_type = vector_type();
				types.add(((Fcmp_opContext)_localctx).vector_type.type);
				}
				break;
			}
			setState(749); ((Fcmp_opContext)_localctx).e1 = expression();
			setState(750); match(35);
			setState(751); ((Fcmp_opContext)_localctx).e2 = expression();
			operands.add(((Fcmp_opContext)_localctx).e1.expr); operands.add(((Fcmp_opContext)_localctx).e2.expr);
			}

			((Fcmp_opContext)_localctx).inst =  instFactory.createCmpInst(dest, opcode, operands, types, cond);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Phi_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext variable;
		public First_class_typeContext first_class_type;
		public ExpressionContext e1;
		public Token lv1;
		public ExpressionContext e2;
		public Token lv2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public First_class_typeContext first_class_type() {
			return getRuleContext(First_class_typeContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Dbg_metadataContext dbg_metadata() {
			return getRuleContext(Dbg_metadataContext.class,0);
		}
		public List<TerminalNode> LOCAL_VARIABLE() { return getTokens(LLVMParser.LOCAL_VARIABLE); }
		public TerminalNode LOCAL_VARIABLE(int i) {
			return getToken(LLVMParser.LOCAL_VARIABLE, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Phi_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phi_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterPhi_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitPhi_op(this);
		}
	}

	public final Phi_opContext phi_op() throws RecognitionException {
		Phi_opContext _localctx = new Phi_opContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_phi_op);

		Constant dest;
		int opcode = InstType.phiInst;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(754); ((Phi_opContext)_localctx).variable = variable();
			dest = ((Phi_opContext)_localctx).variable.expr;
			setState(756); match(18);
			setState(757); match(11);
			setState(758); ((Phi_opContext)_localctx).first_class_type = first_class_type();
			types.add(((Phi_opContext)_localctx).first_class_type.type);
			setState(760); match(1);
			setState(761); ((Phi_opContext)_localctx).e1 = expression();
			operands.add(((Phi_opContext)_localctx).e1.expr);
			setState(763); match(35);
			setState(764); ((Phi_opContext)_localctx).lv1 = match(LOCAL_VARIABLE);
			operands.add(valueFactory.createVariable((((Phi_opContext)_localctx).lv1!=null?((Phi_opContext)_localctx).lv1.getText():null)));
			setState(766); match(32);
			setState(777);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(767); match(35);
					setState(768); match(1);
					setState(769); ((Phi_opContext)_localctx).e2 = expression();
					setState(770); match(35);
					setState(771); ((Phi_opContext)_localctx).lv2 = match(LOCAL_VARIABLE);
					operands.add(((Phi_opContext)_localctx).e2.expr); operands.add(valueFactory.createVariable((((Phi_opContext)_localctx).lv2!=null?((Phi_opContext)_localctx).lv2.getText():null)));
					setState(773); match(32);
					}
					} 
				}
				setState(779);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			setState(781);
			_la = _input.LA(1);
			if (_la==35) {
				{
				setState(780); dbg_metadata();
				}
			}

			}

			((Phi_opContext)_localctx).inst =  instFactory.createSimpleInst(dest, opcode, operands, types);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext variable;
		public ExpressionContext e1;
		public First_class_typeContext fc1;
		public ExpressionContext e2;
		public First_class_typeContext fc2;
		public ExpressionContext e3;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public List<First_class_typeContext> first_class_type() {
			return getRuleContexts(First_class_typeContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BOOLEAN_TYPE() { return getToken(LLVMParser.BOOLEAN_TYPE, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public First_class_typeContext first_class_type(int i) {
			return getRuleContext(First_class_typeContext.class,i);
		}
		public Select_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterSelect_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitSelect_op(this);
		}
	}

	public final Select_opContext select_op() throws RecognitionException {
		Select_opContext _localctx = new Select_opContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_select_op);

		Constant dest;
		int opcode = InstType.selectInst;
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783); ((Select_opContext)_localctx).variable = variable();
			setState(784); match(18);
			setState(785); match(34);
			setState(786); match(BOOLEAN_TYPE);
			setState(787); ((Select_opContext)_localctx).e1 = expression();
			setState(788); match(35);
			setState(789); ((Select_opContext)_localctx).fc1 = first_class_type();
			setState(790); ((Select_opContext)_localctx).e2 = expression();
			setState(791); match(35);
			setState(792); ((Select_opContext)_localctx).fc2 = first_class_type();
			setState(793); ((Select_opContext)_localctx).e3 = expression();
			dest = ((Select_opContext)_localctx).variable.expr; 
			    types.add(typeFactory.getIntNType(1));
			    operands.add(((Select_opContext)_localctx).e1.expr);
			    types.add(((Select_opContext)_localctx).fc1.type); operands.add(((Select_opContext)_localctx).e2.expr);
			    types.add(((Select_opContext)_localctx).fc2.type); operands.add(((Select_opContext)_localctx).e3.expr);
			}

			((Select_opContext)_localctx).inst =  instFactory.createSimpleInst(dest, opcode, operands, types);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_opContext extends ParserRuleContext {
		public Instruction inst;
		public VariableContext variable;
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Call_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterCall_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitCall_op(this);
		}
	}

	public final Call_opContext call_op() throws RecognitionException {
		Call_opContext _localctx = new Call_opContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_call_op);

		Constant dest = null;
		boolean tail = false;
		int opcode = InstType.callInst;
		String cconv = null;
		List<String> pAttributes = new ArrayList<String>();
		List<Type> types = new ArrayList<Type>();
		List<Constant> operands = new ArrayList<Constant>();
		List<String> fAttributes = new ArrayList<String>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
			_la = _input.LA(1);
			if (((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (LOCAL_VARIABLE - 61)) | (1L << (GLOBAL_VARIABLE - 61)) | (1L << (UNDEF - 61)))) != 0)) {
				{
				setState(796); ((Call_opContext)_localctx).variable = variable();
				setState(797); match(18);
				dest = ((Call_opContext)_localctx).variable.expr;
				}
			}

			setState(804);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(802); match(7);
				tail = true;
				}
			}

			setState(806); match(23);
			setState(807); function_call(cconv, pAttributes, types, operands, fAttributes);
			}

			((Call_opContext)_localctx).inst =  instFactory.createCallInst(dest, opcode, operands, types, false, cconv, pAttributes, fAttributes);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_callContext extends ParserRuleContext {
		public String cconv;
		public List<String> pAttributes;
		public List<Type> types;
		public List<Constant> operands;
		public List<String> fAttributes;
		public boolean isVarargFunction;
		public Token CCONV;
		public Token PARAMETER_ATTRIBUTES;
		public Return_typeContext return_type;
		public Function_nameContext function_name;
		public Argument_listContext argument_list;
		public Token FUNCTION_ATTRIBUTES;
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode FUNCTION_ATTRIBUTES(int i) {
			return getToken(LLVMParser.FUNCTION_ATTRIBUTES, i);
		}
		public TerminalNode PARAMETER_ATTRIBUTES(int i) {
			return getToken(LLVMParser.PARAMETER_ATTRIBUTES, i);
		}
		public TerminalNode CCONV() { return getToken(LLVMParser.CCONV, 0); }
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public List<TerminalNode> PARAMETER_ATTRIBUTES() { return getTokens(LLVMParser.PARAMETER_ATTRIBUTES); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public List<TerminalNode> FUNCTION_ATTRIBUTES() { return getTokens(LLVMParser.FUNCTION_ATTRIBUTES); }
		public Function_callContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Function_callContext(ParserRuleContext parent, int invokingState, String cconv, List<String> pAttributes, List<Type> types, List<Constant> operands, List<String> fAttributes) {
			super(parent, invokingState);
			this.cconv = cconv;
			this.pAttributes = pAttributes;
			this.types = types;
			this.operands = operands;
			this.fAttributes = fAttributes;
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitFunction_call(this);
		}
	}

	public final Function_callContext function_call(String cconv,List<String> pAttributes,List<Type> types,List<Constant> operands,List<String> fAttributes) throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState(), cconv, pAttributes, types, operands, fAttributes);
		enterRule(_localctx, 56, RULE_function_call);

		List<Argument> arguments = new ArrayList<Argument>();
		boolean isVararg = false;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(811);
			_la = _input.LA(1);
			if (_la==CCONV) {
				{
				setState(809); ((Function_callContext)_localctx).CCONV = match(CCONV);
				cconv = (((Function_callContext)_localctx).CCONV!=null?((Function_callContext)_localctx).CCONV.getText():null);
				}
			}

			setState(817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PARAMETER_ATTRIBUTES) {
				{
				{
				setState(813); ((Function_callContext)_localctx).PARAMETER_ATTRIBUTES = match(PARAMETER_ATTRIBUTES);
				pAttributes.add((((Function_callContext)_localctx).PARAMETER_ATTRIBUTES!=null?((Function_callContext)_localctx).PARAMETER_ATTRIBUTES.getText():null));
				}
				}
				setState(819);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(820); ((Function_callContext)_localctx).return_type = return_type();
			setState(821); ((Function_callContext)_localctx).function_name = function_name();
			types.add(((Function_callContext)_localctx).return_type.type); operands.add(((Function_callContext)_localctx).function_name.expr);
			setState(823); match(36);
			setState(824); ((Function_callContext)_localctx).argument_list = argument_list(arguments);
			setState(825); match(14);
			((Function_callContext)_localctx).isVarargFunction =  ((Function_callContext)_localctx).argument_list.isVarargFunction;
			setState(831);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION_ATTRIBUTES) {
				{
				{
				setState(827); ((Function_callContext)_localctx).FUNCTION_ATTRIBUTES = match(FUNCTION_ATTRIBUTES);
				fAttributes.add((((Function_callContext)_localctx).FUNCTION_ATTRIBUTES!=null?((Function_callContext)_localctx).FUNCTION_ATTRIBUTES.getText():null));
				}
				}
				setState(833);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}

			for(Argument arg:arguments){
			  types.add(arg.getType());
			  operands.add(arg.getExpr());
			}

			((Function_callContext)_localctx).isVarargFunction =  isVararg;

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Argument_listContext extends ParserRuleContext {
		public List<Argument> alist;
		public boolean isVarargFunction;
		public First_class_typeContext fct1;
		public Token pa1;
		public Llvm_alignContext a1;
		public ExpressionContext e1;
		public First_class_typeContext fct2;
		public Token pa2;
		public Llvm_alignContext a2;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public List<First_class_typeContext> first_class_type() {
			return getRuleContexts(First_class_typeContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Llvm_alignContext llvm_align(int i) {
			return getRuleContext(Llvm_alignContext.class,i);
		}
		public TerminalNode PARAMETER_ATTRIBUTES(int i) {
			return getToken(LLVMParser.PARAMETER_ATTRIBUTES, i);
		}
		public List<Llvm_alignContext> llvm_align() {
			return getRuleContexts(Llvm_alignContext.class);
		}
		public List<TerminalNode> PARAMETER_ATTRIBUTES() { return getTokens(LLVMParser.PARAMETER_ATTRIBUTES); }
		public First_class_typeContext first_class_type(int i) {
			return getRuleContext(First_class_typeContext.class,i);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Argument_listContext(ParserRuleContext parent, int invokingState, List<Argument> alist) {
			super(parent, invokingState);
			this.alist = alist;
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterArgument_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitArgument_list(this);
		}
	}

	public final Argument_listContext argument_list(List<Argument> alist) throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState(), alist);
		enterRule(_localctx, 58, RULE_argument_list);

		Type type;
		List<String> pAttributes = new ArrayList<String>(); 
		int align = -1;
		Constant expr = null;
		boolean isVararg = false;

		int _la;
		try {
			int _alt;
			setState(890);
			switch (_input.LA(1)) {
			case 39:
				enterOuterAlt(_localctx, 1);
				{
				setState(834); match(39);
				isVararg = true;
				}
				break;
			case EOF:
			case 1:
			case 3:
			case 7:
			case 9:
			case 13:
			case 14:
			case 23:
			case 26:
			case 27:
			case 28:
			case 29:
			case 35:
			case 38:
			case 40:
			case 46:
			case 48:
			case 53:
			case 55:
			case 56:
			case BLOCK_ID:
			case BOOLEAN_TYPE:
			case INTEGER_TYPE:
			case LOCAL_VARIABLE:
			case GLOBAL_VARIABLE:
			case VOLATILE:
			case VOID:
			case METADATA:
			case LABEL:
			case TO:
			case UNWIND:
			case FLOATING_POINT_TYPE:
			case UNDEF:
				enterOuterAlt(_localctx, 2);
				{
				setState(888);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(836); ((Argument_listContext)_localctx).fct1 = first_class_type();
					type = ((Argument_listContext)_localctx).fct1.type;
					setState(842);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARAMETER_ATTRIBUTES) {
						{
						{
						setState(838); ((Argument_listContext)_localctx).pa1 = match(PARAMETER_ATTRIBUTES);
						pAttributes.add((((Argument_listContext)_localctx).pa1!=null?((Argument_listContext)_localctx).pa1.getText():null));
						}
						}
						setState(844);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(848);
					_la = _input.LA(1);
					if (_la==ALIGN) {
						{
						setState(845); ((Argument_listContext)_localctx).a1 = llvm_align();
						align = ((Argument_listContext)_localctx).a1.align;
						}
					}

					setState(853);
					switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
					case 1:
						{
						setState(850); ((Argument_listContext)_localctx).e1 = expression();
						expr = ((Argument_listContext)_localctx).e1.expr;
						}
						break;
					}
					alist.add(valueFactory.createArgument(type, pAttributes, align, expr));
					           pAttributes = new ArrayList<String>();
					           align = -1;
					           expr = null;
					           
					setState(880);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(856); match(35);
							setState(857); ((Argument_listContext)_localctx).fct2 = first_class_type();
							type = ((Argument_listContext)_localctx).fct2.type;
							setState(863);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==PARAMETER_ATTRIBUTES) {
								{
								{
								setState(859); ((Argument_listContext)_localctx).pa2 = match(PARAMETER_ATTRIBUTES);
								pAttributes.add((((Argument_listContext)_localctx).pa2!=null?((Argument_listContext)_localctx).pa2.getText():null));
								}
								}
								setState(865);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							setState(869);
							_la = _input.LA(1);
							if (_la==ALIGN) {
								{
								setState(866); ((Argument_listContext)_localctx).a2 = llvm_align();
								align = ((Argument_listContext)_localctx).a2.align;
								}
							}

							setState(874);
							switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
							case 1:
								{
								setState(871); ((Argument_listContext)_localctx).e2 = expression();
								expr = ((Argument_listContext)_localctx).e2.expr;
								}
								break;
							}
							alist.add(valueFactory.createArgument(type, pAttributes, align, expr));
							           pAttributes = new ArrayList<String>();
							           align = -1;
							           expr = null;
							          
							}
							} 
						}
						setState(882);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
					}
					setState(886);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						setState(883); match(35);
						setState(884); match(39);
						isVararg = true;
						}
						break;
					}
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			((Argument_listContext)_localctx).isVarargFunction =  isVararg;

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public Constant expr;
		public Token GLOBAL_VARIABLE;
		public Token LOCAL_VARIABLE;
		public Token UNDEF;
		public TerminalNode UNDEF() { return getToken(LLVMParser.UNDEF, 0); }
		public TerminalNode LOCAL_VARIABLE() { return getToken(LLVMParser.LOCAL_VARIABLE, 0); }
		public TerminalNode GLOBAL_VARIABLE() { return getToken(LLVMParser.GLOBAL_VARIABLE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_variable);
		try {
			setState(898);
			switch (_input.LA(1)) {
			case GLOBAL_VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(892); ((VariableContext)_localctx).GLOBAL_VARIABLE = match(GLOBAL_VARIABLE);
				((VariableContext)_localctx).expr =  valueFactory.createVariable((((VariableContext)_localctx).GLOBAL_VARIABLE!=null?((VariableContext)_localctx).GLOBAL_VARIABLE.getText():null));
				}
				break;
			case LOCAL_VARIABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(894); ((VariableContext)_localctx).LOCAL_VARIABLE = match(LOCAL_VARIABLE);
				((VariableContext)_localctx).expr =  valueFactory.createVariable((((VariableContext)_localctx).LOCAL_VARIABLE!=null?((VariableContext)_localctx).LOCAL_VARIABLE.getText():null));
				}
				break;
			case UNDEF:
				enterOuterAlt(_localctx, 3);
				{
				setState(896); ((VariableContext)_localctx).UNDEF = match(UNDEF);
				((VariableContext)_localctx).expr =  valueFactory.createVariable((((VariableContext)_localctx).UNDEF!=null?((VariableContext)_localctx).UNDEF.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Constant expr;
		public Simple_constantContext simple_constant;
		public Getelementptr_exprContext getelementptr_expr;
		public Conversion_exprContext conversion_expr;
		public Binary_exprContext binary_expr;
		public Cmp_exprContext cmp_expr;
		public VariableContext variable;
		public Metadata_exprContext metadata_expr;
		public Metadata_exprContext metadata_expr() {
			return getRuleContext(Metadata_exprContext.class,0);
		}
		public Binary_exprContext binary_expr() {
			return getRuleContext(Binary_exprContext.class,0);
		}
		public Conversion_exprContext conversion_expr() {
			return getRuleContext(Conversion_exprContext.class,0);
		}
		public Simple_constantContext simple_constant() {
			return getRuleContext(Simple_constantContext.class,0);
		}
		public Getelementptr_exprContext getelementptr_expr() {
			return getRuleContext(Getelementptr_exprContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Cmp_exprContext cmp_expr() {
			return getRuleContext(Cmp_exprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expression);
		try {
			setState(921);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(900); ((ExpressionContext)_localctx).simple_constant = simple_constant();
				((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).simple_constant.constant;
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(903); ((ExpressionContext)_localctx).getelementptr_expr = getelementptr_expr();
				((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).getelementptr_expr.expr;
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(906); ((ExpressionContext)_localctx).conversion_expr = conversion_expr();
				((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).conversion_expr.expr;
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(909); ((ExpressionContext)_localctx).binary_expr = binary_expr();
				((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).binary_expr.expr;
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(912); ((ExpressionContext)_localctx).cmp_expr = cmp_expr();
				((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).cmp_expr.expr;
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(915); ((ExpressionContext)_localctx).variable = variable();
				((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).variable.expr;
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(918); ((ExpressionContext)_localctx).metadata_expr = metadata_expr();
				((ExpressionContext)_localctx).expr =  ((ExpressionContext)_localctx).metadata_expr.expr;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Getelementptr_exprContext extends ParserRuleContext {
		public Constant expr;
		public Pointer_typeContext pointer_type;
		public ExpressionContext expression;
		public Token INTEGER;
		public List<TerminalNode> INTEGER() { return getTokens(LLVMParser.INTEGER); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> INTEGER_TYPE() { return getTokens(LLVMParser.INTEGER_TYPE); }
		public Pointer_typeContext pointer_type() {
			return getRuleContext(Pointer_typeContext.class,0);
		}
		public TerminalNode INTEGER(int i) {
			return getToken(LLVMParser.INTEGER, i);
		}
		public TerminalNode INTEGER_TYPE(int i) {
			return getToken(LLVMParser.INTEGER_TYPE, i);
		}
		public Getelementptr_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getelementptr_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterGetelementptr_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitGetelementptr_expr(this);
		}
	}

	public final Getelementptr_exprContext getelementptr_expr() throws RecognitionException {
		Getelementptr_exprContext _localctx = new Getelementptr_exprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_getelementptr_expr);

		boolean inbounds = false;
		Type type;
		Constant subExpr;
		List<Integer> indices = new ArrayList<Integer>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(923); match(31);
			setState(926);
			_la = _input.LA(1);
			if (_la==4) {
				{
				setState(924); match(4);
				inbounds = true;
				}
			}

			setState(928); match(36);
			setState(929); ((Getelementptr_exprContext)_localctx).pointer_type = pointer_type();
			type = ((Getelementptr_exprContext)_localctx).pointer_type.type;
			setState(931); ((Getelementptr_exprContext)_localctx).expression = expression();
			subExpr = ((Getelementptr_exprContext)_localctx).expression.expr;
			setState(937); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(933); match(35);
				setState(934); match(INTEGER_TYPE);
				setState(935); ((Getelementptr_exprContext)_localctx).INTEGER = match(INTEGER);
				indices.add(Integer.parseInt((((Getelementptr_exprContext)_localctx).INTEGER!=null?((Getelementptr_exprContext)_localctx).INTEGER.getText():null)));
				}
				}
				setState(939); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==35 );
			setState(941); match(14);
			}

			((Getelementptr_exprContext)_localctx).expr =  valueFactory.createGetEleExpression(inbounds, type, subExpr, indices);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Conversion_exprContext extends ParserRuleContext {
		public Constant expr;
		public Token CONVERSION_OP;
		public Scalar_typeContext st1;
		public ExpressionContext expression;
		public Scalar_typeContext st2;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<Scalar_typeContext> scalar_type() {
			return getRuleContexts(Scalar_typeContext.class);
		}
		public TerminalNode TO() { return getToken(LLVMParser.TO, 0); }
		public TerminalNode CONVERSION_OP() { return getToken(LLVMParser.CONVERSION_OP, 0); }
		public Scalar_typeContext scalar_type(int i) {
			return getRuleContext(Scalar_typeContext.class,i);
		}
		public Conversion_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversion_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterConversion_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitConversion_expr(this);
		}
	}

	public final Conversion_exprContext conversion_expr() throws RecognitionException {
		Conversion_exprContext _localctx = new Conversion_exprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_conversion_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(943); ((Conversion_exprContext)_localctx).CONVERSION_OP = match(CONVERSION_OP);
			setState(944); match(36);
			setState(945); ((Conversion_exprContext)_localctx).st1 = scalar_type();
			setState(946); ((Conversion_exprContext)_localctx).expression = expression();
			setState(947); match(TO);
			setState(948); ((Conversion_exprContext)_localctx).st2 = scalar_type();
			setState(949); match(14);
			String op = (((Conversion_exprContext)_localctx).CONVERSION_OP!=null?((Conversion_exprContext)_localctx).CONVERSION_OP.getText():null);
			       Type type1 = ((Conversion_exprContext)_localctx).st1.type;
			       Constant subExpr = ((Conversion_exprContext)_localctx).expression.expr;
			       Type type2 = ((Conversion_exprContext)_localctx).st2.type;
			       ((Conversion_exprContext)_localctx).expr =  valueFactory.createConversionExpression(op, type1, subExpr, type2);
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_exprContext extends ParserRuleContext {
		public Constant expr;
		public Token BINARY_OP;
		public Element_typeContext et1;
		public Vector_typeContext vt1;
		public ExpressionContext ex1;
		public Element_typeContext et2;
		public Vector_typeContext vt2;
		public ExpressionContext ex2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public Vector_typeContext vector_type(int i) {
			return getRuleContext(Vector_typeContext.class,i);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Element_typeContext element_type(int i) {
			return getRuleContext(Element_typeContext.class,i);
		}
		public List<Vector_typeContext> vector_type() {
			return getRuleContexts(Vector_typeContext.class);
		}
		public List<Element_typeContext> element_type() {
			return getRuleContexts(Element_typeContext.class);
		}
		public TerminalNode BINARY_OP() { return getToken(LLVMParser.BINARY_OP, 0); }
		public Binary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterBinary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitBinary_expr(this);
		}
	}

	public final Binary_exprContext binary_expr() throws RecognitionException {
		Binary_exprContext _localctx = new Binary_exprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_binary_expr);

		String op;
		String nuw = null;
		String nsw = null;
		String exact = null;
		Type type1 = null;
		Constant expr1;
		Type type2 = null;
		Constant expr2;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(952); ((Binary_exprContext)_localctx).BINARY_OP = match(BINARY_OP);
			op = (((Binary_exprContext)_localctx).BINARY_OP!=null?((Binary_exprContext)_localctx).BINARY_OP.getText():null);
			setState(956);
			_la = _input.LA(1);
			if (_la==43) {
				{
				setState(954); match(43);
				nuw = "nuw";
				}
			}

			setState(960);
			_la = _input.LA(1);
			if (_la==57) {
				{
				setState(958); match(57);
				nsw = "nsw";
				}
			}

			setState(964);
			_la = _input.LA(1);
			if (_la==33) {
				{
				setState(962); match(33);
				exact = "exact";
				}
			}

			setState(966); match(36);
			setState(973);
			switch (_input.LA(1)) {
			case BOOLEAN_TYPE:
			case INTEGER_TYPE:
			case LOCAL_VARIABLE:
			case FLOATING_POINT_TYPE:
				{
				{
				setState(967); ((Binary_exprContext)_localctx).et1 = element_type();
				type1 = ((Binary_exprContext)_localctx).et1.type;
				}
				}
				break;
			case 3:
				{
				{
				setState(970); ((Binary_exprContext)_localctx).vt1 = vector_type();
				}
				type1 = ((Binary_exprContext)_localctx).vt1.type;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(975); ((Binary_exprContext)_localctx).ex1 = expression();
			expr1 = ((Binary_exprContext)_localctx).ex1.expr;
			setState(977); match(35);
			setState(984);
			switch (_input.LA(1)) {
			case BOOLEAN_TYPE:
			case INTEGER_TYPE:
			case LOCAL_VARIABLE:
			case FLOATING_POINT_TYPE:
				{
				{
				setState(978); ((Binary_exprContext)_localctx).et2 = element_type();
				type2 = ((Binary_exprContext)_localctx).et2.type;
				}
				}
				break;
			case 3:
				{
				{
				setState(981); ((Binary_exprContext)_localctx).vt2 = vector_type();
				}
				type2 = ((Binary_exprContext)_localctx).vt2.type;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(986); ((Binary_exprContext)_localctx).ex2 = expression();
			expr2 = ((Binary_exprContext)_localctx).ex2.expr;
			setState(988); match(14);
			}

			((Binary_exprContext)_localctx).expr =  valueFactory.createBinaryExpression(op, nuw, nsw, exact, type1, expr1, type2, expr2);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cmp_exprContext extends ParserRuleContext {
		public Constant expr;
		public Token ICMP_COND;
		public Token cc1;
		public Token FCMP_COND;
		public Token cc2;
		public Token BOOLEAN;
		public Scalar_typeContext sct1;
		public Vector_typeContext vt1;
		public ExpressionContext e1;
		public Scalar_typeContext sct2;
		public Vector_typeContext vt2;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public Vector_typeContext vector_type(int i) {
			return getRuleContext(Vector_typeContext.class,i);
		}
		public TerminalNode CMP_COND() { return getToken(LLVMParser.CMP_COND, 0); }
		public List<Scalar_typeContext> scalar_type() {
			return getRuleContexts(Scalar_typeContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BOOLEAN() { return getToken(LLVMParser.BOOLEAN, 0); }
		public TerminalNode ICMP_COND() { return getToken(LLVMParser.ICMP_COND, 0); }
		public TerminalNode FCMP_COND() { return getToken(LLVMParser.FCMP_COND, 0); }
		public List<Vector_typeContext> vector_type() {
			return getRuleContexts(Vector_typeContext.class);
		}
		public Scalar_typeContext scalar_type(int i) {
			return getRuleContext(Scalar_typeContext.class,i);
		}
		public Cmp_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmp_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterCmp_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitCmp_expr(this);
		}
	}

	public final Cmp_exprContext cmp_expr() throws RecognitionException {
		Cmp_exprContext _localctx = new Cmp_exprContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_cmp_expr);

		boolean isICmp=true;
		String cond=null;
		Type type1=null, type2=null;
		Constant expr1=null, expr2=null;

		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1007);
			switch (_input.LA(1)) {
			case 54:
				{
				setState(990); match(54);
				setState(995);
				switch (_input.LA(1)) {
				case ICMP_COND:
					{
					setState(991); ((Cmp_exprContext)_localctx).ICMP_COND = match(ICMP_COND);
					cond = (((Cmp_exprContext)_localctx).ICMP_COND!=null?((Cmp_exprContext)_localctx).ICMP_COND.getText():null);
					}
					break;
				case CMP_COND:
					{
					setState(993); ((Cmp_exprContext)_localctx).cc1 = match(CMP_COND);
					cond = (((Cmp_exprContext)_localctx).cc1!=null?((Cmp_exprContext)_localctx).cc1.getText():null);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 45:
				{
				setState(997); match(45);
				isICmp = false;
				setState(1005);
				switch (_input.LA(1)) {
				case FCMP_COND:
					{
					setState(999); ((Cmp_exprContext)_localctx).FCMP_COND = match(FCMP_COND);
					cond = (((Cmp_exprContext)_localctx).FCMP_COND!=null?((Cmp_exprContext)_localctx).FCMP_COND.getText():null);
					}
					break;
				case CMP_COND:
					{
					setState(1001); ((Cmp_exprContext)_localctx).cc2 = match(CMP_COND);
					cond = (((Cmp_exprContext)_localctx).cc2!=null?((Cmp_exprContext)_localctx).cc2.getText():null);
					}
					break;
				case BOOLEAN:
					{
					setState(1003); ((Cmp_exprContext)_localctx).BOOLEAN = match(BOOLEAN);
					cond = (((Cmp_exprContext)_localctx).BOOLEAN!=null?((Cmp_exprContext)_localctx).BOOLEAN.getText():null);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1009); match(36);
			setState(1016);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(1010); ((Cmp_exprContext)_localctx).sct1 = scalar_type();
				type1 = ((Cmp_exprContext)_localctx).sct1.type;
				}
				break;

			case 2:
				{
				setState(1013); ((Cmp_exprContext)_localctx).vt1 = vector_type();
				type1 = ((Cmp_exprContext)_localctx).vt1.type;
				}
				break;
			}
			setState(1018); ((Cmp_exprContext)_localctx).e1 = expression();
			expr1 = ((Cmp_exprContext)_localctx).e1.expr;
			setState(1020); match(35);
			setState(1027);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				{
				setState(1021); ((Cmp_exprContext)_localctx).sct2 = scalar_type();
				type2 = ((Cmp_exprContext)_localctx).sct2.type; 
				}
				break;

			case 2:
				{
				setState(1024); ((Cmp_exprContext)_localctx).vt2 = vector_type();
				type2 = ((Cmp_exprContext)_localctx).vt2.type;
				}
				break;
			}
			setState(1029); ((Cmp_exprContext)_localctx).e2 = expression();
			expr2 = ((Cmp_exprContext)_localctx).e2.expr;
			setState(1031); match(14);
			}

			((Cmp_exprContext)_localctx).expr =  valueFactory.createCmpExpression(isICmp, cond, type1, expr1, type2, expr2);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Metadata_definitionContext extends ParserRuleContext {
		public Metadata_exprContext metadata_expr() {
			return getRuleContext(Metadata_exprContext.class,0);
		}
		public Metadata_variableContext metadata_variable() {
			return getRuleContext(Metadata_variableContext.class,0);
		}
		public Metadata_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metadata_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterMetadata_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitMetadata_definition(this);
		}
	}

	public final Metadata_definitionContext metadata_definition() throws RecognitionException {
		Metadata_definitionContext _localctx = new Metadata_definitionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_metadata_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1033); metadata_variable();
			setState(1034); match(18);
			setState(1035); metadata_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Metadata_variableContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(LLVMParser.INTEGER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LLVMParser.IDENTIFIER, 0); }
		public Metadata_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metadata_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterMetadata_variable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitMetadata_variable(this);
		}
	}

	public final Metadata_variableContext metadata_variable() throws RecognitionException {
		Metadata_variableContext _localctx = new Metadata_variableContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_metadata_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1037); match(28);
			setState(1038);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Metadata_exprContext extends ParserRuleContext {
		public Constant expr;
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(LLVMParser.INTEGER, 0); }
		public Metadata_listContext metadata_list() {
			return getRuleContext(Metadata_listContext.class,0);
		}
		public Metadata_variableContext metadata_variable() {
			return getRuleContext(Metadata_variableContext.class,0);
		}
		public TerminalNode NULL() { return getToken(LLVMParser.NULL, 0); }
		public TerminalNode STRING() { return getToken(LLVMParser.STRING, 0); }
		public Metadata_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metadata_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterMetadata_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitMetadata_expr(this);
		}
	}

	public final Metadata_exprContext metadata_expr() throws RecognitionException {
		Metadata_exprContext _localctx = new Metadata_exprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_metadata_expr);

		List<Argument> argList=new ArrayList<Argument>();

		try {
			setState(1052);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1040); match(28);
				setState(1047);
				switch (_input.LA(1)) {
				case STRING:
					{
					setState(1041); match(STRING);
					}
					break;
				case INTEGER:
					{
					setState(1042); match(INTEGER);
					}
					break;
				case 40:
					{
					setState(1043); match(40);
					setState(1044); metadata_list();
					setState(1045); match(9);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1049); metadata_variable();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1050); argument_list(argList);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1051); match(NULL);
				}
				break;
			}

			((Metadata_exprContext)_localctx).expr =  valueFactory.createVariable("undef");

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Metadata_listContext extends ParserRuleContext {
		public Metadata_exprContext metadata_expr(int i) {
			return getRuleContext(Metadata_exprContext.class,i);
		}
		public List<Metadata_exprContext> metadata_expr() {
			return getRuleContexts(Metadata_exprContext.class);
		}
		public Metadata_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metadata_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterMetadata_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitMetadata_list(this);
		}
	}

	public final Metadata_listContext metadata_list() throws RecognitionException {
		Metadata_listContext _localctx = new Metadata_listContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_metadata_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1054); metadata_expr();
			setState(1059);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==35) {
				{
				{
				setState(1055); match(35);
				setState(1056); metadata_expr();
				}
				}
				setState(1061);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dbg_metadataContext extends ParserRuleContext {
		public Metadata_exprContext metadata_expr() {
			return getRuleContext(Metadata_exprContext.class,0);
		}
		public Dbg_metadataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbg_metadata; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterDbg_metadata(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitDbg_metadata(this);
		}
	}

	public final Dbg_metadataContext dbg_metadata() throws RecognitionException {
		Dbg_metadataContext _localctx = new Dbg_metadataContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_dbg_metadata);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062); match(35);
			setState(1063); match(24);
			setState(1064); metadata_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_typeContext extends ParserRuleContext {
		public Type type;
		public Token LOCAL_VARIABLE;
		public TerminalNode LOCAL_VARIABLE() { return getToken(LLVMParser.LOCAL_VARIABLE, 0); }
		public Id_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterId_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitId_type(this);
		}
	}

	public final Id_typeContext id_type() throws RecognitionException {
		Id_typeContext _localctx = new Id_typeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_id_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1066); ((Id_typeContext)_localctx).LOCAL_VARIABLE = match(LOCAL_VARIABLE);
			((Id_typeContext)_localctx).type =  typeFactory.getIDType((((Id_typeContext)_localctx).LOCAL_VARIABLE!=null?((Id_typeContext)_localctx).LOCAL_VARIABLE.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Element_typeContext extends ParserRuleContext {
		public Type type;
		public Token INTEGER_TYPE;
		public Id_typeContext id_type;
		public TerminalNode FLOATING_POINT_TYPE() { return getToken(LLVMParser.FLOATING_POINT_TYPE, 0); }
		public TerminalNode BOOLEAN_TYPE() { return getToken(LLVMParser.BOOLEAN_TYPE, 0); }
		public Id_typeContext id_type() {
			return getRuleContext(Id_typeContext.class,0);
		}
		public TerminalNode INTEGER_TYPE() { return getToken(LLVMParser.INTEGER_TYPE, 0); }
		public Element_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterElement_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitElement_type(this);
		}
	}

	public final Element_typeContext element_type() throws RecognitionException {
		Element_typeContext _localctx = new Element_typeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_element_type);
		try {
			setState(1078);
			switch (_input.LA(1)) {
			case BOOLEAN_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1069); match(BOOLEAN_TYPE);
				((Element_typeContext)_localctx).type =  typeFactory.getInt1Type();
				}
				break;
			case INTEGER_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1071); ((Element_typeContext)_localctx).INTEGER_TYPE = match(INTEGER_TYPE);
				String is = (((Element_typeContext)_localctx).INTEGER_TYPE!=null?((Element_typeContext)_localctx).INTEGER_TYPE.getText():null); is = is.substring(1, is.length());int i =Integer.parseInt(is);
				                        if(i == 8){
				                          ((Element_typeContext)_localctx).type =  typeFactory.getInt8Type();
				                        }else if(i == 16){
				                          ((Element_typeContext)_localctx).type =  typeFactory.getInt16Type();
				                        }else if(i == 32){
				                          ((Element_typeContext)_localctx).type =  typeFactory.getInt32Type();
				                        }else if(i == 64){
				                          ((Element_typeContext)_localctx).type =  typeFactory.getInt64Type();
				                        }else{
				                          ((Element_typeContext)_localctx).type =  typeFactory.getIntNType(i);
				                        }
				                   
				}
				break;
			case FLOATING_POINT_TYPE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1073); match(FLOATING_POINT_TYPE);
				((Element_typeContext)_localctx).type =  typeFactory.getFloatType();
				}
				break;
			case LOCAL_VARIABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1075); ((Element_typeContext)_localctx).id_type = id_type();
				((Element_typeContext)_localctx).type =  ((Element_typeContext)_localctx).id_type.type;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scalar_typeContext extends ParserRuleContext {
		public Type type;
		public Element_typeContext element_type;
		public Parameter_type_listContext parameter_type_list;
		public Structure_typeContext structure_type;
		public Parameter_type_listContext ptl1;
		public Parameter_type_listContext ptl2;
		public Union_typeContext union_type;
		public Packed_structure_typeContext packed_structure_type;
		public Array_typeContext array_type;
		public Vector_typeContext vector_type;
		public Structure_typeContext structure_type() {
			return getRuleContext(Structure_typeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(LLVMParser.VOID, 0); }
		public Parameter_type_listContext parameter_type_list(int i) {
			return getRuleContext(Parameter_type_listContext.class,i);
		}
		public List<Parameter_type_listContext> parameter_type_list() {
			return getRuleContexts(Parameter_type_listContext.class);
		}
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Vector_typeContext vector_type() {
			return getRuleContext(Vector_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Packed_structure_typeContext packed_structure_type() {
			return getRuleContext(Packed_structure_typeContext.class,0);
		}
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public Scalar_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterScalar_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitScalar_type(this);
		}
	}

	public final Scalar_typeContext scalar_type() throws RecognitionException {
		Scalar_typeContext _localctx = new Scalar_typeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_scalar_type);
		int _la;
		try {
			setState(1249);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1080); ((Scalar_typeContext)_localctx).element_type = element_type();
				((Scalar_typeContext)_localctx).type =  ((Scalar_typeContext)_localctx).element_type.type;
				setState(1086);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(1082); match(2);
					((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1088);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1099);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(1089); ((Scalar_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((Scalar_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((Scalar_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1093); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1091); match(2);
						((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1095); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1102); ((Scalar_typeContext)_localctx).structure_type = structure_type();
				((Scalar_typeContext)_localctx).type =  ((Scalar_typeContext)_localctx).structure_type.type;
				setState(1135);
				switch (_input.LA(1)) {
				case 2:
					{
					setState(1106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1104); match(2);
						((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1108); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(1120);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==36) {
						{
						{
						setState(1110); ((Scalar_typeContext)_localctx).ptl1 = parameter_type_list();
						List<Type> typeList = ((Scalar_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Scalar_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
						setState(1114); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1112); match(2);
							((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1116); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						}
						}
						setState(1122);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 36:
					{
					setState(1131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1123); ((Scalar_typeContext)_localctx).ptl2 = parameter_type_list();
						List<Type> typeList2 = ((Scalar_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Scalar_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
						setState(1127); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1125); match(2);
							((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1129); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						}
						}
						setState(1133); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==36 );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1137); ((Scalar_typeContext)_localctx).union_type = union_type();
				((Scalar_typeContext)_localctx).type =  ((Scalar_typeContext)_localctx).union_type.type;
				setState(1170);
				switch (_input.LA(1)) {
				case 2:
					{
					setState(1141); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1139); match(2);
						((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1143); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(1155);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==36) {
						{
						{
						setState(1145); ((Scalar_typeContext)_localctx).ptl1 = parameter_type_list();
						List<Type> typeList = ((Scalar_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Scalar_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
						setState(1149); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1147); match(2);
							((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1151); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						}
						}
						setState(1157);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 36:
					{
					setState(1166); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1158); ((Scalar_typeContext)_localctx).ptl2 = parameter_type_list();
						List<Type> typeList2 = ((Scalar_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Scalar_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
						setState(1162); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1160); match(2);
							((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1164); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						}
						}
						setState(1168); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==36 );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1172); ((Scalar_typeContext)_localctx).packed_structure_type = packed_structure_type();
				((Scalar_typeContext)_localctx).type =  ((Scalar_typeContext)_localctx).packed_structure_type.type;
				setState(1176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1174); match(2);
					((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1178); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==2 );
				setState(1190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(1180); ((Scalar_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((Scalar_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((Scalar_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1184); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1182); match(2);
						((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1186); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1193); ((Scalar_typeContext)_localctx).array_type = array_type();
				((Scalar_typeContext)_localctx).type =  ((Scalar_typeContext)_localctx).array_type.type;
				setState(1197); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1195); match(2);
					((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1199); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==2 );
				setState(1211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(1201); ((Scalar_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((Scalar_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((Scalar_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1205); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1203); match(2);
						((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1207); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1214); ((Scalar_typeContext)_localctx).vector_type = vector_type();
				((Scalar_typeContext)_localctx).type =  ((Scalar_typeContext)_localctx).vector_type.type;
				setState(1218); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1216); match(2);
					((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1220); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==2 );
				setState(1232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(1222); ((Scalar_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((Scalar_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((Scalar_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1226); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1224); match(2);
						((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1228); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1234);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1235); match(VOID);
				((Scalar_typeContext)_localctx).type =  typeFactory.getVoidType();
				setState(1245); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1237); ((Scalar_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((Scalar_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((Scalar_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1241); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1239); match(2);
						((Scalar_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1243); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1247); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==36 );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primitive_typeContext extends ParserRuleContext {
		public Type type;
		public Element_typeContext element_type;
		public TerminalNode VOID() { return getToken(LLVMParser.VOID, 0); }
		public TerminalNode METADATA() { return getToken(LLVMParser.METADATA, 0); }
		public TerminalNode LABEL() { return getToken(LLVMParser.LABEL, 0); }
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public Primitive_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterPrimitive_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitPrimitive_type(this);
		}
	}

	public final Primitive_typeContext primitive_type() throws RecognitionException {
		Primitive_typeContext _localctx = new Primitive_typeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_primitive_type);
		try {
			setState(1260);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1251); match(VOID);
				((Primitive_typeContext)_localctx).type =  typeFactory.getVoidType();
				}
				break;
			case LABEL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1253); match(LABEL);
				((Primitive_typeContext)_localctx).type =  typeFactory.getLabelType();
				}
				break;
			case METADATA:
				enterOuterAlt(_localctx, 3);
				{
				setState(1255); match(METADATA);
				((Primitive_typeContext)_localctx).type =  typeFactory.getMetadataType();
				}
				break;
			case BOOLEAN_TYPE:
			case INTEGER_TYPE:
			case LOCAL_VARIABLE:
			case FLOATING_POINT_TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1257); ((Primitive_typeContext)_localctx).element_type = element_type();
				((Primitive_typeContext)_localctx).type =  ((Primitive_typeContext)_localctx).element_type.type;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class First_class_typeContext extends ParserRuleContext {
		public Type type;
		public Element_typeContext element_type;
		public Parameter_type_listContext parameter_type_list;
		public Structure_typeContext structure_type;
		public Union_typeContext union_type;
		public Packed_structure_typeContext packed_structure_type;
		public Array_typeContext array_type;
		public Vector_typeContext vector_type;
		public Structure_typeContext structure_type() {
			return getRuleContext(Structure_typeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(LLVMParser.VOID, 0); }
		public Parameter_type_listContext parameter_type_list(int i) {
			return getRuleContext(Parameter_type_listContext.class,i);
		}
		public List<Parameter_type_listContext> parameter_type_list() {
			return getRuleContexts(Parameter_type_listContext.class);
		}
		public TerminalNode METADATA() { return getToken(LLVMParser.METADATA, 0); }
		public TerminalNode LABEL() { return getToken(LLVMParser.LABEL, 0); }
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Vector_typeContext vector_type() {
			return getRuleContext(Vector_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Packed_structure_typeContext packed_structure_type() {
			return getRuleContext(Packed_structure_typeContext.class,0);
		}
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public First_class_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_first_class_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterFirst_class_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitFirst_class_type(this);
		}
	}

	public final First_class_typeContext first_class_type() throws RecognitionException {
		First_class_typeContext _localctx = new First_class_typeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_first_class_type);
		int _la;
		try {
			setState(1413);
			switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1262); ((First_class_typeContext)_localctx).element_type = element_type();
				((First_class_typeContext)_localctx).type =  ((First_class_typeContext)_localctx).element_type.type;
				setState(1268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(1264); match(2);
					((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1270);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(1271); ((First_class_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((First_class_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((First_class_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1275); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1273); match(2);
						((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1277); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1284); ((First_class_typeContext)_localctx).structure_type = structure_type();
				((First_class_typeContext)_localctx).type =  ((First_class_typeContext)_localctx).structure_type.type;
				setState(1290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(1286); match(2);
					((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1292);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(1293); ((First_class_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((First_class_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((First_class_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1297); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1295); match(2);
						((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1299); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1306); ((First_class_typeContext)_localctx).union_type = union_type();
				((First_class_typeContext)_localctx).type =  ((First_class_typeContext)_localctx).union_type.type;
				setState(1312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(1308); match(2);
					((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(1315); ((First_class_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((First_class_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((First_class_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1319); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1317); match(2);
						((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1321); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1327);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1328); ((First_class_typeContext)_localctx).packed_structure_type = packed_structure_type();
				((First_class_typeContext)_localctx).type =  ((First_class_typeContext)_localctx).packed_structure_type.type;
				setState(1332); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1330); match(2);
					((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1334); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==2 );
				setState(1346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(1336); ((First_class_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((First_class_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((First_class_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1340); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1338); match(2);
						((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1342); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1348);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1349); ((First_class_typeContext)_localctx).array_type = array_type();
				((First_class_typeContext)_localctx).type =  ((First_class_typeContext)_localctx).array_type.type;
				setState(1370);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(1353); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1351); match(2);
						((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1355); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(1367);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==36) {
						{
						{
						setState(1357); ((First_class_typeContext)_localctx).parameter_type_list = parameter_type_list();
						List<Type> typeList = ((First_class_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((First_class_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
						setState(1361); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1359); match(2);
							((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1363); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						}
						}
						setState(1369);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1372); ((First_class_typeContext)_localctx).vector_type = vector_type();
				((First_class_typeContext)_localctx).type =  ((First_class_typeContext)_localctx).vector_type.type;
				setState(1393);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(1376); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1374); match(2);
						((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1378); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(1390);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==36) {
						{
						{
						setState(1380); ((First_class_typeContext)_localctx).parameter_type_list = parameter_type_list();
						List<Type> typeList = ((First_class_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((First_class_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
						setState(1384); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1382); match(2);
							((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1386); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						}
						}
						setState(1392);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1395); match(VOID);
				((First_class_typeContext)_localctx).type =  typeFactory.getVoidType();
				setState(1405); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1397); ((First_class_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((First_class_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((First_class_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1401); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1399); match(2);
						((First_class_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1403); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1407); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==36 );
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1409); match(LABEL);
				((First_class_typeContext)_localctx).type =  typeFactory.getLabelType();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1411); match(METADATA);
				((First_class_typeContext)_localctx).type =  typeFactory.getMetadataType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Derived_typeContext extends ParserRuleContext {
		public Type type;
		public Element_typeContext element_type;
		public Parameter_type_listContext ptl1;
		public Parameter_type_listContext ptl2;
		public Structure_typeContext structure_type;
		public Union_typeContext union_type;
		public Packed_structure_typeContext packed_structure_type;
		public Array_typeContext array_type;
		public Vector_typeContext vector_type;
		public Structure_typeContext structure_type() {
			return getRuleContext(Structure_typeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(LLVMParser.VOID, 0); }
		public Parameter_type_listContext parameter_type_list(int i) {
			return getRuleContext(Parameter_type_listContext.class,i);
		}
		public List<Parameter_type_listContext> parameter_type_list() {
			return getRuleContexts(Parameter_type_listContext.class);
		}
		public TerminalNode METADATA() { return getToken(LLVMParser.METADATA, 0); }
		public TerminalNode LABEL() { return getToken(LLVMParser.LABEL, 0); }
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Vector_typeContext vector_type() {
			return getRuleContext(Vector_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Packed_structure_typeContext packed_structure_type() {
			return getRuleContext(Packed_structure_typeContext.class,0);
		}
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public TerminalNode OPAQUE() { return getToken(LLVMParser.OPAQUE, 0); }
		public Derived_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derived_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterDerived_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitDerived_type(this);
		}
	}

	public final Derived_typeContext derived_type() throws RecognitionException {
		Derived_typeContext _localctx = new Derived_typeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_derived_type);
		int _la;
		try {
			int _alt;
			setState(1653);
			switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1415); ((Derived_typeContext)_localctx).element_type = element_type();
				((Derived_typeContext)_localctx).type =  ((Derived_typeContext)_localctx).element_type.type;
				setState(1421);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(1417); match(2);
					((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1423);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1447);
				_la = _input.LA(1);
				if (_la==36) {
					{
					setState(1424); ((Derived_typeContext)_localctx).ptl1 = parameter_type_list();
					List<Type> typeList = ((Derived_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1437);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1428); 
							_errHandler.sync(this);
							_la = _input.LA(1);
							do {
								{
								{
								setState(1426); match(2);
								((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
								}
								}
								setState(1430); 
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while ( _la==2 );
							setState(1432); ((Derived_typeContext)_localctx).ptl2 = parameter_type_list();
							List<Type> typeList2 = ((Derived_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
							}
							} 
						}
						setState(1439);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,153,_ctx);
					}
					setState(1444);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==2) {
						{
						{
						setState(1440); match(2);
						((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1446);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1449); ((Derived_typeContext)_localctx).structure_type = structure_type();
				((Derived_typeContext)_localctx).type =  ((Derived_typeContext)_localctx).structure_type.type;
				setState(1455);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(1451); match(2);
					((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1457);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1481);
				_la = _input.LA(1);
				if (_la==36) {
					{
					setState(1458); ((Derived_typeContext)_localctx).ptl1 = parameter_type_list();
					List<Type> typeList = ((Derived_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1471);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,158,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1462); 
							_errHandler.sync(this);
							_la = _input.LA(1);
							do {
								{
								{
								setState(1460); match(2);
								((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
								}
								}
								setState(1464); 
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while ( _la==2 );
							setState(1466); ((Derived_typeContext)_localctx).ptl2 = parameter_type_list();
							List<Type> typeList2 = ((Derived_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
							}
							} 
						}
						setState(1473);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,158,_ctx);
					}
					setState(1478);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==2) {
						{
						{
						setState(1474); match(2);
						((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1480);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1483); ((Derived_typeContext)_localctx).union_type = union_type();
				((Derived_typeContext)_localctx).type =  ((Derived_typeContext)_localctx).union_type.type;
				setState(1489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(1485); match(2);
					((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1491);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1515);
				_la = _input.LA(1);
				if (_la==36) {
					{
					setState(1492); ((Derived_typeContext)_localctx).ptl1 = parameter_type_list();
					List<Type> typeList = ((Derived_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1505);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1496); 
							_errHandler.sync(this);
							_la = _input.LA(1);
							do {
								{
								{
								setState(1494); match(2);
								((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
								}
								}
								setState(1498); 
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while ( _la==2 );
							setState(1500); ((Derived_typeContext)_localctx).ptl2 = parameter_type_list();
							List<Type> typeList2 = ((Derived_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
							}
							} 
						}
						setState(1507);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
					}
					setState(1512);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==2) {
						{
						{
						setState(1508); match(2);
						((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1514);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1517); ((Derived_typeContext)_localctx).packed_structure_type = packed_structure_type();
				((Derived_typeContext)_localctx).type =  ((Derived_typeContext)_localctx).packed_structure_type.type;
				setState(1550);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(1521); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1519); match(2);
						((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1523); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(1548);
					_la = _input.LA(1);
					if (_la==36) {
						{
						setState(1525); ((Derived_typeContext)_localctx).ptl1 = parameter_type_list();
						List<Type> typeList = ((Derived_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
						setState(1538);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
						while ( _alt!=2 && _alt!=-1 ) {
							if ( _alt==1 ) {
								{
								{
								setState(1529); 
								_errHandler.sync(this);
								_la = _input.LA(1);
								do {
									{
									{
									setState(1527); match(2);
									((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
									}
									}
									setState(1531); 
									_errHandler.sync(this);
									_la = _input.LA(1);
								} while ( _la==2 );
								setState(1533); ((Derived_typeContext)_localctx).ptl2 = parameter_type_list();
								List<Type> typeList2 = ((Derived_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
								}
								} 
							}
							setState(1540);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,168,_ctx);
						}
						setState(1545);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==2) {
							{
							{
							setState(1541); match(2);
							((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1547);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
				}

				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1552); ((Derived_typeContext)_localctx).array_type = array_type();
				((Derived_typeContext)_localctx).type =  ((Derived_typeContext)_localctx).array_type.type;
				setState(1585);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(1556); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1554); match(2);
						((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1558); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(1583);
					_la = _input.LA(1);
					if (_la==36) {
						{
						setState(1560); ((Derived_typeContext)_localctx).ptl1 = parameter_type_list();
						List<Type> typeList = ((Derived_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
						setState(1573);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
						while ( _alt!=2 && _alt!=-1 ) {
							if ( _alt==1 ) {
								{
								{
								setState(1564); 
								_errHandler.sync(this);
								_la = _input.LA(1);
								do {
									{
									{
									setState(1562); match(2);
									((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
									}
									}
									setState(1566); 
									_errHandler.sync(this);
									_la = _input.LA(1);
								} while ( _la==2 );
								setState(1568); ((Derived_typeContext)_localctx).ptl2 = parameter_type_list();
								List<Type> typeList2 = ((Derived_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
								}
								} 
							}
							setState(1575);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
						}
						setState(1580);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==2) {
							{
							{
							setState(1576); match(2);
							((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1582);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
				}

				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1587); ((Derived_typeContext)_localctx).vector_type = vector_type();
				((Derived_typeContext)_localctx).type =  ((Derived_typeContext)_localctx).vector_type.type;
				setState(1620);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(1591); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1589); match(2);
						((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1593); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(1618);
					_la = _input.LA(1);
					if (_la==36) {
						{
						setState(1595); ((Derived_typeContext)_localctx).ptl1 = parameter_type_list();
						List<Type> typeList = ((Derived_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
						setState(1608);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
						while ( _alt!=2 && _alt!=-1 ) {
							if ( _alt==1 ) {
								{
								{
								setState(1599); 
								_errHandler.sync(this);
								_la = _input.LA(1);
								do {
									{
									{
									setState(1597); match(2);
									((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
									}
									}
									setState(1601); 
									_errHandler.sync(this);
									_la = _input.LA(1);
								} while ( _la==2 );
								setState(1603); ((Derived_typeContext)_localctx).ptl2 = parameter_type_list();
								List<Type> typeList2 = ((Derived_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
								}
								} 
							}
							setState(1610);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
						}
						setState(1615);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==2) {
							{
							{
							setState(1611); match(2);
							((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1617);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
				}

				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1622); match(VOID);
				((Derived_typeContext)_localctx).type =  typeFactory.getVoidType();
				setState(1624); ((Derived_typeContext)_localctx).ptl1 = parameter_type_list();
				List<Type> typeList = ((Derived_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
				setState(1637);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(1628); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1626); match(2);
							((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1630); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						setState(1632); ((Derived_typeContext)_localctx).ptl2 = parameter_type_list();
						List<Type> typeList2 = ((Derived_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Derived_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
						}
						} 
					}
					setState(1639);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
				}
				setState(1644);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(1640); match(2);
					((Derived_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1646);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1647); match(LABEL);
				((Derived_typeContext)_localctx).type =  typeFactory.getLabelType();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1649); match(METADATA);
				((Derived_typeContext)_localctx).type =  typeFactory.getMetadataType();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1651); match(OPAQUE);
				((Derived_typeContext)_localctx).type =  typeFactory.getOpaqueType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Aggregate_typeContext extends ParserRuleContext {
		public Type type;
		public Array_typeContext array_type;
		public Structure_typeContext structure_type;
		public Union_typeContext union_type;
		public Id_typeContext id_type;
		public Structure_typeContext structure_type() {
			return getRuleContext(Structure_typeContext.class,0);
		}
		public Id_typeContext id_type() {
			return getRuleContext(Id_typeContext.class,0);
		}
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Aggregate_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterAggregate_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitAggregate_type(this);
		}
	}

	public final Aggregate_typeContext aggregate_type() throws RecognitionException {
		Aggregate_typeContext _localctx = new Aggregate_typeContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_aggregate_type);
		try {
			setState(1667);
			switch (_input.LA(1)) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1655); ((Aggregate_typeContext)_localctx).array_type = array_type();
				((Aggregate_typeContext)_localctx).type =  ((Aggregate_typeContext)_localctx).array_type.type;
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 2);
				{
				setState(1658); ((Aggregate_typeContext)_localctx).structure_type = structure_type();
				((Aggregate_typeContext)_localctx).type =  ((Aggregate_typeContext)_localctx).structure_type.type;
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 3);
				{
				setState(1661); ((Aggregate_typeContext)_localctx).union_type = union_type();
				((Aggregate_typeContext)_localctx).type =  ((Aggregate_typeContext)_localctx).union_type.type;
				}
				break;
			case LOCAL_VARIABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1664); ((Aggregate_typeContext)_localctx).id_type = id_type();
				((Aggregate_typeContext)_localctx).type =  ((Aggregate_typeContext)_localctx).id_type.type;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pointer_typeContext extends ParserRuleContext {
		public Type type;
		public Element_typeContext element_type;
		public Parameter_type_listContext ptl1;
		public Parameter_type_listContext ptl2;
		public Structure_typeContext structure_type;
		public Union_typeContext union_type;
		public Packed_structure_typeContext packed_structure_type;
		public Array_typeContext array_type;
		public Vector_typeContext vector_type;
		public Structure_typeContext structure_type() {
			return getRuleContext(Structure_typeContext.class,0);
		}
		public Parameter_type_listContext parameter_type_list(int i) {
			return getRuleContext(Parameter_type_listContext.class,i);
		}
		public TerminalNode VOID() { return getToken(LLVMParser.VOID, 0); }
		public List<Parameter_type_listContext> parameter_type_list() {
			return getRuleContexts(Parameter_type_listContext.class);
		}
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Vector_typeContext vector_type() {
			return getRuleContext(Vector_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Packed_structure_typeContext packed_structure_type() {
			return getRuleContext(Packed_structure_typeContext.class,0);
		}
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public Pointer_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterPointer_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitPointer_type(this);
		}
	}

	public final Pointer_typeContext pointer_type() throws RecognitionException {
		Pointer_typeContext _localctx = new Pointer_typeContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_pointer_type);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1849);
			switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
			case 1:
				{
				setState(1669); ((Pointer_typeContext)_localctx).element_type = element_type();
				((Pointer_typeContext)_localctx).type =  ((Pointer_typeContext)_localctx).element_type.type;
				setState(1694);
				switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
				case 1:
					{
					setState(1675);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==2) {
						{
						{
						setState(1671); match(2);
						((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1677);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1678); ((Pointer_typeContext)_localctx).ptl1 = parameter_type_list();
					List<Type> typeList = ((Pointer_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1691);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1682); 
							_errHandler.sync(this);
							_la = _input.LA(1);
							do {
								{
								{
								setState(1680); match(2);
								((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
								}
								}
								setState(1684); 
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while ( _la==2 );
							setState(1686); ((Pointer_typeContext)_localctx).ptl2 = parameter_type_list();
							List<Type> typeList2 = ((Pointer_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
							}
							} 
						}
						setState(1693);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,191,_ctx);
					}
					}
					break;
				}
				}
				break;

			case 2:
				{
				setState(1696); ((Pointer_typeContext)_localctx).structure_type = structure_type();
				((Pointer_typeContext)_localctx).type =  ((Pointer_typeContext)_localctx).structure_type.type;
				setState(1721);
				switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
				case 1:
					{
					setState(1702);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==2) {
						{
						{
						setState(1698); match(2);
						((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1704);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1705); ((Pointer_typeContext)_localctx).ptl1 = parameter_type_list();
					List<Type> typeList = ((Pointer_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1718);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1709); 
							_errHandler.sync(this);
							_la = _input.LA(1);
							do {
								{
								{
								setState(1707); match(2);
								((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
								}
								}
								setState(1711); 
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while ( _la==2 );
							setState(1713); ((Pointer_typeContext)_localctx).ptl2 = parameter_type_list();
							List<Type> typeList2 = ((Pointer_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
							}
							} 
						}
						setState(1720);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
					}
					}
					break;
				}
				}
				break;

			case 3:
				{
				setState(1723); ((Pointer_typeContext)_localctx).union_type = union_type();
				((Pointer_typeContext)_localctx).type =  ((Pointer_typeContext)_localctx).union_type.type;
				setState(1748);
				switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
				case 1:
					{
					setState(1729);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==2) {
						{
						{
						setState(1725); match(2);
						((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1731);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1732); ((Pointer_typeContext)_localctx).ptl1 = parameter_type_list();
					List<Type> typeList = ((Pointer_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1745);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,199,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1736); 
							_errHandler.sync(this);
							_la = _input.LA(1);
							do {
								{
								{
								setState(1734); match(2);
								((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
								}
								}
								setState(1738); 
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while ( _la==2 );
							setState(1740); ((Pointer_typeContext)_localctx).ptl2 = parameter_type_list();
							List<Type> typeList2 = ((Pointer_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
							}
							} 
						}
						setState(1747);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,199,_ctx);
					}
					}
					break;
				}
				}
				break;

			case 4:
				{
				setState(1750); ((Pointer_typeContext)_localctx).packed_structure_type = packed_structure_type();
				((Pointer_typeContext)_localctx).type =  ((Pointer_typeContext)_localctx).packed_structure_type.type;
				setState(1775);
				switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
				case 1:
					{
					setState(1756);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==2) {
						{
						{
						setState(1752); match(2);
						((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1758);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1759); ((Pointer_typeContext)_localctx).ptl1 = parameter_type_list();
					List<Type> typeList = ((Pointer_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1772);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1763); 
							_errHandler.sync(this);
							_la = _input.LA(1);
							do {
								{
								{
								setState(1761); match(2);
								((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
								}
								}
								setState(1765); 
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while ( _la==2 );
							setState(1767); ((Pointer_typeContext)_localctx).ptl2 = parameter_type_list();
							List<Type> typeList2 = ((Pointer_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
							}
							} 
						}
						setState(1774);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,203,_ctx);
					}
					}
					break;
				}
				}
				break;

			case 5:
				{
				setState(1777); ((Pointer_typeContext)_localctx).array_type = array_type();
				((Pointer_typeContext)_localctx).type =  ((Pointer_typeContext)_localctx).array_type.type;
				setState(1802);
				switch ( getInterpreter().adaptivePredict(_input,208,_ctx) ) {
				case 1:
					{
					setState(1783);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==2) {
						{
						{
						setState(1779); match(2);
						((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1785);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1786); ((Pointer_typeContext)_localctx).ptl1 = parameter_type_list();
					List<Type> typeList = ((Pointer_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1799);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,207,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1790); 
							_errHandler.sync(this);
							_la = _input.LA(1);
							do {
								{
								{
								setState(1788); match(2);
								((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
								}
								}
								setState(1792); 
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while ( _la==2 );
							setState(1794); ((Pointer_typeContext)_localctx).ptl2 = parameter_type_list();
							List<Type> typeList2 = ((Pointer_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
							}
							} 
						}
						setState(1801);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,207,_ctx);
					}
					}
					break;
				}
				}
				break;

			case 6:
				{
				setState(1804); ((Pointer_typeContext)_localctx).vector_type = vector_type();
				((Pointer_typeContext)_localctx).type =  ((Pointer_typeContext)_localctx).vector_type.type;
				setState(1829);
				switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
				case 1:
					{
					setState(1810);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==2) {
						{
						{
						setState(1806); match(2);
						((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1812);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1813); ((Pointer_typeContext)_localctx).ptl1 = parameter_type_list();
					List<Type> typeList = ((Pointer_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1826);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
					while ( _alt!=2 && _alt!=-1 ) {
						if ( _alt==1 ) {
							{
							{
							setState(1817); 
							_errHandler.sync(this);
							_la = _input.LA(1);
							do {
								{
								{
								setState(1815); match(2);
								((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
								}
								}
								setState(1819); 
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while ( _la==2 );
							setState(1821); ((Pointer_typeContext)_localctx).ptl2 = parameter_type_list();
							List<Type> typeList2 = ((Pointer_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
							}
							} 
						}
						setState(1828);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,211,_ctx);
					}
					}
					break;
				}
				}
				break;

			case 7:
				{
				setState(1831); match(VOID);
				((Pointer_typeContext)_localctx).type =  typeFactory.getVoidType();
				setState(1833); ((Pointer_typeContext)_localctx).ptl1 = parameter_type_list();
				List<Type> typeList = ((Pointer_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
				setState(1846);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(1837); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1835); match(2);
							((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1839); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						setState(1841); ((Pointer_typeContext)_localctx).ptl2 = parameter_type_list();
						List<Type> typeList2 = ((Pointer_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Pointer_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
						}
						} 
					}
					setState(1848);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
				}
				}
				break;
			}
			setState(1853); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1851); match(2);
				((Pointer_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
				}
				}
				setState(1855); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==2 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Structure_typeContext extends ParserRuleContext {
		public Type type;
		public Type_listContext type_list;
		public Type_listContext type_list() {
			return getRuleContext(Type_listContext.class,0);
		}
		public Structure_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterStructure_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitStructure_type(this);
		}
	}

	public final Structure_typeContext structure_type() throws RecognitionException {
		Structure_typeContext _localctx = new Structure_typeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_structure_type);

		  List<Type> typeList = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1857); match(40);
			setState(1861);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 13) | (1L << 40) | (1L << BOOLEAN_TYPE) | (1L << INTEGER_TYPE) | (1L << LOCAL_VARIABLE))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (VOID - 73)) | (1L << (OPAQUE - 73)) | (1L << (METADATA - 73)) | (1L << (LABEL - 73)) | (1L << (FLOATING_POINT_TYPE - 73)))) != 0)) {
				{
				setState(1858); ((Structure_typeContext)_localctx).type_list = type_list();
				typeList = ((Structure_typeContext)_localctx).type_list.typeList;
				}
			}

			setState(1863); match(9);
			((Structure_typeContext)_localctx).type =  typeFactory.getStructType(typeList);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Packed_structure_typeContext extends ParserRuleContext {
		public Type type;
		public Type_listContext type_list;
		public Type_listContext type_list() {
			return getRuleContext(Type_listContext.class,0);
		}
		public Packed_structure_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packed_structure_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterPacked_structure_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitPacked_structure_type(this);
		}
	}

	public final Packed_structure_typeContext packed_structure_type() throws RecognitionException {
		Packed_structure_typeContext _localctx = new Packed_structure_typeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_packed_structure_type);

		  List<Type> typeList = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1866); match(3);
			setState(1867); match(40);
			setState(1871);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 13) | (1L << 40) | (1L << BOOLEAN_TYPE) | (1L << INTEGER_TYPE) | (1L << LOCAL_VARIABLE))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (VOID - 73)) | (1L << (OPAQUE - 73)) | (1L << (METADATA - 73)) | (1L << (LABEL - 73)) | (1L << (FLOATING_POINT_TYPE - 73)))) != 0)) {
				{
				setState(1868); ((Packed_structure_typeContext)_localctx).type_list = type_list();
				typeList = ((Packed_structure_typeContext)_localctx).type_list.typeList;
				}
			}

			setState(1873); match(9);
			setState(1874); match(49);
			((Packed_structure_typeContext)_localctx).type =  typeFactory.getPackedStructType(typeList);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Union_typeContext extends ParserRuleContext {
		public Type type;
		public Type_listContext type_list;
		public Type_listContext type_list() {
			return getRuleContext(Type_listContext.class,0);
		}
		public Union_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterUnion_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitUnion_type(this);
		}
	}

	public final Union_typeContext union_type() throws RecognitionException {
		Union_typeContext _localctx = new Union_typeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_union_type);

		  List<Type> typeList = null;

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1877); match(13);
			setState(1878); match(40);
			setState(1882);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 3) | (1L << 13) | (1L << 40) | (1L << BOOLEAN_TYPE) | (1L << INTEGER_TYPE) | (1L << LOCAL_VARIABLE))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (VOID - 73)) | (1L << (OPAQUE - 73)) | (1L << (METADATA - 73)) | (1L << (LABEL - 73)) | (1L << (FLOATING_POINT_TYPE - 73)))) != 0)) {
				{
				setState(1879); ((Union_typeContext)_localctx).type_list = type_list();
				typeList = ((Union_typeContext)_localctx).type_list.typeList;
				}
			}

			setState(1884); match(9);
			((Union_typeContext)_localctx).type =  typeFactory.getUnionType(typeList);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_listContext extends ParserRuleContext {
		public List<Type> typeList;
		public Derived_typeContext dt;
		public Derived_typeContext dt2;
		public List<Derived_typeContext> derived_type() {
			return getRuleContexts(Derived_typeContext.class);
		}
		public Derived_typeContext derived_type(int i) {
			return getRuleContext(Derived_typeContext.class,i);
		}
		public Type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterType_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitType_list(this);
		}
	}

	public final Type_listContext type_list() throws RecognitionException {
		Type_listContext _localctx = new Type_listContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_type_list);

		  ((Type_listContext)_localctx).typeList =  new ArrayList<Type>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1887); ((Type_listContext)_localctx).dt = derived_type();
			_localctx.typeList.add(((Type_listContext)_localctx).dt.type);
			setState(1895);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==35) {
				{
				{
				setState(1889); match(35);
				setState(1890); ((Type_listContext)_localctx).dt2 = derived_type();
				_localctx.typeList.add(((Type_listContext)_localctx).dt2.type);
				}
				}
				setState(1897);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_typeContext extends ParserRuleContext {
		public Type type;
		public Token INTEGER;
		public Derived_typeContext derived_type;
		public TerminalNode INTEGER() { return getToken(LLVMParser.INTEGER, 0); }
		public Derived_typeContext derived_type() {
			return getRuleContext(Derived_typeContext.class,0);
		}
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterArray_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitArray_type(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1898); match(1);
			setState(1899); ((Array_typeContext)_localctx).INTEGER = match(INTEGER);
			setState(1900); match(21);
			setState(1901); ((Array_typeContext)_localctx).derived_type = derived_type();
			setState(1902); match(32);
			((Array_typeContext)_localctx).type =  typeFactory.getArrayType(Integer.parseInt((((Array_typeContext)_localctx).INTEGER!=null?((Array_typeContext)_localctx).INTEGER.getText():null)), ((Array_typeContext)_localctx).derived_type.type);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vector_typeContext extends ParserRuleContext {
		public Type type;
		public Token INTEGER;
		public Element_typeContext element_type;
		public TerminalNode INTEGER() { return getToken(LLVMParser.INTEGER, 0); }
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public Vector_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterVector_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitVector_type(this);
		}
	}

	public final Vector_typeContext vector_type() throws RecognitionException {
		Vector_typeContext _localctx = new Vector_typeContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_vector_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1905); match(3);
			setState(1906); ((Vector_typeContext)_localctx).INTEGER = match(INTEGER);
			setState(1907); match(21);
			setState(1908); ((Vector_typeContext)_localctx).element_type = element_type();
			setState(1909); match(49);
			((Vector_typeContext)_localctx).type =  typeFactory.getVectorType(Integer.parseInt((((Vector_typeContext)_localctx).INTEGER!=null?((Vector_typeContext)_localctx).INTEGER.getText():null)), ((Vector_typeContext)_localctx).element_type.type);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_typeContext extends ParserRuleContext {
		public Type type;
		public Element_typeContext element_type;
		public Parameter_type_listContext parameter_type_list;
		public Structure_typeContext structure_type;
		public Parameter_type_listContext ptl1;
		public Parameter_type_listContext ptl2;
		public Union_typeContext union_type;
		public Packed_structure_typeContext packed_structure_type;
		public Array_typeContext array_type;
		public Vector_typeContext vector_type;
		public Structure_typeContext structure_type() {
			return getRuleContext(Structure_typeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(LLVMParser.VOID, 0); }
		public Parameter_type_listContext parameter_type_list(int i) {
			return getRuleContext(Parameter_type_listContext.class,i);
		}
		public List<Parameter_type_listContext> parameter_type_list() {
			return getRuleContexts(Parameter_type_listContext.class);
		}
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Vector_typeContext vector_type() {
			return getRuleContext(Vector_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Packed_structure_typeContext packed_structure_type() {
			return getRuleContext(Packed_structure_typeContext.class,0);
		}
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterReturn_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitReturn_type(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_return_type);
		int _la;
		try {
			setState(2082);
			switch ( getInterpreter().adaptivePredict(_input,247,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1912); ((Return_typeContext)_localctx).element_type = element_type();
				((Return_typeContext)_localctx).type =  ((Return_typeContext)_localctx).element_type.type;
				setState(1918);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(1914); match(2);
					((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(1920);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1931);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(1921); ((Return_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((Return_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((Return_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(1925); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1923); match(2);
						((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1927); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(1933);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1934); ((Return_typeContext)_localctx).structure_type = structure_type();
				((Return_typeContext)_localctx).type =  ((Return_typeContext)_localctx).structure_type.type;
				setState(1967);
				switch (_input.LA(1)) {
				case 2:
					{
					setState(1938); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1936); match(2);
						((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1940); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(1952);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==36) {
						{
						{
						setState(1942); ((Return_typeContext)_localctx).ptl1 = parameter_type_list();
						List<Type> typeList = ((Return_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Return_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
						setState(1946); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1944); match(2);
							((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1948); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						}
						}
						setState(1954);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 36:
					{
					setState(1963); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1955); ((Return_typeContext)_localctx).ptl2 = parameter_type_list();
						List<Type> typeList2 = ((Return_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Return_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
						setState(1959); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1957); match(2);
							((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1961); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						}
						}
						setState(1965); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==36 );
					}
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 9:
				case 13:
				case 23:
				case 26:
				case 27:
				case 28:
				case 29:
				case 31:
				case 35:
				case 38:
				case 39:
				case 40:
				case 45:
				case 48:
				case 53:
				case 54:
				case 55:
				case BLOCK_ID:
				case BOOLEAN_TYPE:
				case INTEGER_TYPE:
				case LOCAL_VARIABLE:
				case GLOBAL_VARIABLE:
				case INTEGER:
				case BOOLEAN:
				case FLOATING_POINT:
				case HEX:
				case BINARY_OP:
				case CONVERSION_OP:
				case VOLATILE:
				case VOID:
				case METADATA:
				case LABEL:
				case UNWIND:
				case FLOATING_POINT_TYPE:
				case NULL:
				case UNDEF:
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1969); ((Return_typeContext)_localctx).union_type = union_type();
				((Return_typeContext)_localctx).type =  ((Return_typeContext)_localctx).union_type.type;
				setState(2002);
				switch (_input.LA(1)) {
				case 2:
					{
					setState(1973); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1971); match(2);
						((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(1975); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(1987);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==36) {
						{
						{
						setState(1977); ((Return_typeContext)_localctx).ptl1 = parameter_type_list();
						List<Type> typeList = ((Return_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Return_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
						setState(1981); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1979); match(2);
							((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1983); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						}
						}
						setState(1989);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 36:
					{
					setState(1998); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1990); ((Return_typeContext)_localctx).ptl2 = parameter_type_list();
						List<Type> typeList2 = ((Return_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Return_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
						setState(1994); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1992); match(2);
							((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
							}
							}
							setState(1996); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==2 );
						}
						}
						setState(2000); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==36 );
					}
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 9:
				case 13:
				case 23:
				case 26:
				case 27:
				case 28:
				case 29:
				case 31:
				case 35:
				case 38:
				case 39:
				case 40:
				case 45:
				case 48:
				case 53:
				case 54:
				case 55:
				case BLOCK_ID:
				case BOOLEAN_TYPE:
				case INTEGER_TYPE:
				case LOCAL_VARIABLE:
				case GLOBAL_VARIABLE:
				case INTEGER:
				case BOOLEAN:
				case FLOATING_POINT:
				case HEX:
				case BINARY_OP:
				case CONVERSION_OP:
				case VOLATILE:
				case VOID:
				case METADATA:
				case LABEL:
				case UNWIND:
				case FLOATING_POINT_TYPE:
				case NULL:
				case UNDEF:
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2004); ((Return_typeContext)_localctx).packed_structure_type = packed_structure_type();
				((Return_typeContext)_localctx).type =  ((Return_typeContext)_localctx).packed_structure_type.type;
				setState(2008); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2006); match(2);
					((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(2010); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==2 );
				setState(2022);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(2012); ((Return_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((Return_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((Return_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(2016); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2014); match(2);
						((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2018); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(2024);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2025); ((Return_typeContext)_localctx).array_type = array_type();
				((Return_typeContext)_localctx).type =  ((Return_typeContext)_localctx).array_type.type;
				setState(2029); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2027); match(2);
					((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(2031); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==2 );
				setState(2043);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(2033); ((Return_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((Return_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((Return_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(2037); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2035); match(2);
						((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2039); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(2045);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2046); ((Return_typeContext)_localctx).vector_type = vector_type();
				((Return_typeContext)_localctx).type =  ((Return_typeContext)_localctx).vector_type.type;
				setState(2050); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2048); match(2);
					((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(2052); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==2 );
				setState(2064);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(2054); ((Return_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((Return_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((Return_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(2058); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2056); match(2);
						((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2060); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(2066);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2067); match(VOID);
				((Return_typeContext)_localctx).type =  typeFactory.getVoidType();
				setState(2079);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==36) {
					{
					{
					setState(2069); ((Return_typeContext)_localctx).parameter_type_list = parameter_type_list();
					List<Type> typeList = ((Return_typeContext)_localctx).parameter_type_list.typeList; typeList.add(0, _localctx.type); ((Return_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
					setState(2073); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2071); match(2);
						((Return_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2075); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					}
					}
					setState(2081);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_typeContext extends ParserRuleContext {
		public Type type;
		public Element_typeContext element_type;
		public Parameter_type_listContext ptl1;
		public Parameter_type_listContext ptl2;
		public Structure_typeContext structure_type;
		public Union_typeContext union_type;
		public Packed_structure_typeContext packed_structure_type;
		public Array_typeContext array_type;
		public Vector_typeContext vector_type;
		public Structure_typeContext structure_type() {
			return getRuleContext(Structure_typeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(LLVMParser.VOID, 0); }
		public Parameter_type_listContext parameter_type_list(int i) {
			return getRuleContext(Parameter_type_listContext.class,i);
		}
		public List<Parameter_type_listContext> parameter_type_list() {
			return getRuleContexts(Parameter_type_listContext.class);
		}
		public Union_typeContext union_type() {
			return getRuleContext(Union_typeContext.class,0);
		}
		public Vector_typeContext vector_type() {
			return getRuleContext(Vector_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Packed_structure_typeContext packed_structure_type() {
			return getRuleContext(Packed_structure_typeContext.class,0);
		}
		public Element_typeContext element_type() {
			return getRuleContext(Element_typeContext.class,0);
		}
		public Function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterFunction_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitFunction_type(this);
		}
	}

	public final Function_typeContext function_type() throws RecognitionException {
		Function_typeContext _localctx = new Function_typeContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_function_type);
		int _la;
		try {
			setState(2249);
			switch ( getInterpreter().adaptivePredict(_input,268,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2084); ((Function_typeContext)_localctx).element_type = element_type();
				((Function_typeContext)_localctx).type =  ((Function_typeContext)_localctx).element_type.type;
				setState(2090);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(2086); match(2);
					((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(2092);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2093); ((Function_typeContext)_localctx).ptl1 = parameter_type_list();
				List<Type> typeList = ((Function_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
				setState(2106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(2097); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2095); match(2);
						((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2099); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(2101); ((Function_typeContext)_localctx).ptl2 = parameter_type_list();
					List<Type> typeList2 = ((Function_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
					}
					}
					setState(2108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2109); ((Function_typeContext)_localctx).structure_type = structure_type();
				((Function_typeContext)_localctx).type =  ((Function_typeContext)_localctx).structure_type.type;
				setState(2115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(2111); match(2);
					((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(2117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2118); ((Function_typeContext)_localctx).ptl1 = parameter_type_list();
				List<Type> typeList = ((Function_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
				setState(2131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(2122); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2120); match(2);
						((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2124); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(2126); ((Function_typeContext)_localctx).ptl2 = parameter_type_list();
					List<Type> typeList2 = ((Function_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
					}
					}
					setState(2133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2134); ((Function_typeContext)_localctx).union_type = union_type();
				((Function_typeContext)_localctx).type =  ((Function_typeContext)_localctx).union_type.type;
				setState(2140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(2136); match(2);
					((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(2142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2143); ((Function_typeContext)_localctx).ptl1 = parameter_type_list();
				List<Type> typeList = ((Function_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
				setState(2156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(2147); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2145); match(2);
						((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2149); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(2151); ((Function_typeContext)_localctx).ptl2 = parameter_type_list();
					List<Type> typeList2 = ((Function_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
					}
					}
					setState(2158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2159); ((Function_typeContext)_localctx).packed_structure_type = packed_structure_type();
				((Function_typeContext)_localctx).type =  ((Function_typeContext)_localctx).packed_structure_type.type;
				setState(2163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2161); match(2);
					((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(2165); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==2 );
				setState(2167); ((Function_typeContext)_localctx).ptl1 = parameter_type_list();
				List<Type> typeList = ((Function_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
				setState(2180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(2171); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2169); match(2);
						((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2173); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(2175); ((Function_typeContext)_localctx).ptl2 = parameter_type_list();
					List<Type> typeList2 = ((Function_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
					}
					}
					setState(2182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2183); ((Function_typeContext)_localctx).array_type = array_type();
				((Function_typeContext)_localctx).type =  ((Function_typeContext)_localctx).array_type.type;
				setState(2187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2185); match(2);
					((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(2189); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==2 );
				setState(2191); ((Function_typeContext)_localctx).ptl1 = parameter_type_list();
				List<Type> typeList = ((Function_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
				setState(2204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(2195); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2193); match(2);
						((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2197); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(2199); ((Function_typeContext)_localctx).ptl2 = parameter_type_list();
					List<Type> typeList2 = ((Function_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
					}
					}
					setState(2206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2207); ((Function_typeContext)_localctx).vector_type = vector_type();
				((Function_typeContext)_localctx).type =  ((Function_typeContext)_localctx).vector_type.type;
				setState(2211); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2209); match(2);
					((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
					}
					}
					setState(2213); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==2 );
				setState(2215); ((Function_typeContext)_localctx).ptl1 = parameter_type_list();
				List<Type> typeList = ((Function_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
				setState(2228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(2219); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2217); match(2);
						((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2221); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(2223); ((Function_typeContext)_localctx).ptl2 = parameter_type_list();
					List<Type> typeList2 = ((Function_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
					}
					}
					setState(2230);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2231); match(VOID);
				((Function_typeContext)_localctx).type =  typeFactory.getVoidType();
				setState(2233); ((Function_typeContext)_localctx).ptl1 = parameter_type_list();
				List<Type> typeList = ((Function_typeContext)_localctx).ptl1.typeList; typeList.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList);
				setState(2246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(2237); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(2235); match(2);
						((Function_typeContext)_localctx).type =  typeFactory.getPointerType(_localctx.type);
						}
						}
						setState(2239); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==2 );
					setState(2241); ((Function_typeContext)_localctx).ptl2 = parameter_type_list();
					List<Type> typeList2 = ((Function_typeContext)_localctx).ptl2.typeList; typeList2.add(0, _localctx.type); ((Function_typeContext)_localctx).type =  typeFactory.getFunctionType(typeList2);
					}
					}
					setState(2248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_type_listContext extends ParserRuleContext {
		public List<Type> typeList;
		public First_class_typeContext fct1;
		public First_class_typeContext fct2;
		public List<First_class_typeContext> first_class_type() {
			return getRuleContexts(First_class_typeContext.class);
		}
		public First_class_typeContext first_class_type(int i) {
			return getRuleContext(First_class_typeContext.class,i);
		}
		public Parameter_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterParameter_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitParameter_type_list(this);
		}
	}

	public final Parameter_type_listContext parameter_type_list() throws RecognitionException {
		Parameter_type_listContext _localctx = new Parameter_type_listContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_parameter_type_list);

		  ((Parameter_type_listContext)_localctx).typeList =  new ArrayList<Type>();

		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2251); match(36);
			setState(2270);
			switch (_input.LA(1)) {
			case 39:
				{
				setState(2252); match(39);
				_localctx.typeList.add(typeFactory.getWrongType());
				}
				break;
			case 1:
			case 3:
			case 13:
			case 40:
			case BOOLEAN_TYPE:
			case INTEGER_TYPE:
			case LOCAL_VARIABLE:
			case VOID:
			case METADATA:
			case LABEL:
			case FLOATING_POINT_TYPE:
				{
				setState(2254); ((Parameter_type_listContext)_localctx).fct1 = first_class_type();
				_localctx.typeList.add(((Parameter_type_listContext)_localctx).fct1.type);
				setState(2262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,269,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(2256); match(35);
						setState(2257); ((Parameter_type_listContext)_localctx).fct2 = first_class_type();
						_localctx.typeList.add(((Parameter_type_listContext)_localctx).fct2.type);
						}
						} 
					}
					setState(2264);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,269,_ctx);
				}
				setState(2268);
				_la = _input.LA(1);
				if (_la==35) {
					{
					setState(2265); match(35);
					setState(2266); match(39);
					_localctx.typeList.add(typeFactory.getWrongType());
					}
				}

				}
				break;
			case 14:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2272); match(14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext {
		public Constant constant;
		public Token STRING;
		public Llvm_constantContext llvm_constant;
		public Token GLOBAL_VARIABLE;
		public TerminalNode GLOBAL_VARIABLE() { return getToken(LLVMParser.GLOBAL_VARIABLE, 0); }
		public TerminalNode STRING() { return getToken(LLVMParser.STRING, 0); }
		public Llvm_constantContext llvm_constant() {
			return getRuleContext(Llvm_constantContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_initializer);
		try {
			setState(2284);
			switch (_input.LA(1)) {
			case 41:
				enterOuterAlt(_localctx, 1);
				{
				setState(2274); match(41);
				((InitializerContext)_localctx).constant =  valueFactory.createConstantValue(SimpleConstantValue.nullConst, "null");
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 2);
				{
				setState(2276); match(15);
				setState(2277); ((InitializerContext)_localctx).STRING = match(STRING);
				((InitializerContext)_localctx).constant =  valueFactory.createConstantValue(SimpleConstantValue.nullConst, (((InitializerContext)_localctx).STRING!=null?((InitializerContext)_localctx).STRING.getText():null));
				}
				break;
			case 1:
			case 3:
			case 31:
			case 40:
			case 45:
			case 54:
			case INTEGER:
			case BOOLEAN:
			case FLOATING_POINT:
			case HEX:
			case BINARY_OP:
			case CONVERSION_OP:
			case NULL:
			case UNDEF:
				enterOuterAlt(_localctx, 3);
				{
				setState(2279); ((InitializerContext)_localctx).llvm_constant = llvm_constant();
				((InitializerContext)_localctx).constant =  ((InitializerContext)_localctx).llvm_constant.constant;
				}
				break;
			case GLOBAL_VARIABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(2282); ((InitializerContext)_localctx).GLOBAL_VARIABLE = match(GLOBAL_VARIABLE);
				((InitializerContext)_localctx).constant =  valueFactory.createVariable((((InitializerContext)_localctx).GLOBAL_VARIABLE!=null?((InitializerContext)_localctx).GLOBAL_VARIABLE.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexContext extends ParserRuleContext {
		public Constant expr;
		public Token INTEGER;
		public VariableContext variable;
		public TerminalNode INTEGER() { return getToken(LLVMParser.INTEGER, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitIndex(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_index);
		try {
			setState(2291);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2286); ((IndexContext)_localctx).INTEGER = match(INTEGER);
				((IndexContext)_localctx).expr =  valueFactory.createConstantValue(SimpleConstantValue.intConst, (((IndexContext)_localctx).INTEGER!=null?((IndexContext)_localctx).INTEGER.getText():null));
				}
				break;
			case LOCAL_VARIABLE:
			case GLOBAL_VARIABLE:
			case UNDEF:
				enterOuterAlt(_localctx, 2);
				{
				setState(2288); ((IndexContext)_localctx).variable = variable();
				((IndexContext)_localctx).expr =  ((IndexContext)_localctx).variable.expr;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Llvm_constantContext extends ParserRuleContext {
		public Constant constant;
		public Getelementptr_exprContext getelementptr_expr;
		public Conversion_exprContext conversion_expr;
		public Binary_exprContext binary_expr;
		public Cmp_exprContext cmp_expr;
		public Complex_constantContext complex_constant;
		public Simple_constantContext simple_constant;
		public Undef_constantContext undef_constant;
		public Undef_constantContext undef_constant() {
			return getRuleContext(Undef_constantContext.class,0);
		}
		public Complex_constantContext complex_constant() {
			return getRuleContext(Complex_constantContext.class,0);
		}
		public Binary_exprContext binary_expr() {
			return getRuleContext(Binary_exprContext.class,0);
		}
		public Conversion_exprContext conversion_expr() {
			return getRuleContext(Conversion_exprContext.class,0);
		}
		public Simple_constantContext simple_constant() {
			return getRuleContext(Simple_constantContext.class,0);
		}
		public Getelementptr_exprContext getelementptr_expr() {
			return getRuleContext(Getelementptr_exprContext.class,0);
		}
		public Cmp_exprContext cmp_expr() {
			return getRuleContext(Cmp_exprContext.class,0);
		}
		public Llvm_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llvm_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterLlvm_constant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitLlvm_constant(this);
		}
	}

	public final Llvm_constantContext llvm_constant() throws RecognitionException {
		Llvm_constantContext _localctx = new Llvm_constantContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_llvm_constant);
		try {
			setState(2314);
			switch (_input.LA(1)) {
			case 31:
				enterOuterAlt(_localctx, 1);
				{
				setState(2293); ((Llvm_constantContext)_localctx).getelementptr_expr = getelementptr_expr();
				((Llvm_constantContext)_localctx).constant =  ((Llvm_constantContext)_localctx).getelementptr_expr.expr;
				}
				break;
			case CONVERSION_OP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2296); ((Llvm_constantContext)_localctx).conversion_expr = conversion_expr();
				((Llvm_constantContext)_localctx).constant =  ((Llvm_constantContext)_localctx).conversion_expr.expr;
				}
				break;
			case BINARY_OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(2299); ((Llvm_constantContext)_localctx).binary_expr = binary_expr();
				((Llvm_constantContext)_localctx).constant =  ((Llvm_constantContext)_localctx).binary_expr.expr;
				}
				break;
			case 45:
			case 54:
				enterOuterAlt(_localctx, 4);
				{
				setState(2302); ((Llvm_constantContext)_localctx).cmp_expr = cmp_expr();
				((Llvm_constantContext)_localctx).constant =  ((Llvm_constantContext)_localctx).cmp_expr.expr;
				}
				break;
			case 1:
			case 3:
			case 40:
				enterOuterAlt(_localctx, 5);
				{
				setState(2305); ((Llvm_constantContext)_localctx).complex_constant = complex_constant();
				((Llvm_constantContext)_localctx).constant =  ((Llvm_constantContext)_localctx).complex_constant.constant;
				}
				break;
			case INTEGER:
			case BOOLEAN:
			case FLOATING_POINT:
			case HEX:
			case NULL:
				enterOuterAlt(_localctx, 6);
				{
				setState(2308); ((Llvm_constantContext)_localctx).simple_constant = simple_constant();
				((Llvm_constantContext)_localctx).constant =  ((Llvm_constantContext)_localctx).simple_constant.constant;
				}
				break;
			case UNDEF:
				enterOuterAlt(_localctx, 7);
				{
				setState(2311); ((Llvm_constantContext)_localctx).undef_constant = undef_constant();
				((Llvm_constantContext)_localctx).constant =  ((Llvm_constantContext)_localctx).undef_constant.constant;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simple_constantContext extends ParserRuleContext {
		public Constant constant;
		public Token INTEGER;
		public Token HEX;
		public Token BOOLEAN;
		public Token FLOATING_POINT;
		public Token NULL;
		public TerminalNode INTEGER() { return getToken(LLVMParser.INTEGER, 0); }
		public TerminalNode BOOLEAN() { return getToken(LLVMParser.BOOLEAN, 0); }
		public TerminalNode HEX() { return getToken(LLVMParser.HEX, 0); }
		public TerminalNode NULL() { return getToken(LLVMParser.NULL, 0); }
		public TerminalNode FLOATING_POINT() { return getToken(LLVMParser.FLOATING_POINT, 0); }
		public Simple_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterSimple_constant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitSimple_constant(this);
		}
	}

	public final Simple_constantContext simple_constant() throws RecognitionException {
		Simple_constantContext _localctx = new Simple_constantContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_simple_constant);
		try {
			setState(2326);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2316); ((Simple_constantContext)_localctx).INTEGER = match(INTEGER);
				((Simple_constantContext)_localctx).constant =  valueFactory.createConstantValue(SimpleConstantValue.intConst, (((Simple_constantContext)_localctx).INTEGER!=null?((Simple_constantContext)_localctx).INTEGER.getText():null));
				}
				break;
			case HEX:
				enterOuterAlt(_localctx, 2);
				{
				setState(2318); ((Simple_constantContext)_localctx).HEX = match(HEX);
				((Simple_constantContext)_localctx).constant =  valueFactory.createConstantValue(SimpleConstantValue.hexConst, (((Simple_constantContext)_localctx).HEX!=null?((Simple_constantContext)_localctx).HEX.getText():null));
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2320); ((Simple_constantContext)_localctx).BOOLEAN = match(BOOLEAN);
				((Simple_constantContext)_localctx).constant =  valueFactory.createConstantValue(SimpleConstantValue.boolConst, (((Simple_constantContext)_localctx).BOOLEAN!=null?((Simple_constantContext)_localctx).BOOLEAN.getText():null));
				}
				break;
			case FLOATING_POINT:
				enterOuterAlt(_localctx, 4);
				{
				setState(2322); ((Simple_constantContext)_localctx).FLOATING_POINT = match(FLOATING_POINT);
				((Simple_constantContext)_localctx).constant =  valueFactory.createConstantValue(SimpleConstantValue.floatConst, (((Simple_constantContext)_localctx).FLOATING_POINT!=null?((Simple_constantContext)_localctx).FLOATING_POINT.getText():null));
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(2324); ((Simple_constantContext)_localctx).NULL = match(NULL);
				((Simple_constantContext)_localctx).constant =  valueFactory.createConstantValue(SimpleConstantValue.nullConst, (((Simple_constantContext)_localctx).NULL!=null?((Simple_constantContext)_localctx).NULL.getText():null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Complex_constantContext extends ParserRuleContext {
		public Constant constant;
		public Structure_constantContext structure_constant;
		public Array_constantContext array_constant;
		public Vector_constantContext vector_constant;
		public Array_constantContext array_constant() {
			return getRuleContext(Array_constantContext.class,0);
		}
		public Vector_constantContext vector_constant() {
			return getRuleContext(Vector_constantContext.class,0);
		}
		public Structure_constantContext structure_constant() {
			return getRuleContext(Structure_constantContext.class,0);
		}
		public Complex_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complex_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterComplex_constant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitComplex_constant(this);
		}
	}

	public final Complex_constantContext complex_constant() throws RecognitionException {
		Complex_constantContext _localctx = new Complex_constantContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_complex_constant);
		try {
			setState(2337);
			switch (_input.LA(1)) {
			case 40:
				enterOuterAlt(_localctx, 1);
				{
				setState(2328); ((Complex_constantContext)_localctx).structure_constant = structure_constant();
				((Complex_constantContext)_localctx).constant =  valueFactory.createConstantValue(ComplexConstantValue.structure, (((Complex_constantContext)_localctx).structure_constant!=null?_input.getText(((Complex_constantContext)_localctx).structure_constant.start,((Complex_constantContext)_localctx).structure_constant.stop):null));
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 2);
				{
				setState(2331); ((Complex_constantContext)_localctx).array_constant = array_constant();
				((Complex_constantContext)_localctx).constant =  valueFactory.createConstantValue(ComplexConstantValue.array, (((Complex_constantContext)_localctx).array_constant!=null?_input.getText(((Complex_constantContext)_localctx).array_constant.start,((Complex_constantContext)_localctx).array_constant.stop):null));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2334); ((Complex_constantContext)_localctx).vector_constant = vector_constant();
				((Complex_constantContext)_localctx).constant =  valueFactory.createConstantValue(ComplexConstantValue.vector, (((Complex_constantContext)_localctx).vector_constant!=null?_input.getText(((Complex_constantContext)_localctx).vector_constant.start,((Complex_constantContext)_localctx).vector_constant.stop):null));
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constant_listContext extends ParserRuleContext {
		public List<Derived_typeContext> derived_type() {
			return getRuleContexts(Derived_typeContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public Derived_typeContext derived_type(int i) {
			return getRuleContext(Derived_typeContext.class,i);
		}
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public Constant_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterConstant_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitConstant_list(this);
		}
	}

	public final Constant_listContext constant_list() throws RecognitionException {
		Constant_listContext _localctx = new Constant_listContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_constant_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2339); derived_type();
			setState(2340); initializer();
			setState(2347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==35) {
				{
				{
				setState(2341); match(35);
				setState(2342); derived_type();
				setState(2343); initializer();
				}
				}
				setState(2349);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Structure_constantContext extends ParserRuleContext {
		public Constant_listContext constant_list() {
			return getRuleContext(Constant_listContext.class,0);
		}
		public Structure_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterStructure_constant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitStructure_constant(this);
		}
	}

	public final Structure_constantContext structure_constant() throws RecognitionException {
		Structure_constantContext _localctx = new Structure_constantContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_structure_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2350); match(40);
			setState(2351); constant_list();
			setState(2352); match(9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_constantContext extends ParserRuleContext {
		public Constant_listContext constant_list() {
			return getRuleContext(Constant_listContext.class,0);
		}
		public Array_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterArray_constant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitArray_constant(this);
		}
	}

	public final Array_constantContext array_constant() throws RecognitionException {
		Array_constantContext _localctx = new Array_constantContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_array_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2354); match(1);
			setState(2355); constant_list();
			setState(2356); match(32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vector_constantContext extends ParserRuleContext {
		public Constant_listContext constant_list() {
			return getRuleContext(Constant_listContext.class,0);
		}
		public Vector_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterVector_constant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitVector_constant(this);
		}
	}

	public final Vector_constantContext vector_constant() throws RecognitionException {
		Vector_constantContext _localctx = new Vector_constantContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_vector_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2358); match(3);
			setState(2359); constant_list();
			setState(2360); match(49);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Undef_constantContext extends ParserRuleContext {
		public Constant constant;
		public Undef_constantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_undef_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterUndef_constant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitUndef_constant(this);
		}
	}

	public final Undef_constantContext undef_constant() throws RecognitionException {
		Undef_constantContext _localctx = new Undef_constantContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_undef_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2362); match(UNDEF);
			 ((Undef_constantContext)_localctx).constant =  valueFactory.createVariable("undef"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_nameContext extends ParserRuleContext {
		public Constant expr;
		public Token GLOBAL_VARIABLE;
		public Token LOCAL_VARIABLE;
		public Assembly_exprContext assembly_expr;
		public Assembly_exprContext assembly_expr() {
			return getRuleContext(Assembly_exprContext.class,0);
		}
		public TerminalNode LOCAL_VARIABLE() { return getToken(LLVMParser.LOCAL_VARIABLE, 0); }
		public TerminalNode GLOBAL_VARIABLE() { return getToken(LLVMParser.GLOBAL_VARIABLE, 0); }
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitFunction_name(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_function_name);

		String name=null;

		try {
			setState(2372);
			switch (_input.LA(1)) {
			case GLOBAL_VARIABLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2365); ((Function_nameContext)_localctx).GLOBAL_VARIABLE = match(GLOBAL_VARIABLE);
				name = (((Function_nameContext)_localctx).GLOBAL_VARIABLE!=null?((Function_nameContext)_localctx).GLOBAL_VARIABLE.getText():null);
				}
				break;
			case LOCAL_VARIABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2367); ((Function_nameContext)_localctx).LOCAL_VARIABLE = match(LOCAL_VARIABLE);
				name = (((Function_nameContext)_localctx).LOCAL_VARIABLE!=null?((Function_nameContext)_localctx).LOCAL_VARIABLE.getText():null);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 3);
				{
				setState(2369); ((Function_nameContext)_localctx).assembly_expr = assembly_expr();
				name = (((Function_nameContext)_localctx).assembly_expr!=null?_input.getText(((Function_nameContext)_localctx).assembly_expr.start,((Function_nameContext)_localctx).assembly_expr.stop):null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			((Function_nameContext)_localctx).expr =  valueFactory.createVariable(name);

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assembly_exprContext extends ParserRuleContext {
		public TerminalNode STRING(int i) {
			return getToken(LLVMParser.STRING, i);
		}
		public List<TerminalNode> STRING() { return getTokens(LLVMParser.STRING); }
		public Assembly_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).enterAssembly_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LLVMListener ) ((LLVMListener)listener).exitAssembly_expr(this);
		}
	}

	public final Assembly_exprContext assembly_expr() throws RecognitionException {
		Assembly_exprContext _localctx = new Assembly_exprContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_assembly_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2374); match(5);
			setState(2376);
			_la = _input.LA(1);
			if (_la==6) {
				{
				setState(2375); match(6);
				}
			}

			setState(2379);
			_la = _input.LA(1);
			if (_la==47) {
				{
				setState(2378); match(47);
				}
			}

			setState(2381); match(STRING);
			setState(2382); match(35);
			setState(2383); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3_\u0954\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\3\2\7\2\u0090\n\2\f\2\16\2\u0093\13\2\3\2\3\2\7\2\u0097\n\2\f"+
		"\2\16\2\u009a\13\2\3\2\3\2\3\2\7\2\u009f\n\2\f\2\16\2\u00a2\13\2\3\2\3"+
		"\2\3\2\7\2\u00a7\n\2\f\2\16\2\u00aa\13\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\6"+
		"\2\u00b3\n\2\r\2\16\2\u00b4\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6\u00cd\n\6\3\6\5\6\u00d0"+
		"\n\6\3\6\3\6\5\6\u00d4\n\6\3\6\5\6\u00d7\n\6\3\6\3\6\3\6\5\6\u00dc\n\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00e6\n\6\3\6\3\6\3\6\3\6\5\6\u00ec"+
		"\n\6\5\6\u00ee\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00f6\n\7\3\7\3\7\5\7\u00fa"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\b\u0104\n\b\3\b\3\b\5\b\u0108\n"+
		"\b\3\b\3\b\5\b\u010c\n\b\3\b\3\b\7\b\u0110\n\b\f\b\16\b\u0113\13\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u011e\n\b\3\b\3\b\7\b\u0122\n\b\f"+
		"\b\16\b\u0125\13\b\3\t\3\t\3\t\5\t\u012a\n\t\3\t\3\t\5\t\u012e\n\t\3\t"+
		"\3\t\5\t\u0132\n\t\3\t\3\t\7\t\u0136\n\t\f\t\16\t\u0139\13\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0146\n\t\f\t\16\t\u0149\13\t\3"+
		"\t\3\t\3\t\5\t\u014e\n\t\3\t\3\t\3\t\3\t\6\t\u0154\n\t\r\t\16\t\u0155"+
		"\3\t\3\t\3\n\3\n\5\n\u015c\n\n\3\n\3\n\3\n\7\n\u0161\n\n\f\n\16\n\u0164"+
		"\13\n\3\n\3\n\3\n\7\n\u0169\n\n\f\n\16\n\u016c\13\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0181"+
		"\n\r\3\r\3\r\5\r\u0185\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u0194\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\7\r\u01a3\n\r\f\r\16\r\u01a6\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\7\r\u01b5\n\r\f\r\16\r\u01b8\13\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u01c0\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u01cc"+
		"\n\r\5\r\u01ce\n\r\3\r\5\r\u01d1\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u01f2\n\17\3\17"+
		"\5\17\u01f5\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01fe\n\20\3"+
		"\20\3\20\5\20\u0202\n\20\3\20\3\20\5\20\u0206\n\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u020e\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u023d\n\21\f\21\16\21\u0240"+
		"\13\21\3\21\3\21\5\21\u0244\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\7\22\u0253\n\22\f\22\16\22\u0256\13\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0262\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0270\n\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u027c\n\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0282\n\24\3\25\3\25\3\25\3\25\3\25\5\25\u0289\n"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0293\n\25\3\26\3\26"+
		"\5\26\u0297\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u02a6\n\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u02ae\n"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\6\27\u02b8\n\27\r\27\16\27"+
		"\u02b9\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u02cd\n\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u02d5\n\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u02e6\n\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u02ee"+
		"\n\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33"+
		"\u030a\n\33\f\33\16\33\u030d\13\33\3\33\5\33\u0310\n\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\5\35\u0323\n\35\3\35\3\35\5\35\u0327\n\35\3\35\3\35\3\35\3\36\3\36\5"+
		"\36\u032e\n\36\3\36\3\36\7\36\u0332\n\36\f\36\16\36\u0335\13\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0340\n\36\f\36\16\36\u0343"+
		"\13\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u034b\n\37\f\37\16\37\u034e"+
		"\13\37\3\37\3\37\3\37\5\37\u0353\n\37\3\37\3\37\3\37\5\37\u0358\n\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\7\37\u0360\n\37\f\37\16\37\u0363\13\37\3"+
		"\37\3\37\3\37\5\37\u0368\n\37\3\37\3\37\3\37\5\37\u036d\n\37\3\37\3\37"+
		"\7\37\u0371\n\37\f\37\16\37\u0374\13\37\3\37\3\37\3\37\5\37\u0379\n\37"+
		"\5\37\u037b\n\37\5\37\u037d\n\37\3 \3 \3 \3 \3 \3 \5 \u0385\n \3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u039c\n!\3"+
		"\"\3\"\3\"\5\"\u03a1\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\6\"\u03ac"+
		"\n\"\r\"\16\"\u03ad\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\5$"+
		"\u03bf\n$\3$\3$\5$\u03c3\n$\3$\3$\5$\u03c7\n$\3$\3$\3$\3$\3$\3$\3$\5$"+
		"\u03d0\n$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u03db\n$\3$\3$\3$\3$\3%\3%\3%"+
		"\3%\3%\5%\u03e6\n%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u03f0\n%\5%\u03f2\n%\3%"+
		"\3%\3%\3%\3%\3%\3%\5%\u03fb\n%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0406\n%"+
		"\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\5(\u041a\n("+
		"\3(\3(\3(\5(\u041f\n(\3)\3)\3)\7)\u0424\n)\f)\16)\u0427\13)\3*\3*\3*\3"+
		"*\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0439\n,\3-\3-\3-\3-\7-\u043f"+
		"\n-\f-\16-\u0442\13-\3-\3-\3-\3-\6-\u0448\n-\r-\16-\u0449\7-\u044c\n-"+
		"\f-\16-\u044f\13-\3-\3-\3-\3-\6-\u0455\n-\r-\16-\u0456\3-\3-\3-\3-\6-"+
		"\u045d\n-\r-\16-\u045e\7-\u0461\n-\f-\16-\u0464\13-\3-\3-\3-\3-\6-\u046a"+
		"\n-\r-\16-\u046b\6-\u046e\n-\r-\16-\u046f\5-\u0472\n-\3-\3-\3-\3-\6-\u0478"+
		"\n-\r-\16-\u0479\3-\3-\3-\3-\6-\u0480\n-\r-\16-\u0481\7-\u0484\n-\f-\16"+
		"-\u0487\13-\3-\3-\3-\3-\6-\u048d\n-\r-\16-\u048e\6-\u0491\n-\r-\16-\u0492"+
		"\5-\u0495\n-\3-\3-\3-\3-\6-\u049b\n-\r-\16-\u049c\3-\3-\3-\3-\6-\u04a3"+
		"\n-\r-\16-\u04a4\7-\u04a7\n-\f-\16-\u04aa\13-\3-\3-\3-\3-\6-\u04b0\n-"+
		"\r-\16-\u04b1\3-\3-\3-\3-\6-\u04b8\n-\r-\16-\u04b9\7-\u04bc\n-\f-\16-"+
		"\u04bf\13-\3-\3-\3-\3-\6-\u04c5\n-\r-\16-\u04c6\3-\3-\3-\3-\6-\u04cd\n"+
		"-\r-\16-\u04ce\7-\u04d1\n-\f-\16-\u04d4\13-\3-\3-\3-\3-\3-\3-\6-\u04dc"+
		"\n-\r-\16-\u04dd\6-\u04e0\n-\r-\16-\u04e1\5-\u04e4\n-\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\5.\u04ef\n.\3/\3/\3/\3/\7/\u04f5\n/\f/\16/\u04f8\13/\3/\3/"+
		"\3/\3/\6/\u04fe\n/\r/\16/\u04ff\7/\u0502\n/\f/\16/\u0505\13/\3/\3/\3/"+
		"\3/\7/\u050b\n/\f/\16/\u050e\13/\3/\3/\3/\3/\6/\u0514\n/\r/\16/\u0515"+
		"\7/\u0518\n/\f/\16/\u051b\13/\3/\3/\3/\3/\7/\u0521\n/\f/\16/\u0524\13"+
		"/\3/\3/\3/\3/\6/\u052a\n/\r/\16/\u052b\7/\u052e\n/\f/\16/\u0531\13/\3"+
		"/\3/\3/\3/\6/\u0537\n/\r/\16/\u0538\3/\3/\3/\3/\6/\u053f\n/\r/\16/\u0540"+
		"\7/\u0543\n/\f/\16/\u0546\13/\3/\3/\3/\3/\6/\u054c\n/\r/\16/\u054d\3/"+
		"\3/\3/\3/\6/\u0554\n/\r/\16/\u0555\7/\u0558\n/\f/\16/\u055b\13/\5/\u055d"+
		"\n/\3/\3/\3/\3/\6/\u0563\n/\r/\16/\u0564\3/\3/\3/\3/\6/\u056b\n/\r/\16"+
		"/\u056c\7/\u056f\n/\f/\16/\u0572\13/\5/\u0574\n/\3/\3/\3/\3/\3/\3/\6/"+
		"\u057c\n/\r/\16/\u057d\6/\u0580\n/\r/\16/\u0581\3/\3/\3/\3/\5/\u0588\n"+
		"/\3\60\3\60\3\60\3\60\7\60\u058e\n\60\f\60\16\60\u0591\13\60\3\60\3\60"+
		"\3\60\3\60\6\60\u0597\n\60\r\60\16\60\u0598\3\60\3\60\3\60\7\60\u059e"+
		"\n\60\f\60\16\60\u05a1\13\60\3\60\3\60\7\60\u05a5\n\60\f\60\16\60\u05a8"+
		"\13\60\5\60\u05aa\n\60\3\60\3\60\3\60\3\60\7\60\u05b0\n\60\f\60\16\60"+
		"\u05b3\13\60\3\60\3\60\3\60\3\60\6\60\u05b9\n\60\r\60\16\60\u05ba\3\60"+
		"\3\60\3\60\7\60\u05c0\n\60\f\60\16\60\u05c3\13\60\3\60\3\60\7\60\u05c7"+
		"\n\60\f\60\16\60\u05ca\13\60\5\60\u05cc\n\60\3\60\3\60\3\60\3\60\7\60"+
		"\u05d2\n\60\f\60\16\60\u05d5\13\60\3\60\3\60\3\60\3\60\6\60\u05db\n\60"+
		"\r\60\16\60\u05dc\3\60\3\60\3\60\7\60\u05e2\n\60\f\60\16\60\u05e5\13\60"+
		"\3\60\3\60\7\60\u05e9\n\60\f\60\16\60\u05ec\13\60\5\60\u05ee\n\60\3\60"+
		"\3\60\3\60\3\60\6\60\u05f4\n\60\r\60\16\60\u05f5\3\60\3\60\3\60\3\60\6"+
		"\60\u05fc\n\60\r\60\16\60\u05fd\3\60\3\60\3\60\7\60\u0603\n\60\f\60\16"+
		"\60\u0606\13\60\3\60\3\60\7\60\u060a\n\60\f\60\16\60\u060d\13\60\5\60"+
		"\u060f\n\60\5\60\u0611\n\60\3\60\3\60\3\60\3\60\6\60\u0617\n\60\r\60\16"+
		"\60\u0618\3\60\3\60\3\60\3\60\6\60\u061f\n\60\r\60\16\60\u0620\3\60\3"+
		"\60\3\60\7\60\u0626\n\60\f\60\16\60\u0629\13\60\3\60\3\60\7\60\u062d\n"+
		"\60\f\60\16\60\u0630\13\60\5\60\u0632\n\60\5\60\u0634\n\60\3\60\3\60\3"+
		"\60\3\60\6\60\u063a\n\60\r\60\16\60\u063b\3\60\3\60\3\60\3\60\6\60\u0642"+
		"\n\60\r\60\16\60\u0643\3\60\3\60\3\60\7\60\u0649\n\60\f\60\16\60\u064c"+
		"\13\60\3\60\3\60\7\60\u0650\n\60\f\60\16\60\u0653\13\60\5\60\u0655\n\60"+
		"\5\60\u0657\n\60\3\60\3\60\3\60\3\60\3\60\3\60\6\60\u065f\n\60\r\60\16"+
		"\60\u0660\3\60\3\60\3\60\7\60\u0666\n\60\f\60\16\60\u0669\13\60\3\60\3"+
		"\60\7\60\u066d\n\60\f\60\16\60\u0670\13\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\5\60\u0678\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\5\61\u0686\n\61\3\62\3\62\3\62\3\62\7\62\u068c\n\62\f\62\16"+
		"\62\u068f\13\62\3\62\3\62\3\62\3\62\6\62\u0695\n\62\r\62\16\62\u0696\3"+
		"\62\3\62\3\62\7\62\u069c\n\62\f\62\16\62\u069f\13\62\5\62\u06a1\n\62\3"+
		"\62\3\62\3\62\3\62\7\62\u06a7\n\62\f\62\16\62\u06aa\13\62\3\62\3\62\3"+
		"\62\3\62\6\62\u06b0\n\62\r\62\16\62\u06b1\3\62\3\62\3\62\7\62\u06b7\n"+
		"\62\f\62\16\62\u06ba\13\62\5\62\u06bc\n\62\3\62\3\62\3\62\3\62\7\62\u06c2"+
		"\n\62\f\62\16\62\u06c5\13\62\3\62\3\62\3\62\3\62\6\62\u06cb\n\62\r\62"+
		"\16\62\u06cc\3\62\3\62\3\62\7\62\u06d2\n\62\f\62\16\62\u06d5\13\62\5\62"+
		"\u06d7\n\62\3\62\3\62\3\62\3\62\7\62\u06dd\n\62\f\62\16\62\u06e0\13\62"+
		"\3\62\3\62\3\62\3\62\6\62\u06e6\n\62\r\62\16\62\u06e7\3\62\3\62\3\62\7"+
		"\62\u06ed\n\62\f\62\16\62\u06f0\13\62\5\62\u06f2\n\62\3\62\3\62\3\62\3"+
		"\62\7\62\u06f8\n\62\f\62\16\62\u06fb\13\62\3\62\3\62\3\62\3\62\6\62\u0701"+
		"\n\62\r\62\16\62\u0702\3\62\3\62\3\62\7\62\u0708\n\62\f\62\16\62\u070b"+
		"\13\62\5\62\u070d\n\62\3\62\3\62\3\62\3\62\7\62\u0713\n\62\f\62\16\62"+
		"\u0716\13\62\3\62\3\62\3\62\3\62\6\62\u071c\n\62\r\62\16\62\u071d\3\62"+
		"\3\62\3\62\7\62\u0723\n\62\f\62\16\62\u0726\13\62\5\62\u0728\n\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\6\62\u0730\n\62\r\62\16\62\u0731\3\62\3\62\3"+
		"\62\7\62\u0737\n\62\f\62\16\62\u073a\13\62\5\62\u073c\n\62\3\62\3\62\6"+
		"\62\u0740\n\62\r\62\16\62\u0741\3\63\3\63\3\63\3\63\5\63\u0748\n\63\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\5\64\u0752\n\64\3\64\3\64\3\64"+
		"\3\64\3\65\3\65\3\65\3\65\3\65\5\65\u075d\n\65\3\65\3\65\3\65\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\7\66\u0768\n\66\f\66\16\66\u076b\13\66\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\39\39\39\39\79\u077f\n"+
		"9\f9\169\u0782\139\39\39\39\39\69\u0788\n9\r9\169\u0789\79\u078c\n9\f"+
		"9\169\u078f\139\39\39\39\39\69\u0795\n9\r9\169\u0796\39\39\39\39\69\u079d"+
		"\n9\r9\169\u079e\79\u07a1\n9\f9\169\u07a4\139\39\39\39\39\69\u07aa\n9"+
		"\r9\169\u07ab\69\u07ae\n9\r9\169\u07af\59\u07b2\n9\39\39\39\39\69\u07b8"+
		"\n9\r9\169\u07b9\39\39\39\39\69\u07c0\n9\r9\169\u07c1\79\u07c4\n9\f9\16"+
		"9\u07c7\139\39\39\39\39\69\u07cd\n9\r9\169\u07ce\69\u07d1\n9\r9\169\u07d2"+
		"\59\u07d5\n9\39\39\39\39\69\u07db\n9\r9\169\u07dc\39\39\39\39\69\u07e3"+
		"\n9\r9\169\u07e4\79\u07e7\n9\f9\169\u07ea\139\39\39\39\39\69\u07f0\n9"+
		"\r9\169\u07f1\39\39\39\39\69\u07f8\n9\r9\169\u07f9\79\u07fc\n9\f9\169"+
		"\u07ff\139\39\39\39\39\69\u0805\n9\r9\169\u0806\39\39\39\39\69\u080d\n"+
		"9\r9\169\u080e\79\u0811\n9\f9\169\u0814\139\39\39\39\39\39\39\69\u081c"+
		"\n9\r9\169\u081d\79\u0820\n9\f9\169\u0823\139\59\u0825\n9\3:\3:\3:\3:"+
		"\7:\u082b\n:\f:\16:\u082e\13:\3:\3:\3:\3:\6:\u0834\n:\r:\16:\u0835\3:"+
		"\3:\3:\7:\u083b\n:\f:\16:\u083e\13:\3:\3:\3:\3:\7:\u0844\n:\f:\16:\u0847"+
		"\13:\3:\3:\3:\3:\6:\u084d\n:\r:\16:\u084e\3:\3:\3:\7:\u0854\n:\f:\16:"+
		"\u0857\13:\3:\3:\3:\3:\7:\u085d\n:\f:\16:\u0860\13:\3:\3:\3:\3:\6:\u0866"+
		"\n:\r:\16:\u0867\3:\3:\3:\7:\u086d\n:\f:\16:\u0870\13:\3:\3:\3:\3:\6:"+
		"\u0876\n:\r:\16:\u0877\3:\3:\3:\3:\6:\u087e\n:\r:\16:\u087f\3:\3:\3:\7"+
		":\u0885\n:\f:\16:\u0888\13:\3:\3:\3:\3:\6:\u088e\n:\r:\16:\u088f\3:\3"+
		":\3:\3:\6:\u0896\n:\r:\16:\u0897\3:\3:\3:\7:\u089d\n:\f:\16:\u08a0\13"+
		":\3:\3:\3:\3:\6:\u08a6\n:\r:\16:\u08a7\3:\3:\3:\3:\6:\u08ae\n:\r:\16:"+
		"\u08af\3:\3:\3:\7:\u08b5\n:\f:\16:\u08b8\13:\3:\3:\3:\3:\3:\3:\6:\u08c0"+
		"\n:\r:\16:\u08c1\3:\3:\3:\7:\u08c7\n:\f:\16:\u08ca\13:\5:\u08cc\n:\3;"+
		"\3;\3;\3;\3;\3;\3;\3;\3;\7;\u08d7\n;\f;\16;\u08da\13;\3;\3;\3;\5;\u08df"+
		"\n;\5;\u08e1\n;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u08ef\n<\3=\3="+
		"\3=\3=\3=\5=\u08f6\n=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>"+
		"\3>\3>\3>\3>\3>\5>\u090d\n>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?\5?\u0919\n?"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u0924\n@\3A\3A\3A\3A\3A\3A\7A\u092c\nA"+
		"\fA\16A\u092f\13A\3B\3B\3B\3B\3C\3C\3C\3C\3D\3D\3D\3D\3E\3E\3E\3F\3F\3"+
		"F\3F\3F\3F\3F\5F\u0947\nF\3G\3G\5G\u094b\nG\3G\5G\u094e\nG\3G\3G\3G\3"+
		"G\3G\2H\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:"+
		"<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a"+
		"\u008c\2\4\4  \65\65\4AA]]\u0a77\2\u0091\3\2\2\2\4\u00b8\3\2\2\2\6\u00bd"+
		"\3\2\2\2\b\u00c1\3\2\2\2\n\u00c7\3\2\2\2\f\u00ef\3\2\2\2\16\u0100\3\2"+
		"\2\2\20\u0126\3\2\2\2\22\u015b\3\2\2\2\24\u0170\3\2\2\2\26\u0174\3\2\2"+
		"\2\30\u01cd\3\2\2\2\32\u01d2\3\2\2\2\34\u01f1\3\2\2\2\36\u01f6\3\2\2\2"+
		" \u0215\3\2\2\2\"\u0245\3\2\2\2$\u026f\3\2\2\2&\u0271\3\2\2\2(\u0283\3"+
		"\2\2\2*\u0296\3\2\2\2,\u02a7\3\2\2\2.\u02bb\3\2\2\2\60\u02c4\3\2\2\2\62"+
		"\u02db\3\2\2\2\64\u02f4\3\2\2\2\66\u0311\3\2\2\28\u0322\3\2\2\2:\u032d"+
		"\3\2\2\2<\u037c\3\2\2\2>\u0384\3\2\2\2@\u039b\3\2\2\2B\u039d\3\2\2\2D"+
		"\u03b1\3\2\2\2F\u03ba\3\2\2\2H\u03f1\3\2\2\2J\u040b\3\2\2\2L\u040f\3\2"+
		"\2\2N\u041e\3\2\2\2P\u0420\3\2\2\2R\u0428\3\2\2\2T\u042c\3\2\2\2V\u0438"+
		"\3\2\2\2X\u04e3\3\2\2\2Z\u04ee\3\2\2\2\\\u0587\3\2\2\2^\u0677\3\2\2\2"+
		"`\u0685\3\2\2\2b\u073b\3\2\2\2d\u0743\3\2\2\2f\u074c\3\2\2\2h\u0757\3"+
		"\2\2\2j\u0761\3\2\2\2l\u076c\3\2\2\2n\u0773\3\2\2\2p\u0824\3\2\2\2r\u08cb"+
		"\3\2\2\2t\u08cd\3\2\2\2v\u08ee\3\2\2\2x\u08f5\3\2\2\2z\u090c\3\2\2\2|"+
		"\u0918\3\2\2\2~\u0923\3\2\2\2\u0080\u0925\3\2\2\2\u0082\u0930\3\2\2\2"+
		"\u0084\u0934\3\2\2\2\u0086\u0938\3\2\2\2\u0088\u093c\3\2\2\2\u008a\u0946"+
		"\3\2\2\2\u008c\u0948\3\2\2\2\u008e\u0090\5\4\3\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0098\5\6\4\2\u0095\u0097\5\b\5\2\u0096"+
		"\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u00a0\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\5\n\6\2\u009c"+
		"\u009d\b\2\1\2\u009d\u009f\3\2\2\2\u009e\u009b\3\2\2\2\u009f\u00a2\3\2"+
		"\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a8\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\u00a4\5\f\7\2\u00a4\u00a5\b\2\1\2\u00a5\u00a7\3\2"+
		"\2\2\u00a6\u00a3\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00b2\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\5\16"+
		"\b\2\u00ac\u00ad\b\2\1\2\u00ad\u00b3\3\2\2\2\u00ae\u00af\5\20\t\2\u00af"+
		"\u00b0\b\2\1\2\u00b0\u00b3\3\2\2\2\u00b1\u00b3\5J&\2\u00b2\u00ab\3\2\2"+
		"\2\u00b2\u00ae\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\1\2\2\u00b7"+
		"\3\3\2\2\2\u00b8\u00b9\7\16\2\2\u00b9\u00ba\t\2\2\2\u00ba\u00bb\7\24\2"+
		"\2\u00bb\u00bc\7T\2\2\u00bc\5\3\2\2\2\u00bd\u00be\7\25\2\2\u00be\u00bf"+
		"\7\7\2\2\u00bf\u00c0\7T\2\2\u00c0\7\3\2\2\2\u00c1\u00c2\7?\2\2\u00c2\u00c3"+
		"\7\24\2\2\u00c3\u00c4\7\64\2\2\u00c4\u00c5\5^\60\2\u00c5\u00c6\b\5\1\2"+
		"\u00c6\t\3\2\2\2\u00c7\u00c8\7@\2\2\u00c8\u00c9\b\6\1\2\u00c9\u00cc\7"+
		"\24\2\2\u00ca\u00cb\7W\2\2\u00cb\u00cd\b\6\1\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00d0\7X\2\2\u00cf\u00ce\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00d2\7\n\2\2\u00d2"+
		"\u00d4\b\6\1\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2"+
		"\2\2\u00d5\u00d7\7\\\2\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7"+
		"\u00db\3\2\2\2\u00d8\u00dc\7\22\2\2\u00d9\u00da\7.\2\2\u00da\u00dc\b\6"+
		"\1\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00de\5^\60\2\u00de\u00ed\b\6\1\2\u00df\u00e0\5v<\2\u00e0\u00e5\b\6\1"+
		"\2\u00e1\u00e2\7%\2\2\u00e2\u00e3\5\26\f\2\u00e3\u00e4\b\6\1\2\u00e4\u00e6"+
		"\3\2\2\2\u00e5\u00e1\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00eb\3\2\2\2\u00e7"+
		"\u00e8\7%\2\2\u00e8\u00e9\5\24\13\2\u00e9\u00ea\b\6\1\2\u00ea\u00ec\3"+
		"\2\2\2\u00eb\u00e7\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed"+
		"\u00df\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\13\3\2\2\2\u00ef\u00f0\7@\2\2"+
		"\u00f0\u00f1\b\7\1\2\u00f1\u00f2\7\24\2\2\u00f2\u00f5\7\30\2\2\u00f3\u00f4"+
		"\7W\2\2\u00f4\u00f6\b\7\1\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f9\3\2\2\2\u00f7\u00f8\7X\2\2\u00f8\u00fa\b\7\1\2\u00f9\u00f7\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\5^\60\2\u00fc"+
		"\u00fd\b\7\1\2\u00fd\u00fe\7@\2\2\u00fe\u00ff\b\7\1\2\u00ff\r\3\2\2\2"+
		"\u0100\u0103\7:\2\2\u0101\u0102\7W\2\2\u0102\u0104\b\b\1\2\u0103\u0101"+
		"\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0106\7X\2\2\u0106"+
		"\u0108\b\b\1\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010b\3\2"+
		"\2\2\u0109\u010a\7Y\2\2\u010a\u010c\b\b\1\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u0111\3\2\2\2\u010d\u010e\7Z\2\2\u010e\u0110\b\b"+
		"\1\2\u010f\u010d\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\5p"+
		"9\2\u0115\u0116\b\b\1\2\u0116\u0117\7@\2\2\u0117\u0118\b\b\1\2\u0118\u0119"+
		"\7&\2\2\u0119\u011a\5<\37\2\u011a\u011b\b\b\1\2\u011b\u011d\7\20\2\2\u011c"+
		"\u011e\7\\\2\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0123\3\2"+
		"\2\2\u011f\u0120\7[\2\2\u0120\u0122\b\b\1\2\u0121\u011f\3\2\2\2\u0122"+
		"\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\17\3\2\2"+
		"\2\u0125\u0123\3\2\2\2\u0126\u0129\7\60\2\2\u0127\u0128\7W\2\2\u0128\u012a"+
		"\b\t\1\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u012c\7X\2\2\u012c\u012e\b\t\1\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\u0131\3\2\2\2\u012f\u0130\7Y\2\2\u0130\u0132\b\t\1\2\u0131"+
		"\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0137\3\2\2\2\u0133\u0134\7Z"+
		"\2\2\u0134\u0136\b\t\1\2\u0135\u0133\3\2\2\2\u0136\u0139\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u013a\u013b\5p9\2\u013b\u013c\b\t\1\2\u013c\u013d\7@\2\2\u013d\u013e"+
		"\b\t\1\2\u013e\u013f\7&\2\2\u013f\u0140\5<\37\2\u0140\u0141\b\t\1\2\u0141"+
		"\u0147\7\20\2\2\u0142\u0146\7\\\2\2\u0143\u0144\7[\2\2\u0144\u0146\b\t"+
		"\1\2\u0145\u0142\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0149\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014d\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u014a\u014b\5\24\13\2\u014b\u014c\b\t\1\2\u014c\u014e\3\2\2\2\u014d"+
		"\u014a\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0153\7*"+
		"\2\2\u0150\u0151\5\22\n\2\u0151\u0152\b\t\1\2\u0152\u0154\3\2\2\2\u0153"+
		"\u0150\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u0157\3\2\2\2\u0157\u0158\7\13\2\2\u0158\21\3\2\2\2\u0159\u015a"+
		"\7<\2\2\u015a\u015c\b\n\1\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u0162\3\2\2\2\u015d\u015e\5\64\33\2\u015e\u015f\b\n\1\2\u015f\u0161\3"+
		"\2\2\2\u0160\u015d\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u016a\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\5\34"+
		"\17\2\u0166\u0167\b\n\1\2\u0167\u0169\3\2\2\2\u0168\u0165\3\2\2\2\u0169"+
		"\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016d\3\2"+
		"\2\2\u016c\u016a\3\2\2\2\u016d\u016e\5\30\r\2\u016e\u016f\b\n\1\2\u016f"+
		"\23\3\2\2\2\u0170\u0171\7O\2\2\u0171\u0172\7A\2\2\u0172\u0173\b\13\1\2"+
		"\u0173\25\3\2\2\2\u0174\u0175\7N\2\2\u0175\u0176\7T\2\2\u0176\u0177\b"+
		"\f\1\2\u0177\27\3\2\2\2\u0178\u0179\7(\2\2\u0179\u0180\b\r\1\2\u017a\u017b"+
		"\7K\2\2\u017b\u0181\b\r\1\2\u017c\u017d\5p9\2\u017d\u017e\5@!\2\u017e"+
		"\u017f\b\r\1\2\u017f\u0181\3\2\2\2\u0180\u017a\3\2\2\2\u0180\u017c\3\2"+
		"\2\2\u0181\u0185\3\2\2\2\u0182\u0183\7R\2\2\u0183\u0185\b\r\1\2\u0184"+
		"\u0178\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u01ce\3\2\2\2\u0186\u0187\79"+
		"\2\2\u0187\u0193\b\r\1\2\u0188\u0189\5\32\16\2\u0189\u018a\b\r\1\2\u018a"+
		"\u0194\3\2\2\2\u018b\u018c\7=\2\2\u018c\u018d\5@!\2\u018d\u018e\7%\2\2"+
		"\u018e\u018f\5\32\16\2\u018f\u0190\7%\2\2\u0190\u0191\5\32\16\2\u0191"+
		"\u0192\b\r\1\2\u0192\u0194\3\2\2\2\u0193\u0188\3\2\2\2\u0193\u018b\3\2"+
		"\2\2\u0194\u01cc\3\2\2\2\u0195\u0196\7\67\2\2\u0196\u0197\7>\2\2\u0197"+
		"\u0198\5@!\2\u0198\u0199\7%\2\2\u0199\u019a\5\32\16\2\u019a\u019b\b\r"+
		"\1\2\u019b\u01a4\7\3\2\2\u019c\u019d\7>\2\2\u019d\u019e\7A\2\2\u019e\u019f"+
		"\7%\2\2\u019f\u01a0\5\32\16\2\u01a0\u01a1\b\r\1\2\u01a1\u01a3\3\2\2\2"+
		"\u01a2\u019c\3\2\2\2\u01a3\u01a6\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5"+
		"\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a7\u01a8\7\"\2\2\u01a8"+
		"\u01cc\3\2\2\2\u01a9\u01aa\7\62\2\2\u01aa\u01ab\5b\62\2\u01ab\u01ac\5"+
		"@!\2\u01ac\u01ad\7%\2\2\u01ad\u01ae\7\3\2\2\u01ae\u01af\5\32\16\2\u01af"+
		"\u01b6\b\r\1\2\u01b0\u01b1\7%\2\2\u01b1\u01b2\5\32\16\2\u01b2\u01b3\b"+
		"\r\1\2\u01b3\u01b5\3\2\2\2\u01b4\u01b0\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b6\3\2"+
		"\2\2\u01b9\u01ba\7\"\2\2\u01ba\u01cc\3\2\2\2\u01bb\u01bc\5> \2\u01bc\u01bd"+
		"\7\24\2\2\u01bd\u01be\b\r\1\2\u01be\u01c0\3\2\2\2\u01bf\u01bb\3\2\2\2"+
		"\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\7\35\2\2\u01c2\u01c3"+
		"\5:\36\2\u01c3\u01c4\7Q\2\2\u01c4\u01c5\5\32\16\2\u01c5\u01c6\7R\2\2\u01c6"+
		"\u01c7\5\32\16\2\u01c7\u01c8\b\r\1\2\u01c8\u01cc\3\2\2\2\u01c9\u01ca\7"+
		"\37\2\2\u01ca\u01cc\b\r\1\2\u01cb\u0186\3\2\2\2\u01cb\u0195\3\2\2\2\u01cb"+
		"\u01a9\3\2\2\2\u01cb\u01bf\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01ce\3\2"+
		"\2\2\u01cd\u0184\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01d0\3\2\2\2\u01cf"+
		"\u01d1\5R*\2\u01d0\u01cf\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\31\3\2\2\2"+
		"\u01d2\u01d3\7P\2\2\u01d3\u01d4\7?\2\2\u01d4\u01d5\b\16\1\2\u01d5\33\3"+
		"\2\2\2\u01d6\u01d7\5\36\20\2\u01d7\u01d8\b\17\1\2\u01d8\u01f2\3\2\2\2"+
		"\u01d9\u01da\5 \21\2\u01da\u01db\b\17\1\2\u01db\u01f2\3\2\2\2\u01dc\u01dd"+
		"\5\"\22\2\u01dd\u01de\b\17\1\2\u01de\u01f2\3\2\2\2\u01df\u01e0\5$\23\2"+
		"\u01e0\u01e1\b\17\1\2\u01e1\u01f2\3\2\2\2\u01e2\u01e3\5.\30\2\u01e3\u01e4"+
		"\b\17\1\2\u01e4\u01f2\3\2\2\2\u01e5\u01e6\5\60\31\2\u01e6\u01e7\b\17\1"+
		"\2\u01e7\u01f2\3\2\2\2\u01e8\u01e9\5\62\32\2\u01e9\u01ea\b\17\1\2\u01ea"+
		"\u01f2\3\2\2\2\u01eb\u01ec\5\66\34\2\u01ec\u01ed\b\17\1\2\u01ed\u01f2"+
		"\3\2\2\2\u01ee\u01ef\58\35\2\u01ef\u01f0\b\17\1\2\u01f0\u01f2\3\2\2\2"+
		"\u01f1\u01d6\3\2\2\2\u01f1\u01d9\3\2\2\2\u01f1\u01dc\3\2\2\2\u01f1\u01df"+
		"\3\2\2\2\u01f1\u01e2\3\2\2\2\u01f1\u01e5\3\2\2\2\u01f1\u01e8\3\2\2\2\u01f1"+
		"\u01eb\3\2\2\2\u01f1\u01ee\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01f5\5R"+
		"*\2\u01f4\u01f3\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\35\3\2\2\2\u01f6\u01f7"+
		"\5> \2\u01f7\u01f8\b\20\1\2\u01f8\u01f9\7\24\2\2\u01f9\u01fa\7E\2\2\u01fa"+
		"\u01fd\b\20\1\2\u01fb\u01fc\7-\2\2\u01fc\u01fe\b\20\1\2\u01fd\u01fb\3"+
		"\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0201\3\2\2\2\u01ff\u0200\7;\2\2\u0200"+
		"\u0202\b\20\1\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0205\3"+
		"\2\2\2\u0203\u0204\7#\2\2\u0204\u0206\b\20\1\2\u0205\u0203\3\2\2\2\u0205"+
		"\u0206\3\2\2\2\u0206\u020d\3\2\2\2\u0207\u0208\5V,\2\u0208\u0209\b\20"+
		"\1\2\u0209\u020e\3\2\2\2\u020a\u020b\5n8\2\u020b\u020c\b\20\1\2\u020c"+
		"\u020e\3\2\2\2\u020d\u0207\3\2\2\2\u020d\u020a\3\2\2\2\u020e\u020f\3\2"+
		"\2\2\u020f\u0210\5@!\2\u0210\u0211\b\20\1\2\u0211\u0212\7%\2\2\u0212\u0213"+
		"\5@!\2\u0213\u0214\b\20\1\2\u0214\37\3\2\2\2\u0215\u0216\5> \2\u0216\u0217"+
		"\b\21\1\2\u0217\u0243\7\24\2\2\u0218\u0219\7\'\2\2\u0219\u021a\5n8\2\u021a"+
		"\u021b\5> \2\u021b\u021c\7%\2\2\u021c\u021d\7>\2\2\u021d\u021e\5@!\2\u021e"+
		"\u021f\b\21\1\2\u021f\u0244\3\2\2\2\u0220\u0221\7\26\2\2\u0221\u0222\5"+
		"n8\2\u0222\u0223\5> \2\u0223\u0224\7%\2\2\u0224\u0225\5V,\2\u0225\u0226"+
		"\5@!\2\u0226\u0227\7%\2\2\u0227\u0228\7>\2\2\u0228\u0229\5@!\2\u0229\u022a"+
		"\b\21\1\2\u022a\u0244\3\2\2\2\u022b\u022c\7\66\2\2\u022c\u022d\5n8\2\u022d"+
		"\u022e\5> \2\u022e\u022f\7%\2\2\u022f\u0230\5n8\2\u0230\u0231\5> \2\u0231"+
		"\u0232\7%\2\2\u0232\u0233\5n8\2\u0233\u0234\b\21\1\2\u0234\u0235\7\5\2"+
		"\2\u0235\u0236\7>\2\2\u0236\u0237\7A\2\2\u0237\u023e\b\21\1\2\u0238\u0239"+
		"\7%\2\2\u0239\u023a\7>\2\2\u023a\u023b\7A\2\2\u023b\u023d\b\21\1\2\u023c"+
		"\u0238\3\2\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2\2\2\u023e\u023f\3\2"+
		"\2\2\u023f\u0241\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0242\7\63\2\2\u0242"+
		"\u0244\3\2\2\2\u0243\u0218\3\2\2\2\u0243\u0220\3\2\2\2\u0243\u022b\3\2"+
		"\2\2\u0244!\3\2\2\2\u0245\u0246\5> \2\u0246\u0247\b\22\1\2\u0247\u0261"+
		"\7\24\2\2\u0248\u0249\7\23\2\2\u0249\u024a\5`\61\2\u024a\u024b\5> \2\u024b"+
		"\u024c\7%\2\2\u024c\u024d\5x=\2\u024d\u0254\b\22\1\2\u024e\u024f\7%\2"+
		"\2\u024f\u0250\5x=\2\u0250\u0251\b\22\1\2\u0251\u0253\3\2\2\2\u0252\u024e"+
		"\3\2\2\2\u0253\u0256\3\2\2\2\u0254\u0252\3\2\2\2\u0254\u0255\3\2\2\2\u0255"+
		"\u0262\3\2\2\2\u0256\u0254\3\2\2\2\u0257\u0258\7,\2\2\u0258\u0259\5`\61"+
		"\2\u0259\u025a\5> \2\u025a\u025b\7%\2\2\u025b\u025c\5^\60\2\u025c\u025d"+
		"\5@!\2\u025d\u025e\7%\2\2\u025e\u025f\5x=\2\u025f\u0260\b\22\1\2\u0260"+
		"\u0262\3\2\2\2\u0261\u0248\3\2\2\2\u0261\u0257\3\2\2\2\u0262#\3\2\2\2"+
		"\u0263\u0264\5,\27\2\u0264\u0265\b\23\1\2\u0265\u0270\3\2\2\2\u0266\u0267"+
		"\5&\24\2\u0267\u0268\b\23\1\2\u0268\u0270\3\2\2\2\u0269\u026a\5(\25\2"+
		"\u026a\u026b\b\23\1\2\u026b\u0270\3\2\2\2\u026c\u026d\5*\26\2\u026d\u026e"+
		"\b\23\1\2\u026e\u0270\3\2\2\2\u026f\u0263\3\2\2\2\u026f\u0266\3\2\2\2"+
		"\u026f\u0269\3\2\2\2\u026f\u026c\3\2\2\2\u0270%\3\2\2\2\u0271\u0272\5"+
		"> \2\u0272\u0273\7\24\2\2\u0273\u0274\7\f\2\2\u0274\u0275\5^\60\2\u0275"+
		"\u027b\b\24\1\2\u0276\u0277\7%\2\2\u0277\u0278\5^\60\2\u0278\u0279\5x"+
		"=\2\u0279\u027a\b\24\1\2\u027a\u027c\3\2\2\2\u027b\u0276\3\2\2\2\u027b"+
		"\u027c\3\2\2\2\u027c\u0281\3\2\2\2\u027d\u027e\7%\2\2\u027e\u027f\5\24"+
		"\13\2\u027f\u0280\b\24\1\2\u0280\u0282\3\2\2\2\u0281\u027d\3\2\2\2\u0281"+
		"\u0282\3\2\2\2\u0282\'\3\2\2\2\u0283\u0284\5> \2\u0284\u0285\7\24\2\2"+
		"\u0285\u0288\b\25\1\2\u0286\u0287\7J\2\2\u0287\u0289\b\25\1\2\u0288\u0286"+
		"\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b\7\33\2\2"+
		"\u028b\u028c\5b\62\2\u028c\u028d\5@!\2\u028d\u0292\b\25\1\2\u028e\u028f"+
		"\7%\2\2\u028f\u0290\5\24\13\2\u0290\u0291\b\25\1\2\u0291\u0293\3\2\2\2"+
		"\u0292\u028e\3\2\2\2\u0292\u0293\3\2\2\2\u0293)\3\2\2\2\u0294\u0295\7"+
		"J\2\2\u0295\u0297\b\26\1\2\u0296\u0294\3\2\2\2\u0296\u0297\3\2\2\2\u0297"+
		"\u0298\3\2\2\2\u0298\u0299\7\34\2\2\u0299\u029a\b\26\1\2\u029a\u029b\5"+
		"\\/\2\u029b\u029c\5@!\2\u029c\u029d\b\26\1\2\u029d\u029e\7%\2\2\u029e"+
		"\u029f\5b\62\2\u029f\u02a0\5@!\2\u02a0\u02a5\b\26\1\2\u02a1\u02a2\7%\2"+
		"\2\u02a2\u02a3\5\24\13\2\u02a3\u02a4\b\26\1\2\u02a4\u02a6\3\2\2\2\u02a5"+
		"\u02a1\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6+\3\2\2\2\u02a7\u02a8\5> \2\u02a8"+
		"\u02a9\7\24\2\2\u02a9\u02aa\7!\2\2\u02aa\u02ad\b\27\1\2\u02ab\u02ac\7"+
		"\6\2\2\u02ac\u02ae\b\27\1\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae"+
		"\u02af\3\2\2\2\u02af\u02b0\5b\62\2\u02b0\u02b1\5@!\2\u02b1\u02b7\b\27"+
		"\1\2\u02b2\u02b3\7%\2\2\u02b3\u02b4\7>\2\2\u02b4\u02b5\5x=\2\u02b5\u02b6"+
		"\b\27\1\2\u02b6\u02b8\3\2\2\2\u02b7\u02b2\3\2\2\2\u02b8\u02b9\3\2\2\2"+
		"\u02b9\u02b7\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba-\3\2\2\2\u02bb\u02bc\5"+
		"> \2\u02bc\u02bd\7\24\2\2\u02bd\u02be\7F\2\2\u02be\u02bf\5X-\2\u02bf\u02c0"+
		"\5@!\2\u02c0\u02c1\7Q\2\2\u02c1\u02c2\5X-\2\u02c2\u02c3\b\30\1\2\u02c3"+
		"/\3\2\2\2\u02c4\u02c5\5> \2\u02c5\u02c6\7\24\2\2\u02c6\u02c7\78\2\2\u02c7"+
		"\u02cc\b\31\1\2\u02c8\u02c9\7H\2\2\u02c9\u02cd\b\31\1\2\u02ca\u02cb\7"+
		"G\2\2\u02cb\u02cd\b\31\1\2\u02cc\u02c8\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cd"+
		"\u02d4\3\2\2\2\u02ce\u02cf\5X-\2\u02cf\u02d0\b\31\1\2\u02d0\u02d5\3\2"+
		"\2\2\u02d1\u02d2\5n8\2\u02d2\u02d3\b\31\1\2\u02d3\u02d5\3\2\2\2\u02d4"+
		"\u02ce\3\2\2\2\u02d4\u02d1\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d7\5@"+
		"!\2\u02d7\u02d8\7%\2\2\u02d8\u02d9\5@!\2\u02d9\u02da\b\31\1\2\u02da\61"+
		"\3\2\2\2\u02db\u02dc\5> \2\u02dc\u02dd\7\24\2\2\u02dd\u02de\7/\2\2\u02de"+
		"\u02e5\b\32\1\2\u02df\u02e0\7I\2\2\u02e0\u02e6\b\32\1\2\u02e1\u02e2\7"+
		"G\2\2\u02e2\u02e6\b\32\1\2\u02e3\u02e4\7B\2\2\u02e4\u02e6\b\32\1\2\u02e5"+
		"\u02df\3\2\2\2\u02e5\u02e1\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e6\u02ed\3\2"+
		"\2\2\u02e7\u02e8\5X-\2\u02e8\u02e9\b\32\1\2\u02e9\u02ee\3\2\2\2\u02ea"+
		"\u02eb\5n8\2\u02eb\u02ec\b\32\1\2\u02ec\u02ee\3\2\2\2\u02ed\u02e7\3\2"+
		"\2\2\u02ed\u02ea\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef\u02f0\5@!\2\u02f0\u02f1"+
		"\7%\2\2\u02f1\u02f2\5@!\2\u02f2\u02f3\b\32\1\2\u02f3\63\3\2\2\2\u02f4"+
		"\u02f5\5> \2\u02f5\u02f6\b\33\1\2\u02f6\u02f7\7\24\2\2\u02f7\u02f8\7\r"+
		"\2\2\u02f8\u02f9\5\\/\2\u02f9\u02fa\b\33\1\2\u02fa\u02fb\7\3\2\2\u02fb"+
		"\u02fc\5@!\2\u02fc\u02fd\b\33\1\2\u02fd\u02fe\7%\2\2\u02fe\u02ff\7?\2"+
		"\2\u02ff\u0300\b\33\1\2\u0300\u030b\7\"\2\2\u0301\u0302\7%\2\2\u0302\u0303"+
		"\7\3\2\2\u0303\u0304\5@!\2\u0304\u0305\7%\2\2\u0305\u0306\7?\2\2\u0306"+
		"\u0307\b\33\1\2\u0307\u0308\7\"\2\2\u0308\u030a\3\2\2\2\u0309\u0301\3"+
		"\2\2\2\u030a\u030d\3\2\2\2\u030b\u0309\3\2\2\2\u030b\u030c\3\2\2\2\u030c"+
		"\u030f\3\2\2\2\u030d\u030b\3\2\2\2\u030e\u0310\5R*\2\u030f\u030e\3\2\2"+
		"\2\u030f\u0310\3\2\2\2\u0310\65\3\2\2\2\u0311\u0312\5> \2\u0312\u0313"+
		"\7\24\2\2\u0313\u0314\7$\2\2\u0314\u0315\7=\2\2\u0315\u0316\5@!\2\u0316"+
		"\u0317\7%\2\2\u0317\u0318\5\\/\2\u0318\u0319\5@!\2\u0319\u031a\7%\2\2"+
		"\u031a\u031b\5\\/\2\u031b\u031c\5@!\2\u031c\u031d\b\34\1\2\u031d\67\3"+
		"\2\2\2\u031e\u031f\5> \2\u031f\u0320\7\24\2\2\u0320\u0321\b\35\1\2\u0321"+
		"\u0323\3\2\2\2\u0322\u031e\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0326\3\2"+
		"\2\2\u0324\u0325\7\t\2\2\u0325\u0327\b\35\1\2\u0326\u0324\3\2\2\2\u0326"+
		"\u0327\3\2\2\2\u0327\u0328\3\2\2\2\u0328\u0329\7\31\2\2\u0329\u032a\5"+
		":\36\2\u032a9\3\2\2\2\u032b\u032c\7Y\2\2\u032c\u032e\b\36\1\2\u032d\u032b"+
		"\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u0333\3\2\2\2\u032f\u0330\7Z\2\2\u0330"+
		"\u0332\b\36\1\2\u0331\u032f\3\2\2\2\u0332\u0335\3\2\2\2\u0333\u0331\3"+
		"\2\2\2\u0333\u0334\3\2\2\2\u0334\u0336\3\2\2\2\u0335\u0333\3\2\2\2\u0336"+
		"\u0337\5p9\2\u0337\u0338\5\u008aF\2\u0338\u0339\b\36\1\2\u0339\u033a\7"+
		"&\2\2\u033a\u033b\5<\37\2\u033b\u033c\7\20\2\2\u033c\u0341\b\36\1\2\u033d"+
		"\u033e\7[\2\2\u033e\u0340\b\36\1\2\u033f\u033d\3\2\2\2\u0340\u0343\3\2"+
		"\2\2\u0341\u033f\3\2\2\2\u0341\u0342\3\2\2\2\u0342;\3\2\2\2\u0343\u0341"+
		"\3\2\2\2\u0344\u0345\7)\2\2\u0345\u037d\b\37\1\2\u0346\u0347\5\\/\2\u0347"+
		"\u034c\b\37\1\2\u0348\u0349\7Z\2\2\u0349\u034b\b\37\1\2\u034a\u0348\3"+
		"\2\2\2\u034b\u034e\3\2\2\2\u034c\u034a\3\2\2\2\u034c\u034d\3\2\2\2\u034d"+
		"\u0352\3\2\2\2\u034e\u034c\3\2\2\2\u034f\u0350\5\24\13\2\u0350\u0351\b"+
		"\37\1\2\u0351\u0353\3\2\2\2\u0352\u034f\3\2\2\2\u0352\u0353\3\2\2\2\u0353"+
		"\u0357\3\2\2\2\u0354\u0355\5@!\2\u0355\u0356\b\37\1\2\u0356\u0358\3\2"+
		"\2\2\u0357\u0354\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u0359\3\2\2\2\u0359"+
		"\u0372\b\37\1\2\u035a\u035b\7%\2\2\u035b\u035c\5\\/\2\u035c\u0361\b\37"+
		"\1\2\u035d\u035e\7Z\2\2\u035e\u0360\b\37\1\2\u035f\u035d\3\2\2\2\u0360"+
		"\u0363\3\2\2\2\u0361\u035f\3\2\2\2\u0361\u0362\3\2\2\2\u0362\u0367\3\2"+
		"\2\2\u0363\u0361\3\2\2\2\u0364\u0365\5\24\13\2\u0365\u0366\b\37\1\2\u0366"+
		"\u0368\3\2\2\2\u0367\u0364\3\2\2\2\u0367\u0368\3\2\2\2\u0368\u036c\3\2"+
		"\2\2\u0369\u036a\5@!\2\u036a\u036b\b\37\1\2\u036b\u036d\3\2\2\2\u036c"+
		"\u0369\3\2\2\2\u036c\u036d\3\2\2\2\u036d\u036e\3\2\2\2\u036e\u036f\b\37"+
		"\1\2\u036f\u0371\3\2\2\2\u0370\u035a\3\2\2\2\u0371\u0374\3\2\2\2\u0372"+
		"\u0370\3\2\2\2\u0372\u0373\3\2\2\2\u0373\u0378\3\2\2\2\u0374\u0372\3\2"+
		"\2\2\u0375\u0376\7%\2\2\u0376\u0377\7)\2\2\u0377\u0379\b\37\1\2\u0378"+
		"\u0375\3\2\2\2\u0378\u0379\3\2\2\2\u0379\u037b\3\2\2\2\u037a\u0346\3\2"+
		"\2\2\u037a\u037b\3\2\2\2\u037b\u037d\3\2\2\2\u037c\u0344\3\2\2\2\u037c"+
		"\u037a\3\2\2\2\u037d=\3\2\2\2\u037e\u037f\7@\2\2\u037f\u0385\b \1\2\u0380"+
		"\u0381\7?\2\2\u0381\u0385\b \1\2\u0382\u0383\7V\2\2\u0383\u0385\b \1\2"+
		"\u0384\u037e\3\2\2\2\u0384\u0380\3\2\2\2\u0384\u0382\3\2\2\2\u0385?\3"+
		"\2\2\2\u0386\u0387\5|?\2\u0387\u0388\b!\1\2\u0388\u039c\3\2\2\2\u0389"+
		"\u038a\5B\"\2\u038a\u038b\b!\1\2\u038b\u039c\3\2\2\2\u038c\u038d\5D#\2"+
		"\u038d\u038e\b!\1\2\u038e\u039c\3\2\2\2\u038f\u0390\5F$\2\u0390\u0391"+
		"\b!\1\2\u0391\u039c\3\2\2\2\u0392\u0393\5H%\2\u0393\u0394\b!\1\2\u0394"+
		"\u039c\3\2\2\2\u0395\u0396\5> \2\u0396\u0397\b!\1\2\u0397\u039c\3\2\2"+
		"\2\u0398\u0399\5N(\2\u0399\u039a\b!\1\2\u039a\u039c\3\2\2\2\u039b\u0386"+
		"\3\2\2\2\u039b\u0389\3\2\2\2\u039b\u038c\3\2\2\2\u039b\u038f\3\2\2\2\u039b"+
		"\u0392\3\2\2\2\u039b\u0395\3\2\2\2\u039b\u0398\3\2\2\2\u039cA\3\2\2\2"+
		"\u039d\u03a0\7!\2\2\u039e\u039f\7\6\2\2\u039f\u03a1\b\"\1\2\u03a0\u039e"+
		"\3\2\2\2\u03a0\u03a1\3\2\2\2\u03a1\u03a2\3\2\2\2\u03a2\u03a3\7&\2\2\u03a3"+
		"\u03a4\5b\62\2\u03a4\u03a5\b\"\1\2\u03a5\u03a6\5@!\2\u03a6\u03ab\b\"\1"+
		"\2\u03a7\u03a8\7%\2\2\u03a8\u03a9\7>\2\2\u03a9\u03aa\7A\2\2\u03aa\u03ac"+
		"\b\"\1\2\u03ab\u03a7\3\2\2\2\u03ac\u03ad\3\2\2\2\u03ad\u03ab\3\2\2\2\u03ad"+
		"\u03ae\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03b0\7\20\2\2\u03b0C\3\2\2\2"+
		"\u03b1\u03b2\7F\2\2\u03b2\u03b3\7&\2\2\u03b3\u03b4\5X-\2\u03b4\u03b5\5"+
		"@!\2\u03b5\u03b6\7Q\2\2\u03b6\u03b7\5X-\2\u03b7\u03b8\7\20\2\2\u03b8\u03b9"+
		"\b#\1\2\u03b9E\3\2\2\2\u03ba\u03bb\7E\2\2\u03bb\u03be\b$\1\2\u03bc\u03bd"+
		"\7-\2\2\u03bd\u03bf\b$\1\2\u03be\u03bc\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf"+
		"\u03c2\3\2\2\2\u03c0\u03c1\7;\2\2\u03c1\u03c3\b$\1\2\u03c2\u03c0\3\2\2"+
		"\2\u03c2\u03c3\3\2\2\2\u03c3\u03c6\3\2\2\2\u03c4\u03c5\7#\2\2\u03c5\u03c7"+
		"\b$\1\2\u03c6\u03c4\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7\u03c8\3\2\2\2\u03c8"+
		"\u03cf\7&\2\2\u03c9\u03ca\5V,\2\u03ca\u03cb\b$\1\2\u03cb\u03d0\3\2\2\2"+
		"\u03cc\u03cd\5n8\2\u03cd\u03ce\b$\1\2\u03ce\u03d0\3\2\2\2\u03cf\u03c9"+
		"\3\2\2\2\u03cf\u03cc\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03d2\5@!\2\u03d2"+
		"\u03d3\b$\1\2\u03d3\u03da\7%\2\2\u03d4\u03d5\5V,\2\u03d5\u03d6\b$\1\2"+
		"\u03d6\u03db\3\2\2\2\u03d7\u03d8\5n8\2\u03d8\u03d9\b$\1\2\u03d9\u03db"+
		"\3\2\2\2\u03da\u03d4\3\2\2\2\u03da\u03d7\3\2\2\2\u03db\u03dc\3\2\2\2\u03dc"+
		"\u03dd\5@!\2\u03dd\u03de\b$\1\2\u03de\u03df\7\20\2\2\u03dfG\3\2\2\2\u03e0"+
		"\u03e5\78\2\2\u03e1\u03e2\7H\2\2\u03e2\u03e6\b%\1\2\u03e3\u03e4\7G\2\2"+
		"\u03e4\u03e6\b%\1\2\u03e5\u03e1\3\2\2\2\u03e5\u03e3\3\2\2\2\u03e6\u03f2"+
		"\3\2\2\2\u03e7\u03e8\7/\2\2\u03e8\u03ef\b%\1\2\u03e9\u03ea\7I\2\2\u03ea"+
		"\u03f0\b%\1\2\u03eb\u03ec\7G\2\2\u03ec\u03f0\b%\1\2\u03ed\u03ee\7B\2\2"+
		"\u03ee\u03f0\b%\1\2\u03ef\u03e9\3\2\2\2\u03ef\u03eb\3\2\2\2\u03ef\u03ed"+
		"\3\2\2\2\u03f0\u03f2\3\2\2\2\u03f1\u03e0\3\2\2\2\u03f1\u03e7\3\2\2\2\u03f2"+
		"\u03f3\3\2\2\2\u03f3\u03fa\7&\2\2\u03f4\u03f5\5X-\2\u03f5\u03f6\b%\1\2"+
		"\u03f6\u03fb\3\2\2\2\u03f7\u03f8\5n8\2\u03f8\u03f9\b%\1\2\u03f9\u03fb"+
		"\3\2\2\2\u03fa\u03f4\3\2\2\2\u03fa\u03f7\3\2\2\2\u03fb\u03fc\3\2\2\2\u03fc"+
		"\u03fd\5@!\2\u03fd\u03fe\b%\1\2\u03fe\u0405\7%\2\2\u03ff\u0400\5X-\2\u0400"+
		"\u0401\b%\1\2\u0401\u0406\3\2\2\2\u0402\u0403\5n8\2\u0403\u0404\b%\1\2"+
		"\u0404\u0406\3\2\2\2\u0405\u03ff\3\2\2\2\u0405\u0402\3\2\2\2\u0406\u0407"+
		"\3\2\2\2\u0407\u0408\5@!\2\u0408\u0409\b%\1\2\u0409\u040a\7\20\2\2\u040a"+
		"I\3\2\2\2\u040b\u040c\5L\'\2\u040c\u040d\7\24\2\2\u040d\u040e\5N(\2\u040e"+
		"K\3\2\2\2\u040f\u0410\7\36\2\2\u0410\u0411\t\3\2\2\u0411M\3\2\2\2\u0412"+
		"\u0419\7\36\2\2\u0413\u041a\7T\2\2\u0414\u041a\7A\2\2\u0415\u0416\7*\2"+
		"\2\u0416\u0417\5P)\2\u0417\u0418\7\13\2\2\u0418\u041a\3\2\2\2\u0419\u0413"+
		"\3\2\2\2\u0419\u0414\3\2\2\2\u0419\u0415\3\2\2\2\u041a\u041f\3\2\2\2\u041b"+
		"\u041f\5L\'\2\u041c\u041f\5<\37\2\u041d\u041f\7U\2\2\u041e\u0412\3\2\2"+
		"\2\u041e\u041b\3\2\2\2\u041e\u041c\3\2\2\2\u041e\u041d\3\2\2\2\u041fO"+
		"\3\2\2\2\u0420\u0425\5N(\2\u0421\u0422\7%\2\2\u0422\u0424\5N(\2\u0423"+
		"\u0421\3\2\2\2\u0424\u0427\3\2\2\2\u0425\u0423\3\2\2\2\u0425\u0426\3\2"+
		"\2\2\u0426Q\3\2\2\2\u0427\u0425\3\2\2\2\u0428\u0429\7%\2\2\u0429\u042a"+
		"\7\32\2\2\u042a\u042b\5N(\2\u042bS\3\2\2\2\u042c\u042d\7?\2\2\u042d\u042e"+
		"\b+\1\2\u042eU\3\2\2\2\u042f\u0430\7=\2\2\u0430\u0439\b,\1\2\u0431\u0432"+
		"\7>\2\2\u0432\u0439\b,\1\2\u0433\u0434\7S\2\2\u0434\u0439\b,\1\2\u0435"+
		"\u0436\5T+\2\u0436\u0437\b,\1\2\u0437\u0439\3\2\2\2\u0438\u042f\3\2\2"+
		"\2\u0438\u0431\3\2\2\2\u0438\u0433\3\2\2\2\u0438\u0435\3\2\2\2\u0439W"+
		"\3\2\2\2\u043a\u043b\5V,\2\u043b\u0440\b-\1\2\u043c\u043d\7\4\2\2\u043d"+
		"\u043f\b-\1\2\u043e\u043c\3\2\2\2\u043f\u0442\3\2\2\2\u0440\u043e\3\2"+
		"\2\2\u0440\u0441\3\2\2\2\u0441\u044d\3\2\2\2\u0442\u0440\3\2\2\2\u0443"+
		"\u0444\5t;\2\u0444\u0447\b-\1\2\u0445\u0446\7\4\2\2\u0446\u0448\b-\1\2"+
		"\u0447\u0445\3\2\2\2\u0448\u0449\3\2\2\2\u0449\u0447\3\2\2\2\u0449\u044a"+
		"\3\2\2\2\u044a\u044c\3\2\2\2\u044b\u0443\3\2\2\2\u044c\u044f\3\2\2\2\u044d"+
		"\u044b\3\2\2\2\u044d\u044e\3\2\2\2\u044e\u04e4\3\2\2\2\u044f\u044d\3\2"+
		"\2\2\u0450\u0451\5d\63\2\u0451\u0471\b-\1\2\u0452\u0453\7\4\2\2\u0453"+
		"\u0455\b-\1\2\u0454\u0452\3\2\2\2\u0455\u0456\3\2\2\2\u0456\u0454\3\2"+
		"\2\2\u0456\u0457\3\2\2\2\u0457\u0462\3\2\2\2\u0458\u0459\5t;\2\u0459\u045c"+
		"\b-\1\2\u045a\u045b\7\4\2\2\u045b\u045d\b-\1\2\u045c\u045a\3\2\2\2\u045d"+
		"\u045e\3\2\2\2\u045e\u045c\3\2\2\2\u045e\u045f\3\2\2\2\u045f\u0461\3\2"+
		"\2\2\u0460\u0458\3\2\2\2\u0461\u0464\3\2\2\2\u0462\u0460\3\2\2\2\u0462"+
		"\u0463\3\2\2\2\u0463\u0472\3\2\2\2\u0464\u0462\3\2\2\2\u0465\u0466\5t"+
		";\2\u0466\u0469\b-\1\2\u0467\u0468\7\4\2\2\u0468\u046a\b-\1\2\u0469\u0467"+
		"\3\2\2\2\u046a\u046b\3\2\2\2\u046b\u0469\3\2\2\2\u046b\u046c\3\2\2\2\u046c"+
		"\u046e\3\2\2\2\u046d\u0465\3\2\2\2\u046e\u046f\3\2\2\2\u046f\u046d\3\2"+
		"\2\2\u046f\u0470\3\2\2\2\u0470\u0472\3\2\2\2\u0471\u0454\3\2\2\2\u0471"+
		"\u046d\3\2\2\2\u0472\u04e4\3\2\2\2\u0473\u0474\5h\65\2\u0474\u0494\b-"+
		"\1\2\u0475\u0476\7\4\2\2\u0476\u0478\b-\1\2\u0477\u0475\3\2\2\2\u0478"+
		"\u0479\3\2\2\2\u0479\u0477\3\2\2\2\u0479\u047a\3\2\2\2\u047a\u0485\3\2"+
		"\2\2\u047b\u047c\5t;\2\u047c\u047f\b-\1\2\u047d\u047e\7\4\2\2\u047e\u0480"+
		"\b-\1\2\u047f\u047d\3\2\2\2\u0480\u0481\3\2\2\2\u0481\u047f\3\2\2\2\u0481"+
		"\u0482\3\2\2\2\u0482\u0484\3\2\2\2\u0483\u047b\3\2\2\2\u0484\u0487\3\2"+
		"\2\2\u0485\u0483\3\2\2\2\u0485\u0486\3\2\2\2\u0486\u0495\3\2\2\2\u0487"+
		"\u0485\3\2\2\2\u0488\u0489\5t;\2\u0489\u048c\b-\1\2\u048a\u048b\7\4\2"+
		"\2\u048b\u048d\b-\1\2\u048c\u048a\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u048c"+
		"\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u0491\3\2\2\2\u0490\u0488\3\2\2\2\u0491"+
		"\u0492\3\2\2\2\u0492\u0490\3\2\2\2\u0492\u0493\3\2\2\2\u0493\u0495\3\2"+
		"\2\2\u0494\u0477\3\2\2\2\u0494\u0490\3\2\2\2\u0495\u04e4\3\2\2\2\u0496"+
		"\u0497\5f\64\2\u0497\u049a\b-\1\2\u0498\u0499\7\4\2\2\u0499\u049b\b-\1"+
		"\2\u049a\u0498\3\2\2\2\u049b\u049c\3\2\2\2\u049c\u049a\3\2\2\2\u049c\u049d"+
		"\3\2\2\2\u049d\u04a8\3\2\2\2\u049e\u049f\5t;\2\u049f\u04a2\b-\1\2\u04a0"+
		"\u04a1\7\4\2\2\u04a1\u04a3\b-\1\2\u04a2\u04a0\3\2\2\2\u04a3\u04a4\3\2"+
		"\2\2\u04a4\u04a2\3\2\2\2\u04a4\u04a5\3\2\2\2\u04a5\u04a7\3\2\2\2\u04a6"+
		"\u049e\3\2\2\2\u04a7\u04aa\3\2\2\2\u04a8\u04a6\3\2\2\2\u04a8\u04a9\3\2"+
		"\2\2\u04a9\u04e4\3\2\2\2\u04aa\u04a8\3\2\2\2\u04ab\u04ac\5l\67\2\u04ac"+
		"\u04af\b-\1\2\u04ad\u04ae\7\4\2\2\u04ae\u04b0\b-\1\2\u04af\u04ad\3\2\2"+
		"\2\u04b0\u04b1\3\2\2\2\u04b1\u04af\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2\u04bd"+
		"\3\2\2\2\u04b3\u04b4\5t;\2\u04b4\u04b7\b-\1\2\u04b5\u04b6\7\4\2\2\u04b6"+
		"\u04b8\b-\1\2\u04b7\u04b5\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04b7\3\2"+
		"\2\2\u04b9\u04ba\3\2\2\2\u04ba\u04bc\3\2\2\2\u04bb\u04b3\3\2\2\2\u04bc"+
		"\u04bf\3\2\2\2\u04bd\u04bb\3\2\2\2\u04bd\u04be\3\2\2\2\u04be\u04e4\3\2"+
		"\2\2\u04bf\u04bd\3\2\2\2\u04c0\u04c1\5n8\2\u04c1\u04c4\b-\1\2\u04c2\u04c3"+
		"\7\4\2\2\u04c3\u04c5\b-\1\2\u04c4\u04c2\3\2\2\2\u04c5\u04c6\3\2\2\2\u04c6"+
		"\u04c4\3\2\2\2\u04c6\u04c7\3\2\2\2\u04c7\u04d2\3\2\2\2\u04c8\u04c9\5t"+
		";\2\u04c9\u04cc\b-\1\2\u04ca\u04cb\7\4\2\2\u04cb\u04cd\b-\1\2\u04cc\u04ca"+
		"\3\2\2\2\u04cd\u04ce\3\2\2\2\u04ce\u04cc\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf"+
		"\u04d1\3\2\2\2\u04d0\u04c8\3\2\2\2\u04d1\u04d4\3\2\2\2\u04d2\u04d0\3\2"+
		"\2\2\u04d2\u04d3\3\2\2\2\u04d3\u04e4\3\2\2\2\u04d4\u04d2\3\2\2\2\u04d5"+
		"\u04d6\7K\2\2\u04d6\u04df\b-\1\2\u04d7\u04d8\5t;\2\u04d8\u04db\b-\1\2"+
		"\u04d9\u04da\7\4\2\2\u04da\u04dc\b-\1\2\u04db\u04d9\3\2\2\2\u04dc\u04dd"+
		"\3\2\2\2\u04dd\u04db\3\2\2\2\u04dd\u04de\3\2\2\2\u04de\u04e0\3\2\2\2\u04df"+
		"\u04d7\3\2\2\2\u04e0\u04e1\3\2\2\2\u04e1\u04df\3\2\2\2\u04e1\u04e2\3\2"+
		"\2\2\u04e2\u04e4\3\2\2\2\u04e3\u043a\3\2\2\2\u04e3\u0450\3\2\2\2\u04e3"+
		"\u0473\3\2\2\2\u04e3\u0496\3\2\2\2\u04e3\u04ab\3\2\2\2\u04e3\u04c0\3\2"+
		"\2\2\u04e3\u04d5\3\2\2\2\u04e4Y\3\2\2\2\u04e5\u04e6\7K\2\2\u04e6\u04ef"+
		"\b.\1\2\u04e7\u04e8\7P\2\2\u04e8\u04ef\b.\1\2\u04e9\u04ea\7M\2\2\u04ea"+
		"\u04ef\b.\1\2\u04eb\u04ec\5V,\2\u04ec\u04ed\b.\1\2\u04ed\u04ef\3\2\2\2"+
		"\u04ee\u04e5\3\2\2\2\u04ee\u04e7\3\2\2\2\u04ee\u04e9\3\2\2\2\u04ee\u04eb"+
		"\3\2\2\2\u04ef[\3\2\2\2\u04f0\u04f1\5V,\2\u04f1\u04f6\b/\1\2\u04f2\u04f3"+
		"\7\4\2\2\u04f3\u04f5\b/\1\2\u04f4\u04f2\3\2\2\2\u04f5\u04f8\3\2\2\2\u04f6"+
		"\u04f4\3\2\2\2\u04f6\u04f7\3\2\2\2\u04f7\u0503\3\2\2\2\u04f8\u04f6\3\2"+
		"\2\2\u04f9\u04fa\5t;\2\u04fa\u04fd\b/\1\2\u04fb\u04fc\7\4\2\2\u04fc\u04fe"+
		"\b/\1\2\u04fd\u04fb\3\2\2\2\u04fe\u04ff\3\2\2\2\u04ff\u04fd\3\2\2\2\u04ff"+
		"\u0500\3\2\2\2\u0500\u0502\3\2\2\2\u0501\u04f9\3\2\2\2\u0502\u0505\3\2"+
		"\2\2\u0503\u0501\3\2\2\2\u0503\u0504\3\2\2\2\u0504\u0588\3\2\2\2\u0505"+
		"\u0503\3\2\2\2\u0506\u0507\5d\63\2\u0507\u050c\b/\1\2\u0508\u0509\7\4"+
		"\2\2\u0509\u050b\b/\1\2\u050a\u0508\3\2\2\2\u050b\u050e\3\2\2\2\u050c"+
		"\u050a\3\2\2\2\u050c\u050d\3\2\2\2\u050d\u0519\3\2\2\2\u050e\u050c\3\2"+
		"\2\2\u050f\u0510\5t;\2\u0510\u0513\b/\1\2\u0511\u0512\7\4\2\2\u0512\u0514"+
		"\b/\1\2\u0513\u0511\3\2\2\2\u0514\u0515\3\2\2\2\u0515\u0513\3\2\2\2\u0515"+
		"\u0516\3\2\2\2\u0516\u0518\3\2\2\2\u0517\u050f\3\2\2\2\u0518\u051b\3\2"+
		"\2\2\u0519\u0517\3\2\2\2\u0519\u051a\3\2\2\2\u051a\u0588\3\2\2\2\u051b"+
		"\u0519\3\2\2\2\u051c\u051d\5h\65\2\u051d\u0522\b/\1\2\u051e\u051f\7\4"+
		"\2\2\u051f\u0521\b/\1\2\u0520\u051e\3\2\2\2\u0521\u0524\3\2\2\2\u0522"+
		"\u0520\3\2\2\2\u0522\u0523\3\2\2\2\u0523\u052f\3\2\2\2\u0524\u0522\3\2"+
		"\2\2\u0525\u0526\5t;\2\u0526\u0529\b/\1\2\u0527\u0528\7\4\2\2\u0528\u052a"+
		"\b/\1\2\u0529\u0527\3\2\2\2\u052a\u052b\3\2\2\2\u052b\u0529\3\2\2\2\u052b"+
		"\u052c\3\2\2\2\u052c\u052e\3\2\2\2\u052d\u0525\3\2\2\2\u052e\u0531\3\2"+
		"\2\2\u052f\u052d\3\2\2\2\u052f\u0530\3\2\2\2\u0530\u0588\3\2\2\2\u0531"+
		"\u052f\3\2\2\2\u0532\u0533\5f\64\2\u0533\u0536\b/\1\2\u0534\u0535\7\4"+
		"\2\2\u0535\u0537\b/\1\2\u0536\u0534\3\2\2\2\u0537\u0538\3\2\2\2\u0538"+
		"\u0536\3\2\2\2\u0538\u0539\3\2\2\2\u0539\u0544\3\2\2\2\u053a\u053b\5t"+
		";\2\u053b\u053e\b/\1\2\u053c\u053d\7\4\2\2\u053d\u053f\b/\1\2\u053e\u053c"+
		"\3\2\2\2\u053f\u0540\3\2\2\2\u0540\u053e\3\2\2\2\u0540\u0541\3\2\2\2\u0541"+
		"\u0543\3\2\2\2\u0542\u053a\3\2\2\2\u0543\u0546\3\2\2\2\u0544\u0542\3\2"+
		"\2\2\u0544\u0545\3\2\2\2\u0545\u0588\3\2\2\2\u0546\u0544\3\2\2\2\u0547"+
		"\u0548\5l\67\2\u0548\u055c\b/\1\2\u0549\u054a\7\4\2\2\u054a\u054c\b/\1"+
		"\2\u054b\u0549\3\2\2\2\u054c\u054d\3\2\2\2\u054d\u054b\3\2\2\2\u054d\u054e"+
		"\3\2\2\2\u054e\u0559\3\2\2\2\u054f\u0550\5t;\2\u0550\u0553\b/\1\2\u0551"+
		"\u0552\7\4\2\2\u0552\u0554\b/\1\2\u0553\u0551\3\2\2\2\u0554\u0555\3\2"+
		"\2\2\u0555\u0553\3\2\2\2\u0555\u0556\3\2\2\2\u0556\u0558\3\2\2\2\u0557"+
		"\u054f\3\2\2\2\u0558\u055b\3\2\2\2\u0559\u0557\3\2\2\2\u0559\u055a\3\2"+
		"\2\2\u055a\u055d\3\2\2\2\u055b\u0559\3\2\2\2\u055c\u054b\3\2\2\2\u055c"+
		"\u055d\3\2\2\2\u055d\u0588\3\2\2\2\u055e\u055f\5n8\2\u055f\u0573\b/\1"+
		"\2\u0560\u0561\7\4\2\2\u0561\u0563\b/\1\2\u0562\u0560\3\2\2\2\u0563\u0564"+
		"\3\2\2\2\u0564\u0562\3\2\2\2\u0564\u0565\3\2\2\2\u0565\u0570\3\2\2\2\u0566"+
		"\u0567\5t;\2\u0567\u056a\b/\1\2\u0568\u0569\7\4\2\2\u0569\u056b\b/\1\2"+
		"\u056a\u0568\3\2\2\2\u056b\u056c\3\2\2\2\u056c\u056a\3\2\2\2\u056c\u056d"+
		"\3\2\2\2\u056d\u056f\3\2\2\2\u056e\u0566\3\2\2\2\u056f\u0572\3\2\2\2\u0570"+
		"\u056e\3\2\2\2\u0570\u0571\3\2\2\2\u0571\u0574\3\2\2\2\u0572\u0570\3\2"+
		"\2\2\u0573\u0562\3\2\2\2\u0573\u0574\3\2\2\2\u0574\u0588\3\2\2\2\u0575"+
		"\u0576\7K\2\2\u0576\u057f\b/\1\2\u0577\u0578\5t;\2\u0578\u057b\b/\1\2"+
		"\u0579\u057a\7\4\2\2\u057a\u057c\b/\1\2\u057b\u0579\3\2\2\2\u057c\u057d"+
		"\3\2\2\2\u057d\u057b\3\2\2\2\u057d\u057e\3\2\2\2\u057e\u0580\3\2\2\2\u057f"+
		"\u0577\3\2\2\2\u0580\u0581\3\2\2\2\u0581\u057f\3\2\2\2\u0581\u0582\3\2"+
		"\2\2\u0582\u0588\3\2\2\2\u0583\u0584\7P\2\2\u0584\u0588\b/\1\2\u0585\u0586"+
		"\7M\2\2\u0586\u0588\b/\1\2\u0587\u04f0\3\2\2\2\u0587\u0506\3\2\2\2\u0587"+
		"\u051c\3\2\2\2\u0587\u0532\3\2\2\2\u0587\u0547\3\2\2\2\u0587\u055e\3\2"+
		"\2\2\u0587\u0575\3\2\2\2\u0587\u0583\3\2\2\2\u0587\u0585\3\2\2\2\u0588"+
		"]\3\2\2\2\u0589\u058a\5V,\2\u058a\u058f\b\60\1\2\u058b\u058c\7\4\2\2\u058c"+
		"\u058e\b\60\1\2\u058d\u058b\3\2\2\2\u058e\u0591\3\2\2\2\u058f\u058d\3"+
		"\2\2\2\u058f\u0590\3\2\2\2\u0590\u05a9\3\2\2\2\u0591\u058f\3\2\2\2\u0592"+
		"\u0593\5t;\2\u0593\u059f\b\60\1\2\u0594\u0595\7\4\2\2\u0595\u0597\b\60"+
		"\1\2\u0596\u0594\3\2\2\2\u0597\u0598\3\2\2\2\u0598\u0596\3\2\2\2\u0598"+
		"\u0599\3\2\2\2\u0599\u059a\3\2\2\2\u059a\u059b\5t;\2\u059b\u059c\b\60"+
		"\1\2\u059c\u059e\3\2\2\2\u059d\u0596\3\2\2\2\u059e\u05a1\3\2\2\2\u059f"+
		"\u059d\3\2\2\2\u059f\u05a0\3\2\2\2\u05a0\u05a6\3\2\2\2\u05a1\u059f\3\2"+
		"\2\2\u05a2\u05a3\7\4\2\2\u05a3\u05a5\b\60\1\2\u05a4\u05a2\3\2\2\2\u05a5"+
		"\u05a8\3\2\2\2\u05a6\u05a4\3\2\2\2\u05a6\u05a7\3\2\2\2\u05a7\u05aa\3\2"+
		"\2\2\u05a8\u05a6\3\2\2\2\u05a9\u0592\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aa"+
		"\u0678\3\2\2\2\u05ab\u05ac\5d\63\2\u05ac\u05b1\b\60\1\2\u05ad\u05ae\7"+
		"\4\2\2\u05ae\u05b0\b\60\1\2\u05af\u05ad\3\2\2\2\u05b0\u05b3\3\2\2\2\u05b1"+
		"\u05af\3\2\2\2\u05b1\u05b2\3\2\2\2\u05b2\u05cb\3\2\2\2\u05b3\u05b1\3\2"+
		"\2\2\u05b4\u05b5\5t;\2\u05b5\u05c1\b\60\1\2\u05b6\u05b7\7\4\2\2\u05b7"+
		"\u05b9\b\60\1\2\u05b8\u05b6\3\2\2\2\u05b9\u05ba\3\2\2\2\u05ba\u05b8\3"+
		"\2\2\2\u05ba\u05bb\3\2\2\2\u05bb\u05bc\3\2\2\2\u05bc\u05bd\5t;\2\u05bd"+
		"\u05be\b\60\1\2\u05be\u05c0\3\2\2\2\u05bf\u05b8\3\2\2\2\u05c0\u05c3\3"+
		"\2\2\2\u05c1\u05bf\3\2\2\2\u05c1\u05c2\3\2\2\2\u05c2\u05c8\3\2\2\2\u05c3"+
		"\u05c1\3\2\2\2\u05c4\u05c5\7\4\2\2\u05c5\u05c7\b\60\1\2\u05c6\u05c4\3"+
		"\2\2\2\u05c7\u05ca\3\2\2\2\u05c8\u05c6\3\2\2\2\u05c8\u05c9\3\2\2\2\u05c9"+
		"\u05cc\3\2\2\2\u05ca\u05c8\3\2\2\2\u05cb\u05b4\3\2\2\2\u05cb\u05cc\3\2"+
		"\2\2\u05cc\u0678\3\2\2\2\u05cd\u05ce\5h\65\2\u05ce\u05d3\b\60\1\2\u05cf"+
		"\u05d0\7\4\2\2\u05d0\u05d2\b\60\1\2\u05d1\u05cf\3\2\2\2\u05d2\u05d5\3"+
		"\2\2\2\u05d3\u05d1\3\2\2\2\u05d3\u05d4\3\2\2\2\u05d4\u05ed\3\2\2\2\u05d5"+
		"\u05d3\3\2\2\2\u05d6\u05d7\5t;\2\u05d7\u05e3\b\60\1\2\u05d8\u05d9\7\4"+
		"\2\2\u05d9\u05db\b\60\1\2\u05da\u05d8\3\2\2\2\u05db\u05dc\3\2\2\2\u05dc"+
		"\u05da\3\2\2\2\u05dc\u05dd\3\2\2\2\u05dd\u05de\3\2\2\2\u05de\u05df\5t"+
		";\2\u05df\u05e0\b\60\1\2\u05e0\u05e2\3\2\2\2\u05e1\u05da\3\2\2\2\u05e2"+
		"\u05e5\3\2\2\2\u05e3\u05e1\3\2\2\2\u05e3\u05e4\3\2\2\2\u05e4\u05ea\3\2"+
		"\2\2\u05e5\u05e3\3\2\2\2\u05e6\u05e7\7\4\2\2\u05e7\u05e9\b\60\1\2\u05e8"+
		"\u05e6\3\2\2\2\u05e9\u05ec\3\2\2\2\u05ea\u05e8\3\2\2\2\u05ea\u05eb\3\2"+
		"\2\2\u05eb\u05ee\3\2\2\2\u05ec\u05ea\3\2\2\2\u05ed\u05d6\3\2\2\2\u05ed"+
		"\u05ee\3\2\2\2\u05ee\u0678\3\2\2\2\u05ef\u05f0\5f\64\2\u05f0\u0610\b\60"+
		"\1\2\u05f1\u05f2\7\4\2\2\u05f2\u05f4\b\60\1\2\u05f3\u05f1\3\2\2\2\u05f4"+
		"\u05f5\3\2\2\2\u05f5\u05f3\3\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u060e\3\2"+
		"\2\2\u05f7\u05f8\5t;\2\u05f8\u0604\b\60\1\2\u05f9\u05fa\7\4\2\2\u05fa"+
		"\u05fc\b\60\1\2\u05fb\u05f9\3\2\2\2\u05fc\u05fd\3\2\2\2\u05fd\u05fb\3"+
		"\2\2\2\u05fd\u05fe\3\2\2\2\u05fe\u05ff\3\2\2\2\u05ff\u0600\5t;\2\u0600"+
		"\u0601\b\60\1\2\u0601\u0603\3\2\2\2\u0602\u05fb\3\2\2\2\u0603\u0606\3"+
		"\2\2\2\u0604\u0602\3\2\2\2\u0604\u0605\3\2\2\2\u0605\u060b\3\2\2\2\u0606"+
		"\u0604\3\2\2\2\u0607\u0608\7\4\2\2\u0608\u060a\b\60\1\2\u0609\u0607\3"+
		"\2\2\2\u060a\u060d\3\2\2\2\u060b\u0609\3\2\2\2\u060b\u060c\3\2\2\2\u060c"+
		"\u060f\3\2\2\2\u060d\u060b\3\2\2\2\u060e\u05f7\3\2\2\2\u060e\u060f\3\2"+
		"\2\2\u060f\u0611\3\2\2\2\u0610\u05f3\3\2\2\2\u0610\u0611\3\2\2\2\u0611"+
		"\u0678\3\2\2\2\u0612\u0613\5l\67\2\u0613\u0633\b\60\1\2\u0614\u0615\7"+
		"\4\2\2\u0615\u0617\b\60\1\2\u0616\u0614\3\2\2\2\u0617\u0618\3\2\2\2\u0618"+
		"\u0616\3\2\2\2\u0618\u0619\3\2\2\2\u0619\u0631\3\2\2\2\u061a\u061b\5t"+
		";\2\u061b\u0627\b\60\1\2\u061c\u061d\7\4\2\2\u061d\u061f\b\60\1\2\u061e"+
		"\u061c\3\2\2\2\u061f\u0620\3\2\2\2\u0620\u061e\3\2\2\2\u0620\u0621\3\2"+
		"\2\2\u0621\u0622\3\2\2\2\u0622\u0623\5t;\2\u0623\u0624\b\60\1\2\u0624"+
		"\u0626\3\2\2\2\u0625\u061e\3\2\2\2\u0626\u0629\3\2\2\2\u0627\u0625\3\2"+
		"\2\2\u0627\u0628\3\2\2\2\u0628\u062e\3\2\2\2\u0629\u0627\3\2\2\2\u062a"+
		"\u062b\7\4\2\2\u062b\u062d\b\60\1\2\u062c\u062a\3\2\2\2\u062d\u0630\3"+
		"\2\2\2\u062e\u062c\3\2\2\2\u062e\u062f\3\2\2\2\u062f\u0632\3\2\2\2\u0630"+
		"\u062e\3\2\2\2\u0631\u061a\3\2\2\2\u0631\u0632\3\2\2\2\u0632\u0634\3\2"+
		"\2\2\u0633\u0616\3\2\2\2\u0633\u0634\3\2\2\2\u0634\u0678\3\2\2\2\u0635"+
		"\u0636\5n8\2\u0636\u0656\b\60\1\2\u0637\u0638\7\4\2\2\u0638\u063a\b\60"+
		"\1\2\u0639\u0637\3\2\2\2\u063a\u063b\3\2\2\2\u063b\u0639\3\2\2\2\u063b"+
		"\u063c\3\2\2\2\u063c\u0654\3\2\2\2\u063d\u063e\5t;\2\u063e\u064a\b\60"+
		"\1\2\u063f\u0640\7\4\2\2\u0640\u0642\b\60\1\2\u0641\u063f\3\2\2\2\u0642"+
		"\u0643\3\2\2\2\u0643\u0641\3\2\2\2\u0643\u0644\3\2\2\2\u0644\u0645\3\2"+
		"\2\2\u0645\u0646\5t;\2\u0646\u0647\b\60\1\2\u0647\u0649\3\2\2\2\u0648"+
		"\u0641\3\2\2\2\u0649\u064c\3\2\2\2\u064a\u0648\3\2\2\2\u064a\u064b\3\2"+
		"\2\2\u064b\u0651\3\2\2\2\u064c\u064a\3\2\2\2\u064d\u064e\7\4\2\2\u064e"+
		"\u0650\b\60\1\2\u064f\u064d\3\2\2\2\u0650\u0653\3\2\2\2\u0651\u064f\3"+
		"\2\2\2\u0651\u0652\3\2\2\2\u0652\u0655\3\2\2\2\u0653\u0651\3\2\2\2\u0654"+
		"\u063d\3\2\2\2\u0654\u0655\3\2\2\2\u0655\u0657\3\2\2\2\u0656\u0639\3\2"+
		"\2\2\u0656\u0657\3\2\2\2\u0657\u0678\3\2\2\2\u0658\u0659\7K\2\2\u0659"+
		"\u065a\b\60\1\2\u065a\u065b\5t;\2\u065b\u0667\b\60\1\2\u065c\u065d\7\4"+
		"\2\2\u065d\u065f\b\60\1\2\u065e\u065c\3\2\2\2\u065f\u0660\3\2\2\2\u0660"+
		"\u065e\3\2\2\2\u0660\u0661\3\2\2\2\u0661\u0662\3\2\2\2\u0662\u0663\5t"+
		";\2\u0663\u0664\b\60\1\2\u0664\u0666\3\2\2\2\u0665\u065e\3\2\2\2\u0666"+
		"\u0669\3\2\2\2\u0667\u0665\3\2\2\2\u0667\u0668\3\2\2\2\u0668\u066e\3\2"+
		"\2\2\u0669\u0667\3\2\2\2\u066a\u066b\7\4\2\2\u066b\u066d\b\60\1\2\u066c"+
		"\u066a\3\2\2\2\u066d\u0670\3\2\2\2\u066e\u066c\3\2\2\2\u066e\u066f\3\2"+
		"\2\2\u066f\u0678\3\2\2\2\u0670\u066e\3\2\2\2\u0671\u0672\7P\2\2\u0672"+
		"\u0678\b\60\1\2\u0673\u0674\7M\2\2\u0674\u0678\b\60\1\2\u0675\u0676\7"+
		"L\2\2\u0676\u0678\b\60\1\2\u0677\u0589\3\2\2\2\u0677\u05ab\3\2\2\2\u0677"+
		"\u05cd\3\2\2\2\u0677\u05ef\3\2\2\2\u0677\u0612\3\2\2\2\u0677\u0635\3\2"+
		"\2\2\u0677\u0658\3\2\2\2\u0677\u0671\3\2\2\2\u0677\u0673\3\2\2\2\u0677"+
		"\u0675\3\2\2\2\u0678_\3\2\2\2\u0679\u067a\5l\67\2\u067a\u067b\b\61\1\2"+
		"\u067b\u0686\3\2\2\2\u067c\u067d\5d\63\2\u067d\u067e\b\61\1\2\u067e\u0686"+
		"\3\2\2\2\u067f\u0680\5h\65\2\u0680\u0681\b\61\1\2\u0681\u0686\3\2\2\2"+
		"\u0682\u0683\5T+\2\u0683\u0684\b\61\1\2\u0684\u0686\3\2\2\2\u0685\u0679"+
		"\3\2\2\2\u0685\u067c\3\2\2\2\u0685\u067f\3\2\2\2\u0685\u0682\3\2\2\2\u0686"+
		"a\3\2\2\2\u0687\u0688\5V,\2\u0688\u06a0\b\62\1\2\u0689\u068a\7\4\2\2\u068a"+
		"\u068c\b\62\1\2\u068b\u0689\3\2\2\2\u068c\u068f\3\2\2\2\u068d\u068b\3"+
		"\2\2\2\u068d\u068e\3\2\2\2\u068e\u0690\3\2\2\2\u068f\u068d\3\2\2\2\u0690"+
		"\u0691\5t;\2\u0691\u069d\b\62\1\2\u0692\u0693\7\4\2\2\u0693\u0695\b\62"+
		"\1\2\u0694\u0692\3\2\2\2\u0695\u0696\3\2\2\2\u0696\u0694\3\2\2\2\u0696"+
		"\u0697\3\2\2\2\u0697\u0698\3\2\2\2\u0698\u0699\5t;\2\u0699\u069a\b\62"+
		"\1\2\u069a\u069c\3\2\2\2\u069b\u0694\3\2\2\2\u069c\u069f\3\2\2\2\u069d"+
		"\u069b\3\2\2\2\u069d\u069e\3\2\2\2\u069e\u06a1\3\2\2\2\u069f\u069d\3\2"+
		"\2\2\u06a0\u068d\3\2\2\2\u06a0\u06a1\3\2\2\2\u06a1\u073c\3\2\2\2\u06a2"+
		"\u06a3\5d\63\2\u06a3\u06bb\b\62\1\2\u06a4\u06a5\7\4\2\2\u06a5\u06a7\b"+
		"\62\1\2\u06a6\u06a4\3\2\2\2\u06a7\u06aa\3\2\2\2\u06a8\u06a6\3\2\2\2\u06a8"+
		"\u06a9\3\2\2\2\u06a9\u06ab\3\2\2\2\u06aa\u06a8\3\2\2\2\u06ab\u06ac\5t"+
		";\2\u06ac\u06b8\b\62\1\2\u06ad\u06ae\7\4\2\2\u06ae\u06b0\b\62\1\2\u06af"+
		"\u06ad\3\2\2\2\u06b0\u06b1\3\2\2\2\u06b1\u06af\3\2\2\2\u06b1\u06b2\3\2"+
		"\2\2\u06b2\u06b3\3\2\2\2\u06b3\u06b4\5t;\2\u06b4\u06b5\b\62\1\2\u06b5"+
		"\u06b7\3\2\2\2\u06b6\u06af\3\2\2\2\u06b7\u06ba\3\2\2\2\u06b8\u06b6\3\2"+
		"\2\2\u06b8\u06b9\3\2\2\2\u06b9\u06bc\3\2\2\2\u06ba\u06b8\3\2\2\2\u06bb"+
		"\u06a8\3\2\2\2\u06bb\u06bc\3\2\2\2\u06bc\u073c\3\2\2\2\u06bd\u06be\5h"+
		"\65\2\u06be\u06d6\b\62\1\2\u06bf\u06c0\7\4\2\2\u06c0\u06c2\b\62\1\2\u06c1"+
		"\u06bf\3\2\2\2\u06c2\u06c5\3\2\2\2\u06c3\u06c1\3\2\2\2\u06c3\u06c4\3\2"+
		"\2\2\u06c4\u06c6\3\2\2\2\u06c5\u06c3\3\2\2\2\u06c6\u06c7\5t;\2\u06c7\u06d3"+
		"\b\62\1\2\u06c8\u06c9\7\4\2\2\u06c9\u06cb\b\62\1\2\u06ca\u06c8\3\2\2\2"+
		"\u06cb\u06cc\3\2\2\2\u06cc\u06ca\3\2\2\2\u06cc\u06cd\3\2\2\2\u06cd\u06ce"+
		"\3\2\2\2\u06ce\u06cf\5t;\2\u06cf\u06d0\b\62\1\2\u06d0\u06d2\3\2\2\2\u06d1"+
		"\u06ca\3\2\2\2\u06d2\u06d5\3\2\2\2\u06d3\u06d1\3\2\2\2\u06d3\u06d4\3\2"+
		"\2\2\u06d4\u06d7\3\2\2\2\u06d5\u06d3\3\2\2\2\u06d6\u06c3\3\2\2\2\u06d6"+
		"\u06d7\3\2\2\2\u06d7\u073c\3\2\2\2\u06d8\u06d9\5f\64\2\u06d9\u06f1\b\62"+
		"\1\2\u06da\u06db\7\4\2\2\u06db\u06dd\b\62\1\2\u06dc\u06da\3\2\2\2\u06dd"+
		"\u06e0\3\2\2\2\u06de\u06dc\3\2\2\2\u06de\u06df\3\2\2\2\u06df\u06e1\3\2"+
		"\2\2\u06e0\u06de\3\2\2\2\u06e1\u06e2\5t;\2\u06e2\u06ee\b\62\1\2\u06e3"+
		"\u06e4\7\4\2\2\u06e4\u06e6\b\62\1\2\u06e5\u06e3\3\2\2\2\u06e6\u06e7\3"+
		"\2\2\2\u06e7\u06e5\3\2\2\2\u06e7\u06e8\3\2\2\2\u06e8\u06e9\3\2\2\2\u06e9"+
		"\u06ea\5t;\2\u06ea\u06eb\b\62\1\2\u06eb\u06ed\3\2\2\2\u06ec\u06e5\3\2"+
		"\2\2\u06ed\u06f0\3\2\2\2\u06ee\u06ec\3\2\2\2\u06ee\u06ef\3\2\2\2\u06ef"+
		"\u06f2\3\2\2\2\u06f0\u06ee\3\2\2\2\u06f1\u06de\3\2\2\2\u06f1\u06f2\3\2"+
		"\2\2\u06f2\u073c\3\2\2\2\u06f3\u06f4\5l\67\2\u06f4\u070c\b\62\1\2\u06f5"+
		"\u06f6\7\4\2\2\u06f6\u06f8\b\62\1\2\u06f7\u06f5\3\2\2\2\u06f8\u06fb\3"+
		"\2\2\2\u06f9\u06f7\3\2\2\2\u06f9\u06fa\3\2\2\2\u06fa\u06fc\3\2\2\2\u06fb"+
		"\u06f9\3\2\2\2\u06fc\u06fd\5t;\2\u06fd\u0709\b\62\1\2\u06fe\u06ff\7\4"+
		"\2\2\u06ff\u0701\b\62\1\2\u0700\u06fe\3\2\2\2\u0701\u0702\3\2\2\2\u0702"+
		"\u0700\3\2\2\2\u0702\u0703\3\2\2\2\u0703\u0704\3\2\2\2\u0704\u0705\5t"+
		";\2\u0705\u0706\b\62\1\2\u0706\u0708\3\2\2\2\u0707\u0700\3\2\2\2\u0708"+
		"\u070b\3\2\2\2\u0709\u0707\3\2\2\2\u0709\u070a\3\2\2\2\u070a\u070d\3\2"+
		"\2\2\u070b\u0709\3\2\2\2\u070c\u06f9\3\2\2\2\u070c\u070d\3\2\2\2\u070d"+
		"\u073c\3\2\2\2\u070e\u070f\5n8\2\u070f\u0727\b\62\1\2\u0710\u0711\7\4"+
		"\2\2\u0711\u0713\b\62\1\2\u0712\u0710\3\2\2\2\u0713\u0716\3\2\2\2\u0714"+
		"\u0712\3\2\2\2\u0714\u0715\3\2\2\2\u0715\u0717\3\2\2\2\u0716\u0714\3\2"+
		"\2\2\u0717\u0718\5t;\2\u0718\u0724\b\62\1\2\u0719\u071a\7\4\2\2\u071a"+
		"\u071c\b\62\1\2\u071b\u0719\3\2\2\2\u071c\u071d\3\2\2\2\u071d\u071b\3"+
		"\2\2\2\u071d\u071e\3\2\2\2\u071e\u071f\3\2\2\2\u071f\u0720\5t;\2\u0720"+
		"\u0721\b\62\1\2\u0721\u0723\3\2\2\2\u0722\u071b\3\2\2\2\u0723\u0726\3"+
		"\2\2\2\u0724\u0722\3\2\2\2\u0724\u0725\3\2\2\2\u0725\u0728\3\2\2\2\u0726"+
		"\u0724\3\2\2\2\u0727\u0714\3\2\2\2\u0727\u0728\3\2\2\2\u0728\u073c\3\2"+
		"\2\2\u0729\u072a\7K\2\2\u072a\u072b\b\62\1\2\u072b\u072c\5t;\2\u072c\u0738"+
		"\b\62\1\2\u072d\u072e\7\4\2\2\u072e\u0730\b\62\1\2\u072f\u072d\3\2\2\2"+
		"\u0730\u0731\3\2\2\2\u0731\u072f\3\2\2\2\u0731\u0732\3\2\2\2\u0732\u0733"+
		"\3\2\2\2\u0733\u0734\5t;\2\u0734\u0735\b\62\1\2\u0735\u0737\3\2\2\2\u0736"+
		"\u072f\3\2\2\2\u0737\u073a\3\2\2\2\u0738\u0736\3\2\2\2\u0738\u0739\3\2"+
		"\2\2\u0739\u073c\3\2\2\2\u073a\u0738\3\2\2\2\u073b\u0687\3\2\2\2\u073b"+
		"\u06a2\3\2\2\2\u073b\u06bd\3\2\2\2\u073b\u06d8\3\2\2\2\u073b\u06f3\3\2"+
		"\2\2\u073b\u070e\3\2\2\2\u073b\u0729\3\2\2\2\u073c\u073f\3\2\2\2\u073d"+
		"\u073e\7\4\2\2\u073e\u0740\b\62\1\2\u073f\u073d\3\2\2\2\u0740\u0741\3"+
		"\2\2\2\u0741\u073f\3\2\2\2\u0741\u0742\3\2\2\2\u0742c\3\2\2\2\u0743\u0747"+
		"\7*\2\2\u0744\u0745\5j\66\2\u0745\u0746\b\63\1\2\u0746\u0748\3\2\2\2\u0747"+
		"\u0744\3\2\2\2\u0747\u0748\3\2\2\2\u0748\u0749\3\2\2\2\u0749\u074a\7\13"+
		"\2\2\u074a\u074b\b\63\1\2\u074be\3\2\2\2\u074c\u074d\7\5\2\2\u074d\u0751"+
		"\7*\2\2\u074e\u074f\5j\66\2\u074f\u0750\b\64\1\2\u0750\u0752\3\2\2\2\u0751"+
		"\u074e\3\2\2\2\u0751\u0752\3\2\2\2\u0752\u0753\3\2\2\2\u0753\u0754\7\13"+
		"\2\2\u0754\u0755\7\63\2\2\u0755\u0756\b\64\1\2\u0756g\3\2\2\2\u0757\u0758"+
		"\7\17\2\2\u0758\u075c\7*\2\2\u0759\u075a\5j\66\2\u075a\u075b\b\65\1\2"+
		"\u075b\u075d\3\2\2\2\u075c\u0759\3\2\2\2\u075c\u075d\3\2\2\2\u075d\u075e"+
		"\3\2\2\2\u075e\u075f\7\13\2\2\u075f\u0760\b\65\1\2\u0760i\3\2\2\2\u0761"+
		"\u0762\5^\60\2\u0762\u0769\b\66\1\2\u0763\u0764\7%\2\2\u0764\u0765\5^"+
		"\60\2\u0765\u0766\b\66\1\2\u0766\u0768\3\2\2\2\u0767\u0763\3\2\2\2\u0768"+
		"\u076b\3\2\2\2\u0769\u0767\3\2\2\2\u0769\u076a\3\2\2\2\u076ak\3\2\2\2"+
		"\u076b\u0769\3\2\2\2\u076c\u076d\7\3\2\2\u076d\u076e\7A\2\2\u076e\u076f"+
		"\7\27\2\2\u076f\u0770\5^\60\2\u0770\u0771\7\"\2\2\u0771\u0772\b\67\1\2"+
		"\u0772m\3\2\2\2\u0773\u0774\7\5\2\2\u0774\u0775\7A\2\2\u0775\u0776\7\27"+
		"\2\2\u0776\u0777\5V,\2\u0777\u0778\7\63\2\2\u0778\u0779\b8\1\2\u0779o"+
		"\3\2\2\2\u077a\u077b\5V,\2\u077b\u0780\b9\1\2\u077c\u077d\7\4\2\2\u077d"+
		"\u077f\b9\1\2\u077e\u077c\3\2\2\2\u077f\u0782\3\2\2\2\u0780\u077e\3\2"+
		"\2\2\u0780\u0781\3\2\2\2\u0781\u078d\3\2\2\2\u0782\u0780\3\2\2\2\u0783"+
		"\u0784\5t;\2\u0784\u0787\b9\1\2\u0785\u0786\7\4\2\2\u0786\u0788\b9\1\2"+
		"\u0787\u0785\3\2\2\2\u0788\u0789\3\2\2\2\u0789\u0787\3\2\2\2\u0789\u078a"+
		"\3\2\2\2\u078a\u078c\3\2\2\2\u078b\u0783\3\2\2\2\u078c\u078f\3\2\2\2\u078d"+
		"\u078b\3\2\2\2\u078d\u078e\3\2\2\2\u078e\u0825\3\2\2\2\u078f\u078d\3\2"+
		"\2\2\u0790\u0791\5d\63\2\u0791\u07b1\b9\1\2\u0792\u0793\7\4\2\2\u0793"+
		"\u0795\b9\1\2\u0794\u0792\3\2\2\2\u0795\u0796\3\2\2\2\u0796\u0794\3\2"+
		"\2\2\u0796\u0797\3\2\2\2\u0797\u07a2\3\2\2\2\u0798\u0799\5t;\2\u0799\u079c"+
		"\b9\1\2\u079a\u079b\7\4\2\2\u079b\u079d\b9\1\2\u079c\u079a\3\2\2\2\u079d"+
		"\u079e\3\2\2\2\u079e\u079c\3\2\2\2\u079e\u079f\3\2\2\2\u079f\u07a1\3\2"+
		"\2\2\u07a0\u0798\3\2\2\2\u07a1\u07a4\3\2\2\2\u07a2\u07a0\3\2\2\2\u07a2"+
		"\u07a3\3\2\2\2\u07a3\u07b2\3\2\2\2\u07a4\u07a2\3\2\2\2\u07a5\u07a6\5t"+
		";\2\u07a6\u07a9\b9\1\2\u07a7\u07a8\7\4\2\2\u07a8\u07aa\b9\1\2\u07a9\u07a7"+
		"\3\2\2\2\u07aa\u07ab\3\2\2\2\u07ab\u07a9\3\2\2\2\u07ab\u07ac\3\2\2\2\u07ac"+
		"\u07ae\3\2\2\2\u07ad\u07a5\3\2\2\2\u07ae\u07af\3\2\2\2\u07af\u07ad\3\2"+
		"\2\2\u07af\u07b0\3\2\2\2\u07b0\u07b2\3\2\2\2\u07b1\u0794\3\2\2\2\u07b1"+
		"\u07ad\3\2\2\2\u07b1\u07b2\3\2\2\2\u07b2\u0825\3\2\2\2\u07b3\u07b4\5h"+
		"\65\2\u07b4\u07d4\b9\1\2\u07b5\u07b6\7\4\2\2\u07b6\u07b8\b9\1\2\u07b7"+
		"\u07b5\3\2\2\2\u07b8\u07b9\3\2\2\2\u07b9\u07b7\3\2\2\2\u07b9\u07ba\3\2"+
		"\2\2\u07ba\u07c5\3\2\2\2\u07bb\u07bc\5t;\2\u07bc\u07bf\b9\1\2\u07bd\u07be"+
		"\7\4\2\2\u07be\u07c0\b9\1\2\u07bf\u07bd\3\2\2\2\u07c0\u07c1\3\2\2\2\u07c1"+
		"\u07bf\3\2\2\2\u07c1\u07c2\3\2\2\2\u07c2\u07c4\3\2\2\2\u07c3\u07bb\3\2"+
		"\2\2\u07c4\u07c7\3\2\2\2\u07c5\u07c3\3\2\2\2\u07c5\u07c6\3\2\2\2\u07c6"+
		"\u07d5\3\2\2\2\u07c7\u07c5\3\2\2\2\u07c8\u07c9\5t;\2\u07c9\u07cc\b9\1"+
		"\2\u07ca\u07cb\7\4\2\2\u07cb\u07cd\b9\1\2\u07cc\u07ca\3\2\2\2\u07cd\u07ce"+
		"\3\2\2\2\u07ce\u07cc\3\2\2\2\u07ce\u07cf\3\2\2\2\u07cf\u07d1\3\2\2\2\u07d0"+
		"\u07c8\3\2\2\2\u07d1\u07d2\3\2\2\2\u07d2\u07d0\3\2\2\2\u07d2\u07d3\3\2"+
		"\2\2\u07d3\u07d5\3\2\2\2\u07d4\u07b7\3\2\2\2\u07d4\u07d0\3\2\2\2\u07d4"+
		"\u07d5\3\2\2\2\u07d5\u0825\3\2\2\2\u07d6\u07d7\5f\64\2\u07d7\u07da\b9"+
		"\1\2\u07d8\u07d9\7\4\2\2\u07d9\u07db\b9\1\2\u07da\u07d8\3\2\2\2\u07db"+
		"\u07dc\3\2\2\2\u07dc\u07da\3\2\2\2\u07dc\u07dd\3\2\2\2\u07dd\u07e8\3\2"+
		"\2\2\u07de\u07df\5t;\2\u07df\u07e2\b9\1\2\u07e0\u07e1\7\4\2\2\u07e1\u07e3"+
		"\b9\1\2\u07e2\u07e0\3\2\2\2\u07e3\u07e4\3\2\2\2\u07e4\u07e2\3\2\2\2\u07e4"+
		"\u07e5\3\2\2\2\u07e5\u07e7\3\2\2\2\u07e6\u07de\3\2\2\2\u07e7\u07ea\3\2"+
		"\2\2\u07e8\u07e6\3\2\2\2\u07e8\u07e9\3\2\2\2\u07e9\u0825\3\2\2\2\u07ea"+
		"\u07e8\3\2\2\2\u07eb\u07ec\5l\67\2\u07ec\u07ef\b9\1\2\u07ed\u07ee\7\4"+
		"\2\2\u07ee\u07f0\b9\1\2\u07ef\u07ed\3\2\2\2\u07f0\u07f1\3\2\2\2\u07f1"+
		"\u07ef\3\2\2\2\u07f1\u07f2\3\2\2\2\u07f2\u07fd\3\2\2\2\u07f3\u07f4\5t"+
		";\2\u07f4\u07f7\b9\1\2\u07f5\u07f6\7\4\2\2\u07f6\u07f8\b9\1\2\u07f7\u07f5"+
		"\3\2\2\2\u07f8\u07f9\3\2\2\2\u07f9\u07f7\3\2\2\2\u07f9\u07fa\3\2\2\2\u07fa"+
		"\u07fc\3\2\2\2\u07fb\u07f3\3\2\2\2\u07fc\u07ff\3\2\2\2\u07fd\u07fb\3\2"+
		"\2\2\u07fd\u07fe\3\2\2\2\u07fe\u0825\3\2\2\2\u07ff\u07fd\3\2\2\2\u0800"+
		"\u0801\5n8\2\u0801\u0804\b9\1\2\u0802\u0803\7\4\2\2\u0803\u0805\b9\1\2"+
		"\u0804\u0802\3\2\2\2\u0805\u0806\3\2\2\2\u0806\u0804\3\2\2\2\u0806\u0807"+
		"\3\2\2\2\u0807\u0812\3\2\2\2\u0808\u0809\5t;\2\u0809\u080c\b9\1\2\u080a"+
		"\u080b\7\4\2\2\u080b\u080d\b9\1\2\u080c\u080a\3\2\2\2\u080d\u080e\3\2"+
		"\2\2\u080e\u080c\3\2\2\2\u080e\u080f\3\2\2\2\u080f\u0811\3\2\2\2\u0810"+
		"\u0808\3\2\2\2\u0811\u0814\3\2\2\2\u0812\u0810\3\2\2\2\u0812\u0813\3\2"+
		"\2\2\u0813\u0825\3\2\2\2\u0814\u0812\3\2\2\2\u0815\u0816\7K\2\2\u0816"+
		"\u0821\b9\1\2\u0817\u0818\5t;\2\u0818\u081b\b9\1\2\u0819\u081a\7\4\2\2"+
		"\u081a\u081c\b9\1\2\u081b\u0819\3\2\2\2\u081c\u081d\3\2\2\2\u081d\u081b"+
		"\3\2\2\2\u081d\u081e\3\2\2\2\u081e\u0820\3\2\2\2\u081f\u0817\3\2\2\2\u0820"+
		"\u0823\3\2\2\2\u0821\u081f\3\2\2\2\u0821\u0822\3\2\2\2\u0822\u0825\3\2"+
		"\2\2\u0823\u0821\3\2\2\2\u0824\u077a\3\2\2\2\u0824\u0790\3\2\2\2\u0824"+
		"\u07b3\3\2\2\2\u0824\u07d6\3\2\2\2\u0824\u07eb\3\2\2\2\u0824\u0800\3\2"+
		"\2\2\u0824\u0815\3\2\2\2\u0825q\3\2\2\2\u0826\u0827\5V,\2\u0827\u082c"+
		"\b:\1\2\u0828\u0829\7\4\2\2\u0829\u082b\b:\1\2\u082a\u0828\3\2\2\2\u082b"+
		"\u082e\3\2\2\2\u082c\u082a\3\2\2\2\u082c\u082d\3\2\2\2\u082d\u082f\3\2"+
		"\2\2\u082e\u082c\3\2\2\2\u082f\u0830\5t;\2\u0830\u083c\b:\1\2\u0831\u0832"+
		"\7\4\2\2\u0832\u0834\b:\1\2\u0833\u0831\3\2\2\2\u0834\u0835\3\2\2\2\u0835"+
		"\u0833\3\2\2\2\u0835\u0836\3\2\2\2\u0836\u0837\3\2\2\2\u0837\u0838\5t"+
		";\2\u0838\u0839\b:\1\2\u0839\u083b\3\2\2\2\u083a\u0833\3\2\2\2\u083b\u083e"+
		"\3\2\2\2\u083c\u083a\3\2\2\2\u083c\u083d\3\2\2\2\u083d\u08cc\3\2\2\2\u083e"+
		"\u083c\3\2\2\2\u083f\u0840\5d\63\2\u0840\u0845\b:\1\2\u0841\u0842\7\4"+
		"\2\2\u0842\u0844\b:\1\2\u0843\u0841\3\2\2\2\u0844\u0847\3\2\2\2\u0845"+
		"\u0843\3\2\2\2\u0845\u0846\3\2\2\2\u0846\u0848\3\2\2\2\u0847\u0845\3\2"+
		"\2\2\u0848\u0849\5t;\2\u0849\u0855\b:\1\2\u084a\u084b\7\4\2\2\u084b\u084d"+
		"\b:\1\2\u084c\u084a\3\2\2\2\u084d\u084e\3\2\2\2\u084e\u084c\3\2\2\2\u084e"+
		"\u084f\3\2\2\2\u084f\u0850\3\2\2\2\u0850\u0851\5t;\2\u0851\u0852\b:\1"+
		"\2\u0852\u0854\3\2\2\2\u0853\u084c\3\2\2\2\u0854\u0857\3\2\2\2\u0855\u0853"+
		"\3\2\2\2\u0855\u0856\3\2\2\2\u0856\u08cc\3\2\2\2\u0857\u0855\3\2\2\2\u0858"+
		"\u0859\5h\65\2\u0859\u085e\b:\1\2\u085a\u085b\7\4\2\2\u085b\u085d\b:\1"+
		"\2\u085c\u085a\3\2\2\2\u085d\u0860\3\2\2\2\u085e\u085c\3\2\2\2\u085e\u085f"+
		"\3\2\2\2\u085f\u0861\3\2\2\2\u0860\u085e\3\2\2\2\u0861\u0862\5t;\2\u0862"+
		"\u086e\b:\1\2\u0863\u0864\7\4\2\2\u0864\u0866\b:\1\2\u0865\u0863\3\2\2"+
		"\2\u0866\u0867\3\2\2\2\u0867\u0865\3\2\2\2\u0867\u0868\3\2\2\2\u0868\u0869"+
		"\3\2\2\2\u0869\u086a\5t;\2\u086a\u086b\b:\1\2\u086b\u086d\3\2\2\2\u086c"+
		"\u0865\3\2\2\2\u086d\u0870\3\2\2\2\u086e\u086c\3\2\2\2\u086e\u086f\3\2"+
		"\2\2\u086f\u08cc\3\2\2\2\u0870\u086e\3\2\2\2\u0871\u0872\5f\64\2\u0872"+
		"\u0875\b:\1\2\u0873\u0874\7\4\2\2\u0874\u0876\b:\1\2\u0875\u0873\3\2\2"+
		"\2\u0876\u0877\3\2\2\2\u0877\u0875\3\2\2\2\u0877\u0878\3\2\2\2\u0878\u0879"+
		"\3\2\2\2\u0879\u087a\5t;\2\u087a\u0886\b:\1\2\u087b\u087c\7\4\2\2\u087c"+
		"\u087e\b:\1\2\u087d\u087b\3\2\2\2\u087e\u087f\3\2\2\2\u087f\u087d\3\2"+
		"\2\2\u087f\u0880\3\2\2\2\u0880\u0881\3\2\2\2\u0881\u0882\5t;\2\u0882\u0883"+
		"\b:\1\2\u0883\u0885\3\2\2\2\u0884\u087d\3\2\2\2\u0885\u0888\3\2\2\2\u0886"+
		"\u0884\3\2\2\2\u0886\u0887\3\2\2\2\u0887\u08cc\3\2\2\2\u0888\u0886\3\2"+
		"\2\2\u0889\u088a\5l\67\2\u088a\u088d\b:\1\2\u088b\u088c\7\4\2\2\u088c"+
		"\u088e\b:\1\2\u088d\u088b\3\2\2\2\u088e\u088f\3\2\2\2\u088f\u088d\3\2"+
		"\2\2\u088f\u0890\3\2\2\2\u0890\u0891\3\2\2\2\u0891\u0892\5t;\2\u0892\u089e"+
		"\b:\1\2\u0893\u0894\7\4\2\2\u0894\u0896\b:\1\2\u0895\u0893\3\2\2\2\u0896"+
		"\u0897\3\2\2\2\u0897\u0895\3\2\2\2\u0897\u0898\3\2\2\2\u0898\u0899\3\2"+
		"\2\2\u0899\u089a\5t;\2\u089a\u089b\b:\1\2\u089b\u089d\3\2\2\2\u089c\u0895"+
		"\3\2\2\2\u089d\u08a0\3\2\2\2\u089e\u089c\3\2\2\2\u089e\u089f\3\2\2\2\u089f"+
		"\u08cc\3\2\2\2\u08a0\u089e\3\2\2\2\u08a1\u08a2\5n8\2\u08a2\u08a5\b:\1"+
		"\2\u08a3\u08a4\7\4\2\2\u08a4\u08a6\b:\1\2\u08a5\u08a3\3\2\2\2\u08a6\u08a7"+
		"\3\2\2\2\u08a7\u08a5\3\2\2\2\u08a7\u08a8\3\2\2\2\u08a8\u08a9\3\2\2\2\u08a9"+
		"\u08aa\5t;\2\u08aa\u08b6\b:\1\2\u08ab\u08ac\7\4\2\2\u08ac\u08ae\b:\1\2"+
		"\u08ad\u08ab\3\2\2\2\u08ae\u08af\3\2\2\2\u08af\u08ad\3\2\2\2\u08af\u08b0"+
		"\3\2\2\2\u08b0\u08b1\3\2\2\2\u08b1\u08b2\5t;\2\u08b2\u08b3\b:\1\2\u08b3"+
		"\u08b5\3\2\2\2\u08b4\u08ad\3\2\2\2\u08b5\u08b8\3\2\2\2\u08b6\u08b4\3\2"+
		"\2\2\u08b6\u08b7\3\2\2\2\u08b7\u08cc\3\2\2\2\u08b8\u08b6\3\2\2\2\u08b9"+
		"\u08ba\7K\2\2\u08ba\u08bb\b:\1\2\u08bb\u08bc\5t;\2\u08bc\u08c8\b:\1\2"+
		"\u08bd\u08be\7\4\2\2\u08be\u08c0\b:\1\2\u08bf\u08bd\3\2\2\2\u08c0\u08c1"+
		"\3\2\2\2\u08c1\u08bf\3\2\2\2\u08c1\u08c2\3\2\2\2\u08c2\u08c3\3\2\2\2\u08c3"+
		"\u08c4\5t;\2\u08c4\u08c5\b:\1\2\u08c5\u08c7\3\2\2\2\u08c6\u08bf\3\2\2"+
		"\2\u08c7\u08ca\3\2\2\2\u08c8\u08c6\3\2\2\2\u08c8\u08c9\3\2\2\2\u08c9\u08cc"+
		"\3\2\2\2\u08ca\u08c8\3\2\2\2\u08cb\u0826\3\2\2\2\u08cb\u083f\3\2\2\2\u08cb"+
		"\u0858\3\2\2\2\u08cb\u0871\3\2\2\2\u08cb\u0889\3\2\2\2\u08cb\u08a1\3\2"+
		"\2\2\u08cb\u08b9\3\2\2\2\u08ccs\3\2\2\2\u08cd\u08e0\7&\2\2\u08ce\u08cf"+
		"\7)\2\2\u08cf\u08e1\b;\1\2\u08d0\u08d1\5\\/\2\u08d1\u08d8\b;\1\2\u08d2"+
		"\u08d3\7%\2\2\u08d3\u08d4\5\\/\2\u08d4\u08d5\b;\1\2\u08d5\u08d7\3\2\2"+
		"\2\u08d6\u08d2\3\2\2\2\u08d7\u08da\3\2\2\2\u08d8\u08d6\3\2\2\2\u08d8\u08d9"+
		"\3\2\2\2\u08d9\u08de\3\2\2\2\u08da\u08d8\3\2\2\2\u08db\u08dc\7%\2\2\u08dc"+
		"\u08dd\7)\2\2\u08dd\u08df\b;\1\2\u08de\u08db\3\2\2\2\u08de\u08df\3\2\2"+
		"\2\u08df\u08e1\3\2\2\2\u08e0\u08ce\3\2\2\2\u08e0\u08d0\3\2\2\2\u08e0\u08e1"+
		"\3\2\2\2\u08e1\u08e2\3\2\2\2\u08e2\u08e3\7\20\2\2\u08e3u\3\2\2\2\u08e4"+
		"\u08e5\7+\2\2\u08e5\u08ef\b<\1\2\u08e6\u08e7\7\21\2\2\u08e7\u08e8\7T\2"+
		"\2\u08e8\u08ef\b<\1\2\u08e9\u08ea\5z>\2\u08ea\u08eb\b<\1\2\u08eb\u08ef"+
		"\3\2\2\2\u08ec\u08ed\7@\2\2\u08ed\u08ef\b<\1\2\u08ee\u08e4\3\2\2\2\u08ee"+
		"\u08e6\3\2\2\2\u08ee\u08e9\3\2\2\2\u08ee\u08ec\3\2\2\2\u08efw\3\2\2\2"+
		"\u08f0\u08f1\7A\2\2\u08f1\u08f6\b=\1\2\u08f2\u08f3\5> \2\u08f3\u08f4\b"+
		"=\1\2\u08f4\u08f6\3\2\2\2\u08f5\u08f0\3\2\2\2\u08f5\u08f2\3\2\2\2\u08f6"+
		"y\3\2\2\2\u08f7\u08f8\5B\"\2\u08f8\u08f9\b>\1\2\u08f9\u090d\3\2\2\2\u08fa"+
		"\u08fb\5D#\2\u08fb\u08fc\b>\1\2\u08fc\u090d\3\2\2\2\u08fd\u08fe\5F$\2"+
		"\u08fe\u08ff\b>\1\2\u08ff\u090d\3\2\2\2\u0900\u0901\5H%\2\u0901\u0902"+
		"\b>\1\2\u0902\u090d\3\2\2\2\u0903\u0904\5~@\2\u0904\u0905\b>\1\2\u0905"+
		"\u090d\3\2\2\2\u0906\u0907\5|?\2\u0907\u0908\b>\1\2\u0908\u090d\3\2\2"+
		"\2\u0909\u090a\5\u0088E\2\u090a\u090b\b>\1\2\u090b\u090d\3\2\2\2\u090c"+
		"\u08f7\3\2\2\2\u090c\u08fa\3\2\2\2\u090c\u08fd\3\2\2\2\u090c\u0900\3\2"+
		"\2\2\u090c\u0903\3\2\2\2\u090c\u0906\3\2\2\2\u090c\u0909\3\2\2\2\u090d"+
		"{\3\2\2\2\u090e\u090f\7A\2\2\u090f\u0919\b?\1\2\u0910\u0911\7D\2\2\u0911"+
		"\u0919\b?\1\2\u0912\u0913\7B\2\2\u0913\u0919\b?\1\2\u0914\u0915\7C\2\2"+
		"\u0915\u0919\b?\1\2\u0916\u0917\7U\2\2\u0917\u0919\b?\1\2\u0918\u090e"+
		"\3\2\2\2\u0918\u0910\3\2\2\2\u0918\u0912\3\2\2\2\u0918\u0914\3\2\2\2\u0918"+
		"\u0916\3\2\2\2\u0919}\3\2\2\2\u091a\u091b\5\u0082B\2\u091b\u091c\b@\1"+
		"\2\u091c\u0924\3\2\2\2\u091d\u091e\5\u0084C\2\u091e\u091f\b@\1\2\u091f"+
		"\u0924\3\2\2\2\u0920\u0921\5\u0086D\2\u0921\u0922\b@\1\2\u0922\u0924\3"+
		"\2\2\2\u0923\u091a\3\2\2\2\u0923\u091d\3\2\2\2\u0923\u0920\3\2\2\2\u0924"+
		"\177\3\2\2\2\u0925\u0926\5^\60\2\u0926\u092d\5v<\2\u0927\u0928\7%\2\2"+
		"\u0928\u0929\5^\60\2\u0929\u092a\5v<\2\u092a\u092c\3\2\2\2\u092b\u0927"+
		"\3\2\2\2\u092c\u092f\3\2\2\2\u092d\u092b\3\2\2\2\u092d\u092e\3\2\2\2\u092e"+
		"\u0081\3\2\2\2\u092f\u092d\3\2\2\2\u0930\u0931\7*\2\2\u0931\u0932\5\u0080"+
		"A\2\u0932\u0933\7\13\2\2\u0933\u0083\3\2\2\2\u0934\u0935\7\3\2\2\u0935"+
		"\u0936\5\u0080A\2\u0936\u0937\7\"\2\2\u0937\u0085\3\2\2\2\u0938\u0939"+
		"\7\5\2\2\u0939\u093a\5\u0080A\2\u093a\u093b\7\63\2\2\u093b\u0087\3\2\2"+
		"\2\u093c\u093d\7V\2\2\u093d\u093e\bE\1\2\u093e\u0089\3\2\2\2\u093f\u0940"+
		"\7@\2\2\u0940\u0947\bF\1\2\u0941\u0942\7?\2\2\u0942\u0947\bF\1\2\u0943"+
		"\u0944\5\u008cG\2\u0944\u0945\bF\1\2\u0945\u0947\3\2\2\2\u0946\u093f\3"+
		"\2\2\2\u0946\u0941\3\2\2\2\u0946\u0943\3\2\2\2\u0947\u008b\3\2\2\2\u0948"+
		"\u094a\7\7\2\2\u0949\u094b\7\b\2\2\u094a\u0949\3\2\2\2\u094a\u094b\3\2"+
		"\2\2\u094b\u094d\3\2\2\2\u094c\u094e\7\61\2\2\u094d\u094c\3\2\2\2\u094d"+
		"\u094e\3\2\2\2\u094e\u094f\3\2\2\2\u094f\u0950\7T\2\2\u0950\u0951\7%\2"+
		"\2\u0951\u0952\7T\2\2\u0952\u008d\3\2\2\2\u011b\u0091\u0098\u00a0\u00a8"+
		"\u00b2\u00b4\u00cc\u00cf\u00d3\u00d6\u00db\u00e5\u00eb\u00ed\u00f5\u00f9"+
		"\u0103\u0107\u010b\u0111\u011d\u0123\u0129\u012d\u0131\u0137\u0145\u0147"+
		"\u014d\u0155\u015b\u0162\u016a\u0180\u0184\u0193\u01a4\u01b6\u01bf\u01cb"+
		"\u01cd\u01d0\u01f1\u01f4\u01fd\u0201\u0205\u020d\u023e\u0243\u0254\u0261"+
		"\u026f\u027b\u0281\u0288\u0292\u0296\u02a5\u02ad\u02b9\u02cc\u02d4\u02e5"+
		"\u02ed\u030b\u030f\u0322\u0326\u032d\u0333\u0341\u034c\u0352\u0357\u0361"+
		"\u0367\u036c\u0372\u0378\u037a\u037c\u0384\u039b\u03a0\u03ad\u03be\u03c2"+
		"\u03c6\u03cf\u03da\u03e5\u03ef\u03f1\u03fa\u0405\u0419\u041e\u0425\u0438"+
		"\u0440\u0449\u044d\u0456\u045e\u0462\u046b\u046f\u0471\u0479\u0481\u0485"+
		"\u048e\u0492\u0494\u049c\u04a4\u04a8\u04b1\u04b9\u04bd\u04c6\u04ce\u04d2"+
		"\u04dd\u04e1\u04e3\u04ee\u04f6\u04ff\u0503\u050c\u0515\u0519\u0522\u052b"+
		"\u052f\u0538\u0540\u0544\u054d\u0555\u0559\u055c\u0564\u056c\u0570\u0573"+
		"\u057d\u0581\u0587\u058f\u0598\u059f\u05a6\u05a9\u05b1\u05ba\u05c1\u05c8"+
		"\u05cb\u05d3\u05dc\u05e3\u05ea\u05ed\u05f5\u05fd\u0604\u060b\u060e\u0610"+
		"\u0618\u0620\u0627\u062e\u0631\u0633\u063b\u0643\u064a\u0651\u0654\u0656"+
		"\u0660\u0667\u066e\u0677\u0685\u068d\u0696\u069d\u06a0\u06a8\u06b1\u06b8"+
		"\u06bb\u06c3\u06cc\u06d3\u06d6\u06de\u06e7\u06ee\u06f1\u06f9\u0702\u0709"+
		"\u070c\u0714\u071d\u0724\u0727\u0731\u0738\u073b\u0741\u0747\u0751\u075c"+
		"\u0769\u0780\u0789\u078d\u0796\u079e\u07a2\u07ab\u07af\u07b1\u07b9\u07c1"+
		"\u07c5\u07ce\u07d2\u07d4\u07dc\u07e4\u07e8\u07f1\u07f9\u07fd\u0806\u080e"+
		"\u0812\u081d\u0821\u0824\u082c\u0835\u083c\u0845\u084e\u0855\u085e\u0867"+
		"\u086e\u0877\u087f\u0886\u088f\u0897\u089e\u08a7\u08af\u08b6\u08c1\u08c8"+
		"\u08cb\u08d8\u08de\u08e0\u08ee\u08f5\u090c\u0918\u0923\u092d\u0946\u094a"+
		"\u094d";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}