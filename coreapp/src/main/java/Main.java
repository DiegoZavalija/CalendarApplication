import calendarlogic.CalendarContext;
import display.CalendarDisplay;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        // Create a calendar context
        CalendarContext calendarContext = new CalendarContext();

        // Create the display for a date range of 5 days (including today)
        calendarContext.createDisplay(5);

        // Display the calendar
        calendarContext.displayCalendar();

    }
}
