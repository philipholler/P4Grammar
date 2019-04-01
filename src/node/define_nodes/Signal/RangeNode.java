package node.define_nodes.Signal;

import node.base.BinaryNode;
import node.base.LeafNode;
import node.base.Node;
import semantics.VarType;
import visitor.AbstractVisitor;

public class RangeNode extends LeafNode {
    private String lwBound;
    private String UpBound;
    private VarType Type;

    public RangeNode(String lwBound, String upBound, VarType type) {
        this.lwBound = lwBound;
        UpBound = upBound;
        Type = type;
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "RangeNode(" +
                "lwBound='" + lwBound + '\'' +
                ", UpBound='" + UpBound + '\'' +
                ", Type=" + Type +
                ')';
    }
}
