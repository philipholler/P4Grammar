package node.Statements.Expression.FunctionCall;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class SetFuncNode extends AbstractFuncCallNode {
    private String deviceID;
    private String signalID;

    public SetFuncNode(ParserRuleContext ctx, String deviceID, String signalID, ExpressionNode expr) {
        super(ctx, expr);
        this.deviceID = deviceID;
        this.signalID = signalID;
    }

    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        for(Node n : super.getChildren())
            treeString.append(n.getTreeString(indentation + 1));

        return treeString.toString();
    }

    @Override
    public String toString() {
        return "SetFuncNode(" +
                "deviceID='" + deviceID + '\'' +
                ", signalID='" + signalID + '\'' +
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
}
