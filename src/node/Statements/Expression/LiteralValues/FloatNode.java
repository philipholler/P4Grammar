package node.Statements.Expression.LiteralValues;

import org.antlr.v4.runtime.ParserRuleContext;
import semantics.SymbolTable;
import utils.StringUtils;

public class FloatNode extends LiteralValueNode {
    float val;

    public FloatNode(ParserRuleContext ctx, String type, java.lang.String val) {
        super(ctx, type);
        this.val = Float.parseFloat(val);
    }

    public FloatNode(ParserRuleContext ctx, java.lang.String val) {
        super(ctx);
        this.val = Float.parseFloat(val);
    }

    @Override
    public java.lang.String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    public float getVal() {
        return val;
    }

    @Override
    public String getType() {
        return SymbolTable.FLOAT_TYPE_ID;
    }

    @Override
    public java.lang.String toString() {
        return "FloatNode(" +
                "val=" + val +
                ')';
    }
}
