package default_classes.signal;

public abstract class Signal <T> {

    private T currentValue;

    public synchronized T getCurrentValue(){
        return currentValue;
    }

    public synchronized void setCurrentValue(T newVal){
        currentValue = newVal;
    }

    public abstract void setCurrentValue(String newVal);

    public String getName(){
        return getClass().getSimpleName();
    }

}
