package codegen.default_classes.event;

import codegen.default_classes.SignalData;

public interface EventCondition {

    boolean isFullFilled(SignalData signalData);

}
