package node.define_nodes.Device;

import node.base.LeafNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class InputNode extends LeafNode {

    public final String SIGNAL_ID;

    public InputNode(ParserRuleContext ctx, String signalTypeID) {
        super(ctx);
        this.SIGNAL_ID = signalTypeID;
    }

    @Override
    public String toString() {
        return super.toString() + "(SIGNAL_ID='" + SIGNAL_ID + "')";
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
