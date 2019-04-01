package node.Statements.Expression.LiteralValues;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import semantics.VarType;

public abstract class LiteralValueNode extends ExpressionNode {

    public LiteralValueNode(VarType type) {
        super(type);
    }

    public LiteralValueNode() {
    }
}
