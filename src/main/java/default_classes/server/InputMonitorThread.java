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
    private Runnable onconnectionFailed;

    private boolean running = false;

    public InputMonitorThread(Socket socket, Consumer<String> onSignalReceived, Runnable onconnectionFailed) {
        this.socket = socket;
        this.onSignalReceived = onSignalReceived;
        this.onconnectionFailed = onconnectionFailed;
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
            while (isRunning() && !socket.isClosed()) {
                message = in.nextLine();
                if(message == null || !isRunning() || socket.isClosed())
                    terminate();

//                while(!in.hasNextLine()){
//                    Thread.sleep(500);
//
                    // Stop executing if the connection is terminated
//                        return;
//                    }
//                    System.out.println();
//                }

                System.out.println("Received signal : " + message);
                if (onSignalReceived != null)
                    onSignalReceived.accept(message);
            }
        }catch (NoSuchElementException e){
            // Server connection has been lost
            System.err.println("Client connection terminated");
            terminate();

            if(onconnectionFailed != null)
                onconnectionFailed.run();
        }
    }

    synchronized void terminate(){
        setRunning(false);
        if(!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Attempt to close client socket failed");
            }
        }
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