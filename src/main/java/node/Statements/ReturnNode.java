package node.Statements;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

public class ReturnNode extends Node {

    public ReturnNode(ParserRuleContext ctx, Node returnVal) {
        super(ctx, returnVal);
    }

    public ReturnNode(ParserRuleContext ctx) {
        super(ctx);
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

    public Node getReturnVal(){
        if(getChildren().size() == 0)
            return null;

        return getChildren().get(0);
    }

    @Override
    public String toString() {
        return "ReturnNode()";
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
