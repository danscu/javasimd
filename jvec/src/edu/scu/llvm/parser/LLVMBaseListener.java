// Generated from LLVM.g4 by ANTLR 4.0

package edu.scu.llvm.parser;

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import cn.edu.sjtu.jllvm.VMCore.*;
import cn.edu.sjtu.jllvm.VMCore.Types.*;
import cn.edu.sjtu.jllvm.VMCore.Constants.*;
import cn.edu.sjtu.jllvm.VMCore.Operators.*;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;

import edu.scu.llvm.asm.*;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class LLVMBaseListener implements LLVMListener {
	@Override public void enterExpression(LLVMParser.ExpressionContext ctx) { }
	@Override public void exitExpression(LLVMParser.ExpressionContext ctx) { }

	@Override public void enterUndef_constant(LLVMParser.Undef_constantContext ctx) { }
	@Override public void exitUndef_constant(LLVMParser.Undef_constantContext ctx) { }

	@Override public void enterLlvm_align(LLVMParser.Llvm_alignContext ctx) { }
	@Override public void exitLlvm_align(LLVMParser.Llvm_alignContext ctx) { }

	@Override public void enterGlobal_variable(LLVMParser.Global_variableContext ctx) { }
	@Override public void exitGlobal_variable(LLVMParser.Global_variableContext ctx) { }

	@Override public void enterConversion_expr(LLVMParser.Conversion_exprContext ctx) { }
	@Override public void exitConversion_expr(LLVMParser.Conversion_exprContext ctx) { }

	@Override public void enterUnion_type(LLVMParser.Union_typeContext ctx) { }
	@Override public void exitUnion_type(LLVMParser.Union_typeContext ctx) { }

	@Override public void enterAliases_variable(LLVMParser.Aliases_variableContext ctx) { }
	@Override public void exitAliases_variable(LLVMParser.Aliases_variableContext ctx) { }

	@Override public void enterVector_constant(LLVMParser.Vector_constantContext ctx) { }
	@Override public void exitVector_constant(LLVMParser.Vector_constantContext ctx) { }

	@Override public void enterCall_op(LLVMParser.Call_opContext ctx) { }
	@Override public void exitCall_op(LLVMParser.Call_opContext ctx) { }

	@Override public void enterMetadata_expr(LLVMParser.Metadata_exprContext ctx) { }
	@Override public void exitMetadata_expr(LLVMParser.Metadata_exprContext ctx) { }

	@Override public void enterMetadata_list(LLVMParser.Metadata_listContext ctx) { }
	@Override public void exitMetadata_list(LLVMParser.Metadata_listContext ctx) { }

	@Override public void enterAssembly_expr(LLVMParser.Assembly_exprContext ctx) { }
	@Override public void exitAssembly_expr(LLVMParser.Assembly_exprContext ctx) { }

	@Override public void enterFunction_name(LLVMParser.Function_nameContext ctx) { }
	@Override public void exitFunction_name(LLVMParser.Function_nameContext ctx) { }

	@Override public void enterAggregate_op(LLVMParser.Aggregate_opContext ctx) { }
	@Override public void exitAggregate_op(LLVMParser.Aggregate_opContext ctx) { }

	@Override public void enterFunction_definition(LLVMParser.Function_definitionContext ctx) { }
	@Override public void exitFunction_definition(LLVMParser.Function_definitionContext ctx) { }

	@Override public void enterIcmp_op(LLVMParser.Icmp_opContext ctx) { }
	@Override public void exitIcmp_op(LLVMParser.Icmp_opContext ctx) { }

	@Override public void enterIndex(LLVMParser.IndexContext ctx) { }
	@Override public void exitIndex(LLVMParser.IndexContext ctx) { }

	@Override public void enterTerminator(LLVMParser.TerminatorContext ctx) { }
	@Override public void exitTerminator(LLVMParser.TerminatorContext ctx) { }

	@Override public void enterArray_constant(LLVMParser.Array_constantContext ctx) { }
	@Override public void exitArray_constant(LLVMParser.Array_constantContext ctx) { }

	@Override public void enterBasic_block(LLVMParser.Basic_blockContext ctx) { }
	@Override public void exitBasic_block(LLVMParser.Basic_blockContext ctx) { }

	@Override public void enterConstant_list(LLVMParser.Constant_listContext ctx) { }
	@Override public void exitConstant_list(LLVMParser.Constant_listContext ctx) { }

	@Override public void enterReturn_type(LLVMParser.Return_typeContext ctx) { }
	@Override public void exitReturn_type(LLVMParser.Return_typeContext ctx) { }

	@Override public void enterGetelementptr_expr(LLVMParser.Getelementptr_exprContext ctx) { }
	@Override public void exitGetelementptr_expr(LLVMParser.Getelementptr_exprContext ctx) { }

	@Override public void enterVector_type(LLVMParser.Vector_typeContext ctx) { }
	@Override public void exitVector_type(LLVMParser.Vector_typeContext ctx) { }

	@Override public void enterPacked_structure_type(LLVMParser.Packed_structure_typeContext ctx) { }
	@Override public void exitPacked_structure_type(LLVMParser.Packed_structure_typeContext ctx) { }

	@Override public void enterElement_type(LLVMParser.Element_typeContext ctx) { }
	@Override public void exitElement_type(LLVMParser.Element_typeContext ctx) { }

	@Override public void enterCmp_expr(LLVMParser.Cmp_exprContext ctx) { }
	@Override public void exitCmp_expr(LLVMParser.Cmp_exprContext ctx) { }

	@Override public void enterFirst_class_type(LLVMParser.First_class_typeContext ctx) { }
	@Override public void exitFirst_class_type(LLVMParser.First_class_typeContext ctx) { }

	@Override public void enterStructure_type(LLVMParser.Structure_typeContext ctx) { }
	@Override public void exitStructure_type(LLVMParser.Structure_typeContext ctx) { }

	@Override public void enterComplex_constant(LLVMParser.Complex_constantContext ctx) { }
	@Override public void exitComplex_constant(LLVMParser.Complex_constantContext ctx) { }

	@Override public void enterFunction_call(LLVMParser.Function_callContext ctx) { }
	@Override public void exitFunction_call(LLVMParser.Function_callContext ctx) { }

	@Override public void enterMetadata_variable(LLVMParser.Metadata_variableContext ctx) { }
	@Override public void exitMetadata_variable(LLVMParser.Metadata_variableContext ctx) { }

	@Override public void enterType_list(LLVMParser.Type_listContext ctx) { }
	@Override public void exitType_list(LLVMParser.Type_listContext ctx) { }

	@Override public void enterArgument_list(LLVMParser.Argument_listContext ctx) { }
	@Override public void exitArgument_list(LLVMParser.Argument_listContext ctx) { }

	@Override public void enterGetelementptr_op(LLVMParser.Getelementptr_opContext ctx) { }
	@Override public void exitGetelementptr_op(LLVMParser.Getelementptr_opContext ctx) { }

	@Override public void enterMemory_op(LLVMParser.Memory_opContext ctx) { }
	@Override public void exitMemory_op(LLVMParser.Memory_opContext ctx) { }

	@Override public void enterBinary_op(LLVMParser.Binary_opContext ctx) { }
	@Override public void exitBinary_op(LLVMParser.Binary_opContext ctx) { }

	@Override public void enterSelect_op(LLVMParser.Select_opContext ctx) { }
	@Override public void exitSelect_op(LLVMParser.Select_opContext ctx) { }

	@Override public void enterParameter_type_list(LLVMParser.Parameter_type_listContext ctx) { }
	@Override public void exitParameter_type_list(LLVMParser.Parameter_type_listContext ctx) { }

	@Override public void enterAggregate_type(LLVMParser.Aggregate_typeContext ctx) { }
	@Override public void exitAggregate_type(LLVMParser.Aggregate_typeContext ctx) { }

	@Override public void enterDbg_metadata(LLVMParser.Dbg_metadataContext ctx) { }
	@Override public void exitDbg_metadata(LLVMParser.Dbg_metadataContext ctx) { }

	@Override public void enterBlock_label(LLVMParser.Block_labelContext ctx) { }
	@Override public void exitBlock_label(LLVMParser.Block_labelContext ctx) { }

	@Override public void enterPhi_op(LLVMParser.Phi_opContext ctx) { }
	@Override public void exitPhi_op(LLVMParser.Phi_opContext ctx) { }

	@Override public void enterId_type(LLVMParser.Id_typeContext ctx) { }
	@Override public void exitId_type(LLVMParser.Id_typeContext ctx) { }

	@Override public void enterSimple_constant(LLVMParser.Simple_constantContext ctx) { }
	@Override public void exitSimple_constant(LLVMParser.Simple_constantContext ctx) { }

	@Override public void enterPrimitive_type(LLVMParser.Primitive_typeContext ctx) { }
	@Override public void exitPrimitive_type(LLVMParser.Primitive_typeContext ctx) { }

	@Override public void enterArray_type(LLVMParser.Array_typeContext ctx) { }
	@Override public void exitArray_type(LLVMParser.Array_typeContext ctx) { }

	@Override public void enterLoad_op(LLVMParser.Load_opContext ctx) { }
	@Override public void exitLoad_op(LLVMParser.Load_opContext ctx) { }

	@Override public void enterFcmp_op(LLVMParser.Fcmp_opContext ctx) { }
	@Override public void exitFcmp_op(LLVMParser.Fcmp_opContext ctx) { }

	@Override public void enterMetadata_definition(LLVMParser.Metadata_definitionContext ctx) { }
	@Override public void exitMetadata_definition(LLVMParser.Metadata_definitionContext ctx) { }

	@Override public void enterStore_op(LLVMParser.Store_opContext ctx) { }
	@Override public void exitStore_op(LLVMParser.Store_opContext ctx) { }

	@Override public void enterModule(LLVMParser.ModuleContext ctx) { }
	@Override public void exitModule(LLVMParser.ModuleContext ctx) { }

	@Override public void enterFunction_declaration(LLVMParser.Function_declarationContext ctx) { }
	@Override public void exitFunction_declaration(LLVMParser.Function_declarationContext ctx) { }

	@Override public void enterAlloca_op(LLVMParser.Alloca_opContext ctx) { }
	@Override public void exitAlloca_op(LLVMParser.Alloca_opContext ctx) { }

	@Override public void enterVector_op(LLVMParser.Vector_opContext ctx) { }
	@Override public void exitVector_op(LLVMParser.Vector_opContext ctx) { }

	@Override public void enterLlvm_program(LLVMParser.Llvm_programContext ctx) { }
	@Override public void exitLlvm_program(LLVMParser.Llvm_programContext ctx) { }

	@Override public void enterLlvm_section(LLVMParser.Llvm_sectionContext ctx) { }
	@Override public void exitLlvm_section(LLVMParser.Llvm_sectionContext ctx) { }

	@Override public void enterPointer_type(LLVMParser.Pointer_typeContext ctx) { }
	@Override public void exitPointer_type(LLVMParser.Pointer_typeContext ctx) { }

	@Override public void enterOperator(LLVMParser.OperatorContext ctx) { }
	@Override public void exitOperator(LLVMParser.OperatorContext ctx) { }

	@Override public void enterLlvm_constant(LLVMParser.Llvm_constantContext ctx) { }
	@Override public void exitLlvm_constant(LLVMParser.Llvm_constantContext ctx) { }

	@Override public void enterFunction_type(LLVMParser.Function_typeContext ctx) { }
	@Override public void exitFunction_type(LLVMParser.Function_typeContext ctx) { }

	@Override public void enterConversion_op(LLVMParser.Conversion_opContext ctx) { }
	@Override public void exitConversion_op(LLVMParser.Conversion_opContext ctx) { }

	@Override public void enterDerived_type(LLVMParser.Derived_typeContext ctx) { }
	@Override public void exitDerived_type(LLVMParser.Derived_typeContext ctx) { }

	@Override public void enterScalar_type(LLVMParser.Scalar_typeContext ctx) { }
	@Override public void exitScalar_type(LLVMParser.Scalar_typeContext ctx) { }

	@Override public void enterNamed_type(LLVMParser.Named_typeContext ctx) { }
	@Override public void exitNamed_type(LLVMParser.Named_typeContext ctx) { }

	@Override public void enterBinary_expr(LLVMParser.Binary_exprContext ctx) { }
	@Override public void exitBinary_expr(LLVMParser.Binary_exprContext ctx) { }

	@Override public void enterTarget(LLVMParser.TargetContext ctx) { }
	@Override public void exitTarget(LLVMParser.TargetContext ctx) { }

	@Override public void enterVariable(LLVMParser.VariableContext ctx) { }
	@Override public void exitVariable(LLVMParser.VariableContext ctx) { }

	@Override public void enterStructure_constant(LLVMParser.Structure_constantContext ctx) { }
	@Override public void exitStructure_constant(LLVMParser.Structure_constantContext ctx) { }

	@Override public void enterInitializer(LLVMParser.InitializerContext ctx) { }
	@Override public void exitInitializer(LLVMParser.InitializerContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}