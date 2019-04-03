package node.Statements.Expression.FunctionCall;

import node.base.Node;
import utils.StringUtils;

import java.util.ArrayList;

public class FuncCallNode extends AbstractFuncCallNode{
    private ArrayList<Node> arguments = new ArrayList<>();
    private String ID;

    public FuncCallNode(ArrayList<Node> arguments, String ID) {
        this.arguments = arguments;
        this.ID = ID;
    }

    public FuncCallNode(String ID) {
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
