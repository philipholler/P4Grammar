package node.Statements.Expression;

import node.base.Node;
import utils.StringUtils;
import visitor.AbstractVisitor;

public class MultiExprNode extends Node {
    private Node leftChild;
    private Node rightChild;
    private Operator op;

    public MultiExprNode(Node leftChild, Node rightChild, Operator op) {
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
    public Object accept(AbstractVisitor visitor) {
        return null;
    }

    @Override
    public String toString() {
        return "MultiExprNode(op=" + op +
                ')';
    }
}
