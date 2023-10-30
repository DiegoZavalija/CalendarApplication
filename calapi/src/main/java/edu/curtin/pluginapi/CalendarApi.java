package edu.curtin.pluginapi;

import calendarstructs.CalendarEvent;

import java.util.List;

public interface CalendarApi
{

    void addEventToCalendar(CalendarEvent event);

    List<CalendarEvent> searchEventsByText(String text);

    List<CalendarEvent> createRepeatedEvents(String title, String startDate, String startTime, String duration, int repeat);

}
