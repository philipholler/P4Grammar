package codegen.default_classes.event;

public class EventThread extends Thread {

    public EventThread(Runnable eventMethod) {
        super(eventMethod);
    }



}
