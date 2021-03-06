package visitor;

import exceptions.userside.CompileErrorException;
import node.*;
import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.Events.WhenNodes.ExceedsAndDeceedsEnum;
import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.Statements.*;
import node.Statements.Expression.*;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.LiteralValueNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.Statements.LogicalExpression.*;
import node.TimeNodes.DateNode;
import node.TimeNodes.LocalTimeNode;
import node.TimeNodes.NowNode;
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
import pivot.PivotBaseVisitor;
import pivot.PivotParser;
import semantics.*;
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
        updateLineNumber(ctx);

        return new ProgramNode(ctx, visit(ctx.decls()), new SymbolTable());
    }

    @Override
    public Node visitDecls(PivotParser.DeclsContext ctx) {
        updateLineNumber(ctx);
        DeclsNode node = new DeclsNode(ctx);

        // Return if program is empty
        // defs=define* (vars=declVar | devVars=declDevice)* inFunc=init? (funcDecl | event)*;
        if(ctx.define().isEmpty() && ctx.declVar().isEmpty() && ctx.declDevice().isEmpty() && ctx.init() == null && ctx.funcDecl().isEmpty() && ctx.event().isEmpty()){
            return node;
        }

        for (ParseTree tree : ctx.children) {
            node.addChild(visit(tree));
        }

        return node;
    }

    @Override
    public Node visitDefine(PivotParser.DefineContext ctx) {
        updateLineNumber(ctx);

        if(ctx.signal() != null){
            return visit(ctx.signal());
        }
        if(ctx.device() != null){
            return visit(ctx.device());
        }

        throw new CompileErrorException("Error in visitDefine", getCurrentLineNumber());
    }

    @Override
    public Node visitDeclVar(PivotParser.DeclVarContext ctx) {
        updateLineNumber(ctx);
        VarDeclNode varDeclNode;
        switch (ctx.varType().getText()) {
            case SymbolTable.STRING_TYPE_ID:
                varDeclNode = new VarDeclNode(ctx, SymbolTable.STRING_TYPE_ID, ctx.ID().getText(), visit(ctx.expr()));
                break;
            case SymbolTable.INT_TYPE_ID:
                varDeclNode = new VarDeclNode(ctx, SymbolTable.INT_TYPE_ID, ctx.ID().getText(), visit(ctx.expr()));
                break;
            case SymbolTable.FLOAT_TYPE_ID:
                varDeclNode = new VarDeclNode(ctx, SymbolTable.FLOAT_TYPE_ID, ctx.ID().getText(), visit(ctx.expr()));
                break;
            default:
                throw new CompileErrorException("Error in visitDeclVar", getCurrentLineNumber());
        }

        return varDeclNode;
    }



    @Override
    public Node visitMultiExpr(PivotParser.MultiExprContext ctx) {
        updateLineNumber(ctx);
        if(ctx.op.getText().equals("*")){
            return new MultiExprNode(ctx, (ExpressionNode) visit(ctx.leftChild), (ExpressionNode) visit(ctx.rightChild), Operator.MULTPLY);
        } else if(ctx.op.getText().equals("/")){
            return new MultiExprNode(ctx, (ExpressionNode) visit(ctx.leftChild), (ExpressionNode) visit(ctx.rightChild), Operator.DIVIDE);
        } else{
            throw new CompileErrorException("Error in visitMultiExpr", getCurrentLineNumber());
        }
    }

    @Override
    public Node visitParanExpr(PivotParser.ParanExprContext ctx) {
        updateLineNumber(ctx);
        return visit(ctx.expr());
    }

    @Override
    public Node visitAtom(PivotParser.AtomContext ctx) {
        updateLineNumber(ctx);
        if(ctx.varID != null){
            return new IDNode(ctx, ctx.ID().getText());
        } else if (ctx.litVal() != null){
            return visit(ctx.litVal());
        } else if (ctx.NOW() != null){
            return new NowNode(ctx);
        } else{
            throw new CompileErrorException("Error in visitAtom", getCurrentLineNumber());
        }
    }

    @Override
    public Node visitPlusExpr(PivotParser.PlusExprContext ctx) {
        updateLineNumber(ctx);
        var left = visit(ctx.leftChild);
        var right = visit(ctx.rightChild);
        if(ctx.op.getText().equals("+") && left instanceof ExpressionNode && right instanceof ExpressionNode){
            return new AddExprNode(ctx, (ExpressionNode) left, (ExpressionNode) right, Operator.PLUS);
        } else if(ctx.op.getText().equals("-")){
            return new AddExprNode(ctx, (ExpressionNode) left, (ExpressionNode) right, Operator.MINUS);
        } else{
            throw new CompileErrorException("Error in visitPlusExpr. Could not add types '" +
                    left.getClass().getSimpleName() + "' to '" +
                    right.getClass().getSimpleName() + "'"
                    , getCurrentLineNumber());
        }
    }

    @Override
    public Node visitDeclDevice(PivotParser.DeclDeviceContext ctx) {
        updateLineNumber(ctx);
        DevDeclNode deviceDeclNode = new DevDeclNode(ctx, ctx.devType.getText(), ctx.varID.getText(), ctx.val.getText());

        return deviceDeclNode;
    }

    @Override
    public Node visitSignal(PivotParser.SignalContext ctx) {
        updateLineNumber(ctx);
        if(ctx.range() != null){
            // The defined signal is a range of numbers
            return new DefSignalNode(ctx, ctx.ID().getText(), (RangeNode) visit(ctx.range()));

        } else if(ctx.enumerations() != null){
            // The defined signal is a list of enums
            ArrayList<EnumNode> enums = visitEnums(ctx.enumerations());
            return new DefSignalNode(ctx, enums, ctx.ID().getText());
        } else{
            throw new CompileErrorException("Signal definitions must have either a range or a list of values"
                    , getCurrentLineNumber());
        }
    }

    private FieldSymbol createFieldSymbol(EnumNode node){
        return new FieldSymbol(node, node.getID(), node.getType());
    }

    // Alternative to visitEnumerations that can return more than one node.
    private ArrayList<EnumNode> visitEnums(PivotParser.EnumerationsContext ctx){
        updateLineNumber(ctx);
        ArrayList<EnumNode> enums = new ArrayList<>();
        for(PivotParser.EnumerationContext context: ctx.enumeration()){
            enums.add((EnumNode) visit(context));
        }
        return enums;
    }

    @Override
    public Node visitEnumeration(PivotParser.EnumerationContext ctx) {
        updateLineNumber(ctx);
        return new EnumNode(ctx, ctx.ID().getText(), (LiteralValueNode) visit(ctx.enumVal));
    }

    @Override
    public Node visitRange(PivotParser.RangeContext ctx) {
        updateLineNumber(ctx);
        Node lwBound = visit(ctx.lowerBound());
        Node upBound = visit(ctx.upperBound());

        // If both have the type integer.
        if(lwBound instanceof IntegerNode && upBound instanceof IntegerNode){
            return new RangeNode(ctx, lwBound, upBound, SymbolTable.INT_TYPE_ID);
        } else if (lwBound instanceof FloatNode && upBound instanceof FloatNode){
            return new RangeNode(ctx, lwBound, upBound, SymbolTable.FLOAT_TYPE_ID);
        } else {
            throw new CompileErrorException("Range type mismatch: The bounds of a range must both be integers " +
                    "or both be floats", getCurrentLineNumber());
        }
    }

    @Override
    public Node visitIntlwRange(PivotParser.IntlwRangeContext ctx) {
        updateLineNumber(ctx);
        return new IntegerNode(ctx, ctx.INTEGER().getText());
    }

    @Override
    public Node visitFloatlwRange(PivotParser.FloatlwRangeContext ctx) {
        updateLineNumber(ctx);
        return new FloatNode(ctx, ctx.FLOAT().getText());
    }

    @Override
    public Node visitIntupRange(PivotParser.IntupRangeContext ctx) {
        updateLineNumber(ctx);
        return new IntegerNode(ctx, ctx.INTEGER().getText());
    }

    @Override
    public Node visitFloatupRange(PivotParser.FloatupRangeContext ctx) {
        updateLineNumber(ctx);
        return new FloatNode(ctx, ctx.FLOAT().getText());
    }

    @Override
    public Node visitDevice(PivotParser.DeviceContext ctx) {
        updateLineNumber(ctx);
        ArrayList<InputNode> inputs = new ArrayList<>();
        ArrayList<OutputNode> outputs = new ArrayList<>();

        if(ctx.inputs() != null){
            // Start at index 2 to skip initial 'input' and ':' tokens
            for(int i = 2; i < ctx.inputs().children.size(); i++){
                ParseTree childCtx = ctx.inputs().getChild(i);
                if(isSeparatorSymbol(childCtx)) continue;
                inputs.add(new InputNode(ctx, (ctx.inputs().children.get(i)).getText()));
            }
        }

        if(ctx.outputs() != null){
            // Start at index 2 to skip initial 'output' and ':' keyword tokens
            for(int i = 2; i < ctx.outputs().getChildCount(); i++){
                ParseTree childCtx = ctx.outputs().getChild(i);
                if(isSeparatorSymbol(childCtx)) continue;
                outputs.add(new OutputNode(ctx, (ctx.outputs().children.get(i)).getText()));
            }
        }
        DefDeviceNode defDeviceNode = new DefDeviceNode(ctx, ctx.ID().getText(), outputs, inputs);

        return defDeviceNode;
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
        updateLineNumber(ctx);
        return new InitNode(ctx, visit(ctx.block()));
    }

    @Override
    public Node visitFuncDecl(PivotParser.FuncDeclContext ctx) {
        updateLineNumber(ctx);
        // First find the type of the function
        String type;
        if(ctx.varType() == null && ctx.VOID() != null){
            type = SymbolTable.VOID_TYPE_ID;
        } else {
            switch (ctx.varType().getText()){
                case "string":
                    type = SymbolTable.STRING_TYPE_ID;
                    break;
                case "int":
                    type = SymbolTable.INT_TYPE_ID;
                    break;
                case "float":
                    type = SymbolTable.FLOAT_TYPE_ID;
                    break;
                default:
                    throw new CompileErrorException("Error in visitFuncDecl. Could not find returntype.", getCurrentLineNumber());
            }
        }

        // Find id
        java.lang.String id = ctx.id.getText();

        ArrayList<InputParamNode> params = findInputParams(ctx);


        return new FunctionNode(ctx, type, id, params, visit(ctx.block()));
    }

    private ArrayList<InputParamNode> findInputParams(PivotParser.FuncDeclContext ctx){
        updateLineNumber(ctx);
        ArrayList<InputParamNode> params = new ArrayList<>();

        if(ctx.params.children != null){
            if(ctx.getChildCount() != 0){
                for(ParseTree tree : ctx.params.children){
                    if(!isSeparatorSymbol(tree)){
                        params.add((InputParamNode) visit(tree));
                    }
                }
            }
        }


        return params;
    }

    @Override
    public Node visitParam(PivotParser.ParamContext ctx) {
        updateLineNumber(ctx);
        String type = ctx.varType().getText();

        return new InputParamNode(ctx, ctx.localID.getText(), type);
    }

    @Override
    public Node visitInputWhenEvent(PivotParser.InputWhenEventContext ctx) {
        updateLineNumber(ctx);
        // If the event is triggered by exceeding og deceeding a threshold in a range.
        if(ctx.EXCEEDS() != null || ctx.DECEEDS() != null){
            ExceedsAndDeceedsEnum excdsDecds = null;
            if(ctx.EXCEEDS() != null){
                excdsDecds = ExceedsAndDeceedsEnum.EXCEEDS;
            } else if (ctx.DECEEDS() != null){
                excdsDecds = ExceedsAndDeceedsEnum.DECEEDS;
            }
            return new EventRangeInputNode(ctx, (BlockNode) visit(ctx.block()), ctx.deviceID.getText(),
                    ctx.signalID.getText(), excdsDecds, visit(ctx.number()));
        }
        // For regular enum input as trigger for an event
        else{
            return new EventInputNode(ctx, (BlockNode) visit(ctx.block()), ctx.deviceID.getText(), ctx.signalID.getText(), ctx.enumID.getText());
        }
    }

    @Override
    public Node visitNumber(PivotParser.NumberContext ctx) {
        if(ctx.INTEGER() != null){
            return new IntegerNode(ctx, ctx.INTEGER().getText());
        } else if (ctx.FLOAT() != null){
            return new FloatNode(ctx, ctx.FLOAT().getText());
        }

        return null;
    }

    @Override
    public Node visitTimeWhenEvent(PivotParser.TimeWhenEventContext ctx) {
        updateLineNumber(ctx);
        ArrayList<Node> timeAndDate = findTimeAndOrDate(ctx.timeAndDate());

        // if both time an date are present. Index 0 is time and index 1 is date.
        if(timeAndDate.size() == 2){
            return new EventWhenTimeNode(ctx, (LocalTimeNode) timeAndDate.get(0), (DateNode) timeAndDate.get(1), visit(ctx.block()));
        }
        // If only time is present
        if(timeAndDate.get(0) instanceof LocalTimeNode){
            return new EventWhenTimeNode(ctx, (LocalTimeNode) timeAndDate.get(0), visit(ctx.block()));
        }
        // If only date is present
        if(timeAndDate.get(0) instanceof DateNode){
            return new EventWhenTimeNode(ctx, (DateNode) timeAndDate.get(0), visit(ctx.block()));
        }

        throw new CompileErrorException("Error in visitTimeWhenEvent", getCurrentLineNumber());
    }

    @Override
    public Node visitRepeatEvent(PivotParser.RepeatEventContext ctx) {
        updateLineNumber(ctx);
        // For interval events with starting time. Example "every 2 hours"
        if(ctx.timeAndDate() == null){
            return new EventEveryNode(ctx,
                    new IntegerNode(ctx, ctx.INTEGER().getText()),
                    getTimeFrame(ctx.timeFrame()),
                    (BlockNode) visit(ctx.block()));

        }

        ArrayList<Node> timeAndDate = findTimeAndOrDate(ctx.timeAndDate());

        // if both time an date are present. Index 0 is time and index 1 is date.
        if(timeAndDate.size() == 2){
            return new EventEveryNode(ctx,
                    new IntegerNode(ctx, ctx.INTEGER().getText()),
                    getTimeFrame(ctx.timeFrame()),
                    (LocalTimeNode) timeAndDate.get(0),
                    (DateNode) timeAndDate.get(1),
                    (BlockNode) visit(ctx.block()));
        }
        // If only time is present
        if(timeAndDate.get(0) instanceof LocalTimeNode){
            return new EventEveryNode(ctx,
                    new IntegerNode(ctx, ctx.INTEGER().getText()),
                    getTimeFrame(ctx.timeFrame()),
                    (LocalTimeNode) timeAndDate.get(0),
                    (BlockNode) visit(ctx.block()));
        }
        // If only date is present
        if(timeAndDate.get(0) instanceof DateNode){
            return new EventEveryNode(ctx,
                    new IntegerNode(ctx, ctx.INTEGER().getText()),
                    getTimeFrame(ctx.timeFrame()),
                    (DateNode) timeAndDate.get(0),
                    (BlockNode) visit(ctx.block()));
        }

        throw new CompileErrorException("Error in visitRepeatEvent", getCurrentLineNumber());
    }

    /**
     * This method finds the date and time nodes and returns them both in an Arraylist.
     * @return Arraylist with the time and date nodes inside. If the arraylist has 2 entries, the first in time
     * and second is date.
     */
    private ArrayList<Node> findTimeAndOrDate(PivotParser.TimeAndDateContext ctx){
        updateLineNumber(ctx);
        ArrayList<Node> timeAndDate = new ArrayList<>();
        String minutes, hours, day, month, year;

        if(ctx.TIME() != null){
            hours = ctx.TIME().getText().substring(0,2);
            minutes = ctx.TIME().getText().substring(3,5);

            timeAndDate.add(new LocalTimeNode(ctx, Integer.parseInt(hours), Integer.parseInt(minutes)));
        }else{
            // Otherwise default time is 00:00
            timeAndDate.add(new LocalTimeNode(ctx, 0, 0));
        }

        if(ctx.DATE() != null){
            day = ctx.DATE().getText().substring(0,2);
            month = ctx.DATE().getText().substring(3,5);
            year = ctx.DATE().getText().substring(6,10);
            timeAndDate.add(new DateNode(ctx, Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year)));
        }else if(ctx.DATEnoYEAR() != null){
            day = ctx.DATEnoYEAR().getText().substring(0,2);
            month = ctx.DATEnoYEAR().getText().substring(3,5);
            timeAndDate.add(new DateNode(ctx, Integer.parseInt(day), Integer.parseInt(month)));
        }else if(ctx.DATEnoYEARnoMonth() != null){
            day = ctx.DATEnoYEARnoMonth().getText().substring(0,2);
            timeAndDate.add(new DateNode(ctx, Integer.parseInt(day)));
        }

        return timeAndDate;
