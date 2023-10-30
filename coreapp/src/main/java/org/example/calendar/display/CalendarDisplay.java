package org.example.calendar.display;
import terminalops.TerminalGrid;

import java.util.ArrayList;
import java.util.List;

public class CalendarDisplay
{
    private final TerminalGrid terminalGrid = TerminalGrid.create();
    private final List<List<String>> listMessages;
    private final List<String> rowHeadings;
    private List<String> colHeadings;

    /* default */ int defaultColLength;

    public CalendarDisplay()
    {
        this.listMessages = new ArrayList<>();
        this.rowHeadings = new ArrayList<>();
        this.colHeadings = new ArrayList<>();

        terminalGrid.setBoxChars(new TerminalGrid.BoxChars
                (
                "│ ", " ┊ ", " │",
                "─", "╌", "─",
                "╭─", "─╮", "╰─", "─╯",
                "─┬─", "─┴─", "├╌", "╌┤", "╌┼╌"));
        terminalGrid.setTerminalWidth(150);
    }


    public void setColHeadings(List<String> colHeadings)
    {
        if (colHeadings.isEmpty())
        {
            throw new IllegalArgumentException("You have to set more than one column.");
        }
        this.colHeadings = colHeadings;
        this.defaultColLength = colHeadings.size();
    }

    public void addRow(String rowHeading, List<String> rowContent)
    {
        // Adding the row heading
        rowHeadings.add(rowHeading);

        // Adding the row to the table
        listMessages.add(new ArrayList<>(rowContent));
    }

    public void displayGrid()
    {
        terminalGrid.print(this.listMessages, this.rowHeadings, this.colHeadings);
    }

    // Additional methods can be added here for more functionality.
    // For example, methods to reset the grid, remove rows/columns, etc.
}