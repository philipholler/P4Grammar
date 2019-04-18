package exceptions.userside;

public class IllegalRangeTypeException extends CompileErrorException{

    public IllegalRangeTypeException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public IllegalRangeTypeException(String msg) {
        super(msg);
    }
}
