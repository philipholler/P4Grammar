package codegen.default_classes;

public class IntegerRange extends RangeSignal<Integer>{



    public IntegerRange(Integer lowerBound, Integer upperBound) {
        super(lowerBound, upperBound, 0);
    }

    public IntegerRange(Integer lowerBound, Integer upperBound, Integer defaultValue) {
        super(lowerBound, upperBound, defaultValue);
    }

    @Override
    boolean isValueInRange(Integer value) {
        return (value >= getLowerBound() && value <= getUpperBound());
    }

    @Override
    public Integer getCurrentValue() {
        return super.getCurrentValue();
    }
}
