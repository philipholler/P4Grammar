package node.Events.WhenNodes;

import node.BlockNode;
import node.Events.EventNode;
import node.Statements.LogicalExpression.TimeNodes.DateNode;
import node.Statements.LogicalExpression.TimeNodes.TimeNode;
import node.base.Node;
import utils.StringUtils;

public class EventWhenTimeNode extends EventNode {
    private TimeNode time;
    private DateNode date;
    private BlockNode block;

    public EventWhenTimeNode(TimeNode time, DateNode date, Node block) {
        this.time = time;
        this.date = date;
        this.block = (BlockNode) block;
    }

    public EventWhenTimeNode(TimeNode time, Node block) {
        this.time = time;
        this.block = (BlockNode) block;
    }

    public EventWhenTimeNode(DateNode date, Node block) {
        this.date = date;
        this.block = (BlockNode) block;
    }


    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        treeString.append(block.getTreeString(indentation + 1));

        return treeString.toString();
    }

    @Override
    public String toString() {
        if(time == null){
            return "EventWhenTimeNode(" +
                    "date=" + date +
                    ')';
        }
        else if(date == null){
            return "EventWhenTimeNode(" +
                    "time=" + time +
                    ')';
        }
        else {
            return "EventWhenTimeNode(" +
                    "time=" + time +
                    ", date=" + date +
                    ')';
        }
    }
}
