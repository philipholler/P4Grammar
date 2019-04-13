package codegen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassBuilderTest {

    private ClassBuilder classBuilder;

    @BeforeEach
    void setUp() {
        classBuilder = new ClassBuilder();
    }

    @Test
    void addClassDefinition() {
        classBuilder.addClassDefinition("Child");
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