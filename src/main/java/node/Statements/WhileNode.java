package node.Statements;

import node.base.BinaryNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class WhileNode extends BinaryNode {

    public WhileNode(ParserRuleContext ctx, Node logicalExpr, Node block) {
        super(ctx, logicalExpr, block);
    }

    @Override
    public String toString() {
        return "WhileNode()";
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}