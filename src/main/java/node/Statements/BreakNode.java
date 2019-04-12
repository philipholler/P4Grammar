package node.Statements;

import node.base.LeafNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class BreakNode extends LeafNode {

    public BreakNode(ParserRuleContext context, Node... children) {
        super(context, children);
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
