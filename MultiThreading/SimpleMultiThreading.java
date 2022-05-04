package MultiThreading;

public class SimpleMultiThreading extends Thread {
    static int sum = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleMultiThreading t1 = new SimpleMultiThreading();
        t1.start(); //It initializes the  t1 thread and schedule it for execution
        t1.join();  // It will wait for t1 thread to complete its execution then next lines will execute
        System.out.println(sum); // It will only execute after t1 thread complete its execution

        //Calculating the run method execution time
        long startTime = System.currentTimeMillis();
        t1.run();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to execute t1.run() : " + (endTime - startTime) / 1000 + " Seconds");

        /*
            Output:
                45
                Time taken to execute t1.run() : 10 Seconds
         */
    }
}
