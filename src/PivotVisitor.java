// Generated from C:/Users/phili/IdeaProjects/P4Grammar/src\Pivot.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PivotParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PivotVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PivotParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PivotParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#decls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(PivotParser.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(PivotParser.DefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#signal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignal(PivotParser.SignalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#signalID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignalID(PivotParser.SignalIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#device}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDevice(PivotParser.DeviceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst(PivotParser.InstContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(PivotParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(PivotParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(PivotParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#atomEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomEvent(PivotParser.AtomEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#repeatEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatEvent(PivotParser.RepeatEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#initReturnValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitReturnValue(PivotParser.InitReturnValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#inputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputs(PivotParser.InputsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(PivotParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#outputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputs(PivotParser.OutputsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(PivotParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#deviceID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeviceID(PivotParser.DeviceIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#ip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIp(PivotParser.IpContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#varID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarID(PivotParser.VarIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PivotParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(PivotParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(PivotParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#whilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(PivotParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PivotParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddexpr(PivotParser.AddexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomexpr(PivotParser.AtomexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiexpr(PivotParser.MultiexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paranexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParanexpr(PivotParser.ParanexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(PivotParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalExpressionInParen}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionInParen(PivotParser.LogicalExpressionInParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalLiterals}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalLiterals(PivotParser.LogicalLiteralsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalExpressionAnd}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionAnd(PivotParser.LogicalExpressionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalExpressionOr}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionOr(PivotParser.LogicalExpressionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpressionWithOperator}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpressionWithOperator(PivotParser.ComparisonExpressionWithOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpressionParens}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpressionParens(PivotParser.ComparisonExpressionParensContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#comparison_operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_operand(PivotParser.Comparison_operandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#comp_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp_operator(PivotParser.Comp_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(PivotParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(PivotParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowerBound(PivotParser.LowerBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpperBound(PivotParser.UpperBoundContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#togglevalues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTogglevalues(PivotParser.TogglevaluesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#togglevalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTogglevalue(PivotParser.TogglevalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#toggleID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToggleID(PivotParser.ToggleIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#toggleVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToggleVal(PivotParser.ToggleValContext ctx);
}