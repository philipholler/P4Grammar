package node;

import node.base.LeafNode;
import semantics.VarType;
import visitor.AbstractVisitor;

public class EnumNode extends LeafNode {
    private String ID;
    private VarType type;
    private String val;

    public EnumNode(String ID, VarType type, String val) {
        this.ID = ID;
        this.type = type;
        this.val = val;
    }

    @Override
    public String getTreeString(int indentation) {
        return super.getTreeString(indentation);
    }

    @Override
    public String toString() {
        return "EnumNode(" +
                "ID='" + ID + '\'' +
                ", type=" + type +
                ", val='" + val + '\'' +
                ')';
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return null;
    }
}
