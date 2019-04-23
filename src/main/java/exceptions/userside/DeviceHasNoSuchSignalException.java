package exceptions.userside;

public class DeviceHasNoSuchSignalException extends CompileErrorException{

    public DeviceHasNoSuchSignalException(String msg, int lineNumber) {
        super(msg, lineNumber);
    }

    public DeviceHasNoSuchSignalException(String msg) {
        super(msg);
    }
}
