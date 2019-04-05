package node.TimeNodes;

import node.Statements.LogicalExpression.LogicalExprNode;
import utils.StringUtils;
import utils.TimeUtils;

import java.time.LocalTime;

public class TimeNode extends LogicalExprNode {
    LocalTime time;

    public TimeNode(int hours, int minutes) {
        this.time = TimeUtils.getTime(hours, minutes);
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "TimeNode(" +
                "time=" + time +
                ')';
    }
}
