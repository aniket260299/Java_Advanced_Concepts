package java_8_features;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIDemo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        //Adding elements into list
        for (int i = 1; i <= 10; i++) list.add(i);

        //Using streamAPI to filter even number and store on list
        List<Integer> evenList = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("evenList: " + evenList);

        //Using streamAPI to multiply every number by 10 and store on list
        List<Integer> multipliedBy10 = list.stream().map(x -> x * 10).collect(Collectors.toList());
        System.out.println("multipliedBy10: " + multipliedBy10);

        //Using streamAPI to sort the list
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List: " + sortedList);

        //Using streamAPI to find minimum value from list
        Integer minimum = list.stream().min((a, b) -> a - b).get();
        System.out.println("minimum: " + minimum);

        //Using streamAPI to find maximum value from list
        Integer maximum = list.stream().max((a, b) -> a - b).get();
        System.out.println("maximum: " + maximum);

        //Using StreamAPI to extract values from list
        System.out.print("Using ForEach: ");
        list.forEach(x -> System.out.print(x + " "));

        /*
            Output:
                evenList: [2, 4, 6, 8, 10]
                multipliedBy10: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
                Sorted List: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
                minimum: 1
                maximum: 10
                Using ForEach: 1 2 3 4 5 6 7 8 9 10
         */
    }
}
