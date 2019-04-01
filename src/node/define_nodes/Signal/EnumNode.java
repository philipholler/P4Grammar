package node.define_nodes.Signal;

import node.Statements.Expression.LiteralValues.LiteralValueNode;
import node.base.LeafNode;
import node.base.Node;
import node.base.UnaryNode;
import semantics.VarType;
import visitor.AbstractVisitor;

public class EnumNode extends UnaryNode {
    private String ID;

    public EnumNode(String ID, Node val) {
        super(val);
        this.ID = ID;
    }

    @Override
    public String getTreeString(int indentation) {
        return super.getTreeString(indentation);
    }

    @Override
    public String toString() {
        return "EnumNode(" +
                "ID='" + ID + '\'' +
                ')';
    }
}
