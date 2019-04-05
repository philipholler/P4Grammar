package node.TimeNodes;

import node.Statements.LogicalExpression.LogicalExprNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;

import java.util.ArrayList;

public class NowNode extends LogicalExprNode {

    public NowNode(ParserRuleContext context) {
        super(context);
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "NowNode()";
    }
}
