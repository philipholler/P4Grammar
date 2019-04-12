package semantics;

import node.DevDeclNode;
import node.Function.InputParamNode;
import node.VarDeclNode;
import node.base.Node;
import node.define_nodes.Signal.EnumNode;

import java.util.Objects;

public class FieldSymbol extends Symbol{

    private String typeID;

    public FieldSymbol(Node declarationNode, String name, String typeID) {
        super(name, declarationNode);
        this.typeID = typeID;
    }

    public FieldSymbol(InputParamNode param) {
        super(param.getId(), param);
        this.typeID = param.getType();
    }

    public FieldSymbol(EnumNode enumNode) {
        super(enumNode.getID(), enumNode);
        this.typeID = enumNode.getType();
    }

    public FieldSymbol(DevDeclNode device) {
        super(device.getID(), device);
        this.typeID = device.getType();
    }

    public FieldSymbol(VarDeclNode variable) {
        super(variable.getID(), variable);
        this.typeID = variable.getVarType();
    }

    public String getTypeID() {
        return typeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldSymbol fieldSymbol = (FieldSymbol) o;
        return Objects.equals(id, fieldSymbol.id) &&
                typeID == fieldSymbol.typeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeID);
    }

    @Override
    public String toString() {
        return  typeID + " " + id;
    }

}
