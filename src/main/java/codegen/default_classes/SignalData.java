package codegen.default_classes;

public class SignalData {

    public final String hardwareId, signalType, data;

    public SignalData(String hardwareId, String signalType, String data) {
        this.hardwareId = hardwareId;
        this.signalType = signalType;
        this.data = data;
    }

}
