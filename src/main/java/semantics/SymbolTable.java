package semantics;

import exceptions.userside.DuplicateIDCompileError;
import exceptions.userside.TypeUndefinedCompileError;
import node.Statements.Expression.LiteralValues.FloatNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Expression.LiteralValues.StringNode;
import node.base.Node;
import node.define_nodes.Signal.EnumNode;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Optional;

public class SymbolTable {

    public static final String INT_TYPE_ID = "int", FLOAT_TYPE_ID = "float", STRING_TYPE_ID = "string", VOID_TYPE_ID = "void";

    public final ArrayList<String> definedTypeIDs = new ArrayList<>();

    // The outermost block (Where global variables and type declarations reside)
    private Block globalBlock;
    // The currently opened block
    private Block currentBlock;

    // Functions can have the same name as other symbols and are therefore kept in a seperate list
    // Additionally, functions can only be defined globally and are therefore listed here instead of within a block
    private ArrayList<FunctionSymbol> functions = new ArrayList<>();

    public SymbolTable(){
        globalBlock = new Block();
        currentBlock = globalBlock;

        definedTypeIDs.add(INT_TYPE_ID);
        definedTypeIDs.add(FLOAT_TYPE_ID);
        definedTypeIDs.add(STRING_TYPE_ID);
    }

    public boolean isDeviceTypeDefined(String ID){
        Optional<Symbol> symbol = globalBlock.getSymbol(ID);
        return symbol.isPresent() && symbol.get() instanceof DeviceTypeSymbol;
    }

    public boolean isSignalLiteral(String ID){
        Optional<Symbol> symbol = globalBlock.getSymbol(ID);
        return symbol.isPresent() && symbol.get().declarationNode instanceof EnumNode;
    }

    public boolean isSignalTypeDefined(String ID){
        Optional<Symbol> symbol = globalBlock.getSymbol(ID);
        return symbol.isPresent() && symbol.get() instanceof SignalTypeSymbol;
    }

    public  <T extends Symbol> void enterSymbols(ArrayList<T> symbols) {
        for(Symbol s : symbols)
            enterSymbol(s);
    }

    /** Adds the given symbol to the currently opened scope */
    public void enterSymbol(Symbol s){
        if(s instanceof FunctionSymbol) enterFunctionSymbol((FunctionSymbol) s);
        else if(s instanceof FieldSymbol) enterFieldSymbol((FieldSymbol) s);
        else if(s instanceof SignalTypeSymbol) enterSignalSymbol((SignalTypeSymbol) s);
        else enterRegularSymbol(s);
    }

    private void enterSignalSymbol(SignalTypeSymbol s){
        // check if the signal is already defined
        Optional<Symbol> existingSymbol = currentBlock.getSymbol(s.id);
        if(existingSymbol.isPresent()){
            throw new DuplicateIDCompileError(s.id, s.declarationNode.getLineNumber(),
                    existingSymbol.get().declarationNode.getLineNumber());
        }

        // Add all the literals as field symbols
        for (FieldSymbol symb : s.getSignalLiterals()) {
            enterFieldSymbol(symb);
        }

        // If it gets to here, add the Signal Type
        currentBlock.addSymbol(s);
    }

    private void enterFieldSymbol(FieldSymbol s){
        // Verify that type of the variable is defined before adding it to the symbol table
        if(definedTypeIDs.contains(s.getTypeID())) enterRegularSymbol(s);
        else throw new TypeUndefinedCompileError(s.getTypeID(), s.declarationNode.getLineNumber());
    }

    private void enterRegularSymbol(Symbol s){
        // Throw exception if the symbol id is already in use in the current scope...
        Optional<Symbol> existingSymbol = currentBlock.getSymbol(s.id);
        if(existingSymbol.isPresent()){
            throw new DuplicateIDCompileError(s.id, s.declarationNode.getLineNumber(),
                    existingSymbol.get().declarationNode.getLineNumber());
        }
        // ...otherwise add the symbol to the current scope
        currentBlock.addSymbol(s);

        // Add type id to global type list if the symbol is a type definition
        if(s instanceof DeviceTypeSymbol) definedTypeIDs.add(s.id);
    }

    private void enterFunctionSymbol(FunctionSymbol s){
        // Throw exception if function with same name already exists...
        for(FunctionSymbol fs : functions){
            if(fs.id.equals(s.id))
                throw new DuplicateIDCompileError(s.id, s.declarationNode.getLineNumber(),
                    fs.declarationNode.getLineNumber());
        }

        // ...otherwise add the function to the function list
        functions.add(s);
    }

    public Optional<Symbol> getSymbol(String id){
        return currentBlock.getSymbol(id);
    }

    public Optional<FunctionSymbol> getFunctionSymbol(String id){
        for(FunctionSymbol fs : functions)
            if(fs.getID().equals(id)) return Optional.of(fs);

        return Optional.empty();
    }

    public boolean containsFunctionSymbol(String id){
        for(FunctionSymbol fs : functions){
            if(fs.getID().equals(id)) return true;
        }

        return false;
    }

