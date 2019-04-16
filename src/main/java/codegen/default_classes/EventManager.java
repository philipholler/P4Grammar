package codegen.default_classes;

public class EventManager {


    public void run(){
        Server server = new Server();

        while(true){
            SignalData signalData = server.pollSignal();
            if(signalData != null)
                parseSignal(signalData);
        }
    }

    public void parseSignal(SignalData signalData){

    }








}
