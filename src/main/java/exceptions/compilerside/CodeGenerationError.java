package exceptions.compilerside;

public class CodeGenerationError extends RuntimeException {

    public CodeGenerationError(String message) {
        super(message);
    }
}
