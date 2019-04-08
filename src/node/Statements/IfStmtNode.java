package node.Statements;

import node.base.ListNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;

public class IfStmtNode extends ListNode {
    public IfStmtNode(ParserRuleContext ctx, Node logicalExpr, Node block) {
        super(ctx ,logicalExpr, block);
    }

    public IfStmtNode(ParserRuleContext ctx, ArrayList<Node> children) {
        super(ctx, children);
    }

    public Node getLogicalExprNode(){
        return super.getChildren().get(0);
    }

    public Node getIfBlock(){
        return super.getChildren().get(1);
    }

    public Node getElseBlock(){
        return super.getChildren().get(2);
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}
}
