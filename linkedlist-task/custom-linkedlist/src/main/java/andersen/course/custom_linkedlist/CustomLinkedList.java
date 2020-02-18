package andersen.course.custom_linkedlist;

/**
 * Реализация связного списка.
 *
 * @param <T> тип хранящегося элемента
 */
public class CustomLinkedList<T> {

    /** Размер списка */
    private int size;

    /** Первый элемент */
    private Node<T> first;

    /** Последний элемент */
    private Node<T> last;

    /**
     * Добавляет элемент в конец списка.
     *
     * @param aElement новый элемент
     */
    public void add(T aElement) {
        Node<T> newNode = new Node<>(aElement);
        if (first == null) {
            newNode.setNext(null);
            newNode.setPrev(null);
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrev(last);
            last = newNode;
        }
        size++;
    }

    /**
     * Добавляет элемент на позицию по индеку.
     *
     * @param aElement новый элемент
     * @param aIndex позиция для вставки
     */
    public void add(T aElement, int aIndex) {
        if (aIndex == size) {
            add(aElement);
            return;
        }

        Node<T> newNode = new Node<>(aElement);
        Node<T> currentNode = first;
        for (int i = 0; i < aIndex; i++) {
            currentNode = currentNode.getNext();
        }

        Node<T> prevNode = currentNode.getPrev();
        prevNode.setNext(newNode);
        currentNode.setPrev(newNode);

        newNode.setPrev(prevNode);
        newNode.setNext(currentNode);
        size++;
    }

    /**
     * Очищает список.
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Возвращает элемент по индексу.
     *
     * @param aIndex индекс
     * @return элемент по индексу
     */
    public T get(int aIndex) {
        Node<T> desiredNode = first;
        for (int i = 0; i < aIndex; i++) {
            desiredNode = desiredNode.getNext();
        }
        return desiredNode.getElement();
    }

    /**
     * Удаляет элемент из начала списка.
     *
     * @return удаленный элемент
     */
    public T remove() {
        Node<T> nodeToRemove = first;
        first = first.getNext();
        size--;
        return nodeToRemove.getElement();
    }

    /**
     * Удаляет элемент по индексу.
     *
     * @param aIndex индекс
     * @return удаленный элемент
     */
    public T remove(int aIndex) {
        Node<T> nodeToRemove = first;
        for (int i = 0; i < aIndex; i++) {
            nodeToRemove = nodeToRemove.getNext();
        }

        Node<T> prevNode = nodeToRemove.getPrev();
        Node<T> nextNode = nodeToRemove.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;

        return nodeToRemove.getElement();
    }

    /**
     * Удаляет первое вхождение элемента из списка.
     *
     * @param aElementToRemove элемент для удаления
     * @return удаленный элемент
     */
    public T remove(T aElementToRemove) {
        Node<T> nodeToRemove = null;
        Node<T> currentNode = first;
        while (nodeToRemove == null) {
            if (currentNode.getElement().equals(aElementToRemove)) {
                nodeToRemove = currentNode;
            }
            currentNode = currentNode.getNext();
        }

        Node<T> prevNode = nodeToRemove.getPrev();
        Node<T> nextNode = nodeToRemove.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;

        return nodeToRemove.getElement();
    }

    /**
     * Возвращает размер списка.
     *
     * @return размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Реверсирует список.
     */
    public void reverse() {
        Node<T> currentNode = first;
        Node<T> currentNextNode = first.getNext();
        last = first;
        last.setPrev(first.getNext());
        last.setNext(null);

        while (currentNextNode != null) {
            Node<T> tempNode = currentNextNode;
            currentNextNode = currentNextNode.getNext();
            tempNode.setNext(currentNode);
            currentNode = tempNode;
        }

        first = currentNode;
        first.setPrev(null);
    }

    /**
     * Возвращает первый элемент.
     *
     * @return первый элемент.
     */
    public T getFirst() {
        return first.getElement();
    }

    /**
     * Возвращает последний элемент.
     *
     * @return последний элемент
     */
    public T getLast() {
        return last.getElement();
    }

}
