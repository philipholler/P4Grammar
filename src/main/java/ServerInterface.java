import codegen.default_classes.Signal;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class ServerInterface {


    Queue<SignalData> latetsSignals = new SynchronousQueue<>();

    public SignalData getSignal(){
        return latetsSignals.poll();
    }


    public void sendSignal(SignalData data){

    }





}
