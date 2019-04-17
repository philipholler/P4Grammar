package codegen;

import codegen.default_classes.event.TimeEvent;
import codegen.default_classes.event.TimeEventManager;
import codegen.default_classes.event.TimeIntervalEvent;
import node.Events.EventEveryNode;
import node.Statements.Expression.LiteralValues.IntegerNode;
import node.Statements.Wait.TimeFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TimeUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
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

        timeEvents.add(new TimeIntervalEvent(TimeFrame.SECOND, 6, () -> System.out.println("6 second delay event"), null, null));
        timeEvents.add(new TimeIntervalEvent(TimeFrame.SECOND, 5, () -> System.out.println("5 second delay event"), null, null));
        timeEvents.add(new TimeIntervalEvent(TimeFrame.SECOND, 4, () -> System.out.println("4 second delay event"), null, null));
        timeEvents.add(new TimeIntervalEvent(TimeFrame.SECOND, 3, () -> System.out.println("3 second delay event"), null, null));
        timeEvents.add(new TimeIntervalEvent(TimeFrame.SECOND, 2, () -> System.out.println("2 second delay event"), null, null));

        Thread testThread = new TimeEventManager(timeEvents);
        testThread.run();

        Thread.sleep(5000 * 10);
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