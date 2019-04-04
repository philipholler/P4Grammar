package node.Statements.LogicalExpression.TimeNodes;

import node.Statements.LogicalExpression.LogicalExprNode;
import utils.StringUtils;
import utils.TimeUtils;

import java.time.LocalTime;

public class TimeNode extends LogicalExprNode {
    // todo: find et godt time library og implementer - Philip 03.04.2019
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
