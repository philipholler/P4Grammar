package compiler;

import exceptions.userside.CompileErrorException;
import exceptions.userside.ExpressionWrongTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompilerTest {

    public static final String TEST_GENERATED_DIR = "src/test/testGeneratedFiles/";
    public static final String TEST_SOURCE_FILE_DIR = "src/test/res/ProgramsforTestsPivot/";

    @Test
    void TestVariableError() {
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
        Compiler.setSourceFile("wrongTypeException.pvt");
        assertThrows(ExpressionWrongTypeException.class, Compiler::compileCodeWithoutPrint);
        Compiler.deleteOldGeneratedFiles();
    }

    @Test
    void TestdeclSignalProgram(){
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
        Compiler.setSourceFile("declSignal.pvt");
        Compiler.compileCodeWithoutPrint();
        Compiler.deleteOldGeneratedFiles();
    }

    @Test
    void TestEventTestProgram(){
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
        Compiler.setSourceFile("EventTestProgram.pvt");
        Compiler.compileCodeWithoutPrint();
        Compiler.deleteOldGeneratedFiles();
    }

    @Test
    void testKodeEksempelRapport(){
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
        Compiler.setSourceFile("kodeEksempelRapport.pvt");
        Compiler.compileCodeWithoutPrint();
        Compiler.deleteOldGeneratedFiles();
    }

    @Test
    void testtestProgram(){
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
        Compiler.setSourceFile("testProgram.pvt");
        Compiler.compileCodeWithoutPrint();
        Compiler.deleteOldGeneratedFiles();
    }
}