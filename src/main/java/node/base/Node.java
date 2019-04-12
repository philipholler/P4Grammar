package node.base;

import org.antlr.v4.runtime.ParserRuleContext;
import visitor.ASTBaseVisitor;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Node implements Visitable{

    ArrayList<Node> children = new ArrayList<>();
    ParserRuleContext context;

    public Node(ParserRuleContext context, ArrayList<Node> children) {
        this.children = children;
        this.context = context;
    }

    public Node(ParserRuleContext context, Node...children) {
        if(children != null)
            this.children = new ArrayList<>(Arrays.asList(children));

        this.context = context;
    }

    /**
     * Philip, 31.03.2019
     * This method is used to create a pretty-printed AST. All node types need to implement their own way of
     * printing.
     * @param indentation Used for the recursive call in the node types.
     * @return String of the AST.
     */
    public abstract String getTreeString(int indentation);

    public ArrayList<Node> getChildren() {
        return children;
    }

    public ParserRuleContext getContext() {
        return context;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public int getLineNumber(){
        return context.getStart().getLine();
    }

    @Override
    public <T>T accept(ASTBaseVisitor<? extends T> astBaseVisitor) {
        return astBaseVisitor.visit(this);
    }
}
