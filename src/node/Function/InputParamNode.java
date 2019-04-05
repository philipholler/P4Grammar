package node.Function;

import node.base.LeafNode;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.VarType;

public class InputParamNode extends LeafNode {
    private String id;
    private VarType type;

    public InputParamNode(ParserRuleContext ctx, String id, VarType type) {
        super(ctx);
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "InputParamNode(" +
                "id='" + id + '\'' +
                ", type=" + type +
                ')';
    }
}
