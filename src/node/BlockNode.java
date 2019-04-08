package node;

import node.base.ListNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;

public class BlockNode extends ListNode {

    public BlockNode(ParserRuleContext ctx, ArrayList<Node> children) {
        super(ctx, children);
    }

    public BlockNode(ParserRuleContext ctx) {
        super(ctx);
    }

    @Override
    public String toString() {
        return "BlockNode()";
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
