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
    private ExpressionNode val;
    private BlockNode block;

    public EventRangeInputNode(ParserRuleContext ctx, Node block, String deviceID, String signalID, ExceedsAndDeceedsEnum exceedsAndDeceedsEnum, ExpressionNode expr) {
        super(ctx, block);
        if(!(block instanceof BlockNode)) {
            System.out.println("Error in EventRangeInputNode constructor");
            this.block = null;
        } else{
            this.block = (BlockNode) block;
        }
        this.deviceID = deviceID;
        this.signalID = signalID;
        this.exceedsAndDeceedsEnum = exceedsAndDeceedsEnum;
        this.val = expr;
    }

    @Override
    public String toString() {
        return "EventRangeInputNode(" +
                "deviceID='" + deviceID + '\'' +
                ", signalID='" + signalID + '\'' +
                ", exceedsAndDeceedsEnum=" + exceedsAndDeceedsEnum +
                ')';
    }

    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        treeString.append(val.getTreeString(indentation + 1));
        treeString.append(block.getTreeString(indentation + 1));

        return treeString.toString();
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
