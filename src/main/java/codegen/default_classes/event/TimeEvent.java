package codegen.default_classes.event;

import java.time.LocalDateTime;

public interface TimeEvent extends Comparable<TimeEvent> {

    void executeEventThread();

    void rescheduleEvent();

    LocalDateTime getNextExecutionTime();

    @Override
    default int compareTo(TimeEvent timeEvent){
        return this.getNextExecutionTime().compareTo(timeEvent.getNextExecutionTime());
    }
}
