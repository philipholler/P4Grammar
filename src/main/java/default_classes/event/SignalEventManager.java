package default_classes.event;

import default_classes.SignalData;
import default_classes.device.Device;
import default_classes.signal.Signal;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class SignalEventManager extends Thread {

    // Thread safe unbounded blocking queue containing signals to be parsed by this manager
    private LinkedBlockingQueue<SignalData> signalQueue = new LinkedBlockingQueue<>();
    // ^ When polling using take() on this queue the current thread will be blocked until an element is available
    // ^ This means that this thread will only be running when there are signals to parse


    private ArrayList<SignalEvent> signalEvents = new ArrayList<>();
    private ArrayList<Device> devices = new ArrayList<>();

    public SignalEventManager(ArrayList<SignalEvent> signalEvents, ArrayList<Device> devices){
        this.signalEvents.addAll(signalEvents);
        this.devices.addAll(devices);
    }

    public void run(){
        while(true){
            SignalData signalData = null;
            try {
                signalData = signalQueue.take();
                System.out.println("Took signal" + signalData.toSignalString());
            } catch (InterruptedException e) {
                e.printStackTrace(); // todo : exception handling lol
            }

            // Check if the current signal triggers any events
            parseSignal(signalData);
            // Update the current data variable to correspond to the received signal
            updateCurrentValue(signalData);
        }
    }

    private void parseSignal(SignalData signalData){
        for(SignalEvent event : signalEvents)
            if(event.satisfiesCondition(signalData))
                event.executeEvent();
    }

    // Update the current data variable inside the device signal object
    private void updateCurrentValue(SignalData signalData){
        for(Device dev : devices){
            if(dev.getNetworkID().equals(signalData.hardwareId)){
                Signal signal = dev.getSignal(signalData.signalType);

                // Update the signal data if the device contains this signal type
                if(signal != null)
                    signal.setCurrentValue(signalData.data);
            }
        }
    }

    public synchronized void addSignal(SignalData signalData) {
        signalQueue.offer(signalData);
    }
}
