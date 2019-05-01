package visitor.codegen;

import codegen.ClassBuilder;
import codegen.JavaFileWriter;
import codegen.JavaInputParameter;
import codegen.JavaType;
import compiler.Compiler;
import default_classes.signal.Signal;
import exceptions.compilerside.CodeGenerationError;
import node.DeclsNode;
import node.ProgramNode;
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
import org.apache.commons.io.FileUtils;
import semantics.SignalType;
import semantics.SymbolTable;
import visitor.ASTBaseVisitor;

import java.io.File;
import java.io.IOException;
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

    public static final String GET_SIGNAL_METHOD = "getSignal";

    public static final String INPUT_SIGNAL_PREFIX = "input";
    public static final String OUTPUT_SIGNAL_PREFIX = "output";
    public static final String SET_CURRENT_VALUE_METHOD = "setCurrentValue";


    ArrayList<ClassBuilder> classes = new ArrayList<>();

    public static String getDefaultSignalValue(JavaType type){
        if(type == JavaType.FLOAT) return "0.0f";
        if(type == JavaType.INT) return "0";
        else return "\"null\"";
    }

    @Override
    public ClassBuilder visit(ProgramNode node) {

        // Create all the default classes.
        String sourceLocation = System.getProperty("user.dir");
        File sourceFile = new File(sourceLocation + Compiler.DEFAULT_CLASSES_DIR);
        File targetFile = new File(sourceLocation + File.separator + Compiler.GENERATED_FILES_DIR +  "/default_classes/");


        try {
            FileUtils.copyDirectory(sourceFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.visit(node);
    }

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
            lowerBound = (((FloatNode) rangeNode.getLowerBoundNode()).getVal()) + "f";
            upperBound = (((FloatNode) rangeNode.getUpperBoundNode()).getVal()) + "f";
        }

        ClassBuilder classBuilder = new ClassBuilder();
        classBuilder.appendPackage(ClassBuilder.SIGNAL_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_SIGNAL_PACKAGE);
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_DEVICE_PACKAGE).appendNewLine();
        classBuilder.appendClassDef(signalNode.getID(), ClassBuilder.RANGE_SIGNAL_CLASS, rangeType.objectType);

        // Create constructor calling the super constructor of RangeSignal
        classBuilder.appendConstructor();
        classBuilder.appendSuperConstructorCall(lowerBound, upperBound, lowerBound);
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        // Creates the setCurrentValue(String val) method
        createSetCurrentSignalMetod(classBuilder, rangeType);

        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);
        return classBuilder;
    }

    private void createSetCurrentSignalMetod(ClassBuilder classBuilder, JavaType type){
        // Creates the setCurrentValue(String val) method
        classBuilder.appendMethod(SET_CURRENT_VALUE_METHOD, JavaType.VOID.keyword,
                new JavaInputParameter(JavaType.STRING.keyword, "value"));
        classBuilder.append(SET_CURRENT_VALUE_METHOD).startParan();

        if(type == JavaType.STRING){
            // No need to convert value if the signal type is string
            classBuilder.append("value");
        }else{
            // Convert value to correct type using Integer.valueOf() og Float.valueOf()
            classBuilder.append(type.objectType).appendDot()
                    .append("valueOf").startParan().append("value").endParan();
        }

        classBuilder.endParan().endLine().closeBlock(ClassBuilder.BlockType.METHOD);
    }

    private ClassBuilder generateLiteralSignal(DefSignalNode signalNode) {
        JavaType signalValueType = getSignalValueType(signalNode);

        ClassBuilder signalBuilder = new ClassBuilder();
        signalBuilder.appendPackage(ClassBuilder.SIGNAL_PACKAGE);
        signalBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_SIGNAL_PACKAGE).appendNewLine();

        signalBuilder.appendClassDef(signalNode.getID(), ClassBuilder.LITERAL_SIGNAL_CLASS, signalValueType.objectType);
        signalBuilder.appendConstructor();
        signalBuilder.appendMethodCall(SET_CURRENT_VALUE_METHOD, getDefaultSignalValue(signalValueType));
        signalBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        addEnumVars(signalBuilder, signalNode, signalValueType);
        createSetCurrentSignalMetod(signalBuilder, signalValueType);
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
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_DEVICE_PACKAGE).appendNewLine();
        classBuilder.appendImportAllFrom(ClassBuilder.DEFAULT_SIGNAL_PACKAGE).appendNewLine();
        // Todo : import statements

        classBuilder.appendClassDef(node.getID(), ClassBuilder.DEVICE_SUPER_CLASS);

        // Add variables for signals
        addSignalVariables(classBuilder, node.getInputs(), node.getOutputs());

        // Add constructor calling super constructor with the hardwareID from the constructor parameter
        classBuilder.appendConstructor(new JavaInputParameter(JavaType.STRING.keyword, HARDWARE_ID_VAR));
        classBuilder.appendSuperConstructorCall(HARDWARE_ID_VAR);
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);

        addSignalGetters(classBuilder, node.getInputs(), node.getOutputs());
        addSignalStringGetter(classBuilder, node);

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

    // Adds the getSignal(String hardwareID)
    private void addSignalStringGetter(ClassBuilder classBuilder,
                                       DefDeviceNode node){
        String inputString = "id";

        classBuilder.appendMethod(GET_SIGNAL_METHOD, Signal.class.getSimpleName(),
                new JavaInputParameter(JavaType.STRING.keyword, inputString));

        for(String signalID : getAllSignalVarIDs(node)){
            String quotedID = '"' + signalID + '"';
            classBuilder.append("if").startParan().append(inputString).append(".equals").startParan()
                    .append(quotedID).endParan().endParan()
                    .openBlock(ClassBuilder.BlockType.IF);

            classBuilder.appendReturnStatement(signalID);
            classBuilder.closeBlock(ClassBuilder.BlockType.IF);;
        }

        classBuilder.appendReturnStatement("null");
        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);
    }

    private ArrayList<String> getAllSignalVarIDs(DefDeviceNode node){
        ArrayList<String> allSignals = new ArrayList<>();

        for(InputNode inNode : node.getInputs())
            allSignals.add(INPUT_SIGNAL_PREFIX + inNode.SIGNAL_ID);

        for(OutputNode outNode : node.getOutputs())
            allSignals.add(OUTPUT_SIGNAL_PREFIX + outNode.SIGNAL_ID);

        return allSignals;
    }
}

