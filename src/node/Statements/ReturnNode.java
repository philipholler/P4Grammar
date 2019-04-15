package node.Statements;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class ReturnNode extends Node {
    private ExpressionNode returnVal = null;

    public ReturnNode(ParserRuleContext ctx, Node returnVal) {
        super(ctx, returnVal);
        this.returnVal = (ExpressionNode) returnVal;
    }

    public ReturnNode(ParserRuleContext ctx) {
        super(ctx);
    }

    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        for(Node n : super.getChildren())
            treeString.append(n.getTreeString(indentation + 1));

        return treeString.toString();
    }

    @Override
    public String toString() {
        return "ReturnNode()";
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public void setExpr(ExpressionNode expr){
        this.returnVal = expr;
        super.getChildren().clear();
        super.getChildren().add(expr);
    }

    public Node getReturnVal() {
        return returnVal;
    }
}
