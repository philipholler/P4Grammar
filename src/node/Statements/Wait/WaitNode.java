package node.Statements.Wait;

import node.base.LeafNode;
import visitor.AbstractVisitor;

public class WaitNode extends LeafNode {
    private String val;
    private String varID;
    private TimeFrame timeframe;

    public WaitNode(String val, TimeFrame timeframe) {
        this.val = val;
        this.timeframe = timeframe;
    }

    public WaitNode(TimeFrame timeframe, String varID) {
        this.varID = varID;
        this.timeframe = timeframe;
    }

    @Override
    public Object accept(AbstractVisitor visitor) {
        return null;
    }

    @Override
    public String toString() {
        if(val == null){
            return "WaitNode(" +
                    ", varID='" + varID + '\'' +
                    ", timeframe=" + timeframe +
                    ')';
        }
        return "WaitNode(" +
                "val='" + val + '\'' +
                ", timeframe=" + timeframe +
                ')';
    }
}
