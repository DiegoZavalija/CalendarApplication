package org.example.calendar.calendarlogic;

import org.example.calendar.calendarstructs.CalendarEvent;
import org.example.calendar.calendarstructs.TimeOfDayEvent;
import org.example.calendar.display.CalendarDisplay;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EventManager
{
    private final List<CalendarEvent> globalCalendarEventList;

    public EventManager()
    {
        this.globalCalendarEventList = new ArrayList<>();
    }


    public void addEvent(CalendarEvent event)
    {
        globalCalendarEventList.add(event);
    }

    public void createDisplay(int dateRange, LocalDate startDate, Locale locale)
    {
        CalendarDisplay calendarDisplay = new CalendarDisplay();
        List<String> colHeadings = new ArrayList<>();
        LocalTime startTime = LocalTime.MIDNIGHT; // Start from midnight


        // Creating the date column headings
        for(int i=0; i<dateRange; i++) {
            LocalDate currDate = startDate.plusDays(i);
            colHeadings.add(formatDateForLocale(currDate, locale));
        }
        calendarDisplay.setColHeadings(colHeadings);

        // Creating rows for every hour and every date in the dateRange
        for(int i=0; i<24; i++)
        {  // Looping through 24 hours
            LocalTime currTime = startTime.plusHours(i);
            List<String> row = new ArrayList<>();

            for(int j=0; j<dateRange; j++)
            {
                LocalDate currDate = startDate.plusDays(j);
                CalendarEvent event = findEventForDateAndTime(this.globalCalendarEventList, currDate, currTime);

                if (event != null)
                {
                    row.add(event.getEventDescription());
                }
                else
                {
                    row.add("");  // In the case of no event
                }
            }
            calendarDisplay.addRow(currTime.toString(), row);
        }

        calendarDisplay.displayGrid();
    }

    private CalendarEvent findEventForDateAndTime(List<CalendarEvent> events, LocalDate date, LocalTime time)
    {
        for (CalendarEvent event : events)
        {
            if (event.isAllDayEvent() && event.getDate().equals(date))
            {
                return event;
            }
            else if (!event.isAllDayEvent() && event instanceof TimeOfDayEvent timedEvent)
            {
                if (timedEvent.getDate().equals(date) &&
                        !timedEvent.getEventTime().isAfter(time) &&
                        timedEvent.getEventTime().plus(timedEvent.getEventDuration()).isAfter(time))
                {
                    return timedEvent;
                }
            }
        }
        return null;
    }

    private static String formatDateForLocale(LocalDate date, Locale locale)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(locale);
        return date.format(formatter);
    }
}
