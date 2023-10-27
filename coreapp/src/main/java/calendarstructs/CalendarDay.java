package calendarstructs;

import java.time.LocalDate;
import java.util.List;

public class CalendarDay
{
    private final LocalDate day;
    private List<CalendarEvent> eventList;

    public CalendarDay(LocalDate day)
    {
        this.day = day;
    }

    public void addCalendarEvent(CalendarEvent calendarEvent)
    {
        eventList.add(calendarEvent);
    }

    public List<CalendarEvent> getEventList()
    {
        return eventList;
    }

    public LocalDate getDay()
    {
        return day;
    }
}
