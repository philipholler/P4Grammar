package visitor;

import exceptions.user_side.ArgumentWrongTypeException;
import exceptions.user_side.DivideOrMultiStringExpection;
import exceptions.user_side.ExpressionTypeException;
import exceptions.user_side.SignalLiteralNotDeclaredException;
import node.BlockNode;
import node.Statements.AssignmentNode;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.ExpressionNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.IDNode;
import node.Statements.Expression.LiteralValues.LiteralValueNode;
import node.Statements.Expression.MultiExprNode;
import node.VarDeclNode;
import node.base.Node;
import semantics.*;

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

            // Check that the correct number of variables are parsed
            if (funcSym.getParameters().size() == node.getArguments().size()) {
                // Check that all variables have the same type
                for (int i = 0; i < node.getArguments().size(); ++i) {
                    // If the argument is itself another function call, visit it first to make sure, that it's type
                    // is declared
                    if (node.getArguments().get(i) instanceof FuncCallNode) {
                        super.visit(node);
                    }
                    if(!isExprTypeCorrect((ExpressionNode)node.getArguments().get(i), funcSym.getParameters().get(i).getTypeID())){
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

        // If the ExpressionNode has one of the following types, it can simply check the type against the expected type
        if(expr instanceof LiteralValueNode ||
                expr instanceof FuncCallNode ||
                expr instanceof GetFuncNode ||
                expr instanceof SetFuncNode ||
                expr instanceof IDNode
        ){
            if(!((ExpressionNode) expr).getType().equals(expectedType)){
                throw new ExpressionTypeException("Expression has different type than expected. Got: " +
                        ((ExpressionNode) expr).getType() +
                        " Expected: " +
                        expectedType
                        , expr.getLineNumber());
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
            if(signal.getTYPE() == SignalTypeSymbol.SIGNAL_TYPE.INT_RANGE &&
                    !isExprTypeCorrect(node.getExpr(), SymbolTable.INT_TYPE_ID)){
                throw new ExpressionTypeException("Expression does not match range type. Expected '" +
                        SymbolTable.INT_TYPE_ID +
                        "' got: '" +
                        node.getType() +
                        "'"
                        );
            }
            // Check if the node has a float range and the expr also evaluates a float
            if(signal.getTYPE() == SignalTypeSymbol.SIGNAL_TYPE.FLOAT_RANGE &&
                    !isExprTypeCorrect(node.getExpr(), SymbolTable.FLOAT_TYPE_ID)){
                throw new ExpressionTypeException("Expression does not match range type. Expected '" +
                        SymbolTable.FLOAT_TYPE_ID +
                        "' got: '" +
                        node.getType() +
                        "'"
                );
            }

            // If the signal uses signal Literals, check that the value set is also an enum for the given signal
            // Since signal literal will still be an expr, it will just be a leaf IDNode from which, we can get the value.
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
}
