package exceptions.userside;

public class UnreachableReturnStmtException extends CompileErrorException {

    public UnreachableReturnStmtException(int lineNumber) {
        super("Unreachable return statement.", lineNumber);
    }

    public UnreachableReturnStmtException(String msg) {
        super(msg);
    }
}
