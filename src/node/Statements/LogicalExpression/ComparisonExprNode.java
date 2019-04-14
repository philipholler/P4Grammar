package node.Statements.LogicalExpression;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class ComparisonExprNode extends LogicalExprNode {
    private ComparisonOperator op;
    private Node leftChild;
    private Node rightChild;

    public ComparisonExprNode(ParserRuleContext ctx, Node leftChild, Node rightChild, ComparisonOperator op) {
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
        return "ComparisonExprNode(" +
                "op=" + op +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }
}
