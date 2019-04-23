package node.TimeNodes;

import node.Statements.LogicalExpression.LogicalExprNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public abstract class TimeNode extends LogicalExprNode {

    public TimeNode(ParserRuleContext context, ArrayList<Node> children) {
        super(context, children);
    }

    public TimeNode(ParserRuleContext context, Node... children) {
        super(context, children);
    }

    @Override
    public String getTreeString(int indentation) {
        return null;
    }
}
