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
        var row2 = new ArrayList<String>();

        row.add("1");
        row.add("2");
        row.add("3");

        row2.add("4");
        row2.add("5");
        row2.add("6");


        // Step 3: Display the grid
        calendarDisplay.addRow("This is row1", row);
        calendarDisplay.addRow("This is row2", row2);
        calendarDisplay.displayGrid();
    }
}
