package default_classes.device;

public abstract class Device {

    private String networkID;

    public Device(String networkID) {
        this.networkID = networkID;
    }

    public String getNetworkID() {
        return networkID;
    }
}