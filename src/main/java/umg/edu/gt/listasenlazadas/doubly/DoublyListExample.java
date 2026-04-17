package umg.edu.gt.listasenlazadas.doubly;

/**
 * Ejemplo base para operaciones con lista doblemente enlazada.
 */
public final class DoublyListExample {

    private DoublyListExample() {
    }

    public static void run() {
        DoublyLinkedList<String> historialPaginas = new DoublyLinkedList<>();
        historialPaginas.addLast("Inicio");
        historialPaginas.addLast("Cursos");
        historialPaginas.addLast("Tareas");
        historialPaginas.addFirst("Login");

        System.out.println("--- Lista Doble ---");
        System.out.println("Recorrido normal: " + historialPaginas.toForwardString());
        System.out.println("Recorrido inverso: " + historialPaginas.toBackwardString());

        String ultimaPagina = historialPaginas.removeLast();
        System.out.println("Accion atras (removeLast): " + ultimaPagina);
        System.out.println("Estado actual: " + historialPaginas.toForwardString());
        System.out.println();
    }
}
