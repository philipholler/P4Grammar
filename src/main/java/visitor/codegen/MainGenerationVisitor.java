package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaFileWriter;
import codegen.JavaInputParameter;
import codegen.JavaType;

import node.*;
import node.Events.EventEveryNode;
import node.Events.EventNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.Statements.*;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.IDNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.Statements.Expression.MultiExprNode;
import node.Statements.LogicalExpression.ComparisonExprNode;
import node.Statements.LogicalExpression.LogicalAndExprNode;
import node.Statements.LogicalExpression.LogicalOrExprNode;
import node.Statements.Wait.TimeFrame;
import node.Statements.Wait.WaitNode;
import node.TimeNodes.DateNode;
import node.TimeNodes.NowNode;
import node.TimeNodes.TimeNode;
import node.base.Node;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.Signal.DefSignalNode;
import node.define_nodes.Signal.EnumNode;
import semantics.FieldSymbol;
import semantics.Symbol;
import semantics.SymbolTable;
import utils.JavaCodeUtils;
import visitor.ASTBaseVisitor;

import java.lang.reflect.Method;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

public class MainGenerationVisitor extends ASTBaseVisitor<Void> {

    ClassBuilder classBuilder;
    public static final String MAIN_CLASS_NAME = "Main";
    public static final String INIT_FUNC_NAME = "init";
    public static final String PRINT_STMT_PREFIX = "System.out.println";
    public static final String WHILE_PREFIX = "while";
    public static final String IF_PREFIX = "if";
    public static final String ELSE_PREFIX = "else";
    public static final String NOW_KEYWORD = "LocalDateTime.now()";
    public static final String GET_KEYWORD = "get";
    public static final String SET_KEYWORD = "set";
    public static final String INPUT_KEYWORD = "input";
    public static final String OUTPUT_KEYWORD = "output";
    public static final String BREAK_KEYWORD = "break";
    public static final String TRUE_KEYWORD = "true";
    public static final String FALSE_KEYWORD = "false";
    public static final String SET_METHOD_NAME = "setCurrentValue";
    public static final String GET_METHOD_NAME = "getCurrentValue";
    public static final String SLEEP_METHOD_NAME = "sleep";

    public static final String THREAD_DEATH_ERROR_NAME = "ThreadDeath";

    SymbolTable st;


    @Override
    public Void visit(ProgramNode node) {
        st = node.getSt();
        st.resetScope();

        classBuilder = new ClassBuilder();

        classBuilder.appendPackage(ClassBuilder.SERVER_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.SIGNAL_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEVICE_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_CLASSES_PACKAGE).appendNewLine();

        classBuilder.appendClassDef(MAIN_CLASS_NAME);
        addMainMethod();
        addSleepMethod();
        visitChildren(node);
        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);

