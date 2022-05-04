package executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProcessorThread implements Runnable {
    String task;
    public ProcessorThread(String task){
        this.task = task;
    }
    @Override
    public void run() {
        System.out.println("Processing " + task + " on thread " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class ExecutorDemo {
    public static void main(String[] args) {
        //Creating fixed thread pool of size 5
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //Creating 10 task
        for(int i = 0; i < 10; i++){
            Runnable task = new ProcessorThread("Task "+ (i + 1));
            executorService.submit(task); //sending thread for execution
        }

        //Shutting Down executor service after processing all task
        executorService.shutdown();

        /*
            Output:
                Processing Task 1 on thread pool-1-thread-1
                Processing Task 2 on thread pool-1-thread-2
                Processing Task 3 on thread pool-1-thread-3
                Processing Task 4 on thread pool-1-thread-2
                Processing Task 5 on thread pool-1-thread-3
                Processing Task 6 on thread pool-1-thread-1
                Processing Task 7 on thread pool-1-thread-1
                Processing Task 8 on thread pool-1-thread-2
                Processing Task 9 on thread pool-1-thread-3
                Processing Task 10 on thread pool-1-thread-3
         */
    }
}
