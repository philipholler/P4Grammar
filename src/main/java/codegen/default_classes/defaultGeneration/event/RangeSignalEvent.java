package codegen.default_classes.defaultGeneration.event;

import codegen.default_classes.defaultGeneration.SignalData;
import codegen.default_classes.defaultGeneration.device.Device;
import codegen.default_classes.defaultGeneration.signal.RangeSignal;
import codegen.default_classes.defaultGeneration.signal.Signal;
import node.Statements.Expression.LiteralValues.FloatNode;

public class RangeSignalEvent<T extends Number> implements SignalEvent{

    public enum PassType {
            EXCEEDS, DECEEDS;
    }

    private final Device device;
    private final Signal<T> signal;
    private final T thresHold;

    private final Thread eventThread;
    private final PassType passType;

    public RangeSignalEvent(Device device, RangeSignal<T> signal, T thresHold, PassType passType, Runnable eventAction) {
        this.device = device;
        this.signal = signal;
        this.thresHold = thresHold;
        this.passType = passType;
        eventThread = new Thread(eventAction);


    }

    @Override
    public boolean satisfiesCondition(SignalData data) {
        // If the device and signal type matches, then check if signal exceeds/deceeds
        if(device.getNetworkID().equals(data.hardwareId) && signal.getName().equals(data.signalType)){
            if(passType == PassType.EXCEEDS){

                // The event can only be triggered if the current value is below the threshold
                // and the new value is at or above the treshold
                if(compareSignalValue(signal.getCurrentValue(), thresHold) < 0 && compareSignalValue(data.value, thresHold) >= 0){
                    signal.setCurrentValue(data.value);
                    return true;
                }

                /**
                 * implement so that currentval < thresHold and
                 */



            }else{
                // PassType must be deceeds

            }
        }

        return false;
    }

    private int compareSignalValue(String num, T val){
        // A range signal can either be a float range or an int range
        if(val instanceof Integer){
            Integer x = (Integer) val;
            Integer y = Integer.parseInt(num);
            return x.compareTo(y);
        }else{
            Float x = (Float) val;
            Float y = Float.parseFloat(num);
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

    @SuppressWarnings("unchecked") // Actually is checked
    private T toSignalValue(String stringVal){
        if(signal.getCurrentValue() instanceof Integer)
            return (T) (Integer.valueOf(stringVal));
        else
            return (T) (Float.valueOf(stringVal));
    }


    @Override
    public void executeEvent() {
        while(eventThread.isAlive()){
            eventThread.interrupt();
        }

        eventThread.start();

    }
}
