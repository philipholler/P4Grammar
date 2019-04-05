package exceptions.user_side;

import exceptions.user_side.CompileErrorException;
import main.Main;

public class TypeUndefinedCompileError extends CompileErrorException {
    public TypeUndefinedCompileError(String typeID, int lineNumber) {
        super("The type : " + typeID + " is not defined \n      at " + getLineReference(Main.sourceFile, lineNumber));
    }
}

