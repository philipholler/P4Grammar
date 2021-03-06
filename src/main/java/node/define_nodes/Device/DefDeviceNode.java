package node.define_nodes.Device;

import node.base.Node;
import node.define_nodes.DefNode;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.ListUtils;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;

public class DefDeviceNode extends DefNode {
    // define Device MovementSensor output: toggle & input: celsius;
    String ID;
    ArrayList<OutputNode> outputs = new ArrayList<>();
    ArrayList<InputNode> inputs = new ArrayList<>();

    public DefDeviceNode(ParserRuleContext ctx, String ID, ArrayList<OutputNode> outputs, ArrayList<InputNode> inputs) {
        super(ctx, ListUtils.combineNodeLists(outputs, inputs));
        this.ID = ID;
        if(outputs != null) this.outputs = outputs;
        if(inputs != null) this.inputs = inputs;
    }




    public String getID() {
        return ID;
    }

    public ArrayList<OutputNode> getOutputs() {
        return outputs;
    }

    public ArrayList<InputNode> getInputs() {
        return inputs;
    }

    @Override
    public String toString() {
        return "DefDeviceNode(" +
                "SIGNAL_ID='" + ID + '\'' +
                ')';
    }

    public <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }

}
