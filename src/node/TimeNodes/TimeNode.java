package node.TimeNodes;

import node.Statements.LogicalExpression.LogicalExprNode;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import utils.TimeUtils;

import java.time.LocalTime;

public class TimeNode extends LogicalExprNode {
    LocalTime time;

    public TimeNode(ParserRuleContext ctx, int hours, int minutes) {
        super(ctx);
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
