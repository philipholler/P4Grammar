package default_classes.device;

import default_classes.signal.Signal;

public abstract class Device {

    private String networkID;

    public Device(String networkID) {
        this.networkID = networkID;
    }

    public String getNetworkID() {
        return networkID;
    }

    public abstract Signal getSignal(String name);


}