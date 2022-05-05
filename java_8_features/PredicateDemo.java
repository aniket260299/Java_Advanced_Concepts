package java_8_features;

import java.util.function.Predicate;

public class PredicateDemo {
    //Function that accepts Predicate_Lambdas and Predicate
    public static void printNumbers(Predicate<Integer> isEven, int[] arr) {
        for (int num : arr) {
            if (isEven.test(num))
                System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Implementing Predicate interface using Lambdas
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("5 is Even? " + isEven.test(5));
        System.out.println("4 is Even? " + isEven.test(4));

        Predicate<String> isStartWithA = x -> x.startsWith("A");
        System.out.println("Abc starts with A? " + isStartWithA.test("Abc"));
        System.out.println("Bcd starts with A? " + isStartWithA.test("Bcd"));

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Using Lambda as a Parameter for other function
        System.out.print("Print all even numbers: ");
        printNumbers(x -> x % 2 == 0, arr); //or printNumbers(isEven, arr)

        /*
            Predicate Join using three methods
            -> negate() means ! operator
            -> and() means && operator
            -> or() means || operator
         */

        Predicate<Integer> greaterThanFive = x -> x > 5;

        System.out.print("Print all even numbers and numbers > 5: ");
        printNumbers(isEven.and(greaterThanFive), arr); //Predicate joined using and() function

        System.out.print("Print all even numbers or numbers > 5: ");
        printNumbers(isEven.or(greaterThanFive), arr);  //Predicate joined using or() function

        System.out.print("Print all non even: ");
        printNumbers(isEven.negate(), arr); //Predicate negation using negate() function

        /*
            Output:
                5 is Even? false
                4 is Even? true
                Abc starts with A? true
                Bcd starts with A? false
                Print all even numbers: 2 4 6 8 10
                Print all even numbers and numbers > 5: 6 8 10
                Print all even numbers or numbers > 5: 2 4 6 7 8 9 10
                Print all non even: 1 3 5 7 9
         */
    }
}
