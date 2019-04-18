package default_classes.event;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeConditionEvent implements TimeEvent{

    private LocalDateTime nextExecutionTime;

    private Thread eventThread;
    private final Runnable eventAction;

    private static final int UNSPECIFIED = -1;
    private final int year, month, day, hour, minute;


    private boolean atomEvent = false; // Will this event only be executed one time?

    public TimeConditionEvent(int year, int month, int day, int hour, int minute, Runnable eventAction) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.eventAction = eventAction;
        initNextExecutionTime();
    }

    public TimeConditionEvent(int month, int day, int hour, int minute, Runnable eventAction) {
        this(UNSPECIFIED, month, day, hour, minute, eventAction);
    }

    public TimeConditionEvent(int day, int hour, int minute, Runnable eventAction) {
        this(UNSPECIFIED, UNSPECIFIED, day, hour, minute, eventAction);
    }

    public TimeConditionEvent(int hour, int minute, Runnable eventAction) {
        this(UNSPECIFIED, UNSPECIFIED, UNSPECIFIED, hour, minute, eventAction);
    }

    private void initNextExecutionTime() {
        // Set the starting date for when this should first run
        int y, mo, d, h, min;

        if(year == UNSPECIFIED)
            y = LocalDate.now().getYear();
        else{
            atomEvent = true;
            y = year;
        }

        if(month == UNSPECIFIED)
            mo = LocalDate.now().getMonth().getValue();
        else
            mo = month;

        if(day == UNSPECIFIED)
            d = LocalDate.now().getDayOfMonth();
        else
            d = day;

        h = hour;
        min = minute;

        // If the event time has already passed then reschedule
        nextExecutionTime = LocalDateTime.of(y, mo, d, h, min);
        if(nextExecutionTime.compareTo(LocalDateTime.now()) < 0)
            rescheduleEvent();

        // Todo : Might need to update definition of the DateNode class. Should the user be able
        // Todo : to do something on the 1st of every month?
    }

    @Override
    public void executeEventThread() {
        // Stop previous thread if it's still running
        while(eventThread != null && eventThread.isAlive()){
            eventThread.interrupt();
        }

        eventThread = new Thread(eventAction);
        eventThread.start();
    }

    @Override
    public void rescheduleEvent() {
        if(day == UNSPECIFIED){
            nextExecutionTime = nextExecutionTime.plusDays(1);
        }else if(month == UNSPECIFIED){
            nextExecutionTime = nextExecutionTime.plusMonths(1);
        }else if(year == UNSPECIFIED){
            nextExecutionTime = nextExecutionTime.plusYears(1);
        }
    }

    @Override
    public LocalDateTime getNextExecutionTime() {
        return nextExecutionTime;
    }

}
