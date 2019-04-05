package node.Statements.Expression.FunctionCall;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;

public class GetFuncNode extends AbstractFuncCallNode{
    private String deviceID;
    private String signalID;

    public GetFuncNode(ParserRuleContext ctx, String deviceID, String signalID) {
        super(ctx);
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
