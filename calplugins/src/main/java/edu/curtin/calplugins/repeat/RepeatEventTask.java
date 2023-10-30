package edu.curtin.calplugins.repeat;

import org.example.calendar.calendarstructs.AllDayEvent;
import org.example.calendar.calendarstructs.CalendarEvent;
import org.example.calendar.calendarstructs.TimeOfDayEvent;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RepeatEventTask extends DefaultTask {
    private final String title;
    private final String startDate;
    private final String startTime;
    private final String duration;
    private final int repeat;

    // List to hold created calendar events which extend up to the selected amount of repeats
    private final List<CalendarEvent> events = new ArrayList<>();

    public RepeatEventTask(String title, String startDate, String startTime, String duration, int repeat) {
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
        this.duration = duration;
        this.repeat = repeat;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public String getDuration()
    {
        return duration;
    }

    public String getTitle()
    {
        return title;
    }

    public int getRepeat()
    {
        return repeat;
    }

    @TaskAction
    public void createEvents()
    {
        LocalDate date = LocalDate.parse(getStartDate());

        LocalDate end = date.plusYears(1);
        while (date.isBefore(end))
        {
            CalendarEvent event;
            if (startTime == null || duration == null) {
                // All day event
                event = new AllDayEvent(date, getTitle());
            }
            else
            {
                // Time of day event
                LocalTime time = LocalTime.parse(getStartTime());
                Duration eventDuration = Duration.parse(getDuration());
                event = new TimeOfDayEvent(date, getTitle(), time, eventDuration);
            }

            events.add(event);  // Adding the created event to the list

            date = date.plusDays(getRepeat());
        }

        for (CalendarEvent e : events)
        {
            System.out.println(e);
        }
    }
}
