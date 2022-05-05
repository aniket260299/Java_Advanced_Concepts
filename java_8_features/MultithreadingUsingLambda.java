package java_8_features;

public class MultithreadingUsingLambda {
    public static void main(String[] args) {
        //() -> System.out.println("Thread is running") is implementation of Runnable interface
        //This way of implementation is called as Anonymous inner class using Lambda
        Thread t1 = new Thread(() -> System.out.println("Thread is running"));
        t1.start();

        /*
            Output:
                Thread is running
         */
    }
}
