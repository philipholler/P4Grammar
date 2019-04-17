package codegen.default_classes;

public abstract class Device {

    private String networkID;

    public Device(String networkID) {
        this.networkID = networkID;
    }
}