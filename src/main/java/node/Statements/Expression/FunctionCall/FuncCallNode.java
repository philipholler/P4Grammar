package node.Statements.Expression.FunctionCall;

import node.Statements.Expression.ExpressionNode;
import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;
import java.util.Collections;

public class FuncCallNode extends AbstractFuncCallNode{
    private ArrayList<Node> arguments = new ArrayList<>();
    private String ID;

    public FuncCallNode(ParserRuleContext ctx, ArrayList<Node> arguments, String ID) {
        super(ctx, arguments);
        this.arguments = arguments;
        this.ID = ID;
    }

    public FuncCallNode(ParserRuleContext ctx, String ID) {
        super(ctx);
        this.ID = ID;
    }

    @Override
    public String getTreeString(int indentation) {
        return StringUtils.getIndentedString(indentation) +
                this.toString() + "\n";
    }

    @Override
    public String toString() {
        return "FuncCallNode(" +
                "SIGNAL_ID='" + ID + '\'' +
                ", arguments=" + arguments +
                ", type=" + super.getType() +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
    return astBaseVisitor.visit(this);
}

    public String getID() {
        return ID;
    }

    public ArrayList<Node> getArguments() {
        return arguments;
    }

    public void setArgument(int index, Node argument) {
        super.getChildren().set(index, argument);
        this.getArguments().set(index, argument);
    }
}
