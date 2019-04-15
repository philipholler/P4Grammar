package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaFileWriter;
import codegen.JavaInputParameter;
import codegen.JavaType;
import exceptions.compilerside.CodeGenerationError;
import node.DeclsNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.base.Node;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.Device.InputNode;
import node.define_nodes.Device.OutputNode;
import node.define_nodes.Signal.DefSignalNode;
import node.define_nodes.Signal.EnumNode;
import node.define_nodes.Signal.RangeNode;
import semantics.SignalType;
import semantics.SymbolTable;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;


/**
 * Generates classes representing custom type definitions of devices and signals
 */
public class ClassGenerationVisitor extends ASTBaseVisitor<ClassBuilder> {

    public static final String RANGE_UPPER_BOUND_ID = "UPPER_BOUND";
    public static final String RANGE_LOWER_BOUND_ID = "LOWER_BOUND";

    public static final String CURRENT_VALUE_VAR = "currentValue";
    public static final String HARDWARE_ID_VAR = "hardwareID";

    public static final String INPUT_SIGNAL_PREFIX = "input";
    public static final String OUTPUT_SIGNAL_PREFIX = "output";


    ArrayList<ClassBuilder> classes = new ArrayList<>();

    /** Generates classes for signal declarations */
    @Override
    public ClassBuilder visit(DeclsNode node) {
        for (Node n : node.getChildren()) {
            ClassBuilder classBuilder = visit(n);
            if (classBuilder != null)
                JavaFileWriter.writeClass(classBuilder);
        }

        return null;
    }

    @Override
    public ClassBuilder visit(DefSignalNode signalNode) {
        // Todo : import statements
        if (signalNode.getSignalType() == SignalType.LITERALS)
            return generateLiteralSignal(signalNode);
        else
            return generateRangeSignal(signalNode);
    }

    private ClassBuilder generateRangeSignal(DefSignalNode signalNode) {
        JavaType rangeType;
        RangeNode rangeNode = signalNode.getRangeNode();
        String lowerBound, upperBound;

        if (rangeNode.getType().equals(SymbolTable.INT_TYPE_ID)) {
            rangeType = JavaType.INT;
            lowerBound = String.valueOf(((IntegerNode) rangeNode.getLowerBoundNode()).getVal());
            upperBound = String.valueOf(((IntegerNode) rangeNode.getUpperBoundNode()).getVal());
        } else {
            rangeType = JavaType.FLOAT;
            lowerBound = String.valueOf(((FloatNode) rangeNode.getLowerBoundNode()).getVal());
            upperBound = String.valueOf(((FloatNode) rangeNode.getUpperBoundNode()).getVal());
        }

        ClassBuilder classBuilder = new ClassBuilder();
        classBuilder.appendPackage(ClassBuilder.SIGNAL_PACKAGE);
        classBuilder.appendClassDef(signalNode.getID(), ClassBuilder.RANGE_SIGNAL_CLASS, rangeType.objectType);

        appendRangeConstants(classBuilder, rangeType, upperBound, lowerBound);
        // The default value variable of the range is set to the lower bound
        classBuilder.appendPrimitiveDecl(rangeType, CURRENT_VALUE_VAR, lowerBound).appendNewLine();

        addRangeGetters(classBuilder, rangeType);
        addCurrentValGetter(classBuilder, rangeType);

        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);

