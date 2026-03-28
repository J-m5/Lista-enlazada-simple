# ListasEnlazadas

Proyecto de apoyo para **Programacion 3** con implementaciones propias de:

- Lista simplemente enlazada
- Lista circular
- Lista doblemente enlazada

Incluye ejemplos academicos y aplicaciones de casos reales para entender cuando usar cada estructura.

## Tecnologias

- Java 11
- Maven

## Estructura del proyecto

```text
src/main/java/umg/edu/gt/listasenlazadas/
  Main.java
  simple/
    SimpleNode.java
    SinglyLinkedList.java
    SimpleListExample.java
  circular/
    CircularNode.java
    CircularLinkedList.java
    CircularListExample.java
  doubly/
    DoublyNode.java
    DoublyLinkedList.java
    DoublyListExample.java
  applications/
    TaskBacklogApp.java
    RoundRobinPlaylistApp.java
    UndoRedoEditorApp.java
  retos/
    LinkedListChallenges.java
```

## Ejecucion

Compilar:

```bash
mvn clean compile
```

Ejecutar demo principal:

```bash
mvn exec:java -Dexec.mainClass="umg.edu.gt.listasenlazadas.Main"
```

> Si no tienes configurado el plugin `exec`, puedes ejecutar desde tu IDE la clase `Main`.

## Casos reales incluidos

1. **TaskBacklogApp**: cola de tareas con lista simple (flujo FIFO basico).
2. **RoundRobinPlaylistApp**: reproduccion ciclica con lista circular.
3. **UndoRedoEditorApp**: historial de acciones con lista doblemente enlazada.

## Retos para estudiantes (modificando estructura base)

El proyecto incluye `retos/LinkedListChallenges.java`, que ejecuta escenarios donde
el codigo base necesita ser extendido con nuevos metodos:

1. `SinglyLinkedList.countOccurrences(T value)`
2. `CircularLinkedList.jumpsToValue(T value)`
3. `DoublyLinkedList.indexFromTail(T value)`

Estos metodos estan declarados con `TODO` y `UnsupportedOperationException`,
para que los estudiantes los implementen directamente en cada estructura.

## Buenas practicas aplicadas

- Clases genericas (`<T>`) para reutilizar estructuras.
- Separacion por paquetes segun responsabilidad.
- Encapsulamiento de nodos y control de invariantes.
- Validaciones de entrada y manejo de estados vacios.
- Metodos de apoyo para visualizacion y depuracion.
- Implementacion de estructuras **100% manual**, sin uso de `java.util.*`.
