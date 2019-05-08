package visitor.codegen;


import node.Function.FunctionNode;
import node.Statements.Expression.FunctionCall.FuncCallNode;
import node.Statements.Expression.FunctionCall.SetFuncNode;
import node.Statements.Expression.IDNode;
import node.Statements.IfStmtNode;
import node.Statements.WhileNode;
import node.base.Node;
import semantics.FieldSymbol;
import semantics.FunctionSymbol;
import semantics.Symbol;
import semantics.SymbolTable;
import visitor.ASTBaseVisitor;

import java.util.*;

/**
 * This class is responsible for finding all uses of global variables in a given node and its children
 * A visit mmethod returns a list of all global variables used in that node and in the children of that node
 */
public class SynchronizationVisitor extends ASTBaseVisitor<TreeSet<FieldSymbol>> {

    private final SymbolTable symbolTable;

    // Comparator used for sorting symbol set by the lines the symbols were declared on
    private final Comparator<FieldSymbol> symbolComparator =
            Comparator.comparingInt(fieldSymbol -> fieldSymbol.getDelcarationNode().getLineNumber());

    public SynchronizationVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override // Returns a hashset with the fieldsymbol corresponding to the id node if it's a global variable
    public TreeSet<FieldSymbol> visit(IDNode node) {
        TreeSet<FieldSymbol> globalSymbols = new TreeSet<>(symbolComparator);
        Optional<Symbol> symbol = symbolTable.getSymbol(node.getID());

        if(symbol.isPresent() && symbol.get() instanceof FieldSymbol)
            globalSymbols.add((FieldSymbol) symbol.get());


        return globalSymbols;
    }

    @Override // Finds all global variables used in the while condition (the boolean expression)
    public TreeSet<FieldSymbol> visit(WhileNode node) {
        return visit(node.getLogicalExprNode());
    }

    @Override // Finds all global variables used in the if condition (the boolean expression)
    public TreeSet<FieldSymbol> visit(IfStmtNode node) {
        return visit(node.getLogicalExprNode());
    }

    @Override // Finds all global variables used as input parameters and used in the function that is being called
    public TreeSet<FieldSymbol> visit(FuncCallNode node) {
        TreeSet<FieldSymbol> globalVars = new TreeSet<>(symbolComparator);

        for(Node n : node.getArguments())
            globalVars.addAll(visit(n));

        FunctionNode fnode = findFunctionNode(node.getID());
        for(Node n : fnode.getBlock().getChildren()){
            globalVars.addAll(visit(n));
        }

        return globalVars;
    }

    @Override
    public TreeSet<FieldSymbol> visit(SetFuncNode node) {
        TreeSet<FieldSymbol> globalVars = new TreeSet<>(symbolComparator);

        // Add the device variable to the global vars
        globalVars.add(findDeviceSymbol(node.getDeviceID()));
        // Add any global variables used in the set expression
        globalVars.addAll(visit(node.getExpr()));

        return globalVars;
    }

    private FieldSymbol findDeviceSymbol(String id){
        Optional<Symbol> foundSymbol = symbolTable.getSymbol(id);

        if (!symbolTable.isGlobalVariable(id) || foundSymbol.isPresent())
            throw new RuntimeException("Could not find device symbol in global scope : " + id);

        return (FieldSymbol) foundSymbol.get();
    }

    private FunctionNode findFunctionNode(String id){
        Optional<FunctionSymbol> functionSymbol = symbolTable.getFunctionSymbol(id);

        if(!functionSymbol.isPresent())
            throw new RuntimeException("Attempting to call a function " +
                      "that is not registered in the function table : " + id);

        return (FunctionNode) functionSymbol.get().getDelcarationNode();
    }


    @Override
    protected TreeSet<FieldSymbol> aggregateResult(TreeSet<FieldSymbol> aggregate,
                                                         TreeSet<FieldSymbol> nextResult) {
        if(aggregate == null)
            return nextResult;

        aggregate.addAll(nextResult);
        return nextResult;
    }

    @Override
    protected TreeSet<FieldSymbol> defaultResult() {
        return new TreeSet<>(symbolComparator);
    }
}
