package edu.curtin.calplugins;

import calendarstructs.CalendarEvent;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.util.List;

public class NotifyEventTask extends DefaultTask
{
    private String text;
    private List<CalendarEvent> events;

    public void setText(String text)
    {
        this.text = text;
    }

    public void setEvents(List<CalendarEvent> events)
    {
        this.events = events;
    }

    @TaskAction
    public void notifyForMatchingEvents()
    {
        for (CalendarEvent event : events)
        {
            if (event.getEventTitle().contains(text))
            {
                System.out.println(event);
            }
        }
    }
}
