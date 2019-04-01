package node.Statements.LogicalExpression;

import node.base.Node;
import utils.StringUtils;

public class LogicalOrExprNode extends LogicalExprNode {
    Node leftChild;
    Node rightChild;

    public LogicalOrExprNode(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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
        return "LogicalAndExprNode()";
    }
}
