package node.Statements.LogicalExpression;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class LogicalLiteralNode extends LogicalExprNode {
    private boolean val;

    public LogicalLiteralNode(ParserRuleContext ctx, boolean val) {
        super(ctx);
        this.val = val;
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "LogicalLiteralNode(" +
                "val=" + val +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public boolean isVal() {
        return val;
    }
}
