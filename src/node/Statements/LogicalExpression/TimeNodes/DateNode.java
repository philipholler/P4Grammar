package node.Statements.LogicalExpression.TimeNodes;

import node.Statements.LogicalExpression.LogicalExprNode;
import utils.StringUtils;

public class DateNode extends LogicalExprNode {
    // todo: find proper date library and implement - Philip
    private int day;
    private int month;
    private int year;

    public DateNode(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DateNode(int day, int month) {
        this.day = day;
        this.month = month;
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "DateNode(" +
                "day=" + day +
                "/" + month +
                "/" + year +
                ')';
    }
}
