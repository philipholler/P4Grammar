package node.Statements.Expression;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.VarType;

public abstract class ExpressionNode extends Node {
    private VarType type;

    public ExpressionNode(ParserRuleContext ctx, VarType type) {
        super(ctx);
        this.type = type;
    }

    public ExpressionNode(ParserRuleContext ctx) {
        super(ctx);
    }
}
