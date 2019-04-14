package codegen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CodeBuilderTest {

    private CodeBuilder codeBuilder;

    @BeforeEach
    void setUp() {
        codeBuilder = new CodeBuilder();
    }

    @Test
    void addClassDefinition() { // todo not an actual test
        codeBuilder.appendClassDef("MyClass", "SuperClassSample");

        codeBuilder.appendMethod("setValues", JavaType.VOID.keyword,
                new JavaInputParameter(JavaType.INT.keyword, "value1"),
                new JavaInputParameter(JavaType.INT.keyword, "value2"));

        codeBuilder.appendPrimitiveDecl(JavaType.INT, "a");
        codeBuilder.appendAssignment("a", "31435");

        codeBuilder.appendPrimitiveDecl(JavaType.INT, "b", "5");
        codeBuilder.appendMethodCall("setValues", "a", "b");

        codeBuilder.closeBlock(CodeBuilder.BlockType.METHOD);


        codeBuilder.closeBlock(CodeBuilder.BlockType.CLASS);


        System.out.println(codeBuilder.toString());
    }

    @Test
    void addClassDefinition1() {
    }

    @Test
    void openBlock() {
    }

    @Test
    void closeBlock() {
    }

    @Test
    void addMethod() {
    }

    @Test
    void getClassCode() {
    }
}