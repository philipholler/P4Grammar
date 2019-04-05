package node.base;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;

import java.util.ArrayList;

public abstract class BinaryNode extends Node{
    Node leftChild;
    Node rightChild;

    public BinaryNode(ParserRuleContext ctx, Node leftChild, Node rightChild) {
        super(ctx, leftChild, rightChild);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
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

}
