package multithreading;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("I am running");
    }

    public static void main(String[] args) {
        RunnableThread rt = new RunnableThread(); //We can't directly use rt.start()
        Thread t1 = new Thread(rt); //We need to create Thread object using Thread(obj)
        t1.start();

        /*
            Output:
                I am running
         */
    }
}
