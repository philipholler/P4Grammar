package exceptions.user_side;

import exceptions.user_side.CompileErrorException;
import main.Main;

public class DuplicateIDCompileError extends CompileErrorException {

    public DuplicateIDCompileError(String id, int newIdLineNumber, int oldIdLineNummber) {
        super("The id : '" + id + "' at" + getLineReference(Main.sourceFile, newIdLineNumber)
                + " \n has already been defined at " + getLineReference(Main.sourceFile, oldIdLineNummber));
    }

}
