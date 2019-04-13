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
        return this;
    }

    public void openBlock(BlockType blockType){
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

    public void addMethod(String methodName, FieldSymbol...inputs){

    }

    public String getClassCode(){
        if(!blocks.empty())
            throw new MismatchedBracketException("Not all brackets has been closed. Last opened bracket : "
                    + blocks.peek().name());

        return codeBuilder.toString();
    }



}
