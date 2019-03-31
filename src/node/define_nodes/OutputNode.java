package node.define_nodes;

import node.base.LeafNode;
import visitor.AbstractVisitor;

public class OutputNode extends LeafNode {

    public final String ID;

    public OutputNode(String ID) {
        this.ID = ID;
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return super.toString() + "(ID='" + ID + "')";
    }

}