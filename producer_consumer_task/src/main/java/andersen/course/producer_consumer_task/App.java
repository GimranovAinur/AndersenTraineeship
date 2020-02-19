package andersen.course.producer_consumer_task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(10);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new Producer(buffer));
        executor.execute(new Consumer(buffer));

        executor.shutdown();
    }

}
