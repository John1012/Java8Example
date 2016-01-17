import java.util.Optional;
import static java.lang.System.out;
/**
 * Created by john on 2016/1/16.
 */
public class Java8OptionalExample {
    public static void main(String[] args) {
        Java8OptionalExample example = new Java8OptionalExample();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        //Optional.ofNullable - allows passed parameter to be null
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(example.sum(a,b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not
        out.println("First parameter is present: "+a.isPresent());
        out.println("Second parameter is present: "+b.isPresent());

        //Optional.orElse - return the value if present otherwise returns
        // the default value pressed
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - get the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }
}
