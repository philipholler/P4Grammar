package codegen.default_classes;

import java.util.ArrayList;

public abstract class Device {

    private String networkID;
    private ArrayList<Signal> inputSignals = new ArrayList<>();
    private ArrayList<Signal> outputSignals = new ArrayList<>();

    protected Device(String networkID, ArrayList<Signal> inputSignals, ArrayList<Signal> outputSignals) {
        this.networkID = networkID;
        this.inputSignals = inputSignals;
        this.outputSignals = outputSignals;
    }

    protected Device(String networkID) {
        this.networkID = networkID;
    }

    protected void addInputSignal(Signal signal){
        inputSignals.add(signal);
    }

    protected void addOutputSignal(Signal signal){
        inputSignals.add(signal);
    }

    public String getNetworkID(){
        return networkID;
    }

    public ArrayList<Signal> getInputSignals() {
        return inputSignals;
    }

    public ArrayList<Signal> getOutputSignals() {
        return outputSignals;
    }
}
