package exceptions.user_side;


import compiler.Compiler;

import java.io.PrintStream;
import java.io.PrintWriter;

import static compiler.Compiler.COMPILER_DEBUG_MODE;

public class CompileErrorException extends RuntimeException {

    private int lineNumber;
    private String msg;

    public CompileErrorException(String msg, int lineNumber) {
        super();
        this.msg = msg + "\n" + "at " + getLineReference(Compiler.SOURCE_FILE, lineNumber);
        this.lineNumber = lineNumber;
    }

    public CompileErrorException(String msg) {
        super();
        this.msg = msg;
    }

    protected static String getLineReference(String fileName, int lineNumber){
        return "Pivot.("+ fileName + ":" + lineNumber + ")";
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        System.err.println("\n" + msg);

        if(COMPILER_DEBUG_MODE){
            System.err.println("\n");
            super.printStackTrace(s);
        }

    }

    @Override
    public void printStackTrace(PrintWriter s) {
        System.err.println("\n" + msg);
        if(COMPILER_DEBUG_MODE){
            System.err.println("\n");
            super.printStackTrace(s);
        }
    }
}
