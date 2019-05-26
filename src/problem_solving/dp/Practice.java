package problem_solving.dp;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Date;
import java.util.TimeZone;

import static org.joda.time.Days.daysBetween;

public class Practice {
    public static void main(String[] args) {
        cal();
        final TimeZone zone = TimeZone.getDefault();
        System.out.println(zone);
    }

    public static int getNoOfDaysBetweenTwoDates(Date start, Date end) {
        DateTime start1 = new DateTime(start);
        DateTime end1 = new DateTime(end);
        int days = daysBetween(start1.withTimeAtStartOfDay(), end1.withTimeAtStartOfDay()).getDays();
        return days;
    }

    public static void cal() {
        // 12:45 am on the 20th to 1pm on the 21st, May 2019
        DateTimeZone zone = DateTimeZone.forID("Asia/Kolkata");
        DateTime start = new DateTime(2019, 5, 20, 0, 45, 0, zone);
        DateTime end = new DateTime(2019, 5, 21, 13, 0, 0, zone);

        System.out.println(daysBetween(start.withTimeAtStartOfDay(),
                end.withTimeAtStartOfDay()).getDays());

        System.out.println(daysBetween(start.toLocalDate(),
                end.toLocalDate()).getDays());

        System.out.println(daysBetween(start.toLocalDateTime(),
                end.toLocalDateTime()).getDays());

    }
}
