package node.Statements.Expression.LiteralValues;

import org.antlr.v4.runtime.ParserRuleContext;
import semantics.SymbolTable;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class IntegerNode extends LiteralValueNode {
    int val;

    public IntegerNode(ParserRuleContext ctx, String val) {
        super(ctx);
        this.val = Integer.parseInt(val);
    }

    public int getVal() {
        return val;
    }

    @Override
    public java.lang.String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String getType() {
        return SymbolTable.INT_TYPE_ID;
    }

    @Override
    public java.lang.String toString() {
        return "IntegerNode(" +
                "val=" + val +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
