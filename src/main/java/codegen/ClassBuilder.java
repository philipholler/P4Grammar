package codegen;

import exceptions.compilerside.MismatchedBracketException;
import semantics.FieldSymbol;

import java.util.Optional;
import java.util.Stack;

public class ClassBuilder {

    private IndentedStringBuilder codeBuilder = new IndentedStringBuilder();

    private String className = "";

    private Stack<BlockType> blocks = new Stack<BlockType>();

    private static final String START_BRACKET = "{", END_BRACKET = "}";
    private static final String TAB = "    ";
    private static final String COMMA = ",";


    public enum BlockType{
        CLASS, METHOD, WHILE, IF, ELSE, FOR;
    }

    public ClassBuilder addClassDefinition(final String className){
        this.className = className;
        return addClassDefinition(className, Optional.empty());
    }

    public ClassBuilder addClassDefinition(String className, String superClass){
        this.className = className;
        return addClassDefinition(className, Optional.of(superClass));
    }

    private ClassBuilder addClassDefinition(String className, Optional<String> superClass){
        codeBuilder.append("public class ").append(className).append(" ");

        // Add extends superclass to class definition if a superclass is given
        superClass.ifPresent(s -> codeBuilder.append("extends " + s).append(" "));

        openBlock(BlockType.CLASS);
        codeBuilder.newLine();
        return this;
    }

    private void openBlock(BlockType blockType){
        blocks.push(blockType);
        codeBuilder.append(START_BRACKET).newLine();
        codeBuilder.incrementIndentation();
    }


    public void closeBlock(BlockType blockType){
        BlockType lastOpenedBlock = blocks.pop();
        if (lastOpenedBlock != blockType)
            throw new MismatchedBracketException("Attempted to close a " + blockType.name() + " bracket but last " +
                    "opened bracket was a " + lastOpenedBlock + " bracket");


        codeBuilder.newLine();
        codeBuilder.decremmentIndentation();
        codeBuilder.append(END_BRACKET).newLine();
    }

    public ClassBuilder addMethod(String methodName, JavaType returnType, JavaInputParameter...inputs){
        codeBuilder.append("public ").append(returnType.keyword).append(" ").append(methodName);

        codeBuilder.append(" (");
        appendFormalParameters(inputs);
        codeBuilder.append(") ");

        openBlock(BlockType.METHOD);
        return this;
    }

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

    public String getClassCode(){
        if(!blocks.empty())
            throw new MismatchedBracketException("Not all brackets has been closed. Last opened bracket : "
                    + blocks.peek().name());

        return codeBuilder.toString();
    }



}
