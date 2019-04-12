package semantics;

import exceptions.userside.NoSuchSignalCompileError;
import node.base.Node;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.Device.InputNode;
import node.define_nodes.Device.OutputNode;

import java.util.ArrayList;
import java.util.Optional;

public class DeviceTypeSymbol extends Symbol{

    private final ArrayList<SignalTypeSymbol> inputSignals, outputSignals;

    public DeviceTypeSymbol(String id, Node declarationNode, ArrayList<SignalTypeSymbol> inputSignals, ArrayList<SignalTypeSymbol> outputSignals) {
        super(id, declarationNode);
        this.inputSignals = inputSignals;
        this.outputSignals = outputSignals;
    }

    public DeviceTypeSymbol(DefDeviceNode defDeviceNode, SymbolTable symbolTable) {
        super(defDeviceNode.getID(), defDeviceNode);
        inputSignals = new ArrayList<>();
        outputSignals = new ArrayList<>();

        for(InputNode inNode : defDeviceNode.getInputs())
            inputSignals.add(getInputSymbol(inNode, symbolTable));

        for(OutputNode outNode : defDeviceNode.getOutputs())
            outputSignals.add(getOutputSymbol(outNode, symbolTable));
    }

    private static SignalTypeSymbol getInputSymbol(InputNode inNode, SymbolTable symbolTable){
        Optional<Symbol> retrievedSymbol = symbolTable.getSymbol(inNode.ID);
        if(retrievedSymbol.isPresent() && retrievedSymbol.get() instanceof SignalTypeSymbol)
            return ((SignalTypeSymbol) retrievedSymbol.get());
        else
            throw new NoSuchSignalCompileError(inNode.ID, inNode.getLineNumber());
    }

    private static SignalTypeSymbol getOutputSymbol(OutputNode outNode, SymbolTable symbolTable){
        Optional<Symbol> retrievedSymbol = symbolTable.getSymbol(outNode.ID);
        if(retrievedSymbol.isPresent() && retrievedSymbol.get() instanceof SignalTypeSymbol)
            return ((SignalTypeSymbol) retrievedSymbol.get());
        else
            throw new NoSuchSignalCompileError(outNode.ID, outNode.getLineNumber());
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

    @Override
    public String toString() {
        StringBuilder inputs = new StringBuilder();
        StringBuilder outputs = new StringBuilder();

        for(Symbol s : inputSignals)
            inputs.append(s.id).append(", ");

        for(Symbol s : outputSignals)
            outputs.append(s.id).append(", ");

       if(inputs.length() > 0) inputs.delete(inputs.length() - 2, inputs.length());
       if(outputs.length() > 0) outputs.delete(outputs.length() - 2, outputs.length());

        return "Device: " + id + " - Inputs(" +
                inputs.toString() + "), Outputs(" + outputs.toString() + ")";
    }
}
