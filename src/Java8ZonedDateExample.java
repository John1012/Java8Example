import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by john on 2016/1/16.
 */
public class Java8ZonedDateExample {
    public static void main(String[] args) {
        //Get current date and time
        ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("Date1: "+date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: "+id);

        ZoneId currentId = ZoneId.systemDefault();
        System.out.println("Current zone: "+currentId);
    }
}
