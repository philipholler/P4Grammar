package node;

import node.base.Node;
import node.base.UnaryNode;
import visitor.AbstractVisitor;

public class ProgramNode extends UnaryNode {

    public ProgramNode(Node child) {
        super(child);
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }
}
