import calendarlogic.CalendarContext;
import calendarlogic.EventManager;
import calendarstructs.AllDayEvent;
import calendarstructs.CalendarEvent;
import display.CalendarDisplay;
import jdk.jfr.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        LocalTime curTime = LocalTime.now();
        LocalDate curDate = LocalDate.now();
        String eventDescription = "Meeting 1";

        // Create a calendar context
        CalendarContext calendarContext = new CalendarContext();
        EventManager eventManager = new EventManager();

        CalendarEvent event1 = new AllDayEvent(curDate, eventDescription);

        eventManager.addEvent(event1);

        // Create the display for a date range of 5 days (including today)
        calendarContext.createDisplay(5);

        // Display the calendar
        calendarContext.displayCalendar();

    }
}
