package visitor.codegen;

import codegen.ClassBuilder;
import node.define_nodes.Signal.DefSignalNode;
import semantics.SignalType;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;


/**
 * Generates classes representing custom type definitions of devices and signals
 */
public class ClassGenerationVisitor extends ASTBaseVisitor<ClassBuilder> {

    ArrayList<ClassBuilder> classes = new ArrayList<>();

    @Override
    public ClassBuilder visit(DefSignalNode signalNode) {
        ClassBuilder signalBuilder = new ClassBuilder(ClassBuilder.SIGNAL_PACKAGE);


        return signalBuilder;
    }

    private ClassBuilder generateRangeSignal(){
        return null;
    }

    private ClassBuilder generateLiteralSignal(){
        return null;
    }


    private void extractLiteralValue(){

    }
}
