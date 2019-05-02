package exceptions.userside;

public class SignalIsNotInputException extends CompileErrorException {

    public SignalIsNotInputException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public SignalIsNotInputException(String msg) {
        super(msg);
    }
}
