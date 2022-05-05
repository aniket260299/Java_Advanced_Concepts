package java_8_features;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFUnctionAndPredicateDemo {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        BiPredicate<String, String> isEqual = (a, b) -> a.equals(b);

        System.out.println("Sum(5, 5) : " + sum.apply(5, 5));
        System.out.println("isEqual(ABC,BBC) ? " + isEqual.test("ABC", "BBC"));

        /*
            Output:
                Sum(5, 5) : 10
                isEqual(ABC,BBC) ? false
         */
    }
}
