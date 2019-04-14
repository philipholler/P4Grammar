package codegen;

import exceptions.compilerside.CodeGenerationError;
import exceptions.compilerside.MismatchedBracketException;

import java.lang.reflect.Method;
import java.util.Stack;

public class ClassBuilder {

    private IndentedStringBuilder codeBuilder = new IndentedStringBuilder();

    public static final String RANGE_SIGNAL_CLASS = "Signal";
    public static final String LITERAL_SIGNAL_CLASS = "Signal";

    public static final String DEVICE_SUPER_CLASS = "Device";

    public static final String DEVICE_PACKAGE = "device";
    public static final String SIGNAL_PACKAGE = "signal";

    private String className = "";
    private String packageName = "";

    private Stack<BlockType> blocks = new Stack<BlockType>();

    private static final String START_BRACKET = "{", END_BRACKET = "}";
    private static final String START_PARAN = "(", END_PARAN = ")";
    private static final String LINE_END = ";";

    private static final String TAB = "    ";
    private static final String COMMA = ",";

    private boolean hasClassDefinition = false;

    public String getPackage() {
        return packageName;
    }

    public enum BlockType{
        CLASS, METHOD, WHILE, IF, ELSE, FOR;
    }


    public ClassBuilder(String packageString) {
        codeBuilder.append("package ").append(packageString).append(LINE_END).newLine().newLine();
        this.packageName = packageString;
    }

    /** Adds a standard public class definition to the builder */
    public ClassBuilder appendClassDef(final String className){
        this.className = className;
        return appendClassDef(className, "", "");
    }

    /**
     * Adds a public class extending a given super class to the builder
     * @param superClass The name of the class that this class should extend
     */
    public ClassBuilder appendClassDef(String className, String superClass){
        this.className = className;
        return appendClassDef(className, superClass, "");
    }

    public ClassBuilder appendClassDef(String className, String superClass, String genericType){
        if(hasClassDefinition)
            throw new CodeGenerationError("Only one class definition is allowed per class generator. " +
                    "New class definitions should go in a separate file.");

        codeBuilder.append("public class ").append(className).append(" ");

        // Add extends superclass to class definition if a superclass is given
        if(!superClass.isEmpty())
            codeBuilder.append("extends " + superClass).append(" ");

        if(!genericType.isEmpty())
            codeBuilder.append(" <" + genericType + "> ");

        openBlock(BlockType.CLASS);
        codeBuilder.newLine();

        hasClassDefinition = true;
        return this;
    }


    // Open a block by pushing the type to the block stack and appending a starting bracket
    private void openBlock(BlockType blockType){
        blocks.push(blockType);
        codeBuilder.append(START_BRACKET).newLine();
        codeBuilder.incrementIndentation();
    }

    /**
     * Closes a block by reducing the line indentation and adding an ending bracket
     * @param blockType The type of block that is expected to be closed
     */
    public void closeBlock(BlockType blockType){
        BlockType lastOpenedBlock = blocks.pop();

        // Throw exception if the attempting to close a type of bracket that is different from the last opened one
        if (lastOpenedBlock != blockType)
            throw new MismatchedBracketException("Attempted to close a " + blockType.name() + " bracket but last " +
                    "opened bracket was a " + lastOpenedBlock + " bracket");

        codeBuilder.newLine();
        codeBuilder.decremmentIndentation();
        codeBuilder.append(END_BRACKET).newLine().newLine();
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

    // Appends comma-separated actual parameters with the form : "type paramID1, type paramID2"
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

    public ClassBuilder appendObjectDecl(String type, String id, String...constructorInputs){
        codeBuilder.append(type).append(" ").append(id);

        codeBuilder.append(" = new " + type + START_PARAN);
        appendActualParameters(constructorInputs);
        codeBuilder.append(END_PARAN).append(LINE_END).newLine();

        codeBuilder.append(LINE_END).newLine();
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





    public String getClassName() {
        return className;
    }

    /**
     * Requires all brackets within the class to be closed before returning the generated code.
     * @return a string containing all code generated in this class generator
     */
    public String getClassCode(){
        if(!blocks.empty())
            throw new MismatchedBracketException("Not all brackets has been closed. Last opened bracket : "
                    + blocks.peek().name());

        if(!hasClassDefinition)
            throw new CodeGenerationError("Generated class code does not contain a class definition");

        return codeBuilder.toString();
    }




}
