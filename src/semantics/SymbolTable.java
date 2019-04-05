package semantics;

import exceptions.CompileErrorException;
import node.base.Node;
import utils.StringUtils;

import java.util.ArrayList;

public class SymbolTable {

    Block globalBlock;
    Block currentBlock;

    public SymbolTable(){
        globalBlock = new Block(null, null);
        currentBlock = globalBlock;
    }

    /**
     * Opens a scope corresponding to the current node
     **/
    // TODO: 28-03-2019 Should this maybe be recursive? (and maybe check all blocks/scopes)
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

    /**
     * Adds the given symbol to the currently opened scope
     */
    public void enterSymbol(Symbol s){
        currentBlock.addSymbol(s);
    }

    /**
     * Checks if the current scope (or any parent scopes) contains any symbol with the given idString
     */
    public boolean containsID(String id){
        return currentBlock.idExistsInScope(id);
    }

    public Symbol retriveSymbol(String id){
        return currentBlock.retriveSymbol(id);
    }

    public String toString(){
        return globalBlock.toString(0);
    }


    // TODO: 28-03-2019 Should this be named Block instead?
    private class Block {

        private Node blockNode;
        private Block parentBlock;
        private ArrayList<Block> subBlocks = new ArrayList<>();

        private ArrayList<Symbol> localSymbols = new ArrayList<>();

        private Block(Node blockNode, Block parentBlock){
            this.blockNode = blockNode;
            this.parentBlock = parentBlock;
        }

        private boolean addSymbol(Symbol symbol){
            if(idExistsInScope(symbol.getName()))
                return false;

            localSymbols.add(symbol);
            return true;
        }

        // Checks if there is already a symbol with the given idString in this block or any parent blocks.
        private boolean idExistsInScope (String id){
            for(Symbol s : localSymbols)
                if(s.getName().equals(id)) return true;

            if(hasParent())
                return parentBlock.idExistsInScope(id);

            return false;
        }

        private Symbol retriveSymbol(String id){
            for(Symbol s : localSymbols)
                if(s.getName().equals(id)) return s;

            if(hasParent())
                return parentBlock.retriveSymbol(id);


            return null;
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
