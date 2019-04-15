package node.Statements.Expression.LiteralValues;

import org.antlr.v4.runtime.ParserRuleContext;
import semantics.SymbolTable;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class StringNode extends LiteralValueNode {
    String val;

    public StringNode(ParserRuleContext ctx, String val) {
        super(ctx);
        this.val = val.substring(1, val.length() - 1);
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "StringNode(" +
                "val='" + val + '\'' +
                ')';
    }

    @Override
    public String getType() {
        return SymbolTable.STRING_TYPE_ID;
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public String getVal() {
        return val;
    }
}
