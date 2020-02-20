package andersen.course.producer_consumer_task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        SynchronizedBuffer<Integer> buffer = new SynchronizedBuffer<>(2);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new Producer(buffer));
        executor.execute(new Producer(buffer));
        executor.execute(new Consumer(buffer));

        executor.shutdown();
    }

}
