package Nodes.Base;

public abstract class UnaryNode extends Node{
    Node child;

    public UnaryNode(Node child) {
        this.child = child;
    }

    public Node getChild() {
        return child;
    }
}
