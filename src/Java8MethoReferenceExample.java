import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2016/1/7.
 */
public class Java8MethoReferenceExample {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<String>();
        nameList.add("John");
        nameList.add("Janey");
        nameList.add("Eric");
        nameList.add("Pierce");
        nameList.add("Larry");

        nameList.forEach(System.out::println);
    }
}
