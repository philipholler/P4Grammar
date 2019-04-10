package visitor;

import exceptions.user_side.ExpressionTypeException;
import node.BlockNode;
import node.Statements.AssignmentNode;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.IDNode;
import node.Statements.Expression.LiteralValues.LiteralValueNode;
import node.Statements.Expression.MultiExprNode;
import node.VarDeclNode;
import node.base.Node;
import semantics.FieldSymbol;
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
    public Void visit(AssignmentNode node) {
        Optional<Symbol> optSymbol = st.getSymbol(node.getID());
        if(optSymbol.isPresent()){
            FieldSymbol symbol = (FieldSymbol) optSymbol.get();
            if(!isTypeCorrect(node.getExpr(), symbol.getTypeID())){
                throw new ExpressionTypeException("Assigning expr to variable with different type", node.getLineNumber());
            }
        }

        return super.visit(node);
    }

    @Override
    public Void visit(VarDeclNode node) {
        // Check if all values inside the expression have the same type and the type of the variable.
        if(!isTypeCorrect(node.getExpr(), node.getVarType())){
            throw new ExpressionTypeException("Expression has more types in it or doesn't match variable type.", node.getLineNumber());
        }

        // Set the type of the entire expr
        node.getExpr().setType(node.getVarType());

        return super.visit(node);
    }

    /**
     * Checks if all of the literal values inside the expression node is of the expectedType "expectedType"
     * @param expr expressionNode containing the expr.
     * @param expectedType expectedType to check for
     * @return true if all literal values match the expectedType.
     */
    public boolean isTypeCorrect(Node expr, String expectedType){
        // Check if the expr is simply a literal value
        if(expr instanceof LiteralValueNode){
            if(!((LiteralValueNode) expr).getType().equals(expectedType)){
                throw new ExpressionTypeException("Expression has different type than expected. Got: " +
                        ((LiteralValueNode) expr).getType() +
                        " Expected: " +
                        expectedType
                        , expr.getLineNumber());
            }
        }

        // Check if the expression is simply an IDnode variable
        isIDSameType(expr, expectedType);

        // check if children have the expected type
        for (Node node: expr.getChildren()) {
            if(node instanceof AddExprNode || node instanceof MultiExprNode){
                isTypeCorrect(node, expectedType);
            } else if (node instanceof LiteralValueNode){
                if(!((LiteralValueNode) node).getType().equals(expectedType)){
                    throw new ExpressionTypeException("Expression has different type than expected. Got: " +
                            ((LiteralValueNode) expr).getType() +
                            " Expected: " +
                            expectedType
                            , expr.getLineNumber());
                }
            }
            // Check if it is a variable and the type of the variable
            isIDSameType(node, expectedType);
        }
        return true;
    }

    /**
     * Helper function for the isTypeCorrect
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
