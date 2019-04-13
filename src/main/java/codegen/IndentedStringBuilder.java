package codegen;

public class IndentedStringBuilder {

    private int indentation = 0; // Amount of 'tabs' to displace lines by

    public static final String TAB = "    "; // Uses 4 spaces instead of \t
    public static final String NEW_LINE = System.lineSeparator();

    private StringBuilder stringBuilder = new StringBuilder();

    private boolean freshLine = true;

    public IndentedStringBuilder() {}

    public IndentedStringBuilder(int indentation) {
        this.indentation = indentation;
    }


    public IndentedStringBuilder append(String string){
        if(freshLine) indentCurrentLine();

        if(string.contains(NEW_LINE))
            string = indentLines(string);

        stringBuilder.append(string);
        return this;
    }

    private String indentLines(String string) {
        String indentation = getIndentedString();
        return string.replaceAll(NEW_LINE, NEW_LINE + indentation);
    }

    private String getIndentedString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < indentation; i++)
            sb.append(TAB);

        return sb.toString();
    }

    public IndentedStringBuilder newLine(){
        stringBuilder.append(NEW_LINE);
        freshLine = true;
        return this;
    }

    private void indentCurrentLine(){
        stringBuilder.append(getIndentedString());
        freshLine = false;
    }


    public void incrementIndentation(){
        indentation++;
    }

    public void decremmentIndentation(){
        assert indentation > 0 : "Indentation cannot be lower than 0";
        indentation--;
    }

    public void setIndentation(int indentation){
        this.indentation = indentation;
    }

    public int getIndentation() {
        return indentation;
    }

    @Override
    public String toString(){
        return stringBuilder.toString();
    }


}
