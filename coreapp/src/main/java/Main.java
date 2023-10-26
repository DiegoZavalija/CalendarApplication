
import terminalops.TerminalGrid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        var terminalGrid = TerminalGrid.create();
        String[][] messages = {{"Hello", "Adios"}};

        terminalGrid.print(messages);
    }
}
