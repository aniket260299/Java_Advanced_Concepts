package MultiThreading;

class MyThread1 implements Runnable {
    int sum = 0;

    @Override
    public void run() {
        //MyThread1 acquires the lock
        synchronized (this) {
            for (int i = 1; i <= 100; i++)
                sum += i;
            System.out.println("Main Thread Notified");
            this.notify(); //It will release the lock and notify the main thread
        }
    }
}

public class InterThreadCommunicationDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 mt1 = new MyThread1();
        Thread t1 = new Thread(mt1);
        t1.start();

        //we cannot use wait()/notify() without synchronization
        //Main thread will acquire the lock
        synchronized (t1) {
            System.out.println("Main is waiting");
            t1.wait(); //Main thread will release the lock and wait for t1 thread for notification
            System.out.println(mt1.sum);
        }

        /*
            Output:
                Main is waiting
                Main Thread Notified
                5050
         */
    }
}
