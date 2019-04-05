package node.define_nodes;

import node.base.ListNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.AbstractVisitor;

import java.util.ArrayList;

public abstract class DefNode extends ListNode {

    public DefNode(ParserRuleContext ctx) {
        super(ctx);
    }

    public DefNode(ParserRuleContext ctx, ArrayList<Node> children) {
        super(ctx, children);
    }

}

