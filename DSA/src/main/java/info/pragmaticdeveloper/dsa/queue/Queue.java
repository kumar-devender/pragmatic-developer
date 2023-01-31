package info.pragmaticdeveloper.dsa.queue;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("devender");
        queue.enqueue("kumar");
        queue.enqueue("yadav");
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        queue.enqueue("Astha");
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T t) {
        Node<T> node = new Node<>(t);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    public T peek() {
        return head.data;
    }

    public T dequeue() {
        T item = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return item;
    }

    private class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
