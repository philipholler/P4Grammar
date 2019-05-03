package compiler;

import exceptions.userside.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompilerTest {

    public static final String TEST_GENERATED_DIR = "src/test/testGeneratedFiles/";
    public static final String TEST_SOURCE_FILE_DIR = "src/test/res/ProgramsforTestsPivot/";


    @BeforeEach
    void setup() {
        Compiler.setCompilerDebugMode(true);
        Compiler.setGeneratedFilesDir(TEST_GENERATED_DIR);
        Compiler.setSourceFileDir(TEST_SOURCE_FILE_DIR);
    }

    @AfterEach
    void deleteOldFiles() {
        Compiler.deleteOldGeneratedFiles();
    }


    /**
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *             TEST THAT SIMPLE ERRORS ARE CAUGHT                  *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */

    @Test
    void TestWrongReturnTypeException(){
        Compiler.setSourceFile("WrongReturnTypeException.pvt");
        assertThrows(WrongReturnTypeException.class, Compiler::compileToJava);
    }

    @Test
    void TestVariableNotInitialisedException(){
        Compiler.setSourceFile("VariableNotInitialisedException.pvt");
        assertThrows(VariableNotInitialisedException.class, Compiler::compileToJava);
    }

    @Test
    void TestTypeUndefinedCompileError(){
        Compiler.setSourceFile("TypeUndefinedCompileError.pvt");
        assertThrows(TypeUndefinedCompileError.class, Compiler::compileToJava);
    }

    @Test
    void TestSubtractStringException(){
        Compiler.setSourceFile("SubtractStringException.pvt");
        assertThrows(SubtractStringException.class, Compiler::compileToJava);
    }

    @Test
    void TestSignalLiteralWrongTypeException(){
        Compiler.setSourceFile("SignalLiteralWrongTypeException.pvt");
        assertThrows(SignalLiteralWrongTypeException.class, Compiler::compileToJava);
    }

    @Test
    void TestSignalLiteralNotDeclaredException(){
        Compiler.setSourceFile("SignalLiteralNotDeclaredException.pvt");
        assertThrows(SignalLiteralNotDeclaredException.class, Compiler::compileToJava);
    }

    @Test
    void TestSignalLiteralDuplicateException(){
        Compiler.setSourceFile("SignalLiteralDuplicateException.pvt");
        assertThrows(SignalLiteralDuplicateException.class, Compiler::compileToJava);
    }

    @Test
    void TestSignalIsNotOutputException(){
        Compiler.setSourceFile("SignalIsNotOutputException.pvt");
        assertThrows(SignalIsNotOutputException.class, Compiler::compileToJava);
    }

    @Test
    void TestSignalIsNotInputException(){
        Compiler.setSourceFile("SignalIsNotInputException.pvt");
        assertThrows(SignalIsNotInputException.class, Compiler::compileToJava);
    }

    @Test
    void TestReturnStatementMissingException() {
        Compiler.setSourceFile("ReturnStatementMissingException.pvt");
        assertThrows(ReturnStatementMissingException.class, Compiler::compileToJava);
    }

    @Test
    void TestNoSuchSignalCompileError(){
        Compiler.setSourceFile("NoSuchSignalCompileError.pvt");
        assertThrows(NoSuchSignalCompileError.class, Compiler::compileToJava);
    }

    @Test
    void TestIncorrectArgumentAmountException(){
        Compiler.setSourceFile("IncorrectArgumentAmountException.pvt");
        assertThrows(IncorrectArgumentAmountException.class, Compiler::compileToJava);
    }

    @Test
    void TestIllegalRangeTypeException(){
        Compiler.setSourceFile("IllegalRangeTypeException.pvt");
        assertThrows(IllegalRangeTypeException.class, Compiler::compileToJava);
    }

    @Test
    void TestFunctionNotDeclaredException(){
        Compiler.setSourceFile("FunctionNotDeclaredException.pvt");
        assertThrows(FunctionNotDeclaredException.class, Compiler::compileToJava);
    }

    @Test
    void TestExpressionWrongTypeException(){
        Compiler.setSourceFile("ExpressionWrongTypeException.pvt");
        assertThrows(ExpressionWrongTypeException.class, Compiler::compileToJava);
    }

    @Test
    void TestDuplicateIDCompileError(){
        Compiler.setSourceFile("DuplicateIDCompileError.pvt");
        assertThrows(DuplicateIDCompileError.class, Compiler::compileToJava);
    }

    @Test
    void TestDivideOrMultiStringException(){
        Compiler.setSourceFile("DivideOrMultiStringException.pvt");
        assertThrows(DivideOrMultiStringException.class, Compiler::compileToJava);
    }

    @Test
    void TestDifferentTypesComparisonException() {
        Compiler.setSourceFile("DifferentTypesComparisonException.pvt");
        assertThrows(DifferentTypesComparisonException.class, Compiler::compileToJava);
    }

    @Test
    void TestDeviceHasNoSuchSignalException() {
        Compiler.setSourceFile("DeviceHasNoSuchSignalException.pvt");
        assertThrows(DeviceHasNoSuchSignalException.class, Compiler::compileToJava);
    }

    @Test
    void TestArgumentWrongTypeException(){
        Compiler.setSourceFile("ArgumentWrongTypeException.pvt");
        assertThrows(ArgumentWrongTypeException.class, Compiler::compileToJava);
    }

    @Test
    void TestWrongTypeException() {
        Compiler.setSourceFile("WrongTypeException.pvt");
        assertThrows(ExpressionWrongTypeException.class, Compiler::compileToJava);
    }


    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *              SYSTEM TESTS WITH ENTIRE PROGRAMS                   *
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */

    @Test
    void TestdeclSignalProgram(){
        Compiler.setSourceFile("declSignal.pvt");
        Compiler.compileToJava();
    }

    @Test
    void TestEventTestProgram(){
        Compiler.setSourceFile("EventTestProgram.pvt");
        Compiler.compileToJava();
    }

    @Test
    void testKodeEksempelRapport(){
        Compiler.setSourceFile("kodeEksempelRapport.pvt");
        Compiler.compileToJava();
    }

    @Test
    void testtestProgram(){
        Compiler.setSourceFile("testProgram.pvt");
        Compiler.compileToJava();
    }
}