package semantics;

import com.sun.jdi.InvalidTypeException;
import exceptions.IdAlreadyUsedException;
import exceptions.TypeUndefinedException;
import node.base.Node;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Optional;

public class SymbolTable {

    public static final String INT_TYPE_ID = "int", FLOAT_TYPE_ID = "float", STRING_TYPE_ID = "string";

    public final ArrayList<String> definedTypeIDs = new ArrayList<>();

    // The outermost block (Where global variables and type declarations reside)
    Block globalBlock;
    // The currently opened block
    Block currentBlock;

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

    public boolean isSignalTypeDefined(String ID){
        Optional<Symbol> symbol = globalBlock.getSymbol(ID);
        return symbol.isPresent() && symbol.get() instanceof SignalTypeSymbol;
    }

    private void enterSymbol(ArrayList<Symbol> symbols) throws IdAlreadyUsedException, TypeUndefinedException {
        for(Symbol s : symbols){
            enterSymbol(s);
        }
    }

    /** Adds the given symbol to the currently opened scope */
    public void enterSymbol(Symbol s) throws IdAlreadyUsedException, TypeUndefinedException {
        if(s instanceof FunctionSymbol) enterFunctionSymbol((FunctionSymbol) s);
        else if(s instanceof FieldSymbol) enterFieldSymbol((FieldSymbol)s);
        else enterRegularSymbol(s);
    }

    private void enterFieldSymbol(FieldSymbol s) throws IdAlreadyUsedException, TypeUndefinedException{
        // Verify that type of the variable is defined before adding it to the symbol table
        if(definedTypeIDs.contains(s.getTypeID())) enterRegularSymbol(s);
        else throw new TypeUndefinedException(s.getTypeID());
    }

    private void enterRegularSymbol(Symbol s) throws IdAlreadyUsedException{
        // Throw exception if the symbol id is already in use in the current scope...
        Optional<Symbol> existingSymbol = currentBlock.getSymbol(s.id);
        if(existingSymbol.isPresent())
            throw new IdAlreadyUsedException(s.id, existingSymbol.get());

        // ...otherwise add the symbol to the current scope
        currentBlock.addSymbol(s);
        // Add type id to global type list if the symbol is a type definition
        if(s instanceof DeviceTypeSymbol) definedTypeIDs.add(s.id);
    }

    private void enterFunctionSymbol(FunctionSymbol s) throws IdAlreadyUsedException, TypeUndefinedException{


        // Throw exception if function with same name already exists...
        for(FunctionSymbol fs : functions){
            if(fs.id.equals(s.id)) throw new IdAlreadyUsedException("",fs);
        }

        // ...otherwise add the function to the function list
        functions.add(s);
    }



    /** Checks if the current scope (or any parent scopes) contains any symbol with the given idString */
    public boolean containsID(String id){
        return currentBlock.idExistsInScope(id);
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
        StringBuilder functionsString = new StringBuilder("Functions : \n");
        for(FunctionSymbol fs : functions)
            functionsString.append(fs.toString()).append("\n");


        return functionsString.append(globalBlock.toString(0)).toString();
    }



    // TODO: 28-03-2019 Should this be named Scope instead?
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
            for(Symbol s : localSymbols)
                if(s.id.equals(id)) return Optional.of(s);

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
            String s = StringUtils.getIndentedString(indentation);
            for(Symbol sym : localSymbols){
                s += StringUtils.getIndentedString(indentation);
                s += sym.toString();
            }
            for(Block b : subBlocks){
                s += "\n" + b.toString(indentation + 1);
            }

            return s;
        }
    }
}
