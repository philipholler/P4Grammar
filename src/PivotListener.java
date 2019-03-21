// Generated from /Users/philip/Library/Mobile Documents/com~apple~CloudDocs/Cloud dokumenter/Java projects/P4Grammar/Pivot.g4 by ANTLR 4.7.2
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
	 * Enter a parse tree produced by {@link PivotParser#inputID}.
	 * @param ctx the parse tree
	 */
	void enterInputID(PivotParser.InputIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#inputID}.
	 * @param ctx the parse tree
	 */
	void exitInputID(PivotParser.InputIDContext ctx);
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
	 * Enter a parse tree produced by {@link PivotParser#outputID}.
	 * @param ctx the parse tree
	 */
	void enterOutputID(PivotParser.OutputIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#outputID}.
	 * @param ctx the parse tree
	 */
	void exitOutputID(PivotParser.OutputIDContext ctx);
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
	 * Enter a parse tree produced by {@link PivotParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(PivotParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(PivotParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#inputParam}.
	 * @param ctx the parse tree
	 */
	void enterInputParam(PivotParser.InputParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#inputParam}.
	 * @param ctx the parse tree
	 */
	void exitInputParam(PivotParser.InputParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#wait}.
	 * @param ctx the parse tree
	 */
	void enterWait(PivotParser.WaitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#wait}.
	 * @param ctx the parse tree
	 */
	void exitWait(PivotParser.WaitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#timeVal}.
	 * @param ctx the parse tree
	 */
	void enterTimeVal(PivotParser.TimeValContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#timeVal}.
	 * @param ctx the parse tree
	 */
	void exitTimeVal(PivotParser.TimeValContext ctx);
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
	 * Enter a parse tree produced by the {@code funcexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncexpr(PivotParser.FuncexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcexpr}
	 * labeled alternative in {@link PivotParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncexpr(PivotParser.FuncexprContext ctx);
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
	 * Enter a parse tree produced by {@link PivotParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(PivotParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(PivotParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(PivotParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(PivotParser.DateContext ctx);
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
	 * Enter a parse tree produced by the {@code intAtom}
	 * labeled alternative in {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIntAtom(PivotParser.IntAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intAtom}
	 * labeled alternative in {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIntAtom(PivotParser.IntAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatAtom}
	 * labeled alternative in {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFloatAtom(PivotParser.FloatAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatAtom}
	 * labeled alternative in {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFloatAtom(PivotParser.FloatAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(PivotParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(PivotParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varidAtom}
	 * labeled alternative in {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterVaridAtom(PivotParser.VaridAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varidAtom}
	 * labeled alternative in {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitVaridAtom(PivotParser.VaridAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nowAtom}
	 * labeled alternative in {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNowAtom(PivotParser.NowAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nowAtom}
	 * labeled alternative in {@link PivotParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNowAtom(PivotParser.NowAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PivotParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PivotParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PivotParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PivotParser.TypeContext ctx);
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
	 * Enter a parse tree produced by the {@code intLB}
	 * labeled alternative in {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 */
	void enterIntLB(PivotParser.IntLBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLB}
	 * labeled alternative in {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 */
	void exitIntLB(PivotParser.IntLBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatLB}
	 * labeled alternative in {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 */
	void enterFloatLB(PivotParser.FloatLBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatLB}
	 * labeled alternative in {@link PivotParser#lowerBound}.
	 * @param ctx the parse tree
	 */
	void exitFloatLB(PivotParser.FloatLBContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intUP}
	 * labeled alternative in {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 */
	void enterIntUP(PivotParser.IntUPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intUP}
	 * labeled alternative in {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 */
	void exitIntUP(PivotParser.IntUPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatUP}
	 * labeled alternative in {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 */
	void enterFloatUP(PivotParser.FloatUPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatUP}
	 * labeled alternative in {@link PivotParser#upperBound}.
	 * @param ctx the parse tree
	 */
	void exitFloatUP(PivotParser.FloatUPContext ctx);
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
	 * Enter a parse tree produced by the {@code stringVal}
	 * labeled alternative in {@link PivotParser#toggleVal}.
	 * @param ctx the parse tree
	 */
	void enterStringVal(PivotParser.StringValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringVal}
	 * labeled alternative in {@link PivotParser#toggleVal}.
	 * @param ctx the parse tree
	 */
	void exitStringVal(PivotParser.StringValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerVal}
	 * labeled alternative in {@link PivotParser#toggleVal}.
	 * @param ctx the parse tree
	 */
	void enterIntegerVal(PivotParser.IntegerValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerVal}
	 * labeled alternative in {@link PivotParser#toggleVal}.
	 * @param ctx the parse tree
	 */
	void exitIntegerVal(PivotParser.IntegerValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatVal}
	 * labeled alternative in {@link PivotParser#toggleVal}.
	 * @param ctx the parse tree
	 */
	void enterFloatVal(PivotParser.FloatValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatVal}
	 * labeled alternative in {@link PivotParser#toggleVal}.
	 * @param ctx the parse tree
	 */
	void exitFloatVal(PivotParser.FloatValContext ctx);
}