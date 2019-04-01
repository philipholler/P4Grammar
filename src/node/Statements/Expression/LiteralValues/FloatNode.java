package node.Statements.Expression.LiteralValues;

import semantics.VarType;
import utils.StringUtils;
import visitor.AbstractVisitor;

public class FloatNode extends LiteralValueNode {
    float val;

    public FloatNode(VarType type, String val) {
        super(type);
        this.val = Float.parseFloat(val);
    }

    public FloatNode(String val) {
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
