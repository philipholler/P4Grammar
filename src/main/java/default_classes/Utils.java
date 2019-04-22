package default_classes;

import java.time.*;

public class Utils {
    /**
     *
     * @return 1 if now is bigger than monthday, 0 if they are equal and -1 if monthDay is bigger.
     */
    public static int compareMonthToNow(MonthDay monthDay){
        int month = monthDay.getMonth().getValue();
        int day = monthDay.getDayOfMonth();

        // If localDate month smaller than now
        if(month < MonthDay.now().getMonthValue()){
            return 1;
        }

        // If localDate month is the same, but the day is smaller
        if(month == MonthDay.now().getMonthValue() && day < MonthDay.now().getDayOfMonth()){
            return 1;
        }

        // If they are identical
        if(month == MonthDay.now().getMonthValue() && day == MonthDay.now().getDayOfMonth()){
            return 0;
        }

        // Else monthDay must be bigger
        return -1;
    }


    /**
     * @return 1 if now is bigger than localDateTime, 0 if equal and -1 if localDateTime is bigger.
     */
    public static int compareDateToNow(LocalDateTime localDateTime){
        int day = localDateTime.getDayOfMonth();
        int month = localDateTime.getMonthValue();
        int year = localDateTime.getYear();

        // If now has a higher year, it is obviously bigger
        if(year < LocalDateTime.now().getYear()){
            return 1;
        }

        // If year is the same, but now has a bigger month
        if(year == LocalDateTime.now().getYear() && month < LocalDateTime.now().getMonthValue()){
            return 1;
        }

        // If year and month are the same, but day of localDateTime is smaller than now's
        if(year == LocalDateTime.now().getYear() && month == LocalDateTime.now().getMonthValue() && day < LocalDateTime.now().getDayOfMonth()){
            return 1;
        }

        // If both day, month and year are the same. They are considered equal
        if(year == LocalDateTime.now().getYear() && month == LocalDateTime.now().getMonthValue() && day == LocalDateTime.now().getDayOfMonth()){
            return 0;
        }

        return -1;
    }

    /**
     * Compares a LocalTime to now.
     * @return If the localTime is smaller, it returns 1. If they are equal, it returns 0, else -1.
     */
    public static int compareTimeToNow(LocalTime localTime){
        int hour = localTime.getHour();
        int minute = localTime.getMinute();

        // If now's hour is bigger, or the hours are identical, but now's minutes are bigger, return 1.
        if(hour < LocalTime.now().getHour() || (hour == LocalTime.now().getHour() && minute < LocalTime.now().getMinute())){
            return 1;
        }
        // If identical return 0;
        else if (hour == LocalTime.now().getHour() && minute == LocalTime.now().getMinute()){
            return 0;
        }
        // Else localTime must be bigger. return -1
        else {
            return -1;
        }
    }

    /**
     * @return 1 if now is bigger, 0 if identical and -1 if day is bigger than now.
     */
    public static int compareDayToNow(int day){
        // If now's day is bigger, return 1
        if(day < LocalDate.now().getDayOfMonth()){
            return 1;
        }
        // If they are identical, return 0;
        else if (day == LocalDate.now().getDayOfMonth()){
            return 0;
        }
        // Else day must be bigger
        else {
            return -1;
        }
    }
}
