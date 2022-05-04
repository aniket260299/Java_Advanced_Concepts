package multithreading;

class PrintMessage {
    //this method is static and synchronized, hence we have achieved class level locking
    public static synchronized void sayHello(String name) {
        for (int i = 0; i < 3; i++)
            System.out.println(name);
    }
}

class ThreadClass implements Runnable {
    private String name;

    public ThreadClass(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        PrintMessage.sayHello(name);
    }
}

public class ClassLevelLocking {
    public static void main(String[] args) {

        ThreadClass mt1 = new ThreadClass("Thread1");
        ThreadClass mt2 = new ThreadClass("Thread2");
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
