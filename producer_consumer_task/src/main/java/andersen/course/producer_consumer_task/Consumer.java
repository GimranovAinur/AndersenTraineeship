package andersen.course.producer_consumer_task;

/**
 * Потребитель.
 */
public class Consumer implements Runnable {

    /** Общий буфер */
    private final SynchronizedBuffer<Integer> buffer;

    public Consumer(SynchronizedBuffer<Integer> aBuffer) {
        buffer = aBuffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int value = buffer.pop();
                System.out.println("Получено значение: " + value);
            } catch (InterruptedException e) {
                System.out.println("Работа потребителя прервана");
                Thread.currentThread().interrupt();
            }
        }
    }

}
