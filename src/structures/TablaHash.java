package structures;

public class TablaHash<K, V> {
    private ListaEnlazada<NodoHash<K, V>>[] table;
    private int capacity;

    // Constructor de la tabla hash
    public TablaHash(int capacity) {
        this.capacity = capacity;
        table = new ListaEnlazada[capacity];
    }

    // El metodo hash
    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void add(K key, V value) {
        int index = hash(key); // Calcular el índice usando el método hash
        if (table[index] == null) {
            table[index] = new ListaEnlazada<>(); // Crear una nueva lista enlazada si no existe
        }
        table[index].add(new NodoHash<>(key, value)); // Agregar el nuevo nodo a la lista enlazada
    }

    // Método para obtener el valor asociado a una clave dada
    public V get(K key) {
        int index = hash(key);// Calcular el índice usando el método hash
        if (table[index] == null) {
            return null;
        }
        // Recorrer la lista enlazada para encontrar el nodo con la clave dada
        for (NodoHash<K, V> nodo : table[index].toList()) {
            if (nodo.key.equals(key)) {
                return nodo.value;
            }
        }
        return null;
    }
    // meotdo para limpiar la tabla hash
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
    }
}