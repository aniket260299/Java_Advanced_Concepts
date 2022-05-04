package MultiThreading;

class DisplayMessages {
    public void sayHello(String name) {
        /*
            We have used synchronized block for object level locking and
            any code above synchronized block can be accessed by multiple threads simultaneously.
            Synchronized block can only be accessed by one thread at a time
         */
        synchronized (this) {
            for (int i = 0; i < 3; i++)
                System.out.println(name);
        }
    }
}

class MyThreadClass implements Runnable {
    private String name;
    private DisplayMessages dm;

    public MyThreadClass(String name, DisplayMessages dm) {
        this.name = name;
        this.dm = dm;
    }

    @Override
    public void run() {
        dm.sayHello(name);
    }
}

public class SynchronizedBlockDemo {
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
                Thread1
                Thread1
                Thread1
                Thread2
                Thread2
                Thread2
         */

    }
}
