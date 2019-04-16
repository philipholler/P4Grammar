package codegen.default_classes.event;

import node.Events.EventEveryNode;
import node.Statements.Wait.TimeFrame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeIntervalEvent implements TimeEvent {

    private LocalDateTime nextExecutionTime;
    private EventEveryNode eventNode;
    private Thread eventThread;

    public TimeIntervalEvent(EventEveryNode node, Runnable eventAction){
        this.eventNode = node;
        eventThread = new Thread(eventAction);
        initExecutionTime();
    }

    // Set execution time to be the starting time specified in the node
    // If no time is specified the value defaults to .now()
    private void initExecutionTime(){
        LocalDate startDate;
        LocalTime startTime;

        if(eventNode.getDateNode() != null)
            startDate = eventNode.getDateNode().getDate();
        else
            startDate = LocalDate.now();

        if(eventNode.getTimeNode() != null)
            startTime = eventNode.getTimeNode().getTime();
        else
            startTime = LocalTime.now();

        nextExecutionTime = LocalDateTime.of(startDate, startTime);
    }

    @Override
    public void executeEventThread() {
        if(eventThread.isAlive()){
            eventThread.interrupt();

            System.out.println("\nEvent thread for time interval node interrupted. Node : ");
            System.out.println(eventNode.toString() + "\n");
        }

        eventThread.run();
    }

    @Override
    public void rescheduleEvent() {
        TimeFrame timeFrame = eventNode.getTimeframe();
        long interval = eventNode.getInteger().getVal();
        switch (timeFrame){
            case MONTH:
                nextExecutionTime = nextExecutionTime.plusMonths(interval);
                break;
            case WEEK:
                nextExecutionTime = nextExecutionTime.plusWeeks(interval);
                break;
            case DAY:
                nextExecutionTime = nextExecutionTime.plusDays(interval);
                break;
            case HOUR:
                nextExecutionTime = nextExecutionTime.plusHours(interval);
                break;
            case MINUTES:
                nextExecutionTime = nextExecutionTime.plusMinutes(interval);
                break;
            case SECOND:
                nextExecutionTime = nextExecutionTime.plusSeconds(interval);
                break;
            case MILLISECONDS:
                nextExecutionTime = nextExecutionTime.plusNanos(interval * 1000000L); // convert millis to nanos
                break;
        }
    }

    @Override
    public LocalDateTime getNextExecutionTime() {
        return nextExecutionTime;
    }

}
