package semantics;

import node.base.Node;

import java.util.Objects;

public class FieldSymbol extends Symbol{

    private VarType type;

    public FieldSymbol(String name, Node declarationNode, VarType type) {
        super(name, declarationNode);
        this.type = type;
    }

    public VarType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldSymbol fieldSymbol = (FieldSymbol) o;
        return Objects.equals(id, fieldSymbol.id) &&
                type == fieldSymbol.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "FieldSymbol{" +
                "name='" + id + '\'' +
                ", type=" + type +
                ", declarationNode=" + declarationNode +
                '}';
    }

}
