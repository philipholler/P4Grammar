package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaType;
import node.DeclsNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.base.Node;
import node.define_nodes.Signal.DefSignalNode;
import node.define_nodes.Signal.RangeNode;
import semantics.SignalType;
import semantics.SymbolTable;
import utils.JavaCodeUtils;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;


/**
 * Generates classes representing custom type definitions of devices and signals
 */
public class ClassGenerationVisitor extends ASTBaseVisitor<ClassBuilder> {

    public static final String RANGE_UPPER_BOUND_ID = "UPPER_BOUND";
    public static final String RANGE_LOWER_BOUND_ID = "LOWER_BOUND";
    public static final String CURRENT_VALUE_ID = "currentValue";

    ArrayList<ClassBuilder> classes = new ArrayList<>();

    @Override
    public ClassBuilder visit(DeclsNode node) {
        for(Node n : node.getChildren()){
            ClassBuilder classBuilder = visit(n);
            if(classBuilder != null)
                System.out.println(classBuilder.getClassCode());
        }

        return null;
    }

    @Override
    public ClassBuilder visit(DefSignalNode signalNode) {
        if(signalNode.getSignalType() == SignalType.LITERALS)
            return generateLiteralSignal(signalNode);
        else
            return generateRangeSignal(signalNode);
    }

    private ClassBuilder generateRangeSignal(DefSignalNode signalNode){
        JavaType rangeType;
        RangeNode rangeNode = signalNode.getRangeNode();
        String lowerBound, upperBound;

        if(rangeNode.getType().equals(SymbolTable.INT_TYPE_ID)){
            rangeType = JavaType.INT;
            lowerBound = String.valueOf(((IntegerNode) rangeNode.getLowerBoundNode()).getVal());
            upperBound = String.valueOf(((IntegerNode) rangeNode.getLowerBoundNode()).getVal());
        }else{
            rangeType = JavaType.FLOAT;
            lowerBound = String.valueOf(((FloatNode) rangeNode.getLowerBoundNode()).getVal());
            upperBound = String.valueOf(((FloatNode) rangeNode.getLowerBoundNode()).getVal());
        }

        ClassBuilder classBuilder = new ClassBuilder(ClassBuilder.SIGNAL_PACKAGE);
        classBuilder.appendClassDef(signalNode.getID(), ClassBuilder.RANGE_SIGNAL_CLASS, rangeType.objectType);

        appendRangeConstants(classBuilder, rangeType, upperBound, lowerBound);
        // The default value variable of the range is set to the lower bound
        classBuilder.appendPrimitiveDecl(rangeType, CURRENT_VALUE_ID, lowerBound).appendNewLine();

        addRangeGetters(classBuilder, rangeType);
        addCurrentValGetter(classBuilder, rangeType);

        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);

        return classBuilder;
    }

    private void addCurrentValGetter(ClassBuilder classBuilder, JavaType rangeType) {
        classBuilder.appendGetMethod(rangeType.objectType, CURRENT_VALUE_ID).appendNewLine();
    }

    private void addRangeGetters(ClassBuilder classBuilder, JavaType rangeType) {
        classBuilder.appendGetMethod(rangeType.objectType, RANGE_UPPER_BOUND_ID);
        classBuilder.appendGetMethod(rangeType.objectType, RANGE_LOWER_BOUND_ID);
    }

    private void appendRangeConstants(ClassBuilder classBuilder, JavaType type, String lowerBound, String upperBound){
        classBuilder.appendPrimitiveDecl(type, RANGE_LOWER_BOUND_ID, lowerBound);
        classBuilder.appendPrimitiveDecl(type, RANGE_UPPER_BOUND_ID, upperBound).appendNewLine();
    }


    private ClassBuilder generateLiteralSignal(DefSignalNode signalNode){
        return null;
    }


    private void extractLiteralValue(){

    }
}
