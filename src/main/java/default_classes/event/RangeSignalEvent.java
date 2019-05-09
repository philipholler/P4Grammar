package default_classes.event;

import default_classes.SignalData;
import default_classes.device.Device;
import default_classes.signal.RangeSignal;
import default_classes.signal.Signal;

public class RangeSignalEvent<T extends Number> implements SignalEvent{

    private final Device device;
    private final Signal<T> signal;
    private final T thresHold;
    private T previousValue;

    private Thread eventThread;
    private final String passType;
    public static final String EXCEEDS = "EXCEEDS", DECEEDS = "DECEEDS";

    private final Runnable eventAction;

    public RangeSignalEvent(Device device, RangeSignal<T> signal, T thresHold, String passType, Runnable eventAction) {
        this.device = device;
        this.signal = signal;
        this.thresHold = thresHold;
        this.passType = passType;
        this.eventAction = eventAction;
        previousValue = signal.getCurrentValue();
    }

    @Override
    public boolean satisfiesCondition(SignalData data) {
        boolean result = false;
        // If the device and signal type matches, then check if signal exceeds/deceeds
        if(device.getNetworkID().equals(data.hardwareId) && signal.getName().equals(data.signalType)){

            if(passType.equals("EXCEEDS")){
                // The 'exceeds' event can only be triggered if the current data is at or below the threshold
                // and the new data is at or above the threshold
                if(compareSignalValue(previousValue, thresHold) <= 0
                        && compareSignalValue(data.data, thresHold) > 0){
                    result = true;
                }

            }else{
                // The 'deceeds' event can only be triggered if the current data is at or above the threshold
                // and the new data is below the threshold
                if(compareSignalValue(previousValue, thresHold) >= 0
                        && compareSignalValue(data.data, thresHold) < 0){
                    result = true;
                }
            }

            // Update the current signal data to reflect the newly received data
            signal.setCurrentValue(data.data);
            previousValue = signal.getCurrentValue();
        }

        return result;
    }

    private int compareSignalValue(String num, T val){
        // A range signal can either be a float range or an int range
        if(val instanceof Integer){
            Integer x = Integer.parseInt(num);
            Integer y = (Integer) val;
            return x.compareTo(y);
        }else{
            Float x = Float.parseFloat(num);
            Float y = (Float) val;
            return x.compareTo(y);
        }
    }

    private int compareSignalValue(T val1, T val2){
        // A range signal can either be a float or an integer
        if(val1 instanceof Integer){
            Integer x = (Integer) val1;
            Integer y = (Integer) val2;
            return x.compareTo(y);
        }else{
            Float x = (Float) val1;
            Float y = (Float) val2;
            return x.compareTo(y);
        }
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
