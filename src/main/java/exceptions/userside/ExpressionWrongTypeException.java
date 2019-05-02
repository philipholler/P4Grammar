package exceptions.userside;

public class ExpressionWrongTypeException extends CompileErrorException {

    public ExpressionWrongTypeException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public ExpressionWrongTypeException(String msg) {
        super(msg);
    }
}
