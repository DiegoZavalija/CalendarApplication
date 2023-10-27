package calendarlogic;
import display.CalendarDisplay;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CalendarContext
{
    private final LocalDate nowDate;
    private final EventManager eventManager;

    private CalendarDisplay calendarDisplay;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public CalendarContext(LocalDate currDate)
    {
        this.nowDate = currDate;
        eventManager = new EventManager();
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

        List<String> colHeadings = new ArrayList<>();
        DateTimeFormatter dateFormatter = this.dateTimeFormatter;
        LocalTime startTime = LocalTime.MIDNIGHT; // Starting from midnight
        CalendarDisplay calendarDisplay = new CalendarDisplay();

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
                // This is where you can add actual event data or placeholders.
                // For this example, I'm just using a placeholder.
                row.add("Event " + currTime);
            }
            calendarDisplay.addRow(currTime.toString(), row);
        }

        calendarDisplay.displayGrid();
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
