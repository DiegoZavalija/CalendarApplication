package calendarlogic;
import display.CalendarDisplay;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CalendarContext
{
    private final LocalDate currDate;
    private final EventManager eventManager;
    private CalendarDisplay calendarDisplay;
    private int calendarLength;

    public CalendarContext(LocalDate currDate)
    {
        this.currDate = currDate;
        eventManager = new EventManager();
    }



    public void createDisplay(int dateRange, LocalDate startDate)
    {
        List<String> colHeadings = new ArrayList<>();


        // Creating the date column headings
        for(int i=0; i<dateRange; i++)
        {
            colHeadings.add(startDate.plusDays(i).format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        }

        // Setting the length so the rows that are added fit within the columns
        calendarLength = colHeadings.size();
        List<String> row = new ArrayList<>();
        for (int i=0; i<dateRange; i++)
        {
            row.add("Event" + i);
        }


        calendarDisplay = new CalendarDisplay(colHeadings);
        calendarDisplay.addRow("All Day Events", row);

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
