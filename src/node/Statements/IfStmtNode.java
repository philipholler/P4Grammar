package node.Statements;

import node.base.BinaryNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;

public class IfStmtNode extends BinaryNode {

    public IfStmtNode(ParserRuleContext ctx, Node logicalExpr, Node block) {
        super(ctx ,logicalExpr, block);
    }
}
