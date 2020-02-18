package andersen.course.custom_linkedlist;

/**
 * Реализация связного списка.
 *
 * @param <T> тип хранящегося элемента
 */
public class CustomLinkedList<T> implements Cloneable {

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
        if (aIndex == 0) {
            newNode.setNext(first);
            first.setPrev(newNode);
            first = newNode;
        } else {
            Node<T> currentNode = first;
            for (int i = 0; i < aIndex; i++) {
                currentNode = currentNode.getNext();
            }

            Node<T> prevNode = currentNode.getPrev();
            prevNode.setNext(newNode);
            currentNode.setPrev(newNode);

            newNode.setPrev(prevNode);
            newNode.setNext(currentNode);
        }
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
        if ((aIndex < 0) || (aIndex >= size)) {
            return null;
        }

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
        Node<T> nodeToRemove;
        if (aIndex == 0) {
            nodeToRemove = last;
            Node<T> nextNode = first.getNext();
            nextNode.setPrev(null);
            first = nextNode;
        } else if (aIndex == (size - 1)) {
            nodeToRemove = first;
            Node<T> prevNode = last.getPrev();
            prevNode.setNext(null);
            last = prevNode;
        } else {
            nodeToRemove = first;
            for (int i = 0; i < aIndex; i++) {
                nodeToRemove = nodeToRemove.getNext();
            }
            Node<T> prevNode = nodeToRemove.getPrev();
            Node<T> nextNode = nodeToRemove.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
        }
        size--;

        return nodeToRemove.getElement();
    }

    /**
     * Удаляет первое вхождение элемента из списка.
     *
     * @param aElementToRemove элемент для удаления
     * @return удаленный элемент
     */
    public boolean remove(T aElementToRemove) {
        if ((size == 1) && aElementToRemove.equals(first)) {
            clear();
            return true;
        }

        boolean removed = false;

        Node<T> nodeToRemove = first;
        for (int i = 0; i < size; i++) {
            if (nodeToRemove.getElement().equals(aElementToRemove)) {
                break;
            }
            nodeToRemove = nodeToRemove.getNext();
        }

        if (nodeToRemove.getPrev() == null) {
            first = first.getNext();
            first.setPrev(null);
            removed = true;
        } else if (nodeToRemove.getNext() == null) {
            last = last.getPrev();
            last.setNext(null);
            removed = true;
        } else {
            Node<T> prevNode = nodeToRemove.getPrev();
            Node<T> nextNode = nodeToRemove.getNext();
            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
            removed = true;
        }
        size--;

        return removed;
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
     * Возвращает признак того, что список пустой.
     *
     * @return признак того, что список пустой
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращает признак наличия элемента в списке.
     *
     * @param aElement искомый элемент
     * @return признак наличия элемента в списке
     */
    public boolean contains(T aElement) {
        Node<T> currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.getElement().equals(aElement)) {
                return true;
            }
        }
        return false;
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
