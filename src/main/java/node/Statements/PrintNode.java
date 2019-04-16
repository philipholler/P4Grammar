package node.Statements;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class PrintNode extends UnaryNode {

    private ExpressionNode expressionNode;

    public PrintNode(ParserRuleContext ctx, ExpressionNode child) {
        super(ctx, child);
        this.expressionNode = child;
    }

    public ExpressionNode getPrintValue(){
        return (ExpressionNode) super.getChild();
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }

    public void setExpressionNode(ExpressionNode expressionNode) {
        super.getChildren().clear();
        super.getChildren().add(expressionNode);
        this.expressionNode = expressionNode;
    }
}
