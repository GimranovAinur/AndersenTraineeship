package andersen.course.producer_consumer_task;

import java.util.concurrent.BlockingQueue;

/**
 * Производитель.
 */
public class Producer implements Runnable {

    /** Общий буфер */
    private final BlockingQueue<Integer> buffer;

    public Producer(BlockingQueue<Integer> aBuffer) {
        buffer = aBuffer;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            try {
                buffer.put(value);
                System.out.println("Добавлено значение: " + value);
                value++;
            } catch (InterruptedException e) {
                System.out.println("Работа производителя прервана");
                Thread.currentThread().interrupt();
            }
        }
    }

}
