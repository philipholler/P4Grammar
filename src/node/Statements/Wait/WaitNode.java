package node.Statements.Wait;

import node.base.LeafNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.AbstractVisitor;

public class WaitNode extends UnaryNode {
    private TimeFrame timeframe;

    public WaitNode(ParserRuleContext ctx, Node expr, TimeFrame timeframe) {
        super(ctx, expr);
        this.timeframe = timeframe;
    }

    @Override
    public String toString() {
        return "WaitNode(" +
                "timeframe=" + timeframe +
                ')';
    }
}
