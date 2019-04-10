package node.Statements.Expression;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public abstract class ExpressionNode extends Node {
    private String type;

    public ExpressionNode(ParserRuleContext context, ArrayList<Node> children, String type) {
        super(context, children);
        this.type = type;
    }

    public ExpressionNode(ParserRuleContext context, ArrayList<Node> children) {
        super(context, children);
    }

    public ExpressionNode(ParserRuleContext context, String type, Node... children) {
        super(context, children);
        this.type = type;
    }

    public ExpressionNode(ParserRuleContext context, Node... children) {
        super(context, children);
    }

    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
