package structures;

import java.util.function.Predicate;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    public void removeIf(Predicate<? super T> filter) {
        Node<T> current = head;

        while (current != null) {
            Node<T> nextNode = current.next;

            if (filter.test(current.data)) {
                if (current == head) {
                    head = nextNode;
                    if (head == null) {
                        tail = null;
                    } else {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = nextNode;
                    nextNode.prev = current.prev;
                }
                size--;
            }
            current = nextNode;
        }
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

}