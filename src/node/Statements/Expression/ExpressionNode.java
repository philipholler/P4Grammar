package node.Statements.Expression;

import node.base.Node;
import semantics.VarType;

public abstract class ExpressionNode extends Node {
    private VarType type;

    public ExpressionNode(VarType type) {
        this.type = type;
    }

    public ExpressionNode() {
    }
}
