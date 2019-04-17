package exceptions.userside;

public class SignalIsNotOutputException extends CompileErrorException {

    public SignalIsNotOutputException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public SignalIsNotOutputException(String msg) {
        super(msg);
    }
}
