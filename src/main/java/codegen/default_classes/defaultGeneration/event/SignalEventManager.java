package codegen.default_classes.defaultGeneration.event;

import codegen.default_classes.defaultGeneration.signal.Server;
import codegen.default_classes.defaultGeneration.SignalData;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SignalEventManager extends Thread {

    // Queue of signals that should be parsed
    private LinkedBlockingQueue<SignalData> signalQueue = new LinkedBlockingQueue<>();

    private ArrayList<SignalEvent> signalEvents = new ArrayList<>();

    public SignalEventManager(ArrayList<SignalEvent> signalEvents){
        this.signalEvents.addAll(signalEvents);
    }

    public LinkedBlockingQueue<SignalData> getEventsQueue(){
        return signalQueue;
    }

    public void run(){
        while(true){
            SignalData signalData = null;
            try {
                signalData = signalQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace(); // todo : exception handling lol
            }
            parseSignal(signalData);
        }
    }

    public void parseSignal(SignalData signalData){
        for(SignalEvent event : signalEvents){
            if(event.satisfiesCondition(signalData))
                event.executeEvent();
        }
    }


}
