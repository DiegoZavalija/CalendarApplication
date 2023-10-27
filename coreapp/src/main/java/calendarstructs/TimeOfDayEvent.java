package calendarstructs;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class TimeOfDayEvent extends CalendarEvent
{
    private final LocalTime eventTime;
    private final Duration eventDuration;


    public TimeOfDayEvent(LocalDate eventDate, String eventDescription, LocalTime eventTime, Duration eventDuration)
    {
        super(eventDate, eventDescription);
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
    public String getEventDescription() {
        return super.getEventDescription();
    }

    @Override
    public boolean isAllDayEvent() {
        return false;
    }
}
