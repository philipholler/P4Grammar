package codegen.default_classes;

public class FloatRange extends RangeSignal<Float> {

    public FloatRange(Float lowerBound, Float upperBound, Float defaultValue) {
        super(lowerBound, upperBound, defaultValue);
    }

    public FloatRange(Float lowerBound, Float upperBound) {
        super(lowerBound, upperBound, 0f);
    }

    @Override
    boolean isValueInRange(Float value) {
        return false;
    }
}
