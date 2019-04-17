package node.Statements.Expression.FunctionCall;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class GetFuncNode extends AbstractFuncCallNode{
    private String deviceID;
    private String signalID;
    private boolean isOutput;

    public GetFuncNode(ParserRuleContext ctx, String deviceID, String signalID) {
        super(ctx);
        this.deviceID = deviceID;
        this.signalID = signalID;
        this.isOutput = true;
    }

    public GetFuncNode(ParserRuleContext ctx, String deviceID, String signalID, boolean isOutput) {
        super(ctx);
        this.deviceID = deviceID;
        this.signalID = signalID;
        this.isOutput = isOutput;
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
                ", isOutput='" + isOutput + '\'' +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public String getDeviceID() {
        return deviceID;
    }

    public String getSignalID() {
        return signalID;
    }

    public boolean isOutput() {
        return isOutput;
    }
}
