package default_classes.server;

import java.net.InetAddress;

public class ClientInformation {
    private InetAddress ip;
    private int port;
    private String deviceName;

    public InetAddress getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public String toString() {
        return "ClientInformation{" +
                "ip=" + ip +
                ", port=" + port +
                ", deviceName='" + deviceName + '\'' +
                '}';
    }
}
