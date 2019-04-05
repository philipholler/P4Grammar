package semantics;

import node.base.Node;

import java.util.ArrayList;

public class DeviceTypeSymbol extends Symbol{

    private final ArrayList<SignalTypeSymbol> inputSignals, outputSignals;

    public DeviceTypeSymbol(String id, Node declarationNode, ArrayList<SignalTypeSymbol> inputSignals, ArrayList<SignalTypeSymbol> outputSignals) {
        super(id, declarationNode);
        this.inputSignals = inputSignals;
        this.outputSignals = outputSignals;
    }

    public boolean hasInputSignal(String ID) {
        for(SignalTypeSymbol s : inputSignals)
            if(s.id.equals(ID)) return true;
        return false;
    }

    public boolean hasOutputSignal(String ID) {
        for(SignalTypeSymbol s : inputSignals)
            if(s.id.equals(ID)) return true;
        return false;
    }

    public boolean hasSignal(String ID){
        return (hasInputSignal(ID) | hasOutputSignal(ID));
    }

    public ArrayList<SignalTypeSymbol> getInputSignals() {
        return inputSignals;
    }

    public ArrayList<SignalTypeSymbol> getOutputSignals() {
        return outputSignals;
    }
}
