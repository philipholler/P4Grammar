package node.Statements.Expression.LiteralValues;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.VarType;

public abstract class LiteralValueNode extends ExpressionNode {

    public LiteralValueNode(ParserRuleContext ctx, VarType type) {
        super(ctx, type);
    }

    public LiteralValueNode(ParserRuleContext ctx) {
        super(ctx);
    }
}
