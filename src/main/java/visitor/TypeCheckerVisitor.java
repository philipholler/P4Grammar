package visitor;

import exceptions.userside.ArgumentWrongTypeException;
import exceptions.userside.DivideOrMultiStringExpection;
import exceptions.userside.ExpressionTypeException;
import exceptions.user_side.*;
import node.BlockNode;
import node.ProgramNode;
import node.Statements.AssignmentNode;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.ExpressionNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.IDNode;
import node.Statements.Expression.LiteralValues.LiteralValueNode;
import node.Statements.Expression.MultiExprNode;
import node.Statements.LogicalExpression.ComparisonExprNode;
import node.TimeNodes.DateNode;
import node.TimeNodes.NowNode;
import node.TimeNodes.TimeNode;
import node.VarDeclNode;
import node.base.Node;
import semantics.*;

import java.util.Optional;

/**
 * This visitor checks that all statements involving types are type correct.
 * For example that a variable declaration of the type int also takes and expression, that evaluates an int.
 * - Philip
 */

public class TypeCheckerVisitor extends ASTBaseVisitor<Void>{
    SymbolTable st;

    public TypeCheckerVisitor() {
    }

    @Override
    public Void visit(ProgramNode node) {
        this.st = node.getSt();
        st.resetScope();
        return super.visit(node);
    }

    @Override
    public Void visit(FuncCallNode node) {
        // Get the function
        Optional<FunctionSymbol> sym = st.getFunctionSymbol(node.getID());
        if(sym.isPresent()) {
            FunctionSymbol funcSym = sym.get();
            // Check that the correct number of variables are parsed
            if (funcSym.getParameters().size() == node.getArguments().size()) {
                // Check that all variables have the same type
                for (int i = 0; i < node.getArguments().size(); ++i) {
                    // Every argument (an expr) should have the same type as the formal parameters gotten from the funcSym.
                    // The order of the parameters MATTERS.
                    if(!((ExpressionNode)node.getArguments().get(i)).getType().equals(funcSym.getParameters().get(i).getTypeID())){
                        throw new ArgumentWrongTypeException("Argument wrong type. Expected '" +
                                funcSym.getParameters().get(i).getTypeID() +
                                "' got: '" +
                                ((ExpressionNode) node.getArguments().get(i)).getType() +
                                "'"
                                , node.getLineNumber());
                    }
                }
            }
        } else {
            // if the function is not present in the symbol table, throw exception.
            throw new FunctionNotDeclaredException("Function '" +
                    node.getID() +
                    "' not declared.",
                    node.getLineNumber()
            );
        }

        return super.visit(node);
    }

    @Override
    public Void visit(AssignmentNode node) {
        Optional<Symbol> optSymbol = st.getSymbol(node.getID());
        if(optSymbol.isPresent()){
            FieldSymbol symbol = (FieldSymbol) optSymbol.get();
            if(!symbol.getTypeID().equals(node.getExpr().getType())){
                throw new ExpressionTypeException("Assigning expr to variable with different type. Expected '" +
                        symbol.getTypeID() +
                        "' got '" +
                        node.getExpr().getType() +
                        "'"
                        , node.getLineNumber());
            }
        }

        return super.visit(node);
    }

    @Override
    public Void visit(VarDeclNode node) {
        // If the expression does not have the same type as the variable being declared, throw exception.
        if(!node.getExpr().getType().equals(node.getVarType())){
            throw new ExpressionTypeException("Expression has more types in it or doesn't match variable type.", node.getLineNumber());
        }

        return super.visit(node);
    }

    /**
     * Checks if an expression is type correct, meaning all values have the same type.
     * @param expr An ExpressionNode
     * @param expectedType the type, that all parts must have
     * @return true, if all parts have the same type
     */
    public boolean isExprTypeCorrect(Node expr, String expectedType){
        // Check addexpr and multiexpr by checking their children
        if(expr instanceof AddExprNode || expr instanceof MultiExprNode){
            for(Node n : expr.getChildren()){
                // Check the children. Not if the child is a funcCall node, since they are already checked in the
                // visit(FuncCallNode)
                if(!(n instanceof FuncCallNode) && !isExprTypeCorrect(n, expectedType)){
                    throw new ExpressionTypeException("Expression has different type than expected. Got: " +
                            ((ExpressionNode) expr).getType() +
                            " Expected: " +
                            expectedType
                            , expr.getLineNumber());
                }
            }
        }
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

        // If the method gets to here without exception, the expression has the expected value
        if(expr instanceof ExpressionNode){
            ((ExpressionNode) expr).setType(expectedType);
        }

        return true;
    }

