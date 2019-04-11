package visitor;

import exceptions.user_side.ArgumentWrongTypeException;
import exceptions.user_side.ExpressionTypeException;
import node.BlockNode;
import node.Statements.AssignmentNode;
import node.Statements.Expression.ExpressionNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.IDNode;
import node.Statements.Expression.LiteralValues.LiteralValueNode;
import node.VarDeclNode;
import node.base.Node;
import semantics.FieldSymbol;
import semantics.FunctionSymbol;
import semantics.Symbol;
import semantics.SymbolTable;

import java.util.Optional;

public class TypeCheckerVisitor extends ASTBaseVisitor<Void>{
    SymbolTable st;

    public TypeCheckerVisitor(SymbolTable st) {
        this.st = st;
        this.st.resetScope();
    }

    public SymbolTable getSt() {
        return st;
    }

    @Override
    public Void visit(FuncCallNode node) {
        Optional<FunctionSymbol> sym = st.getFunctionSymbol(node.getID());
        if(sym.isPresent()) {
            FunctionSymbol funcSym = sym.get();
            node.setType(funcSym.getReturnType());

            // Check that the correct number of variables are parsed
            if (funcSym.getParameters().size() == node.getArguments().size()) {
                // Check that all variables have the same type
                for (int i = 0; i < node.getArguments().size(); ++i) {
                    // If the argument is itself another function call, visit it first to make sure, that it's type
                    // is declared
                    if (node.getArguments().get(i) instanceof FuncCallNode) {
                        super.visit(node);
                    }
                    if (!funcSym.getParameters().get(i).getTypeID().equals(((ExpressionNode) node.getArguments().get(i)).getType())) {
                        throw new ArgumentWrongTypeException("Argument wrong type. Expected '" +
                                funcSym.getParameters().get(i).getTypeID() +
                                "' got: '" +
                                ((ExpressionNode) node.getArguments().get(i)).getType() +
                                "'"
                                , node.getLineNumber());
                    }
                }
            }
        }

        return super.visit(node);
    }

    @Override
    public Void visit(AssignmentNode node) {
        Optional<Symbol> optSymbol = st.getSymbol(node.getID());
        if(optSymbol.isPresent()){
            FieldSymbol symbol = (FieldSymbol) optSymbol.get();
            if(!isExprTypeCorrect(node.getExpr(), symbol.getTypeID())){
                throw new ExpressionTypeException("Assigning expr to variable with different type", node.getLineNumber());
            }
        }

        return super.visit(node);
    }

    @Override
    public Void visit(VarDeclNode node) {
        // Check if all values inside the expression have the same type and the type of the variable.
        if(!isExprTypeCorrect(node.getExpr(), node.getVarType())){
            throw new ExpressionTypeException("Expression has more types in it or doesn't match variable type.", node.getLineNumber());
        }

        // Set the type of the entire expr
        node.getExpr().setType(node.getVarType());

        return super.visit(node);
    }

    /**
     * Checks if an expression is type correct, meaning all values have the same type.
     * @param expr An ExpressionNode
     * @param expectedType the type, that all parts must have
     * @return true, if all parts have the same type
     */
    public boolean isExprTypeCorrect(Node expr, String expectedType){
        // For literal value
        if(expr instanceof LiteralValueNode){
            if(!((LiteralValueNode) expr).getType().equals(expectedType)){
                throw new ExpressionTypeException("Expression has different type than expected. Got: " +
                        ((LiteralValueNode) expr).getType() +
                        " Expected: " +
                        expectedType
                        , expr.getLineNumber());
            }
        }
        // Check the IDNode type
        if(expr instanceof IDNode){
            if(!isIDSameType(expr, expectedType)){
                throw new ExpressionTypeException("Expression has different type than expected. Got: " +
                        ((IDNode) expr).getType() +
                        " Expected: " +
                        expectedType
                        , expr.getLineNumber());
            }
        }
        // Check that the funcCall returns a value of the expected type
        if(expr instanceof FuncCallNode){
            if(!((FuncCallNode) expr).getType().equals(expectedType)){
                throw new ExpressionTypeException("Expression has different type than expected. Got: " +
                        ((FuncCallNode) expr).getType() +
                        " Expected: " +
                        expectedType
                        , expr.getLineNumber());
            }
        }
        // Check if the get function returns a value of the expected type
        if(expr instanceof GetFuncNode){
            if(!((GetFuncNode) expr).getType().equals(expectedType)){
                throw new ExpressionTypeException("Expression has different type than expected. Got: " +
                        ((GetFuncNode) expr).getType() +
                        " Expected: " +
                        expectedType
                        , expr.getLineNumber());
            }
        }

        // Do the same for all children
        for (Node n: expr.getChildren()) {
            // Don't visit a funcCallNodes children. It's returnType is already checked earlier.
            if (!(expr instanceof FuncCallNode)) {
                isExprTypeCorrect(n, expectedType);
            }
        }

        return true;
    }

    /**
     * Helper function for the isExprTypeCorrect
     * Check if an ID node (i.e. a variable) is also of the same type as the expected type
     */
    private Boolean isIDSameType(Node IDNode, String expectedType) {
        if(IDNode instanceof IDNode){
            Optional<Symbol> optSymbol = st.getSymbol(((IDNode) IDNode).getID());
            if (optSymbol.isPresent()) {
                FieldSymbol symbol = (FieldSymbol) optSymbol.get();
                if (!symbol.getTypeID().equals(expectedType)) {
                    throw new ExpressionTypeException("Expression has different type than expected. Got: " +
                            symbol.getTypeID() +
                            " Expected: " +
                            expectedType
                            , IDNode.getLineNumber());
                }
            }
        }
        return true;
    }

    @Override
    public Void visit(BlockNode node) {
        st.openScope(node);

        super.visit(node);

        st.closeScope();

        return null;
    }


}
