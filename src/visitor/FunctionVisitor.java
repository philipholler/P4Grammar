package visitor;

import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.ProgramNode;
import semantics.FunctionSymbol;
import semantics.SymbolTable;

public class FunctionVisitor extends ASTBaseVisitor<Object> {
    SymbolTable st;

    public FunctionVisitor() {
        this.st = new SymbolTable();
    }

    @Override
    public Object visit(FunctionNode node) {
        FunctionSymbol fs = new FunctionSymbol(node);

        st.enterSymbol(fs);

        return null;
    }

    public SymbolTable getSt() {
        return st;
    }
}
