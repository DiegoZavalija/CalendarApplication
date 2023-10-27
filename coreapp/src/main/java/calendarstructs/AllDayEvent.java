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
}
