package node.Events;

import node.BlockNode;
import node.Statements.Expression.ExpressionNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Wait.TimeFrame;
import node.TimeNodes.DateNode;
import node.TimeNodes.TimeNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class EventEveryNode extends EventNode {
    private TimeFrame timeframe;
    private BlockNode blocK;
    private IntegerNode integer;

    public EventEveryNode(ParserRuleContext ctx, IntegerNode integerNode, TimeFrame timeframe, TimeNode timeNode, DateNode dateNode, BlockNode block) {
        super(ctx, integerNode, timeNode, dateNode, block);
        this.timeframe = timeframe;
        this.blocK = block;
        this.integer = integerNode;
    }

    public EventEveryNode(ParserRuleContext ctx, IntegerNode integerNode, TimeFrame timeframe, DateNode dateNode, BlockNode block) {
        super(ctx, integerNode, dateNode, block);
        this.timeframe = timeframe;
        this.integer = integerNode;
    }

    public EventEveryNode(ParserRuleContext ctx, IntegerNode integerNode, TimeFrame timeframe, TimeNode timeNode, BlockNode block) {
        super(ctx, integerNode, timeNode, block);
        this.timeframe = timeframe;
        this.integer = integerNode;
    }

    public EventEveryNode(ParserRuleContext ctx, IntegerNode integerNode, TimeFrame timeframe, BlockNode block) {
        super(ctx, integerNode, block);
        this.timeframe = timeframe;
        this.integer = integerNode;
    }

    @Override
    public String toString() {
        return "EventEveryNode(" +
                "timeframe=" + timeframe +
                ')';
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
