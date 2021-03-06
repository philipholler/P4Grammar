package node.Statements;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;


public class AssignmentNode extends UnaryNode {
    private String ID;
    private ExpressionNode expr;

    public AssignmentNode(ParserRuleContext ctx, Node expr, String ID) {
        super(ctx, expr);
        this.ID = ID;
        this.expr = (ExpressionNode) expr;
    }

    @Override
    public String toString() {
        return "AssignmentNode(" +
                "SIGNAL_ID='" + ID + '\'' +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public String getID() {
        return ID;
    }

    public ExpressionNode getExpr() {
        return expr;
    }

    public void setExpr(ExpressionNode expr) {
        this.expr = expr;

        super.setChild(expr);
    }
}
