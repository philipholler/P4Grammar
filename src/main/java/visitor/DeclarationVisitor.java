package visitor;

import exceptions.userside.*;
import node.BlockNode;
import node.DevDeclNode;
import node.Function.FunctionNode;
import node.Statements.Expression.IDNode;
import node.Statements.IfStmtNode;
import node.VarDeclNode;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.Signal.DefSignalNode;
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
}
