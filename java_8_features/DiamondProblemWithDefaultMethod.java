package java_8_features;

interface Parent1 {
    default void add(int a, int b) {
        System.out.println(a + b);
    }
}

interface Parent2 {
    default void add(int a, int b) {
        System.out.println(a + b);
    }
}

public class DiamondProblemWithDefaultMethod implements Parent1, Parent2 {
    //To solve diamond problem we need to override the conflicting add method
    @Override
    public void add(int a, int b) {
        Parent1.super.add(a, b);
        // or Parent2.super.add(a, b) or provide your implementation
    }

    public static void main(String[] args) {
        DiamondProblemWithDefaultMethod obj = new DiamondProblemWithDefaultMethod();
        obj.add(5, 5);

        /*
            Output:
                10
         */
    }
}
