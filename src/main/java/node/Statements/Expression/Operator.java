package node.Statements.Expression;

public enum Operator {
    PLUS("+"), MINUS("-"), DIVIDE("/"), MULTPLY("*");

    public final String symbol;
    Operator(String string){
        this.symbol = string;
    }
}
