package calendarlogic;
import calendarstructs.CalendarEvent;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class CalendarContext
{
    private LocalDate currDate;
    private LocalDate nowDate;
    private final EventManager eventManager;
    private final DateTimeFormatter dateTimeFormatter;

    public CalendarContext(LocalDate nowDate)
    {
        eventManager = new EventManager();
        this.nowDate = nowDate; // The current date of the user
        this.currDate = this.nowDate; // The current date of the calendar which the user can move
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // Default format
    }

    public LocalDate getNowDate()
    {
        return nowDate;
    }

    // Adding event to the Event Manager
    public void addEvent(CalendarEvent event)
    {
        eventManager.addEvent(event);
    }

    public void displayCalendar()
    {
        // Adding all dependencies from the context
        eventManager.createDisplay(7, currDate, dateTimeFormatter);
    }
}
