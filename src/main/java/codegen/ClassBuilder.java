package codegen;

import exceptions.compilerside.CodeGenerationError;
import exceptions.compilerside.MismatchedBracketException;
import semantics.FieldSymbol;

import java.util.Optional;
import java.util.Stack;

public class ClassBuilder {

    private IndentedStringBuilder codeBuilder = new IndentedStringBuilder();

    private String className = "";

    private Stack<BlockType> blocks = new Stack<BlockType>();

    private static final String START_BRACKET = "{", END_BRACKET = "}";
    private static final String START_PARAN = "(", END_PARAN = ")";
    private static final String LINE_END = ";";


    private static final String TAB = "    ";
    private static final String COMMA = ",";

    private boolean hasClassDefinition = false;

    public enum BlockType{
        CLASS, METHOD, WHILE, IF, ELSE, FOR;
    }


    /** Adds a standard public class definition to the builder */
    public ClassBuilder addClassDefinition(final String className){
        this.className = className;
        return addClassDefinition(className, Optional.empty());
    }

    /**
     * Adds a public class extending a given super class to the builder
     * @param superClass The name of the class that this class should extend
     */
    public ClassBuilder addClassDefinition(String className, String superClass){
        this.className = className;
        return addClassDefinition(className, Optional.of(superClass));
    }

    private ClassBuilder addClassDefinition(String className, Optional<String> superClass){
        if(hasClassDefinition)
            throw new CodeGenerationError("Only one class definition is allowed per class generator. " +
                    "New class definitions should go in a separate file.");

        codeBuilder.append("public class ").append(className).append(" ");

        // Add extends superclass to class definition if a superclass is given
        superClass.ifPresent(s -> codeBuilder.append("extends " + s).append(" "));

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
        codeBuilder.append(END_BRACKET).newLine();
    }

    /**
     * Appends a new method definition to the class
     * Any subsequent appends will be added inside the method body
     * until the method body is closed using closeBlock
     * @param inputs Zero or more formal parameters
     */
    public ClassBuilder appendMethod(String methodName, JavaType returnType, JavaInputParameter...inputs){
        codeBuilder.append("public ").append(returnType.keyword).append(" ").append(methodName);

        codeBuilder.append(" (");
        appendFormalParameters(inputs);
        codeBuilder.append(") ");

        openBlock(BlockType.METHOD);
        return this;
    }

    // Appends comma-separated parameters with the form : "type paramID1, type paramID2"
    // with no comma after the last parameter
    private void appendFormalParameters(JavaInputParameter[] inputs) {
        // Add parameters to method definition
        for(int i = 0; i < inputs.length; i++){
            JavaInputParameter p = inputs[i];
            codeBuilder.append(p.TYPE.keyword).append(" ").append(p.identifier);

            // Add comma separator after every parameter, except for the last one
            if(i != inputs.length - 1)
                codeBuilder.append(COMMA).append(" ");
        }
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


    public ClassBuilder appendVarDecl(JavaType type, String id){
        appendVarDecl(type, id, "");
        return this;
    }

    public ClassBuilder appendVarDecl(JavaType type, String id, String value){
        codeBuilder.append(type.keyword).append(" ").append(id);

        if(!value.isEmpty())
            codeBuilder.append(" = ").append(value);

        codeBuilder.append(LINE_END).newLine();
        return this;
    }


    public ClassBuilder appendAssignment(String varID, String value){
        codeBuilder.append(varID).append(" = ").append(value).append(LINE_END).newLine();
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
