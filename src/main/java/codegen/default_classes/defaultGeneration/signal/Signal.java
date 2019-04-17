package codegen.default_classes.defaultGeneration.signal;

public interface Signal <T> {

    T getCurrentValue();
    void setCurrentValue(T newVal);

}
