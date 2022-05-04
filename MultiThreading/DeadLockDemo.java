package MultiThreading;

class Thread1 extends Thread {
    Resource r1, r2;

    public Thread1(Resource r1, Resource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        synchronized (r1) {
            System.out.println("Locked resource1 in Thread1");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread1 is trying to access resource2");
            synchronized (r2) {
                System.out.println("Locking resource2 in Thread1");
            }
        }
    }
}

class Thread2 extends Thread {
    Resource r1, r2;

    public Thread2(Resource r1, Resource r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void run() {
        synchronized (r2) {
            System.out.println("Locked resource2 in Thread2");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread2 is trying to access resource1");
            synchronized (r1) {
                System.out.println("Locking resource1 in Thread2");
            }
        }
    }
}

class Resource {
}

public class DeadLockDemo {
    public static void main(String[] args) {
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        Thread1 t1 = new Thread1(r1, r2);
        Thread2 t2 = new Thread2(r1, r2);
        t1.start();
        t2.start();

        /*
            Flow:
            -> Thread1 will start and lock resource1 for 500ms
            -> Thread2 will start and lock resource2 for 500ms
            -> Thread1 will try to access resource2, but it is locked by Thread2
            -> Thread2 will try to access resource1, but it is locked by Thread1
            -> Both threads are in deadlock state

            Output:
                Locked resource1 in Thread1
                Locked resource2 in Thread2
                Thread1 is trying to access resource2
                Thread2 is trying to access resource1
         */
    }
}
