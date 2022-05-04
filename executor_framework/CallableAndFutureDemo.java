package executor_framework;

import java.util.concurrent.*;

class CalculateSum implements Callable<Integer> {
    int N;

    public CalculateSum(int N) {
        this.N = N;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Calculating sum till " + N +
                " on Thread " + Thread.currentThread().getName());

        int sum = 0;
        for (int i = 1; i <= N; i++)
            sum += i;

        Thread.sleep(1000); //Simulating processing time

        return sum;
    }
}

public class CallableAndFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Creating thread pool of size 2
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer>[] results = new Future[5]; //Creating Future array for storing result

        int j = 0;
        for (int i = 6; i <= 10; i++) {
            Callable<Integer> task = new CalculateSum(i); //Creating Callable Task
            results[j++] = executorService.submit(task);  //Submitting task and Storing future result
        }
        executorService.shutdown(); //Shutting down executor service after running all tasks

        //Extracting result from future
        j = 6;
        for (Future<Integer> result : results) {
            System.out.println("Sum till " + j + " = " + result.get());
            j++;
        }

        /*
            Output:
                Calculating sum till 6 on Thread pool-1-thread-1
                Calculating sum till 7 on Thread pool-1-thread-2
                Sum till 6 = 21
                Calculating sum till 9 on Thread pool-1-thread-1
                Calculating sum till 8 on Thread pool-1-thread-2
                Sum till 7 = 28
                Calculating sum till 10 on Thread pool-1-thread-2
                Sum till 8 = 36
                Sum till 9 = 45
                Sum till 10 = 55
         */
    }

}
