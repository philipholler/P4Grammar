package node.define_nodes.Signal;

import node.base.BinaryNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;

public class RangeNode extends BinaryNode {

    private String type;

    public RangeNode(ParserRuleContext ctx, Node leftChild, Node rightChild, String type) {
        super(ctx, leftChild, rightChild);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RangeNode(" +
                "Type=" + type +
                ')';
    }

}
