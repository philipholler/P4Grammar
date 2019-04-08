package node.define_nodes.Device;

import node.base.LeafNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class InputNode extends LeafNode {

    public final String ID;

    public InputNode(ParserRuleContext ctx, String ID) {
        super(ctx);
        this.ID = ID;
    }

    @Override
    public String toString() {
        return super.toString() + "(ID='" + ID + "')";
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
