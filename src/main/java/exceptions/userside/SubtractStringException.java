package exceptions.userside;

public class SubtractStringException extends CompileErrorException {

    public SubtractStringException(int lineNumber) {
        super("Cannot subtract a string", lineNumber);
    }

    public SubtractStringException(String msg) {
        super(msg);
    }
}
