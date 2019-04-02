// Generated from /Users/philip/Library/Mobile Documents/com~apple~CloudDocs/Cloud dokumenter/Java projects/P4Grammar/Pivot.g4 by ANTLR 4.7.2
package antlr;
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
	 * Visit a parse tree produced by {@link PivotParser#enumerations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerations(PivotParser.EnumerationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#enumeration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeration(PivotParser.EnumerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRange(PivotParser.RangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intlwRange}
	 * labeled alternative in {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntlwRange(PivotParser.IntlwRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatlwRange}
	 * labeled alternative in {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatlwRange(PivotParser.FloatlwRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intupRange}
	 * labeled alternative in {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntupRange(PivotParser.IntupRangeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatupRange}
	 * labeled alternative in {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatupRange(PivotParser.FloatupRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#device}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDevice(PivotParser.DeviceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#inputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputs(PivotParser.InputsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#outputs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputs(PivotParser.OutputsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#declDevice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclDevice(PivotParser.DeclDeviceContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(PivotParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#funcDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(PivotParser.FuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#fParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFParams(PivotParser.FParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(PivotParser.ParamContext ctx);
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
	 * Visit a parse tree produced by {@link PivotParser#timeFrame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeFrame(PivotParser.TimeFrameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PivotParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(PivotParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#waitStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWaitStmt(PivotParser.WaitStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PivotParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(PivotParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#whilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(PivotParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(PivotParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(PivotParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#declVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclVar(PivotParser.DeclVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#brk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrk(PivotParser.BrkContext ctx);
	/**
	 * Visit a parse tree produced by {@link PivotParser#rtn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRtn(PivotParser.RtnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link PivotParser#litVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntVal(PivotParser.IntValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatVal}
	 * labeled alternative in {@link PivotParser#litVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatVal(PivotParser.FloatValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringVal}
	 * labeled alternative in {@link PivotParser#litVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringVal(PivotParser.StringValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiExpr(PivotParser.MultiExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(PivotParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paranExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParanExpr(PivotParser.ParanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funCall}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunCall(PivotParser.FunCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(PivotParser.PlusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpressionOr}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionOr(PivotParser.LogicalExpressionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(PivotParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalLiterals}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalLiterals(PivotParser.LogicalLiteralsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpressionAnd}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionAnd(PivotParser.LogicalExpressionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExpressionInParen}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressionInParen(PivotParser.LogicalExpressionInParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpressionWithOperator}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpressionWithOperator(PivotParser.ComparisonExpressionWithOperatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpressionParens}
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
	 * Visit a parse tree produced by {@link PivotParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(PivotParser.VarTypeContext ctx);
}