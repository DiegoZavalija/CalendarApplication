package calendarstructs;
import java.time.LocalDate;

public class AllDayEvent extends CalendarEvent
{
    public AllDayEvent(LocalDate eventDate, String eventTitle)
    {
        super(eventDate, eventTitle);
    }

    @Override
    public boolean isAllDayEvent(){return true;}

    @Override
    public String toString()
    {
        return " Date: " + getDate() + " All Day Event \n Event description: " + getEventTitle();
    }
}
