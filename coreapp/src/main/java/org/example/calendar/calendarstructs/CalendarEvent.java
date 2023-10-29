package org.example.calendar.calendarstructs;
import java.time.*;

public abstract class CalendarEvent
{
    private final LocalDate eventDate;
    private final String eventDescription;


    public CalendarEvent(LocalDate eventDate, String eventDescription)
    {
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
    }

    public LocalDate getDate()
    {
        return eventDate;
    }

    public String getEventDescription()
    {
        return eventDescription;
    }

    public abstract boolean isAllDayEvent();
}
