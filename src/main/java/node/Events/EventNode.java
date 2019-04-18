package node.Events;

import node.BlockNode;
import node.base.ListNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.SymbolTable;

import java.util.ArrayList;

public abstract class EventNode extends ListNode {

    public EventNode(ParserRuleContext context, ArrayList<Node> children) {
        super(context, children);
    }

    public EventNode(ParserRuleContext context, Node... children) {
        super(context, children);
    }

    public abstract BlockNode getBlockNode();

    public String getReturnType(){
        return SymbolTable.VOID_TYPE_ID;
    }

}
