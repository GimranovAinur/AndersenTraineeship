package andersen.course.producer_consumer_task;

/**
 * Производитель.
 */
public class Producer implements Runnable {

    /** Общий буфер */
    private final SynchronizedBuffer<Integer> buffer;

    public Producer(SynchronizedBuffer<Integer> aBuffer) {
        buffer = aBuffer;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            try {
                synchronized (buffer) {
                    buffer.add(value);
                    System.out.println("Добавлено значение: " + value + "через "
                            + Thread.currentThread().getName());
                    value++;
                }
            } catch (InterruptedException e) {
                System.out.println("Работа производителя прервана");
                Thread.currentThread().interrupt();
            }
        }
    }

}
