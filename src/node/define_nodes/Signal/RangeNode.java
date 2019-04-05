package node.define_nodes.Signal;

import node.Statements.Expression.LiteralValues.LiteralValueNode;
import node.base.BinaryNode;
import node.base.LeafNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.VarType;
import visitor.AbstractVisitor;

public class RangeNode extends BinaryNode {
    private VarType Type;

    public RangeNode(ParserRuleContext ctx, Node leftChild, Node rightChild, VarType type) {
        super(ctx, leftChild, rightChild);
        Type = type;
    }

    @Override
    public String toString() {
        return "RangeNode(" +
                "Type=" + Type +
                ')';
    }

}
