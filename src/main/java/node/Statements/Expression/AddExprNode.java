package node.Statements.Expression;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;


public class AddExprNode extends ExpressionNode {
    private Operator op;
    private ExpressionNode leftChild;
    private ExpressionNode rightChild;

    public AddExprNode(ParserRuleContext ctx, ExpressionNode leftChild, ExpressionNode rightChild, Operator op) {
        super(ctx, leftChild, rightChild);
        this.op = op;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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
        return "AddExprNode(op=" + op +
                ')';
    }

    public Operator getOperator() {
        return op;
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public ExpressionNode getLeftChild() {
        return leftChild;
    }

    public ExpressionNode getRightChild() {
        return rightChild;
    }
}