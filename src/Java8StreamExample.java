import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by john on 2016/1/8.
 */
public class Java8StreamExample {
    public static void main(String[] args) {
        System.out.println("Using Java7");
        //Count empty string
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("List: " +strings);
        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("Empty string: "+count);
        count = getCountLength3UsingJava7(strings);
        System.out.println("String of length 3:"+count);
        //Eliminate empty string
        List<String> filtered = deleteEmptyStringUsingJava7(strings);
        System.out.println("Filtered List: "+filtered);
        //Eliminate empty string and join using comma
        String mergeString = getMergedStringUsingJava7(strings,",");
        System.out.println("Merged string: "+mergeString);


        List<Integer> numbers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        System.out.println("List: "+numbers);
        System.out.println("The highest number in list: "+getMax(numbers));
        System.out.println("The lowest number in list: "+getMin(numbers));
        System.out.println("The sum of all numbers: "+getSum(numbers));
        System.out.println("The average of all list: "+getAverage(numbers));

        //print ten random numbers
        Random random = new Random();
        for(int i=0;i<10;i++)
            System.out.println(random.nextInt());

        System.out.println("Using Java8");
        System.out.println("List: "+strings);
        count = strings.stream().filter(string->string.isEmpty()).count();
        System.out.println("Empty string: "+count);
        count = strings.stream().filter(string->string.length()==3).count();
        System.out.println("String of length 3:"+count);
        filtered = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: "+filtered);
        mergeString = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged string: "+mergeString);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x)->x).summaryStatistics();
        System.out.println("List: "+numbers);
        System.out.println("The highest number in list: "+stats.getMax());
        System.out.println("The lowest number in list: "+stats.getMin());
        System.out.println("The sum of all numbers: "+stats.getSum());
        System.out.println("The average of all list: "+stats.getAverage());

        random.ints().limit(10).sorted().forEach(System.out::println);

        //parallel processing
        count = strings.parallelStream().filter(string->string.isEmpty()).count();
        System.out.println("Empty string: "+count);



    }

    private static int getCountEmptyStringUsingJava7(List<String> strings) {
        int count =0;
        for(String str : strings) {
            if(str.isEmpty())
                count++;
        }
        return count;
    }

    private static int getCountLength3UsingJava7(List<String> strings) {
        int count =0;
        for(String str : strings) {
            if(str.length() == 3) {
                count++;
            }
        }
        return count;
    }

    private static List<String> deleteEmptyStringUsingJava7(List<String> strings) {
        List<String> filteredList = new ArrayList<String>();
        for(String str : strings) {
            if(!str.isEmpty())
                filteredList.add(str);
        }
        return filteredList;
    }

//    private static String getMergedStringUsingJava7(List<String> strings,String separator) {
//        StringBuilder builder = new StringBuilder();
//        for(String str : strings) {
//            if(!strings.isEmpty()) {
//                builder.append(str);
//                builder.append(separator);
//            }
//        }
//        String mergedString =builder.toString();
//        return mergedString.substring(0,mergedString.length()-2);
//    }

    private static String getMergedStringUsingJava7(List<String> strings, String separator){
        StringBuilder stringBuilder = new StringBuilder();

        for(String string: strings){

            if(!string.isEmpty()){
                stringBuilder.append(string);
                stringBuilder.append(separator);
            }
        }
        String mergedString = stringBuilder.toString();
        return mergedString.substring(0, mergedString.length()-2);
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> squares = new ArrayList<Integer>();
        for(Integer num : numbers) {
            Integer sequare = new Integer(num.intValue() * num.intValue());

            if(!squares.contains(sequare))
                squares.add(sequare);
        }
        return squares;
    }

    private static int getMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for(Integer num : numbers) {
            if(max < num.intValue())
                max = num.intValue();
        }
        return max;
    }

    private static int getMin(List<Integer> numbers) {
        int min = numbers.get(0);
        for(Integer num : numbers) {
            if(min > num.intValue())
                min = num.intValue();
        }
        return min;
    }

    private static int getSum(List numbers){
        int sum = (int)(numbers.get(0));

        for(int i=1;i < numbers.size();i++){
            sum += (int)numbers.get(i);
        }
        return sum;
    }

    private static int getAverage(List<Integer> numbers){
        return getSum(numbers) / numbers.size();
    }
}
