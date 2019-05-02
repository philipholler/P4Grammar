package exceptions.userside;

public class DivideOrMultiStringException extends CompileErrorException {

    public DivideOrMultiStringException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public DivideOrMultiStringException(String msg) {
        super(msg);
    }
}

