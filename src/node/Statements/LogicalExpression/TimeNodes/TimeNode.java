package node.Statements.LogicalExpression.TimeNodes;

import node.Statements.LogicalExpression.LogicalExprNode;
import utils.StringUtils;

public class TimeNode extends LogicalExprNode {
    // todo: find et godt time library og implementer - Philip 03.04.2019
    private int hours;
    private int minutes;

    public TimeNode(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "TimeNode(" +
                "time=" +
                hours + ':' + minutes +
                ')';
    }
}
