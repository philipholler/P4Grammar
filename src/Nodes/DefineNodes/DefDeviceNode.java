package Nodes.DefineNodes;

import Nodes.Base.Node;

import java.util.ArrayList;

public class DefDeviceNode extends DefNode{
    // define Device MovementSensor output: toggle & input: celsius;
    String ID;
    ArrayList<OutputNode> outputs;
    ArrayList<InputNode> Inputs;

    public DefDeviceNode(String ID, ArrayList<OutputNode> outputs, ArrayList<InputNode> inputs) {
        this.ID = ID;
        this.outputs = outputs;
        Inputs = inputs;
    }

    public DefDeviceNode(ArrayList<Node> children, String ID, ArrayList<OutputNode> outputs, ArrayList<InputNode> inputs) {
        super(children);
        this.ID = ID;
        this.outputs = outputs;
        Inputs = inputs;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<OutputNode> getOutputs() {
        return outputs;
    }

    public ArrayList<InputNode> getInputs() {
        return Inputs;
    }
}
