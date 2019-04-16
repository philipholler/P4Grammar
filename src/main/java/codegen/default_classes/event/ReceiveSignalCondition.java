package codegen.default_classes.event;

import codegen.default_classes.SignalData;

public class ReceiveSignalCondition implements EventCondition {
    @Override
    public boolean isFullFilled(SignalData signalData) {
        return false;
    }

}
