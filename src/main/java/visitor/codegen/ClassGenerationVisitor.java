package visitor.codegen;

import codegen.CodeBuilder;
import codegen.JavaFileWriter;
import codegen.JavaType;
import exceptions.compilerside.CodeGenerationError;
import node.DeclsNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.base.Node;
import node.define_nodes.Device.DefDeviceNode;
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
public class ClassGenerationVisitor extends ASTBaseVisitor<CodeBuilder> {

    public static final String RANGE_UPPER_BOUND_ID = "UPPER_BOUND";
    public static final String RANGE_LOWER_BOUND_ID = "LOWER_BOUND";
    public static final String CURRENT_VALUE_ID = "currentValue";

    public static final String INPUT_SIGNAL_PREFIX = "input";
    public static final String OUTPUT_SIGNAL_PREFIX = "output";


    ArrayList<CodeBuilder> classes = new ArrayList<>();

    /** Generates classes for signal declarations */
    @Override
    public CodeBuilder visit(DeclsNode node) {
        for (Node n : node.getChildren()) {
            CodeBuilder codeBuilder = visit(n);
            if (codeBuilder != null)
                JavaFileWriter.writeClass(codeBuilder);
        }

        return null;
    }

    @Override
    public CodeBuilder visit(DefSignalNode signalNode) {
        // Todo : import statements
        if (signalNode.getSignalType() == SignalType.LITERALS)
            return generateLiteralSignal(signalNode);
        else
            return generateRangeSignal(signalNode);
    }

    private CodeBuilder generateRangeSignal(DefSignalNode signalNode) {
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

        CodeBuilder codeBuilder = new CodeBuilder();
        codeBuilder.appendPackage(CodeBuilder.SIGNAL_PACKAGE);
        codeBuilder.appendClassDef(signalNode.getID(), CodeBuilder.RANGE_SIGNAL_CLASS, rangeType.objectType);

        appendRangeConstants(codeBuilder, rangeType, upperBound, lowerBound);
        // The default value variable of the range is set to the lower bound
        codeBuilder.appendPrimitiveDecl(rangeType, CURRENT_VALUE_ID, lowerBound).appendNewLine();

        addRangeGetters(codeBuilder, rangeType);
        addCurrentValGetter(codeBuilder, rangeType);

        codeBuilder.closeBlock(CodeBuilder.BlockType.CLASS);

        return codeBuilder;
    }

    private void addCurrentValGetter(CodeBuilder codeBuilder, JavaType rangeType) {
        codeBuilder.appendGetMethod(rangeType.objectType, CURRENT_VALUE_ID).appendNewLine();
    }

    private void addRangeGetters(CodeBuilder codeBuilder, JavaType rangeType) {
        codeBuilder.appendGetMethod(rangeType.objectType, RANGE_UPPER_BOUND_ID);
        codeBuilder.appendGetMethod(rangeType.objectType, RANGE_LOWER_BOUND_ID);
    }

    private void appendRangeConstants(CodeBuilder codeBuilder, JavaType type, String lowerBound, String upperBound) {
        codeBuilder.appendPrimitiveDecl(type, RANGE_LOWER_BOUND_ID, lowerBound);
        codeBuilder.appendPrimitiveDecl(type, RANGE_UPPER_BOUND_ID, upperBound).appendNewLine();
    }

    private CodeBuilder generateLiteralSignal(DefSignalNode signalNode) {
        JavaType signalValueType = getSignalValueType(signalNode);

        CodeBuilder signalBuilder = new CodeBuilder();
        signalBuilder.appendPackage(CodeBuilder.SIGNAL_PACKAGE);

        signalBuilder.appendClassDef(signalNode.getID(), CodeBuilder.LITERAL_SIGNAL_CLASS, signalValueType.objectType);

        addEnumVars(signalBuilder, signalNode, signalValueType);
        addEnumVarGetters(signalBuilder, signalNode, signalValueType);

        signalBuilder.closeBlock(CodeBuilder.BlockType.CLASS);
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

    private void addEnumVars(CodeBuilder codeBuilder, DefSignalNode defSignalNode, JavaType type){
        for(EnumNode enumNode : defSignalNode.getEnumNodes()){
            String value;

            if(type == JavaType.STRING)
                value = ((StringNode) enumNode.getLiteralValue()).getVal();
            else if (type == JavaType.INT)
                value = String.valueOf(((IntegerNode) enumNode.getLiteralValue()).getVal());
            else
                value = String.valueOf(((FloatNode) enumNode.getLiteralValue()).getVal());

            codeBuilder.appendPrimitiveDecl(type, enumNode.getID(), value);
        }

        codeBuilder.appendNewLine();
    }

    private void addEnumVarGetters(CodeBuilder codeBuilder, DefSignalNode defSignalNode, JavaType type){
        for(EnumNode enumNode : defSignalNode.getEnumNodes()){
            codeBuilder.appendGetMethod(type.objectType, enumNode.getID());
        }
    }

    /** Generates classes for device declarations */
    @Override
    public CodeBuilder visit(DefDeviceNode node) {
        CodeBuilder codeBuilder = new CodeBuilder();
        codeBuilder.appendPackage(CodeBuilder.DEVICE_PACKAGE);
        // Todo : import statements

        codeBuilder.appendClassDef(node.getID(), CodeBuilder.DEVICE_SUPER_CLASS);

        //for(Node n : node.getInputs())
       //     codeBuilder.append(visit(n).toString());




        return null;
    }




}
