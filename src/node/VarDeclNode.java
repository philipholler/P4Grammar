package node;

import node.base.LeafNode;
import node.base.Node;
import node.base.UnaryNode;
import semantics.VarType;
import visitor.AbstractVisitor;

public class VarDeclNode extends UnaryNode {
    VarType varType;
    String ID;

    public VarDeclNode(VarType varType, String ID, Node expr) {
        super(expr);
        this.varType = varType;
        this.ID = ID;
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

    @Override
    public String toString() {
        return "VarDeclNode(" +
                "varType=" + varType +
                ", ID='" + ID + '\'' +
                ')';
    }
}
