package exceptions.userside;

import main.Main;

public class NoSuchSignalCompileError extends CompileErrorException{

    public NoSuchSignalCompileError(String signalID, int lineNumber) {
        super("The signal : " + signalID + " has not been defined\n     at " +
                getLineReference(Main.SOURCE_FILE, lineNumber));
    }
}
