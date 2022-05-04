package multithreading;

class DisplayMessage {
    //this method is synchronized so only one can access is at anytime
    public synchronized void sayHello(String name) {
        for (int i = 0; i < 3; i++)
            System.out.println(name);
    }
}

class MyThread implements Runnable {
    private String name;
    private DisplayMessages dm;

    public MyThread(String name, DisplayMessages dm) {
        this.name = name;
        this.dm = dm;
    }

    @Override
    public void run() {
        dm.sayHello(name);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        DisplayMessages dm = new DisplayMessages(); //we will share this object between objects

        MyThreadClass mt1 = new MyThreadClass("Thread1", dm);
        MyThreadClass mt2 = new MyThreadClass("Thread2", dm);
        Thread t1 = new Thread(mt1);
        Thread t2 = new Thread(mt2);

        t1.start();
        t2.start();

        /*
            Output:
                Thread2
                Thread2
                Thread2
                Thread1
                Thread1
                Thread1
         */

    }
}
