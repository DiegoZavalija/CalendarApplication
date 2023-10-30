package edu.curtin.pluginapi;

import calendarstructs.CalendarEvent;

import java.util.List;

public class CalendarApiOps implements CalendarApi
{
    CalendarService calendarService = new CalendarService();

    @Override
    public void addEventToCalendar(CalendarEvent event)
    {
        calendarService.addEvent(event);
    }

    @Override
    public List<CalendarEvent> searchEventsByText(String text)
    {
        return calendarService.notifyForEvent(text);
    }

    @Override
    public List<CalendarEvent> createRepeatedEvents(String title, String startDate, String startTime, String duration, int repeat)
    {
        return calendarService.generateRepeatedEvents(title, startDate, startTime, duration, repeat);
    }
}
