package node.Events;

import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public abstract class EventNode extends Node{

    public EventNode(ParserRuleContext context, ArrayList<Node> children) {
        super(context, children);
    }

    public EventNode(ParserRuleContext context, Node... children) {
        super(context, children);
    }
}
