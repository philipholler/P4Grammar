package semantics;

import node.base.Node;

import java.util.ArrayList;

public class FunctionSymbol extends Symbol {

    ArrayList<FieldSymbol> parameters;

    public FunctionSymbol(String id, Node declarationNode, ArrayList<FieldSymbol> parameters) {
        super(id, declarationNode);
        this.parameters = parameters;
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
