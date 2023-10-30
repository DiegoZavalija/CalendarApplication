package edu.curtin.pluginapi;
import calendarstructs.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarService
{

    private final List<CalendarEvent> events = new ArrayList<>();

    public void addEvent(CalendarEvent event) {
        events.add(event);
    }

    public List<CalendarEvent> notifyForEvent(String text)
    {
        List<CalendarEvent> matchingEvents = new ArrayList<>();
        for (CalendarEvent event : events)
        {
            if (event.getEventTitle().contains(text))
            {
                matchingEvents.add(event);
            }
        }
        return matchingEvents;
    }

    public List<CalendarEvent> generateRepeatedEvents(String title, String startDate, String startTime, String duration, int repeat)
    {
        return new ArrayList<>();
    }
}
