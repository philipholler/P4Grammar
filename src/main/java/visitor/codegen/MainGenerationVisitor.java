package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaFileWriter;
import codegen.JavaInputParameter;
import codegen.JavaType;

import default_classes.event.SignalEventManager;
import default_classes.server.Server;
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
import node.Statements.Expression.ExpressionNode;
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
import node.Statements.Wait.WaitNode;
import node.TimeNodes.DateNode;
import node.TimeNodes.LocalTimeNode;
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

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.TreeSet;

public class MainGenerationVisitor extends ASTBaseVisitor<Void> {

    ClassBuilder classBuilder;
    ClassBuilder eventListBuilder;

    public static final String MAIN_CLASS_NAME = "Main";
    public static final String INIT_FUNC_NAME = "init";
    public static final String PRINT_STMT_PREFIX = "System.out.println";
    public static final String WHILE_PREFIX = "while";
    public static final String IF_PREFIX = "if";
    public static final String ELSE_PREFIX = "else";
    public static final String NOW_KEYWORD = "LocalDateTime.now()";
    public static final String GET_KEYWORD = "get";
    public static final String INPUT_KEYWORD = "input";
    public static final String OUTPUT_KEYWORD = "output";
    public static final String SET_KEYWORD = "set";
    public static final String BREAK_KEYWORD = "break";
    public static final String TRUE_KEYWORD = "true";
    public static final String FALSE_KEYWORD = "false";
    public static final String SET_METHOD_NAME = "setCurrentValue";
    public static final String GET_METHOD_NAME = "getCurrentValue";
    public static final String SLEEP_METHOD_NAME = "sleep";
    public static final String SERVER_VAR_NAME = "server";
    public static final String EVENT_INIT_METHOD = "eventInit";
    public static final String DEVICE_LIST_NAME = "devices";
    public static final String SIGNAL_EVENT_MANAGER = "signalEventManager";
    public static final String DEVICE_LIST_FILL_METHOD = "fillDeviceList";


    public static final String THREAD_DEATH_ERROR_NAME = "ThreadDeath";

    private SymbolTable st;
    private GlobalVarVisitor globalVarVisitor;

