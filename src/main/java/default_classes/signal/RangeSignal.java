package default_classes.signal;

public abstract class RangeSignal<T extends Number> extends Signal<T> {

    private T lowerBound, upperBound;

    public RangeSignal(T lowerBound, T upperBound, T defaultValue){
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        setCurrentValue(defaultValue);
    }

    public T getUpperBound(){
        return upperBound;
    }

    public T getLowerBound(){
        return upperBound;
    }

    public boolean isValueInRange(T value){
        if(value instanceof Integer){
            Integer low = (Integer) lowerBound;
            Integer high = (Integer) upperBound;
            return (((Integer) value) >= low && ((Integer) value) <= high);
        }else if(value instanceof Float){
            Float low = (Float) lowerBound;
            Float high = (Float) upperBound;
            return (((Float) value) >= low && ((Float) value) <= high);
        }else{
            throw new RuntimeException("A range signal should only ever be of type Float or Integer, but signal "
                    + RangeSignal.class.getSimpleName() + " is of type " + value.getClass().getSimpleName());
        }
    }

}
