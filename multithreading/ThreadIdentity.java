package multithreading;

public class ThreadIdentity extends Thread {
    @Override
    public void run() {
        Thread t1 = Thread.currentThread(); //get the current thread object
        System.out.println("My name is : " + t1.getName());

        t1.setName("New Alias"); //It will set/change the name of thread
        System.out.println("My name is : " + t1.getName());
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadIdentity();
        t1.setName("Aliased Thread"); //Setting name of thread
        t1.start();

        /*
            Output:
                My name is : Aliased Thread
                My name is : New Alias
         */
    }
}
