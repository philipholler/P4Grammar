package node.define_nodes.Signal;

import node.Statements.Expression.LiteralValues.LiteralValueNode;
import node.base.BinaryNode;
import node.base.LeafNode;
import node.base.Node;
import semantics.VarType;
import visitor.AbstractVisitor;

public class RangeNode extends BinaryNode {
    private VarType Type;

    public RangeNode(Node leftChild, Node rightChild, VarType type) {
        super(leftChild, rightChild);
        Type = type;
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "RangeNode(" +
                "Type=" + Type +
                ')';
    }

}
