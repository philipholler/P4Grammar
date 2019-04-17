package codegen;

import default_classes.SignalData;
import default_classes.device.Window;
import default_classes.event.RangeSignalEvent;
import default_classes.event.SignalEvent;
import default_classes.event.SignalEventManager;
import default_classes.event.SimpleSignalEvent;
import default_classes.signal.OpenSignal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

class ClassBuilderTest {

    private ClassBuilder classBuilder;

    @BeforeEach
    void setUp() {
        classBuilder = new ClassBuilder();
    }

    @Test
    void addClassDefinition() throws InterruptedException { // todo not an actual test
        OpenSignal percent = new OpenSignal(0, 100);
        OpenSignal percent2 = new OpenSignal(0, 100);

        Window window = new Window("101");
        Window window2 = new Window("102");


        RangeSignalEvent<Integer> rangeEvent = new RangeSignalEvent<Integer>(window, percent, 25,
                RangeSignalEvent.PassType.EXCEEDS, () -> System.out.println("Signal exceeded 25!"));

        RangeSignalEvent<Integer> rangeEvent2 = new RangeSignalEvent<Integer>(window2, percent, 35,
                RangeSignalEvent.PassType.DECEEDS, () -> System.out.println("Signal exceeded 35!"));

        SimpleSignalEvent<Integer> normalEvent = new SimpleSignalEvent<Integer>(window, percent2, 50, () -> System.out.println("recieved signal 50"));

        ArrayList<SignalEvent> events = new ArrayList<>();
        events.add(rangeEvent);
        events.add(rangeEvent2);
        events.add(normalEvent);

        SignalEventManager signalEventManager = new SignalEventManager(events);
        LinkedBlockingQueue<SignalData> signalQueue = signalEventManager.getEventsQueue();

        signalEventManager.start();

        System.out.println("_________________________");
        signalQueue.add(new SignalData("101", "OpenSignal", "24"));
        Thread.sleep(1000);
        signalQueue.add(new SignalData("101", "OpenSignal", "23"));
        Thread.sleep(1000);
        System.out.println("_________________________");
        signalQueue.add(new SignalData("101", "OpenSignal", "26"));
        Thread.sleep(1000);
        System.out.println("_________________________");
        signalQueue.add(new SignalData("101", "OpenSignal", "27"));
        Thread.sleep(1000);
        System.out.println("_________________________");
        signalQueue.add(new SignalData("101", "OpenSignal", "24"));
        Thread.sleep(1000);
        System.out.println("_________________________");
        signalQueue.add(new SignalData("101", "OpenSignal", "26"));
        Thread.sleep(1000);
        System.out.println("_________________________");
        signalQueue.add(new SignalData("101", "OpenSignal", "50"));
        Thread.sleep(1000);
        System.out.println("_________________________");
        signalQueue.add(new SignalData("101", "OpenSignal", "50"));
        Thread.sleep(5000);




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