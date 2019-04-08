package node;

import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;


public class InitNode extends UnaryNode {

    public InitNode(ParserRuleContext ctx, Node block) {
        super(ctx, block);
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
