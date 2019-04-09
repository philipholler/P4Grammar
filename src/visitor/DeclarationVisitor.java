package visitor;

import node.DevDeclNode;
import node.Events.EventEveryNode;
import node.Events.WhenNodes.EventInputNode;
import node.Events.WhenNodes.EventRangeInputNode;
import node.Events.WhenNodes.EventWhenTimeNode;
import node.Function.FunctionNode;
import node.InitNode;
import node.Statements.IfStmtNode;
import node.Statements.WhileNode;
import node.VarDeclNode;
import node.define_nodes.Device.DefDeviceNode;
import node.define_nodes.Signal.DefSignalNode;
import semantics.*;

import java.util.Optional;

public class DeclarationVisitor extends ASTBaseVisitor<Void> {
    SymbolTable st;

    public DeclarationVisitor(SymbolTable st) {
        this.st = st;
    }

    public SymbolTable getSt() {
        return st;
    }


    @Override
    public Void visit(DefDeviceNode node) {
        DeviceTypeSymbol deviceTypeSymbol = new DeviceTypeSymbol(node, st);
        st.enterSymbol(deviceTypeSymbol);
        return null;
    }

    @Override
    public Void visit(DefSignalNode node) {
        SignalTypeSymbol signalType = new SignalTypeSymbol(node);
        st.enterSymbol(signalType);
        return null;
    }

    @Override
    public Void visit(FunctionNode node) {
        st.openScope(node);

        Optional<FunctionSymbol> functionSymbol = st.getFunctionSymbol(node.getId());
        if(functionSymbol.isPresent()){
            st.enterSymbols(functionSymbol.get().getParameters());
        }

        super.visit(node.getBlock());

        st.closeScope();

        return null;
    }

    @Override
    public Void visit(DevDeclNode node) {
        st.enterSymbol(new FieldSymbol(node));
        return null;
    }

    @Override
    public Void visit(InitNode node) {
        st.openScope(node);

        super.visit(node);

        st.closeScope();
        return null;
    }

    @Override
    public Void visit(VarDeclNode node) {
        st.enterSymbol(new FieldSymbol(node));
        return null;
    }

    @Override
    public Void visit(IfStmtNode node) {
        st.openScope(node);

        super.visit(node.getIfBlock());

        st.closeScope();


        if(node.getElseBlock() != null){
            st.openScope(node);

            super.visit(node.getElseBlock());

            st.closeScope();
        }

        return null;
    }

    @Override
    public Void visit(WhileNode node) {
        st.openScope(node);

        super.visit(node.getRightChild());

        st.closeScope();

        return null;
    }

    @Override
    public Void visit(EventInputNode node) {
        st.openScope(node);

        super.visit(node.getBlockNode());

        st.closeScope();

        return null;
    }

    @Override
    public Void visit(EventRangeInputNode node) {
        st.openScope(node);

        super.visit(node.getBlockNode());

        st.closeScope();

        return null;
    }

    @Override
    public Void visit(EventWhenTimeNode node) {
        st.openScope(node);

        super.visit(node.getBlockNode());

        st.closeScope();

        return null;
    }

    @Override
    public Void visit(EventEveryNode node) {
        st.openScope(node);

        super.visit(node.getBlockNode());

        st.closeScope();

        return null;
    }
}
