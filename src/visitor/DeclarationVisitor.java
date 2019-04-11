package visitor;

import exceptions.user_side.*;
import node.BlockNode;
import node.DevDeclNode;
import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.InitNode;
import node.Statements.AssignmentNode;
import node.Statements.Expression.ExpressionNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.GetFuncNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.IDNode;
import node.Statements.IfStmtNode;
import node.Statements.WhileNode;
import node.VarDeclNode;
import node.base.Node;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.Signal.DefSignalNode;
import node.define_nodes.Signal.EnumNode;
import semantics.*;

import java.util.Optional;

public class DeclarationVisitor extends ASTBaseVisitor<Void> {
    SymbolTable st;

    public DeclarationVisitor(SymbolTable st) {
        this.st = st;
        this.st.resetScope();
    }

    public SymbolTable getSt() {
        return st;
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
    public Void visit(FuncCallNode node) {
        // Check that the function is declared
        Optional<FunctionSymbol> sym = st.getFunctionSymbol(node.getID());
        if(!sym.isPresent()) {
            throw new FunctionNotDeclaredException("Function with name: '" + node.getID() + "' is not declared",
                    node.getLineNumber());
        } else{
            // If declared give the node it's correct type
            node.setType(sym.get().getReturnType());
        }

        return null;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Void visit(GetFuncNode node) {
        Optional<Symbol> signal = st.getSymbol(node.getSignalID());
        Optional<Symbol> device = st.getSymbol(node.getDeviceID());

        // Check that both the device and signal are declared.
        //noinspection Duplicates
        if(signal.isPresent() && device.isPresent() && signal.get() instanceof SignalTypeSymbol){
            SignalTypeSymbol signalSymb = (SignalTypeSymbol) signal.get();

            // Set the expression type of the node depending on the signal type.
            switch (signalSymb.getTYPE()){
                case INT_RANGE:
                    node.setType("int");
                    break;
                case FLOAT_RANGE:
                    node.setType("float");
                    break;
                case LITERALS:
                    node.setType(signalSymb.getSignalLiterals().get(0).getTypeID());
                    break;
            }
        } else {
            throw new TypeUndefinedCompileError("Type with name: '" + node.getDeviceID() +
                    "' or " + node.getSignalID() + " not defined"
            , node.getLineNumber());
        }

        return super.visit(node);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Void visit(SetFuncNode node) {
        Optional<Symbol> signal = st.getSymbol(node.getSignalID());
        Optional<Symbol> device = st.getSymbol(node.getDeviceID());

        if(signal.isPresent() && signal.get() instanceof SignalTypeSymbol){
            SignalTypeSymbol signalSymb = (SignalTypeSymbol) signal.get();

            // Set the expression type of the node depending on the signal type.
            switch (signalSymb.getTYPE()){
                case INT_RANGE:
                    node.setType("int");
                    break;
                case FLOAT_RANGE:
                    node.setType("float");
                    break;
                case LITERALS:
                    node.setType(signalSymb.getSignalLiterals().get(0).getTypeID());
                    break;
            }
        }else {
            throw new TypeUndefinedCompileError("Type with name: '" + node.getSignalID() + "' not defined", node.getLineNumber());
        }


        if(device.isEmpty()){
            throw new TypeUndefinedCompileError("Type '" + node.getDeviceID() + "' not defined", node.getLineNumber());
        }



        return super.visit(node);
    }
}
