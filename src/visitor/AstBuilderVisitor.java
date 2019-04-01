package visitor;

import antlr.PivotBaseVisitor;
import antlr.PivotParser;
import node.*;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.IDNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.Statements.Expression.MultiExprNode;
import node.Statements.Expression.Operator;
import node.Statements.Wait.TimeFrame;
import node.Statements.Wait.WaitNode;
import node.base.Node;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.InitNode;
import node.define_nodes.Signal.DefSignalNode;
import node.define_nodes.Device.InputNode;
import node.define_nodes.Device.OutputNode;
import node.define_nodes.Signal.EnumNode;
import node.define_nodes.Signal.RangeNode;
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

        for (ParseTree tree : ctx.children) {
            node.addChild(visit(tree));
        }

        return node;
    }

    @Override
    public Node visitDefine(PivotParser.DefineContext ctx) {
        if(ctx.signal() != null){
            return visit(ctx.signal());
        }
        if(ctx.device() != null){
            return visit(ctx.device());
        }

        // todo Error handling.
        System.out.println("Error in visitDefine");
        return null;
    }

    @Override
    public Node visitDeclVar(PivotParser.DeclVarContext ctx) {
        switch (ctx.varType().getText()) {
            case "string":
                return new VarDeclNode(VarType.STRING, ctx.ID().getText(), new StringNode(ctx.STRING().getText()));
            case "int":
                return new VarDeclNode(VarType.INT, ctx.ID().getText(), visit(ctx.expr()));
            case "float":
                return new VarDeclNode(VarType.FLOAT, ctx.ID().getText(), visit(ctx.expr()));
            default:
                System.out.println("ERROR IN VisitDeclVar");
                return new VarDeclNode(VarType.FLOAT, ctx.ID().getText(), visit(ctx.expr()));
        }
    }



    @Override
    public Node visitMultiExpr(PivotParser.MultiExprContext ctx) {
        if(ctx.op.getText().equals("*")){
            return new MultiExprNode(visit(ctx.leftChild), visit(ctx.rightChild), Operator.MULTPLY);
        } else if(ctx.op.getText().equals("/")){
            return new MultiExprNode(visit(ctx.leftChild), visit(ctx.rightChild), Operator.DIVIDE);
        } else{
            // todo exception handling
            System.out.println("Error in AstBuilderVisitor - visitMultiExpr");
            return null;
        }
    }

    @Override
    public Node visitParanExpr(PivotParser.ParanExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Node visitFunCall(PivotParser.FunCallContext ctx) {
        return super.visitFunCall(ctx);
    }

    @Override
    public Node visitAtom(PivotParser.AtomContext ctx) {
        if(ctx.varID == null){
            return visit(ctx.litVal());
        } else {
            return new IDNode(ctx.ID().getText());
        }
    }

    @Override
    public Node visitPlusExpr(PivotParser.PlusExprContext ctx) {
        if(ctx.op.getText().equals("+")){
            return new AddExprNode(visit(ctx.leftChild), visit(ctx.rightChild), Operator.PLUS);
        } else if(ctx.op.getText().equals("-")){
            return new AddExprNode(visit(ctx.leftChild), visit(ctx.rightChild), Operator.MINUS);
        } else{
            // todo exception handling
            System.out.println("Error in AstBuilderVisitor - visitMultiExpr");
            return null;
        }
    }

    @Override
    public Node visitDeclDevice(PivotParser.DeclDeviceContext ctx) {
        return new DevDeclNode(ctx.devType.getText(), ctx.varID.getText(), ctx.val.getText());
    }

    @Override
    public Node visitSignal(PivotParser.SignalContext ctx) {
        if(ctx.range() != null){
            return new DefSignalNode(ctx.ID().getText(), (RangeNode) visit(ctx.range()));
        } else if(ctx.enumerations() != null){
            ArrayList<Node> enums = visitEnums(ctx.enumerations());
            return new DefSignalNode(enums, ctx.ID().getText());
        } else{
            System.out.println("Something went wrong in visitSignal");
        }

        return null;
    }

    // Alternative to visitEnumerations that can return more than one node.
    private ArrayList<Node> visitEnums(PivotParser.EnumerationsContext ctx){
        ArrayList<Node> enums = new ArrayList<>();
        for(PivotParser.EnumerationContext context: ctx.enumeration()){
            enums.add(visit(context));
        }
        return enums;
    }

    @Override
    public Node visitEnumeration(PivotParser.EnumerationContext ctx) {
        return new EnumNode(ctx.ID().getText(), visit(ctx.enumVal));
    }

    @Override
    public Node visitRange(PivotParser.RangeContext ctx) {
        // If both have the type integer.
        Node lwBound = visit(ctx.lowerBound());
        Node upBound = visit(ctx.upperBound());
        if(lwBound instanceof IntegerNode && upBound instanceof IntegerNode){
            return new RangeNode(lwBound, upBound, VarType.INT);
        } else if (lwBound instanceof FloatNode && upBound instanceof FloatNode){
            return new RangeNode(lwBound, upBound, VarType.FLOAT);
        } else {
            // todo error handling
            System.out.println("Error in AstBuilderVisitor - visitRange");
            return null;
        }

    }

    @Override
    public Node visitIntlwRange(PivotParser.IntlwRangeContext ctx) {
        return new IntegerNode(ctx.INTEGER().getText());
    }

    @Override
    public Node visitFloatlwRange(PivotParser.FloatlwRangeContext ctx) {
        return new FloatNode(ctx.FLOAT().getText());
    }

    @Override
    public Node visitIntupRange(PivotParser.IntupRangeContext ctx) {
        return new IntegerNode(ctx.INTEGER().getText());
    }

    @Override
    public Node visitFloatupRange(PivotParser.FloatupRangeContext ctx) {
        return new FloatNode(ctx.FLOAT().getText());
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
    public Node visitInit(PivotParser.InitContext ctx) {
        return new InitNode(visit(ctx.block()));
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
    public Node visitBlock(PivotParser.BlockContext ctx) {
        return new BlockNode(findNodes(ctx.stmts()));
    }

    private ArrayList<Node> findNodes(PivotParser.StmtsContext ctx){
        ArrayList<Node> stmts = new ArrayList<>();

        for (ParseTree tree: ctx.children) {
            stmts.add(visit(tree));
        }

        return stmts;
    }

    @Override
    public Node visitWaitStmt(PivotParser.WaitStmtContext ctx) {
        TimeFrame timeframe = getTimeFrame(ctx);
        if(ctx.varID != null){
            return new WaitNode(timeframe, ctx.varID.getText());
        } else if (ctx.INTEGER() != null){
            return new WaitNode(ctx.INTEGER().getText(), timeframe);
        }
        // todo: error handling
        System.out.println("Something went wrong in AST visitorbuilder wait statement");
        return null;
    }

    private TimeFrame getTimeFrame(PivotParser.WaitStmtContext ctx){
        if(ctx.timeFrame() != null){
            if(ctx.timeFrame().MONTHS() != null){
                return TimeFrame.MONTH;
            } else if (ctx.timeFrame().WEEKS() != null){
                return TimeFrame.WEEK;
            } else if (ctx.timeFrame().DAYS() != null){
                return TimeFrame.DAY;
            } else if(ctx.timeFrame().HOURS() != null){
                return TimeFrame.HOUR;
            } else if (ctx.timeFrame().MINUTES() != null){
                return TimeFrame.MINUTES;
            } else if (ctx.timeFrame().SECONDS() != null){
                return TimeFrame.SECOND;
            } else if (ctx.timeFrame().MS() != null){
                return TimeFrame.MILLISECONDS;
            }
        }
        // todo error handling
        System.out.println("Something went wrong when finding TimeFrame");
        return null;
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
    public Node visitVarType(PivotParser.VarTypeContext ctx) {
        return super.visitVarType(ctx);
    }

    /**
     * All literal values
     */
    @Override
    public Node visitIntVal(PivotParser.IntValContext ctx) {
        return new IntegerNode(ctx.INTEGER().getText());
    }

    @Override
    public Node visitFloatVal(PivotParser.FloatValContext ctx) {
        return new FloatNode(ctx.FLOAT().getText());
    }

    @Override
    public Node visitStringVal(PivotParser.StringValContext ctx) {
        return new StringNode(ctx.STRING().getText());
    }
}
