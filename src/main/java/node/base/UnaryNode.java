package node.base;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;

import java.util.ArrayList;

public abstract class UnaryNode extends Node{
    Node child;

    public UnaryNode(ParserRuleContext ctx, Node child) {
        super(ctx, child);
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
        // Set super class children to only contain the new child
        children.clear();
        children.add(child);
    }
}
