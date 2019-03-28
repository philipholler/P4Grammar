package Nodes.Base;

import java.util.ArrayList;

public abstract class ListNode extends Node{
    ArrayList<Node> children;

    public ListNode(ArrayList<Node> children) {
        this.children = children;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void addChild(Node child){
        children.add(child);
    }
}
