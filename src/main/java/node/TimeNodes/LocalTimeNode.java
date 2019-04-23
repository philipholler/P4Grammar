package node.TimeNodes;

import node.Statements.LogicalExpression.LogicalExprNode;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import utils.TimeUtils;
import visitor.ASTBaseVisitor;

import java.sql.Time;
import java.time.LocalTime;

public class LocalTimeNode extends TimeNode {
    LocalTime time;

    public LocalTimeNode(ParserRuleContext ctx, int hours, int minutes) {
        super(ctx);
        this.time = TimeUtils.getTime(hours, minutes);
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "LocalTimeNode(" +
                "time=" + time +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
