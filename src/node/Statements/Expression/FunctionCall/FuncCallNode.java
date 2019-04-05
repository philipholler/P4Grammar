package node.Statements.Expression.FunctionCall;

import node.base.Node;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.StringUtils;

import java.util.ArrayList;

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
                "ID='" + ID + '\'' +
                ", arguments=" + arguments +
                ')';
    }
}
