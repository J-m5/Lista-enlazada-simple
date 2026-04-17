package umg.edu.gt.listasenlazadas.doubly;

/**
 * Nodo para lista doblemente enlazada.
 *
 * @param <T> tipo de dato almacenado
 */
final class DoublyNode<T> {
    private final T value;
    private DoublyNode<T> previous;
    private DoublyNode<T> next;

    DoublyNode(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    DoublyNode<T> getPrevious() {
        return previous;
    }

    void setPrevious(DoublyNode<T> previous) {
        this.previous = previous;
    }

    DoublyNode<T> getNext() {
        return next;
    }

    void setNext(DoublyNode<T> next) {
        this.next = next;
    }
}
