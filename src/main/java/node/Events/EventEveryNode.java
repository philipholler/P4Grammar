package node.Events;

import node.BlockNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Wait.TimeFrame;
import node.TimeNodes.DateNode;
import node.TimeNodes.LocalTimeNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class EventEveryNode extends EventNode {
    private TimeFrame timeframe;
    private IntegerNode integer;
    private BlockNode blocK;

    public EventEveryNode(ParserRuleContext ctx, IntegerNode integerNode, TimeFrame timeframe, LocalTimeNode localTimeNode, DateNode dateNode, BlockNode block) {
        super(ctx, integerNode, localTimeNode, dateNode, block);
        this.timeframe = timeframe;
        this.blocK = block;
        this.integer = integerNode;
    }

    public EventEveryNode(ParserRuleContext ctx, IntegerNode integerNode, TimeFrame timeframe, DateNode dateNode, BlockNode block) {
        super(ctx, integerNode, dateNode, block);
        this.timeframe = timeframe;
        this.integer = integerNode;
    }

    public EventEveryNode(ParserRuleContext ctx, IntegerNode integerNode, TimeFrame timeframe, LocalTimeNode localTimeNode, BlockNode block) {
        super(ctx, integerNode, localTimeNode, block);
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

    public TimeFrame getTimeframe() {
        return timeframe;
    }

    public IntegerNode getInteger() {
        return integer;
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public LocalTimeNode getTimeNode(){
        for (Node node: super.getChildren()) {
            if(node instanceof LocalTimeNode){
                return (LocalTimeNode) node;
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
