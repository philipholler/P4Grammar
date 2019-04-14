package codegen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassBuilderTest {

    private ClassBuilder classBuilder;

    @BeforeEach
    void setUp() {
        classBuilder = new ClassBuilder("standard");
    }

    @Test
    void addClassDefinition() { // todo not an actual test
        classBuilder.addClassDefinition("MyClass", "SuperClassSample");

        classBuilder.appendMethod("setValues", JavaType.VOID,
                new JavaInputParameter(JavaType.INT, "value1"),
                new JavaInputParameter(JavaType.INT, "value2"));

        classBuilder.appendVarDecl(JavaType.INT, "a");
        classBuilder.appendAssignment("a", "31435");

        classBuilder.appendVarDecl(JavaType.INT, "b", "5");
        classBuilder.appendMethodCall("setValues", "a", "b");

        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);


        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);


        System.out.println(classBuilder.getClassCode());
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