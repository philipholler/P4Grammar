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
import node.Events.WhenNodes.ExceedsAndDeceedsEnum;
import node.ProgramNode;
import semantics.SymbolTable;
import visitor.ASTBaseVisitor;

import java.time.LocalDate;
import java.time.LocalTime;

import static codegen.ClassBuilder.GET_METHOD_PREFIX;

public class EventInitializationVisitor extends ASTBaseVisitor<Void> {

    ClassBuilder classBuilder;

    public static final String EVENT_INIT_CLASS_NAME = "EventInitializer";
    public static final String START_EVENTMANAGERS_METHOD = "startEventManagers";

    private static final String MAIN_REFERENCE_NAME = "main";
    private static final String ADD_EVENTS_METHOD = "fillEventLists";
    private static final String TIME_EVENT_LIST = "timeEvents";
    private static final String SIGNAL_EVENT_LIST = "signalEvents";
    public static final String SIGNAL_EVENT_MANAGER = "signalEventManager";
    private static final String TIME_EVENT_MANAGER = "timeEventManager";

    private final MethodSignatureVisitor methodSignatureVisitor = new MethodSignatureVisitor();

    private SymbolTable symbolTable;


    @Override
    public Void visit(ProgramNode node) {
        this.symbolTable = node.getSt();
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

        classBuilder.appendGetMethod(TimeEventManager.class.getSimpleName(), TIME_EVENT_MANAGER);
        classBuilder.appendGetMethod(SignalEventManager.class.getSimpleName(), SIGNAL_EVENT_MANAGER);


        // Create method for adding events to their respective lists
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
        classBuilder.appendImportAllFrom(ClassBuilder.SERVER_PACKAGE).appendNewLine();
        classBuilder.appendImport(ClassBuilder.ARRAYLIST_PACKAGE);
        classBuilder.appendImport("java.time.LocalDate");
        classBuilder.appendImport("java.time.LocalTime").appendNewLine();

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

        // Initialize signalEventManager
        classBuilder.append(SIGNAL_EVENT_MANAGER).appendEquals();
        classBuilder.append("new ").append(SignalEventManager.class.getSimpleName()).startParan()
                .append(SIGNAL_EVENT_LIST).appendComma().appendSpace()
                .append(MAIN_REFERENCE_NAME).appendDot()
                .append(GET_METHOD_PREFIX + MainGenerationVisitor.DEVICE_LIST_NAME).startParan().endParan()
                .endParan().endLine();

        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
    }

    @Override
    public Void visit(EventInputNode node) {
        String eventFunctionName = methodSignatureVisitor.visit(node);

        classBuilder.append(SIGNAL_EVENT_LIST).appendDot().append("add").startParan();
        classBuilder.append("new ").append(SimpleSignalEvent.class.getSimpleName()).append(" ").startParan();

        // Definition of parameters for simpleSignalEvent constructor :

        // device
        classBuilder.append(MAIN_REFERENCE_NAME).appendDot().append(node.getDeviceID()).appendComma();

        // device.getOutputSignal
        classBuilder.append(MAIN_REFERENCE_NAME).appendDot().append(node.getDeviceID()).appendDot()
                .append(MainGenerationVisitor.GET_KEYWORD)
                .append(ClassGenerationVisitor.OUTPUT_SIGNAL_PREFIX).append(node.getSignalID())
                .startParan().endParan().appendComma().appendSpace();

        //classBuilder.append(node.get)
        classBuilder.append(symbolTable.getEnumStringValue(node.getEnumID()));
        classBuilder.appendComma().appendSpace();

        // the runnable  () -> main.eventFunction()
        classBuilder.startParan().endParan().appendLambdaArrow().append(MAIN_REFERENCE_NAME).appendDot()
                .append(eventFunctionName).startParan().endParan();

        classBuilder.endParan().endParan().endLine().appendNewLine();
        return null;
    }

    @Override
    public Void visit(EventRangeInputNode node) {
        String device = MAIN_REFERENCE_NAME + "." + node.getDeviceID();
        String signal = MAIN_REFERENCE_NAME + "." + node.getDeviceID() + "."
                + GET_METHOD_PREFIX + ClassGenerationVisitor.OUTPUT_SIGNAL_PREFIX
                + node.getSignalID() + "()";

        String threshold = node.getThresholdString();
        String passType;
        if(node.getExceedsAndDeceedsEnum() == ExceedsAndDeceedsEnum.EXCEEDS)
            passType = RangeSignalEvent.EXCEEDS;
        else
            passType = RangeSignalEvent.DECEEDS;

        passType = '"' + passType + '"'; // Turn into string

        String runnable = MAIN_REFERENCE_NAME + "." + new MethodSignatureVisitor().visit(node) + "()";

        addRangeEvent(device, signal, threshold, passType, runnable);
        return super.visit(node);
    }

    private void addRangeEvent(String device, String signal, String threshold, String passType, String runnable) {
        // Example gen "timeEvens.add(new TimeCondition("
        classBuilder.append(SIGNAL_EVENT_LIST).appendDot().append("add").startParan();
        classBuilder.append("new ").append(RangeSignalEvent.class.getSimpleName()).startParan();

        // Example gen "2019, 12, 31, 23, 59, 59, () ->"
        classBuilder.appendCommaSeparated(device, signal, threshold, passType).appendComma();
        classBuilder.startParan().endParan().appendLambdaArrow();

        // Example gen "main.eventFunc21()"
        classBuilder.append(runnable);

        classBuilder.endParan().endParan().endLine();
    }

