package codegen.default_classes;

public interface Signal <T> {

    T getCurrentValue();
    void setCurrentValue(T newVal);

}