    /**
     * Helper function for the isExprTypeCorrect
     * Check if an SIGNAL_ID node (i.e. a variable) is also of the same type as the expected type
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

    @Override
    public Void visit(SetFuncNode node) {
        // Check that the enum is actually contained in the signal definition
        Optional<Symbol> symbol = st.getSymbol(node.getSignalID());
        if(symbol.isPresent()){
            SignalTypeSymbol signal = (SignalTypeSymbol) symbol.get();
            // If the signal is an int range and got an expression of the type int.
            if(signal.getTYPE() == SignalTypeSymbol.SIGNAL_TYPE.INT_RANGE && !node.getExpr().getType().equals(SymbolTable.INT_TYPE_ID)){
                throw new ExpressionTypeException("Expression does not match range type. Expected '" +
                        SymbolTable.INT_TYPE_ID +
                        "' got: '" +
                        node.getExpr().getType() +
                        "'",
                        node.getExpr().getLineNumber()
                        );
            }
            // Check if the node has a float range and the expr also evaluates a float
            if(signal.getTYPE() == SignalTypeSymbol.SIGNAL_TYPE.FLOAT_RANGE && !node.getExpr().getType().equals(SymbolTable.FLOAT_TYPE_ID)){
                throw new ExpressionTypeException("Expression does not match range type. Expected '" +
                        SymbolTable.FLOAT_TYPE_ID +
                        "' got: '" +
                        node.getExpr().getType() +
                        "'",
                        node.getExpr().getLineNumber()
                );
            }

            // If the signal uses signal Literals, check that the signal literal set in the source code is actually
            // present in the signal definition.
            // Since ambiguity could not be avoided between Signal literal ID and expr, the signal literal is passed as an IDNode expr.
            if(signal.getTYPE() == SignalTypeSymbol.SIGNAL_TYPE.LITERALS){
                String signalLiteral = ((IDNode)node.getExpr()).getID();
                if(!signal.containsSymbol(signalLiteral)) {
                    throw new SignalLiteralNotDeclaredException("Signal literal '" + signalLiteral + "' not declared", node.getLineNumber());
                }
            }
        }

        return super.visit(node);
    }

    @Override
    public Void visit(MultiExprNode node) {
        if(node.getType().equals(SymbolTable.STRING_TYPE_ID)){
            throw new DivideOrMultiStringExpection("Cannot divide or multiply strings", node.getLineNumber());
        }
        return super.visit(node);
    }

    @Override
    public Void visit(ComparisonExprNode node) {
        // If both sides are expressions.
        if(node.getLeftChild() instanceof ExpressionNode && node.getRightChild() instanceof ExpressionNode){
            // If the expressions do not have the same type throw error
            if(!((ExpressionNode) node.getLeftChild()).getType().equals(((ExpressionNode) node.getRightChild()).getType())){
                throw new DifferentTypesComparisonException("Cannot compare types: '" +
                        ((ExpressionNode) node.getLeftChild()).getType() +
                        "' with type '" +
                        ((ExpressionNode) node.getRightChild()).getType(),
                        node.getLineNumber()
                        );
            }
            return super.visit(node);
        }
        // If the left node is a Timenode (nownode, timenode or datenode) and the right child is not.
        if((node.getLeftChild() instanceof NowNode || node.getLeftChild() instanceof TimeNode || node.getLeftChild() instanceof DateNode) &&
            !(node.getRightChild() instanceof NowNode || node.getRightChild() instanceof TimeNode || node.getRightChild() instanceof DateNode)){
            throw new DifferentTypesComparisonException("Cannot compare type '" +
                    node.getLeftChild().getClass().getSimpleName().replace("Node", "") +
                    "' with type '" +
                    node.getRightChild().getClass().getSimpleName().replace("Node", "") +
                    "'",
                    node.getLineNumber());
        }
        // If the left child is not a time node, but the right child is.
        if(!(node.getLeftChild() instanceof NowNode || node.getLeftChild() instanceof TimeNode || node.getLeftChild() instanceof DateNode) &&
                (node.getRightChild() instanceof NowNode || node.getRightChild() instanceof TimeNode || node.getRightChild() instanceof DateNode)){
            throw new DifferentTypesComparisonException("Cannot compare type '" +
                    node.getLeftChild().getClass().getSimpleName().replace("Node", "") +
                    "' with type '" +
                    node.getRightChild().getClass().getSimpleName().replace("Node", "") +
                    "'",
                    node.getLineNumber());
        }

        // Cannot compare now to now, since it will always be true.
        if(node.getLeftChild() instanceof NowNode && node.getRightChild() instanceof NowNode){
            throw new DifferentTypesComparisonException("Cannot compare type '" +
                    node.getLeftChild().getClass().getSimpleName().replace("Node", "") +
                    "' with type '" +
                    node.getRightChild().getClass().getSimpleName().replace("Node", "") +
                    "'. Comparing 'Now' to 'Now' will always be true.",
                    node.getLineNumber());
        }

        return super.visit(node);
    }
}
