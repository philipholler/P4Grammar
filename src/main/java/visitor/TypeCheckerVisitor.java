package visitor;

import exceptions.userside.*;
import node.BlockNode;
import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.Function.FunctionNode;
import node.ProgramNode;
import node.Statements.AssignmentNode;
import node.Statements.Expression.*;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.LogicalExpression.ComparisonExprNode;
import node.Statements.PrintNode;
import node.Statements.ReturnNode;
import node.Statements.Wait.WaitNode;
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
    private SymbolTable st;
    private String lastFunctionVisitedReturnType;

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
                                "' at argument number '" + (i+1) + "'",
                                node.getLineNumber());
                    }
                }
            } else{
                throw new IncorrectArgumentAmountException("Incorrect amount of arguments. Expected '" +
                        funcSym.getParameters().size() +
                        "', got '" +
                        node.getArguments().size() +
                        "'",
                        node.getLineNumber()
                );
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
                throw new ExpressionWrongTypeException("Assigning expr to variable with different type. Expected '" +
                        symbol.getTypeID() +
                        "' got '" +
                        node.getExpr().getType() +
                        "'"
                        , node.getLineNumber());
            }
        } else {
            throw new VariableNotInitialisedException("Variable with '" + node.getID() + "' not initialised.", node.getLineNumber());
        }

        return super.visit(node);
    }

    @Override
    public Void visit(VarDeclNode node) {
        // If the expression does not have the same type as the variable being declared, throw exception.
        if(!node.getExpr().getType().equals(node.getVarType())){
            throw new ExpressionWrongTypeException("Expression has more types in it or doesn't match variable type.", node.getLineNumber());
        }

        return super.visit(node);
    }

    @Override
    public Void visit(BlockNode node) {
        st.openScope(node);

        int rtnStmtCount = 0;
        for (Node n: node.getChildren()) {
            if(n instanceof ReturnNode){
                ++rtnStmtCount;
            }
            visit(n);
            if(rtnStmtCount > 1){
                throw new UnreachableReturnStmtException(n.getLineNumber());
            }
        }

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
            if(signal.getTYPE() == SignalType.INT_RANGE && !node.getExpr().getType().equals(SymbolTable.INT_TYPE_ID)){
                throw new ExpressionWrongTypeException("Expression does not match range type. Expected '" +
                        SymbolTable.INT_TYPE_ID +
                        "' got: '" +
                        node.getExpr().getType() +
                        "'",
                        node.getExpr().getLineNumber()
                        );
            }
            // Check if the node has a float range and the expr also evaluates a float
            if(signal.getTYPE() == SignalType.FLOAT_RANGE && !node.getExpr().getType().equals(SymbolTable.FLOAT_TYPE_ID)){
                throw new ExpressionWrongTypeException("Expression does not match range type. Expected '" +
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
            if(signal.getTYPE() == SignalType.LITERALS){
                String signalLiteral = ((IDNode)node.getExpr()).getID();
                // Check that the signal contains the singal literal
                if(!signal.containsSymbol(signalLiteral)) {
                    throw new SignalLiteralNotDeclaredException("Signal literal '" +
                            signalLiteral +
                            "' not declared for signal '" +
                            node.getSignalID() +
                            "'"
                            ,
                            node.getLineNumber());
                }
            }
        } else {
            throw new DeviceHasNoSuchSignalException("'" + node.getDeviceID() + "' has no such signal '" + node.getSignalID() + "'",
                    node.getLineNumber());
        }

        return super.visit(node);
    }

    @Override
    public Void visit(MultiExprNode node) {
        if(node.getType().equals(SymbolTable.STRING_TYPE_ID)){
            throw new DivideOrMultiStringException("Cannot divide or multiply strings", node.getLineNumber());
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


        // Cannot compare to TimeNodes. For example 14:00 < 10d05m2019y
        if(node.getLeftChild() instanceof TimeNode && node.getRightChild() instanceof TimeNode){
            throw new DifferentTypesComparisonException("Cannot compare type '" +
                    node.getLeftChild().getClass().getSimpleName().replace("Node", "") +
                    "' with type '" +
                    node.getRightChild().getClass().getSimpleName().replace("Node", "") +
                    "'",
                    node.getLineNumber());
        }

        // If the left node is a NowNode and the right child is a TimeNode, throw.
        if((node.getLeftChild() instanceof NowNode) &&
            !(node.getRightChild() instanceof TimeNode)){
            throw new DifferentTypesComparisonException("Cannot compare type '" +
                    node.getLeftChild().getClass().getSimpleName().replace("Node", "") +
                    "' with type '" +
                    node.getRightChild().getClass().getSimpleName().replace("Node", "") +
                    "'",
                    node.getLineNumber());
        }
        // If the right child is a NowNode, but the left child is not a TimeNode.
        if(node.getRightChild() instanceof NowNode &&
                !(node.getLeftChild() instanceof TimeNode)){
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

    @Override
    public Void visit(WaitNode node) {
        // Wait can only be used with integers.
        if(!node.getExpr().getType().equals(SymbolTable.INT_TYPE_ID)){
            throw new ExpressionWrongTypeException("Wait node can only take '" + SymbolTable.INT_TYPE_ID + "' as input.", node.getLineNumber());
        }
        return super.visit(node);
    }

    @Override
    public Void visit(ReturnNode node) {

        // If the return data is not specified, but the function is not void, throw.
        if(node.getReturnVal() == null){
            if(!lastFunctionVisitedReturnType.equals("void")){
                throw new WrongReturnTypeException("Wrong return type. Expected '" +
                        lastFunctionVisitedReturnType +
                        "', got '" +
                        null +
                        "'",
                        node.getLineNumber()
                );
            }
        }
        // If the return data is not null, compare the type to the last visited function
        // (i.e. the current function scope)
        else if(!node.getReturnVal().getType().equals(lastFunctionVisitedReturnType)){
            throw new WrongReturnTypeException("Wrong return type. Expected '" +
                    lastFunctionVisitedReturnType +
                    "', got '" +
                    node.getReturnVal().getType() +
                    "'",
                    node.getLineNumber()
                    );
        }
        return super.visit(node);
    }

    @Override
    public Void visit(FunctionNode node) {
        lastFunctionVisitedReturnType = node.getReturnType();
        return super.visit(node);
    }

    // when frontDoorSensor Toggle: On
    @Override
    public Void visit(EventInputNode node) {
        // Fetch the device from the symbol table
        Optional<Symbol> dev = st.getSymbol(node.getDeviceID());
        if(dev.isPresent() && dev.get() instanceof FieldSymbol){
            // get the type of the device
            Optional<Symbol> devType = st.getSymbol(((FieldSymbol) dev.get()).getTypeID());
            if(devType.isPresent() && devType.get() instanceof DeviceTypeSymbol){
                // Check that the signal is contained within the device type as output
                if(!(((DeviceTypeSymbol) devType.get()).hasOutputSignal(node.getSignalID()))){
                    throw new DeviceHasNoSuchSignalException("Device '" +
                        node.getDeviceID() +
                        "' has no such signal '" +
                        node.getSignalID() + "'",
                        node.getLineNumber());
                }
            }
        }

        // Check that the signal has the signal literal
        Optional<Symbol> sig = st.getSymbol(node.getSignalID());
        if(sig.isPresent() && sig.get() instanceof SignalTypeSymbol){
            if(!((SignalTypeSymbol) sig.get()).containsSymbol(node.getEnumID())){
                throw new SignalLiteralWrongTypeException("Signal '" +
                        node.getSignalID() +
                        "' does not contain literal '" +
                        node.getEnumID() +
                        "'",
                        node.getLineNumber());
            }
        }


        lastFunctionVisitedReturnType = node.getReturnType();
        return super.visit(node);
    }

    @Override
    public Void visit(EventRangeInputNode node) {
        // Check that the device is present and also has the signal in it's type
        Optional<Symbol> dev = st.getSymbol(node.getDeviceID());
        if(dev.isPresent() && dev.get() instanceof FieldSymbol){
            // Get the type of the device
            Optional<Symbol> devType = st.getSymbol(((FieldSymbol) dev.get()).getTypeID());
            if(devType.isPresent() && devType.get() instanceof DeviceTypeSymbol){
                // Check that the device also has the signal in use
                if(!(((DeviceTypeSymbol) devType.get()).hasOutputSignal(node.getSignalID()))){
                    throw new CompileErrorException("Device '" +
                            node.getDeviceID() +
                            "' of type '" +
                            devType.get().getID() +
                            "' does not have the signal '" +
                            node.getSignalID() +
                            "'",
                            node.getLineNumber()
                            );
                }
            } else {
                throw new TypeUndefinedCompileError(((FieldSymbol) dev.get()).getTypeID(), node.getLineNumber());
            }
        } else {
            throw new TypeUndefinedCompileError(node.getDeviceID(), node.getLineNumber());
        }

        // Fetch signal from symbol table
        Optional<Symbol> sym = st.getSymbol(node.getSignalID());

        // Check that the signal is actually defined...
        if(sym.isPresent() && sym.get() instanceof SignalTypeSymbol){
            SignalType type = ((SignalTypeSymbol) sym.get()).getTYPE();
            // Check that the type of the signal range is the same as data it should "exceeds" or "deceeds".
            switch (type){
                case INT_RANGE:
                    if(!node.getExprNode().getType().equals(SymbolTable.INT_TYPE_ID)){
                        throw new IllegalRangeTypeException("Illegal range type. Expected '" +
                                SymbolTable.INT_TYPE_ID +
                                "', got '" +
                                node.getExprNode().getType() +
                                "'",
                                node.getLineNumber()
                        );
                    }
                    break;
                case FLOAT_RANGE:
                    if(!node.getExprNode().getType().equals(SymbolTable.FLOAT_TYPE_ID)){
                        throw new IllegalRangeTypeException("Illegal range type. Expected '" +
                                SymbolTable.FLOAT_TYPE_ID +
                                "', got '" +
                                node.getExprNode().getType() +
                                "'",
                                node.getLineNumber()
                        );
                    }
                    break;
            }
        } else {
            // If not present, throw exception
            throw new NoSuchSignalCompileError(node.getSignalID(), node.getLineNumber());
        }

        lastFunctionVisitedReturnType = node.getReturnType();
        return super.visit(node);
    }

    @Override
    public Void visit(EventWhenTimeNode node) {
        lastFunctionVisitedReturnType = node.getReturnType();
        return super.visit(node);
    }

    @Override
    public Void visit(EventEveryNode node) {
        lastFunctionVisitedReturnType = node.getReturnType();
        return super.visit(node);
    }

    @Override
    public Void visit(AddExprNode node) {
        if(node.getType().equals(SymbolTable.STRING_TYPE_ID) && node.getOperator() == Operator.MINUS){
            throw new SubtractStringException(node.getLineNumber());
        }
        return super.visit(node);
    }

    @Override
    public Void visit(PrintNode node) {
        return null;
    }
}
