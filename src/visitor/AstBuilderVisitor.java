package visitor;

import antlr.PivotBaseVisitor;
import antlr.PivotParser;
import exceptions.user_side.CompileErrorException;
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
import node.TimeNodes.NowNode;
import node.TimeNodes.TimeNode;
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
import semantics.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public class AstBuilderVisitor extends PivotBaseVisitor<Node> {

    private static int currentLineNumber = 0;
    private SymbolTable symbolTable;

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public static int getCurrentLineNumber() {
        return currentLineNumber;
    }

    private static void updateLineNumber(ParserRuleContext fromCtx) {
        AstBuilderVisitor.currentLineNumber = fromCtx.getStart().getLine();
    }

    @Override
    public Node visitProgram(PivotParser.ProgramContext ctx) {
        symbolTable = new SymbolTable();
        updateLineNumber(ctx);

        return new ProgramNode(ctx, visit(ctx.decls()));
    }

    @Override
    public Node visitDecls(PivotParser.DeclsContext ctx) {
        updateLineNumber(ctx);
        DeclsNode node = new DeclsNode(ctx);

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
        symbolTable.enterSymbol(new FieldSymbol(varDeclNode, varDeclNode.getID(), varDeclNode.getVarType()));
        return varDeclNode;
    }



    @Override
    public Node visitMultiExpr(PivotParser.MultiExprContext ctx) {
        updateLineNumber(ctx);
        if(ctx.op.getText().equals("*")){
            return new MultiExprNode(ctx, visit(ctx.leftChild), visit(ctx.rightChild), Operator.MULTPLY);
        } else if(ctx.op.getText().equals("/")){
            return new MultiExprNode(ctx, visit(ctx.leftChild), visit(ctx.rightChild), Operator.DIVIDE);
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
        if(ctx.op.getText().equals("+")){
            return new AddExprNode(ctx, visit(ctx.leftChild), visit(ctx.rightChild), Operator.PLUS);
        } else if(ctx.op.getText().equals("-")){
            return new AddExprNode(ctx, visit(ctx.leftChild), visit(ctx.rightChild), Operator.MINUS);
        } else{
            throw new CompileErrorException("Error in visitPlusExpr", getCurrentLineNumber());
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
            DefSignalNode defSignalNode = new DefSignalNode(ctx, ctx.ID().getText(), (RangeNode) visit(ctx.range()));
            symbolTable.enterSymbol(createSignalSymbol(defSignalNode));
            return defSignalNode;

        } else if(ctx.enumerations() != null){
            // The defined signal is a list of enums
            ArrayList<EnumNode> enums = visitEnums(ctx.enumerations());
            DefSignalNode defSignalNode = new DefSignalNode(ctx, enums, ctx.ID().getText());
            symbolTable.enterSymbol(createSignalSymbol(defSignalNode));
            return defSignalNode;
        } else{
            throw new CompileErrorException("Signal definitions must have either a range or a list of values"
                    , getCurrentLineNumber());
        }
    }

    /** Creates a SignalTypeNode with either a range or list of enums based on the given signal definition node */
    private SignalTypeSymbol createSignalSymbol(DefSignalNode defSignalNode){
        if(!defSignalNode.getEnumValues().isEmpty()){
            // Create signal symbol with a list of enum values
            ArrayList<FieldSymbol> enums = new ArrayList<>();
            for(EnumNode eNode : defSignalNode.getEnumValues())
                enums.add(createFieldSymbol(eNode));
            return new SignalTypeSymbol(defSignalNode, defSignalNode.getID(), enums);
        }

        if(defSignalNode.getRangeNode().getType().equals(SymbolTable.INT_TYPE_ID)){
            // Create int range signal symbol
            int lowerBound = ((IntegerNode)(defSignalNode.getRangeNode().getLeftChild())).getVal();
            int upperBound = ((IntegerNode)(defSignalNode.getRangeNode().getRightChild())).getVal();
            return new SignalTypeSymbol(defSignalNode, defSignalNode.getID(), lowerBound, upperBound);
        }else{
            // Create float range signal symbol
            float lowerBound = ((FloatNode)(defSignalNode.getRangeNode().getLeftChild())).getVal();
            float upperBound = ((FloatNode)(defSignalNode.getRangeNode().getRightChild())).getVal();
            return new SignalTypeSymbol(defSignalNode, defSignalNode.getID(), lowerBound, upperBound);
        }
    }

    private FieldSymbol createFieldSymbol(EnumNode node){
        return new FieldSymbol(node, node.getID(), node.getValue().getType());
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
            for(int i = 1; i < ctx.inputs().children.size(); i++){
                ParseTree childCtx = ctx.inputs().getChild(i);
                if(isSeparatorSymbol(childCtx)) continue;
                inputs.add(new InputNode(ctx, (ctx.inputs().children.get(i)).getText()));
            }
        }

        if(ctx.outputs() != null){
            // Start at index 2 to skip initial 'output' and ':' keyword tokens
            for(int i = 1; i < ctx.outputs().getChildCount(); i++){
                ParseTree childCtx = ctx.outputs().getChild(i);
                if(isSeparatorSymbol(childCtx)) continue;
                outputs.add(new OutputNode(ctx, (ctx.outputs().children.get(i)).getText()));
            }
        }
        DefDeviceNode defDeviceNode = new DefDeviceNode(ctx, ctx.ID().getText(), outputs, inputs);

        symbolTable.enterSymbol(new DeviceTypeSymbol(defDeviceNode, symbolTable));

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


        FunctionNode fNode = new FunctionNode(ctx, type, id, params, visit(ctx.block()));
        FunctionSymbol fSymmbol = new FunctionSymbol(fNode);
        symbolTable.enterSymbol(fSymmbol);

        // Add function parameters to function scope
        symbolTable.openScope(fNode.getBlock());
        symbolTable.enterSymbols(fSymmbol.getParameters());
        symbolTable.closeScope();
        return fNode;
    }

    private ArrayList<InputParamNode> findInputParams(PivotParser.FuncDeclContext ctx){
        updateLineNumber(ctx);
        ArrayList<InputParamNode> params = new ArrayList<>();

        if(ctx.getChildCount() != 0){
            for(ParseTree tree : ctx.params.children){
                if(!isSeparatorSymbol(tree)){
                    params.add((InputParamNode) visit(tree));
                }
            }
        }

        return params;
    }

    @Override
    public Node visitParam(PivotParser.ParamContext ctx) {
        updateLineNumber(ctx);
        String type = ctx.varType().getText();

        if(!symbolTable.isValidType(type))
            throw new CompileErrorException("Error in visitParam. Could not find param type.", getCurrentLineNumber());

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
            return new EventRangeInputNode(ctx, visit(ctx.block()), ctx.deviceID.getText(),
                    ctx.signalID.getText(), excdsDecds, (ExpressionNode) visit(ctx.expr()));
        }
        // For regular enum input as trigger for an event
        else{
            return new EventInputNode(ctx, visit(ctx.block()), ctx.deviceID.getText(), ctx.signalID.getText(), ctx.enumID.getText());
        }
    }

    @Override
    public Node visitTimeWhenEvent(PivotParser.TimeWhenEventContext ctx) {
        updateLineNumber(ctx);
        ArrayList<Node> timeAndDate = findTimeAndOrDate(ctx.timeAndDate());

        // if both time an date are present. Index 0 is time and index 1 is date.
        if(timeAndDate.size() == 2){
            return new EventWhenTimeNode(ctx, (TimeNode) timeAndDate.get(0), (DateNode) timeAndDate.get(1), visit(ctx.block()));
        }
        // If only time is present
        if(timeAndDate.get(0) instanceof TimeNode){
            return new EventWhenTimeNode(ctx, (TimeNode) timeAndDate.get(0), visit(ctx.block()));
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
                    (ExpressionNode) visit(ctx.expr()),
                    getTimeFrame(ctx.timeFrame()),
                    (BlockNode) visit(ctx.block()));

        }

        ArrayList<Node> timeAndDate = findTimeAndOrDate(ctx.timeAndDate());

        // if both time an date are present. Index 0 is time and index 1 is date.
        if(timeAndDate.size() == 2){
            return new EventEveryNode(ctx,
                    (ExpressionNode) visit(ctx.expr()),
                    getTimeFrame(ctx.timeFrame()),
                    (TimeNode) timeAndDate.get(0),
                    (DateNode) timeAndDate.get(1),
                    (BlockNode) visit(ctx.block()));
        }
        // If only time is present
        if(timeAndDate.get(0) instanceof TimeNode){
            return new EventEveryNode(ctx,
                    (ExpressionNode) visit(ctx.expr()),
                    getTimeFrame(ctx.timeFrame()),
                    (TimeNode) timeAndDate.get(0),
                    (BlockNode) visit(ctx.block()));
        }
        // If only date is present
        if(timeAndDate.get(0) instanceof DateNode){
            return new EventEveryNode(ctx,
                    (ExpressionNode) visit(ctx.expr()),
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
        java.lang.String minutes, hours, day, month, year;

        // If the date and time are both fully used. For example "when 14:00 21d03m2019y"
        if(ctx.DATE() != null && ctx.TIME() != null){
            hours = ctx.TIME().getText().substring(0,2);
            minutes = ctx.TIME().getText().substring(3,5);
            timeAndDate.add(new TimeNode(ctx, Integer.parseInt(hours), Integer.parseInt(minutes)));

            day = ctx.DATE().getText().substring(0,2);
            month = ctx.DATE().getText().substring(3,5);
            year = ctx.DATE().getText().substring(6,10);
            timeAndDate.add(new DateNode(ctx, Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year)));

            return timeAndDate;
        }
        // If time and date are both used, but no year is given. For example if something is repeated every year.
        // An example of this would be: "when 14:00 21d03m
        if (ctx.DATEnoYEAR() != null && ctx.TIME() != null){
            hours = ctx.TIME().getText().substring(0,2);
            minutes = ctx.TIME().getText().substring(3,5);
            timeAndDate.add(new TimeNode(ctx, Integer.parseInt(hours), Integer.parseInt(minutes)));

            day = ctx.DATEnoYEAR().getText().substring(0,2);
            month = ctx.DATEnoYEAR().getText().substring(3,5);
            timeAndDate.add(new DateNode(ctx, Integer.parseInt(day), Integer.parseInt(month)));

            return timeAndDate;
        }

        // If just a time is given. For example "when 14:00". This will then trigger every day.
        if(ctx.TIME() != null){
            hours = ctx.TIME().getText().substring(0,2);
            minutes = ctx.TIME().getText().substring(3,5);
            timeAndDate.add(new TimeNode(ctx, Integer.parseInt(hours), Integer.parseInt(minutes)));

            return timeAndDate;
        }

        // if only a date i present. For example "when 01d01m2000y"
        if(ctx.DATE() != null){
            day = ctx.DATE().getText().substring(0,2);
            month = ctx.DATE().getText().substring(3,5);
            year = ctx.DATE().getText().substring(6,10);
            timeAndDate.add(new DateNode(ctx, Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year)));

            return timeAndDate;
        }

        // If only a date without year is present. For example "when 01d01m"
        if(ctx.DATEnoYEAR() != null){
            day = ctx.DATEnoYEAR().getText().substring(0,2);
            month = ctx.DATEnoYEAR().getText().substring(3,5);
            timeAndDate.add(new DateNode(ctx, Integer.parseInt(day), Integer.parseInt(month)));

            return timeAndDate;
        }

        throw new CompileErrorException("Error in findTimeAndDateNote", getCurrentLineNumber());
    }

    @Override
    public Node visitBlock(PivotParser.BlockContext ctx) {
        updateLineNumber(ctx);
        BlockNode block = new BlockNode(ctx);
        
        symbolTable.openScope(block);
        ArrayList<Node> stmts = findNodes(ctx.stmts());
        symbolTable.closeScope();

        block.addChildren(stmts);
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
        return new AssignmentNode(ctx, visit(ctx.expr()), ctx.varID.getText());
    }

    @Override
    public Node visitIfstmt(PivotParser.IfstmtContext ctx) {
        updateLineNumber(ctx);
        return new IfStmtNode(ctx, visit(ctx.logical_expr()), visit(ctx.blck));
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
        return new SetFuncNode(ctx, ctx.deviceID.getText(), ctx.signalID.getText(), visit(ctx.expr()));
    }

    @Override
    public Node visitGetFun(PivotParser.GetFunContext ctx) {
        updateLineNumber(ctx);
        return new GetFuncNode(ctx, ctx.deviceID.getText(), ctx.signalID.getText());
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
    public Node visitBrk(PivotParser.BrkContext ctx) {
        updateLineNumber(ctx);
        return new BreakNode(ctx);
    }

    @Override
    public Node visitRtn(PivotParser.RtnContext ctx) {
        updateLineNumber(ctx);
        if(ctx.expr() == null){
            return new ReturnNode(ctx);
        }
        return new ReturnNode(ctx, visit(ctx.expr()));
    }

    @Override
    public Node visitLogicalExpressionOr(PivotParser.LogicalExpressionOrContext ctx) {
        updateLineNumber(ctx);
        return new LogicalOrExprNode(ctx, visit(ctx.left), visit(ctx.right));
    }

    @Override
    public Node visitLogicalLiterals(PivotParser.LogicalLiteralsContext ctx) {
        updateLineNumber(ctx);
        switch(ctx.getText()){
            case "true":
                return new LogicalLiteralNode(ctx, true);
            case "false":
                return new LogicalLiteralNode(ctx, false);
            default:
                throw new CompileErrorException("Error in visitLogicalLiterals. Could not identify literal: " +
                        ctx.getText(), getCurrentLineNumber());
        }
    }

    @Override
    public Node visitLogicalExpressionAnd(PivotParser.LogicalExpressionAndContext ctx) {
        updateLineNumber(ctx);
        return new LogicalAndExprNode(ctx, visit(ctx.left), visit(ctx.right));
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
        return new TimeNode(ctx, Integer.parseInt(hours),Integer.parseInt(minutes));
    }

    @Override
    public Node visitComOperandDate(PivotParser.ComOperandDateContext ctx) {
        updateLineNumber(ctx);
        java.lang.String day, month, year;

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
        } else {
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
}
