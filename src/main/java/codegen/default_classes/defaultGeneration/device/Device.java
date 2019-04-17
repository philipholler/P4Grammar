package codegen.default_classes.defaultGeneration.device;

public abstract class Device {

    private String networkID;

    public Device(String networkID) {
        this.networkID = networkID;
    }

    public String getNetworkID() {
        return networkID;
    }
}