    @Override
    public Void visit(ProgramNode node) {
        st = node.getSt();
        globalVarVisitor = new GlobalVarVisitor(st);
        st.resetScope();

        classBuilder = new ClassBuilder();
        eventListBuilder = new ClassBuilder();

        classBuilder.appendPackage(ClassBuilder.SERVER_PACKAGE);
        addImports();

        classBuilder.appendClassDef(MAIN_CLASS_NAME);
        addStandardVars(); // Todo Should be thread safe
        addMainMethod(node.getDeclsNode());
        addConstructor(node.getDeclsNode());

        addSleepMethod();
        visitChildren(node); // Todo maybe visit vardecl children seperately in order to have var decls at the top of generated code
        addDeviceListFill();
        classBuilder.appendGetMethod("ArrayList<Device>", DEVICE_LIST_NAME);

        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);
        JavaFileWriter.writeClass(classBuilder);
        return null;
    }

    private void addDeviceListFill() {
        classBuilder.appendMethod(DEVICE_LIST_FILL_METHOD, JavaType.VOID.keyword);
        // Add devices to the device list
        classBuilder.append(eventListBuilder.toString());
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
    }

    private void addImports() {
        classBuilder.appendImportAllFrom(ClassBuilder.SIGNAL_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEVICE_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.EVENT_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_SERVER_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_DEVICE_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_EVENT_PACKAGE);
        classBuilder.appendImport(ClassBuilder.ARRAYLIST_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_CLASSES_PACKAGE).appendNewLine();
        classBuilder.appendImport("java.time.LocalDate");
        classBuilder.appendImport("java.time.LocalTime");
        classBuilder.appendImport("java.time.MonthDay");
        classBuilder.appendImport("java.time.LocalDateTime");
    }

    private void addStandardVars() {
        classBuilder.appendFinal().appendObjectDecl(Server.class.getSimpleName(), SERVER_VAR_NAME);
        classBuilder.appendFinal().appendNewObjectDecl("ArrayList<Device>", DEVICE_LIST_NAME);
        classBuilder.appendFinal().appendObjectDecl(SignalEventManager.class.getSimpleName(), SIGNAL_EVENT_MANAGER);
    }

    private void addMainMethod(DeclsNode node) {
        classBuilder.appendMainMethod();
        classBuilder.appendFinal().appendNewObjectDecl(MAIN_CLASS_NAME, "main");
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
    }

    private void addConstructor(DeclsNode node) {
        classBuilder.appendConstructor();

        // Add call to add all method a list
        classBuilder.appendMethodCall(DEVICE_LIST_FILL_METHOD);

        // Todo call init server before init (Since the init method can call server-dependant methods)
        // afasfsadfsd

        // Call user-defined init function if it's defined
        if (node.hasInitNode()) classBuilder.appendMethodCall(INIT_FUNC_NAME);

        addEventInitStatements();


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
        for (Node statement : node.getChildren()) {
            // Get functions can stand alone, therefor remove.
            if (statement instanceof GetFuncNode)
                continue;
            else
                visit(statement);

            if (statement instanceof ReturnNode) {
                classBuilder.endLine().appendNewLine();
                st.closeScope();
                return null;
            }
            if (statement instanceof FuncCallNode) classBuilder.endLine().appendNewLine();
            if (statement instanceof SetFuncNode) classBuilder.endLine().appendNewLine();
        }

        st.closeScope();
        return null;
    }

    @Override
    public Void visit(DevDeclNode node) {
        // The only other types derive from Device with constructor (String hardwareID)
        classBuilder.appendPublicKeyWord();
        classBuilder.appendFinal().appendNewObjectDecl(node.getType(), node.getID(), node.getVal());

        // Add device to device list
        eventListBuilder.append(DEVICE_LIST_NAME).appendDot().append("add");
        eventListBuilder.startParan().append(node.getID()).endParan().endLine();
        return null;
    }

    @Override
    public Void visit(VarDeclNode node) {
        JavaType type = JavaCodeUtils.correspondingJavaType(node.getVarType());

        // Generates : "type x = "
        classBuilder.append(type.objectType).appendSpace().append(node.getID()).appendEquals();
        // visit children to append data that is assigned to the variable
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

        if (node.getReturnVal() != null) {
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

        // User-programmed init
        visit(node.getBlock());
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
        return null;
    }

    // Default init behaviour - Initialize events and server + and run event managers
    private void addEventInitStatements() {
        String eventInitName = "eventInit";

        // "EventInitializer eventInit = "
        classBuilder.append(EventInitializationVisitor.EVENT_INIT_CLASS_NAME).appendSpace().append(eventInitName)
                .appendEquals();

        // "new EventInitializer(this);
        classBuilder.append("new ").append(EventInitializationVisitor.EVENT_INIT_CLASS_NAME)
                .startParan().append("this").endParan().endLine();

        // eventInit.startEventManagers
        classBuilder.append(eventInitName).appendDot().append(EventInitializationVisitor.START_EVENTMANAGERS_METHOD)
                .startParan().endParan().endLine();

        // "server = new Server("
        classBuilder.append(SERVER_VAR_NAME).appendEquals()
                .append("new ").append(Server.class.getSimpleName()).startParan();

        // eventInit.getSignalEventManager());
        classBuilder.append(eventInitName).appendDot().append(ClassBuilder.GET_METHOD_PREFIX)
                .append(EventInitializationVisitor.SIGNAL_EVENT_MANAGER).startParan().endParan();
        classBuilder.endParan().endLine();

        // signalEventManager = eventInit.getSignalEventManager()
        classBuilder.append(SIGNAL_EVENT_MANAGER).appendEquals();
        classBuilder.append(eventInitName).appendDot().append(ClassBuilder.GET_METHOD_PREFIX)
                .append(EventInitializationVisitor.SIGNAL_EVENT_MANAGER).startParan().endParan();
        classBuilder.endLine();

        //server.start();
        classBuilder.append(SERVER_VAR_NAME).appendDot().appendMethodCall("start");
    }

    @Override
    public Void visit(GetFuncNode node) {
        // Make sure to cast the data to the correct type
        if (node.getType().equals(SymbolTable.INT_TYPE_ID)) {
            classBuilder.append("(Integer)");
        } else if (node.getType().equals(SymbolTable.FLOAT_TYPE_ID)) {
            classBuilder.append("(Float");
        }

        // device.
        classBuilder.append(node.getDeviceID());
        classBuilder.appendDot();

        // device.getInputSignalID() || device.getOutputSignalID()
        classBuilder.append(GET_KEYWORD);
        if (node.isOutput()) {
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
        classBuilder.append("Utils.sendSignal").startParan()
                    .append(SERVER_VAR_NAME).appendComma();

        classBuilder.append(node.getDeviceID()).appendComma();

        classBuilder.append(node.getDeviceID()).appendDot()
                    .append(GET_KEYWORD).append(INPUT_KEYWORD)
                    .append(node.getSignalID()).startParan().endParan().appendComma();


        classBuilder.append("String.valueOf").startParan();
        visit(node.getExpr());
        classBuilder.endParan();

        classBuilder.endParan().endLine();
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
        // If the id is a signal literal then replace the id with the actual data
        if (st.isSignalLiteral(node.getID())) {
            Optional<Symbol> sigLit = st.getSymbol(node.getID());
            if (sigLit.isPresent()) {
                FieldSymbol signalLiteral = (FieldSymbol) sigLit.get();
                EnumNode enumNode = (EnumNode) signalLiteral.getDelcarationNode();
                classBuilder.append("" + ((IntegerNode) enumNode.getLiteralValue()).getVal());
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

        if (node.getReturnType().equals("string")) {
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

        syncVisitBlock(node.getBlockNode());

//        visit(node.getBlockNode());
        classBuilder.appendNewLine().closeBlock(ClassBuilder.BlockType.METHOD);
    }

    // Event blocks are different than regular block because all statements inside an event
    // must be preceded by synchronization locking all used global variables
    private void syncVisitBlock(BlockNode blockNode) {

        // Synchronize all used variables before each statement
        for (Node n : blockNode.getChildren()) {
            // Optimization : While loops can have their synchronizes inside the block
            // (if and only if the condition uses no global variables)
            if(n instanceof WhileNode && globalVarVisitor.visit(((WhileNode) n).getLogicalExprNode()).size() == 0){
                WhileNode whnode  = (WhileNode) n;
                classBuilder.append("while(");
                visit(((WhileNode) n).getLogicalExprNode());
                classBuilder.append(")").openBlock(ClassBuilder.BlockType.WHILE);
                syncVisitBlock(((WhileNode) n).getBlockNode());
                classBuilder.closeBlock(ClassBuilder.BlockType.WHILE);
                continue;
            }

            TreeSet<FieldSymbol> globalVars = globalVarVisitor.visit(n);
            openSyncBlocks(globalVars);
            visit(n);// Add statement logic

            // If an expression constitues the whole line the add ';' and newline
            if(n instanceof ExpressionNode)
                classBuilder.endLine();
            closeSyncBlocks(globalVars.size());
        }
    }

    private void openSyncBlocks(TreeSet<FieldSymbol> globalVars) {
        for (Symbol field : globalVars)
            classBuilder.startSyncBlock(field.getID());
    }


    private void closeSyncBlocks(int blocksToClose) {
        for (int i = 0; i < blocksToClose; i++)
            classBuilder.closeBlock(ClassBuilder.BlockType.SYNCHRONIZED);
    }


    @Override
    public Void visit(PrintNode node) {
        classBuilder.append(PRINT_STMT_PREFIX).startParan();
        visit(node.getPrintValue());
        classBuilder.endParan().endLine();
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

        if (node.getElseBlock() != null) {
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

        // Loop condition
        classBuilder.startParan();
        visit(node.getLeftChild());
        classBuilder.endParan();

        classBuilder.openBlock(ClassBuilder.BlockType.WHILE);

        appendInterruptCheck();
        visit(node.getRightChild());
        classBuilder.closeBlock(ClassBuilder.BlockType.WHILE);
        return null;
    }

    private void appendInterruptCheck() {
        classBuilder.append("Utils.").appendMethodCall("interruptCheck");
    }

    @Override
    public Void visit(LocalTimeNode node) {
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
        if (node.getLeftChild() instanceof NowNode && node.getRightChild() instanceof TimeNode) {
            classBuilder.appendTimeComparison((NowNode) node.getLeftChild(), (TimeNode) node.getRightChild(), node.getOp());
            return null;
        }
        if (node.getLeftChild() instanceof TimeNode && node.getRightChild() instanceof NowNode) {
            classBuilder.appendTimeComparison((TimeNode) node.getLeftChild(), (NowNode) node.getRightChild(), node.getOp());
            return null;
        }

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
    public Void visit(WaitNode node) {
        classBuilder.append("sleep(");
        visit(node.getExpr());

        long i = 1L;
        switch (node.getTimeframe()) {
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
