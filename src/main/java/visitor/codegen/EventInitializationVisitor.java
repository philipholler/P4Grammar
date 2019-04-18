package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaFileWriter;
import codegen.JavaInputParameter;
import codegen.JavaType;
import default_classes.event.*;
import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.ProgramNode;
import visitor.ASTBaseVisitor;

public class EventInitializationVisitor extends ASTBaseVisitor<Void> {

    ClassBuilder classBuilder;

    public static final String EVENT_INIT_CLASS_NAME = "EventInitializer";
    public static final String START_EVENTMANAGERS_METHOD = "startEventManagers";
    private static final String MAIN_REFERENCE_NAME = "main";
    private static final String ADD_EVENTS_METHOD = "fillEventLists";
    private static final String TIME_EVENT_LIST = "timeEvents";
    private static final String SIGNAL_EVENT_LIST = "signalEvents";
    private static final String SIGNAL_EVENT_MANAGER = "signalEventManager";
    private static final String TIME_EVENT_MANAGER = "timeEventManager";

    private final MethodSignatureVisitor methodSignatureVisitor = new MethodSignatureVisitor();

    @Override
    public Void visit(ProgramNode node) {
        classBuilder = new ClassBuilder();
        classBuilder.appendPackage(ClassBuilder.EVENT_PACKAGE);
        addImports();

        classBuilder.appendClassDef(EVENT_INIT_CLASS_NAME);

        addLocalVars();
        addConstructor();

        // Add method for starting event managers
        classBuilder.appendMethod(START_EVENTMANAGERS_METHOD, JavaType.VOID.keyword);
        classBuilder.append(SIGNAL_EVENT_MANAGER).appendDot().append("start()").endLine().appendNewLine();
        classBuilder.append(TIME_EVENT_MANAGER).appendDot().append("start()").endLine().appendNewLine();
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        // Method for adding events to their respective lists
        classBuilder.appendMethod(ADD_EVENTS_METHOD, JavaType.VOID.keyword);
        visitChildren(node);
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);
        JavaFileWriter.writeClass(classBuilder);
        return null;
    }

    private void addImports() {
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_SIGNAL_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_EVENT_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_DEVICE_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEVICE_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.SIGNAL_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.SERVER_PACKAGE);
        classBuilder.appendImport(ClassBuilder.ARRAYLIST_PACKAGE).appendNewLine();
    }

    private void addLocalVars(){
        classBuilder.appendObjectDecl(MainGenerationVisitor.MAIN_CLASS_NAME, MAIN_REFERENCE_NAME);

        classBuilder.appendNewObjectDecl("ArrayList<" + TimeEvent.class.getSimpleName() + ">", TIME_EVENT_LIST);
        classBuilder.appendNewObjectDecl("ArrayList<" + SignalEvent.class.getSimpleName() + ">", SIGNAL_EVENT_LIST);
        classBuilder.appendObjectDecl(TimeEventManager.class.getSimpleName(), TIME_EVENT_MANAGER);
        classBuilder.appendObjectDecl(SignalEventManager.class.getSimpleName(), SIGNAL_EVENT_MANAGER).appendNewLine();
    }

    private void addConstructor() {
        classBuilder.appendConstructor(new JavaInputParameter(MainGenerationVisitor.MAIN_CLASS_NAME
                , MAIN_REFERENCE_NAME));
        classBuilder.appendAssignment("this." + MAIN_REFERENCE_NAME, MAIN_REFERENCE_NAME);
        classBuilder.appendMethodCall(ADD_EVENTS_METHOD);

        classBuilder.appendAssignment(TIME_EVENT_MANAGER, "new " + TimeEventManager.class.getSimpleName()
                + "(" + TIME_EVENT_LIST + ")");
        classBuilder.appendAssignment(SIGNAL_EVENT_MANAGER, "new " + SignalEventManager.class.getSimpleName()
                + "(" + SIGNAL_EVENT_LIST + ")");

        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
    }

    @Override
    public Void visit(EventInputNode node) {
        String eventFunctionName = methodSignatureVisitor.visit(node);

        classBuilder.append(TIME_EVENT_LIST).appendDot().append("add").startParan();
        classBuilder.append("new ").append(SimpleSignalEvent.class.getSimpleName()).append(" ").startParan();

        // Defnition of parameters for simpleSignalEvent constructor :

        // device
        classBuilder.append(MAIN_REFERENCE_NAME).appendDot().append(node.getDeviceID()).appendComma();

        // device.getOutputSignal
        classBuilder.append(MAIN_REFERENCE_NAME).appendDot().append(node.getDeviceID()).appendDot()
                .append(MainGenerationVisitor.GET_KEYWORD)
                .append(ClassGenerationVisitor.OUTPUT_SIGNAL_PREFIX).append(node.getSignalID())
                .startParan().endParan().appendComma().appendSpace();

        //classBuilder.append(node.get)
        classBuilder.appendComma().appendSpace();

        // the runnable  () -> main.eventFunction()
        classBuilder.startParan().endParan().appendLambdaArrow().append(MAIN_REFERENCE_NAME).appendDot()
                .append(eventFunctionName).startParan().endParan();

        classBuilder.endParan().endParan().endLine().appendNewLine();
        return null;
    }

    @Override
    public Void visit(EventRangeInputNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(EventWhenTimeNode node) {
        /*classBuilder.append(TIME_EVENT_LIST).appendDot().append("add").startParan();
        classBuilder.append("new ").append(TimeConditionEvent.class.getSimpleName()).append(" ").startParan();

        classBuilder.endParan().endLine().appendNewLine();*/
        return super.visit(node);
    }

    @Override
    public Void visit(EventEveryNode node) {
        return super.visit(node);
    }
}
