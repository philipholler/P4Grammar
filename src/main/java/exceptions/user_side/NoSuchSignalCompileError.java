package exceptions.user_side;

import compiler.Compiler;

public class NoSuchSignalCompileError extends CompileErrorException{

    public NoSuchSignalCompileError(String signalID, int lineNumber) {
        super("The signal : " + signalID + " has not been defined\n     at " +
                getLineReference(Compiler.SOURCE_FILE, lineNumber));
    }
}
