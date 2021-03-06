package codegen;

import default_classes.Utils;
import exceptions.compilerside.CodeGenerationError;
import exceptions.compilerside.MismatchedBracketException;
import jdk.jshell.execution.Util;
import node.Statements.LogicalExpression.ComparisonOperator;
import node.TimeNodes.DateNode;
import node.TimeNodes.LocalTimeNode;
import node.TimeNodes.NowNode;
import node.TimeNodes.TimeNode;
import utils.TimeUtils;

import java.time.*;
import java.util.Stack;

public class ClassBuilder {

    private IndentedStringBuilder codeBuilder = new IndentedStringBuilder();

    /* --------------------- Syntax & naming constants --------------------- */
    public static final String RANGE_SIGNAL_CLASS = "RangeSignal";
    public static final String LITERAL_SIGNAL_CLASS = "Signal";
    public static final String GET_METHOD_PREFIX = "get";
    public static final String SET_METHOD_PREFIX = "set";

    public static final String DEVICE_SUPER_CLASS = "Device";

    public static final String DEFAULT_CLASSES_PACKAGE = "default_classes";
    public static final String DEFAULT_SIGNAL_PACKAGE = "default_classes.signal";
    public static final String DEFAULT_DEVICE_PACKAGE = "default_classes.device";
    public static final String DEFAULT_EVENT_PACKAGE = "default_classes.event";
    public static final String DEFAULT_SERVER_PACKAGE = "default_classes.server";

    public static final String DEVICE_PACKAGE = "device";
    public static final String SIGNAL_PACKAGE = "signal";
    public static final String SERVER_PACKAGE = "server";
    public static final String EVENT_PACKAGE  = "event";

    public static final String ARRAYLIST_PACKAGE  = "java.util.ArrayList";

    private static final String START_BRACKET = "{", END_BRACKET = "}";
    private static final String START_PARAN = "(", END_PARAN = ")";
    private static final String LINE_END = ";";

    private static final String TAB = "    ";
    private static final String COMMA = ",";
    private static final String DOT = ".";
    /* --------------------------------------------------------------------- */

    private String className = "";
    private String packageName = "";

    // Every time a new block is created its type (method block, function block etc.)
    // is pushed to the block stack. When a block type is closed it's asserted that it matches
    // the top element of the stack
    private Stack<BlockType> blocks = new Stack<BlockType>();

    private boolean hasClassDefinition = false;

    public String getPackage() {
        return packageName;
    }

    public ClassBuilder appendPublicKeyWord() {
        codeBuilder.append("public ");
        return this;
    }

    public ClassBuilder appendCommaSeparated(String...items) {
        for(int i = 0; i < items.length; i++){
            codeBuilder.append(items[i]);
            if(i != items.length - 1) appendComma();
        }
        return this;
    }

    public ClassBuilder appendFinal() {
        return this.append("final ");
    }

    public ClassBuilder appendSynchronized() {
        return this.append("synchronized ");
    }


    public enum BlockType{
        CLASS, METHOD, WHILE, IF, ELSE, FOR, TRY, CATCH, SYNCHRONIZED;
    }

    public ClassBuilder appendPackage(String packageString){
        codeBuilder.append("package ").append(packageString).append(LINE_END).newLine().newLine();
        this.packageName = packageString;
        return this;
    }

    public ClassBuilder appendImportAllFrom(String packge){
        codeBuilder.append("import ").append(packge).append(".*").append(LINE_END).newLine();
        return this;
    }

    public ClassBuilder appendImport(String packge){
        codeBuilder.append("import ").append(packge).append(LINE_END).newLine();
        return this;
    }

    /** Adds a standard public class definition to the builder */
    public ClassBuilder appendClassDef(String className){
        return appendClassDef(className, "", "");
    }

    /**
     * Adds a public class extending a given super class to the builder
     * @param superClass The name of the class that this class should extend
     */
    public ClassBuilder appendClassDef(String className, String superClass){
        return appendClassDef(className, superClass, "");
    }

    public ClassBuilder appendClassDef(String className, String superClass, String genericType){
        this.className = className;

        if(hasClassDefinition)
            throw new CodeGenerationError("Only one class definition is allowed per class generator. " +
                    "New class definitions should go in a separate file.");

        codeBuilder.append("public class ").append(className).append(" ");

        // Add extends superclass to class definition if a superclass is given
        if(!superClass.isEmpty())
            codeBuilder.append("extends " + superClass).append(" ");

        if(!genericType.isEmpty())
            codeBuilder.append("<" + genericType + "> ");

        openBlock(BlockType.CLASS);
        codeBuilder.newLine();

        hasClassDefinition = true;
        return this;
    }

    public void startSyncBlock(String varName) {
        appendSynchronized().startParan().append(varName).endParan();
        openBlock(BlockType.SYNCHRONIZED);
    }

    // Open a block by pushing the type to the block stack and appending a starting bracket
    public void openBlock(BlockType blockType){
        blocks.push(blockType);
        codeBuilder.append(START_BRACKET).newLine();
        codeBuilder.incrementIndentation();
    }

