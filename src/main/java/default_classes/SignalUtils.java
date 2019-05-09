package default_classes;

public class SignalUtils {

    //splits up the incoming signal
    public static String[] splitter(String message) {
        String[] splitmsg = message.split("\\s+");
        return splitmsg;
    }

    // TODO: 30-04-2019 handle edge cases
    public static SignalData parseSignalData(String string) {
        String[] arr = splitter(string);
        return new SignalData(arr[0], arr[1], arr[2]);
    }

    public static SignalData parseSignalData(String string, String hardwareId) {
        String[] arr = splitter(string);
        return new SignalData(hardwareId, arr[0], arr[1]);
    }

}
