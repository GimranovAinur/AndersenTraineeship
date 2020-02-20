package andersen.course.producer_consumer_task;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedBuffer<T> {

    /** Вместимость буфера */
    private final int capacity;

    /** Буфер обмена */
    private final List<T> buffer;

    public SynchronizedBuffer(int aCapacity) {
        buffer = new ArrayList<>(aCapacity);
        capacity = aCapacity;
    }

    /**
     * Добавляет значение в буфер.
     *
     * @param aValue новое значение
     * @throws InterruptedException при прерывании ожидания освобождения места в буфере
     */
    public void add(T aValue) throws InterruptedException {
        synchronized (this) {
            while (buffer.size() >= capacity) {
                wait();
            }
            buffer.add(aValue);
            notify();
        }
    }

    /**
     * Извлекает и возвращает значение из буфера.
     *
     * @return значение из буфера
     * @throws InterruptedException при прерывании ожидания добавления значений
     */
    public T pop() throws InterruptedException {
        synchronized (this) {
            while (buffer.size() == 0) {
                wait();
            }
            T value = buffer.remove(0);
            notify();
            return value;
        }
    }

}
