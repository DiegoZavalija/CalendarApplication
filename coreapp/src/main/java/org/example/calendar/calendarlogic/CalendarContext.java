package org.example.calendar.calendarlogic;
import org.example.calendar.calendarstructs.AllDayEvent;
import org.example.calendar.calendarstructs.CalendarEvent;
import org.example.calendar.calendarstructs.TimeOfDayEvent;

import java.text.Normalizer;
import java.time.*;
import java.util.Locale;
import java.util.Scanner;

public class CalendarContext
{
    private LocalDate currDate; // The calendar's current date
    private final LocalDate nowDate; // The ACTUAL current date of the user
    private Locale curLocale;
    private final EventManager eventManager;

    public CalendarContext(LocalDate nowDate)
    {


        this.nowDate = nowDate; // The current date of the user
        this.currDate = this.nowDate; // The current date of the calendar which the user can move
        this.curLocale = Locale.getDefault(); // Setting the default locale
        eventManager = new EventManager(this.nowDate);
    }

    // Adding event to the Event Manager
    public void addEvent(CalendarEvent event)
    {
        // Create new event with normalized input
        eventManager.addEvent(event);
    }

    public void addEvent(LocalDate date, String title, String startTime, String durationStr)
    {
        CalendarEvent event;

        String eventTitle = Normalizer.normalize(title, Normalizer.Form.NFC); // Normalizing event title

        if (startTime.isEmpty() || durationStr.isEmpty()) // Default all day
        {
            event = new AllDayEvent(date, eventTitle);
        }
        else // If user provides both start time and duration, the event is TimeOfDay
        {
            LocalTime start = LocalTime.parse(startTime);
            Duration duration = Duration.ofHours(Long.parseLong(durationStr));
            event = new TimeOfDayEvent(date, eventTitle, start, duration);
        }
        System.out.println(event);
        eventManager.addEvent(event);
    }

    public void searchForEvent(Scanner sc)
    {


        System.out.println("Enter the title of the event: ");
        String searchInput = sc.nextLine();
        String trimmedInput = Normalizer.normalize(searchInput.trim(), Normalizer.Form.NFC);
        CalendarEvent event = eventManager.searchEvent(trimmedInput);
        if (event != null)
        {
            currDate = event.getDate();
            System.out.println("Event found: " + event);
        }
        else
        {
            System.out.println("No event found matching the search term.");
        }

    }

    public void startCalendar()
    {
        try(Scanner sc = new Scanner(System.in))
        {
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
                    case "s" -> searchForEvent(sc);
                    case "l" -> {
                        System.out.println("Enter the IETF language tag (e.g., 'en-AU', 'th-TH-u-nu-thai'): ");
                        String langTag = sc.nextLine();
                        changeLocale(langTag);
                    }
                    case "x" -> continueMove = false;
                    default -> System.out.println("Invalid option.");

                }
                displayCalendar();
            }
        }
    }

    public static void showOptions() // Simply prints the menu
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
                's' To search for an event title
                'l' To change the locale
                'x' To exit
                """);
    }

    public void changeLocale(String languageTag)
    {
        languageTag = Normalizer.normalize(languageTag, Normalizer.Form.NFC);
        Locale newLocale = Locale.forLanguageTag(languageTag);

        if (!newLocale.getLanguage().isEmpty())
        {
            curLocale = newLocale;
            System.out.println("Locale has been changed to: " + newLocale.getDisplayName());
        }
        else
        {
            System.out.println("Invalid locale.");
        }
    }

    public void displayCalendar()
    {
        // Adding all dependencies from the context
        eventManager.createDisplay(7, currDate, curLocale);
    }
}
