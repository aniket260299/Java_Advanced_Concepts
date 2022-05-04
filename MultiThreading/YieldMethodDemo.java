package MultiThreading;

public class YieldMethodDemo implements Runnable {
    /*
        A yield() method is a static method of Thread class and it can stop the
        currently executing thread and will give a chance to other waiting threads
        of the same priority. If in case there are no waiting threads or if all the
        waiting threads have low priority then the same thread will continue its execution.
     */
    @Override
    public void run() {
        Thread.yield();
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread is Running");
        }

    }

    public static void main(String[] args) {
        YieldMethodDemo ymd = new YieldMethodDemo();
        Thread t1 = new Thread(ymd);
        t1.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main is Running");
        }

        /*
           Output (Main always complete its execution):
            Main is Running
            Main is Running
            Main is Running
            Main is Running
            Main is Running
            Thread is Running
            Thread is Running
            Thread is Running
            Thread is Running
            Thread is Running
         */
    }
}
