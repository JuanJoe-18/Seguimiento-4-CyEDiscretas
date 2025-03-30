package structures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListaEnlazada<T> {
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size = 0;

    public ListaEnlazada() {
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Nodo<T> newNodo = new Nodo<>(data);

        if (head == null) {
            head = newNodo;
            tail = newNodo;
        } else {
            tail.next = newNodo;
            newNodo.prev = tail;
            tail = newNodo;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Nodo<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }


    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }



    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Nodo<T> current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }
}