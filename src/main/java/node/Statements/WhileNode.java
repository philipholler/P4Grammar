package node.Statements;

import node.BlockNode;
import node.Statements.LogicalExpression.LogicalExprNode;
import node.base.BinaryNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

public class WhileNode extends BinaryNode {

    private LogicalExprNode logicalExprNode;
    private BlockNode blockNode;

    public WhileNode(ParserRuleContext ctx, Node logicalExpr, Node block) {
        super(ctx, logicalExpr, block);
        this.logicalExprNode = (LogicalExprNode) logicalExpr;
        this.blockNode = (BlockNode) block;
    }

    @Override
    public String toString() {
        return "WhileNode()";
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public LogicalExprNode getLogicalExprNode() {
        return logicalExprNode;
    }

    public BlockNode getBlockNode(){return blockNode;}

}
