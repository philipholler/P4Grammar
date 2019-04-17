package codegen.default_classes.defaultGeneration.device;

import codegen.default_classes.defaultGeneration.signal.OpenSignal;

public class Window extends Device{

    private OpenSignal openSignal = new OpenSignal(0, 100);

    public Window(String networkID) {
        super(networkID);
    }

    public OpenSignal getOpenSignal(){
        return openSignal;
    }

}
