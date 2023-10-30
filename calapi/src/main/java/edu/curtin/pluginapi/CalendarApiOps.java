package edu.curtin.pluginapi;

import calendarstructs.CalendarEvent;

import java.util.List;

public class CalendarApiOps implements CalendarApi
{

    @Override
    public void addEventToCalendar(CalendarEvent event)
    {

    }

    @Override
    public List<CalendarEvent> searchEventsByText(String text)
    {
        return null;
    }

    @Override
    public List<CalendarEvent> createRepeatedEvents(String title, String startDate, String startTime, String duration, int repeat)
    {
        return null;
    }
}
