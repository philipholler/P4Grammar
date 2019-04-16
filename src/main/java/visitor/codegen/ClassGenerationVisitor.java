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

    public static final String RANGE_UPPER_BOUND_VAR = "UPPER_BOUND";
    public static final String RANGE_LOWER_BOUND_VAR = "LOWER_BOUND";
    public static final String DEFAULT_VALUE_VAR = "defaultValue";


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
        String defaultValue = "";

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
        classBuilder.appendImportAllFrom(ClassBuilder.SIGNAL_PACKAGE).appendNewLine();
        classBuilder.appendClassDef(signalNode.getID(), ClassBuilder.RANGE_SIGNAL_CLASS, rangeType.objectType);

        // Create constructor calling the super constructor of RangeSignal
        classBuilder.appendConstructor();
        classBuilder.appendSuperConstructorCall(lowerBound, upperBound, defaultValue);
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);
        return classBuilder;
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
        classBuilder.appendImportAllFrom(ClassBuilder.SIGNAL_PACKAGE).appendNewLine();
        // Todo : import statements

        classBuilder.appendClassDef(node.getID(), ClassBuilder.DEVICE_SUPER_CLASS);

        // Add variables for signals
        addSignalVariables(classBuilder, node.getInputs(), node.getOutputs());

        // Add constructor calling super constructor with the hardwareID from the constructor parameter
        classBuilder.appendConstructor(new JavaInputParameter(JavaType.STRING.keyword, HARDWARE_ID_VAR));
        classBuilder.appendSuperConstructorCall(HARDWARE_ID_VAR);
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        addSignalGetters(classBuilder, node.getInputs(), node.getOutputs());

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

