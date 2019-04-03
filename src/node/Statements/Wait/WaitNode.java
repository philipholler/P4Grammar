package node.Statements.Wait;

import node.base.LeafNode;
import node.base.Node;
import node.base.UnaryNode;
import visitor.AbstractVisitor;

public class WaitNode extends UnaryNode {
    private TimeFrame timeframe;

    public WaitNode(Node expr, TimeFrame timeframe) {
        super(expr);
        this.timeframe = timeframe;
    }

    @Override
    public String toString() {
        return "WaitNode(" +
                "timeframe=" + timeframe +
                ')';
    }
}
