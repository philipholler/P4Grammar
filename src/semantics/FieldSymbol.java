package semantics;

import node.base.Node;

import java.util.Objects;

public class FieldSymbol extends Symbol{

    private String typeID;

    public FieldSymbol(String name, Node declarationNode, String typeID) {
        super(name, declarationNode);
        this.typeID = typeID;
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
        return "FieldSymbol{" +
                "name='" + id + '\'' +
                ", typeID=" + typeID +
                ", declarationNode=" + declarationNode +
                '}';
    }

}
