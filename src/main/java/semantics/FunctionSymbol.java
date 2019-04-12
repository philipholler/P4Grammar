package semantics;

import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.base.Node;

import java.util.ArrayList;

public class FunctionSymbol extends Symbol {

    private final String returnType;
    ArrayList<FieldSymbol> parameters;

    public FunctionSymbol(String id, Node declarationNode, String returnType, ArrayList<FieldSymbol> parameters) {
        super(id, declarationNode);
        this.parameters = parameters;
        this.returnType = returnType;
    }

    public FunctionSymbol(FunctionNode fNode) {
        super(fNode.getId(), fNode);
        this.returnType = fNode.getReturnType();
        this.parameters = createParamSymbols(fNode.getInputParams());
    }

    private ArrayList<FieldSymbol> createParamSymbols(ArrayList<InputParamNode> inputNodes){
        ArrayList<FieldSymbol> params = new ArrayList<>();
        for(InputParamNode paramNode : inputNodes){
            params.add(new FieldSymbol(paramNode, paramNode.getId(), paramNode.getType()));
        }
        return params;
    }

    public ArrayList<FieldSymbol> getParameters() {
        return parameters;
    }

    public boolean hasParameter(String ID){
        for(FieldSymbol param : parameters){
            if(param.id.equals(ID)) return true;
        }

        return false;
    }

    public String getReturnType() {
        return returnType;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(returnType + " " + id + " (");

        for(FieldSymbol s : parameters){
            string.append(s.getTypeID()).append(" ").append(s.id).append(", ");
        }
        // Delete last comma
        string.delete(string.length() - 2, string.length());
        string.append(")");

        return string.toString();
    }
}
