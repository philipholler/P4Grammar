package node.Statements.Expression.FunctionCall;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class SetFuncNode extends AbstractFuncCallNode {
    private String deviceID;
    private String signalID;
    private Node expr;

    public SetFuncNode(ParserRuleContext ctx, String deviceID, String signalID, Node expr) {
        super(ctx);
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

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
