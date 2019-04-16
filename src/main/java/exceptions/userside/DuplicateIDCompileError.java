package exceptions.userside;

import compiler.Compiler;

public class DuplicateIDCompileError extends CompileErrorException {

    public DuplicateIDCompileError(String id, int newIdLineNumber, int oldIdLineNummber) {
        super("The id : '" + id + "' at" + getLineReference(Compiler.SOURCE_FILE, newIdLineNumber)
                + " \n has already been defined at " + getLineReference(Compiler.SOURCE_FILE, oldIdLineNummber));
    }

}
