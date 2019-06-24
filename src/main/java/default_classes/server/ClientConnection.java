package default_classes.server;

import default_classes.SignalUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ClientConnection extends Thread {
    ClientInformation clientInfo;

    private Scanner inputStream;
    private PrintWriter out;
    private Socket socket;

    private LinkedBlockingQueue<String> messagesToBeSent = new LinkedBlockingQueue<>();
    private String messageToBeSent = null;
    private InputMonitorThread inputMonitorThread;
    private Server server;

    private boolean running = true;

    public ClientConnection(Socket socket, Server server) {
        this.socket = socket;
        inputMonitorThread = new InputMonitorThread(socket,
                (str) -> server.addRecievedSignal(SignalUtils.parseSignalData(str)));
        this.server = server;
    }

    @Override
    public synchronized void start() {
        running = true;
        ClientInformation client = new ClientInformation();
        try {
            inputStream = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //adds the clients information to the ClientInfo
        client.setIp(socket.getInetAddress());
        client.setPort(socket.getPort());
        client.setDeviceName(inputStream.nextLine());
        clientInfo = client;
        System.out.println("Client accepted: " + socket.getRemoteSocketAddress().toString());
        inputMonitorThread.start();

        super.start();
    }

    public void run() {
        try {
            while (isRunning()) {
                // Attempt to retrieve message, waiting for at most 5 seconds
                String message = messagesToBeSent.poll(5, TimeUnit.SECONDS);

                // Stop running if the connection is lost or the thread is stopped
                if (!isRunning() || socket.isClosed()) {
                    terminate();
                    return;
                }

                // Send message if one was retrievable
                if (message != null){
                    System.out.println("Sent message : " + message +
                            "\nTo device : " + clientInfo.getDeviceName());
                    out.println(message);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(!socket.isClosed())
                closeSocket();
        }
    }

    private void closeSocket(){
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Failed to close socket for client : " + clientInfo.getDeviceName());
            System.err.println("Socket status : " + socket.isConnected());
        }
    }

    public synchronized void terminate() {
        running = false;
        inputMonitorThread.terminate();
    }

    public synchronized boolean isRunning() {
        return running;
    }

    //sets the message that is being sent to the client
    public void sendMessage(String message) {
        messagesToBeSent.add(message);
    }

}