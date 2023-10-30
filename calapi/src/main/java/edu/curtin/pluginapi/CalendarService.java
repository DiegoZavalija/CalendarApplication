package edu.curtin.pluginapi;

import calendarstructs.*;
import edu.curtin.calplugins.Notify;
import edu.curtin.calplugins.NotifyEventTask;
import edu.curtin.calplugins.RepeatEventTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarService
{

    private final List<CalendarEvent> events = new ArrayList<>();

    public void addEvent(CalendarEvent event)
    {
        events.add(event);
    }

    public List<CalendarEvent> notifyForEvent(String text)
    {
        NotifyEventTask notifyEventTask = new NotifyEventTask();
        // notifyEventTask.notifyForMatchingEvents();
        return null;
    }

    public List<CalendarEvent> generateRepeatedEvents(String title, String startDate, String startTime, String duration, int repeat)
    {
        RepeatEventTask repeatEventTask = new RepeatEventTask(title, startDate, startTime, duration, repeat);
        //repeatEventTask.getEvents();
        return null;
    }
}
