package calendarlogic;
import calendarstructs.CalendarEvent;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class CalendarContext
{
    private LocalDate currDate;
    private final LocalDate nowDate;
    private Locale curLocale;
    private final EventManager eventManager;
    private final DateTimeFormatter dateTimeFormatter;

    public CalendarContext(LocalDate nowDate)
    {
        eventManager = new EventManager();

        this.nowDate = nowDate; // The current date of the user
        this.currDate = this.nowDate; // The current date of the calendar which the user can move
        this.curLocale = Locale.getDefault(); // Setting the default locale

        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // Default format
    }

    public LocalDate getNowDate()
    {
        return nowDate;
    }

    // Adding event to the Event Manager
    public void addEvent(CalendarEvent event)
    {
        eventManager.addEvent(event);
    }

    public void moveDate()
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        switch (input)
        {
            case "+d" -> currDate = currDate.plusDays(1);
            case "+w" -> currDate = currDate.plusWeeks(1);
            case "+m" -> currDate = currDate.plusMonths(1);
            case "+y" -> currDate = currDate.plusYears(1);
            case "-d" -> currDate = currDate.minusDays(1);
            case "-w" -> currDate = currDate.minusWeeks(1);
            case "-m" -> currDate = currDate.minusMonths(1);
            case "-y" -> currDate = currDate.minusYears(1);
            case "t" -> currDate = nowDate;
            default -> {
                System.out.println("Invalid option.");
                return;
            }
        }

        displayCalendar();
    }

    public void displayCalendar()
    {
        // Adding all dependencies from the context
        eventManager.createDisplay(7, currDate, curLocale);
    }
}
