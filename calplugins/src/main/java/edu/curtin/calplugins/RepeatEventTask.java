package edu.curtin.calplugins;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class RepeatEventTask extends DefaultTask {
    private String title;
    private String startDate;
    private String startTime;
    private String duration;
    private int repeat;

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }

    public int getRepeat() {
        return repeat;
    }

    @TaskAction
    public void createEvents() {
        LocalDate date = LocalDate.parse(getStartDate());
        LocalTime time = getStartTime() != null ? LocalTime.parse(getStartTime()) : null;
        Duration eventDuration = getDuration() != null ? Duration.parse(getDuration()) : null;

        LocalDate end = date.plusYears(1);

        while (date.isBefore(end))
        {
            System.out.println("Event Title: " + getTitle() + " on Date: " + date);
            if (time != null)
            {
                System.out.println("Start Time: " + time);
                if (eventDuration != null)
                {
                    System.out.println("End Time: " + time.plus(eventDuration));
                }
            } else
            {
                System.out.println("All Day Event");
            }
            date = date.plusDays(getRepeat());
        }
    }
}
