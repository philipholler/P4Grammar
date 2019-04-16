package node.Events.WhenNodes;

import node.BlockNode;
import node.Events.EventNode;
import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class EventRangeInputNode extends EventNode {
    private String deviceID;
    private String signalID;
    private ExceedsAndDeceedsEnum exceedsAndDeceedsEnum;

    public EventRangeInputNode(ParserRuleContext ctx, BlockNode block, String deviceID, String signalID, ExceedsAndDeceedsEnum exceedsAndDeceedsEnum, ExpressionNode expr) {
        super(ctx, block, expr);
        this.deviceID = deviceID;
        this.signalID = signalID;
        this.exceedsAndDeceedsEnum = exceedsAndDeceedsEnum;
    }

    @Override
    public String toString() {
        return "EventRangeInputNode(" +
                "deviceID='" + deviceID + '\'' +
                ", signalID='" + signalID + '\'' +
                ", exceedsAndDeceedsEnum=" + exceedsAndDeceedsEnum +
                ')';
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getSignalID() {
        return signalID;
    }

    public ExceedsAndDeceedsEnum getExceedsAndDeceedsEnum() {
        return exceedsAndDeceedsEnum;
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

    public BlockNode getBlockNode(){
        for (Node node: super.getChildren()) {
            if(node instanceof BlockNode){
                return (BlockNode) node;
            }
        }
        return null;
    }
}
