package node.Statements;

import node.base.Node;
import node.base.UnaryNode;
import visitor.AbstractVisitor;

public class AssignmentNode extends UnaryNode {
    String ID;

    public AssignmentNode(Node expr, String ID) {
        super(expr);
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "AssignmentNode(" +
                "ID='" + ID + '\'' +
                ')';
    }
}
