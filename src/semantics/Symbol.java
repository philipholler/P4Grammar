package semantics;

import node.base.Node;

public abstract class Symbol {

    protected String id;
    protected Node declarationNode;

    public Symbol(String id, Node declarationNode) {
        this.id = id;
        this.declarationNode = declarationNode;
    }

    public String getID(){
        return id;
    }

    public Node getDelcarationNode(){
        return declarationNode;
    }

}
