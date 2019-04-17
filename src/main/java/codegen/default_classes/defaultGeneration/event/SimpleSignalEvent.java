package codegen.default_classes.defaultGeneration.event;

import codegen.default_classes.defaultGeneration.SignalData;
import codegen.default_classes.defaultGeneration.device.Device;
import codegen.default_classes.defaultGeneration.signal.Signal;

public class SimpleSignalEvent<T> implements SignalEvent {

    private final Device device;
    private final Signal<T> signal;
    private final T value;

    private final SignalData expectedData;
    private final Thread eventThread;

    public SimpleSignalEvent(Device device, Signal<T> signal, T value, Runnable eventAction) {
        this.device = device;
        this.signal = signal;
        this.value = value;

        eventThread = new Thread(eventAction);

        // The value that will trigger this event
        expectedData = new SignalData(device.getNetworkID(), signal.getClass().getName(), String.valueOf(value));
    }

    @Override
    public boolean satisfiesCondition(SignalData data) {
        return expectedData.equals(data);
    }

    @Override
    public void executeEvent() {
        // Kill the old event thread if it's still running
        while(eventThread.isAlive()){
            eventThread.interrupt(); // Todo Should this sleep for a short period to allow the thread to stop?
        }

        eventThread.start();
    }

}
