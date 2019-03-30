package visitor;

import node.base.ListNode;
import node.base.Node;
import node.base.UnaryNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class VisitorBase extends AbstractVisitor{

    public abstract Object defaultVisit(Node node);

    public Object visit(Object node) {
        if (node == null)
        {
            System.out.println("Attempted to visit a null object!");
            new Exception().printStackTrace(); // Print stack trace for debugging purposes
            return null;
        }


        // Get best method for this object
        Method method = getMethodFor(node);

        // Attempt to invoke the method
        try
        {
            return method.invoke(this, node);
        }
        catch (IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    protected void visitChildren(UnaryNode node) {
        if (node.getChild() != null)
            visit(node.getChild());
    }

    protected void visitChildren(ListNode node) {
        List<Node> children = node.getChildren();

        for (int i = 0; i < children.size(); ++i) {
            visit(children.get(i));
            if (children.get(i) == null) {
                children.remove(i);
            }
            else{
                i++;
            }
        }
    }

    private Method getMethodFor(Object node) {
        Method ans = null;

        // Find a method which matches the class of the node
        Class currentClass = node.getClass();
        while (ans == null && currentClass != Object.class && currentClass != Node.class) {
            try {
                ans = this.getClass().getMethod("visit", currentClass);
            }
            catch (NoSuchMethodException e) {
                // This may happen if the implementation of the visitor does implement a visitor for all nodes
            }

            // If no appropriate method was found, look in its superclass
            if (ans == null)
                currentClass = currentClass.getSuperclass();
        }

        // If no method was found, return default method
        if (ans == null) {
            try {
                ans = this.getClass().getMethod("defaultVisit", Node.class);
            }
            catch (NoSuchMethodException e) {
                // Should not happen since defaultVisit is abstract and must be implemented
            }
        }
        return ans;
    }
}
