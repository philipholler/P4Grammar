package node.Statements.Expression.FunctionCall;

import utils.StringUtils;

public class GetFuncNode extends AbstractFuncCallNode{
    private String deviceID;
    private String signalID;

    public GetFuncNode(String deviceID, String signalID) {
        this.deviceID = deviceID;
        this.signalID = signalID;
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "GetFuncNode(" +
                "deviceID='" + deviceID + '\'' +
                ", signalID='" + signalID + '\'' +
                ')';
    }
}
