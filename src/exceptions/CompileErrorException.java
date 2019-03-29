package exceptions;


import main.Main;

import java.io.PrintStream;
import java.io.PrintWriter;

public class CompileErrorException extends RuntimeException {

    private int lineNumber;
    private String msg;

    public CompileErrorException(String msg, int lineNumber) {
        super();
        this.msg = msg;
        this.lineNumber = lineNumber;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        System.err.println("\n" + msg);
        System.err.println("at " + "Pivot.("+ Main.sourceFile + ":" + lineNumber + ")");

    }

    @Override
    public void printStackTrace(PrintWriter s) {
        System.err.println("\n" + msg);
        s.println("at " + "Pivot.("+ Main.sourceFile + ":" + lineNumber + ")");
    }
}
