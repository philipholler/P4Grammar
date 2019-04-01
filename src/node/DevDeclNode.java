package node;

import node.base.LeafNode;
import visitor.AbstractVisitor;

public class DevDeclNode extends LeafNode {
    String type;
    String ID;
    String val;

    public DevDeclNode(String type, String ID, String val) {
        this.type = type;
        this.ID = ID;
        this.val = val;
    }

    public String getType() {
        return type;
    }

    public String getID() {
        return ID;
    }

    public String getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "DevDeclNode(" +
                "type='" + type + '\'' +
                ", ID='" + ID + '\'' +
                ", val='" + val + '\'' +
                ')';
    }
}
