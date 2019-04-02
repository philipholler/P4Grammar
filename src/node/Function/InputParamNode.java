package node.Function;

import node.base.LeafNode;
import semantics.VarType;

public class InputParamNode extends LeafNode {
    private String id;
    private VarType type;

    public InputParamNode(String id, VarType type) {
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
