package exceptions.userside;

public class SignalIsNotInputExpection extends CompileErrorException {

    public SignalIsNotInputExpection(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public SignalIsNotInputExpection(String msg) {
        super(msg);
    }
}
