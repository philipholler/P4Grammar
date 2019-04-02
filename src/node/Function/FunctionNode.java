package node.Function;

import node.base.ListNode;
import node.base.Node;
import node.base.UnaryNode;
import semantics.VarType;

import java.util.ArrayList;

public class FunctionNode extends UnaryNode {
    private VarType returnType;
    private String id;
    private ArrayList<Node> inputParams = new ArrayList<>();

    public FunctionNode(VarType returnType, String id, ArrayList<Node> inputParams, Node block) {
        super(block);
        this.returnType = returnType;
        this.id = id;
        this.inputParams = inputParams;
    }

    @Override
    public String toString() {
        return "FunctionNode(" +
                "returnType=" + returnType +
                ", id='" + id + '\'' +
                ", inputParams=" + inputParams +
                ')';
    }
}
