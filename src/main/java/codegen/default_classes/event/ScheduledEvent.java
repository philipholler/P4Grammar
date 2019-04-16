package codegen.default_classes.event;

import node.Events.WhenNodes.EventWhenTimeNode;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ScheduledEvent implements TimeEvent{

    private LocalDateTime nextExecutionTime;
    private EventWhenTimeNode node;

    private Thread eventhread;

    public ScheduledEvent(EventWhenTimeNode node, Runnable eventAction) {
        this.node = node;
        this.eventhread = new Thread(eventAction);
        initNextExecutionTime();
    }

    private void initNextExecutionTime() {
        LocalDate nextExecutionTime;

        // Todo : Might need to update definition of the DateNode class. Should the user be able
        // Todo : to do something on the 1st of every month?
    }

    @Override
    public void executeEventThread() {

    }

    @Override
    public void rescheduleEvent() {

    }

    @Override
    public LocalDateTime getNextExecutionTime() {
        return null;
    }

    @Override
    public int compareTo(TimeEvent timeEvent) {
        return 0;
    }
}
