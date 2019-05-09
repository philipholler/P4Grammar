package default_classes.server;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Consumer;

public class InputMonitorThread extends Thread {
    private Socket socket;
    private String message = null;
    private Consumer<String> onSignalReceived;
    Scanner in;

    public InputMonitorThread(Socket socket, Consumer<String> onSignalReceived) {
        this.socket = socket;
        this.onSignalReceived = onSignalReceived;
    }

    public InputMonitorThread(Socket socket) {
        this.socket = socket;
        this.onSignalReceived = null;
    }

    @Override
    public synchronized void start() {
        try {
            in = new Scanner(socket.getInputStream());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.start();
    }

    public void run() {
        try{
            while (true) {
                message = in.nextLine();

                if (onSignalReceived != null)
                    onSignalReceived.accept(message);
            }
        }catch (NoSuchElementException e){
            System.err.println("Client connection terminated");
        }
    }

    public String getMessage() {
        return message;

    }
}