package exceptions.user_side;

public class FunctionNotDeclaredException extends CompileErrorException {

    public FunctionNotDeclaredException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public FunctionNotDeclaredException(String msg) {
        super(msg);
    }
}