    /**
     * Closes a block by reducing the line indentation and adding an ending bracket
     * @param blockType The type of block that is expected to be closed
     */
    public ClassBuilder closeBlock(BlockType blockType){
        BlockType lastOpenedBlock = blocks.pop();

        // Throw exception if the attempting to close a type of bracket that is different from the last opened one
        if (lastOpenedBlock != blockType)
            throw new MismatchedBracketException("Attempted to close a " + blockType.name() + " bracket but last " +
                    "opened bracket was a " + lastOpenedBlock + " bracket");


        codeBuilder.decremmentIndentation();
        if(!codeBuilder.isLineEmpty()) codeBuilder.newLine();

        codeBuilder.append(END_BRACKET);
        if(blockType != BlockType.TRY) {
            codeBuilder.newLine();
        }
        return this;
    }


    public ClassBuilder appendConstructor(JavaInputParameter...inputParameters){
        if(className.isEmpty())
            throw new CodeGenerationError("Attempted to add constructor but ClassBuilder has no class definition");

        // Add constructor definition with input parameters
        codeBuilder.append("public ").append(className).append(START_PARAN);
        appendFormalParameters(inputParameters);
        codeBuilder.append(END_PARAN);

        // Build body of constructor
        openBlock(BlockType.METHOD);
        return this;
    }

    public ClassBuilder appendSuperConstructorCall(String...parameters){
        codeBuilder.append("super").append(START_PARAN);

        // Add all constructor inputs as actual parameters to super constructor
        appendActualParameters(parameters);
        codeBuilder.append(END_PARAN).append(LINE_END);
        return this;
    }

    public ClassBuilder appendMainMethod(){
        codeBuilder.newLine();
        codeBuilder.append("public static void main(String[] args)");
        openBlock(BlockType.METHOD);
        return this;
    }

    /**
     * Appends a new method definition to the class
     * Any subsequent appends will be added inside the method body
     * until the method body is closed using closeBlock
     * @param inputs Zero or more formal parameters
     */
    public ClassBuilder appendMethod(String methodName, String returnType, JavaInputParameter...inputs){
        codeBuilder.append("public ").append(returnType).append(" ").append(methodName);

        codeBuilder.append(" (");
        appendFormalParameters(inputs);
        codeBuilder.append(") ");

        openBlock(BlockType.METHOD);
        return this;
    }

    public ClassBuilder appendSyncrhonizedMethod(String methodName, String returnType, JavaInputParameter...inputs){
        codeBuilder.append("public ").append("synchronized ").append(returnType).append(" ").append(methodName);

        codeBuilder.append(" (");
        appendFormalParameters(inputs);
        codeBuilder.append(") ");

        openBlock(BlockType.METHOD);
        return this;
    }

    public ClassBuilder appendGetMethod(String type, String varName){
        codeBuilder.append("public ").append(type).append(" ").append("get").append(varName);
        codeBuilder.append(START_PARAN).append(END_PARAN);
        openBlock(BlockType.METHOD);
        appendReturnStatement(varName);
        closeBlock(BlockType.METHOD);
        return this;
    }

    // Appends comma-separated parameters with the form : "type paramID1, type paramID2"
    // with no comma after the last parameter
    private void appendFormalParameters(JavaInputParameter[] inputs) {
        // Add parameters to method definition
        for(int i = 0; i < inputs.length; i++){
            JavaInputParameter p = inputs[i];
            codeBuilder.append(p.TYPE).append(" ").append(p.identifier);

            // Add comma separator after every parameter, except for the last one
            if(i != inputs.length - 1)
                codeBuilder.append(COMMA).append(" ");
        }
    }

    public ClassBuilder appendReturnStatement(String val){
        codeBuilder.append("return ").append(val).append(LINE_END);
        return this;
    }

    public ClassBuilder appendTimeComparisonText(TimeNode timeNode, ComparisonOperator op, boolean flipOperator){
        String s = null;

        if(timeNode instanceof DateNode){
            DateNode n = (DateNode)timeNode;
            if(n.hasDate()){
                LocalDate t = n.getDate();
                s = "LocalDate.of(" + t.getYear() + ", " + t.getMonthValue() + ", " + t.getDayOfMonth() + ")";
            } else if(n.hasMonthDay()){
                MonthDay m = n.getMonthDay();
                s = "MonthDay.of(" + m.getMonthValue() + ", " + m.getDayOfMonth() + ")";
            } else if (n.hasday()){
                s = "" + n.getDay();
            }
        } else if(timeNode instanceof LocalTimeNode){
            LocalTime t = ((LocalTimeNode) timeNode).getTime();
            s = "LocalTime.of(" + t.getHour() + ", " + t.getMinute() + ")";
        }


        codeBuilder.append("Utils.isComparisonTrue(LocalDateTime.now(), ComparisonOperator." + op.name() + ", " + s + ", "+ flipOperator + ")");
        return this;
    }

    public ClassBuilder appendTimeComparison(NowNode nowNode, TimeNode timeNode, ComparisonOperator op){
        return appendTimeComparisonText(timeNode, op, false);
    }


