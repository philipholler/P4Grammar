package visitor;

import exceptions.user_side.ExpressionTypeException;
import exceptions.user_side.TypeUndefinedCompileError;
import exceptions.user_side.VariableNotInitialisedException;
import node.BlockNode;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.IDNode;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.Statements.Expression.MultiExprNode;
import node.base.Node;
import semantics.*;

import java.util.Optional;

/**
 * This class is meant for assigning types to all nodes of the type "ExpressionNode"
 */

public class TypeAssignmentVisitor extends ASTBaseVisitor<String> {
    SymbolTable st;

    public TypeAssignmentVisitor(SymbolTable st) {
        this.st = st;
        st.resetScope();
    }

    public SymbolTable getSt() {
        return st;
    }

    @Override
    public String visit(FuncCallNode node) {
        Optional<FunctionSymbol> funcSymbol = st.getFunctionSymbol(node.getID());
        if(funcSymbol.isPresent()){
            node.setType(funcSymbol.get().getReturnType());
        }

        // Make sure to visit all children to assign types to them as well.
        super.visit(node);

        return node.getType();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public String visit(SetFuncNode node) {
        Optional<Symbol> signal = st.getSymbol(node.getSignalID());
        Optional<Symbol> device = st.getSymbol(node.getDeviceID());

        // Check that both the device and signal are declared.
        if(signal.isPresent() && device.isPresent() && signal.get() instanceof SignalTypeSymbol){
            SignalTypeSymbol signalSymb = (SignalTypeSymbol) signal.get();

            // Set the expression type of the node depending on the signal type.
            switch (signalSymb.getTYPE()){
                case INT_RANGE:
                    node.setType(SymbolTable.INT_TYPE_ID);
                    visit(node.getExpr());
                    break;
                case FLOAT_RANGE:
                    node.setType(SymbolTable.FLOAT_TYPE_ID);
                    visit(node.getExpr());
                    break;
                case LITERALS:
                    node.setType(signalSymb.getSignalLiterals().get(0).getTypeID());
                    break;
                default:
                    throw new TypeUndefinedCompileError("Could not identify type", node.getLineNumber());
            }
        }

        return node.getType();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public String visit(GetFuncNode node) {
        Optional<Symbol> signal = st.getSymbol(node.getSignalID());
        Optional<Symbol> device = st.getSymbol(node.getDeviceID());

        // Check that both the device and signal are declared.
        if(signal.isPresent() && device.isPresent() && signal.get() instanceof SignalTypeSymbol){
            SignalTypeSymbol signalSymb = (SignalTypeSymbol) signal.get();

            // Set the expression type of the node depending on the signal type.
            switch (signalSymb.getTYPE()){
                case INT_RANGE:
                    node.setType(SymbolTable.INT_TYPE_ID);
                    break;
                case FLOAT_RANGE:
                    node.setType(SymbolTable.FLOAT_TYPE_ID);
                    break;
                case LITERALS:
                    node.setType(signalSymb.getSignalLiterals().get(0).getTypeID());
                    break;
                default:
                    throw new TypeUndefinedCompileError("Could not identify type", node.getLineNumber());
            }
        }
        return node.getType();
    }

    @Override
    public String visit(IntegerNode node) {
        return node.getType();
    }

    @Override
    public String visit(FloatNode node) {
        return node.getType();
    }

    @Override
    public String visit(StringNode node) {
        return node.getType();
    }

    @SuppressWarnings("Duplicates")
    @Override
    public String visit(AddExprNode node) {
        String leftNodeType = visit(node.getLeftChild());
        String rightNodeType = visit(node.getRightChild());

        if(!leftNodeType.equals(rightNodeType)){
            throw new ExpressionTypeException("Type mismatch expected: '" +
                    leftNodeType +
                    "' got: '" +
                    rightNodeType +
                    "'"
                    , node.getLineNumber());
        }

        node.setType(leftNodeType);
        return node.getType();
    }


    @SuppressWarnings("Duplicates")
    @Override
    public String visit(MultiExprNode node) {
        String leftNodeType = visit(node.getLeftChild());
        String rightNodeType = visit(node.getRightChild());

        if(!leftNodeType.equals(rightNodeType)){
            throw new ExpressionTypeException("Type mismatch", node.getLineNumber());
        }

        node.setType(leftNodeType);
        return node.getType();
    }

    @Override
    public String visit(IDNode node) {
        Optional<Symbol> varSymbol = st.getSymbol(node.getID());
        if(varSymbol.isPresent() && varSymbol.get() instanceof FieldSymbol){
            node.setType(((FieldSymbol) varSymbol.get()).getTypeID());
        } else {
            throw new VariableNotInitialisedException("Variable '" + node.getID() + "' not initialised.", node.getLineNumber());
        }

        return node.getType();
    }

    @Override
    public String visit(BlockNode node) {
        st.openScope(node);

        super.visit(node);

        st.closeScope();

        return null;
    }


}
