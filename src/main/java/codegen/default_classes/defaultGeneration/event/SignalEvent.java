package codegen.default_classes.defaultGeneration.event;

import codegen.default_classes.defaultGeneration.SignalData;

public interface SignalEvent {

    boolean satisfiesCondition(SignalData data);

    void executeEvent();

}
