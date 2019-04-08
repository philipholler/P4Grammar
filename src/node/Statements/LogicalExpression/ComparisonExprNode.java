package node.Statements.LogicalExpression;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class ComparisonExprNode extends LogicalExprNode {
    Node leftChild;
    Node rightChild;
    ComparisonOperator op;

    public ComparisonExprNode(ParserRuleContext ctx, Node leftChild, Node rightChild, ComparisonOperator op) {
        super(ctx, leftChild, rightChild);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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
        return "ComparisonExprNode(" +
                "op=" + op +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
