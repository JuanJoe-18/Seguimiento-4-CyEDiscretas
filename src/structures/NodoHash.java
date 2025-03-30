package  structures;

public class NodoHash<K, V> {
    K key;// Clave
    V value;// valor
    // Constructor
    public NodoHash(K key, V value) {
        this.key = key;
        this.value = value;
    }
}