    @Override
    public Void visit(EventWhenTimeNode node) {
        // Find input parameters for TimeConditionEvent
        final String UNSPECIFIED = String.valueOf(TimeConditionEvent.UNSPECIFIED);

        String year = UNSPECIFIED, month = UNSPECIFIED, day = UNSPECIFIED;
        String hour = UNSPECIFIED, minute = UNSPECIFIED;

        if(node.getDateNode().getDate() != null){ // The event definition specifies year, month and day
            year = String.valueOf(node.getDateNode().getDate().getYear());
            month = String.valueOf(node.getDateNode().getDate().getMonthValue());
            day = String.valueOf(node.getDateNode().getDate().getDayOfMonth());
        }else if(node.getDateNode().getMonthDay() != null){ // Only month and day are specified in event
            month = String.valueOf(node.getDateNode().getMonthDay().getMonthValue());
            day = String.valueOf(node.getDateNode().getMonthDay().getDayOfMonth());
        }else if(node.getDateNode().getDay() != -1){ // Only day of the month is specified in event
            day = String.valueOf(node.getDateNode().getDay());
        }// Otherwise all date values are unspecified

        hour = String.valueOf(node.getTimeNode().getTime().getHour());
        minute = String.valueOf(node.getTimeNode().getTime().getMinute());


        // Generate code (example) : "timeEvents.add(2019, 11, 27, 23, 59, 59, () -> main.when21d02h());"
        addTimeConditionEventDef(year, month, day, hour, minute, new MethodSignatureVisitor().visit(node));

        return null;
    }

    private void addTimeConditionEventDef(String year, String month, String day, String hour,
                                          String minute, String eventFunction) {

        // Example gen "timeEvens.add(new TimeCondition("
        classBuilder.append(TIME_EVENT_LIST).appendDot().append("add").startParan();
        classBuilder.append("new ").append(TimeConditionEvent.class.getSimpleName()).startParan();

        // Example gen "2019, 12, 31, 23, 59, 59, () ->"
        classBuilder.appendCommaSeparated(year, month, day, hour, minute).appendComma();
        classBuilder.startParan().endParan().appendLambdaArrow();

        // Example gen "main.eventFunc21()"
        classBuilder.append(MAIN_REFERENCE_NAME).appendDot().append(eventFunction).startParan().endParan();

        classBuilder.endParan().endParan().endLine();
    }


    @Override
    public Void visit(EventEveryNode node) {
        String timeFrame = '"' + node.getTimeframe().name() + '"';
        String delay = String.valueOf(node.getInteger().getVal()) ;
        String startDate, startTime;
        String runnable = MAIN_REFERENCE_NAME + "." + new MethodSignatureVisitor().visit(node);

        if(node.getDateNode() != null)
            startDate = addLocalDateDeclaration("date_node" + node.getLineNumber(), node.getDateNode().getDate());
        else
            startDate = "null";


        if(node.getTimeNode() != null)
            startTime = addLocalTimeDeclaration("time_node" + node.getLineNumber(), node.getTimeNode().getTime());
        else
            startTime = "null";

        addTimeIntervalEventDef(timeFrame, delay, startDate, startTime, runnable);
        return super.visit(node);
    }

    private void addTimeIntervalEventDef(String timeFrame, String delay, String startDate, String startTime, String runnable) {
        // Example gen "timeEvens.add(new TimeIntervalEvent("
        classBuilder.append(TIME_EVENT_LIST).appendDot().append("add").startParan();
        classBuilder.append("new ").append(TimeIntervalEvent.class.getSimpleName()).startParan();

        // Example gen "25, "SECONDS",  null, null, () ->"
        classBuilder.appendCommaSeparated(timeFrame, delay, startDate, startTime).appendComma();
        classBuilder.startParan().endParan().appendLambdaArrow();

        // Example gen "main.eventFunc21()"
        classBuilder.append(runnable).startParan().endParan();

        classBuilder.endParan().endParan().endLine();
    }

    // Delcares a LocalDate and returns the name of the declared variable
    public String addLocalDateDeclaration(String varName, LocalDate date){
        // Example gen "LocalDate varName = LocalDate.of("
        classBuilder.append("LocalDate ").append(varName).appendEquals().append("LocalDate.of").startParan();

        classBuilder.appendCommaSeparated(String.valueOf(date.getYear()),
                String.valueOf(date.getMonthValue()), String.valueOf(date.getDayOfMonth()));

        classBuilder.endParan().endLine();
        return varName;
    }

    // Delcares a LocalTime and returns the name of the declared variable
    public String addLocalTimeDeclaration(String varName, LocalTime time){
        classBuilder.append("LocalTime ").append(varName).appendEquals().append("LocalTime.of").startParan();

        classBuilder.appendCommaSeparated(String.valueOf(time.getHour()),
                String.valueOf(time.getMinute()), String.valueOf(time.getSecond()));

        classBuilder.endParan().endLine();
        return varName;
    }

}
