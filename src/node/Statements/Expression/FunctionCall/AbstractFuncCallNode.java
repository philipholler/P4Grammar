package node.Statements.Expression.FunctionCall;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public abstract class AbstractFuncCallNode extends ExpressionNode {

    public AbstractFuncCallNode(ParserRuleContext ctx, ArrayList<Node> children){
        super(ctx, children);
    }

    public AbstractFuncCallNode(ParserRuleContext ctx, String type) {
        super(ctx, type);
    }

    public AbstractFuncCallNode(ParserRuleContext ctx) {
        super(ctx);
    }
}
