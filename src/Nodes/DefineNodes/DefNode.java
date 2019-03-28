package Nodes.DefineNodes;

import Nodes.Base.ListNode;
import Nodes.Base.Node;
import Visitors.AbstractVisitor;

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

