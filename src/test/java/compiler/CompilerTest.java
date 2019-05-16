package compiler;

import exceptions.userside.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
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
        Compiler.setGeneratedOutputFilesDir(TEST_GENERATED_DIR);
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

    @Test
    void TestUnreachableReturnStmtException00(){
        Compiler.setSourceFile("UnreachableReturnStmtException.pvt");
        assertThrows(UnreachableReturnStmtException.class, Compiler::compileToJava);
    }

    @Test
    void TestUnreachableReturnStmtException01(){
        Compiler.setSourceFile("UnreachableReturnStmtException1.pvt");
        assertThrows(UnreachableReturnStmtException.class, Compiler::compileToJava);
    }

    @Test
    void TestUnreachableReturnStmtException02(){
        Compiler.setSourceFile("UnreachableReturnStmtException2.pvt");
        assertThrows(UnreachableReturnStmtException.class, Compiler::compileToJava);
    }

    @Test
    void TestUnreachableReturnStmtException03(){
        Compiler.setSourceFile("UnreachableReturnStmtException3.pvt");
        assertThrows(UnreachableReturnStmtException.class, Compiler::compileToJava);
    }

    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                        PARSER TEST                               *
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */

    @Test
    void testParseCancellationException(){
        Compiler.setSourceFile("ParseCancellationException.pvt");
        assertThrows(ParseCancellationException.class, Compiler::compileToJava);
    }

    @Test
    void testEmptyProgram(){
        Compiler.setSourceFile("EmptyProgram.pvt");
        Compiler.compileToJava();
    }


    /** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *              SYSTEM TESTS WITH ENTIRE PROGRAMS                   *
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */

    @Test
    void TestdeclSignalProgram(){
        Compiler.setSourceFile("declSignalTest.pvt");
        Compiler.compileToJava();
    }

    @Test
    void TestEventTestProgram(){
        Compiler.setSourceFile("EventTestProgramTest.pvt");
        Compiler.compileToJava();
    }

    @Test
    void testKodeEksempelRapport(){
        Compiler.setSourceFile("kodeEksempelRapportTest.pvt");
        Compiler.compileToJava();
    }

    @Test
    void testtestProgram(){
        Compiler.setSourceFile("testProgramTest.pvt");
        Compiler.compileToJava();
    }
}