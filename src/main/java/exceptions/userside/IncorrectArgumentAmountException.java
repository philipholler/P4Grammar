package exceptions.userside;

public class IncorrectArgumentAmountException extends CompileErrorException {
    public IncorrectArgumentAmountException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public IncorrectArgumentAmountException(String msg) {
        super(msg);
    }
}
