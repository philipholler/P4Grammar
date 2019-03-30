package node.base;

import visitor.Visitable;

public abstract class Node implements Visitable {


    public abstract String getTreeString(int indentation);

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
