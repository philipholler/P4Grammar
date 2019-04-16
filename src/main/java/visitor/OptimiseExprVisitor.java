package visitor;

import node.BlockNode;
import node.ProgramNode;
import node.Statements.AssignmentNode;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.ExpressionNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.Statements.Expression.MultiExprNode;
import node.Statements.LogicalExpression.ComparisonExprNode;
import node.Statements.LogicalExpression.LogicalLiteralNode;
import node.Statements.PrintNode;
import node.Statements.ReturnNode;
import node.VarDeclNode;
import node.base.Node;
import semantics.SymbolTable;

public class OptimiseExprVisitor extends ASTBaseVisitor<Object> {
    SymbolTable st;

    public OptimiseExprVisitor() {
    }

    @Override
    public Object visit(ProgramNode node) {
        this.st = node.getSt();
        st.resetScope();
        return super.visit(node);
    }

    /**
     * Tries to evaluate expressions if no variable is involved.
     * @return a new node with the evaluated value inside or null if the nodes contained variables.
     */
    @Override
    public Object visit(AddExprNode node) {
        ExpressionNode newNode;

        // Check if both are integer
        if(visit(node.getLeftChild()) instanceof IntegerNode && visit(node.getRightChild()) instanceof IntegerNode){
            // Call recursively until a new IntegerNode is returned.
            Integer newValue = (((IntegerNode) visit(node.getLeftChild())).getVal() + ((IntegerNode) visit(node.getRightChild())).getVal());
            newNode = new IntegerNode(node.getContext(), newValue.toString());
            return newNode;
        }
        if(visit(node.getLeftChild()) instanceof FloatNode && visit(node.getRightChild()) instanceof FloatNode){
            // Call recursively until a new FloatNode is returned.
            Float newValue = (((FloatNode) visit(node.getLeftChild())).getVal() + ((FloatNode) visit(node.getRightChild())).getVal());
            newNode = new FloatNode(node.getContext(), newValue.toString());
            return newNode;
        }
        if(visit(node.getLeftChild()) instanceof StringNode && visit(node.getRightChild()) instanceof StringNode){
            // Call recursively until a new StringNode is returned.
            String newValue = "\"" +
                    ((StringNode) visit(node.getLeftChild())).getStringVal() +
                    ((StringNode) visit(node.getRightChild())).getStringVal() +
                    "\"";
            newNode = new StringNode(node.getContext(), newValue);
            return newNode;
        }


        return super.visit(node);
    }

    /**
     * Tries to evaluate expressions if no variable is involved.
     * @return a new node with the evaluated value inside or null if the nodes contained variables.
     */
    @Override
    public Object visit(MultiExprNode node) {
        ExpressionNode newNode;

        // Check if both are integer
        if(visit(node.getLeftChild()) instanceof IntegerNode && visit(node.getRightChild()) instanceof IntegerNode){
            // Call recursively until a new IntegerNode is returned.
            Integer newValue = (((IntegerNode) visit(node.getLeftChild())).getVal() * ((IntegerNode) visit(node.getRightChild())).getVal());
            newNode = new IntegerNode(node.getContext(), newValue.toString());
            return newNode;
        }
        // Check if both are float
        if(visit(node.getLeftChild()) instanceof FloatNode && visit(node.getRightChild()) instanceof FloatNode){
            // Call recursively until a new FloatNode is returned.
            Float newValue = (((FloatNode) visit(node.getLeftChild())).getVal() * ((FloatNode) visit(node.getRightChild())).getVal());
            newNode = new FloatNode(node.getContext(), newValue.toString());
            return newNode;
        }

        return super.visit(node);
    }

    @Override
    public Object visit(AssignmentNode node) {
        var newExpr = visit(node.getExpr());
        if(newExpr instanceof ExpressionNode){
            node.setExpr((ExpressionNode)newExpr);
        }

        return super.visit(node);
    }

    @Override
    public Object visit(VarDeclNode node) {
        var newExpr = visit(node.getExpr());
        if(newExpr instanceof ExpressionNode){
            node.setExpr((ExpressionNode)newExpr);
        }

        return super.visit(node);
    }

    @Override
    public Object visit(FloatNode node) {
        return node;
    }

    @Override
    public Object visit(IntegerNode node) {
        return node;
    }

    @Override
    public Object visit(StringNode node) {
        return node;
    }

    @Override
    public Object visit(ReturnNode node) {
        if(node.getReturnVal() != null){
            var newExpr = visit(node.getReturnVal());
            if(newExpr instanceof ExpressionNode){
                node.setExpr((ExpressionNode)newExpr);
            }
        }

        return super.visit(node);
    }

    @Override
    public Object visit(ComparisonExprNode node) {
        // See if the optimiser finds a new node to put in instead. Null is returned, if no optimisation was found.
        var newLeftChild = visit(node.getLeftChild());
        var newRightChild = visit(node.getRightChild());

        // Check if the optimiser found a node and replace
        if(newLeftChild instanceof ExpressionNode){
            node.setLeftChild((ExpressionNode)newLeftChild);
        }
        if(newRightChild instanceof ExpressionNode){
            node.setRightChild((ExpressionNode) newRightChild);
        }

        return super.visit(node);
    }

    @Override
    public Object visit(LogicalLiteralNode node) {
        return node;
    }

    @Override
    public Object visit(BlockNode node) {
        st.openScope(node);

        super.visit(node);

        st.closeScope();

        return null;
    }

    @Override
    public Object visit(FuncCallNode node) {
        // Check if some of the arguments can be optimised.
        for(int i = 0; i < node.getArguments().size(); ++i){
            if(visit(node.getArguments().get(i)) instanceof ExpressionNode){
                node.setArgument(i, (Node)visit(node.getArguments().get(i)));
            }
        }

        return super.visit(node);
    }

    @Override
    public Object visit(SetFuncNode node) {
        var newExpr = visit(node.getExpr());
        if(newExpr instanceof ExpressionNode){
            node.setExpr((ExpressionNode)newExpr);
        }

        return super.visit(node);
    }

    @Override
    public Object visit(PrintNode node) {
        var newValue = findPrintString(node.getPrintValue());
        if(newValue != null){
            node.setChild(newValue);
        }

        return super.visit(node);
    }

    /**
     * If all expressions are of the type StringNode, and new string can be concatenated from all of those into on StringNode.
     * @param printExpr the expr from the printNode
     * @return a new StringNode containing all strings in one.
     */
    private StringNode findPrintString(ExpressionNode printExpr){
        if(printExpr instanceof AddExprNode){
            if(visit(printExpr) instanceof StringNode){
                return (StringNode) visit(printExpr);
            }
        }

        return null;
    }
}
