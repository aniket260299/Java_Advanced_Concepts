package MultiThreading;

public class InterruptMethodDemo implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread is running");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("I am interrupted");
        }
    }

    public static void main(String[] args) {
        InterruptMethodDemo imd = new InterruptMethodDemo();
        Thread t1 = new Thread(imd);
        t1.start();
        t1.interrupt(); // we can only interrupt a thread if its in sleep mode
        System.out.println("End of main");

        /*
            End of main
            Thread is running
            I am interrupted
         */
    }
}
