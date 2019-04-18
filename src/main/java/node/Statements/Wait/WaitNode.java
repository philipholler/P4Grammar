package node.Statements.Wait;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;


public class WaitNode extends UnaryNode {
    private TimeFrame timeframe;
    private ExpressionNode expr;

    public WaitNode(ParserRuleContext ctx, Node expr, TimeFrame timeframe) {
        super(ctx, expr);
        this.timeframe = timeframe;
        this.expr = (ExpressionNode) expr;
    }

    @Override
    public String toString() {
        return "WaitNode(" +
                "timeframe=" + timeframe +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public ExpressionNode getExpr() {
        return expr;
    }

    public TimeFrame getTimeframe() {
        return timeframe;
    }
}
