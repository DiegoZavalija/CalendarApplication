package calendarlogic;
import calendarstructs.CalendarEvent;
import calendarstructs.TimeOfDayEvent;
import display.CalendarDisplay;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CalendarContext
{
    private final LocalDate nowDate;
    //private final EventManager eventManager;
    private CalendarDisplay calendarDisplay;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private List<CalendarEvent> globalCalendarEventList = new ArrayList<>();

    public CalendarContext(LocalDate currDate)
    {
        this.nowDate = currDate;
        //eventManager = new EventManager();
    }

    public void addEvent(CalendarEvent event)
    {
        globalCalendarEventList.add(event);
    }

/*    public void createDisplay(int dateRange, LocalDate startDate)
    {
        LocalTime startTime = LocalTime.now();
        CalendarDisplay calendarDisplay = new CalendarDisplay();

        // Creating the date column headings
        for(int i=0; i<dateRange; i++)
        {
            LocalDate currDate = startDate.plusDays(i);
            calendarDisplay.addColHeading(currDate.format(dateTimeFormatter));
            // SearchEvents
            for(int j=0; j < dateRange; j++)
            {
                List<String> row = new ArrayList<>();
                LocalTime currTime = startTime.plusHours(j);

                row.add("Event " + i);
                calendarDisplay.addRow(currTime.toString(), row);
            }
        }

        // Setting the length so the rows that are added fit within the columns

        //calendarDisplay.setColHeadings(colHeadings);
        calendarDisplay.displayGrid();
    }*/

    public void createDisplay(int dateRange, LocalDate startDate)
    {
        CalendarDisplay calendarDisplay = new CalendarDisplay();
        var events = this.globalCalendarEventList;
        List<String> colHeadings = new ArrayList<>();
        DateTimeFormatter dateFormatter = this.dateTimeFormatter;  // Example format: "Mon 01/01"
        LocalTime startTime = LocalTime.MIDNIGHT; // Start from midnight


        // Creating the date column headings
        for(int i=0; i<dateRange; i++) {
            LocalDate currDate = startDate.plusDays(i);
            colHeadings.add(currDate.format(dateFormatter));
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
                CalendarEvent event = findEventForDateAndTime(events, currDate, currTime);

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

    private CalendarEvent findEventForDateAndTime(List<CalendarEvent> events, LocalDate date, LocalTime time) {
        for (CalendarEvent event : events) {
            if (event.isAllDayEvent() && event.getDate().equals(date)) {
                return event;
            } else if (!event.isAllDayEvent() && event instanceof TimeOfDayEvent timedEvent) {
                if (timedEvent.getDate().equals(date) &&
                        !timedEvent.getEventTime().isAfter(time) &&
                        timedEvent.getEventTime().plus(timedEvent.getEventDuration()).isAfter(time)) {
                    return timedEvent;
                }
            }
        }
        return null;
    }



/*    private void createTimeRows()
    {

        LocalTime = curTime;
        for(int i=0; i<calendarLength; i++)
        {

            List<String> row = new ArrayList<>();
            String time;
            // Fill in the row with increasing hours (24h)
            calendarDisplay.addRow();
        }
    }*/

    public void displayCalendar()
    {
        if (calendarDisplay != null)
        {
            calendarDisplay.displayGrid();
        }
    }
}
