package node.base;

public abstract class Node implements Visitable {

    /**
     * Philip, 31.03.2019
     * This method is used to create a pretty-printed AST. All node types need to implement their own way of
     * printing.
     * @param indentation Used for the recursive call in the node types.
     * @return String of the AST.
     */
    public abstract String getTreeString(int indentation);

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
