package default_classes.server;

import default_classes.SignalData;
import default_classes.SignalUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerThread extends Thread {
    ClientInformation clientInfo;

    Scanner inputStream;
    PrintWriter out;
    private Socket s;
    private String message = null;
    private LinkedBlockingQueue<String> messagesToBeSent = new LinkedBlockingQueue<>();
    private String messageToBeSent = null;
    InputMonitorThread inputMonitorThread;
    Server server;

    public ServerThread(Socket s, Server server) {
        this.s = s;
        inputMonitorThread = new InputMonitorThread(s,
                (str) -> server.addRecievedSignal(SignalUtils.parseSignalData(str)));
        this.server = server;
    }

    @Override
    public synchronized void start() {

        ClientInformation client = new ClientInformation();
        try {
            inputStream = new Scanner(s.getInputStream());
            out = new PrintWriter(s.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //adds the clients information to the hashset listOfClients
        client.setIp(s.getInetAddress());
        client.setPort(s.getPort());
        client.setDeviceName(inputStream.nextLine());
        clientInfo = client;
        System.out.println("Client accepted: " + s.getRemoteSocketAddress().toString());
        inputMonitorThread.start();
        super.start();
    }

    public void run() {
        while (true) {
            //send messageToBeSent if its not equal null
            try {
                out.println(messagesToBeSent.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //sets the message that is being sent to the client
    public void setMessageToBeSent(String message) {
        messagesToBeSent.add(message);
    }

}