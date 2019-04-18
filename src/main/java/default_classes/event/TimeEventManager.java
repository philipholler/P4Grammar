package default_classes.event;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.TreeSet;

public class TimeEventManager extends Thread {

    private TreeSet<TimeEvent> eventExecutions = new TreeSet<>();

    public TimeEventManager(ArrayList<TimeEvent> events) {
        this.eventExecutions.addAll(events);
    }

    @Override
    public void run(){
        if(eventExecutions.isEmpty()) return; // No time events in the program

        while (true){
            LocalDateTime now;
            TimeEvent nextEvent = eventExecutions.first();

            // Sleep until the next event is ready to be executed
            while((now = LocalDateTime.now()).compareTo(nextEvent.getNextExecutionTime()) < 0){
                long timeDifference = ChronoUnit.MILLIS.between(now, eventExecutions.first().getNextExecutionTime());

                try {
                    Thread.sleep(timeDifference);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Execute the event action
            nextEvent.executeEventThread();

            // Remove the event from the set and update the next execution time
            eventExecutions.remove(nextEvent);
            nextEvent.rescheduleEvent();

            // Add the event back in
            eventExecutions.add(nextEvent);
        }
    }






}
