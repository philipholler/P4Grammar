package codegen.default_classes.event;

import node.Events.EventEveryNode;
import node.Statements.Wait.TimeFrame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeIntervalEvent implements TimeEvent {

    private LocalDateTime nextExecutionTime;
    private Thread eventThread;

    private TimeFrame timeFrame; // Include TimeFrame in the compiled code
    private int delay;

    private LocalDate startDate; // todo : run initExecutionTime at the start of every year
    private LocalTime startTime;

    public TimeIntervalEvent(TimeFrame timeFrame, int delay, Runnable eventAction,
                             LocalDate startDate, LocalTime startTime){
        this.timeFrame = timeFrame;
        this.delay = delay;
        this.startTime = startTime;
        this.startDate = startDate;
        eventThread = new Thread(eventAction);
        initExecutionTime();
    }

    // Set execution time to be the starting time specified in the node
    // If no time is specified the value defaults to .now()
    private void initExecutionTime(){

        if(startDate == null)
            startDate = LocalDate.now();

        if(startTime == null)
            startTime = LocalTime.now();

        nextExecutionTime = LocalDateTime.of(startDate, startTime);
    }

    // Runs the code that should be executed when the condition is fulfilled
    @Override
    public void executeEventThread() {
        if(eventThread.isAlive()){
            eventThread.interrupt();

            System.out.println("\nEvent thread for time interval node interrupted.");
            // todo specify node
        }

        eventThread.run();
    }

    // Updates the nextExecutionTime to be the current execution time plus whatever delay is specified in the
    // event definition
    @Override
    public void rescheduleEvent() {
        switch (timeFrame){
            case MONTH:
                nextExecutionTime = nextExecutionTime.plusMonths(delay);
                break;
            case WEEK:
                nextExecutionTime = nextExecutionTime.plusWeeks(delay);
                break;
            case DAY:
                nextExecutionTime = nextExecutionTime.plusDays(delay);
                break;
            case HOUR:
                nextExecutionTime = nextExecutionTime.plusHours(delay);
                break;
            case MINUTES:
                nextExecutionTime = nextExecutionTime.plusMinutes(delay);
                break;
            case SECOND:
                nextExecutionTime = nextExecutionTime.plusSeconds(delay);
                break;
            case MILLISECONDS:
                nextExecutionTime = nextExecutionTime.plusNanos(delay * 1000000L); // convert millis to nanos
                break;
        }
    }

    @Override
    public LocalDateTime getNextExecutionTime() {
        return nextExecutionTime;
    }

}