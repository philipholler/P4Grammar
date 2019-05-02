package visitor;

import exceptions.userside.*;
import node.*;
import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.Statements.AssignmentNode;
import node.Statements.Expression.AddExprNode;
import node.Statements.Expression.ExpressionNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.IDNode;
import node.Statements.IfStmtNode;
import node.Statements.WhileNode;
import node.base.Node;
import node.VarDeclNode;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.Signal.DefSignalNode;
import semantics.*;

import java.util.Optional;

/**
 * This visitor is responsible for finding all declarations and adding them to the symbol table.
 * Functions should, however, be declared before using this visitor. This is done using the FunctionVisitor.
 */

public class DeclarationVisitor extends ASTBaseVisitor<Void> {
    SymbolTable st;

    public DeclarationVisitor() {
    }

    @Override
    public Void visit(ProgramNode node) {
        this.st = node.getSt();
        st.resetScope();
        return super.visit(node);
    }

    @Override
    public Void visit(DefDeviceNode node) {
        DeviceTypeSymbol deviceTypeSymbol = new DeviceTypeSymbol(node, st);
        st.enterSymbol(deviceTypeSymbol);
        super.visit(node);
        return null;
    }

    @Override
    public Void visit(DefSignalNode node) {
        SignalTypeSymbol signalType = new SignalTypeSymbol(node);
        for (FieldSymbol sym : signalType.getSignalLiterals()) {
            if(st.containsID(sym.getID())){
                throw new SignalLiteralDuplicateException("signal '" + sym.getID() + "' already defined.", node.getLineNumber());
            }
        }
        st.enterSymbol(signalType);
        super.visit(node);
        return null;
    }

    @Override
    public Void visit(FunctionNode node) {
        st.openScope(node.getBlock());

        Optional<FunctionSymbol> functionSymbol = st.getFunctionSymbol(node.getId());
        if(functionSymbol.isPresent()){
            st.enterSymbols(functionSymbol.get().getParameters());
        } else {
            throw new FunctionNotDeclaredException("Function '" +
                    node.getId() +
                    "' not declared.",
                    node.getLineNumber()
            );
        }


        st.closeScope();

        super.visit(node);

        return null;
    }

    @Override
    public Void visit(BlockNode node) {
        st.openScope(node);

        super.visit(node);

        st.closeScope();

        return null;
    }

    @Override
    public Void visit(DevDeclNode node) {
        st.enterSymbol(new FieldSymbol(node));
        super.visit(node);
        return null;
    }

    @Override
    public Void visit(VarDeclNode node) {
        st.enterSymbol(new FieldSymbol(node));
        super.visit(node);
        return null;
    }

    @Override
    public Void visit(IfStmtNode node) {
        super.visit(node.getLogicalExprNode());

        super.visit(node.getIfBlock());

        if(node.getElseBlock() != null){
            super.visit(node.getElseBlock());
        }

        return null;
    }

    @Override
    public Void visit(IDNode node) {
        // Check if the IDNode (i.e. the variable) is already declared and available from this scope
        if(!st.getSymbol(node.getID()).isPresent()){
            throw new VariableNotInitialisedException("Variable '" + node.getID() + "' not declared", node.getLineNumber());
        }
        return super.visit(node);
    }

    @Override
    public Void visit(GetFuncNode node) {
        Optional<Symbol> dev = st.getSymbol(node.getDeviceID());
        // Find device and check, that it is declared
        if(dev.isPresent()){
            FieldSymbol device = (FieldSymbol) dev.get();

            // Get the type of the device and check that is is declared
            Optional<Symbol> type = st.getSymbol(device.getTypeID());
            if(type.isPresent()){
                DeviceTypeSymbol deviceType = (DeviceTypeSymbol) type.get();

                // If the node getter is configured as output, but the type doesn't have that output signal. Throw.
                if(node.isOutput() && !deviceType.hasOutputSignal(node.getSignalID())){
                    throw new SignalIsNotOutputException("The signal '" + node.getSignalID() + "' is not defined in device '" + node.getDeviceID()  + "' as output", node.getLineNumber());
                }

                // if the node getter is configured as input, but the type doesn't have that input signal. throw.
                if(!node.isOutput() && !deviceType.hasInputSignal(node.getSignalID())){
                    throw new SignalIsNotInputException("The signal '" + node.getSignalID() + "' is not defined in device '" + node.getDeviceID()  + "' as input", node.getLineNumber());
                }

            } else {
                throw new TypeUndefinedCompileError(device.getTypeID(), node.getLineNumber());
            }
        } else {
            throw new VariableNotInitialisedException("Device with name '" +node.getDeviceID() + "' not declared", node.getLineNumber());
        }
        return null;
    }

    // when frontDoorSensor Toggle: On
    @Override
    public Void visit(EventInputNode node) {
        // fetch the device
        Optional<Symbol> dev = st.getSymbol(node.getDeviceID());
        //Check that it is present and of the type Field symbol
        if(!(dev.isPresent() && dev.get() instanceof FieldSymbol)){
            throw new VariableNotInitialisedException("Variable '" + node.getDeviceID() + "' not declared", node.getLineNumber());
        }

        // check that the literal is declared.
        if(!st.isSignalLiteral(node.getEnumID())){
            throw new SignalLiteralNotDeclaredException("Signal literal '" +
                    node.getEnumID() +
                    "' not declared",
                    node.getLineNumber()
            );
        }
        return super.visit(node);
    }

    // when mainThermometer Celsius: exceeds 22
    @Override
    public Void visit(EventRangeInputNode node) {
        // fetch the device
        Optional<Symbol> dev = st.getSymbol(node.getDeviceID());
        //Check that it is present and of the type Field symbol
        if(!(dev.isPresent() && dev.get() instanceof FieldSymbol)){
            throw new VariableNotInitialisedException("Variable '" + node.getDeviceID() + "' not declared", node.getLineNumber());
        }

        // fetch the signal
        Optional<Symbol> sig = st.getSymbol(node.getSignalID());
        // Check that the signal is declared
        if(!(sig.isPresent() && sig.get() instanceof SignalTypeSymbol)){
            throw new NoSuchSignalCompileError(node.getSignalID(), node.getLineNumber());
        }

        return super.visit(node);
    }
}
