package node;

import node.base.ListNode;
import node.base.Node;
import visitor.AbstractVisitor;

import java.util.ArrayList;

public class DeclsNode extends ListNode {

    public DeclsNode() {
    }

    public DeclsNode(ArrayList<Node> children) {
        super(children);
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }
}
