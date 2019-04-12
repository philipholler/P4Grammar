package exceptions.user_side;

public class SignalLiteralNotDeclaredException extends CompileErrorException {

    public SignalLiteralNotDeclaredException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public SignalLiteralNotDeclaredException(String msg) {
        super(msg);
    }
}
