package Nodes;

import Nodes.Base.LeafNode;
import Visitors.AbstractVisitor;

public class DevDeclNode extends LeafNode {
    String type;
    String ID;
    String val;

    public DevDeclNode(String type, String ID, String val) {
        this.type = type;
        this.ID = ID;
        this.val = val;
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
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

}
