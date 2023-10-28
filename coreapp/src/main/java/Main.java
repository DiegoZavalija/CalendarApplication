import calendarlogic.CalendarContext;
import calendarlogic.EventManager;
import calendarstructs.AllDayEvent;
import calendarstructs.CalendarEvent;
import calendarstructs.TimeOfDayEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;


public class Main
{
    public static void main(String[] args)
    {
        LocalTime curTime = LocalTime.now();
        LocalDate curDate = LocalDate.now();
        CalendarContext calendarContext = new CalendarContext(curDate);

        Duration duration = Duration.ofHours(2);
        String eventDescription1 = "Meeting 1";
        String eventDescription2 = "Meeting 2";



        // Create a calendar context

        EventManager eventManager = new EventManager();

        CalendarEvent event1 = new AllDayEvent(curDate, eventDescription1);
        CalendarEvent event2 = new TimeOfDayEvent(curDate.plusDays(1), eventDescription2, curTime.plusHours(1), duration);

/*        eventManager.addEvent(event1);
        eventManager.addEvent(event2);*/

        System.out.println(event1);
        System.out.println(event2);

        calendarContext.addEvent(event1);
        calendarContext.addEvent(event2);

        calendarContext.displayCalendar();

    }
}
