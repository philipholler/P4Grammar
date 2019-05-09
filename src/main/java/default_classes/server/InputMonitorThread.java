package default_classes.server;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Consumer;

public class InputMonitorThread extends Thread {
    private Socket socket;
    private String message = null;
    Scanner in;

    private Consumer<String> onSignalReceived;
    private Runnable onConnectionLost;

    private boolean running = false;

    public InputMonitorThread(Socket socket, Consumer<String> onSignalReceived, Runnable onConnectionLost) {
        this.socket = socket;
        this.onSignalReceived = onSignalReceived;
        this.onConnectionLost = onConnectionLost;
    }

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
        running = true;
        try {
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            System.err.println("Failed to start InputListenerThread");
            e.printStackTrace();
            return;
        }

        super.start();
    }

    public void run() {
        try{
            while (isRunning()) {
                message = in.nextLine();
                System.out.println("Received signal : " + message);
                if (onSignalReceived != null)
                    onSignalReceived.accept(message);
            }
        }catch (NoSuchElementException e){
            // Server connection has been lost
            System.err.println("Client connection terminated");

            if(onConnectionLost != null)
                onConnectionLost.run();
        }
    }

    protected synchronized void stopThread(){
        setRunning(false);
    }

    private synchronized void setRunning(boolean running){
        this.running = running;
    }

    public synchronized boolean isRunning() {
        return running;
    }

    public String getMessage() {
        return message;

    }
}