        return classBuilder;
    }

    private void addCurrentValGetter(ClassBuilder classBuilder, JavaType rangeType) {
        classBuilder.appendGetMethod(rangeType.objectType, CURRENT_VALUE_VAR).appendNewLine();
    }

    private void addRangeGetters(ClassBuilder classBuilder, JavaType rangeType) {
        classBuilder.appendGetMethod(rangeType.objectType, RANGE_UPPER_BOUND_ID);
        classBuilder.appendGetMethod(rangeType.objectType, RANGE_LOWER_BOUND_ID);
    }

    private void appendRangeConstants(ClassBuilder classBuilder, JavaType type, String lowerBound, String upperBound) {
        classBuilder.appendPrimitiveDecl(type, RANGE_LOWER_BOUND_ID, lowerBound);
        classBuilder.appendPrimitiveDecl(type, RANGE_UPPER_BOUND_ID, upperBound).appendNewLine();
    }

    private ClassBuilder generateLiteralSignal(DefSignalNode signalNode) {
        JavaType signalValueType = getSignalValueType(signalNode);

        ClassBuilder signalBuilder = new ClassBuilder();
        signalBuilder.appendPackage(ClassBuilder.SIGNAL_PACKAGE);

        signalBuilder.appendClassDef(signalNode.getID(), ClassBuilder.LITERAL_SIGNAL_CLASS, signalValueType.objectType);

        addEnumVars(signalBuilder, signalNode, signalValueType);
        addEnumVarGetters(signalBuilder, signalNode, signalValueType);

        signalBuilder.closeBlock(ClassBuilder.BlockType.CLASS);
        return signalBuilder;
    }

    private JavaType getSignalValueType(DefSignalNode signalNode) {
        switch (signalNode.getEnumNodes().get(0).getType()) {
            case SymbolTable.INT_TYPE_ID:
                return JavaType.INT;
            case SymbolTable.FLOAT_TYPE_ID:
                return JavaType.FLOAT;
            case SymbolTable.STRING_TYPE_ID:
                return JavaType.STRING;

            default:
                throw new CodeGenerationError("Signal values have invalid type : " + signalNode.getSignalType().name());
        }
    }

    private void addEnumVars(ClassBuilder classBuilder, DefSignalNode defSignalNode, JavaType type){
        for(EnumNode enumNode : defSignalNode.getEnumNodes()){
            String value;

            if(type == JavaType.STRING)
                value = ((StringNode) enumNode.getLiteralValue()).getVal();
            else if (type == JavaType.INT)
                value = String.valueOf(((IntegerNode) enumNode.getLiteralValue()).getVal());
            else
                value = String.valueOf(((FloatNode) enumNode.getLiteralValue()).getVal());

            classBuilder.appendPrimitiveDecl(type, enumNode.getID(), value);
        }

        classBuilder.appendNewLine();
    }

    private void addEnumVarGetters(ClassBuilder classBuilder, DefSignalNode defSignalNode, JavaType type){
        for(EnumNode enumNode : defSignalNode.getEnumNodes())
            classBuilder.appendGetMethod(type.objectType, enumNode.getID());
    }

    /** Generates classes for device declarations */
    @Override
    public ClassBuilder visit(DefDeviceNode node) {
        ClassBuilder classBuilder = new ClassBuilder();
        classBuilder.appendPackage(ClassBuilder.DEVICE_PACKAGE);
        // Todo : import statements

        classBuilder.appendClassDef(node.getID(), ClassBuilder.DEVICE_SUPER_CLASS);

        // Add variables
        addSignalVariables(classBuilder, node.getInputs(), node.getOutputs());
        classBuilder.appendPrimitiveDecl(JavaType.STRING, HARDWARE_ID_VAR).appendNewLine();

        // Add constructor and methods
        classBuilder.appendConstructor(new JavaInputParameter(JavaType.STRING.keyword, HARDWARE_ID_VAR));
        addSignalGetters(classBuilder, node.getInputs(), node.getOutputs());
        classBuilder.appendGetMethod(JavaType.STRING.keyword, HARDWARE_ID_VAR);

        return classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);
    }

    private void addSignalVariables(ClassBuilder classBuilder, ArrayList<InputNode> inputNodes, ArrayList<OutputNode> outputNodes){
        for(InputNode inNode : inputNodes)
            classBuilder.appendNewObjectDecl(inNode.SIGNAL_ID, INPUT_SIGNAL_PREFIX + inNode.SIGNAL_ID);

        for(OutputNode outNode : outputNodes)
            classBuilder.appendNewObjectDecl(outNode.SIGNAL_ID, OUTPUT_SIGNAL_PREFIX + outNode.SIGNAL_ID);
    }

    private void addSignalGetters(ClassBuilder classBuilder, ArrayList<InputNode> inputs, ArrayList<OutputNode> outputs) {
        for(InputNode inNode : inputs)
            classBuilder.appendGetMethod(inNode.SIGNAL_ID, INPUT_SIGNAL_PREFIX + inNode.SIGNAL_ID);

        for(OutputNode outNode : outputs)
            classBuilder.appendGetMethod(outNode.SIGNAL_ID, OUTPUT_SIGNAL_PREFIX + outNode.SIGNAL_ID);
    }

}
