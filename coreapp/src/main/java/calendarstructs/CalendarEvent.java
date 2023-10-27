package calendarstructs;
import java.time.*;

public abstract class CalendarEvent
{
    private LocalTime eventTime;
    private String eventDescription;

    public CalendarEvent(LocalTime eventTime, String eventDescription)
    {
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
    }

    public LocalTime getEventTime()
    {
        return eventTime;
    }

    public String getEventDescription()
    {
        return eventDescription;
    }
}
