package codegen.default_classes.event;

import codegen.default_classes.Server;
import codegen.default_classes.SignalData;

import java.time.LocalDateTime;
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

    }






}
