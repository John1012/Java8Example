import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by john on 2016/1/17.
 */
public class Java8ChronoUnitExample {
    public static void main(String[] args) {
        // Get current date and time
        LocalDate today = LocalDate.now();
        System.out.println("Current date: "+today);

        //add 1 week to the current date
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Next week: "+nextWeek);

        //add 1 year to the current year
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Next year: "+nextYear);

        //add 10 year to the current year
        LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
        System.out.println("Date after ten year: "+nextDecade);
    }
}
