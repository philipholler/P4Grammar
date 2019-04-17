package default_classes.event;

import default_classes.SignalData;

public interface SignalEvent {

    boolean satisfiesCondition(SignalData data);

    void executeEvent();

}
