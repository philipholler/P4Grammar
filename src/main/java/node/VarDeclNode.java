package node;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class VarDeclNode extends UnaryNode {
    String varType;
    String ID;
    ExpressionNode expr;

    public VarDeclNode(ParserRuleContext ctx, String varType, String ID, Node expr) {
        super(ctx, expr);
        this.varType = varType;
        this.ID = ID;
        this.expr = (ExpressionNode) expr;
    }

    public ExpressionNode getExpr() {
        return expr;
    }

    public String getVarType() {
        return varType;
    }

    public java.lang.String getID() {
        return ID;
    }

    @Override
    public java.lang.String toString() {
        return "VarDeclNode(" +
                "varType=" + varType +
                ", SIGNAL_ID='" + ID + '\'' +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
