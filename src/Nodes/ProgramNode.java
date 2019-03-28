package Nodes;

import Nodes.Base.ListNode;
import Nodes.Base.Node;
import Nodes.Base.UnaryNode;
import Visitors.AbstractVisitor;
import Visitors.PrintVisitor;

public class ProgramNode extends UnaryNode {

    public ProgramNode(Node child) {
        super(child);
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }
}
