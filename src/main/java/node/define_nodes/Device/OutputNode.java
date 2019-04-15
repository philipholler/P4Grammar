package node.define_nodes.Device;

import node.base.LeafNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class OutputNode extends LeafNode {

    public final String SIGNAL_ID;

    public OutputNode(ParserRuleContext ctx, String SIGNAL_ID) {
        super(ctx);
        this.SIGNAL_ID = SIGNAL_ID;
    }

    @Override
    public String toString() {
        return super.toString() + "(SIGNAL_ID='" + SIGNAL_ID + "')";
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

}
