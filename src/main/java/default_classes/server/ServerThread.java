package default_classes.server;

import default_classes.SignalUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ServerThread extends Thread {
    ClientInformation clientInfo;

    Scanner inputStream;
    PrintWriter out;
    private Socket socket;
    private String message = null;
    private LinkedBlockingQueue<String> messagesToBeSent = new LinkedBlockingQueue<>();
    private String messageToBeSent = null;
    InputMonitorThread inputMonitorThread;
    Server server;

    private boolean running = true;

    public ServerThread(Socket socket, Server server) {
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

        //adds the clients information to the hashset listOfClients
        client.setIp(socket.getInetAddress());
        client.setPort(socket.getPort());
        client.setDeviceName(inputStream.nextLine());
        clientInfo = client;
        System.out.println("Client accepted: " + socket.getRemoteSocketAddress().toString());
        inputMonitorThread.start();
        super.start();
    }

    public void run() {
        while (running) {
            //send messageToBeSent if its not equal null
            try {
                String message = messagesToBeSent.poll(10, TimeUnit.SECONDS);

                if(socket.isClosed()){
                    stopServerThread();
                    return;
                }

                if(messageToBeSent != null)
                    out.println(messagesToBeSent.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void stopServerThread(){
        running = false;
        server.removeConnectionThread(this);

    }

    //sets the message that is being sent to the client
    public void setMessageToBeSent(String message) {
        messagesToBeSent.add(message);
    }

}