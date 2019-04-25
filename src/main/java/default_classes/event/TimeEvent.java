package default_classes.event;

import java.time.LocalDateTime;

public interface TimeEvent extends Comparable<TimeEvent> {

    void executeEventThread();

    void rescheduleEvent();

    LocalDateTime getNextExecutionTime();

    @Override
    default int compareTo(TimeEvent timeEvent){
        int result = this.getNextExecutionTime().compareTo(timeEvent.getNextExecutionTime());

        if(result == 0){ // Compare object hash
            if(this.equals(timeEvent)) result = 0;
            else result = (this.hashCode() > timeEvent.hashCode()) ? 1 : -1;
        }
        return result;
    }

    boolean isRepeated();
}
