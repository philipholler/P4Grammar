package node.Events;

import node.BlockNode;
import node.Statements.Expression.ExpressionNode;
import node.Statements.Wait.TimeFrame;
import node.TimeNodes.DateNode;
import node.TimeNodes.TimeNode;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class EventEveryNode extends EventNode {
    private ExpressionNode exprNode;
    private TimeFrame timeframe;
    private TimeNode timeNode;
    private DateNode dateNode;
    private BlockNode block;

    public EventEveryNode(ParserRuleContext ctx, ExpressionNode exprNode, TimeFrame timeframe, TimeNode timeNode, DateNode dateNode, BlockNode block) {
        super(ctx, exprNode, timeNode, dateNode, block);
        this.exprNode = exprNode;
        this.timeframe = timeframe;
        this.timeNode = timeNode;
        this.dateNode = dateNode;
        this.block = block;
    }

    public EventEveryNode(ParserRuleContext ctx, ExpressionNode exprNode, TimeFrame timeframe, DateNode dateNode, BlockNode block) {
        super(ctx, exprNode, dateNode, block);
        this.exprNode = exprNode;
        this.timeframe = timeframe;
        this.dateNode = dateNode;
        this.block = block;
    }

    public EventEveryNode(ParserRuleContext ctx, ExpressionNode exprNode, TimeFrame timeframe, TimeNode timeNode, BlockNode block) {
        super(ctx, exprNode, timeNode, block);
        this.exprNode = exprNode;
        this.timeframe = timeframe;
        this.timeNode = timeNode;
        this.block = block;
    }

    public EventEveryNode(ParserRuleContext ctx, ExpressionNode exprNode, TimeFrame timeframe, BlockNode block) {
        super(ctx, exprNode, block);
        this.exprNode = exprNode;
        this.timeframe = timeframe;
        this.block = block;
    }

    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        treeString.append(exprNode.getTreeString(indentation + 1));
        if(timeNode != null){
            treeString.append(timeNode.getTreeString(indentation + 1));
        }
        if(dateNode != null) {
            treeString.append(dateNode.getTreeString(indentation + 1));
        }
        treeString.append(block.getTreeString(indentation + 1));

        return treeString.toString();
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
}
