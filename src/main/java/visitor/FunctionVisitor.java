package visitor;

import exceptions.userside.ReturnStatementMissingException;
import node.Function.FunctionNode;
import node.Function.InputParamNode;
import node.ProgramNode;
import node.Statements.ReturnNode;
import node.base.Node;
import semantics.FunctionSymbol;
import semantics.SymbolTable;

/**
 * This visitor is a simple visitor for adding all functions to the symbol table.
 * This must be done before the declaration visitor visits,
 */

public class FunctionVisitor extends ASTBaseVisitor<Object> {
    SymbolTable st;

    @Override
    public Object visit(ProgramNode node) {
        this.st = node.getSt();
        return super.visit(node);
    }

    @Override
    public Object visit(FunctionNode node) {
        // Check that if the function is not of the type void, it must have a return statement.
        // Return statements can be nested inside if and while as well. But we can't know the run time value
        // of the booleans triggering the if and while, therefor we require one in the outer scope of the function
        if(!node.getReturnType().equals("void")){
            boolean hasReturnNode = false;
            for (Node n : node.getBlock().getChildren()) {
                if(n instanceof ReturnNode) hasReturnNode = true;
            }
            if(!hasReturnNode) throw new ReturnStatementMissingException("Function '" + node.getId() + "has no return statement", node.getLineNumber());
        }

        FunctionSymbol fs = new FunctionSymbol(node);
        st.enterSymbol(fs);

        return null;
    }
}
