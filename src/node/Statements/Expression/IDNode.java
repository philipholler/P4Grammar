package node.Statements.Expression;

import semantics.VarType;
import utils.StringUtils;
import visitor.AbstractVisitor;

public class IDNode extends ExpressionNode {
    String ID;

    public IDNode(VarType type, String ID) {
        super(type);
        this.ID = ID;
    }

    public IDNode(String ID) {
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
