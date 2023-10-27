package calendarlogic;

import calendarstructs.CalendarDay;
import calendarstructs.CalendarEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventManager
{
    private final List<CalendarDay> calendarDayList = new ArrayList<>();

    public List<CalendarEvent> getEventsByDate(LocalDate date)
    {
        for (CalendarDay calendarDay : calendarDayList)
        {
            if (calendarDay.getDay().equals(date))
            {
                return calendarDay.getEventList();
            }
        }
        return null;
    }

    public void addAllDayEvent(LocalDate dayStart, LocalDate dayEnd)
    {

    }
}
