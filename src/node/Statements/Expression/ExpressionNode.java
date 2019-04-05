package node.Statements.Expression;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.VarType;

import java.util.ArrayList;

public abstract class ExpressionNode extends Node {
    private VarType type;

    public ExpressionNode(ParserRuleContext context, ArrayList<Node> children, VarType type) {
        super(context, children);
        this.type = type;
    }

    public ExpressionNode(ParserRuleContext context, ArrayList<Node> children) {
        super(context, children);
    }

    public ExpressionNode(ParserRuleContext context, VarType type, Node... children) {
        super(context, children);
        this.type = type;
    }

    public ExpressionNode(ParserRuleContext context, Node... children) {
        super(context, children);
    }

}
