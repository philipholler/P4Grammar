package node.Statements;

import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;


public class AssignmentNode extends UnaryNode {
    String ID;

    public AssignmentNode(ParserRuleContext ctx, Node expr, String ID) {
        super(ctx, expr);
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "AssignmentNode(" +
                "ID='" + ID + '\'' +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
