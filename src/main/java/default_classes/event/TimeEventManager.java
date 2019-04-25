package default_classes.event;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * This class manages time events;
 * starting events threads at the appropriate time
 * and rescheduling them after execution
 */

public class TimeEventManager extends Thread {

    private TreeSet<TimeEvent> eventExecutions = new TreeSet<>();

    public TimeEventManager(ArrayList<TimeEvent> events) {
        this.eventExecutions.addAll(events);
    }

    @Override // The main loop responsible for executing and rescheduling events when needed
    public void run(){
        while (true){
            if(eventExecutions.isEmpty()) return; // Return if there's no more events left to be executed

            TimeEvent nextEvent = eventExecutions.first();

            // Sleep until the next event is ready to be executed
            waitUntil(nextEvent.getNextExecutionTime());

            // Execute the event action and remove it from the queue
            nextEvent.executeEventThread();
            eventExecutions.remove(nextEvent);

            // Reschedule event and add it back in if it's repeatable
            if(nextEvent.isRepeated()){
                nextEvent.rescheduleEvent();
                eventExecutions.add(nextEvent);
            }
        }
    }

    // Sleeps the current thread until the given timePoint
    private void waitUntil(LocalDateTime timePoint){
        LocalDateTime now;

        while((now = LocalDateTime.now()).compareTo(timePoint) < 0){

            // Calculate time difference and sleep thread until the timePoint is reached
            long timeDifference = ChronoUnit.MILLIS.between(now, timePoint);

            try {
                Thread.sleep(timeDifference);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }






}
