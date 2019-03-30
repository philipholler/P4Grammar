package node.define_nodes;

import node.base.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefDeviceNode extends DefNode {
    // define Device MovementSensor output: toggle & input: celsius;
    String ID;
    ArrayList<OutputNode> outputs = new ArrayList<>();
    ArrayList<InputNode> inputs = new ArrayList<>();

    public DefDeviceNode(String ID, ArrayList<OutputNode> outputs, ArrayList<InputNode> inputs) {
        super();
        this.ID = ID;
        if(outputs != null) this.outputs = outputs;
        if(inputs != null) this.inputs = inputs;

        for (Node n : this.inputs)
            addChild(n);
        for (Node n : this.outputs)
            addChild(n);
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
}
