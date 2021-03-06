package node;

import node.base.LeafNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;


public class DevDeclNode extends LeafNode {
    String type;
    String ID;
    String val;

    public DevDeclNode(ParserRuleContext ctx, String type, String ID, String val) {
        super(ctx);
        this.type = type;
        this.ID = ID;
        this.val = val;
    }

    public String getType() {
        return type;
    }

    public String getID() {
        return ID;
    }

    public String getVal() {
        return val;
    }

    public String getValWithoutQuotation(){
        return val.substring(1, val.length() -1);
    }

    @Override
    public String toString() {
        return "DevDeclNode(" +
                "type='" + type + '\'' +
                ", SIGNAL_ID='" + ID + '\'' +
                ", val='" + val + '\'' +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
