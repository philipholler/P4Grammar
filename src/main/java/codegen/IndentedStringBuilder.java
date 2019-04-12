package codegen;

public class IndentedStringBuilder {

    private int indentation = 0;
    private static final String TAB = "    ";
    private static final String NEW_LINE = System.lineSeparator();


    private StringBuilder stringBuilder = new StringBuilder();

    public IndentedStringBuilder() {}

    public IndentedStringBuilder(int indentation) {
        this.indentation = indentation;
    }

    public IndentedStringBuilder append(String string){
        return this;
    }

    public IndentedStringBuilder newLine(){
        stringBuilder.append(newLine());
        return this;
    }


    public void incrementIndentation(){
        indentation++;
    }

    public void decremmentIndentation(){
        indentation--;
    }


    @Override
    public String toString(){
        return stringBuilder.toString();
    }


}
