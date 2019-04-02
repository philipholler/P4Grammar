package node;

import node.BlockNode;
import node.base.ListNode;
import node.base.Node;
import node.base.UnaryNode;
import visitor.AbstractVisitor;

public class InitNode extends UnaryNode {

    public InitNode(Node block) {
        super(block);
    }

}
