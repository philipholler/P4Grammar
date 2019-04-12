package exceptions.compilerside;

/**
 * Indicates that a bracket is missing or has been placed wrongly
 */
public class MismatchedBracketException extends RuntimeException {

    public MismatchedBracketException(String message) {
        super(message);
    }

}
