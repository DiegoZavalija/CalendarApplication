package org.example.calendar.calendarstructs;
import java.time.*;

public abstract class CalendarEvent
{
    private final LocalDate eventDate;
    private final String eventTitle;


    public CalendarEvent(LocalDate eventDate, String eventTitle)
    {
        this.eventDate = eventDate;
        this.eventTitle = eventTitle;
    }

    public LocalDate getDate()
    {
        return eventDate;
    }

    public String getEventTitle()
    {
        return eventTitle;
    }

    public abstract boolean isAllDayEvent();
}
