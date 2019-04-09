package node;

import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class VarDeclNode extends UnaryNode {
    String varType;
    String ID;

    public VarDeclNode(ParserRuleContext ctx, String varType, String ID, Node expr) {
        super(ctx, expr);
        this.varType = varType;
        this.ID = ID;
    }

    public String getVarType() {
        return varType;
    }

    public java.lang.String getID() {
        return ID;
    }

    @Override
    public java.lang.String toString() {
        return "VarDeclNode(" +
                "varType=" + varType +
                ", ID='" + ID + '\'' +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
