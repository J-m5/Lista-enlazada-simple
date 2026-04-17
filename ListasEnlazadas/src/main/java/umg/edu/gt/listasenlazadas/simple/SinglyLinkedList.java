package umg.edu.gt.listasenlazadas.simple;

/**
 * Implementacion basica de una lista simplemente enlazada.
 *
 * @param <T> tipo de dato almacenado
 */
public class SinglyLinkedList<T> {
    private SimpleNode<T> head;
    private SimpleNode<T> tail;
    private int size;

    public void addFirst(T value) {
        SimpleNode<T> newNode = new SimpleNode<>(value);
        newNode.setNext(head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        SimpleNode<T> newNode = new SimpleNode<>(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
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
        }
        size--;
        return value;
    }

    public boolean remove(T value) {
        if (head == null) {
            return false;
        }

        if (isSameValue(head.getValue(), value)) {
            removeFirst();
            return true;
        }

        SimpleNode<T> previous = head;
        SimpleNode<T> current = head.getNext();

        while (current != null) {
            if (isSameValue(current.getValue(), value)) {
                previous.setNext(current.getNext());
                if (current == tail) {
                    tail = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public boolean contains(T value) {
        SimpleNode<T> current = head;
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

    /**
     * RETO 1:
     * Cuenta cuantas veces aparece un valor dentro de la lista.
     *
     * Reglas sugeridas:
     * - No usar arreglos ni librerias externas.
     * - Resolver solo con recorrido de nodos.
     * - Complejidad esperada: O(n).
     *
     * @param value valor a buscar
     * @return cantidad de ocurrencias encontradas
     */
    public int countOccurrences(T value) {
        int count = 0;
        SimpleNode<T> current = head;
        while(current != null) {
        	if(isSameValue(current.getValue(), value)) {
        		count++;
        	}
        	current = current.getNext();
        }
        return count;
    }
    
    /**
     * RETO 2 (intermedio):
     * Limpia completamente la lista y retorna cuántos nodos fueron eliminados.
     *
     * Objetivo pedagógico:
     * - Entender cómo recorrer y "desconectar" nodos en una lista enlazada.
     * - Reforzar invariantes de la estructura (head, tail, size).
     *
     * Reglas sugeridas:
     * - No usar estructuras auxiliares.
     * - Desconectar nodo por nodo (setNext(null)).
     * - Al final: head == null, tail == null, size == 0.
     *
     * Casos de prueba sugeridos:
     * - Lista vacía -> retorna 0.
     * - Lista con 1 nodo -> retorna 1 y queda vacía.
     * - Lista con n nodos -> retorna n y queda vacía.
     *
     * @return cantidad de nodos eliminados
     */
    public int clean() {
        if (head == null) {
        	return 0;
        }
        int count = size;
        SimpleNode<T> current = head;
        while (current != null) {
        	SimpleNode<T> nextNode =
        			current.getNext();
        	current.setNext(null);
        	current = nextNode;
        }
        head = null;
        tail = null;
        size = 0;
        return count;
        
    }

    /**
     * RETO 3 (intermedio/avanzado):
     * Invierte la lista en el mismo objeto (in-place).
     *
     * Ejemplo:
     * Antes: [2, 4, 5, 6]
     * Después: [6, 5, 4, 2]
     *
     * Objetivo pedagógico:
     * - Dominar manipulación de punteros previous/current/next.
     * - Actualizar correctamente head y tail.
     *
     * Reglas sugeridas:
     * - No crear una nueva lista.
     * - No usar recursión.
     * - Complejidad esperada: O(n) tiempo, O(1) memoria extra.
     *
     * Casos de prueba sugeridos:
     * - Lista vacía.
     * - Lista con un elemento.
     * - Lista con varios elementos.
     */
    public void reverseInPlace() {
        if (head == null || head.getNext() == null) {
        	return;
        }
        SimpleNode<T> previous = null;
        SimpleNode<T> current = head;
        SimpleNode<T> nextNode = null;
        
        while (current != null) {
        	nextNode = current.getNext();
        	current.setNext(previous);
        	previous = current;
        	current = nextNode;
        }
        
        tail = head;
        head = previous;
    }

    /**
     * RETO 4 (avanzado):
     * Elimina duplicados conservando la primera aparición de cada valor.
     *
     * Ejemplo:
     * Antes: [A, B, A, C, B, D]
     * Después: [A, B, C, D]
     *
     * Objetivo pedagógico:
     * - Practicar recorridos anidados y eliminación interna de nodos.
     * - Mantener consistencia de enlaces y tamaño tras cada eliminación.
     *
     * Reglas sugeridas:
     * - No usar HashSet, Map, arreglos u otras estructuras auxiliares.
     * - Resolver comparando nodos de forma manual.
     * - Complejidad esperada sin auxiliares: O(n^2).
     *
     * @return cantidad de nodos eliminados por duplicados
     */
    public int removeDuplicates() {
        if (head == null || head.getNext() == null) {
            return 0;
        }
        
        int removedCount = 0;
        SimpleNode<T> current = head;
        
        while (current != null && current.getNext() != null) {
            SimpleNode<T> runner = current;
            
            while (runner.getNext() != null) {
                if (isSameValue(current.getValue(), runner.getNext().getValue())) {
                    runner.setNext(runner.getNext().getNext());
                    removedCount++;
                    size--; 
                    
                    if (runner.getNext() == null) {
                        tail = runner;
                    }
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
        
        return removedCount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        SimpleNode<T> current = head;
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

    private boolean isSameValue(T left, T right) {
        return left == right || (left != null && left.equals(right));
    }
}
