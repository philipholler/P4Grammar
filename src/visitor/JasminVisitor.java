package visitor;

import node.DeclsNode;
import node.ProgramNode;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.VarDeclNode;
import node.base.Node;

import java.util.HashMap;
import java.util.HashSet;

import java.util.Set;

public class JasminVisitor extends ASTBaseVisitor {
    @Override
    public Object visit(DeclsNode node) {
        String declarations = "";
        for (Node n : node.getChildren()) {
            if (n instanceof VarDeclNode) {
                declarations +=
                        " getstatic java/lang/System/out Ljava/io/PrintStream; \n" +
                        visit(n) +"\n" +
                        " invokevirtual java/io/PrintStream/println(I)V \n \n";
            }
        }
        return declarations;
    }

    @Override
    public Object visit(ProgramNode node) {
        String body ="";
        for (Node n: node.getChildren()) {
            body += visit(n);
        }
        return  ".class public PivotClass\n" +
                ".super java/lang/Object\n"+
                ".method public static main([Ljava/lang/String;)V \n" +
                " .limit stack 100\n" +
                " .limit locals 100\n" +
                body + "\n"
                +" return\n" +
                ".end method";
    }

    @Override
    public Object visit(IntegerNode node) {
        return "ldc " + node.getVal() + "\n";
    }

    @Override
    public Object visit(AddExprNode node) {
        String operands="";
        for(Node n: node.getChildren()){
            operands += visit(n);
        }
        return operands + "iadd\n";
    }

    @Override
    public Object visit(VarDeclNode node) {
        return visit(node.getChild());
    }
}