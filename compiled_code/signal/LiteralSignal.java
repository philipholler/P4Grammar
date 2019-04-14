package codegen.default_classes;

import java.util.ArrayList;

public class LiteralSignal<T> implements Signal<T> {

    private ArrayList<T> legalValues;
    private T currentValue;

    public LiteralSignal(ArrayList<T> legalValues, T defaultValue){
        this.legalValues = legalValues;
        this.currentValue = defaultValue;
    }

    @Override
    public T getCurrentValue() {
        return currentValue;
    }

    @Override
    public void setCurrentValue(T newVal) {
        currentValue = newVal;
    }

    public boolean isLegalValue(T val){
        return legalValues.contains(val);
    }

}
