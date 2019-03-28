package Nodes;

import Nodes.Base.BinaryNode;
import Nodes.Base.Node;
import Visitors.AbstractVisitor;

public class RangeNode extends BinaryNode {

    public RangeNode(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }
}
