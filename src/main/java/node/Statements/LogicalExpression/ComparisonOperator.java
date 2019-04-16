package node.Statements.LogicalExpression;

public enum ComparisonOperator {
    GREATERTHAN(">"),
    GREANTHANEQUAL(">="),
    SMALLERTHAN("<"),
    SMALLERTHANEQUAL("<="),
    EQUALTO("=="),
    NOTEQUAL("!=");

    public final String opString;
    ComparisonOperator(String opString) {
        this.opString = opString;
    }
}
