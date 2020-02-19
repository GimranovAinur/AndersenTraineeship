package andersen.course.producer_consumer_task;

import java.util.concurrent.BlockingQueue;

/**
 * Потребитель.
 */
public class Consumer implements Runnable {

    /** Общий буфер */
    private final BlockingQueue<Integer> buffer;

    public Consumer(BlockingQueue<Integer> aBuffer) {
        buffer = aBuffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int value = buffer.take();
                System.out.println("Получено значение: " + value);
            } catch (InterruptedException e) {
                System.out.println("Работа потребителя прервана");
                Thread.currentThread().interrupt();
            }
        }
    }

}