//
    }

    @Override
    public Node visitBlock(PivotParser.BlockContext ctx) {
        updateLineNumber(ctx);
        BlockNode block = new BlockNode(ctx);

        ArrayList<Node> nodes = findNodes(ctx.stmts());

        block.addChildren(nodes);

        return block;
    }

    private ArrayList<Node> findNodes(PivotParser.StmtsContext ctx){
        updateLineNumber(ctx);
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
        updateLineNumber(ctx);
        TimeFrame timeframe = getTimeFrame(ctx.timeFrame());
        return new WaitNode(ctx, visit(ctx.expr()), timeframe);
    }

    private TimeFrame getTimeFrame(PivotParser.TimeFrameContext ctx){
        if(ctx != null){
            if(ctx.MONTHS() != null){
                return TimeFrame.MONTH;
            } else if (ctx.WEEKS() != null){
                return TimeFrame.WEEK;
            } else if (ctx.DAYS() != null){
                return TimeFrame.DAY;
            } else if(ctx.HOURS() != null){
                return TimeFrame.HOUR;
            } else if (ctx.MINUTES() != null){
                return TimeFrame.MINUTES;
            } else if (ctx.SECONDS() != null){
                return TimeFrame.SECOND;
            } else if (ctx.MS() != null){
                return TimeFrame.MILLISECONDS;
            }
        }

        throw new CompileErrorException("Error in getTimeFrame. Could not find time frame.", getCurrentLineNumber());
    }

    @Override
    public Node visitAssignment(PivotParser.AssignmentContext ctx) {
        updateLineNumber(ctx);
        return new AssignmentNode(ctx, (ExpressionNode)visit(ctx.expr()), ctx.varID.getText());
    }

    @Override
    public Node visitIfstmt(PivotParser.IfstmtContext ctx) {
        updateLineNumber(ctx);

        ArrayList<Node> children = new ArrayList<>();
        Node logicalExpr = visit(ctx.logical_expr());
        Node ifBlock = visit(ctx.blck);
        children.add(logicalExpr);
        children.add(ifBlock);
        if(ctx.elseblck != null){
            Node elseBlocK = visit(ctx.elseblck);
            children.add(elseBlocK);
        }

        return new IfStmtNode(ctx, children);
    }

    @Override
    public Node visitWhilestmt(PivotParser.WhilestmtContext ctx) {
        updateLineNumber(ctx);
        return new WhileNode(ctx, visit(ctx.logical_expr()), visit(ctx.block()));
    }

    @Override
    public Node visitFunCall(PivotParser.FunCallContext ctx) {
        updateLineNumber(ctx);
        ArrayList<Node> arguments = findArguments(ctx);
        if(!arguments.isEmpty()){
            return new FuncCallNode(ctx, arguments, ctx.id.getText());
        } else {
            return new FuncCallNode(ctx, ctx.id.getText());
        }
    }

    @Override
    public Node visitSetFun(PivotParser.SetFunContext ctx) {
        updateLineNumber(ctx);
        return new SetFuncNode(ctx, ctx.deviceID.getText(), ctx.signalID.getText(), (ExpressionNode) visit(ctx.exprVal));
    }

    @Override
    public Node visitGetFun(PivotParser.GetFunContext ctx) {
        updateLineNumber(ctx);
        // It it is not defined to be an input, it will be an output.
        // The user can, however, also define it to be an output, but this makes no difference.
        if(ctx.INPUT() == null){
            return new GetFuncNode(ctx, ctx.deviceID.getText(), ctx.signalID.getText());
        } else {
            return new GetFuncNode(ctx, ctx.deviceID.getText(), ctx.signalID.getText(), false);
        }
    }

    private ArrayList<Node> findArguments(PivotParser.FunCallContext ctx){
        updateLineNumber(ctx);
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
    public Node visitRtn(PivotParser.RtnContext ctx) {
        updateLineNumber(ctx);
        if(ctx.expr() == null){
            return new ReturnNode(ctx);
        }
        return new ReturnNode(ctx, (ExpressionNode)visit(ctx.expr()));
    }

    @Override
    public Node visitLogicalExpressionAnd(PivotParser.LogicalExpressionAndContext ctx) {
        updateLineNumber(ctx);
        return new LogicalAndExprNode(ctx, visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitLogicalExpressionOr(PivotParser.LogicalExpressionOrContext ctx) {
        updateLineNumber(ctx);
        return new LogicalOrExprNode(ctx, visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitLogicalExpressionInParen(PivotParser.LogicalExpressionInParenContext ctx) {
        updateLineNumber(ctx);
        return visit(ctx.logical_expr());
    }

    @Override
    public Node visitComparisonExpressionWithOperator(PivotParser.ComparisonExpressionWithOperatorContext ctx) {
        updateLineNumber(ctx);
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

        return new ComparisonExprNode(ctx, visit(ctx.left), visit(ctx.right), op);
    }

    @Override
    public Node visitCompOperandTime(PivotParser.CompOperandTimeContext ctx) {
        updateLineNumber(ctx);
        java.lang.String hours = ctx.TIME().getText().substring(0,2);
        java.lang.String minutes = ctx.TIME().getText().substring(3,5);
        return new LocalTimeNode(ctx, Integer.parseInt(hours),Integer.parseInt(minutes));
    }

    @Override
    public Node visitComOperandDate(PivotParser.ComOperandDateContext ctx) {
        updateLineNumber(ctx);
        String day, month, year;

        // If the date has year also for one time events.
        if(ctx.DATE() != null){
            day = ctx.DATE().getText().substring(0,2);
            month = ctx.DATE().getText().substring(3,5);
            year = ctx.DATE().getText().substring(6,10);
            return new DateNode(ctx, Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
        }
        // If the event is at a specific date every year, no year is needed.
        else if (ctx.DATEnoYEAR() != null){
            day = ctx.DATEnoYEAR().getText().substring(0,2);
            month = ctx.DATEnoYEAR().getText().substring(3,5);
            return new DateNode(ctx, Integer.parseInt(day), Integer.parseInt(month));
        }
        // If the event is a specific day a month. For example if(now < 03d) do something.
        else if (ctx.DATEnoYEARnoMonth() != null){
            day = ctx.DATEnoYEARnoMonth().getText().substring(0,2);
            return new DateNode(ctx, Integer.parseInt(day));
        }
        else {
            throw new CompileErrorException("Error in visitComOperandDate. Could not identify date or date without year",
                    getCurrentLineNumber());
        }
    }

    /**
     * All literal values
     */
    @Override
    public Node visitIntVal(PivotParser.IntValContext ctx) {
        updateLineNumber(ctx);
        return new IntegerNode(ctx, ctx.INTEGER().getText());
    }

    @Override
    public Node visitFloatVal(PivotParser.FloatValContext ctx) {
        updateLineNumber(ctx);
        return new FloatNode(ctx, ctx.FLOAT().getText());
    }

    @Override
    public Node visitStringVal(PivotParser.StringValContext ctx) {
        updateLineNumber(ctx);
        return new StringNode(ctx, ctx.STRING().getText());
    }

    @Override
    public Node visitPrintStmt(PivotParser.PrintStmtContext ctx) {
        return new PrintNode(ctx, (ExpressionNode) visit(ctx.expr()));
    }
}
