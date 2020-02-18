package andersen.course.custom_linkedlist;

/**
 * Узел связного списка.
 */
public class Node<T> {

    private T element;

    private Node<T> next;

    private Node<T> prev;

    Node(T aElement) {
        element = aElement;
    }

    T getElement() {
        return element;
    }

    Node<T> getNext() {
        return next;
    }

    Node<T> getPrev() {
        return prev;
    }

    protected void setNext(Node<T> next) {
        this.next = next;
    }

    protected void setPrev(Node<T> prev) {
        this.prev = prev;
    }

}
