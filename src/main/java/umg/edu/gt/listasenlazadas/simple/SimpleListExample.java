package umg.edu.gt.listasenlazadas.simple;

/**
 * Ejemplo didactico de operaciones con lista simplemente enlazada.
 */
public final class SimpleListExample {

    private SimpleListExample() {
    }

    public static void run() {
        SinglyLinkedList<String> pendientes = new SinglyLinkedList<>();
        pendientes.addLast("Investigar tema de grafos");
        pendientes.addLast("Resolver hoja de ejercicios");
        pendientes.addFirst("Repasar listas enlazadas");

        System.out.println("--- Lista Simple ---");
        System.out.println("Pendientes: " + pendientes);
        System.out.println("Contiene 'grafos': " + pendientes.contains("Investigar tema de grafos"));

        String completada = pendientes.removeFirst();
        System.out.println("Tarea completada: " + completada);
        System.out.println("Pendientes actualizados: " + pendientes);
        System.out.println();
    }
}
