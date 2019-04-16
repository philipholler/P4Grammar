package codegen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;

class ClassBuilderTest {

    private ClassBuilder classBuilder;

    @BeforeEach
    void setUp() {
        classBuilder = new ClassBuilder();
    }

    @Test
    void addClassDefinition() { // todo not an actual test

        System.out.println(MonthDay.now());
        System.out.println(LocalTime.now().getHour() + "H" +LocalTime.now().getMinute() + "M");
        System.out.println(LocalDate.now().toString().replaceAll("-", "_"));

        /*
        classBuilder.appendClassDef("MyClass", "SuperClassSample");

        classBuilder.appendMethod("setValues", JavaType.VOID.keyword,
                new JavaInputParameter(JavaType.INT.keyword, "value1"),
                new JavaInputParameter(JavaType.INT.keyword, "value2"));

        classBuilder.appendPrimitiveDecl(JavaType.INT, "a");
        classBuilder.appendAssignment("a", "31435");

        classBuilder.appendPrimitiveDecl(JavaType.INT, "b", "5");
        classBuilder.appendMethodCall("setValues", "a", "b");

        classBuilder.closeBlock(ClassBuilder.BlockType.METHOD);


        classBuilder.closeBlock(ClassBuilder.BlockType.CLASS);


        System.out.println(classBuilder.toString());*/
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