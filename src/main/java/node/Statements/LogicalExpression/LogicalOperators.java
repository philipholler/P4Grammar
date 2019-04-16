package node.Statements.LogicalExpression;

public enum LogicalOperators {
    AND("&&"), OR("||");

    public final String logOp;

    LogicalOperators(String logOp) {
        this.logOp = logOp;
    }
}
