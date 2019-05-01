package compiler;

import exceptions.userside.CompileErrorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompilerTest {

    public static final String TEST_GENERATED_DIR = "src/test/testGeneratedFiles/";
    public static final String TEST_SOURCE_FILE_DIR = "src/test/res/ProgramsforTestsPivot/";

    @Test
    void testVariableError() {
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
        Compiler.setSourceFile("wrongTypeException.pvt");
        assertThrows(CompileErrorException.class, () -> Compiler.main(new String[0]));
        Compiler.deleteOldGeneratedFiles();
    }

    @Test
    void testdeclSignalProgram(){
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
        Compiler.setSourceFile("declSignal.pvt");
        Compiler.main(new String[0]);
        Compiler.deleteOldGeneratedFiles();
    }

    @Test
    void testEventTestProgram(){
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
        Compiler.setSourceFile("EventTestProgram.pvt");
        Compiler.main(new String[0]);
        Compiler.deleteOldGeneratedFiles();
    }

    @Test
    void testKodeEksempelRapport(){
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
        Compiler.setSourceFile("kodeEksempelRapport.pvt");
        Compiler.main(new String[0]);
        Compiler.deleteOldGeneratedFiles();
    }

    @Test
    void testtestProgram(){
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
        Compiler.setSourceFile("testProgram.pvt");
        Compiler.main(new String[0]);
        Compiler.deleteOldGeneratedFiles();
    }
}