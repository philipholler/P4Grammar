package node.Statements.Expression;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class IDNode extends ExpressionNode {
    java.lang.String ID;

    public IDNode(ParserRuleContext ctx, String type, java.lang.String ID) {
        super(ctx, type);
        this.ID = ID;
    }

    public IDNode(ParserRuleContext ctx, java.lang.String ID) {
        super(ctx);
        this.ID = ID;
    }

    @Override
    public java.lang.String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public java.lang.String toString() {
        return "IDNode(" +
                "ID='" + ID + '\'' +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
