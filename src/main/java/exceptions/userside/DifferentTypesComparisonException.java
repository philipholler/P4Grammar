package exceptions.userside;

public class DifferentTypesComparisonException extends CompileErrorException {

    public DifferentTypesComparisonException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public DifferentTypesComparisonException(String msg) {
        super(msg);
    }
}
