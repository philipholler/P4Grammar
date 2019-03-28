package Nodes;

import Nodes.Base.ListNode;
import Nodes.Base.Node;
import Visitors.AbstractVisitor;

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
