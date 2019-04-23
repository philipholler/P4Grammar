package visitor;

import node.*;
import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.IDNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.Operator;
import node.Statements.IfStmtNode;
import node.Statements.LogicalExpression.ComparisonExprNode;
import node.Statements.PrintNode;
import node.Statements.ReturnNode;
import node.base.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class JasminVisitor extends ASTBaseVisitor {
    private HashMap<String,Integer> variables = new HashMap<>();
    private int labels = 0;

    @Override
    public Object visit(InitNode node) {
        //init node acts as main in jasmine
        String body ="";
        for(Node n: node.getChildren()){
            body += visit(n);
        }
        String main = ".method public static main([Ljava/lang/String;)V \n" +
                " .limit stack 100\n" +
                " .limit locals 100\n" +
                body +
                " return\n" +
                ".end method";
        return main;
    }

    @Override
    public Object visit(DeclsNode node) {
        String declarations = "";
        //VISIT ALL FUNCTIONS FIRST
        for (Node n : node.getChildren()) {
            if(n instanceof FunctionNode){
                declarations += visit(n);
            }
        }
        //THEN VISIT THE REST
        for(Node n : node.getChildren()){
            if(!(n instanceof FunctionNode)){
                declarations+= visit(n);
            }
        }
        return declarations;
    }

    @Override
    public Object visit(InputParamNode node) {
        return ":( \n";
    }

    @Override
    public Object visit(IDNode node) {
        if(variables.containsKey(node.getID())){
            return "iload " + variables.get(node.getID()) +"\n";
        }
        variables.put(node.getID(),variables.size());
        return "iload " + variables.get(node.getID()) +"\n";
    }

    @Override
    public Object visit(BlockNode node) {
        String body="";
        for(Node n : node.getChildren()){
            body +=visit(n);
        }
        return body+ "\n";
    }

    @Override
    public Object visit(IfStmtNode node) {
        //Create labels for true, false and the end label
        String tlabel = nextLabel(), flabel = nextLabel(), elabel = nextLabel();
        List<String> labelarr = Arrays.asList(flabel,tlabel,elabel);
        String condition ="";
        String body="";
        //Make sure we visit the ComparisonExprNode first
        for(Node n: node.getChildren()){
            if(n instanceof ComparisonExprNode){
                condition += visit(n) + flabel + "\n";
            }
        }
        condition+= " goto " + tlabel + "\n";
        //Then we create the body
        int i =0;
        for(Node n: node.getChildren()){
            //ignore comparisonexprnode
            if(!(n instanceof  ComparisonExprNode)){
                body+= labelarr.get(i) +": "+ "\n" + visit(n);
                if(i ==0){
                    body+= "goto " + elabel +"\n";
                }
                i++;
            }
        }
        return condition + body + elabel+":"+"\n";
    }

    @Override
    public Object visit(ComparisonExprNode node) {
        //load the comparison values
        //visit left and right node
        String comparisonVals ="";
        comparisonVals+=visit(node.getLeftChild());
        comparisonVals+=visit(node.getRightChild());
        return comparisonVals + "if"+getComparisonOperator(node) + " ";
    }
    @Override
    public Object visit(ReturnNode node) {
        String body ="";
        for(Node n: node.getChildren()){
            body+=visit(n);
        }
        return body;
    }

    @Override
    public Object visit(ProgramNode node) {
        String body ="";
        for (Node n: node.getChildren()) {
            body += visit(n);
        }
        return  ".class public PivotClass \n" +
                ".super java/lang/Object\n"+
                body + "\n";
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
        if (node.getOperator() == Operator.PLUS){
            return operands + "iadd\n";
        }
        else{
            return operands + "isub\n";
        }

    }

    @Override
    public Object visit(PrintNode node) {
        String decl = " getstatic java/lang/System/out Ljava/io/PrintStream;\n";
        String invoke = " invokevirtual java/io/PrintStream/println(I)V\n";
        String body="";
        for(Node n: node.getChildren()){
            body +=visit(n);
        }
        return decl + body +invoke;

    }

    @Override
    public Object visit(VarDeclNode node) {
        storeVariable(node.getID());
        return visit(node.getChild()) + "istore " + variables.get(node.getID())+ "\n";
    }
    private String getComparisonOperator(ComparisonExprNode node){
        switch (node.getOp()){
            case GREATERTHAN: return "gt";
            case EQUALTO: return "eq";
            case NOTEQUAL: return "ne";
            case SMALLERTHAN: return "lt";
            case GREANTHANEQUAL: return "ge";
            case SMALLERTHANEQUAL: return "le";
            default: throw new RuntimeException("Undefined ComparisonNode Given");
        }
    }
    private void storeVariable(String id){
            variables.put(id, variables.size());
    }
    private String nextLabel(){
        return "L" +labels++;
    }
}