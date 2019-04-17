package codegen.default_classes.event;

import codegen.default_classes.Server;
import codegen.default_classes.SignalData;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

public class TimeEventManager extends Thread {

    private TreeSet<TimeEvent> eventExecutions = new TreeSet<>();

    public TimeEventManager(ArrayList<TimeEvent> events) {
        this.eventExecutions.addAll(events);
    }

    @Override
    public void run(){

        while (true){
            LocalDateTime now;
            TimeEvent nextEvent = eventExecutions.first();

            while((now = LocalDateTime.now()).compareTo(nextEvent.getNextExecutionTime()) < 0){
                Long timeDifference = ChronoUnit.MILLIS.between(now, eventExecutions.first().getNextExecutionTime());
                try {
                    Thread.sleep(timeDifference);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            eventExecutions.remove(nextEvent);
            nextEvent.executeEventThread();
            nextEvent.rescheduleEvent();
            eventExecutions.add(nextEvent);
        }
    }






}
