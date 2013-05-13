// Generated from LLVM.g4 by ANTLR 4.0

package cn.edu.sjtu.jllvm.VMCore.Parser;

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import cn.edu.sjtu.jllvm.VMCore.*;
import cn.edu.sjtu.jllvm.VMCore.Types.*;
import cn.edu.sjtu.jllvm.VMCore.Constants.*;
import cn.edu.sjtu.jllvm.VMCore.Operators.*;
import cn.edu.sjtu.jllvm.VMCore.Instructions.Instruction;

import edu.scu.jvec.Instructions.*;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface LLVMListener extends ParseTreeListener {
	void enterExpression(LLVMParser.ExpressionContext ctx);
	void exitExpression(LLVMParser.ExpressionContext ctx);

	void enterUndef_constant(LLVMParser.Undef_constantContext ctx);
	void exitUndef_constant(LLVMParser.Undef_constantContext ctx);

	void enterLlvm_align(LLVMParser.Llvm_alignContext ctx);
	void exitLlvm_align(LLVMParser.Llvm_alignContext ctx);

	void enterGlobal_variable(LLVMParser.Global_variableContext ctx);
	void exitGlobal_variable(LLVMParser.Global_variableContext ctx);

	void enterConversion_expr(LLVMParser.Conversion_exprContext ctx);
	void exitConversion_expr(LLVMParser.Conversion_exprContext ctx);

	void enterUnion_type(LLVMParser.Union_typeContext ctx);
	void exitUnion_type(LLVMParser.Union_typeContext ctx);

	void enterAliases_variable(LLVMParser.Aliases_variableContext ctx);
	void exitAliases_variable(LLVMParser.Aliases_variableContext ctx);

	void enterVector_constant(LLVMParser.Vector_constantContext ctx);
	void exitVector_constant(LLVMParser.Vector_constantContext ctx);

	void enterCall_op(LLVMParser.Call_opContext ctx);
	void exitCall_op(LLVMParser.Call_opContext ctx);

	void enterMetadata_expr(LLVMParser.Metadata_exprContext ctx);
	void exitMetadata_expr(LLVMParser.Metadata_exprContext ctx);

	void enterMetadata_list(LLVMParser.Metadata_listContext ctx);
	void exitMetadata_list(LLVMParser.Metadata_listContext ctx);

	void enterAssembly_expr(LLVMParser.Assembly_exprContext ctx);
	void exitAssembly_expr(LLVMParser.Assembly_exprContext ctx);

	void enterFunction_name(LLVMParser.Function_nameContext ctx);
	void exitFunction_name(LLVMParser.Function_nameContext ctx);

	void enterAggregate_op(LLVMParser.Aggregate_opContext ctx);
	void exitAggregate_op(LLVMParser.Aggregate_opContext ctx);

	void enterFunction_definition(LLVMParser.Function_definitionContext ctx);
	void exitFunction_definition(LLVMParser.Function_definitionContext ctx);

	void enterIcmp_op(LLVMParser.Icmp_opContext ctx);
	void exitIcmp_op(LLVMParser.Icmp_opContext ctx);

	void enterIndex(LLVMParser.IndexContext ctx);
	void exitIndex(LLVMParser.IndexContext ctx);

	void enterTerminator(LLVMParser.TerminatorContext ctx);
	void exitTerminator(LLVMParser.TerminatorContext ctx);

	void enterArray_constant(LLVMParser.Array_constantContext ctx);
	void exitArray_constant(LLVMParser.Array_constantContext ctx);

	void enterBasic_block(LLVMParser.Basic_blockContext ctx);
	void exitBasic_block(LLVMParser.Basic_blockContext ctx);

	void enterConstant_list(LLVMParser.Constant_listContext ctx);
	void exitConstant_list(LLVMParser.Constant_listContext ctx);

	void enterReturn_type(LLVMParser.Return_typeContext ctx);
	void exitReturn_type(LLVMParser.Return_typeContext ctx);

	void enterGetelementptr_expr(LLVMParser.Getelementptr_exprContext ctx);
	void exitGetelementptr_expr(LLVMParser.Getelementptr_exprContext ctx);

	void enterVector_type(LLVMParser.Vector_typeContext ctx);
	void exitVector_type(LLVMParser.Vector_typeContext ctx);

	void enterPacked_structure_type(LLVMParser.Packed_structure_typeContext ctx);
	void exitPacked_structure_type(LLVMParser.Packed_structure_typeContext ctx);

	void enterElement_type(LLVMParser.Element_typeContext ctx);
	void exitElement_type(LLVMParser.Element_typeContext ctx);

	void enterCmp_expr(LLVMParser.Cmp_exprContext ctx);
	void exitCmp_expr(LLVMParser.Cmp_exprContext ctx);

	void enterFirst_class_type(LLVMParser.First_class_typeContext ctx);
	void exitFirst_class_type(LLVMParser.First_class_typeContext ctx);

	void enterStructure_type(LLVMParser.Structure_typeContext ctx);
	void exitStructure_type(LLVMParser.Structure_typeContext ctx);

	void enterComplex_constant(LLVMParser.Complex_constantContext ctx);
	void exitComplex_constant(LLVMParser.Complex_constantContext ctx);

	void enterFunction_call(LLVMParser.Function_callContext ctx);
	void exitFunction_call(LLVMParser.Function_callContext ctx);

	void enterMetadata_variable(LLVMParser.Metadata_variableContext ctx);
	void exitMetadata_variable(LLVMParser.Metadata_variableContext ctx);

	void enterType_list(LLVMParser.Type_listContext ctx);
	void exitType_list(LLVMParser.Type_listContext ctx);

	void enterArgument_list(LLVMParser.Argument_listContext ctx);
	void exitArgument_list(LLVMParser.Argument_listContext ctx);

	void enterGetelementptr_op(LLVMParser.Getelementptr_opContext ctx);
	void exitGetelementptr_op(LLVMParser.Getelementptr_opContext ctx);

	void enterMemory_op(LLVMParser.Memory_opContext ctx);
	void exitMemory_op(LLVMParser.Memory_opContext ctx);

	void enterBinary_op(LLVMParser.Binary_opContext ctx);
	void exitBinary_op(LLVMParser.Binary_opContext ctx);

	void enterSelect_op(LLVMParser.Select_opContext ctx);
	void exitSelect_op(LLVMParser.Select_opContext ctx);

	void enterParameter_type_list(LLVMParser.Parameter_type_listContext ctx);
	void exitParameter_type_list(LLVMParser.Parameter_type_listContext ctx);

	void enterAggregate_type(LLVMParser.Aggregate_typeContext ctx);
	void exitAggregate_type(LLVMParser.Aggregate_typeContext ctx);

	void enterDbg_metadata(LLVMParser.Dbg_metadataContext ctx);
	void exitDbg_metadata(LLVMParser.Dbg_metadataContext ctx);

	void enterBlock_label(LLVMParser.Block_labelContext ctx);
	void exitBlock_label(LLVMParser.Block_labelContext ctx);

	void enterPhi_op(LLVMParser.Phi_opContext ctx);
	void exitPhi_op(LLVMParser.Phi_opContext ctx);

	void enterId_type(LLVMParser.Id_typeContext ctx);
	void exitId_type(LLVMParser.Id_typeContext ctx);

	void enterSimple_constant(LLVMParser.Simple_constantContext ctx);
	void exitSimple_constant(LLVMParser.Simple_constantContext ctx);

	void enterPrimitive_type(LLVMParser.Primitive_typeContext ctx);
	void exitPrimitive_type(LLVMParser.Primitive_typeContext ctx);

	void enterArray_type(LLVMParser.Array_typeContext ctx);
	void exitArray_type(LLVMParser.Array_typeContext ctx);

	void enterLoad_op(LLVMParser.Load_opContext ctx);
	void exitLoad_op(LLVMParser.Load_opContext ctx);

	void enterFcmp_op(LLVMParser.Fcmp_opContext ctx);
	void exitFcmp_op(LLVMParser.Fcmp_opContext ctx);

	void enterMetadata_definition(LLVMParser.Metadata_definitionContext ctx);
	void exitMetadata_definition(LLVMParser.Metadata_definitionContext ctx);

	void enterStore_op(LLVMParser.Store_opContext ctx);
	void exitStore_op(LLVMParser.Store_opContext ctx);

	void enterModule(LLVMParser.ModuleContext ctx);
	void exitModule(LLVMParser.ModuleContext ctx);

	void enterFunction_declaration(LLVMParser.Function_declarationContext ctx);
	void exitFunction_declaration(LLVMParser.Function_declarationContext ctx);

	void enterAlloca_op(LLVMParser.Alloca_opContext ctx);
	void exitAlloca_op(LLVMParser.Alloca_opContext ctx);

	void enterVector_op(LLVMParser.Vector_opContext ctx);
	void exitVector_op(LLVMParser.Vector_opContext ctx);

	void enterLlvm_program(LLVMParser.Llvm_programContext ctx);
	void exitLlvm_program(LLVMParser.Llvm_programContext ctx);

	void enterLlvm_section(LLVMParser.Llvm_sectionContext ctx);
	void exitLlvm_section(LLVMParser.Llvm_sectionContext ctx);

	void enterPointer_type(LLVMParser.Pointer_typeContext ctx);
	void exitPointer_type(LLVMParser.Pointer_typeContext ctx);

	void enterOperator(LLVMParser.OperatorContext ctx);
	void exitOperator(LLVMParser.OperatorContext ctx);

	void enterLlvm_constant(LLVMParser.Llvm_constantContext ctx);
	void exitLlvm_constant(LLVMParser.Llvm_constantContext ctx);

	void enterFunction_type(LLVMParser.Function_typeContext ctx);
	void exitFunction_type(LLVMParser.Function_typeContext ctx);

	void enterConversion_op(LLVMParser.Conversion_opContext ctx);
	void exitConversion_op(LLVMParser.Conversion_opContext ctx);

	void enterDerived_type(LLVMParser.Derived_typeContext ctx);
	void exitDerived_type(LLVMParser.Derived_typeContext ctx);

	void enterScalar_type(LLVMParser.Scalar_typeContext ctx);
	void exitScalar_type(LLVMParser.Scalar_typeContext ctx);

	void enterNamed_type(LLVMParser.Named_typeContext ctx);
	void exitNamed_type(LLVMParser.Named_typeContext ctx);

	void enterBinary_expr(LLVMParser.Binary_exprContext ctx);
	void exitBinary_expr(LLVMParser.Binary_exprContext ctx);

	void enterTarget(LLVMParser.TargetContext ctx);
	void exitTarget(LLVMParser.TargetContext ctx);

	void enterVariable(LLVMParser.VariableContext ctx);
	void exitVariable(LLVMParser.VariableContext ctx);

	void enterStructure_constant(LLVMParser.Structure_constantContext ctx);
	void exitStructure_constant(LLVMParser.Structure_constantContext ctx);

	void enterInitializer(LLVMParser.InitializerContext ctx);
	void exitInitializer(LLVMParser.InitializerContext ctx);
}