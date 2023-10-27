package calendarstructs;
import java.time.LocalDate;

public class AllDayEvent extends CalendarEvent
{
    public AllDayEvent(LocalDate eventDate, String eventDescription)
    {
        super(eventDate, eventDescription);
    }

    @Override
    public boolean isAllDayEvent(){return true;}

    @Override
    public String toString()
    {
        return " Date: " + getDate() + " All Day Event \n Event description: " + getEventDescription();
    }
}
