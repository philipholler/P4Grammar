package node.Statements.Expression;

import node.base.Node;
import semantics.VarType;
import utils.StringUtils;

import java.util.ArrayList;

public class FuncCallNode extends ExpressionNode{
    private ArrayList<Node> params = new ArrayList<>();
    private String ID;

    public FuncCallNode(ArrayList<Node> params, String ID) {
        this.params = params;
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
                ", params=" + params +
                ')';
    }
}
