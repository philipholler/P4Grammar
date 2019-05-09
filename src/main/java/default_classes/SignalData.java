package default_classes;

import java.util.Objects;

public class SignalData {

    public final String hardwareId, signalType, data;

    public SignalData(String hardwareId, String signalType, String data) {
        this.hardwareId = hardwareId;
        this.signalType = signalType;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignalData that = (SignalData) o;
        return Objects.equals(hardwareId, that.hardwareId) &&
                Objects.equals(signalType, that.signalType) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hardwareId, signalType, data);
    }

    public String toSignalString() {
        return hardwareId + " " + signalType + " " + data;
    }
}
