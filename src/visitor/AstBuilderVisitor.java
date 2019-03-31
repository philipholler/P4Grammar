package visitor;

import antlr.PivotBaseVisitor;
import antlr.PivotParser;
import node.*;
import node.base.Node;
import node.define_nodes.DefDeviceNode;
import node.define_nodes.DefSignalNode;
import node.define_nodes.InputNode;
import node.define_nodes.OutputNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import semantics.VarType;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public class AstBuilderVisitor extends PivotBaseVisitor<Node> {

    private static int currentLineNumber = 0;

    public static int getCurrentLineNumber() {
        return currentLineNumber;
    }

    private static void updateLineNumber(ParserRuleContext fromCtx) {
        AstBuilderVisitor.currentLineNumber = fromCtx.getStart().getLine();
    }

    @Override
    public Node visitProgram(PivotParser.ProgramContext ctx) {
        return new ProgramNode(visit(ctx.decls()));
    }

    @Override
    public Node visitDecls(PivotParser.DeclsContext ctx) {
        DeclsNode node = new DeclsNode();

        // Add all defines
        for (PivotParser.DefineContext context: ctx.define()) {
            node.addChild(visit(context));
        }
        // Add all var decl
        for (PivotParser.DeclVarContext context: ctx.declVar()) {
            node.addChild(visit(context));
        }
        // Add all device decl
        for(PivotParser.DeclDeviceContext context: ctx.declDevice()){
            node.addChild(visit(context));
        }
        // todo add funcs and events.

        return node;
    }

    @Override
    public Node visitDefine(PivotParser.DefineContext ctx) {
        if(ctx.signal() != null){
            return new DefSignalNode();
        }
        if(ctx.device() != null){
            return (DefDeviceNode) visit(ctx.device());
        }

        // todo Error handling.
        System.out.println("Error in visitDefine");
        return null;
    }

    @Override
    public Node visitDeclVar(PivotParser.DeclVarContext ctx) {
        if(ctx.varType().getText().equals("string")){
            return new VarDeclNode(VarType.STRING, ctx.varID.getText(), ctx.litVal().getText());
        } else if(ctx.varType().getText().equals("int")){
            return new VarDeclNode(VarType.INT, ctx.varID.getText(), ctx.litVal().getText());
        } else if(ctx.varType().getText().equals("float")){
            return new VarDeclNode(VarType.FLOAT, ctx.varID.getText(), ctx.litVal().getText());
        } else {
            System.out.println("ERROR IN VisitDeclVar");
            return new VarDeclNode(VarType.FLOAT, ctx.varID.getText(), ctx.litVal().getText());
        }
    }

    @Override
    public Node visitDeclDevice(PivotParser.DeclDeviceContext ctx) {
        return new DevDeclNode(ctx.devType.getText(), ctx.varID.getText(), ctx.val.getText());
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
        ArrayList<InputNode> inputs = new ArrayList<>();
        ArrayList<OutputNode> outputs = new ArrayList<>();

        if(ctx.inputs() != null){
            // Start at index 2 to skip initial 'input' and ':' tokens
            for(int i = 1; i < ctx.inputs().children.size(); i++){
                ParseTree childCtx = ctx.inputs().getChild(i);
                if(isSeparatorSymbol(childCtx)) continue;
                inputs.add(new InputNode((ctx.inputs().children.get(i)).getText()));
            }
        }

        if(ctx.outputs() != null){
            // Start at index 2 to skip initial 'output' and ':' keyword tokens
            for(int i = 1; i < ctx.outputs().getChildCount(); i++){
                ParseTree childCtx = ctx.outputs().getChild(i);
                if(isSeparatorSymbol(childCtx)) continue;
                outputs.add(new OutputNode((ctx.outputs().children.get(i)).getText()));
            }
        }

        return new DefDeviceNode(ctx.ID().getText(), outputs, inputs);
    }

    private boolean isSeparatorSymbol(ParseTree ctx){
        return (ctx instanceof TerminalNode) &&
                (ctx.getText().equals(";") ||
                        ctx.getText().equals(",")  ||
                        ctx.getText().equals(":")  ||
                        ctx.getText().equals("..") ||
                        ctx.getText().equals("(")  ||
                        ctx.getText().equals(")")  ||
                        ctx.getText().equals("{")  ||
                        ctx.getText().equals("}"));
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
    public Node visitVarType(PivotParser.VarTypeContext ctx) {
        return super.visitVarType(ctx);
    }


}
