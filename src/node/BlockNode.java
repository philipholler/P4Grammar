package node;

import node.base.ListNode;
import node.base.Node;
import visitor.AbstractVisitor;

import java.util.ArrayList;

public class BlockNode extends ListNode {

    public BlockNode(ArrayList<Node> children) {
        super(children);
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return null;
    }
}
