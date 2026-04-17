package umg.edu.gt.listasenlazadas.simple;

/**
 * Nodo para lista simplemente enlazada.
 *
 * @param <T> tipo de dato almacenado
 */
final class SimpleNode<T> {
    private final T value;
    private SimpleNode<T> next;

    SimpleNode(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    SimpleNode<T> getNext() {
        return next;
    }

    void setNext(SimpleNode<T> next) {
        this.next = next;
    }
}
