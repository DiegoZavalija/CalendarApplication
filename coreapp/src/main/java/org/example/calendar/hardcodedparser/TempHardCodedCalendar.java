package org.example.calendar.hardcodedparser;

import calendarstructs.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


// JavaCC parser didn't work in the end, so this is the file reading class
public class TempHardCodedCalendar
{

    public static List<CalendarEvent> readEventsFromFile(String filename)
    {
        List<CalendarEvent> events = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                if (line.startsWith("event"))
                {
                    String[] parts = line.split("\"");
                    if (parts.length < 2)
                    {
                        System.out.println("Skipping line: " + line);
                        continue;
                    }
                    String[] dateAndTime = parts[0].split(" ");
                    LocalDate date = LocalDate.parse(dateAndTime[1]);
                    String title = parts[1];

                    if (dateAndTime.length == 4)
                    {
                        // Time-Of-Day event
                        LocalTime time = LocalTime.parse(dateAndTime[2]);
                        Duration duration = Duration.ofMinutes(Long.parseLong(dateAndTime[3]));
                        events.add(new TimeOfDayEvent(date, title, time, duration));
                    }
                    else if (dateAndTime.length == 2)
                    { // All-day event
                        events.add(new AllDayEvent(date, title));
                    }
                    else
                    {
                        System.out.println("Skipping line: " + line);
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred while reading the file.");
        }
        return events;
    }
}
