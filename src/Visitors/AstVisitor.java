package Visitors;

import ANTLR.PivotBaseVisitor;
import ANTLR.PivotParser;
import Nodes.Node;

public class AstVisitor extends PivotBaseVisitor<Node> {

    @Override
    public Node visitProgram(PivotParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    @Override
    public Node visitDecls(PivotParser.DeclsContext ctx) {
        return super.visitDecls(ctx);
    }

    @Override
    public Node visitDefine(PivotParser.DefineContext ctx) {
        return super.visitDefine(ctx);
    }

    @Override
    public Node visitSignal(PivotParser.SignalContext ctx) {
        return super.visitSignal(ctx);
    }

    @Override
    public Node visitEnumerations(PivotParser.EnumerationsContext ctx) {
        return super.visitEnumerations(ctx);
    }

    @Override
    public Node visitEnumeration(PivotParser.EnumerationContext ctx) {
        return super.visitEnumeration(ctx);
    }

    @Override
    public Node visitRange(PivotParser.RangeContext ctx) {
        return super.visitRange(ctx);
    }

    @Override
    public Node visitIntLB(PivotParser.IntLBContext ctx) {
        return super.visitIntLB(ctx);
    }

    @Override
    public Node visitFloatLB(PivotParser.FloatLBContext ctx) {
        return super.visitFloatLB(ctx);
    }

    @Override
    public Node visitIntUP(PivotParser.IntUPContext ctx) {
        return super.visitIntUP(ctx);
    }

    @Override
    public Node visitFloatUP(PivotParser.FloatUPContext ctx) {
        return super.visitFloatUP(ctx);
    }

    @Override
    public Node visitDevice(PivotParser.DeviceContext ctx) {
        return super.visitDevice(ctx);
    }

    @Override
    public Node visitInputs(PivotParser.InputsContext ctx) {
        return super.visitInputs(ctx);
    }

    @Override
    public Node visitOutputs(PivotParser.OutputsContext ctx) {
        return super.visitOutputs(ctx);
    }

    @Override
    public Node visitInit(PivotParser.InitContext ctx) {
        return super.visitInit(ctx);
    }

    @Override
    public Node visitFuncDecl(PivotParser.FuncDeclContext ctx) {
        return super.visitFuncDecl(ctx);
    }

    @Override
    public Node visitFParams(PivotParser.FParamsContext ctx) {
        return super.visitFParams(ctx);
    }

    @Override
    public Node visitParam(PivotParser.ParamContext ctx) {
        return super.visitParam(ctx);
    }

    @Override
    public Node visitEvent(PivotParser.EventContext ctx) {
        return super.visitEvent(ctx);
    }

    @Override
    public Node visitAtomEvent(PivotParser.AtomEventContext ctx) {
        return super.visitAtomEvent(ctx);
    }

    @Override
    public Node visitRepeatEvent(PivotParser.RepeatEventContext ctx) {
        return super.visitRepeatEvent(ctx);
    }

    @Override
    public Node visitTimeFrame(PivotParser.TimeFrameContext ctx) {
        return super.visitTimeFrame(ctx);
    }

    @Override
    public Node visitBlock(PivotParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public Node visitStmts(PivotParser.StmtsContext ctx) {
        return super.visitStmts(ctx);
    }

    @Override
    public Node visitWaitStmt(PivotParser.WaitStmtContext ctx) {
        return super.visitWaitStmt(ctx);
    }

    @Override
    public Node visitAssignment(PivotParser.AssignmentContext ctx) {
        return super.visitAssignment(ctx);
    }

    @Override
    public Node visitIfstmt(PivotParser.IfstmtContext ctx) {
        return super.visitIfstmt(ctx);
    }

    @Override
    public Node visitWhilestmt(PivotParser.WhilestmtContext ctx) {
        return super.visitWhilestmt(ctx);
    }

    @Override
    public Node visitFuncCall(PivotParser.FuncCallContext ctx) {
        return super.visitFuncCall(ctx);
    }

    @Override
    public Node visitInputParam(PivotParser.InputParamContext ctx) {
        return super.visitInputParam(ctx);
    }

    @Override
    public Node visitDeclVar(PivotParser.DeclVarContext ctx) {
        return super.visitDeclVar(ctx);
    }

    @Override
    public Node visitBrk(PivotParser.BrkContext ctx) {
        return super.visitBrk(ctx);
    }

    @Override
    public Node visitRtn(PivotParser.RtnContext ctx) {
        return super.visitRtn(ctx);
    }

    @Override
    public Node visitIntVal(PivotParser.IntValContext ctx) {
        return super.visitIntVal(ctx);
    }

    @Override
    public Node visitFloatVal(PivotParser.FloatValContext ctx) {
        return super.visitFloatVal(ctx);
    }

    @Override
    public Node visitStringVal(PivotParser.StringValContext ctx) {
        return super.visitStringVal(ctx);
    }

    @Override
    public Node visitFuncexpr(PivotParser.FuncexprContext ctx) {
        return super.visitFuncexpr(ctx);
    }

    @Override
    public Node visitAddexpr(PivotParser.AddexprContext ctx) {
        return super.visitAddexpr(ctx);
    }

    @Override
    public Node visitAtomexpr(PivotParser.AtomexprContext ctx) {
        return super.visitAtomexpr(ctx);
    }

    @Override
    public Node visitMultiexpr(PivotParser.MultiexprContext ctx) {
        return super.visitMultiexpr(ctx);
    }

    @Override
    public Node visitParanexpr(PivotParser.ParanexprContext ctx) {
        return super.visitParanexpr(ctx);
    }

    @Override
    public Node visitLogicalExpressionOr(PivotParser.LogicalExpressionOrContext ctx) {
        return super.visitLogicalExpressionOr(ctx);
    }

    @Override
    public Node visitComparisonExpression(PivotParser.ComparisonExpressionContext ctx) {
        return super.visitComparisonExpression(ctx);
    }

    @Override
    public Node visitLogicalLiterals(PivotParser.LogicalLiteralsContext ctx) {
        return super.visitLogicalLiterals(ctx);
    }

    @Override
    public Node visitLogicalExpressionAnd(PivotParser.LogicalExpressionAndContext ctx) {
        return super.visitLogicalExpressionAnd(ctx);
    }

    @Override
    public Node visitLogicalExpressionInParen(PivotParser.LogicalExpressionInParenContext ctx) {
        return super.visitLogicalExpressionInParen(ctx);
    }

    @Override
    public Node visitComparisonExpressionWithOperator(PivotParser.ComparisonExpressionWithOperatorContext ctx) {
        return super.visitComparisonExpressionWithOperator(ctx);
    }

    @Override
    public Node visitComparisonExpressionParens(PivotParser.ComparisonExpressionParensContext ctx) {
        return super.visitComparisonExpressionParens(ctx);
    }

    @Override
    public Node visitTimeOp(PivotParser.TimeOpContext ctx) {
        return super.visitTimeOp(ctx);
    }

    @Override
    public Node visitDateOp(PivotParser.DateOpContext ctx) {
        return super.visitDateOp(ctx);
    }

    @Override
    public Node visitExprOP(PivotParser.ExprOPContext ctx) {
        return super.visitExprOP(ctx);
    }

    @Override
    public Node visitComp_operator(PivotParser.Comp_operatorContext ctx) {
        return super.visitComp_operator(ctx);
    }

    @Override
    public Node visitLitValue(PivotParser.LitValueContext ctx) {
        return super.visitLitValue(ctx);
    }

    @Override
    public Node visitVaridAtom(PivotParser.VaridAtomContext ctx) {
        return super.visitVaridAtom(ctx);
    }

    @Override
    public Node visitNowAtom(PivotParser.NowAtomContext ctx) {
        return super.visitNowAtom(ctx);
    }

    @Override
    public Node visitType(PivotParser.TypeContext ctx) {
        return super.visitType(ctx);
    }
}
