package exceptions.user_side;

public class ExpressionTypeException extends CompileErrorException {

    public ExpressionTypeException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public ExpressionTypeException(String msg) {
        super(msg);
    }
}
