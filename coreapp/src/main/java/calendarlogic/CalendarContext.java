package calendarlogic;
import calendarstructs.CalendarEvent;
import calendarstructs.TimeOfDayEvent;
import display.CalendarDisplay;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CalendarContext
{
    private final LocalDate currDate = LocalDate.now();
    private final EventManager eventManager;
    private DateTimeFormatter dateTimeFormatter;

    public CalendarContext(LocalDate currDate)
    {
        eventManager = new EventManager();
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
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
