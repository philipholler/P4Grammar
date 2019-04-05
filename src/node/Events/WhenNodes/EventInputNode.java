package node.Events.WhenNodes;

import node.BlockNode;
import node.Events.EventNode;
import node.base.Node;
import node.define_nodes.Signal.EnumNode;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;

public class EventInputNode extends EventNode {
    private String deviceID;
    private String signalID;
    private String enumID;
    private BlockNode blockNode;

    public EventInputNode(ParserRuleContext ctx, Node block, String deviceID, String signalID, String enumID) {
        super(ctx, block);
        if(!(block instanceof BlockNode)) {
            System.out.println("Error in EventInputNode constructor");
            this.blockNode = null;
        } else {
            this.blockNode = (BlockNode) block;
        }
        this.deviceID = deviceID;
        this.signalID = signalID;
        this.enumID = enumID;
    }

    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        treeString.append(blockNode.getTreeString(indentation + 1));

        return treeString.toString();
    }

    @Override
    public String toString() {
        return "EventInputNode(" +
                "deviceID='" + deviceID + '\'' +
                ", signalID='" + signalID + '\'' +
                ", enumID='" + enumID + '\'' +
                ')';
    }
}
