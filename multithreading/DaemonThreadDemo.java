package multithreading;

class CustomThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}

public class DaemonThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        //Main thread is non daemon thread, and we can't change it
        System.out.println(Thread.currentThread().isDaemon());

        CustomThread1 ct1 = new CustomThread1();
        System.out.println(ct1.isDaemon()); //By default, any thread is non daemon
        ct1.start();
        ct1.join(); //waiting for ct1 to complete its execution

        CustomThread1 ct2 = new CustomThread1();
        ct2.setDaemon(true); //Setting ct2 as Daemon thread
        ct2.start(); //Main thread will not wail for daemon thread to complete its execution

        System.out.println("End of main");

        /*
            Output:
                false
                false
                1 2 3 4 5 6 7 8 9 10
                End of main
                1
         */
    }
}
