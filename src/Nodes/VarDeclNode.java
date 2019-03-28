package Nodes;

import Nodes.Base.LeafNode;
import Nodes.Enums.VarType;
import Visitors.AbstractVisitor;

public class VarDeclNode extends LeafNode {
    VarType varType;
    String ID;
    String val;

    public VarDeclNode(VarType varType, String ID, String val) {
        this.varType = varType;
        this.ID = ID;
        this.val = val;
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }

    public VarType getVarType() {
        return varType;
    }

    public String getID() {
        return ID;
    }

    public String getVal() {
        return val;
    }
}
