package garbage_collection;

public class RequestingJVMforGarbageCollection {
    int id;

    public RequestingJVMforGarbageCollection(int id) {
        this.id = id;
        System.out.println("Object created: " + this.id);
    }

    protected void finalize() throws Throwable {
        System.out.println("Object finalized: " + this.id);
    }

    public static void main(String[] args) throws InterruptedException {
        //Creating two unreachable object
        new RequestingJVMforGarbageCollection(1);
        new RequestingJVMforGarbageCollection(2);

        //Requesting JVM for garbage collection
        System.gc();

        Thread.sleep(1000);

        /*
            There is no guarantee that after calling System.gc() garbage is collected.
            Output:
                Object created: 1
                Object created: 2
                Object finalized: 2
                Object finalized: 1
         */
    }
}
