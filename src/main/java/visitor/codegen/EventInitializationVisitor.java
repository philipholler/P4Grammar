package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaInputParameter;
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

    @Override
    public Void visit(ProgramNode node) {
        classBuilder.appendPackage(ClassBuilder.EVENT_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_CLASSES_PACKAGE);
        classBuilder.appendClassDef(EVENT_INIT_CLASS_NAME);
        addMainReference();
        addConsructor();
        return visitChildren(node);
    }

    private void addMainReference(){
        classBuilder.appendObjectDecl(MainGenerationVisitor.MAIN_CLASS_NAME, MAIN_REFERENCE_NAME);
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
