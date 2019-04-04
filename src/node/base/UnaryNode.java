package node.base;

import utils.StringUtils;

public abstract class UnaryNode extends Node{
    Node child;

    public UnaryNode(Node child) {
        this.child = child;
    }

    public Node getChild() {
        return child;
    }

    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        treeString.append(child.getTreeString(indentation + 1));

        return treeString.toString();
    }

    public void setChild(Node child) {
        this.child = child;
    }
}
