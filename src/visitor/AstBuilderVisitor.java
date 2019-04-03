package visitor;

import antlr.PivotBaseVisitor;
import antlr.PivotParser;
import node.*;
import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.Statements.*;
import node.Statements.Expression.*;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.Statements.LogicalExpression.*;
import node.Statements.LogicalExpression.TimeNodes.DateNode;
import node.Statements.LogicalExpression.TimeNodes.NowNode;
import node.Statements.LogicalExpression.TimeNodes.TimeNode;
import node.Statements.Wait.TimeFrame;
import node.Statements.Wait.WaitNode;
import node.base.Node;
import node.define_nodes.Device.DefDeviceNode;
import node.InitNode;
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
                return new VarDeclNode(VarType.STRING, ctx.ID().getText(), visit(ctx.expr()));
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
    public Node visitAtom(PivotParser.AtomContext ctx) {
        if(ctx.varID != null){
            return new IDNode(ctx.ID().getText());
        } else if (ctx.litVal() != null){
            return visit(ctx.litVal());
        } else if (ctx.NOW() != null){
            return new NowNode();
        } else{
            System.out.println("Something went wrong in AstBuilder - visitAtom");
            return null;
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
        Node lwBound = visit(ctx.lowerBound());
        Node upBound = visit(ctx.upperBound());

        // If both have the type integer.
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
        // First find the type of the function
        VarType type = null;
        if(!ctx.varType().isEmpty()){
            switch (ctx.varType().getText()){
                case "string":
                    type = VarType.STRING;
                    break;
                case "int":
                    type = VarType.INT;
                    break;
                case "float":
                    type = VarType.FLOAT;
                    break;
                case "void":
                    type = VarType.VOID;
                    break;
                default:
                    System.out.println("Error in ASTVistior -  visitFuncDecl");
            }
        }

        // Find id
        String id = ctx.id.getText();

        ArrayList<Node> params = findInputParams(ctx);

        return new FunctionNode(type, id, params, visit(ctx.block()));
    }

    private ArrayList<Node> findInputParams(PivotParser.FuncDeclContext ctx){
        ArrayList<Node> params = new ArrayList<>();

        if(ctx.getChildCount() != 0){
            for(ParseTree tree : ctx.params.children){
                if(!isSeparatorSymbol(tree)){
                    params.add(visit(tree));
                }
            }
        }

        return params;
    }

    @Override
    public Node visitParam(PivotParser.ParamContext ctx) {
        VarType type = null;
        if(!ctx.varType().isEmpty()){
            switch (ctx.varType().getText()){
                case "string":
                    type = VarType.STRING;
                    break;
                case "int":
                    type = VarType.INT;
                    break;
                case "float":
                    type = VarType.FLOAT;
                    break;
                default:
                    System.out.println("Error in ASTVistior - visitParam");
                    break;

            }
        }
        return new InputParamNode(ctx.localID.getText(), type);
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
        ArrayList<Node> stmts = findNodes(ctx.stmts());

        if(!stmts.isEmpty()){
            return new BlockNode(stmts);
        } else {
            return new BlockNode();
        }
    }

    private ArrayList<Node> findNodes(PivotParser.StmtsContext ctx){
        ArrayList<Node> stmts = new ArrayList<>();

        if(ctx.getChildCount() != 0){
            for (ParseTree tree: ctx.children) {
                if (!isSeparatorSymbol(tree)) {
                    stmts.add(visit(tree));
                }
            }
        }

        return stmts;
    }

    @Override
    public Node visitWaitStmt(PivotParser.WaitStmtContext ctx) {
        TimeFrame timeframe = getTimeFrame(ctx);

        return new WaitNode(visit(ctx.expr()), timeframe);
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
        return new AssignmentNode(visit(ctx.expr()), ctx.varID.getText());
    }

    @Override
    public Node visitIfstmt(PivotParser.IfstmtContext ctx) {
        return new IfStmtNode(visit(ctx.logical_expr()), visit(ctx.blck));
    }

    @Override
    public Node visitWhilestmt(PivotParser.WhilestmtContext ctx) {
        return new WhileNode(visit(ctx.logical_expr()), visit(ctx.block()));
    }

    @Override
    public Node visitFunCall(PivotParser.FunCallContext ctx) {
        ArrayList<Node> arguments = findArguments(ctx);
        if(!arguments.isEmpty()){
            return new FuncCallNode(arguments, ctx.id.getText());
        } else {
            return new FuncCallNode(ctx.id.getText());
        }
    }

    @Override
    public Node visitSetFun(PivotParser.SetFunContext ctx) {
        return new SetFuncNode(ctx.deviceID.getText(), ctx.signalID.getText(), visit(ctx.expr()));
    }

    @Override
    public Node visitGetFun(PivotParser.GetFunContext ctx) {
        return new GetFuncNode(ctx.deviceID.getText(), ctx.signalID.getText());
    }

    private ArrayList<Node> findArguments(PivotParser.FunCallContext ctx){
        ArrayList<Node> arguments = new ArrayList<>();
        if(ctx.arguments().getChildCount() != 0){
            for (ParseTree tree : ctx.arguments().children) {
                if(!isSeparatorSymbol(tree)){
                    arguments.add(visit(tree));
                }
            }
        }
        return arguments;
    }

    @Override
    public Node visitBrk(PivotParser.BrkContext ctx) {
        return new BreakNode();
    }

    @Override
    public Node visitRtn(PivotParser.RtnContext ctx) {
        return new ReturnNode(visit(ctx.expr()));
    }

    @Override
    public Node visitLogicalExpressionOr(PivotParser.LogicalExpressionOrContext ctx) {
        return new LogicalOrExprNode(visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitComparisonExpression(PivotParser.ComparisonExpressionContext ctx) {
        return super.visitComparisonExpression(ctx);
    }

    @Override
    public Node visitLogicalLiterals(PivotParser.LogicalLiteralsContext ctx) {
        switch(ctx.getText()){
            case "true":
                return new LogicalLiteralNode(true);
            case "false":
                return new LogicalLiteralNode(false);
            default:
                System.out.println("Something went wrong in AstBuilder - visitLogicalLiterals");
                return null;
        }
    }

    @Override
    public Node visitLogicalExpressionAnd(PivotParser.LogicalExpressionAndContext ctx) {
        return new LogicalAndExprNode(visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitLogicalExpressionInParen(PivotParser.LogicalExpressionInParenContext ctx) {
        return visit(ctx.logical_expr());
    }



    @Override
    public Node visitComparisonExpressionWithOperator(PivotParser.ComparisonExpressionWithOperatorContext ctx) {
        ComparisonOperator op = null;

        if(ctx.op.GE() != null){
            op = ComparisonOperator.GREANTHANEQUAL;
        } else if(ctx.op.EQ() != null){
            op = ComparisonOperator.EQUALTO;
        } else if (ctx.op.GT() != null){
            op = ComparisonOperator.GREATERTHAN;
        } else if (ctx.op.NE() != null){
            op = ComparisonOperator.NOTEQUAL;
        } else if (ctx.op.SE() != null){
            op = ComparisonOperator.SMALLERTHANEQUAL;
        } else if (ctx.op.ST() != null){
            op = ComparisonOperator.SMALLERTHAN;
        }

        return new ComparisonExprNode(visit(ctx.left), visit(ctx.right), op);
    }

    @Override
    public Node visitCompOperandTime(PivotParser.CompOperandTimeContext ctx) {
        String hours = ctx.TIME().getText().substring(0,2);
        String minutes = ctx.TIME().getText().substring(3,5);
        return new TimeNode(Integer.parseInt(hours),Integer.parseInt(minutes));
    }

    @Override
    public Node visitComOperandDate(PivotParser.ComOperandDateContext ctx) {
        String day, month, year;

        // If the date has year also for one time events.
        if(ctx.DATE() != null){
            day = ctx.DATE().getText().substring(0,2);
            month = ctx.DATE().getText().substring(3,5);
            year = ctx.DATE().getText().substring(6,10);
            return new DateNode(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
        }
        // If the event is at a specific date every year, no year is needed.
        else if (ctx.DATEnoYEAR() != null){
            day = ctx.DATEnoYEAR().getText().substring(0,2);
            month = ctx.DATEnoYEAR().getText().substring(3,5);
            return new DateNode(Integer.parseInt(day), Integer.parseInt(month));
        } else {
            System.out.println("Something went wrong in AstBuilder - visitComOperandDate");
            return null;
        }
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
