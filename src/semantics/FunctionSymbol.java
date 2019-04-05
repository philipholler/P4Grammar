package semantics;

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
        StringBuilder string = new StringBuilder(id + " (");

        for(FieldSymbol s : parameters){
            string.append(s.id).append(",");
        }
        // Delete last comma
        string.deleteCharAt(string.length() - 1);
        string.append(")");

        return string.toString();
    }
}
