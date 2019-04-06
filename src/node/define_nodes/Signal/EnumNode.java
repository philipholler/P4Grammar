package node.define_nodes.Signal;

import node.Statements.Expression.LiteralValues.LiteralValueNode;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;

public class EnumNode extends UnaryNode {
    private String ID;
    private LiteralValueNode value;

    public EnumNode(ParserRuleContext ctx, String ID, LiteralValueNode value) {
        super(ctx, value);
        this.ID = ID;
        this.value = value;
    }

    public String getID() {
        return ID;
    }

    public LiteralValueNode getValue() {
        return value;
    }

    @Override
    public String getTreeString(int indentation) {
        return super.getTreeString(indentation);
    }

    @Override
    public String toString() {
        return "EnumNode(" +
                "ID='" + ID + '\'' +
                ')';
    }
}
