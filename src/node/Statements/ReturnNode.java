package node.Statements;

import node.Statements.Expression.ExpressionNode;
import node.base.LeafNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;

public class ReturnNode extends Node {
    private ExpressionNode exprNode;

    public ReturnNode(ParserRuleContext ctx, Node returnVal) {
        super(ctx, returnVal);
        this.exprNode = (ExpressionNode) returnVal;
    }

    public ReturnNode(ParserRuleContext ctx) {
        super(ctx);
    }

    @Override
    public String getTreeString(int indentation) {
        StringBuilder treeString = new StringBuilder();

        treeString.append(StringUtils.getIndentedString(indentation));
        treeString.append(this.toString()).append("\n");

        if(exprNode != null){
            treeString.append(exprNode.getTreeString(indentation + 1));
        }

        return treeString.toString();
    }

    @Override
    public String toString() {
        return "ReturnNode()";
    }
}
