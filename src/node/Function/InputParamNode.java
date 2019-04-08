package node.Function;

import node.base.LeafNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class InputParamNode extends LeafNode {
    private java.lang.String id;
    private String type;

    public InputParamNode(ParserRuleContext ctx, java.lang.String id, String type) {
        super(ctx);
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public java.lang.String toString() {
        return "InputParamNode(" +
                "id='" + id + '\'' +
                ", type=" + type +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
