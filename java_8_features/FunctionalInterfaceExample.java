package java_8_features;

//Functional Interface
interface FunctionalInterface {
    void display();
}

class FunctionalInterfaceExample {
    public static void main(String[] args) {
        //Providing implementation of Functional Interface using Lambda Expression
        FunctionalInterface fi = () -> System.out.println("Hello");
        fi.display();

        /*
            Output:
                Hello
         */
    }
}
