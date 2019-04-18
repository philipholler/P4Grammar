package exceptions.userside;

public class WrongReturnTypeException extends CompileErrorException {

    public WrongReturnTypeException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public WrongReturnTypeException(String msg) {
        super(msg);
    }

}
