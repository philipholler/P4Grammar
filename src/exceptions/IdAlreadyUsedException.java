package exceptions;

import node.base.Node;
import semantics.Symbol;

public class IdAlreadyUsedException extends SemanticException {

    private String ID;
    // The symbol that currently uses the ID
    private Symbol previousUse;

    public IdAlreadyUsedException(String ID, Symbol previousUse) {
        super("The ID : '" + ID + "' has already been used within this scope");
        this.ID = ID;
        this.previousUse = previousUse;
    }

    public String getID() {
        return ID;
    }

    public Symbol getPreviousUse() {
        return previousUse;
    }

}
