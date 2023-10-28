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

    // Adding event to the Event Manager
    public void addEvent(CalendarEvent event)
    {
        eventManager.addEvent(event);
    }

    public void startCalendar()
    {
        Scanner sc = new Scanner(System.in);
        boolean continueMove = true;
        displayCalendar();

        while(continueMove)
        {
            showOptions();
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
                case "x" -> continueMove = false;
                default -> System.out.println("Invalid option.");

            }
            displayCalendar();
        }
    }

    public void changeLocale(String localeString)
    {
        // Here the user can change the locale of the CalendarContext by inputting text
        // try( Locale.builder) catch (bad locale)
    }

    public static void showOptions()
    {
        System.out.println("""
                Press the following keys to modify the date:
                '+d' To move forward one day
                '+w' To move forward one week
                '+m' To move forward one month
                '+y' To move forward one year
                '-d' To move backwards one day
                '-w' To move backwards one week
                '-m' To move backwards one month
                '-y' To move backwards one year
                't' To return to today
                """);
    }

    public void displayCalendar()
    {
        // Adding all dependencies from the context
        eventManager.createDisplay(7, currDate, curLocale);
    }
}
