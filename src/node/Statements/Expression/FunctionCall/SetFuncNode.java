package node.Statements.Expression.FunctionCall;

import node.base.Node;
import utils.StringUtils;

public class SetFuncNode extends AbstractFuncCallNode {
    private String deviceID;
    private String signalID;
    private Node expr;

    public SetFuncNode(String deviceID, String signalID, Node expr) {
        this.deviceID = deviceID;
        this.signalID = signalID;
        this.expr = expr;
    }

    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        treeString.append(expr.getTreeString(indentation + 1));

        return treeString.toString();
    }

    @Override
    public String toString() {
        return "SetFuncNode(" +
                "deviceID='" + deviceID + '\'' +
                ", signalID='" + signalID + '\'' +
                ')';
    }
}
