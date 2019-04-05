package node.base;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;

import java.util.ArrayList;

public abstract class ListNode extends Node{

    /**
     * Contains a list of children nodes (stored in the super class (Node))
     */

    public ListNode(ParserRuleContext ctx) {
        super(ctx);
    }

    public ListNode(ParserRuleContext ctx, ArrayList<Node> children) {
        super(ctx, children);
    }

    public ListNode(ParserRuleContext ctx, Node...children) {
        super(ctx, children);
    }

    public void addChild(Node child){
        children.add(child);
    }

    public void addChildren(ArrayList<Node> children){
        children.addAll(children);
    }

    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        for(Node n : children)
            treeString.append(n.getTreeString(indentation + 1));

        return treeString.toString();
    }
}
