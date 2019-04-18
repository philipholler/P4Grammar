package default_classes.server;

import default_classes.SignalData;
import default_classes.event.SignalEventManager;

import java.util.Scanner;

public class Server extends Thread{

    private SignalEventManager signalEventManager;

    public Server(SignalEventManager signalEventManager) {
        this.signalEventManager = signalEventManager;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(!Thread.interrupted()){
            String input = scanner.nextLine();
            SignalData signalData = parseInput(input);

            if(signalData != null){
                signalEventManager.addSignal(signalData);
            }else{
                System.err.println("SERVER: Invalid input : " + input);
            }
        }
    }

    private SignalData parseInput(String input){
        if(input.isEmpty()) return null;

        String[] string = input.split(" ");
        if(string.length != 3) return null;

        return new SignalData(string[0], string[1], string[2]);
    }
}
