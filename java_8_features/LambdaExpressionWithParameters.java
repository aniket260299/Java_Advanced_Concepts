package java_8_features;

//Functional Interface
interface Adder {
    int add(int a, int b);
}

public class LambdaExpressionWithParameters {
    public static void main(String[] args) {
        //Providing implementation of Adder interface using Lambda Expression
        Adder obj = (a, b) -> a + b;
        System.out.println(obj.add(5, 6));

        /*
            Output:
                11
         */
    }
}
