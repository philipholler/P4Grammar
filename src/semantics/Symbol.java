package semantics;

import javafx.css.Declaration;
import node.base.Node;

import java.util.Objects;

public class Symbol {

    private String name;
    private VarType type;
    private Node declarationNode;

    public Symbol(String name, VarType type, Node declarationNode) {
        this.name = name;
        this.type = type;
        this.declarationNode = declarationNode;
    }

    public String getName() {
        return name;
    }

    public VarType getType() {
        return type;
    }

    public Node getDeclarationNode() {
        return declarationNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return Objects.equals(name, symbol.name) &&
                type == symbol.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", declarationNode=" + declarationNode +
                '}';
    }

}
