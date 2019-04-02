package node.Statements;

import node.base.LeafNode;
import node.base.Node;
import node.base.UnaryNode;

public class ReturnNode extends UnaryNode {

    public ReturnNode(Node returnVal) {
        super(returnVal);
    }

    @Override
    public String toString() {
        return "ReturnNode()";
    }
}