    public ClassBuilder appendTimeComparison(TimeNode timeNode, NowNode nowNode, ComparisonOperator op){
        return appendTimeComparisonText(timeNode, op, true);
    }

    // Asserts that a statement is not placed outside a method body
    private void checkStatementPlacement(){
        if(blocks.empty() || blocks.peek() == BlockType.CLASS)
            throw new CodeGenerationError("Statements cannot be placed outside a method body");
    }

    /**
     * Adds a method call. Must be inside a method body.
     * @param inputParams text to write as input parameters, can be literal values as well as variable IDs
     */
    public ClassBuilder appendMethodCall(String methodName, String...inputParams){
        checkStatementPlacement();

        codeBuilder.append(methodName).append(" ").append(START_PARAN);
        appendActualParameters(inputParams);
        codeBuilder.append(END_PARAN).append(LINE_END).newLine();

        return this;
    }

    public ClassBuilder appendThrow(String exceptionName){
        codeBuilder.append("throw new ").append(exceptionName)
                .append(START_PARAN).append(END_PARAN).append(LINE_END).newLine();

        return this;

    }

    public ClassBuilder appendTryStatement (){
        codeBuilder.append("try");
        openBlock(BlockType.TRY);
        return this;
    }

    public ClassBuilder appendCatch (String execptionType, String exceptionName){
        codeBuilder.append("catch").append(" ").append(START_PARAN).append(" ")
                .append(execptionType).append(" ").append(exceptionName)
                .append(END_PARAN);

        openBlock(BlockType.CATCH);
        return this;
    }

    // Appends comma-separated actual parameters with the form : "paramID1, paramID2" and so on
    // with no comma after the last parameter
    private void appendActualParameters(String...inputs) {
        // Add parameters to method definition
        for(int i = 0; i < inputs.length; i++){
            String id = inputs[i];
            codeBuilder.append(id);

            // Add comma separator after every parameter, except for the last one
            if(i != inputs.length - 1)
                codeBuilder.append(COMMA).append(" ");
        }
    }


    public ClassBuilder appendPrimitiveDecl(JavaType type, String id){
        appendPrimitiveDecl(type, id, "");
        return this;
    }

    public ClassBuilder appendPrimitiveDecl(JavaType type, String id, String value){
        codeBuilder.append(type.keyword).append(" ").append(id);

        if(!value.isEmpty())
            codeBuilder.append(" = ").append(value);

        codeBuilder.append(LINE_END).newLine();
        return this;
    }

    public ClassBuilder startParan(){
        codeBuilder.append(START_PARAN);
        return this;
    }

    public ClassBuilder endParan(){
        codeBuilder.append(END_PARAN);
        return this;
    }

    public ClassBuilder append(String string){
        codeBuilder.append(string);
        return this;
    }

    public ClassBuilder appendWord(String string){
        codeBuilder.append(string).append(" ");
        return this;
    }

    public ClassBuilder appendOperator(String op){
        codeBuilder.append(" ").append(op).append(" ");
        return this;
    }

    public ClassBuilder appendEquals(){
        codeBuilder.append(" = ");
        return this;
    }

    public ClassBuilder appendComma() {
        codeBuilder.append(COMMA);
        return this;
    }

    public ClassBuilder appendSpace(){
        codeBuilder.append(" ");
        return this;
    }


    public ClassBuilder endLine(){
        codeBuilder.append(LINE_END).newLine();
        return this;
    }

    public ClassBuilder appendDot(){
        codeBuilder.append(DOT);
        return this;
    }

    /**
     * Appends a new object declaration with instantiation
     * @param type The type of the object
     * @param id The name of the object
     * @param constructorInputs The inputs given to the constructor
     */
    public ClassBuilder appendNewObjectDecl(String type, String id, String...constructorInputs){
        codeBuilder.append(type).append(" ").append(id);

        codeBuilder.append(" = new " + type + START_PARAN);
        appendActualParameters(constructorInputs);
        codeBuilder.append(END_PARAN).append(LINE_END).newLine().newLine();

        return this;
    }

    public ClassBuilder appendObjectDecl(String type, String id){
        codeBuilder.append(type).append(" ").append(id).append(LINE_END).newLine();

        return this;
    }

    public ClassBuilder appendAssignment(String varID, String value){
        codeBuilder.append(varID).append(" = ").append(value).append(LINE_END).newLine();
        return this;
    }

    public ClassBuilder appendNewLine(){
        codeBuilder.newLine();
        return this;
    }

    public ClassBuilder appendLambdaArrow(){
        codeBuilder.append(" -> ");
        return this;
    }


    public String getClassName() {
        return className;
    }

    /**
     * Requires all brackets within the class to be closed before returning the generated code.
     * @return a string containing all code generated in this class generator
     */
    @Override
    public String toString(){
        if(!blocks.empty())
            throw new MismatchedBracketException("Not all brackets has been closed. Last opened bracket : "
                    + blocks.peek().name());

        return codeBuilder.toString();
    }
}
