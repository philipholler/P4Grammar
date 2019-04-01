package node.Statements.LogicalExpression;

import node.base.Node;
import utils.StringUtils;

public class ComparisonExprNode extends LogicalExprNode {
    Node leftChild;
    Node rightChild;
    ComparisonOperator op;

    public ComparisonExprNode(Node leftChild, Node rightChild, ComparisonOperator op) {
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
}
