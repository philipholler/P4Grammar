package codegen.default_classes;

import java.util.ArrayList;

public abstract class Device {

    private String networkID;

    public Device(String networkID) {
        this.networkID = networkID;
    }
}
