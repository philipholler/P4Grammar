package default_classes.server;

import default_classes.SignalData;
import default_classes.event.SignalEventManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Server extends Thread {

    ConcurrentLinkedQueue<SignalData> signalQueue = new ConcurrentLinkedQueue<>();
    public ArrayList<ServerThread> clientConnectThreads = new ArrayList<>();
    Socket socket = null;
    ServerSocket serversocket = null;

    private final int serverPort = 8000;

    private SignalEventManager signalEventManager;

    public Server(SignalEventManager signalEventManager) {
        this.signalEventManager = signalEventManager;
    }

    @Override
    public synchronized void start() {
        System.out.println("Server starting......");
        try {
            serversocket = new ServerSocket(serverPort);
            System.out.println("Server socket opened on port : " + serverPort);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server error");
        }

        super.start();
    }

    public static void main(String[] args) {
        Server server = new Server(new SignalEventManager(new ArrayList<>(), new ArrayList<>()));
        server.start();
    }

    @Override
    public void run() {
        System.out.println("Server now accepting connections");

        while (true) {
            try {
                socket = serversocket.accept();
                System.out.println("\nIncoming connection... ");
                //a new thread is created to handle the conection with the connecting device
                ServerThread st = new ServerThread(socket, this);
                st.start();

                //the thread is added to the list of threads
                clientConnectThreads.add(st);

                // Report status
                System.out.println("Connected to client : '" + st.clientInfo.getDeviceName() + "'");
                System.out.println("Currently " + clientConnectThreads.size() + " clients are connected");
            } catch (IOException e) {
                System.err.println("Failed to establish connection");
                e.printStackTrace();
            }
        }

    }

    //Sends a signal to the device that matches Signalsdata hardware id
    public synchronized void sendSignal(SignalData data) {
        for (ServerThread thread : clientConnectThreads) {
            if (thread.clientInfo.getDeviceName().equals(data.hardwareId))
                thread.setMessageToBeSent(data.signalType + " " + data.data);
        }
    }

    //returns the first signal in signalqueue and removes it
    public SignalData pollSignal() {
        return signalQueue.poll();
    }

    public synchronized void addRecievedSignal(SignalData signalData) {
        signalEventManager.addSignal(signalData);
    }
    public ArrayList<ServerThread> getClientConnectThreads(){
        return clientConnectThreads;
    }

    public synchronized void removeConnectionThread(ServerThread serverThread) {
        clientConnectThreads.remove(serverThread);
    }
}



