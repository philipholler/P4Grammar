package node.Statements.Expression;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class MultiExprNode extends ExpressionNode {
    private ExpressionNode leftChild;
    private ExpressionNode rightChild;
    private Operator op;

    public MultiExprNode(ParserRuleContext ctx, Node leftChild, Node rightChild, Operator op) {
        super(ctx, leftChild, rightChild);
        this.leftChild = (ExpressionNode) leftChild;
        this.rightChild = (ExpressionNode) rightChild;
        this.op = op;
    }

    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        treeString.append(leftChild.getTreeString(indentation + 1));
        treeString.append(rightChild.getTreeString(indentation + 1));

        return treeString.toString();
    }

    @Override
    public String toString() {
        return "MultiExprNode(op=" + op +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
