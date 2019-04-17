package default_classes.signal;

public interface Signal <T> {

    T getCurrentValue();

    void setCurrentValue(T newVal);

    void setCurrentValue(String newVal);



    default String getName(){
        return getClass().getSimpleName();
    }

}
