package umg.edu.gt.listasenlazadas.doubly;

/**
 * Implementacion basica de una lista doblemente enlazada.
 *
 * @param <T> tipo de dato almacenado
 */
public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;

    public void addFirst(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }

        T value = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrevious(null);
        }
        size--;
        return value;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        }

        T value = tail.getValue();
        tail = tail.getPrevious();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        size--;
        return value;
    }

    public boolean contains(T value) {
        DoublyNode<T> current = head;
        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int countOccurrences(T value) {
        int count = 0;
        DoublyNode<T> current = head;
        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                count++;
            }
            current = current.getNext();
        }
        return count;
    }

    public int clean() {
        if (head == null) {
            return 0;
        }
        
        int count = size;
        DoublyNode<T> current = head;
        
        while (current != null) {
            DoublyNode<T> nextNode = current.getNext();
            current.setNext(null);
            current.setPrevious(null);
            current = nextNode;
        }
        
        head = null;
        tail = null;
        size = 0;
        
        return count;
    }

    public void reverseInPlace() {
        if (head == null || head.getNext() == null) {
            return;
        }
        
        DoublyNode<T> current = head;
        DoublyNode<T> temp = null;
        
        while (current != null) {
            temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);
            current = current.getPrevious();
        }
        
        temp = head;
        head = tail;
        tail = temp;
    }

    public int removeDuplicates() {
        if (head == null || head.getNext() == null) {
            return 0;
        }
        
        int removedCount = 0;
        DoublyNode<T> current = head;
        
        while (current != null && current.getNext() != null) {
            DoublyNode<T> runner = current.getNext();
            
            while (runner != null) {
                if (isSameValue(current.getValue(), runner.getValue())) {
            
                    DoublyNode<T> nextNode = runner.getNext();
                    DoublyNode<T> prevNode = runner.getPrevious();
                    
                    if (prevNode != null) {
                        prevNode.setNext(nextNode);
                    }
                    if (nextNode != null) {
                        nextNode.setPrevious(prevNode);
                    }
                    if (runner == tail) {
                        tail = prevNode;
                    }
                    removedCount++;
                    size--;
                    runner = nextNode;
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
        
        return removedCount;
    }

    public String toForwardString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> current = head;
        while (current != null) {
            builder.append(current.getValue());
            if (current.getNext() != null) {
                builder.append(", ");
            }
            current = current.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    public String toBackwardString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyNode<T> current = tail;
        while (current != null) {
            builder.append(current.getValue());
            if (current.getPrevious() != null) {
                builder.append(", ");
            }
            current = current.getPrevious();
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public String toString() {
        return toForwardString();
    }

    private boolean isSameValue(T left, T right) {
        return left == right || (left != null && left.equals(right));
    }
}
