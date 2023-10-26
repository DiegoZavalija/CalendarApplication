import display.CalendarDisplay;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        // Step 1: Create an instance of the CalendarDisplay class with column headings
        List<String> colHeadings = new ArrayList<>();
        colHeadings.add("Time");
        colHeadings.add("Monday");
        colHeadings.add("Tuesday");

        var calendarDisplay = new CalendarDisplay(colHeadings);

        var row = new ArrayList<String>();

        row.add("1");
        row.add("2");
        row.add("3");

        // Step 3: Display the grid
        calendarDisplay.addRow("Heading", row);
        calendarDisplay.displayGrid();
    }
}
