package default_classes.signal;

public abstract class Signal <T> {

    private T currentValue;

    public T getCurrentValue(){
        return currentValue;
    }

    public void setCurrentValue(T newVal){
        currentValue = newVal;
    }

    abstract void setCurrentValue(String newVal);



    public String getName(){
        return getClass().getSimpleName();
    }

}
