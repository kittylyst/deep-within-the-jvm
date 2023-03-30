package kathik.session5;

import java.time.DayOfWeek;

public class Days {
    public static boolean isWorkDay(DayOfWeek day){
        var today = switch(day) {
            case SATURDAY, SUNDAY -> false;
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
        };

        // Do any further processing for e.g. public holidays...

        return today;
    }
}
