package node.Function;

import node.BlockNode;
import node.base.Node;
import node.base.UnaryNode;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public class FunctionNode extends UnaryNode {
    private String returnType;
    private String id;
    private ArrayList<InputParamNode> inputParams = new ArrayList<>();

    public FunctionNode(ParserRuleContext ctx, String returnType, String id, ArrayList<InputParamNode> inputParams, Node block) {
        super(ctx, block);
        this.returnType = returnType;
        this.id = id;
        this.inputParams = inputParams;
    }

    public String getReturnType() {
        return returnType;
    }

    public String getId() {
        return id;
    }

    public ArrayList<InputParamNode> getInputParams() {
        return inputParams;
    }

    public BlockNode getBlock(){
        return (BlockNode) this.getChild();
    }

    @Override
    public java.lang.String toString() {
        return "FunctionNode(" +
                "returnType=" + returnType +
                ", id='" + id + '\'' +
                ", inputParams=" + inputParams +
                ')';
    }
}
