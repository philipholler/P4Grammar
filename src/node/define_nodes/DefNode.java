package node.define_nodes;

import node.base.ListNode;
import node.base.Node;
import utils.StringUtils;
import visitor.AbstractVisitor;

import java.util.ArrayList;

/**
 * TODO ERROR HANDLING I CONSTRUCTORS
 */

public abstract class DefNode extends ListNode {

    public DefNode() {
    }

    public DefNode(ArrayList<Node> children) {
        super(children);
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return visitor.visit(this);
    }


}

