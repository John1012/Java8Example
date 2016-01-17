import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by john on 2016/1/17.
 */
public class Java8BackwardCompatibility {
    public static void main(String[] args) {
        // Get the current date
        Date current = new Date();
        System.out.println("Current date: "+ current);

        //Get the instant of current date in terms of milliseconds
        Instant now = current.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, zone);
        System.out.println("Zoned Date: "+zonedDateTime);
    }
}
