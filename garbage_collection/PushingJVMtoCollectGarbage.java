package garbage_collection;

public class PushingJVMtoCollectGarbage {
    int id;

    public PushingJVMtoCollectGarbage(int id) {
        this.id = id;
        System.out.println("Object: " + this.id + " created");
    }

    //Called by GC before destroying the object
    protected void finalize() throws Throwable {
        System.out.println("Object: " + this.id + " finalized");
    }

    public static void main(String[] args) {
        //creating 500000 unreachable object
        for (int i = 1; i <= 500000; i++) {
            new PushingJVMtoCollectGarbage(i);
        }

        /*
            JVM only calls Garbage Collector when it is running out of memory.
            Output:
                59887 finalized
                Object: 59886 finalized
                Object: 59884 finalized
                Object: 59883 finalized
                Object: 135082 created
                Object: 59882 finalized
                Object: 135083 created
                Object: 135084 created
                Object: 135085 created
                Object: 135086 created
                Object: 135087 created
                Object: 135088 created
                Object: 135089 created
                Object: 135090 created
                Object: 135091 created
         */
    }
}
