package multithreading;

class CustomThread extends Thread {
    CustomThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadGroupDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread current = Thread.currentThread();
        System.out.println(current.getName());

        //main thread is created under "main" thread group
        System.out.println(current.getThreadGroup().getName());
        //parent of "main" thread group is "system" thread group
        System.out.println(current.getThreadGroup().getParent().getName());

        //Creating our own thread group
        ThreadGroup parent = new ThreadGroup("Parent");
        //Creating thread group under "Parent" thread group
        ThreadGroup child = new ThreadGroup(parent, "child");
        //setting max priority for child thread group
        child.setMaxPriority(4);
        //Creating threads under "child" thread group
        Thread t1 = new Thread(child, "t1");
        Thread t2 = new Thread(child, "t2");
        //checking t1 priority
        System.out.println(t1.getPriority());

        //Creating two CustomThreads under child thread group
        CustomThread ct1 = new CustomThread(child, "CustomThread1");
        CustomThread ct2 = new CustomThread(child, "CustomThread2");
        ct1.start();
        ct2.start();
        //Fetching active thread count under child thread
        System.out.println(child.activeCount());
        //List child thread group information
        child.list();

        Thread.sleep(5000);

        System.out.println(child.activeCount());
        child.list();

        /*
            Output:
                main
                main
                system
                4
                2
                java.lang.ThreadGroup[name=child,maxpri=4]
                    Thread[CustomThread1,4,child]
                    Thread[CustomThread2,4,child]
                0
                java.lang.ThreadGroup[name=child,maxpri=4]
         */
    }
}
