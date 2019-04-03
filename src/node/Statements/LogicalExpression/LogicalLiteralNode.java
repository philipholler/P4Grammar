package node.Statements.LogicalExpression;

import utils.StringUtils;

public class LogicalLiteralNode extends LogicalExprNode {
    private boolean val;

    public LogicalLiteralNode(boolean val) {
        this.val = val;
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "LogicalLiteralNode(" +
                "val=" + val +
                ')';
    }
}
