package exceptions.userside;


import compiler.Compiler;

public class TypeUndefinedCompileError extends CompileErrorException {
    public TypeUndefinedCompileError(String typeID, int lineNumber) {
        super("The type : " + typeID + " is not defined \n      at " + getLineReference(Compiler.SOURCE_FILE, lineNumber));
    }
}

