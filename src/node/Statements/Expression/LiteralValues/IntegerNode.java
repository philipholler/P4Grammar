package node.Statements.Expression.LiteralValues;

import semantics.VarType;
import utils.StringUtils;
import visitor.AbstractVisitor;

public class IntegerNode extends LiteralValueNode {
    int val;

    public IntegerNode(String val) {
        this.val = Integer.parseInt(val);
    }

    public IntegerNode(VarType type, String val) {
        super(type);
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
