package multithreading;

class ProducerThread extends Thread {
    Data data;

    public ProducerThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (data) {
                try {
                    if (data.value >= 10) data.wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                data.value += 1;
                System.out.println("Produced: " + data.value);
                data.notify();
            }
        }
    }
}

class ConsumerThread extends Thread {
    Data data;

    public ConsumerThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (data) {
                try {
                    if (data.value <= 0) data.wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Consumed: " + data.value);
                data.value -= 1;
                data.notify();
            }
        }
    }
}

class Data {
    int value;
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Data data = new Data();
        ProducerThread producer = new ProducerThread(data);
        ConsumerThread consumer = new ConsumerThread(data);
        producer.start();
        consumer.start();

        /*
            Output:
                Produced: 1
                Consumed: 1
                Produced: 1
                Consumed: 1
                Produced: 1
                Consumed: 1
                Produced: 1
                Produced: 2
                Produced: 3
                Produced: 4
                Produced: 5
                Produced: 6
                Produced: 7
                Produced: 8
                Produced: 9
                Produced: 10
                Consumed: 10
                Produced: 10
                Consumed: 10
                Consumed: 9
                Produced: 9
                Consumed: 9
                Consumed: 8
                Consumed: 7
                Consumed: 6
                Consumed: 5
                Consumed: 4
                Consumed: 3
                Consumed: 2
                Consumed: 1
                Produced: 1
         */
    }
}
