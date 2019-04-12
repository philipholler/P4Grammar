package node.Statements.LogicalExpression;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class LogicalOrExprNode extends LogicalExprNode {

    public LogicalOrExprNode(ParserRuleContext ctx, Node leftChild, Node rightChild) {
        super(ctx, leftChild, rightChild);
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
        return "LogicalOrExprNode()";
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
