package codegen.default_classes.event;

import codegen.default_classes.Server;
import codegen.default_classes.SignalData;

import java.util.concurrent.ConcurrentLinkedQueue;

public class SignalEventManager extends Thread {

    // Queue of events that should be executed
    ConcurrentLinkedQueue<Runnable> events = new ConcurrentLinkedQueue<>();

    public void run(){
        Server server = new Server(); // Todo: Server should be passed in constructor when integrated

        while(true){
            SignalData signalData = server.pollSignal();
            if(signalData != null)
                parseSignal(signalData);

        }
    }

    public void manageTimedEvents(){

    }

    public void parseSignal(SignalData signalData){
        // "device1" "toggle" "on"


        // when device signal : value >> convert to string triple aka. signal value --> "device" "signal" "value" with method call

        // switch (signal

        //

    }


}
