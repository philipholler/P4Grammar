package node.Statements.Expression.LiteralValues;

import semantics.VarType;
import utils.StringUtils;
import visitor.AbstractVisitor;

public class StringNode extends LiteralValueNode {
    String val;

    public StringNode(String val) {
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
}
