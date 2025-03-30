package structures;
import java.util.*;

public class HashTable<K, V> implements HashTableInterface<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private final LinkedList<LinkedList<Entrada<K, V>>> buckets;
    private int size;

    public HashTable() {
        buckets = new LinkedList<>();
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets.add(new LinkedList<>());
        }
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entrada<K, V>> bucket = buckets.get(index);

        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets.set(index, bucket);
        }

        for (int i = 0; i < bucket.size(); i++) {
            Entrada<K, V> entry = bucket.get(i);
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entrada<>(key, value));
        size++;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entrada<K, V>> bucket = buckets.get(index);

        for (int i = 0; i < bucket.size(); i++) {
            Entrada<K, V> entry = bucket.get(i);
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entrada<K, V>> bucket = buckets.get(index);
        int initialSize = bucket.size();

        bucket.removeIf(entry -> entry.key.equals(key));

        if (bucket.size() < initialSize) {
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % INITIAL_CAPACITY);
    }

    private static class Entrada<K, V> {
        K key;
        V value;

        Entrada(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
