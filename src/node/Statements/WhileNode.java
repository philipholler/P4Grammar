package node.Statements;

import node.base.BinaryNode;
import node.base.Node;

public class WhileNode extends BinaryNode {

    public WhileNode(Node logicalExpr, Node block) {
        super(logicalExpr, block);
    }

    @Override
    public String toString() {
        return "WhileNode()";
    }
}
