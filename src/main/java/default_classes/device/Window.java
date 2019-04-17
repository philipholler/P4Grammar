package default_classes.device;

import default_classes.signal.OpenSignal;

public class Window extends Device{

    private OpenSignal openSignal = new OpenSignal(0, 100);

    public Window(String networkID) {
        super(networkID);
    }

    public OpenSignal getOpenSignal(){
        return openSignal;
    }

}
