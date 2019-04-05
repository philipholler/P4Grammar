package node;

import node.base.LeafNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.VarType;
import visitor.AbstractVisitor;

public class VarDeclNode extends UnaryNode {
    VarType varType;
    String ID;

    public VarDeclNode(ParserRuleContext ctx, VarType varType, String ID, Node expr) {
        super(ctx, expr);
        this.varType = varType;
        this.ID = ID;
    }

    public VarType getVarType() {
        return varType;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "VarDeclNode(" +
                "varType=" + varType +
                ", ID='" + ID + '\'' +
                ')';
    }
}
