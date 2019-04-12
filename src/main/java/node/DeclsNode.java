package node;

import node.base.ListNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;


import java.util.ArrayList;

public class DeclsNode extends ListNode {

    public DeclsNode(ParserRuleContext ctx) {
        super(ctx);
    }

    public DeclsNode(ParserRuleContext ctx, ArrayList<Node> children) {
        super(ctx, children);
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
