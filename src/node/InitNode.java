package node;

import node.BlockNode;
import node.base.ListNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.AbstractVisitor;

public class InitNode extends UnaryNode {

    public InitNode(ParserRuleContext ctx, Node block) {
        super(ctx, block);
    }

}
