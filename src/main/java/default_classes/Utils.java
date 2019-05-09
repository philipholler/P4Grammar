package default_classes;

import default_classes.device.Device;
import default_classes.event.SignalEventManager;
import default_classes.server.Server;
import default_classes.signal.Signal;

import java.time.*;

public class Utils {
    public static final int UNDEFINED = -1;

    public static boolean isComparisonTrue(LocalDateTime now, ComparisonOperator operator, Object time, boolean shouldBeFlipped){
        int result = nowComparedTo(time, now);

        if(shouldBeFlipped){
            operator = flipOperator(operator);
        }

        switch (operator){
            case GREATERTHAN:
                return result > 0;
            case GREANTHANEQUAL:
                return result >= 0;
            case SMALLERTHAN:
                return result < 0;
            case SMALLERTHANEQUAL:
                return result <= 0;
            case EQUALTO:
                return result == 0;
            case NOTEQUAL:
                return result != 0;
        }

        return true;
    }

    private static ComparisonOperator flipOperator(ComparisonOperator op){
        switch (op) {
            case GREATERTHAN:
                return ComparisonOperator.SMALLERTHAN;
            case GREANTHANEQUAL:
                return ComparisonOperator.SMALLERTHANEQUAL;
            case SMALLERTHAN:
                return ComparisonOperator.GREATERTHAN;
            case SMALLERTHANEQUAL:
                return ComparisonOperator.GREANTHANEQUAL;
            case EQUALTO:
                return ComparisonOperator.EQUALTO;
            case NOTEQUAL:
                return ComparisonOperator.NOTEQUAL;
        }

        throw new RuntimeException("Could not flip operater '" + op.opString + "'");
    }

    private static int nowComparedTo(Object o, LocalDateTime now){
        // For 22d04m2019y
        if(o instanceof LocalDate){
            LocalDate t = (LocalDate) o;
            return nowComparedToDate(UNDEFINED, UNDEFINED, t.getDayOfMonth(), t.getMonthValue(), t.getYear(), now);
        }
        // For 22d04m
        if(o instanceof MonthDay){
            MonthDay m = (MonthDay) o;
            return nowComparedToDate(UNDEFINED, UNDEFINED, m.getDayOfMonth(), m.getMonthValue(), UNDEFINED, now);
        }
        // for 22d
        if(o instanceof Integer){
            int i = (Integer) o;
            return nowComparedToDate(UNDEFINED, UNDEFINED, i, UNDEFINED, UNDEFINED, now);
        }
        // For 14:00
        if(o instanceof LocalTime){
            LocalTime t = (LocalTime) o;
            return nowComparedToDate(t.getMinute(), t.getHour(), UNDEFINED, UNDEFINED, UNDEFINED, now);
        }

        // Else throw exception
        throw new RuntimeException("Could now determine object to compare time to. Tried to compare '" +
                o.getClass().getSimpleName() +
                "' to '" +
                "LocalDateTime, Monthday, DayOfWeek and LocalTime'");
    }

    private static int nowComparedToDate(int minutes, int hours, int day, int month, int year, LocalDateTime now){
        LocalDateTime filledInTime = fillInMissing(minutes, hours, day, month, year, now);

        return now.compareTo(filledInTime);
    }

    private static LocalDateTime fillInMissing(int minutes, int hours, int day, int month, int year, LocalDateTime now){
        if(minutes == UNDEFINED) minutes = now.getMinute();
        if(hours == UNDEFINED) hours = now.getHour();
        if(day == UNDEFINED) day = now.getDayOfMonth();
        if(month == UNDEFINED) month = now.getMonthValue();
        if(year == UNDEFINED) year = now.getYear();

        return LocalDateTime.of(year, month, day, hours, minutes, now.getSecond(), now.getNano());
    }

    public static void interruptCheck(){
        if(Thread.interrupted()){
            System.out.println("Thread STOPPING");
            throw new ThreadDeath();
        }
    }

    public static int getLongEnoughMonth(int minimumDays) {
        return getLongEnoughMonth(minimumDays, LocalDate.now());
    }

    public static int getLongEnoughMonth(int minimumDays, LocalDate startingPoint) {
        if (minimumDays > 31 || minimumDays < 0)
            throw new RuntimeException("Attempted to find month with more than: " + minimumDays + " days");

        LocalDate date = startingPoint;
        Month month = date.getMonth();
        while (month.maxLength() > minimumDays) {
            date = date.plusMonths(1);
            month = date.getMonth();
        }

        return month.getValue();
    }

    public static void sendSignal (Server server, Device dev, Signal signal, String val){
        server.sendSignal(new SignalData(dev.getNetworkID(), signal.getName(), val));
        signal.setCurrentValue(val);
    }

}
