package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaFileWriter;
import codegen.JavaInputParameter;
import codegen.JavaType;
import default_classes.event.SignalEvent;
import default_classes.event.TimeEvent;
import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.ProgramNode;
import visitor.ASTBaseVisitor;

public class EventInitializationVisitor extends ASTBaseVisitor<Void> {

    ClassBuilder classBuilder;

    public static final String EVENT_INIT_CLASS_NAME = "EventInitializer";
    private static final String MAIN_REFERENCE_NAME = "main";
    private static final String ADD_EVENTS_METHOD = "fillEventLists";
    private static final String TIME_EVENT_LIST = "timeEvents";
    private static final String SIGNAL_EVENT_LIST = "signalEvents";

    @Override
    public Void visit(ProgramNode node) {
        classBuilder = new ClassBuilder();
        classBuilder.appendPackage(ClassBuilder.EVENT_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_SIGNAL_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_EVENT_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_DEVICE_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEVICE_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.SIGNAL_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.SERVER_PACKAGE);
        classBuilder.appendImport(ClassBuilder.ARRAYLIST_PACKAGE).appendNewLine();
        classBuilder.appendClassDef(EVENT_INIT_CLASS_NAME);

        addLocalVars();
        addConsructor();

        classBuilder.appendMethod(ADD_EVENTS_METHOD, JavaType.VOID.keyword);
        visitChildren(node);
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);
        JavaFileWriter.writeClass(classBuilder);

        return null;
    }

    private void addLocalVars(){
        classBuilder.appendObjectDecl(MainGenerationVisitor.MAIN_CLASS_NAME, MAIN_REFERENCE_NAME);

        classBuilder.appendNewObjectDecl("ArrayList<" + TimeEvent.class.getSimpleName() + ">", TIME_EVENT_LIST);
        classBuilder.appendNewObjectDecl("ArrayList<" + SignalEvent.class.getSimpleName() + ">", SIGNAL_EVENT_LIST);
    }

    private void addConsructor() {
        classBuilder.appendConstructor(new JavaInputParameter(MainGenerationVisitor.MAIN_CLASS_NAME
                , MAIN_REFERENCE_NAME));
        classBuilder.appendAssignment("this." + MAIN_REFERENCE_NAME, MAIN_REFERENCE_NAME);
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
    }

    @Override
    public Void visit(EventInputNode node) {

        return super.visit(node);
    }

    @Override
    public Void visit(EventRangeInputNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(EventWhenTimeNode node) {
        return super.visit(node);
    }

    @Override
    public Void visit(EventEveryNode node) {
        return super.visit(node);
    }
}
