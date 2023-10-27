package calendarlogic;

import calendarstructs.CalendarEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager
{
    private final Map<LocalDate, List<CalendarEvent>> dateMap;

    public EventManager()
    {
        this.dateMap = new HashMap<>();
    }


    public void addEvent(CalendarEvent event)
    {
        LocalDate date = event.getDate();

        // Retrieving the list of events for the specified date, or create a new list if none exists
        List<CalendarEvent> eventsForDate = dateMap.computeIfAbsent(date, k -> new ArrayList<>());

        // Add the event to the list for the specified date
        eventsForDate.add(event);
    }

    public List<CalendarEvent> getEventsByDate(LocalDate date)
    {
        return dateMap.getOrDefault(date, null);

    }
}
