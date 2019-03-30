package node.define_nodes;

import node.base.LeafNode;
import visitor.AbstractVisitor;

public class OutputNode extends LeafNode {

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }
}
