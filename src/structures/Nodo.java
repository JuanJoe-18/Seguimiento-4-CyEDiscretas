package structures;

class Nodo<T> {
    T data;
    Nodo<T> next;
    Nodo<T> prev;

    Nodo(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}