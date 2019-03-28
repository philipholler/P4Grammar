package Nodes.Base;

public abstract class BinaryNode extends Node{
    Node LeftChild;
    Node RightChild;

    public BinaryNode(Node leftChild, Node rightChild) {
        LeftChild = leftChild;
        RightChild = rightChild;
    }

    public Node getLeftChild() {
        return LeftChild;
    }

    public Node getRightChild() {
        return RightChild;
    }
}
