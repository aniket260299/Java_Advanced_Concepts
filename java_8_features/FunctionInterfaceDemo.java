package java_8_features;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        Function<String, Integer> stringLength = s -> s.length();
        System.out.print("Length of 'Lambda' is: ");
        System.out.println(stringLength.apply("Lambda"));

        Function<Integer, Integer> divideBy2 = i -> i / 2;

        //a.compose(b) == b.andThen(a)
        System.out.print("Result of stringLength->'Lambda' and then divideBy2 is ");
        System.out.println(stringLength.andThen(divideBy2).apply("Lambda"));

        System.out.print("Result of divideBy2 compose stringLength->'Lambda' is ");
        System.out.println(divideBy2.compose(stringLength).apply("Lambda"));

        //Curring function to take 4 parameters
        Function<Integer, Function<Integer, Function<Integer, UnaryOperator<Integer>>>>
                curry = a -> b -> c -> d -> a + b + c + d;
        System.out.println("Curry result: " + curry.apply(1).apply(2).apply(3).apply(4));

        /*
            Output:
                Length of 'Lambda' is: 6
                Result of stringLength->'Lambda' and then divideBy2 is 3
                Result of divideBy2 compose stringLength->'Lambda' is 3
                Curry result: 10
         */


    }
}
