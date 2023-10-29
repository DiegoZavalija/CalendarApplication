package org.example.calendar.calendarstructs;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class TimeOfDayEvent extends CalendarEvent
{
    private final LocalTime eventTime;
    private final Duration eventDuration;


    public TimeOfDayEvent(LocalDate eventDate, String eventTitle, LocalTime eventTime, Duration eventDuration)
    {
        super(eventDate, eventTitle);
        this.eventTime = eventTime;
        this.eventDuration = eventDuration;
    }

    public LocalTime getEventTime()
    {
        return eventTime;
    }

    public Duration getEventDuration()
    {
        return eventDuration;
    }

    @Override
    public boolean isAllDayEvent() {
        return false;
    }

    @Override
    public String toString()
    {
        return "Date: " + getDate() + " Time: " + getEventTime() + "\nDescription: "  + getEventTitle();
    }

}