    /** Checks if the current scope (or any parent scopes) contains any symbol with the given idString */
    public boolean containsID(String id){
        return currentBlock.idExistsInScope(id);
    }

    /** Checks if the current scope (or any parent scopes) contains any symbol with the given idString */
    public boolean isGlobalVariable (String id){
        Optional<Symbol> symbol = globalBlock.getSymbol(id);
        return symbol.isPresent() && symbol.get() instanceof FieldSymbol;
    }



    /**
     * Opens a scope corresponding to the current node
     **/
    public void openScope(Node n){
        // Check if the block is already contained within the current block
        for(Block b : currentBlock.subBlocks){
            if(b.getBlockNode() == n){
                currentBlock = b;
                return;
            }
        }

        // ...otherwise make new block and add it to the currentBlock
        Block newBlock = new Block(n, currentBlock);
        currentBlock.addSubBlock(newBlock);
        currentBlock = newBlock;
    }

    /**
     * Closes the currently opened scope
     */
    public void closeScope(){
        if(!currentBlock.hasParent())
            throw new RuntimeException("Attempted to close outermost scope");

        currentBlock = currentBlock.getParentBlock();
    }


    public String toString(){
        StringBuilder symbolString = new StringBuilder("Functions : \n");
        for(FunctionSymbol fs : functions)
            symbolString.append(fs.toString()).append("\n");
        symbolString.append("\n__________________________________\nOther symbols : \n");

        return symbolString.append(globalBlock.toString(1)).toString();
    }

    public static boolean isPrimitiveDataType(String type){
        return (type.equals(INT_TYPE_ID)
                || type.equals(FLOAT_TYPE_ID)
                || type.equals(STRING_TYPE_ID));
    }





    public boolean isValidType(String type) {
        return definedTypeIDs.contains(type);
    }

    // Finds and extracts a string representing the data of the given enumID
    public String getEnumStringValue(String enumID) {
        EnumNode enumNode = (EnumNode) (((FieldSymbol) getSymbol(enumID).get()).declarationNode);
        if(enumNode.getType().equals(STRING_TYPE_ID)){
            return ((StringNode) enumNode.getLiteralValue()).getVal();
        }else if (enumNode.getType().equals(INT_TYPE_ID)){
            return String.valueOf(((IntegerNode) enumNode.getLiteralValue()).getVal());
        }else{
            return String.valueOf(((FloatNode) enumNode.getLiteralValue()).getVal());
        }
    }

    private class Block {

        private Node blockNode;
        private Block parentBlock;
        private ArrayList<Block> subBlocks = new ArrayList<>();

        private ArrayList<Symbol> localSymbols = new ArrayList<>();

        private Block(Node blockNode, Block parentBlock){
            this.blockNode = blockNode;
            this.parentBlock = parentBlock;
        }

        private Block(){}

        private boolean addSymbol(Symbol symbol){
            if(idExistsInScope(symbol.id))
                return false;

            localSymbols.add(symbol);
            return true;
        }

        // Checks if there is already a symbol with the given idString in this block or any parent blocks.
        private boolean idExistsInScope (String id){
            for(Symbol s : localSymbols)
                if(s.id.equals(id)) return true;

            if(hasParent())
                return parentBlock.idExistsInScope(id);

            return false;
        }

        private Optional<Symbol> getSymbol(String id){
            // Check every symbol within this scope
            for(Symbol s : localSymbols) {

                // Check the literals defined in signal symbols
                if (s instanceof SignalTypeSymbol) {
                    Optional<FieldSymbol> matchingSignalLiteral = ((SignalTypeSymbol) s).getSignalLiteral(id);
                    // (at return) The extra Optional.of converts Optional<FieldSymbol> to Optional<Symbol>
                    if(matchingSignalLiteral.isPresent()) return Optional.of(matchingSignalLiteral.get());
                }

                // Check if the symbol id matches the given id
                if (s.id.equals(id))
                    return Optional.of(s);
            }

            // Check the parent block if no local symbols match the id
            if(hasParent())
                return parentBlock.getSymbol(id);

            return Optional.empty();
        }

        private void addSubBlock(Block block){
            subBlocks.add(block);
        }

        private boolean hasParent(){
            return parentBlock != null;
        }

        private Node getBlockNode(){
            return this.blockNode;
        }

        private Block getParentBlock(){
            return parentBlock;
        }


        public String toString(int indentation) {
            StringBuilder s = new StringBuilder();

            for(Symbol sym : localSymbols){
                s.append(StringUtils.getIndentedString(indentation));
                s.append(sym.toString()).append("\n");
            }

            for(Block b : subBlocks){
                s.append(b.toString(indentation + 1));
            }

            if(s.length() != 0){
                String blockSeperator = StringUtils.getIndentedString(indentation - 1) +
                        StringUtils.getLineIndentedString(1) + "\n";
                s.insert(0, blockSeperator);
                s.append(blockSeperator);

            }

            return s.toString();
        }
    }

    public void resetScope(){
        currentBlock = globalBlock;
    }
}
