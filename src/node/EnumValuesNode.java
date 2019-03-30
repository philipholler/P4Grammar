package node;

import node.base.ListNode;
import node.base.Node;
import visitor.AbstractVisitor;

import java.util.ArrayList;

public class EnumValuesNode extends ListNode {

    public EnumValuesNode() {
    }

    public EnumValuesNode(ArrayList<Node> children) {
        super(children);
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public ArrayList<Node> getChildren() {
        return super.getChildren();
    }

    @Override
    public void addChild(Node child) {
        super.addChild(child);
    }
}