        JavaFileWriter.writeClass(classBuilder);
        return null;
    }

    private void addMainMethod(){
        classBuilder.appendMainMethod();
        classBuilder.appendNewObjectDecl(MAIN_CLASS_NAME, "main");
        classBuilder.append("main.").appendMethodCall(INIT_FUNC_NAME);

        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
    }

    private void addSleepMethod() {
        classBuilder.appendMethod(SLEEP_METHOD_NAME, JavaType.VOID.keyword, new JavaInputParameter(JavaType.LONG.keyword, "millis"));

        classBuilder.appendTryStatement();
        classBuilder.appendMethodCall("Thread.sleep", "millis");
        classBuilder.closeBlock(ClassBuilder.BlockType.TRY);

        classBuilder.appendCatch("InterruptedException", "e");
        classBuilder.appendThrow(THREAD_DEATH_ERROR_NAME).closeBlock(ClassBuilder.BlockType.CATCH);
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
    }

    @Override
    public Void visit(BlockNode node) {
        st.openScope(node);
        for(Node statement : node.getChildren()){
            // Get functions can stand alone, therefor remove.
            if(statement instanceof GetFuncNode){
                continue;
            } else {
                visit(statement);
            }
            if(statement instanceof ReturnNode){
                classBuilder.endLine().appendNewLine();
                st.closeScope();
                return null;
            }
            if(statement instanceof FuncCallNode) classBuilder.endLine().appendNewLine();
            if(statement instanceof SetFuncNode) classBuilder.endLine().appendNewLine();
        }

        st.closeScope();
        return null;
    }

    @Override
    public Void visit(DevDeclNode node) {
        // The only other types derive from Device with constructor (String hardwareID)
        classBuilder.appendNewObjectDecl(node.getType(), node.getID(), node.getVal());
        return null;
    }

    @Override
    public Void visit(VarDeclNode node) {
        JavaType type = JavaCodeUtils.correspondingJavaType(node.getVarType());

        // Generates : "type x = "
        classBuilder.appendWord(type.keyword).append(node.getID()).appendEquals();
        // visit children to append value that is assigned to the variable
        visit(node.getExpr());
        classBuilder.endLine();

        return null;
    }

    @Override
    public Void visit(AssignmentNode node) {
        classBuilder.append(node.getID()).appendEquals();
        visit(node.getExpr());
        classBuilder.endLine();
        return null;
    }

    @Override
    public Void visit(ReturnNode node) {
        classBuilder.append("return");

        if(node.getReturnVal() != null){
            classBuilder.appendSpace();
            visit(node.getReturnVal());
        }
        return null;
    }

    @Override
    public Void visit(FloatNode node) {
        classBuilder.append(String.valueOf(node.getVal()) + 'f');
        return null;
    }

    @Override
    public Void visit(IntegerNode node) {
        classBuilder.append(String.valueOf(node.getVal()));
        return null;
    }

    @Override
    public Void visit(StringNode node) {
        classBuilder.append(String.valueOf(node.getVal()));
        return null;
    }

    @Override
    public Void visit(FuncCallNode node) {
        classBuilder.append(node.getID()).startParan();

        for (int i = 0; i < node.getArguments().size(); i++) {
            visit(node.getArguments().get(i));

            if (i != node.getArguments().size() - 1)
                classBuilder.appendComma().appendSpace();
        }

        classBuilder.endParan();
        return null;
    }

    @Override
    public Void visit(InitNode node) {
        classBuilder.appendMethod(INIT_FUNC_NAME, JavaType.VOID.keyword);
        visit(node.getBlock());
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
        return null;
    }

    @Override
    public Void visit(GetFuncNode node) {
        // Make sure to cast the value to the correct type
        if(node.getType().equals(SymbolTable.INT_TYPE_ID)){
            classBuilder.append("(Integer)");
        } else if (node.getType().equals(SymbolTable.FLOAT_TYPE_ID)){
            classBuilder.append("(Float");
        }

        // device.
        classBuilder.append(node.getDeviceID());
        classBuilder.appendDot();

        // device.getInputSignalID() || device.getOutputSignalID()
        classBuilder.append(GET_KEYWORD);
        if(node.isOutput()){
            classBuilder.append(OUTPUT_KEYWORD);
        } else {
            classBuilder.append(INPUT_KEYWORD);
        }
        classBuilder.append(node.getSignalID() + "()");
        classBuilder.appendDot();

        // device.getInputSignalID().getCurrentValue()
        classBuilder.append(GET_METHOD_NAME + "()");

        return null;
    }

    @Override
    public Void visit(SetFuncNode node) {
        // call dot operator on the device
        // device.
        classBuilder.append(node.getDeviceID());
        classBuilder.appendDot();

        // device.getInputSignalID().
        classBuilder.append(GET_KEYWORD);
        classBuilder.append(INPUT_KEYWORD);
        classBuilder.append(node.getSignalID() + "()");
        classBuilder.appendDot();

        // Use the set function on the method.
        // device.getInputSignalID().setCurrentValue( 'expr' )
        classBuilder.append(SET_METHOD_NAME);
        classBuilder.startParan();
        // Find the 'expr'
        visit(node.getExpr());
        classBuilder.endParan();
        return null;
    }

    @Override
    public Void visit(AddExprNode node) {
        visit(node.getLeftChild());
        classBuilder.appendOperator(node.getOperator().symbol);
        visit(node.getRightChild());
        return null;
    }

    @Override
    public Void visit(MultiExprNode node) {
        // Enclose operands in parentheses to ensure correct order of evaluation
        classBuilder.startParan();
        visit(node.getLeftChild());
        classBuilder.endParan();

        classBuilder.appendOperator(node.getOperator().symbol);

        classBuilder.startParan();
        visit(node.getRightChild());
        classBuilder.endParan();
        return null;
    }

    @Override
    public Void visit(IDNode node) {
        if(st.isSignalLiteral(node.getID())){
            Optional<Symbol> sigLit = st.getSymbol(node.getID());
            if(sigLit.isPresent()){
                FieldSymbol signalLiteral = (FieldSymbol) sigLit.get();
                EnumNode enumNode = (EnumNode) signalLiteral.getDelcarationNode();
                classBuilder.append("" + ((IntegerNode)enumNode.getLiteralValue()).getVal());
            }
        } else {
            classBuilder.append(node.getID());
        }

        return null;
    }


    @Override
    public Void visit(FunctionNode node) {
        // Create an array of java method input parameters (formal parameters)
        JavaInputParameter[] inputParams = new JavaInputParameter[node.getInputParams().size()];
        for (int i = 0; i < inputParams.length; i++) {
            InputParamNode inNode = node.getInputParams().get(i);

            // Convert type from pivot type to java type
            String type = inNode.getType();
            if (SymbolTable.isPrimitiveDataType(type))
                type = JavaCodeUtils.correspondingJavaType(inNode.getType()).keyword;

            inputParams[i] = new JavaInputParameter(type, inNode.getId());
        }

        if(node.getReturnType().equals("string")){
            classBuilder.appendMethod(node.getId(), "String", inputParams);
        } else {
            classBuilder.appendMethod(node.getId(), node.getReturnType(), inputParams);
        }

        visit(node.getBlock());
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        return null;
    }


    @Override
    public Void visit(EventRangeInputNode node) {
        visitGeneralEventNode(node);
        return null;
    }

    @Override
    public Void visit(EventWhenTimeNode node) {
        visitGeneralEventNode(node);
        return null;
    }

    @Override
    public Void visit(EventEveryNode node) {
        visitGeneralEventNode(node);
        return null;
    }

    @Override
    public Void visit(EventInputNode node) {
        visitGeneralEventNode(node);
        return null;
    }

    private void visitGeneralEventNode(EventNode node) {
        String methodName = node.accept(new MethodSignatureVisitor());
        assert !methodName.isEmpty(); // Sanity check

        classBuilder.appendMethod(methodName, JavaType.VOID.keyword);
        visit(node.getBlockNode());
        classBuilder.appendNewLine().closeBlock(ClassBuilder.BlockType.METHOD);
    }

    @Override
    public Void visit(PrintNode node) {
        classBuilder.append(PRINT_STMT_PREFIX).startParan();
        visit(node.getPrintValue());
        classBuilder.endParan().endLine().appendNewLine();
        return null;
    }

    @Override
    public Void visit(DefDeviceNode node) {
        return null; // Don't do anything for definitions
    }

    @Override
    public Void visit(DefSignalNode node) {
        return null; // Don't do anything for definitions
    }

    @Override
    public Void visit(IfStmtNode node) {
        classBuilder.append(IF_PREFIX);
        classBuilder.startParan();
        visit(node.getLogicalExprNode());
        classBuilder.endParan();
        classBuilder.openBlock(ClassBuilder.BlockType.IF);
        visit(node.getIfBlock());
        classBuilder.closeBlock(ClassBuilder.BlockType.IF);

        if(node.getElseBlock() != null){
            classBuilder.append(ELSE_PREFIX);
            classBuilder.openBlock(ClassBuilder.BlockType.ELSE);
            visit(node.getElseBlock());
            classBuilder.closeBlock(ClassBuilder.BlockType.ELSE);
        }

        return null;
    }

    @Override
    public Void visit(WhileNode node) {
        classBuilder.append(WHILE_PREFIX);
        classBuilder.startParan();
        visit(node.getLeftChild());
        classBuilder.endParan();
        classBuilder.openBlock(ClassBuilder.BlockType.WHILE);
        visit(node.getRightChild());
        classBuilder.closeBlock(ClassBuilder.BlockType.WHILE);
        return null;
    }

    @Override
    public Void visit(TimeNode node) {
        LocalDateTime time = LocalDateTime.now().plusMinutes(5);
        return null;
    }

    @Override
    public Void visit(DateNode node) {
        LocalDateTime time = LocalDateTime.now().plusMinutes(5);
        return null;
    }

    @Override
    public Void visit(LogicalAndExprNode node) {
        visit(node.getLeftChild());
        classBuilder.appendOperator(node.getOp().logOp);
        visit(node.getRightChild());
        return null;
    }

    @Override
    public Void visit(LogicalOrExprNode node) {
        visit(node.getLeftChild());
        classBuilder.appendOperator(node.getOp().logOp);
        visit(node.getRightChild());
        return null;
    }

    @Override
    public Void visit(ComparisonExprNode node) {
        visit(node.getLeftChild());
        classBuilder.appendOperator(node.getOp().opString);
        visit(node.getRightChild());
        return null;
    }

    @Override
    public Void visit(NowNode node) {
        classBuilder.append(NOW_KEYWORD);
        return null;
    }

    @Override
    public Void visit(BreakNode node) {
        classBuilder.append(BREAK_KEYWORD + ";");
        return super.visit(node);
    }

    @Override
    public Void visit(WaitNode node) {
        classBuilder.append("sleep(");
        visit(node.getExpr());

        long i = 1L;
        switch(node.getTimeframe()){
            case MONTH:
                i = 2592000000L;//MS in a month
                break;
            case WEEK:
                i = 604800000L; // ms in a week
                break;
            case DAY:
                i = 86400000L; // ms in a day
                break;
            case HOUR:
                i = 3600000L; // ms in an hour
                break;
            case MINUTES:
                i = 60000L; // ms in a minute
                break;
            case SECOND:
                i = 1000L; // ms in a second
                break;
            case MILLISECONDS:
        }

        classBuilder.append("*" + i);
        classBuilder.endParan();
        classBuilder.endLine();

        return null;
    }
}
