package codegen.default_classes.event;

import codegen.default_classes.Server;
import codegen.default_classes.SignalData;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TimeEventManager extends Thread {

    TreeSet<TimeEvent> eventExecutions = new TreeSet<>();

    public TimeEventManager(ArrayList<TimeEvent> eventExecutions) {
        this.eventExecutions.addAll(eventExecutions);
    }

    @Override
    public void run(){
        while (true){
            LocalDateTime now = LocalDateTime.now();
            TimeEvent nextEvent = eventExecutions.first();

            if(now.compareTo(nextEvent.getNextExecutionTime()) < 0){
                Long timeDifference = ChronoUnit.MILLIS.between(now, eventExecutions.first().getNextExecutionTime());
                try {
                    Thread.sleep(timeDifference);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            nextEvent.executeEventThread();
            eventExecutions.remove(nextEvent);
            nextEvent.rescheduleEvent();
            eventExecutions.add(nextEvent);
        }
    }






}
