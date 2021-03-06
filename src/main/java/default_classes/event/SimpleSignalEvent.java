package default_classes.event;

import default_classes.SignalData;
import default_classes.device.Device;
import default_classes.signal.Signal;

public class SimpleSignalEvent<T> implements SignalEvent {

    private final Device device;
    private final Signal<T> signal;
    private final T value;

    private final SignalData expectedData;
    private final Runnable eventAction;
    private Thread eventThread;

    public SimpleSignalEvent(Device device, Signal<T> signal, T value, Runnable eventAction) {
        this.device = device;
        this.signal = signal;
        this.value = value;
        this.eventAction = eventAction;

        // The data that will trigger this event
        expectedData = new SignalData(device.getNetworkID(), signal.getClass().getSimpleName(), String.valueOf(value));
    }

    @Override
    public boolean satisfiesCondition(SignalData data) {
        return expectedData.equals(data);
    }

    @Override
    public void executeEvent() {
        // Stop previous thread if it's still running
        while(eventThread != null && eventThread.isAlive()){
            eventThread.interrupt();
        }

        eventThread = new Thread(eventAction);
        eventThread.start();
    }

}
