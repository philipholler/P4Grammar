package node.Statements.Expression.LiteralValues;

import org.antlr.v4.runtime.ParserRuleContext;
import semantics.VarType;
import utils.StringUtils;
import visitor.AbstractVisitor;

public class FloatNode extends LiteralValueNode {
    float val;

    public FloatNode(ParserRuleContext ctx, VarType type, String val) {
        super(ctx, type);
        this.val = Float.parseFloat(val);
    }

    public FloatNode(ParserRuleContext ctx, String val) {
        super(ctx);
        this.val = Float.parseFloat(val);
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "FloatNode(" +
                "val=" + val +
                ')';
    }
}
