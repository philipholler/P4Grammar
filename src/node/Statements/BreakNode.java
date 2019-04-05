package node.Statements;

import node.base.LeafNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;

public class BreakNode extends LeafNode {

    public BreakNode(ParserRuleContext context, Node... children) {
        super(context, children);
    }
}
