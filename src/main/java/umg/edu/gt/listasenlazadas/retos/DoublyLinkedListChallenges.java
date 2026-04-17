package umg.edu.gt.listasenlazadas.retos;

import umg.edu.gt.listasenlazadas.doubly.DoublyLinkedList;

/**
 * Retos para lista doblemente enlazada.
 * Incluye casos de prueba con resultado esperado.
 */
public final class DoublyLinkedListChallenges {

    private DoublyLinkedListChallenges() {
    }

    public static void run() {
        System.out.println("=== RETOS LISTA DOBLE ===");
        challenge1CountOccurrences();
        challenge2Clean();
        challenge3ReverseInPlace();
        challenge4RemoveDuplicates();
        System.out.println();
    }

    private static void challenge1CountOccurrences() {
        DoublyLinkedList<String> historial = new DoublyLinkedList<>();
        historial.addLast("EDIT");
        historial.addLast("SAVE");
        historial.addLast("EDIT");
        historial.addLast("UNDO");
        historial.addLast("EDIT");

        System.out.println("Reto D1 - Conteo de ocurrencias");
        System.out.println("Datos: " + historial.toForwardString());
        try {
            int total = historial.countOccurrences("EDIT");
            printCheck("countOccurrences(EDIT)", 3, total);
        } catch (UnsupportedOperationException ex) {
            System.out.println("  [PENDIENTE] " + ex.getMessage());
        }
        System.out.println();
    }

    private static void challenge2Clean() {
        DoublyLinkedList<Integer> numeros = new DoublyLinkedList<>();
        numeros.addLast(1);
        numeros.addLast(2);
        numeros.addLast(3);
        numeros.addLast(4);

        System.out.println("Reto D2 - Limpiar lista");
        System.out.println("Antes: " + numeros.toForwardString() + " size=" + numeros.size());
        try {
            int removed = numeros.clean();
            printCheck("clean() removidos", 4, removed);
            printCheck("size final", 0, numeros.size());
            printCheck("isEmpty final", true, numeros.isEmpty());
        } catch (UnsupportedOperationException ex) {
            System.out.println("  [PENDIENTE] " + ex.getMessage());
        }
        System.out.println();
    }

    private static void challenge3ReverseInPlace() {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<>();
        lista.addLast(10);
        lista.addLast(20);
        lista.addLast(30);
        lista.addLast(40);

        System.out.println("Reto D3 - Inversion in-place");
        System.out.println("Antes (forward): " + lista.toForwardString());
        System.out.println("Antes (backward): " + lista.toBackwardString());
        try {
            lista.reverseInPlace();
            printCheck("forward invertido", "[40, 30, 20, 10]", lista.toForwardString());
            printCheck("backward invertido", "[10, 20, 30, 40]", lista.toBackwardString());
        } catch (UnsupportedOperationException ex) {
            System.out.println("  [PENDIENTE] " + ex.getMessage());
        }
        System.out.println();
    }

    private static void challenge4RemoveDuplicates() {
        DoublyLinkedList<String> codigos = new DoublyLinkedList<>();
        codigos.addLast("A");
        codigos.addLast("B");
        codigos.addLast("A");
        codigos.addLast("C");
        codigos.addLast("B");
        codigos.addLast("D");
        codigos.addLast("D");

        System.out.println("Reto D4 - Eliminar duplicados");
        System.out.println("Antes: " + codigos.toForwardString());
        try {
            int removed = codigos.removeDuplicates();
            printCheck("removeDuplicates removidos", 3, removed);
            printCheck("contenido final", "[A, B, C, D]", codigos.toForwardString());
            printCheck("size final", 4, codigos.size());
        } catch (UnsupportedOperationException ex) {
            System.out.println("  [PENDIENTE] " + ex.getMessage());
        }
        System.out.println();
    }

    private static void printCheck(String testName, Object expected, Object actual) {
        boolean ok = isSame(expected, actual);
        String status = ok ? "OK" : "FALLO";
        System.out.println("  [" + status + "] " + testName
                + " -> esperado=" + expected + ", obtenido=" + actual);
    }

    private static boolean isSame(Object left, Object right) {
        return left == right || (left != null && left.equals(right));
    }
}
