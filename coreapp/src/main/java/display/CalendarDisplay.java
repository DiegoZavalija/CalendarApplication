package display;
import terminalops.TerminalGrid;

import java.util.ArrayList;
import java.util.List;

public class CalendarDisplay
{
    private final TerminalGrid terminalGrid = TerminalGrid.create();
    private final List<List<String>> listMessages;
    private final List<String> rowHeadings;
    private List<String> colHeadings;

    int defaultColLength;

    public CalendarDisplay(List<String> colHeadings)
    {
        this.listMessages = new ArrayList<>();
        this.rowHeadings = new ArrayList<>();
        setColHeadings(colHeadings);


    }

    /**
     * Adds a heading to the row headings list.
     * @param rowHeading The row heading to add.
     */

    public void addRow(String rowHeading, List<String> rowContent)
    {


        // Adding the row heading
        addRowHeading(rowHeading);
        // Adding the row to the table
        listMessages.add(new ArrayList<>(rowContent));
    }

    private void addRowHeading(String rowHeading)
    {
        rowHeadings.add(rowHeading);
    }


    private void setColHeadings(List<String> colHeadings)
    {
        if (colHeadings.isEmpty())
        {
            throw new IllegalArgumentException("Give more than one column");
        }
        this.colHeadings = colHeadings;
        this.defaultColLength = colHeadings.size();
    }

    public void displayGrid()
    {
        terminalGrid.print(this.listMessages, this.rowHeadings, this.colHeadings);
    }

    // Additional methods can be added here for more functionality.
    // For example, methods to reset the grid, remove rows/columns, etc.
}