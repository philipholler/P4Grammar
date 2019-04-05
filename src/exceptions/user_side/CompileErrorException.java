package exceptions.user_side;


import main.Main;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CompileErrorException extends RuntimeException {

    private int lineNumber;
    private String msg;

    public CompileErrorException(String msg, int lineNumber) {
        super();
        this.msg = msg + "\n" + "at " + getLineReference(Main.sourceFile, lineNumber);
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
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        System.err.println("\n" + msg);
    }
}
