import calendarlogic.CalendarContext;
import calendarstructs.AllDayEvent;
import calendarstructs.CalendarEvent;
import calendarstructs.TimeOfDayEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.util.Locale;


public class Main
{
    public static void main(String[] args)
    {

        LocalTime curTime = LocalTime.now();
        LocalDate nowDate = LocalDate.now();
        CalendarContext calendarContext = new CalendarContext(nowDate);
        Locale locale = Locale.getDefault();

        System.out.println(locale);

        Duration duration = Duration.ofHours(2);
        String eventDescription1 = "Meeting 1";
        String eventDescription2 = "Meeting 2";

        CalendarEvent event1 = new AllDayEvent(nowDate, eventDescription1);
        CalendarEvent event2 = new TimeOfDayEvent(nowDate.plusDays(1), eventDescription2, curTime.plusHours(1), duration);

        System.out.println(event1);
        System.out.println(event2);

        calendarContext.addEvent(event1);
        calendarContext.addEvent(event2);


        calendarContext.startCalendar();
    }
}
