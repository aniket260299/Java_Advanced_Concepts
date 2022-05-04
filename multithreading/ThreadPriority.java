package multithreading;

public class ThreadPriority extends Thread {
    @Override
    public void run() {
        System.out.println("I am running");
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadPriority();
        /*
            We have three pre-defined priorities:
            MIN_PRIORITY : 1
            NORM_PRIORITY : 5
            MAX_PRIORITY : 10
         */

        t1.setPriority(6); //Always set priority before starting
        t1.start();

        /*
            Output:
                I am running
         */
    }
}
