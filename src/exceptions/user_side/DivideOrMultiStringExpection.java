package exceptions.user_side;

public class DivideOrMultiStringExpection extends CompileErrorException {

    public DivideOrMultiStringExpection(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public DivideOrMultiStringExpection(String msg) {
        super(msg);
    }
}
