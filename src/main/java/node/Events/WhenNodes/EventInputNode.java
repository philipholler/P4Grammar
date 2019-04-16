package node.Events.WhenNodes;

import node.BlockNode;
import node.Events.EventNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class EventInputNode extends EventNode {
    private String deviceID;
    private String signalID;
    private String enumID;

    public EventInputNode(ParserRuleContext ctx, BlockNode block, String deviceID, String signalID, String enumID) {
        super(ctx, block);
        this.deviceID = deviceID;
        this.signalID = signalID;
        this.enumID = enumID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getSignalID() {
        return signalID;
    }

    public String getEnumID() {
        return enumID;
    }

    @Override
    public String toString() {
        return "EventInputNode(" +
                "deviceID='" + deviceID + '\'' +
                ", signalID='" + signalID + '\'' +
                ", enumID='" + enumID + '\'' +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public BlockNode getBlockNode(){
        return (BlockNode) super.getChildren().get(0);
    }
}
