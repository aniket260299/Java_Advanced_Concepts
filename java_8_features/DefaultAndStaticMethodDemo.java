package java_8_features;

//Interface can have default and static method
interface DefaultAndStaticMethod {
    //Default method
    default void add(int a, int b) {
        System.out.println(a + b);
    }

    //Static Method
    static void sub(int a, int b) {
        System.out.println(a - b);
    }
}

public class DefaultAndStaticMethodDemo {
    public static void main(String[] args) {
        //Accessing static method
        DefaultAndStaticMethod.sub(6, 3);

        //Providing implementation of interface using anonymous inner class
        DefaultAndStaticMethod obj = new DefaultAndStaticMethod() { };
        obj.add(5, 3);

        /*
            Output:
                3
                8
         */
    }
}

