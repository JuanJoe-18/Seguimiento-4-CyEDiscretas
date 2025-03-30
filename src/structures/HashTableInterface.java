package structures;

public interface HashTableInterface<K, V> {
    void add(K clave, V valor);
    V get(K clave);
    void remove(K clave);


    int size();
    boolean isEmpty();
}
