package node.Events;

import node.BlockNode;
import node.Statements.Expression.ExpressionNode;
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

    public EventEveryNode(ParserRuleContext ctx, ExpressionNode exprNode, TimeFrame timeframe, TimeNode timeNode, DateNode dateNode, BlockNode block) {
        super(ctx, exprNode, timeNode, dateNode, block);
        this.timeframe = timeframe;
        this.blocK = block;
    }

    public EventEveryNode(ParserRuleContext ctx, ExpressionNode exprNode, TimeFrame timeframe, DateNode dateNode, BlockNode block) {
        super(ctx, exprNode, dateNode, block);
        this.timeframe = timeframe;
    }

    public EventEveryNode(ParserRuleContext ctx, ExpressionNode exprNode, TimeFrame timeframe, TimeNode timeNode, BlockNode block) {
        super(ctx, exprNode, timeNode, block);
        this.timeframe = timeframe;
    }

    public EventEveryNode(ParserRuleContext ctx, ExpressionNode exprNode, TimeFrame timeframe, BlockNode block) {
        super(ctx, exprNode, block);
        this.timeframe = timeframe;
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

    public ExpressionNode getExprNode(){
        for (Node node: super.getChildren()) {
            if(node instanceof ExpressionNode){
                return (ExpressionNode) node;
            }
        }
        return null;
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
