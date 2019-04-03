// Generated from /Users/philip/Library/Mobile Documents/com~apple~CloudDocs/Cloud dokumenter/Java projects/P4Grammar/Pivot.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PivotParser}.
 */
public interface PivotListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PivotParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PivotParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PivotParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(PivotParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(PivotParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(PivotParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(PivotParser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#signal}.
	 * @param ctx the parse tree
	 */
	void enterSignal(PivotParser.SignalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#signal}.
	 * @param ctx the parse tree
	 */
	void exitSignal(PivotParser.SignalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#enumerations}.
	 * @param ctx the parse tree
	 */
	void enterEnumerations(PivotParser.EnumerationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#enumerations}.
	 * @param ctx the parse tree
	 */
	void exitEnumerations(PivotParser.EnumerationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void enterEnumeration(PivotParser.EnumerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void exitEnumeration(PivotParser.EnumerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(PivotParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(PivotParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intlwRange}
	 * labeled alternative in {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 */
	void enterIntlwRange(PivotParser.IntlwRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intlwRange}
	 * labeled alternative in {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 */
	void exitIntlwRange(PivotParser.IntlwRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatlwRange}
	 * labeled alternative in {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 */
	void enterFloatlwRange(PivotParser.FloatlwRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatlwRange}
	 * labeled alternative in {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 */
	void exitFloatlwRange(PivotParser.FloatlwRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intupRange}
	 * labeled alternative in {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 */
	void enterIntupRange(PivotParser.IntupRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intupRange}
	 * labeled alternative in {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 */
	void exitIntupRange(PivotParser.IntupRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatupRange}
	 * labeled alternative in {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 */
	void enterFloatupRange(PivotParser.FloatupRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatupRange}
	 * labeled alternative in {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 */
	void exitFloatupRange(PivotParser.FloatupRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#device}.
	 * @param ctx the parse tree
	 */
	void enterDevice(PivotParser.DeviceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#device}.
	 * @param ctx the parse tree
	 */
	void exitDevice(PivotParser.DeviceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#inputs}.
	 * @param ctx the parse tree
	 */
	void enterInputs(PivotParser.InputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#inputs}.
	 * @param ctx the parse tree
	 */
	void exitInputs(PivotParser.InputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#outputs}.
	 * @param ctx the parse tree
	 */
	void enterOutputs(PivotParser.OutputsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#outputs}.
	 * @param ctx the parse tree
	 */
	void exitOutputs(PivotParser.OutputsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#declDevice}.
	 * @param ctx the parse tree
	 */
	void enterDeclDevice(PivotParser.DeclDeviceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#declDevice}.
	 * @param ctx the parse tree
	 */
	void exitDeclDevice(PivotParser.DeclDeviceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(PivotParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(PivotParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(PivotParser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(PivotParser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#fParams}.
	 * @param ctx the parse tree
	 */
	void enterFParams(PivotParser.FParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#fParams}.
	 * @param ctx the parse tree
	 */
	void exitFParams(PivotParser.FParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(PivotParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(PivotParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(PivotParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(PivotParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#atomEvent}.
	 * @param ctx the parse tree
	 */
	void enterAtomEvent(PivotParser.AtomEventContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#atomEvent}.
	 * @param ctx the parse tree
	 */
	void exitAtomEvent(PivotParser.AtomEventContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#repeatEvent}.
	 * @param ctx the parse tree
	 */
	void enterRepeatEvent(PivotParser.RepeatEventContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#repeatEvent}.
	 * @param ctx the parse tree
	 */
	void exitRepeatEvent(PivotParser.RepeatEventContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#timeAndDate}.
	 * @param ctx the parse tree
	 */
	void enterTimeAndDate(PivotParser.TimeAndDateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#timeAndDate}.
	 * @param ctx the parse tree
	 */
	void exitTimeAndDate(PivotParser.TimeAndDateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#timeFrame}.
	 * @param ctx the parse tree
	 */
	void enterTimeFrame(PivotParser.TimeFrameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#timeFrame}.
	 * @param ctx the parse tree
	 */
	void exitTimeFrame(PivotParser.TimeFrameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PivotParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PivotParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(PivotParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(PivotParser.StmtsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#waitStmt}.
	 * @param ctx the parse tree
	 */
	void enterWaitStmt(PivotParser.WaitStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#waitStmt}.
	 * @param ctx the parse tree
	 */
	void exitWaitStmt(PivotParser.WaitStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PivotParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PivotParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(PivotParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(PivotParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(PivotParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(PivotParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funCall}
	 * labeled alternative in {@link PivotParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFunCall(PivotParser.FunCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funCall}
	 * labeled alternative in {@link PivotParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFunCall(PivotParser.FunCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setFun}
	 * labeled alternative in {@link PivotParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterSetFun(PivotParser.SetFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setFun}
	 * labeled alternative in {@link PivotParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitSetFun(PivotParser.SetFunContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getFun}
	 * labeled alternative in {@link PivotParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterGetFun(PivotParser.GetFunContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getFun}
	 * labeled alternative in {@link PivotParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitGetFun(PivotParser.GetFunContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(PivotParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(PivotParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#declVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclVar(PivotParser.DeclVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#declVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclVar(PivotParser.DeclVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#brk}.
	 * @param ctx the parse tree
	 */
	void enterBrk(PivotParser.BrkContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#brk}.
	 * @param ctx the parse tree
	 */
	void exitBrk(PivotParser.BrkContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#rtn}.
	 * @param ctx the parse tree
	 */
	void enterRtn(PivotParser.RtnContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#rtn}.
	 * @param ctx the parse tree
	 */
	void exitRtn(PivotParser.RtnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link PivotParser#litVal}.
	 * @param ctx the parse tree
	 */
	void enterIntVal(PivotParser.IntValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link PivotParser#litVal}.
	 * @param ctx the parse tree
	 */
	void exitIntVal(PivotParser.IntValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatVal}
	 * labeled alternative in {@link PivotParser#litVal}.
	 * @param ctx the parse tree
	 */
	void enterFloatVal(PivotParser.FloatValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatVal}
	 * labeled alternative in {@link PivotParser#litVal}.
	 * @param ctx the parse tree
	 */
	void exitFloatVal(PivotParser.FloatValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringVal}
	 * labeled alternative in {@link PivotParser#litVal}.
	 * @param ctx the parse tree
	 */
	void enterStringVal(PivotParser.StringValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringVal}
	 * labeled alternative in {@link PivotParser#litVal}.
	 * @param ctx the parse tree
	 */
	void exitStringVal(PivotParser.StringValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funCallExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunCallExpr(PivotParser.FunCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funCallExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunCallExpr(PivotParser.FunCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiExpr(PivotParser.MultiExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiExpr(PivotParser.MultiExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(PivotParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(PivotParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paranExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParanExpr(PivotParser.ParanExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paranExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParanExpr(PivotParser.ParanExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(PivotParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(PivotParser.PlusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpressionOr}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionOr(PivotParser.LogicalExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpressionOr}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionOr(PivotParser.LogicalExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(PivotParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpression}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(PivotParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalLiterals}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalLiterals(PivotParser.LogicalLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalLiterals}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalLiterals(PivotParser.LogicalLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpressionAnd}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionAnd(PivotParser.LogicalExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpressionAnd}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionAnd(PivotParser.LogicalExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExpressionInParen}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionInParen(PivotParser.LogicalExpressionInParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExpressionInParen}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionInParen(PivotParser.LogicalExpressionInParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpressionWithOperator}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpressionWithOperator(PivotParser.ComparisonExpressionWithOperatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpressionWithOperator}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpressionWithOperator(PivotParser.ComparisonExpressionWithOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpressionParens}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpressionParens(PivotParser.ComparisonExpressionParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpressionParens}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpressionParens(PivotParser.ComparisonExpressionParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compOperandTime}
	 * labeled alternative in {@link PivotParser#comparison_operand}.
	 * @param ctx the parse tree
	 */
	void enterCompOperandTime(PivotParser.CompOperandTimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compOperandTime}
	 * labeled alternative in {@link PivotParser#comparison_operand}.
	 * @param ctx the parse tree
	 */
	void exitCompOperandTime(PivotParser.CompOperandTimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comOperandDate}
	 * labeled alternative in {@link PivotParser#comparison_operand}.
	 * @param ctx the parse tree
	 */
	void enterComOperandDate(PivotParser.ComOperandDateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comOperandDate}
	 * labeled alternative in {@link PivotParser#comparison_operand}.
	 * @param ctx the parse tree
	 */
	void exitComOperandDate(PivotParser.ComOperandDateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comOperandExpr}
	 * labeled alternative in {@link PivotParser#comparison_operand}.
	 * @param ctx the parse tree
	 */
	void enterComOperandExpr(PivotParser.ComOperandExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comOperandExpr}
	 * labeled alternative in {@link PivotParser#comparison_operand}.
	 * @param ctx the parse tree
	 */
	void exitComOperandExpr(PivotParser.ComOperandExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#comp_operator}.
	 * @param ctx the parse tree
	 */
	void enterComp_operator(PivotParser.Comp_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#comp_operator}.
	 * @param ctx the parse tree
	 */
	void exitComp_operator(PivotParser.Comp_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(PivotParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(PivotParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(PivotParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(PivotParser.VarTypeContext ctx);
}