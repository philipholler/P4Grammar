package node.define_nodes.Signal;

import node.Statements.Expression.ExpressionNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.LiteralValueNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;
import semantics.SymbolTable;
import visitor.ASTBaseVisitor;

public class EnumNode extends UnaryNode {
    private String ID;
    private LiteralValueNode literalValue;

    public EnumNode(ParserRuleContext ctx, String ID, LiteralValueNode value) {
        super(ctx, value);
        this.literalValue = value;
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String getTreeString(int indentation) {
        return super.getTreeString(indentation);
    }

    @Override
    public String toString() {
        return "EnumNode(" +
                "ID='" + ID + '\'' +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public LiteralValueNode getLiteralValue(){
        return literalValue;
    }

    public String getType(){
        Node val = super.getChildren().get(0);

        if(val instanceof IntegerNode){
            return ((IntegerNode) val).getType();
        } else if (val instanceof FloatNode){
            return ((FloatNode) val).getType();
        } else {
            return ((StringNode) val).getType();
        }
    }

}
