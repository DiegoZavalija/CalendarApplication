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
        Duration duration = Duration.ofHours(2);
        String eventDescription = "Meeting 1";

        // Create a calendar context
        CalendarContext calendarContext = new CalendarContext(curDate);
        EventManager eventManager = new EventManager();

        CalendarEvent event1 = new AllDayEvent(curDate, eventDescription);
        CalendarEvent event2 = new TimeOfDayEvent(curDate, eventDescription, curTime, duration);

        eventManager.addEvent(event1);
        eventManager.addEvent(event2);

        System.out.println(event1);
        System.out.println(event2);


        // Create the display for a date range of 5 days (including today)
        calendarContext.createDisplay(7, curDate);

        // Display the calendar
        calendarContext.displayCalendar();

    }
}
