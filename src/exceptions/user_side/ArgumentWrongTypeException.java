package exceptions.user_side;

public class ArgumentWrongTypeException extends CompileErrorException {

    public ArgumentWrongTypeException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public ArgumentWrongTypeException(String msg) {
        super(msg);
    }
}
