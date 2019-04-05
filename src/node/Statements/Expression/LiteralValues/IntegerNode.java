package node.Statements.Expression.LiteralValues;

import org.antlr.v4.runtime.ParserRuleContext;
import semantics.VarType;
import utils.StringUtils;
import visitor.AbstractVisitor;

public class IntegerNode extends LiteralValueNode {
    int val;

    public IntegerNode(ParserRuleContext ctx, String val) {
        super(ctx);
        this.val = Integer.parseInt(val);
    }

    public IntegerNode(ParserRuleContext ctx, VarType type, String val) {
        super(ctx, type);
        this.val = Integer.parseInt(val);
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "IntegerNode(" +
                "val=" + val +
                ')';
    }
}
