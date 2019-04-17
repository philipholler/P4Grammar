package node.Events.WhenNodes;

import node.BlockNode;
import node.Events.EventNode;
import node.TimeNodes.DateNode;
import node.TimeNodes.TimeNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

import java.time.MonthDay;

public class EventWhenTimeNode extends EventNode {

    public EventWhenTimeNode(ParserRuleContext ctx, TimeNode time, DateNode date, Node block) {
        super(ctx, time, date, block);
    }

    public EventWhenTimeNode(ParserRuleContext ctx, TimeNode time, Node block) {
        super(ctx, time, block);
    }

    public EventWhenTimeNode(ParserRuleContext ctx, DateNode date, Node block) {
        super(ctx, date, block);
    }

    @Override
    public String toString() {
        return "EventWhenTimeNode()";
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public TimeNode getTimeNode(){
        for (Node node: super.getChildren()) {
            if(node instanceof TimeNode){
                return (TimeNode) node;
            }
        }
        return null;
    }

    public DateNode getDateNode(){
        for (Node node: super.getChildren()) {
            if(node instanceof DateNode){
                return (DateNode) node;
            }
        }
        return null;
    }

    public BlockNode getBlockNode(){
        for (Node node: super.getChildren()) {
            if(node instanceof BlockNode){
                return (BlockNode) node;
            }
        }
        return null;
    }
}
