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
    public ArrayList<ClientConnection> clientConnectThreads = new ArrayList<>();
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

    @Override // The main server loop listens for connection attempts from clients
    public void run() {
        System.out.println("Server now accepting connections");

        while (true) {
            try {
                acceptClientConnection();
            } catch (IOException e) {
                System.err.println("Failed to establish connection");
                e.printStackTrace();
            }
        }
    }

    // Waits for a new incoming connection
    private void acceptClientConnection() throws IOException {
        socket = serversocket.accept();
        System.out.println("\nIncoming connection... ");
        //a new thread is created to handle the conection with the connecting device
        ClientConnection st = new ClientConnection(socket, this);
        st.start();

        //the thread is added to the list of threads
        removeOldConnection(st);
        clientConnectThreads.add(st);

        // Report status
        System.out.println("Connected to client : '" + st.clientInfo.getDeviceName() + "'");
        System.out.println("Currently " + clientConnectThreads.size() + " clients are connected");
    }

    // Looks for an already existing connection with the same hardware id and removes it if it exists
    private synchronized void removeOldConnection(ClientConnection clientConnection){
        for(ClientConnection connection : clientConnectThreads){
            if(connection.clientInfo.getDeviceName().equals(clientConnection.clientInfo.getDeviceName())){
                removeConnectionThread(connection);
                return;
            }
        }
    }

    //Sends a signal to the device that matches SignalData hardware id
    public synchronized void sendSignal(SignalData data) {
        for (ClientConnection thread : clientConnectThreads) {
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
    public ArrayList<ClientConnection> getClientConnectThreads(){
        return clientConnectThreads;
    }

    public synchronized void removeConnectionThread(ClientConnection clientConnection) {
        clientConnectThreads.remove(clientConnection);
    }
}



