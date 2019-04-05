package node.Events.WhenNodes;

import node.BlockNode;
import node.Events.EventNode;
import node.TimeNodes.DateNode;
import node.TimeNodes.TimeNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;

public class EventWhenTimeNode extends EventNode {
    private TimeNode time;
    private DateNode date;
    private BlockNode block;

    public EventWhenTimeNode(ParserRuleContext ctx, TimeNode time, DateNode date, Node block) {
        super(ctx, time, date, block);
        this.time = time;
        this.date = date;
        this.block = (BlockNode) block;
    }

    public EventWhenTimeNode(ParserRuleContext ctx, TimeNode time, Node block) {
        super(ctx, time, block);
        this.time = time;
        this.block = (BlockNode) block;
    }

    public EventWhenTimeNode(ParserRuleContext ctx, DateNode date, Node block) {
        super(ctx, date, block);
        this.date = date;
        this.block = (BlockNode) block;
    }


    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        if(time != null){
            treeString.append(time.getTreeString(indentation + 1));
        }
        if(date != null) {
            treeString.append(date.getTreeString(indentation + 1));
        }
        treeString.append(block.getTreeString(indentation + 1));

        return treeString.toString();
    }

    @Override
    public String toString() {
        return "EventWhenTimeNode()";
    }
}
