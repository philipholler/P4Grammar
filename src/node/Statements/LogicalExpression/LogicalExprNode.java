package node.Statements.LogicalExpression;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public abstract class LogicalExprNode extends Node {

    public LogicalExprNode(ParserRuleContext context, ArrayList<Node> children) {
        super(context, children);
    }

    public LogicalExprNode(ParserRuleContext context, Node... children) {
        super(context, children);
    }
}
