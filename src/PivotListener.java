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
	 * Enter a parse tree produced by {@link PivotParser#signalID}.
	 * @param ctx the parse tree
	 */
	void enterSignalID(PivotParser.SignalIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#signalID}.
	 * @param ctx the parse tree
	 */
	void exitSignalID(PivotParser.SignalIDContext ctx);
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
	 * Enter a parse tree produced by {@link PivotParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterInst(PivotParser.InstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitInst(PivotParser.InstContext ctx);
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
	 * Enter a parse tree produced by {@link PivotParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(PivotParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(PivotParser.FuncContext ctx);
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
	 * Enter a parse tree produced by {@link PivotParser#initReturnValue}.
	 * @param ctx the parse tree
	 */
	void enterInitReturnValue(PivotParser.InitReturnValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#initReturnValue}.
	 * @param ctx the parse tree
	 */
	void exitInitReturnValue(PivotParser.InitReturnValueContext ctx);
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
	 * Enter a parse tree produced by {@link PivotParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(PivotParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(PivotParser.InputContext ctx);
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
	 * Enter a parse tree produced by {@link PivotParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutput(PivotParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutput(PivotParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#deviceID}.
	 * @param ctx the parse tree
	 */
	void enterDeviceID(PivotParser.DeviceIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#deviceID}.
	 * @param ctx the parse tree
	 */
	void exitDeviceID(PivotParser.DeviceIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#ip}.
	 * @param ctx the parse tree
	 */
	void enterIp(PivotParser.IpContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#ip}.
	 * @param ctx the parse tree
	 */
	void exitIp(PivotParser.IpContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#varID}.
	 * @param ctx the parse tree
	 */
	void enterVarID(PivotParser.VarIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#varID}.
	 * @param ctx the parse tree
	 */
	void exitVarID(PivotParser.VarIDContext ctx);
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
	 * Enter a parse tree produced by {@link PivotParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(PivotParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(PivotParser.StatContext ctx);
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
	 * Enter a parse tree produced by the {@code addexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddexpr(PivotParser.AddexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddexpr(PivotParser.AddexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomexpr(PivotParser.AtomexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomexpr(PivotParser.AtomexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiexpr(PivotParser.MultiexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiexpr(PivotParser.MultiexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paranexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParanexpr(PivotParser.ParanexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paranexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParanexpr(PivotParser.ParanexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(PivotParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(PivotParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionInParen}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionInParen(PivotParser.LogicalExpressionInParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionInParen}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionInParen(PivotParser.LogicalExpressionInParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalLiterals}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalLiterals(PivotParser.LogicalLiteralsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalLiterals}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalLiterals(PivotParser.LogicalLiteralsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionAnd}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionAnd(PivotParser.LogicalExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionAnd}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionAnd(PivotParser.LogicalExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalExpressionOr}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpressionOr(PivotParser.LogicalExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalExpressionOr}
	 * labeled alternative in {@link PivotParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpressionOr(PivotParser.LogicalExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpressionWithOperator}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpressionWithOperator(PivotParser.ComparisonExpressionWithOperatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpressionWithOperator}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpressionWithOperator(PivotParser.ComparisonExpressionWithOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpressionParens}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpressionParens(PivotParser.ComparisonExpressionParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpressionParens}
	 * labeled alternative in {@link PivotParser#comparison_expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpressionParens(PivotParser.ComparisonExpressionParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#comparison_operand}.
	 * @param ctx the parse tree
	 */
	void enterComparison_operand(PivotParser.Comparison_operandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#comparison_operand}.
	 * @param ctx the parse tree
	 */
	void exitComparison_operand(PivotParser.Comparison_operandContext ctx);
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
	 * Enter a parse tree produced by {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 */
	void enterLowerBound(PivotParser.LowerBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 */
	void exitLowerBound(PivotParser.LowerBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 */
	void enterUpperBound(PivotParser.UpperBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 */
	void exitUpperBound(PivotParser.UpperBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#togglevalues}.
	 * @param ctx the parse tree
	 */
	void enterTogglevalues(PivotParser.TogglevaluesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#togglevalues}.
	 * @param ctx the parse tree
	 */
	void exitTogglevalues(PivotParser.TogglevaluesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#togglevalue}.
	 * @param ctx the parse tree
	 */
	void enterTogglevalue(PivotParser.TogglevalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#togglevalue}.
	 * @param ctx the parse tree
	 */
	void exitTogglevalue(PivotParser.TogglevalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#toggleID}.
	 * @param ctx the parse tree
	 */
	void enterToggleID(PivotParser.ToggleIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#toggleID}.
	 * @param ctx the parse tree
	 */
	void exitToggleID(PivotParser.ToggleIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#toggleVal}.
	 * @param ctx the parse tree
	 */
	void enterToggleVal(PivotParser.ToggleValContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#toggleVal}.
	 * @param ctx the parse tree
	 */
	void exitToggleVal(PivotParser.ToggleValContext ctx);
}