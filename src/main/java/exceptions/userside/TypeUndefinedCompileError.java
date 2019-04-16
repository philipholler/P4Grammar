package exceptions.userside;

import main.Main;

public class TypeUndefinedCompileError extends CompileErrorException {
    public TypeUndefinedCompileError(String typeID, int lineNumber) {
        super("The type : " + typeID + " is not defined \n      at " + getLineReference(Main.SOURCE_FILE, lineNumber));
    }
}

