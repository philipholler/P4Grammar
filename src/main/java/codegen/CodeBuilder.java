package codegen;

import exceptions.compilerside.MismatchedBracketException;
import semantics.FieldSymbol;

import java.util.Stack;

public class CodeBuilder {

    private IndentedStringBuilder codeBuilder = new IndentedStringBuilder();

    private int indentation = 0;
    private Stack<BlockType> blocks = new Stack<BlockType>();

    private static final String START_BRACKET = "{", END_BRACKET = "}";
    private static final String TAB = "    ";

    private enum BlockType{
        CLASS, METHOD, WHILE, IF, ELSE, FOR;
    }

    public CodeBuilder generateClass(String className){
        return this;
    }

    public CodeBuilder generateClass(String className, String superClass){
        return this;
    }


    public void OpenBlock(BlockType blockType){
        blocks.push(blockType);
    }


    public void closeBlock(BlockType blockType){
        BlockType lastOpenedBlock = blocks.pop();
        if (lastOpenedBlock != blockType)
            throw new MismatchedBracketException("Attempted to close a " + blockType.name() + " bracket but last " +
                    "opened bracket was a " + lastOpenedBlock + " bracket");
        else{
            //codeBuilder.appendLine("}\n");
        }
    }


    public CodeBuilder(String className, String superClass) {
        codeBuilder.append("public class ").append(className).append( "extends ").append(START_BRACKET);
    }

    public void addMethod(String methodName, FieldSymbol...inputs){

    }

    public String getClassCode(){
        return codeBuilder.append("}").toString();
    }



}
