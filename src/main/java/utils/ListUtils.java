package utils;

import node.base.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListUtils {

    public static <T extends Node, C extends Node> ArrayList<Node> combineNodeLists(ArrayList<T> listOne, ArrayList<C> listTwo){
        ArrayList<Node> combined  = new ArrayList<>();
        combined.addAll(listOne);
        combined.addAll(listTwo);
        return combined;
    }


}
