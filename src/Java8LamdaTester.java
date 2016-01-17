/**
 * Created by john on 2016/1/7.
 */
public class Java8LamdaTester {
    interface MathOperation{
        int operation(int a,int b);
    }
    interface GreetingService {
        void sayMessage(String message);
    }
    private int operate(int a,int b,MathOperation mathOperation) {
        return mathOperation.operation(a,b);
    }
    final static String salutation = "Hello!";
    public static void main(String[] args) {
        Java8LamdaTester tester = new Java8LamdaTester();

        //with type declaration
        MathOperation addition = (int a,int b) -> a + b;
        //with out type declaration
        MathOperation subtraction = (a,b) -> a - b;
        //with return statement along with curly braces
        MathOperation multiplication = (int a,int b) -> { return a * b; };
        //without return statement and curly braces
        MathOperation division = (int a,int b) -> a / b;

        System.out.println("10+5=" + tester.operate(10,5,addition));
        System.out.println("10-5=" + tester.operate(10,5,subtraction));
        System.out.println("10*5=" + tester.operate(10,5,multiplication));
        System.out.println("10/5=" + tester.operate(10,5,division));

        GreetingService greetService1 = message ->
                System.out.println(message);
        GreetingService greetService2 = (message) ->
                System.out.println(message);

        greetService1.sayMessage("John");
        greetService2.sayMessage("Chang");


        GreetingService greetService3 = message ->
                System.out.println(salutation+message);
        greetService3.sayMessage("John Chang");
    }
}
