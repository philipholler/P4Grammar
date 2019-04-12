package node;

import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class ProgramNode extends UnaryNode {

    public ProgramNode(ParserRuleContext ctx, Node child) {
        super(ctx, child);
    }

    @Override
    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
