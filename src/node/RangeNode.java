package node;

import node.base.BinaryNode;
import node.base.Node;
import visitor.AbstractVisitor;

public class RangeNode extends BinaryNode {

    public RangeNode(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }
}
