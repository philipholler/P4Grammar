package node.Statements;

import node.base.BinaryNode;
import node.base.Node;

public class IfStmtNode extends BinaryNode {

    public IfStmtNode(Node logicalExpr, Node block) {
        super(logicalExpr, block);
    }
}
