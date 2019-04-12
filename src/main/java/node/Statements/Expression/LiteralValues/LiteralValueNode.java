package node.Statements.Expression.LiteralValues;

import node.Statements.Expression.ExpressionNode;
import org.antlr.v4.runtime.ParserRuleContext;

public abstract class LiteralValueNode extends ExpressionNode {

    public LiteralValueNode(ParserRuleContext ctx, String type) {
        super(ctx, type);
    }

    public LiteralValueNode(ParserRuleContext ctx) {
        super(ctx);
    }

    public abstract String getType();
}
