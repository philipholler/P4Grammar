package visitor;

import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.ProgramNode;
import semantics.FunctionSymbol;
import semantics.SymbolTable;

/**
 * This visitor is a simple visitor for adding all functions to the symbol table.
 * This must be done before the declaration visitor visits,
 */

public class FunctionVisitor extends ASTBaseVisitor<Object> {
    SymbolTable st;

    @Override
    public Object visit(FunctionNode node) {
        FunctionSymbol fs = new FunctionSymbol(node);

        st.enterSymbol(fs);

        return null;
    }

    @Override
    public Object visit(ProgramNode node) {
        this.st = node.getSt();
        return super.visit(node);
    }
}
