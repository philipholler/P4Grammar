package node.Statements.Expression;

import org.antlr.v4.runtime.ParserRuleContext;
import semantics.VarType;
import utils.StringUtils;
import visitor.AbstractVisitor;

public class IDNode extends ExpressionNode {
    String ID;

    public IDNode(ParserRuleContext ctx, VarType type, String ID) {
        super(ctx, type);
        this.ID = ID;
    }

    public IDNode(ParserRuleContext ctx, String ID) {
        super(ctx);
        this.ID = ID;
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "IDNode(" +
                "ID='" + ID + '\'' +
                ')';
    }
}
