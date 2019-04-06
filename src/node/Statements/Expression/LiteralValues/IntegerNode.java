package node.Statements.Expression.LiteralValues;

import org.antlr.v4.runtime.ParserRuleContext;
import semantics.SymbolTable;
import utils.StringUtils;

public class IntegerNode extends LiteralValueNode {
    int val;

    public IntegerNode(ParserRuleContext ctx, java.lang.String val) {
        super(ctx);
        this.val = Integer.parseInt(val);
    }

    public IntegerNode(ParserRuleContext ctx, String type, java.lang.String val) {
        super(ctx, type);
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
}
