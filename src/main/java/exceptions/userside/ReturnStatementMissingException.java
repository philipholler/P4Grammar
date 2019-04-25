package exceptions.userside;

public class ReturnStatementMissingException extends CompileErrorException {

    public ReturnStatementMissingException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public ReturnStatementMissingException(String msg) {
        super(msg);
    }
}
