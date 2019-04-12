package exceptions.userside;

public class VariableNotInitialisedException extends CompileErrorException {

    public VariableNotInitialisedException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public VariableNotInitialisedException(String msg) {
        super(msg);
    }
}
