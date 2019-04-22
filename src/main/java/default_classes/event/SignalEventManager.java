package default_classes.event;

import default_classes.SignalData;
import default_classes.device.Device;
import default_classes.signal.Signal;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class SignalEventManager extends Thread {

    // Queue of signals that should be parsed
    private LinkedBlockingQueue<SignalData> signalQueue = new LinkedBlockingQueue<>();

    private ArrayList<SignalEvent> signalEvents = new ArrayList<>();
    private ArrayList<Device> devices = new ArrayList<>();


    public SignalEventManager(ArrayList<SignalEvent> signalEvents, ArrayList<Device> devices){
        this.signalEvents.addAll(signalEvents);
        this.devices.addAll(devices);
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
            //updateCurrentValue(signalData);
        }
    }

    private void parseSignal(SignalData signalData){
        for(SignalEvent event : signalEvents){
            if(event.satisfiesCondition(signalData))
                event.executeEvent();
        }
    }

    // Update the current value variable inside the device signal object
    private void updateCurrentValue(SignalData signalData){
        for(Device dev : devices){
            if(dev.getNetworkID().equals(signalData.hardwareId)){
                Signal signal = dev.getSignal(signalData.signalType);
                if(signal != null){
                    signal.setCurrentValue(signalData.value);
                }
            }
        }


    }


    public void addSignal(SignalData signalData) {
        getEventsQueue().add(signalData);
    }
}
