package Nodes;

import Nodes.Base.ListNode;
import Nodes.Base.Node;
import Nodes.Base.UnaryNode;
import Visitors.AbstractVisitor;

public class programNode extends UnaryNode {

    public programNode(Node child) {
        super(child);
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }
}
