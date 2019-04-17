package codegen.default_classes;

public abstract class RangeSignal<T extends Number> implements Signal<T> {

    private T lowerBound, upperBound;
    private T currentValue;

    public RangeSignal(T lowerBound, T upperBound, T defaultValue){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.currentValue = defaultValue;
    }

    public T getUpperBound(){
        return upperBound;
    }

    public T getLowerBound(){
        return upperBound;
    }

    abstract boolean isValueInRange(T value);


    @Override
    public T getCurrentValue() {
        return currentValue;
    }

    @Override
    public void setCurrentValue(T newVal) {
        this.currentValue = newVal;
    }
}
