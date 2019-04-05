package node.Statements.LogicalExpression;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public abstract class LogicalExprNode extends Node {

    // todo Is this node used? It doesn't seem to have unique behaivor
    public LogicalExprNode(ArrayList<Node> children, ParserRuleContext context) {
        super(context, children);
    }
}
