package node.Statements.Expression.LiteralValues;

import org.antlr.v4.runtime.ParserRuleContext;
import semantics.SymbolTable;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class StringNode extends LiteralValueNode {
    String val;

    public StringNode(ParserRuleContext ctx, String val) {
        super(ctx);
        this.val = val;
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    // Get value with '"' around string. I.e. "String"
    public String getVal() {
        return val;
    }

    // Get value without '"' around string. i.e. "String" -> String
    public String getStringVal(){
        return val.substring(1, val.length() -1);
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

}
