package node.Statements.Expression.LiteralValues;

import semantics.VarType;
import utils.StringUtils;
import visitor.AbstractVisitor;

public class StringNode extends LiteralValueNode {
    String val;

    public StringNode(VarType type, String val) {
        super(type);
        this.val = val.substring(1, val.length() -1);
    }

    public StringNode(String val) {
        this.val = val;
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return null;
    }

    @Override
    public String toString() {
        return "StringNode(" +
                "val='" + val + '\'' +
                ')';
    }
}
