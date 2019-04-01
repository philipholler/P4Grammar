package node.define_nodes.Device;

import node.base.LeafNode;
import visitor.AbstractVisitor;

public class InputNode extends LeafNode {

    public final String ID;

    public InputNode(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return super.toString() + "(ID='" + ID + "')";
    }
}
