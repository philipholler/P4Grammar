package exceptions.user_side;

import main.Main;

public class DuplicateIDCompileError extends CompileErrorException {

    public DuplicateIDCompileError(String id, int newIdLineNumber, int oldIdLineNummber) {
        super("The id : '" + id + "' at" + getLineReference(Main.SOURCE_FILE, newIdLineNumber)
                + " \n has already been defined at " + getLineReference(Main.SOURCE_FILE, oldIdLineNummber));
    }

}
