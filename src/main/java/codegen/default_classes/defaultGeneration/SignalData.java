package codegen.default_classes.defaultGeneration;

import java.util.Objects;

public class SignalData {

    public final String hardwareId, signalType, value;

    public SignalData(String hardwareId, String signalType, String value) {
        this.hardwareId = hardwareId;
        this.signalType = signalType;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignalData that = (SignalData) o;
        return Objects.equals(hardwareId, that.hardwareId) &&
                Objects.equals(signalType, that.signalType) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hardwareId, signalType, value);
    }

    @Override
    public String toString() {
        return "SignalData{" +
                "hardwareId='" + hardwareId + '\'' +
                ", signalType='" + signalType + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
