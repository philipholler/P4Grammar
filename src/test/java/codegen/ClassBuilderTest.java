package codegen;

import codegen.default_classes.event.ScheduledEvent;
import codegen.default_classes.event.TimeEvent;
import codegen.default_classes.event.TimeEventManager;
import codegen.default_classes.event.TimeIntervalEvent;
import node.Statements.Wait.TimeFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ClassBuilderTest {

    private ClassBuilder classBuilder;

    @BeforeEach
    void setUp() {
        classBuilder = new ClassBuilder();
    }

    @Test
    void addClassDefinition() throws InterruptedException { // todo not an actual test
        ArrayList<TimeEvent> timeEvents = new ArrayList<>();


        Thread thread = new Thread(() -> {
            while (true){
                System.out.println("hey");
            }
        });
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();
        Thread.sleep(50000);


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